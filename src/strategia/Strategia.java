package strategia;

import singleton.Słownik;
import singleton.Słowo;

import java.util.List;

public interface Strategia {
    //List<Słowo> wybierzSłowa(Słownik słownik);
    void wyświetlPytanie(int choose, boolean polski);
    Słowo pobierzSłowo(int choose);
}
