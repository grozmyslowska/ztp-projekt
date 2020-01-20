package dekorator;

import singleton.Słownik;
import singleton.Słowo;
import singleton.SłowoKategoria;
import strategia.Strategia;

import java.util.List;
import java.util.Scanner;

public abstract class Rozgrywka {
    Słownik słownik;
    List<Słowo> słowa;
    boolean polNaAng;
    Strategia strategia;
    List<SłowoKategoria> kategorie;

    public Rozgrywka(Słownik słownik, boolean polNaAng, Strategia strategia, List<SłowoKategoria> kategorie) {
        this.słownik = słownik;
        this.polNaAng = polNaAng;
        this.strategia = strategia;
        this.kategorie = kategorie;
    }

    void graj(){
    }

    int zdobytePunkty(){
        return 0;
    }

    public void odpowiedzPrawidlowa(){
    }

    public void odpowiedzNieprawidlowa(){
    }

    public void zmienStrategie(Strategia strategy) {
        this.strategia = strategy;
    }
}
