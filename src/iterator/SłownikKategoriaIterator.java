package iterator;

import singleton.Słownik;
import singleton.Słowo;
import singleton.SłowoKategoria;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SłownikKategoriaIterator implements Iterator<Słowo> {
    protected Słownik słownik;
    private int index;
    private List<SłowoKategoria> wybraneKategorie;

    public SłownikKategoriaIterator(Słownik słownik, List<SłowoKategoria> kategorie){
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
        int tempIdx = index;
        while (true) {
            tempIdx++;
            if (tempIdx >= słowa.size()) {
                tempIdx = -1;
                break;
            }
            if(wybraneKategorie.contains(słowa.get(tempIdx).getSłowoKategoria())){
                break;
            }
        }
        return tempIdx;
    }
}
//        implements Iterator<singleton.Słowo>{
//    //czy iterować po listaSłów, ale sprawdzać warunek później?
//    protected List<singleton.Słowo> listaSłówZKategorii = new ArrayList<singleton.Słowo>();
//    protected int index;
//
//    public iterator.SłownikKategoriaIterator(int kategoria){
//        index = 0;
//
//        singleton.Słownik słownik = singleton.Słownik.getInstance();
//        for (singleton.Słowo:słownik.listaSłów()) {
//            if(singleton.Słowo.getKategoriaSłowa().getCategoryAsInt()==kategoria){
//                listaSłówZKategorii.add(singleton.Słowo);
//            }
//        }
//    }
//
//    public int liczbaWyrazów(){return listaSłówZKategorii.size();}
//
//    @Override
//    public boolean hasNext() {
//
//        return index < liczbaWyrazów();
//    }
//
//    @Override
//    public singleton.Słowo next() {
//        return listaSłówZKategorii.get(index++);
//    }
//}