package singleton;

import iterator.SłownikIterator;
import iterator.IteratorTrudność;
import iterator.SłownikKategoriaIterator;

import java.util.*;

public final class Słownik{
//dodałem static by móc posiadać to w strategii
    private static Słownik instance = new Słownik();
    private List<Słowo> listaSłów;

    private Słownik() {
        //tutaj nasz słownik na twardo
        listaSłów = new ArrayList<Słowo>();
        listaSłów.add(new Słowo("kot","cat", SłowoKategoria.Zwierzęta, Trudność.BradzoŁatwy));
        listaSłów.add(new Słowo("pies","dog", SłowoKategoria.Zwierzęta, Trudność.BradzoŁatwy));
        listaSłów.add(new Słowo("bird","ptak", SłowoKategoria.Zwierzęta, Trudność.BradzoŁatwy));
    }
//dodałem static by móc posiadać to w strategii
    public static Słownik getInstance() {
        return instance;
    }

    /////////////////////////////////////////////////////////////////////////

    public IteratorTrudność CreateIterator(List<Trudność> tr) {
        return new IteratorTrudność(this, tr);
    }

    public List<Słowo> getAll() {
        return new ArrayList<>(listaSłów);
    }

    //////////////////////////////////////////////////////////////////////////

    void usuńSłowo(Słowo słowo){
        if(listaSłów.contains(słowo)) listaSłów.remove(słowo);
    }

    //////////////////////////////////////////////////////////////////////////

    public Iterator<Słowo> iterator(List<SłowoKategoria> kategorie){

        if(kategorie.isEmpty()){
            Iterator<Słowo> it = listaSłów.iterator();
            return it;
        }
        else{
            return new SłownikKategoriaIterator(this, kategorie);
        }
//        switch (kategoria) {
//            case 0: {
//                Iterator<Słowo> it = listaSłów.iterator();
//                return it; //new SłownikIterator();
//            }
//            case 1: {
//                return new iterator.SłownikKategoriaIterator(kategoria);
//            }
//
//            default: {
//                System.out.println("Nie wybrano opcji! Domyślny iterator.");
//                return new SłownikIterator();
//            }
//        }
    }


    public void wyswietlSlownik(){
        System.out.println();
        System.out.println("Słownik:");
        Słowo s;
        for(int i=1;i<=listaSłów.size();i++){
            s=listaSłów.get(i-1);
            System.out.println(i+" "+s.getPoPolsku()+" "+s.getPoAngielsku()+" "+s.getTrudnośćSłowa());
        }
    }

    public void usunSlowo(){

    }

    public void edytujSlowo(){

    }

    public void dodajSlowo(){

    }

}
