package dekorator;

import memento.Memento;
import singleton.Słowo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RozgrywkaSprawdzian extends Rozgrywka {

    int iloscPrawidlowychOdpowiedzi = 0;
    int iloscNieprawidlowychOdpowiedzi = 0;

    List<Słowo> pytania = new ArrayList<>();
    List<String> odpowiedzi = new ArrayList<>();

    int i = 0;

    public void graj() {
        List<Słowo> słowa = strategia.wybierzSłowa(słownik, kategorie);

        int ii = 0;
        for(int j=i+5; i<j; i++, ii++){
            Słowo słowoPytanie = słowa.get(ii);

            System.out.println();
            System.out.print(i+1 + ". Pytanie: ");
            System.out.println(słowoPytanie.getPytanie(polNaAng));
            pytania.add(słowoPytanie);

            strategia.wyświetlPodpowiedzi(ii, polNaAng);

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
