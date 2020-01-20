package dekorator;

import singleton.Słownik;
import singleton.Słowo;
import singleton.SłowoKategoria;
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

    public void graj() {
        List<Słowo> słowa = słownik.getAll();

        for(int i=0; i<5; i++){
            słowa = strategia.wybierzSłowa(słownik, kategorie);

            Random random = new Random();
            int randomInteger = random.nextInt(słowa.size());

            Słowo słowoPytanie = słowa.get(randomInteger);

            System.out.println(i + ". Pytanie: ");
            System.out.println(słowoPytanie.getPytanie(polNaAng));
            pytania.add(słowoPytanie);

            strategia.wyświetlPodpowiedzi(randomInteger, polNaAng);

            System.out.println("Twoja odpowiedz: ");

            Scanner scan = new Scanner(System.in);
            String odpowiedzGracza = scan.nextLine();
            odpowiedzi.add(odpowiedzGracza);

            if(odpowiedzGracza.equals(słowoPytanie.getPodpowiedz(polNaAng)))
                odpowiedzPrawidlowa();
            else
                odpowiedzNieprawidlowa();
        }

        System.out.println("Ilość prawidłowych odpowiedzi: "+iloscPrawidlowychOdpowiedzi);
    }

    public void odpowiedzPrawidlowa(){
        super.odpowiedzPrawidlowa();
        iloscPrawidlowychOdpowiedzi++;
    }

    public void odpowiedzNieprawidlowa(){
        super.odpowiedzNieprawidlowa();
        iloscNieprawidlowychOdpowiedzi++;
    }

    public int zdobytePunkty() {
        return iloscPrawidlowychOdpowiedzi - iloscNieprawidlowychOdpowiedzi/2;
    }
}
