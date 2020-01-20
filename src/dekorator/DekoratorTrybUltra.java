package dekorator;

import singleton.Słownik;
import singleton.SłowoKategoria;
import strategia.Strategia;

import java.util.List;

public class DekoratorTrybUltra extends DekoratorTryb {

    public DekoratorTrybUltra(Rozgrywka rozgrywka) {
        super(rozgrywka);
    }

    public void graj() {
        rozgrywka.graj();
    }

    public int zdobytePunkty() {
        return rozgrywka.zdobytePunkty()*2;
    }
}
