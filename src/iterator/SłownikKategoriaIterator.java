package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SłownikKategoriaIterator {}
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