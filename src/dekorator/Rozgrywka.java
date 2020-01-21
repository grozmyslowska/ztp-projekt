package dekorator;

import singleton.Słownik;
import singleton.SłowoKategoria;
import strategia.Strategia;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.List;

public abstract class Rozgrywka {
    Słownik słownik;
    boolean polNaAng;
    Strategia strategia;
    List<SłowoKategoria> kategorie;

    Clip clip;

    public void setSłownik(Słownik słownik) {
        this.słownik = słownik;
    }

//    public void setSłowa(List<Słowo> słowa) {
//        this.słowa = słowa;
//    }

    public void setPolNaAng(boolean polNaAng) {
        this.polNaAng = polNaAng;
    }

    public void setStrategia(Strategia strategia) {
        this.strategia = strategia;
    }

    public void setKategorie(List<SłowoKategoria> kategorie) {
        this.kategorie = kategorie;
    }

    public void graj(){
    }

    public int zdobytePunkty(){
        return 0;
    }

    public void zmienStrategie(Strategia strategy) {
        this.strategia = strategy;
    }

    public void odpowiedzPrawidlowa(){
        dzwiek(".//res//OK.wav");
    }

    public void odpowiedzNieprawidlowa(){
        dzwiek(".//res//Error.wav");
    }

    void dzwiek(String adresPliku){
        try{
            File file = new File(adresPliku);
            AudioInputStream sound = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(sound);
        }
        catch(Exception e){
        }
        clip.setFramePosition(0);
        clip.start();
    }
}
