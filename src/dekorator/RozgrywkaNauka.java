package dekorator;

import singleton.Słowo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RozgrywkaNauka extends Rozgrywka {

    int i=0;

    public void graj() {
        List<Słowo> słowa = new ArrayList<>();

        for(int j=i+5; i<j; i++) {
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

//            strategia.wyświetlPodpowiedzi(randomInteger, polNaAng);

            while (true){

                System.out.println("Twoja odpowiedz: ");

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
