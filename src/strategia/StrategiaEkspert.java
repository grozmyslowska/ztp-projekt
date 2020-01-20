package strategia;

import java.util.*;

import singleton.Słownik;
import singleton.Słowo;
import singleton.SłowoKategoria;
import singleton.Trudność;

public class StrategiaEkspert implements Strategia {
    Iterator<Słowo> iterator;
    List<Słowo> listaPytań;

    @Override
    public List<Słowo> wybierzSłowa(Słownik słownik, List<SłowoKategoria> kategorie) {
        iterator = słownik.iterator(kategorie);

        listaPytań = losujPytania();

        return listaPytań;
    }

    @Override
    public void wyświetlPodpowiedzi(int choose, boolean polski) {

    }

    private ArrayList<Słowo> losujPytania(){
        ArrayList<Słowo> pytania = new ArrayList<Słowo>();
        pytania.add(losujSłowo(Trudność.Łatwy));
        pytania.add(losujSłowo(Trudność.BradzoŁatwy));
        pytania.add(losujSłowo(Trudność.Łatwy));
        pytania.add(losujSłowo(Trudność.Łatwy));
        pytania.add(losujSłowo(Trudność.BradzoŁatwy));

        return pytania;
    }

    private Słowo losujSłowo(Trudność trudność){
        Słowo słowo=null;
        Random r = new Random();
        int rand = r.nextInt(5);

        for( ;rand>0; rand-- ){
            int wykonaniePętli = 0;
            while (iterator.hasNext()){
                słowo = iterator.next();
                if(słowo.getSłowoKategoria().equals(trudność)) break;
                wykonaniePętli++;
                if(wykonaniePętli>100) return new Słowo("Brak takiego słowa", "This word don't exist", SłowoKategoria.Zwierzęta, trudność);
            }
        }
        return słowo;
    }

}
