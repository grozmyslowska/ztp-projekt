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

    public void usunSlowo(Słowo słowo){
        listaSłów.remove(słowo);
    }

    public Słowo znajdzSlowo(String słowoPl){
        for(Słowo słowo : listaSłów){
            if(słowo.getPoPolsku().equals(słowoPl)){
                return słowo;
            }
        }
        return null;
    }

    public boolean edytujSlowo(Słowo doZmiany, Słowo nowe){
        for(Słowo słowo : listaSłów){
            if(słowo.getPoPolsku().equals(doZmiany.getPoPolsku())){
                słowo.setPoPolsku(nowe.getPoPolsku());
                słowo.setPoAngielsku(nowe.getPoAngielsku());
                słowo.setSłowoKategoria(nowe.getSłowoKategoria());
                słowo.setTrudnośćSłowa(nowe.getTrudnośćSłowa());
                return true;
            }
        }
        return false;
    }

    public boolean dodajSlowo(Słowo słowo){

        if(listaSłów.add(słowo)) return true;
        return false;
    }

    public List<Słowo> getAll() {
        return new ArrayList<>(listaSłów);
    }

}
