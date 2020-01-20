package singleton;

import iterator.SłownikKategoriaIterator;

import java.util.*;

public final class Słownik{
    private static Słownik instance = new Słownik();
    private List<Słowo> listaSłów;

    private Słownik() {
        listaSłów = new ArrayList<Słowo>();
        listaSłów.add(new Słowo("kot","cat", SłowoKategoria.Zwierzęta, Trudność.BradzoŁatwy));
        listaSłów.add(new Słowo("pies","dog", SłowoKategoria.Zwierzęta, Trudność.BradzoŁatwy));
        listaSłów.add(new Słowo("bird","ptak", SłowoKategoria.Zwierzęta, Trudność.BradzoŁatwy));
    }

    public static Słownik getInstance() {
        return instance;
    }

    public Iterator<Słowo> iterator(List<SłowoKategoria> kategorie){

        if(kategorie.isEmpty()){
            Iterator<Słowo> it = listaSłów.iterator();
            return it;
        }
        else{
            return new SłownikKategoriaIterator(this, kategorie);
        }
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

    public List<Słowo> getAll() {
        return new ArrayList<>(listaSłów);
    }

}
