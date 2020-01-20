package dekorator;

import singleton.Słownik;
import singleton.SłowoKategoria;
import strategia.Strategia;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.List;

public class DekoratorDzwieki extends DekoratorTryb {

    Clip clip;

    public DekoratorDzwieki(Słownik słownik, boolean polNaAng, Strategia strategia, List<SłowoKategoria> kategorie, Rozgrywka rozgrywka) {
        super(słownik, polNaAng, strategia, kategorie, rozgrywka);
    }

    public void odpowiedzPrawidlowa(){
        rozgrywka.odpowiedzPrawidlowa();
        dzwiek(".//res//OK.wav");
    }

    public void odpowiedzNieprawidlowa(){
        rozgrywka.odpowiedzNieprawidlowa();
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
