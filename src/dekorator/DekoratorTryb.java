package dekorator;

public abstract class DekoratorTryb extends Rozgrywka {
    protected Rozgrywka rozgrywka;

    public DekoratorTryb(Rozgrywka rozgrywka) {
        this.rozgrywka = rozgrywka;
    }
}
