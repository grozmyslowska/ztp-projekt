package dekorator;

import singleton.Słownik;
import singleton.SłowoKategoria;
import strategia.Strategia;

import java.util.List;

public class DekoratorTrybUltra extends DekoratorTryb {

    public DekoratorTrybUltra(Słownik słownik, boolean polNaAng, Strategia strategia, List<SłowoKategoria> kategorie, Rozgrywka rozgrywka){
        super(słownik, polNaAng, strategia, kategorie, rozgrywka);
    }

    public void graj() {
        rozgrywka.graj();
    }

    public int zdobytePunkty() {
        return rozgrywka.zdobytePunkty()*2;
    }
}
