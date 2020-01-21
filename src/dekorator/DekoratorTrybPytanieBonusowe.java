package dekorator;

import singleton.Słownik;
import singleton.SłowoKategoria;
import strategia.Strategia;

import java.util.List;

public class DekoratorTrybPytanieBonusowe extends DekoratorTryb {

    public DekoratorTrybPytanieBonusowe(Rozgrywka rozgrywka) {
        super(rozgrywka);
    }

    public void graj() {
        System.out.println("ZACZYNAMY ZABAWE");
        rozgrywka.graj();
        System.out.println("JESTESMY W SRODKU");
        rozgrywka.graj();
        System.out.println("KONCZYMY ZABAWE");
    }

    public int zdobytePunkty() {
        return rozgrywka.zdobytePunkty();
    }
}
