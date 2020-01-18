package dekorator;

import strategia.Strategia;

public class RozgrywkaSprawdzian implements Rozgrywka {
    int iloscPrawidlowychOdpowiedzi = 0;
    int iloscNieprawidlowychOdpowiedzi = 0;
//    List<pytaania> qwertyui;
    public void graj() {



    }

    public int zdobytePunkty() {
        return iloscPrawidlowychOdpowiedzi - iloscNieprawidlowychOdpowiedzi/2;
    }

    private Strategia strategia;

    public RozgrywkaSprawdzian(Strategia strategy) {
        this.strategia = strategy;
    }

    public void zmienStrategie(Strategia strategy) {
        this.strategia = strategy;
    }

    public void goToBattle() {
        //strategia.wybierzSłowa();
    }
}
