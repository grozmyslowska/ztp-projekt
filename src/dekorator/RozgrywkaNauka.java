package dekorator;

import singleton.Słowo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RozgrywkaNauka extends Rozgrywka {

    int i=0;

    public void graj() {
        List<Słowo> słowa = strategia.wybierzSłowa(słownik, kategorie);

        for(int j=i+5; i<j; i++) {
            Słowo słowoPytanie = słowa.get(i);

            System.out.println();
            System.out.print(i+1 + ". Pytanie: ");
            System.out.println(słowoPytanie.getPytanie(polNaAng));

            strategia.wyświetlPodpowiedzi(i,polNaAng);

            while (true){

                System.out.print("Twoja odpowiedz: ");

                Scanner scan = new Scanner(System.in);
                String odpowiedzGracza = scan.nextLine();

                if (odpowiedzGracza.equalsIgnoreCase(słowoPytanie.getPodpowiedz(polNaAng))){
                    odpowiedzPrawidlowa();
                    break;
                } else
                    odpowiedzNieprawidlowa();
            }
        }
    }

    public void odpowiedzPrawidlowa(){
        super.odpowiedzPrawidlowa();
        System.out.println("Gratulacje!");
    }
    public void odpowiedzNieprawidlowa(){
        super.odpowiedzNieprawidlowa();
        System.out.println("Podana odpowiedź jest niepoprawna.");
    }

    public int zdobytePunkty() {
        return 0;
    }
}
