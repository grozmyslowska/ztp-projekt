package strategia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import singleton.Słownik;
import singleton.Słowo;
import singleton.SłowoKategoria;
import singleton.Trudność;

public class StrategiaŁatwy implements Strategia {
    Słownik słownik;
    Iterator<Słowo> iterator;
    List<Słowo> listaPytań;// = new ArrayList<Słowo>();

//    public List<Słowo> wybierzSłowa(Słownik słownik) {
//        return null;
//    }
    public StrategiaŁatwy(List<SłowoKategoria> kategorie){
        słownik = Słownik.getInstance();
        iterator = słownik.iterator(kategorie);
        //listaPytań = losujPytania();
        listaPytań = new ArrayList<Słowo>();
        listaPytań.add(losujSłowo(Trudność.Łatwy));
        listaPytań.add(losujSłowo(Trudność.BradzoŁatwy));
        listaPytań.add(losujSłowo(Trudność.Łatwy));
        listaPytań.add(losujSłowo(Trudność.Łatwy));
        listaPytań.add(losujSłowo(Trudność.BradzoŁatwy));
    }

    @Override
    public void wyświetlPytanie(int choose, boolean polski) {
        Random r = new Random();
        int rand = r.nextInt(5);
        if(polski){
            System.out.println(choose+" pytanie: "+listaPytań.get(choose).getPoPolsku()+" oznacza: ");
            System.out.println("a) "+listaPytań.get(choose).getPoAngielsku()+".");
            System.out.println("b) "+listaPytań.get(rand).getPoAngielsku()+".");
        }
        else{
            System.out.println(choose+" pytanie: "+listaPytań.get(choose).getPoAngielsku()+" oznacza: ");
            System.out.println("a) "+listaPytań.get(choose).getPoPolsku()+".");
            System.out.println("b) "+listaPytań.get(rand).getPoPolsku()+".");
        }
    }

    @Override
    public Słowo pobierzSłowo(int choose) {
        return listaPytań.get(choose);
    }

//    private ArrayList<Słowo> losujPytania(){
//        List<Słowo> pytania = new ArrayList<Słowo>();
//        pytania.add(losujSłowo(Trudność.Łatwy));
//        pytania.add(losujSłowo(Trudność.BradzoŁatwy));
//        pytania.add(losujSłowo(Trudność.Łatwy));
//        pytania.add(losujSłowo(Trudność.Łatwy));
//        pytania.add(losujSłowo(Trudność.BradzoŁatwy));
//
//        return pytania;
//    }

    private Słowo losujSłowo(Trudność trudność){
        Słowo słowo=null;
        Random r = new Random();
        int rand = r.nextInt(10);

        for( ;rand>0; rand-- ){
            int wykonaniePętli = 0;
            while (iterator.hasNext()){
                słowo = iterator.next();
                wykonaniePętli++;
                if(wykonaniePętli>słownik.getAll().size()) return null;
            }
        }
        return słowo;
    }
}
