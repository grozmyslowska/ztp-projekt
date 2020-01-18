package dekorator;

import singleton.Słownik;
import singleton.Słowo;
import strategia.Strategia;

import java.util.List;

public abstract class DekoratorTryb extends Rozgrywka {
    protected Rozgrywka rozgrywka;

    public DekoratorTryb(Słownik słownik, boolean polNaAng, Strategia strategia, Rozgrywka rozgrywka) {
        super(słownik, polNaAng, strategia);
        this.rozgrywka = rozgrywka;
    }
}
