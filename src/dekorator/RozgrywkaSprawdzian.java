package dekorator;

import singleton.Słowo;

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

    transient int i = 0;

    public void graj() {
        List<Słowo> słowa = strategia.wybierzSłowa(słownik, kategorie);

        for(int j=i+5; i<j; i++){
            Słowo słowoPytanie = słowa.get(i);

            System.out.println();
            System.out.print(i+1 + ". Pytanie: ");
            System.out.println(słowoPytanie.getPytanie(polNaAng));
            pytania.add(słowoPytanie);

            strategia.wyświetlPodpowiedzi(i, polNaAng);

            System.out.print("Twoja odpowiedz: ");

            Scanner scan = new Scanner(System.in);
            String odpowiedzGracza = scan.nextLine();
            odpowiedzi.add(odpowiedzGracza);

            if(odpowiedzGracza.equalsIgnoreCase(słowoPytanie.getPodpowiedz(polNaAng)))
                odpowiedzPrawidlowa();
            else
                odpowiedzNieprawidlowa();
        }

        System.out.println();
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
