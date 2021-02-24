package dekorator;

public class DekoratorTrybUltra extends DekoratorTryb {

    public DekoratorTrybUltra(Rozgrywka rozgrywka) {
        super(rozgrywka);
    }

    public int zdobytePunkty() {
        return rozgrywka.zdobytePunkty()*2;
    }
}
