package dekorator;

import singleton.Słownik;
import singleton.Słowo;
import strategia.Strategia;

import java.io.Serializable;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RozgrywkaSprawdzian extends Rozgrywka implements Serializable {
    transient int iloscPrawidlowychOdpowiedzi = 0;
    transient int iloscNieprawidlowychOdpowiedzi = 0;

    List<Słowo> pytania;
    List<String> odpowiedzi;

    public RozgrywkaSprawdzian(Słownik słownik, boolean polNaAng, Strategia strategia) {
        super(słownik, polNaAng, strategia);
    }

    public void graj() {

        for(int i=0; i<5; i++){
            słowa = strategia.wybierzSłowa(słownik);

            Random random = new Random();
            int randomInteger = random.nextInt(słowa.size());
            Słowo słowoPytanie = słowa.get(randomInteger);

            System.out.println(i + ". Pytanie: ");
            System.out.println(słowoPytanie.getPytanie(polNaAng));
            pytania.add(słowoPytanie);

            if(słowa.size()>1) {
                System.out.println("Podpowiedzi: ");

                for (Słowo s : słowa) {
                    System.out.println(s.getPodpowiedz(polNaAng));
                }
            }

            System.out.println("Twoja odpowiedz: ");

            Scanner scan = new Scanner(System.in);
            String odpowiedzGracza = scan.nextLine();
            odpowiedzi.add(odpowiedzGracza);

            if(odpowiedzGracza == słowoPytanie.getPodpowiedz(polNaAng))
                iloscPrawidlowychOdpowiedzi++;
            else
                iloscNieprawidlowychOdpowiedzi++;
        }

        System.out.println("Ilość prawidłowych odpowiedzi: "+iloscPrawidlowychOdpowiedzi);
    }



    public int zdobytePunkty() {
        return iloscPrawidlowychOdpowiedzi - iloscNieprawidlowychOdpowiedzi/2;
    }
}
