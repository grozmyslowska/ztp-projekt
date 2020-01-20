package dekorator;

import singleton.Słownik;
import singleton.Słowo;
import singleton.SłowoKategoria;
import strategia.Strategia;

import java.util.List;

public abstract class DekoratorTryb extends Rozgrywka {
    protected Rozgrywka rozgrywka;

    public DekoratorTryb(Rozgrywka rozgrywka) {
        this.rozgrywka = rozgrywka;
    }
}
