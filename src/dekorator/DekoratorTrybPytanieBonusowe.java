package dekorator;

import singleton.Słownik;
import singleton.SłowoKategoria;
import strategia.Strategia;

import java.util.List;

public class DekoratorTrybPytanieBonusowe extends DekoratorTryb {

    public DekoratorTrybPytanieBonusowe(Rozgrywka rozgrywka) {
        super(rozgrywka);
    }

    public void graj() {
        rozgrywka.graj();
        rozgrywka.graj();
    }

    public int zdobytePunkty() {
        return rozgrywka.zdobytePunkty();
    }
}
