package memento;// zawiera ustawienia (trudnosc oraz czy automatyczna) oraz osiagniecia gracza (ilosc punktow)

import singleton.Trudność;

public class Gracz {
    static int waga = 10;

    String name;
    int sumaPunktów;
    Trudność trudność;
    boolean trudnośćAutomatyczna;

    public Gracz(String name, int sumaPunktów, Trudność trudność, boolean trudnośćAutomatyczna) {
        this.name = name;
        this.sumaPunktów = sumaPunktów;
        this.trudność = trudność;
        this.trudnośćAutomatyczna = trudnośćAutomatyczna;
    }

    public void setTrudnośćAutomatyczna(boolean option){
        trudnośćAutomatyczna = option;
        if(option == true){
            switch (sumaPunktów / waga) {
                case 0:
                    trudność = Trudność.BradzoŁatwy;
                    break;
                case 1:
                    trudność = Trudność.Łatwy;
                    break;
                case 2:
                    trudność = Trudność.Trudny;
                    break;
                case 3:
                    trudność = Trudność.BardzoTrudny;
                    break;
                default:
                    trudność = Trudność.Ekspert;
                    break;
            }
        }
    }

    public void setTrudność(Trudność trudność){
        if(trudnośćAutomatyczna == false){
            this.trudność = trudność;
        }
    }

    public void setSumaPunktów(int punkty){
        sumaPunktów += punkty;
        if(sumaPunktów < 0) sumaPunktów = 0;
        if(trudnośćAutomatyczna == true){
            switch (sumaPunktów / waga) {
                case 0:
                    trudność = Trudność.BradzoŁatwy;
                    break;
                case 1:
                    trudność = Trudność.Łatwy;
                    break;
                case 2:
                    trudność = Trudność.Trudny;
                    break;
                case 3:
                    trudność = Trudność.BardzoTrudny;
                    break;
                default:
                    trudność = Trudność.Ekspert;
                    break;
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getSumaPunktów() {
        return sumaPunktów;
    }

    public Trudność getTrudność() {
        return trudność;
    }

    public boolean isTrudnośćAutomatyczna() {
        return trudnośćAutomatyczna;
    }

    private static class MementoGracza implements Memento {
        private Object stan[] = new Object[4];
        Memento setStan(String name, int sumaPunktów, Trudność trudność, boolean trudnośćAutomatyczna){
            stan[0]=name;
            stan[1]=sumaPunktów;
            stan[2]=trudność;
            stan[3]=trudnośćAutomatyczna;
            return this;
        }
        public Object getStan(){
            return stan;
        }
    }

    public Memento stworzMemento(){
        return new Gracz.MementoGracza().setStan(name, sumaPunktów, trudność, trudnośćAutomatyczna);
    }
    public void przywroc(Memento m){
        Object[] stan = (Object[]) ((Gracz.MementoGracza)m).getStan();
        name = (String) stan[0];
        sumaPunktów = (int) stan[1];
        trudność = (Trudność) stan[2];
        trudnośćAutomatyczna = (boolean) stan[3];
    }
}
