package iterator;

import singleton.Słownik;
import singleton.Słowo;
import singleton.Trudność;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class IteratorTrudność implements Iterator<Słowo> {

    private Słownik słownik;
    private int idx;
    private List<Trudność> trudnośćLista;

    public IteratorTrudność(Słownik słownik, List<Trudność> trudnośćLista) {
        this.słownik = słownik;
        this.idx = -1;
        this.trudnośćLista = trudnośćLista;
    }

    @Override
    public boolean hasNext() {
        return findNextIdx() != -1;
    }

    @Override
    public Słowo next() {
        idx = findNextIdx();
        if (idx != -1) {
            return słownik.getAll().get(idx);
        }
        return null;
    }

    private int findNextIdx() {
        List<Słowo> słowa = słownik.getAll();
        int tempIdx = idx;
        while (true) {
            tempIdx++;
            if (tempIdx >= słowa.size()) {
                tempIdx = -1;
                break;
            }
            if(trudnośćLista.contains(słowa.get(tempIdx).getTrudnośćSłowa())){
                break;
            }
        }
        return tempIdx;
    }

}
