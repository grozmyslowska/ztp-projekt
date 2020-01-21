package dekorator;

public class DekoratorTrybUltra extends DekoratorTryb {

    public DekoratorTrybUltra(Rozgrywka rozgrywka) {
        super(rozgrywka);
    }

    public void graj() {
        rozgrywka.graj();
    }

    public int zdobytePunkty() {
        return rozgrywka.zdobytePunkty()*2;
    }
}
