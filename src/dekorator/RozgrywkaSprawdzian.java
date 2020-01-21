package dekorator;

import singleton.Słownik;
import singleton.Słowo;
import singleton.SłowoKategoria;
import strategia.Strategia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RozgrywkaSprawdzian extends Rozgrywka implements Serializable {

    transient int iloscPrawidlowychOdpowiedzi = 0;
    transient int iloscNieprawidlowychOdpowiedzi = 0;

    List<Słowo> pytania = new ArrayList<>();
    List<String> odpowiedzi = new ArrayList<>();

    int i = 0;

    public void graj() {
        List<Słowo> słowa = słownik.getAll();

        for(int j=i+5; i<j; i++){
//            słowa = strategia.wybierzSłowa(słownik, kategorie);

            słowa.add(słownik.getAll().get(0));
            słowa.add(słownik.getAll().get(1));
            słowa.add(słownik.getAll().get(2));
            słowa.add(słownik.getAll().get(3));
            słowa.add(słownik.getAll().get(4));

            Random random = new Random();
            int randomInteger = random.nextInt(słowa.size());

            Słowo słowoPytanie = słowa.get(randomInteger);

            System.out.println(i+1 + ". Pytanie: ");
            System.out.println(słowoPytanie.getPytanie(polNaAng));
            pytania.add(słowoPytanie);

//            strategia.wyświetlPodpowiedzi(randomInteger, polNaAng);

            System.out.println("Twoja odpowiedz: ");

            Scanner scan = new Scanner(System.in);
            String odpowiedzGracza = scan.nextLine();
            odpowiedzi.add(odpowiedzGracza);

            if(odpowiedzGracza.equalsIgnoreCase(słowoPytanie.getPodpowiedz(polNaAng)))
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
