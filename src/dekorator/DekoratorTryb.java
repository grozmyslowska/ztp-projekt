package dekorator;

import singleton.Słownik;
import singleton.Słowo;
import singleton.SłowoKategoria;
import strategia.Strategia;

import java.util.List;

public abstract class DekoratorTryb extends Rozgrywka {
    protected Rozgrywka rozgrywka;

    public DekoratorTryb(Słownik słownik, boolean polNaAng, Strategia strategia, List<SłowoKategoria> kategorie, Rozgrywka rozgrywka) {
        super(słownik, polNaAng, strategia, kategorie);
        this.rozgrywka = rozgrywka;
    }
}
