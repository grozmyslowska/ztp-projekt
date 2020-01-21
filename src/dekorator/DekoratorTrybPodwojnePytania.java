package dekorator;

public class DekoratorTrybPodwojnePytania extends DekoratorTryb {

    public DekoratorTrybPodwojnePytania(Rozgrywka rozgrywka) {
        super(rozgrywka);
    }

    public void graj() {
        rozgrywka.graj();
        rozgrywka.graj();
    }

    public int zdobytePunkty() {
        return rozgrywka.zdobytePunkty();
    }
}
