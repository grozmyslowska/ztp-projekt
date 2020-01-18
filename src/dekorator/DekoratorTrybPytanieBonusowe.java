package dekorator;

public class DekoratorTrybPytanieBonusowe extends DekoratorTryb {
    public DekoratorTrybPytanieBonusowe(Rozgrywka rozgrywka){
        super(rozgrywka);
    }

    public void graj() {
        rozgrywka.graj();
        System.out.println("Hah ha! To był żart - nie ma żadnego pytania bonusowego .^.");
    }

    public int zdobytePunkty() {
        return rozgrywka.zdobytePunkty()+0;
    }
}
