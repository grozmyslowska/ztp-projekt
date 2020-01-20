package dekorator;

import singleton.Słownik;
import singleton.Słowo;
import singleton.SłowoKategoria;
import strategia.Strategia;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RozgrywkaNauka extends Rozgrywka {

    public RozgrywkaNauka(Słownik słownik, boolean polNaAng, Strategia strategia, List<SłowoKategoria> kategorie) {
        super(słownik, polNaAng, strategia, kategorie);
    }

    public void graj() {

        for(int i=0; i<5; i++) {
            słowa = strategia.wybierzSłowa(słownik, kategorie);

            Random random = new Random();
            int randomInteger = random.nextInt(słowa.size());
            Słowo słowoPytanie = słowa.get(randomInteger);

            System.out.println(i + ". Pytanie: ");
            System.out.println(słowoPytanie.getPytanie(polNaAng));

            strategia.wyświetlPodpowiedzi(randomInteger, polNaAng);

            while (1 == 1){

                System.out.println("Twoja odpowiedz: ");

                Scanner scan = new Scanner(System.in);
                String odpowiedzGracza = scan.nextLine();

                if (odpowiedzGracza == słowoPytanie.getPodpowiedz(polNaAng)){
                    System.out.println("Gratulacje!");
                    break;
                } else
                    System.out.println("Podana odpowiedź jest niepoprawna.");
            }
        }
    }
    public int zdobytePunkty() {
        return 0;
    }
}
