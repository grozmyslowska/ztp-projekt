package dekorator;

public abstract class DekoratorTryb implements Rozgrywka {
    protected Rozgrywka rozgrywka;

    public DekoratorTryb(Rozgrywka rozgrywka) {
        this.rozgrywka = rozgrywka;
    }
}
