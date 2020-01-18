// zawiera ustawienia (trudnosc oraz czy automatyczna) oraz osiagniecia gracza (ilosc punktow)

import singleton.Trudność;

public class Gracz {
    static int waga = 10;

    String name;
    int sumaPunktów;
    Trudność trudność;
    boolean trudnośćAutomatyczna;

    public Gracz(String name) {
        this.name = name;
        this.sumaPunktów = 0;
        this.trudność = Trudność.BradzoŁatwy;
        this.trudnośćAutomatyczna = true;
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
}
