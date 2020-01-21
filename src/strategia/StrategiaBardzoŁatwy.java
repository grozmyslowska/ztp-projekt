package strategia;

import java.util.*;

import singleton.Słownik;
import singleton.Słowo;
import singleton.SłowoKategoria;
import singleton.Trudność;

public class StrategiaBardzoŁatwy implements Strategia {
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
        var kolejność = losujKolejnośćPodpowiedzi(choose);

        if(polski){
            System.out.println("-"+listaPytań.get(kolejność[0]).getPoAngielsku());
            System.out.println("-"+listaPytań.get(kolejność[1]).getPoAngielsku());
        }
        else{
            System.out.println("-"+listaPytań.get(kolejność[0]).getPoPolsku()+".");
            System.out.println("-"+listaPytań.get(kolejność[1]).getPoPolsku()+".");
        }
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
            ind = losujSłowo(Trudność.Łatwy, wszystkieSłowaZkategorii);
            if(ind==-1)break;
        }while(wystąpienia[ind]);
        if(ind!=-1){
            wystąpienia[ind]=true;
            pytania.add(wszystkieSłowaZkategorii.get(ind));
        }
        else pytania.add(new Słowo("Brak tej trudności", "that don't exist", SłowoKategoria.Zwierzęta, Trudność.Łatwy));
        do{
            ind = losujSłowo(Trudność.BradzoŁatwy, wszystkieSłowaZkategorii);
            if(ind==-1)break;
        }while(wystąpienia[ind]);
        if(ind!=-1){
            wystąpienia[ind]=true;
            pytania.add(wszystkieSłowaZkategorii.get(ind));
        }
        else pytania.add(new Słowo("Brak tej trudności", "that don't exist", SłowoKategoria.Zwierzęta, Trudność.Łatwy));
        do{
            ind = losujSłowo(Trudność.BradzoŁatwy, wszystkieSłowaZkategorii);
            if(ind==-1)break;
        }while(wystąpienia[ind]);
        if(ind!=-1){
            wystąpienia[ind]=true;
            pytania.add(wszystkieSłowaZkategorii.get(ind));
        }
        else pytania.add(new Słowo("Brak tej trudności", "that don't exist", SłowoKategoria.Zwierzęta, Trudność.Łatwy));
        do{
            ind = losujSłowo(Trudność.Łatwy, wszystkieSłowaZkategorii);
            if(ind==-1)break;
        }while(wystąpienia[ind]);
        if(ind!=-1){
            wystąpienia[ind]=true;
            pytania.add(wszystkieSłowaZkategorii.get(ind));
        }
        else pytania.add(new Słowo("Brak tej trudności", "that don't exist", SłowoKategoria.Zwierzęta, Trudność.Łatwy));
        do{
            ind = losujSłowo(Trudność.BradzoŁatwy, wszystkieSłowaZkategorii);
            if(ind==-1)break;
        }while(wystąpienia[ind]);
        if(ind!=-1){
            wystąpienia[ind]=true;
            pytania.add(wszystkieSłowaZkategorii.get(ind));
        }
        else pytania.add(new Słowo("Brak tej trudności", "that don't exist", SłowoKategoria.Zwierzęta, Trudność.Łatwy));

        return pytania;
    }

    private int[] losujKolejnośćPodpowiedzi(int correctAnswer){
        var table = new int[2];

        Random r = new Random();
        table[0] = correctAnswer;

        for (int i=1;i<table.length; i++){
            int rand = r.nextInt(5);
            while(Arrays.asList(table).indexOf(rand)>=0){
                rand = r.nextInt(5);
            }
            table[i]=rand;
        }

        int rand = r.nextInt(table.length);

        table[0]=table[rand];
        table[rand]=correctAnswer;

        return table;
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
