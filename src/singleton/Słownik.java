package singleton;

import iterator.SłownikIterator;
import iterator.IteratorTrudność;

import java.util.*;

public final class Słownik{

    private static Słownik instance = new Słownik();
    private List<Słowo> listaSłów;

    private Słownik() {
        //tutaj nasz słownik na twardo
        listaSłów = new ArrayList<Słowo>();
        listaSłów.add(new Słowo("kot","cat", /*SłowoKategoria.Zwierzęta,*/ Trudność.BradzoŁatwy));
        listaSłów.add(new Słowo("pies","dog", /*SłowoKategoria.Zwierzęta,*/ Trudność.BradzoŁatwy));
        listaSłów.add(new Słowo("bird","ptak", /*SłowoKategoria.Zwierzęta,*/ Trudność.BradzoŁatwy));
    }

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

    void dodajSłowo(Słowo słowo){
        listaSłów.add(słowo);
    }

    void edytujSłowo(Słowo słowo, Słowo słowoEdytowane){
        for (Słowo s : listaSłów){
            if(s == słowo){
                s = słowoEdytowane;
                break;
            }
        }
    }

    void usuńSłowo(Słowo słowo){
        if(listaSłów.contains(słowo)) listaSłów.remove(słowo);
    }

    //////////////////////////////////////////////////////////////////////////

    public Iterator<Słowo> iterator(int kategoria){

        switch (kategoria) {
            case 0: {
                return new SłownikIterator();
            }
            case 1: {
                return null; //new iterator.SłownikKategoriaIterator(kategoria);
            }

            default: {
                System.out.println("Nie wybrano opcji! Domyślny iterator.");
                return new SłownikIterator();
            }
        }
    }

}
