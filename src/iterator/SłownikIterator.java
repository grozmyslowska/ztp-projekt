package iterator;
import singleton.Słowo;

import java.util.Iterator;
import java.util.function.Consumer;

public class SłownikIterator implements Iterator<Słowo>{
    public boolean hasNext() {
        return false;
    }

    public Słowo next() {
        return null;
    }

    public void remove() {

    }

    public void forEachRemaining(Consumer<? super Słowo> action) {

    }
//    protected Słownik słownik = Słownik.getInstance();
//    protected int index;
//
//    public SłownikIterator(){
//        index = 0;
//    }
//
//    public int liczbaWyrazów(){return słownik.listaSłów.size();}
//
//    @Override
//    public boolean hasNext() {
//
//        return index < liczbaWyrazów();
//    }
//
//    @Override
//    public Słowo next() {
//        return słownik.listaSłów.get(index++);
//    }
}