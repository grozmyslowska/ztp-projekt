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

        ArrayList<Słowo> wszystkieSłowaZkategorii = new ArrayList<Słowo>();
        while (iterator.hasNext()) {
            Słowo słowo = iterator.next();
            wszystkieSłowaZkategorii.add(słowo);
        }
        boolean[] wystąpienia= new boolean[wszystkieSłowaZkategorii.size()];
        int ind;

        do{
            ind = losujSłowo(Trudność.Trudny, wszystkieSłowaZkategorii);
            if(ind==-1)break;
        }while(wystąpienia[ind]);
        if(ind!=-1){
            wystąpienia[ind]=true;
            pytania.add(wszystkieSłowaZkategorii.get(ind));
        }
        else pytania.add(new Słowo("Brak tej trudności", "that don't exist", SłowoKategoria.Zwierzęta, Trudność.Łatwy));
        do{
            ind = losujSłowo(Trudność.Ekspert, wszystkieSłowaZkategorii);
            if(ind==-1)break;
        }while(wystąpienia[ind]);
        if(ind!=-1){
            wystąpienia[ind]=true;
            pytania.add(wszystkieSłowaZkategorii.get(ind));
        }
        else pytania.add(new Słowo("Brak tej trudności", "that don't exist", SłowoKategoria.Zwierzęta, Trudność.Łatwy));
        do{
            ind = losujSłowo(Trudność.BardzoTrudny, wszystkieSłowaZkategorii);
            if(ind==-1)break;
        }while(wystąpienia[ind]);
        if(ind!=-1){
            wystąpienia[ind]=true;
            pytania.add(wszystkieSłowaZkategorii.get(ind));
        }
        else pytania.add(new Słowo("Brak tej trudności", "that don't exist", SłowoKategoria.Zwierzęta, Trudność.Łatwy));
        do{
            ind = losujSłowo(Trudność.BardzoTrudny, wszystkieSłowaZkategorii);
            if(ind==-1)break;
        }while(wystąpienia[ind]);
        if(ind!=-1){
            wystąpienia[ind]=true;
            pytania.add(wszystkieSłowaZkategorii.get(ind));
        }
        else pytania.add(new Słowo("Brak tej trudności", "that don't exist", SłowoKategoria.Zwierzęta, Trudność.Łatwy));
        do{
            ind = losujSłowo(Trudność.Ekspert, wszystkieSłowaZkategorii);
            if(ind==-1)break;
        }while(wystąpienia[ind]);
        if(ind!=-1){
            wystąpienia[ind]=true;
            pytania.add(wszystkieSłowaZkategorii.get(ind));
        }
        else pytania.add(new Słowo("Brak tej trudności", "that don't exist", SłowoKategoria.Zwierzęta, Trudność.Łatwy));

        return pytania;
    }

    private int losujSłowo(Trudność trudność, ArrayList<Słowo> lista){
        Słowo słowo=null;
        Random r = new Random();
        int iloscSłówZOdpowiedniąTrudnością=0;
        for(Słowo element: lista){
            if(element.getTrudnośćSłowa().equals(trudność)) iloscSłówZOdpowiedniąTrudnością++;
        }
        if(iloscSłówZOdpowiedniąTrudnością==0) return -1;
        int rand = r.nextInt(iloscSłówZOdpowiedniąTrudnością);
        int i=0;

        do{
            if(lista.get(i).getTrudnośćSłowa().equals(trudność)) rand--;
            if(rand==-1) return i;
            i++;
        }while(rand>=0&&i<lista.size());

        return -1;
    }

}
