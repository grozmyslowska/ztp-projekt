package dekorator;

import singleton.Słownik;
import singleton.Słowo;
import strategia.Strategia;

import java.util.List;

public class RozgrywkaNauka implements Rozgrywka {
    private Strategia strategia;
    boolean PolNaAng;

    public void graj() {

        for(int i = 0; i < 5; i++) {
//            List<Słowo> podpowiedzi = strategia.wybierzSłowa(Słownik.getInstance(), PolNaAng);
//            Słowo pytanie = podpowiedzi.get(0);
//
//            //System.out.println(pytanie.poPolsku);
//
//            //wyświetlić losową kolejność
//            for (Słowo s : podpowiedzi);
                //System.out.println(s.poAngielsku);

            //pobierz odpowiedź

            //zweryfikuj poprawność odpowiedzi

            //idź dalej lub wróć do punktu: pobierz odpowiedź
        }
    }
    public int zdobytePunkty() {
        return 0;
    }
}
