package strategia;

import singleton.Słownik;
import singleton.Słowo;
import singleton.SłowoKategoria;
import singleton.Trudność;

import java.util.*;

public class StrategiaBardzoTrudny implements Strategia {
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
            System.out.println("-"+listaPytań.get(kolejność[2]).getPoAngielsku());
            System.out.println("-"+listaPytań.get(kolejność[3]).getPoAngielsku());
            System.out.println("-"+listaPytań.get(kolejność[4]).getPoAngielsku());
        }
        else{
            System.out.println("-"+listaPytań.get(kolejność[0]).getPoPolsku()+".");
            System.out.println("-"+listaPytań.get(kolejność[1]).getPoPolsku()+".");
            System.out.println("-"+listaPytań.get(kolejność[2]).getPoPolsku()+".");
            System.out.println("-"+listaPytań.get(kolejność[3]).getPoPolsku()+".");
            System.out.println("-"+listaPytań.get(kolejność[4]).getPoPolsku()+".");
        }
    }

    private ArrayList<Słowo> losujPytania(){
        ArrayList<Słowo> pytania = new ArrayList<Słowo>();
        pytania.add(losujSłowo(Trudność.BardzoTrudny));
        pytania.add(losujSłowo(Trudność.Trudny));
        pytania.add(losujSłowo(Trudność.BardzoTrudny));
        pytania.add(losujSłowo(Trudność.Ekspert));
        pytania.add(losujSłowo(Trudność.Ekspert));

        return pytania;
    }

    private int[] losujKolejnośćPodpowiedzi(int correctAnswer){
        var table = new int[5];

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
