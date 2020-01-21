package iterator;

import singleton.Słownik;
import singleton.Słowo;
import singleton.SłowoKategoria;
import java.util.Iterator;
import java.util.List;

public class SłownikIterator implements Iterator<Słowo> {
    protected Słownik słownik;
    private int index;
    private List<SłowoKategoria> wybraneKategorie;

    public SłownikIterator(Słownik słownik, List<SłowoKategoria> kategorie){
        index = -1;
        this.słownik=słownik;
        wybraneKategorie=kategorie;
    }

    @Override
    public boolean hasNext() {
        return findNextIndex() != -1;
    }

    @Override
    public Słowo next() {
        index = findNextIndex();
        if (index != -1) {
            return słownik.getAll().get(index);
        }
        return null;
    }

    private int findNextIndex() {
        List<Słowo> słowa = słownik.getAll();
        int temporaryIndex = index;
        while (true) {
            temporaryIndex++;
            if (temporaryIndex >= słowa.size()) {
                temporaryIndex = -1;
                break;
            }
            if(wybraneKategorie.contains(słowa.get(temporaryIndex).getSłowoKategoria())){
                break;
            }
        }
        return temporaryIndex;
    }
}