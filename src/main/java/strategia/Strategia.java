package strategia;

import singleton.Słownik;
import singleton.Słowo;
import singleton.SłowoKategoria;

import java.util.List;

public interface Strategia {
    List<Słowo> wybierzSłowa(Słownik słownik, List<SłowoKategoria> kategorie);
    void wyświetlPodpowiedzi(int choose, boolean polski);
}
