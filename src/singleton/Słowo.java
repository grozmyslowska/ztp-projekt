package singleton;

public class Słowo {
    String poPolsku;
    String poAngielsku;
    //SłowoKategoria słowoKategoria;
    Trudność trudność;

    public Słowo() {
    }

    public Słowo(String poPolsku, String poAngielsku, /*SłowoKategoria słowoKategoria,*/ Trudność trudność) {
        this.poPolsku = poPolsku;
        this.poAngielsku = poAngielsku;
        //this.słowoKategoria = słowoKategoria;
        this.trudność = trudność;
    }

    public String getPoPolsku() {
        return poPolsku;
    }

    public void setPoPolsku(String poPolsku) {
        this.poPolsku = poPolsku;
    }

    public String getPoAngielsku() {
        return poAngielsku;
    }

    public void setPoAngielsku(String poAngielsku) {
        this.poAngielsku = poAngielsku;
    }

//    public SłowoKategoria getSłowoKategoria() {
//        return słowoKategoria;
//    }
//
//    public void setSłowoKategoria(SłowoKategoria słowoKategoria) {
//        this.słowoKategoria = słowoKategoria;
//    }

    public Trudność getTrudnośćSłowa() {
        return trudność;
    }

    public void setTrudnośćSłowa(Trudność trudność) {
        this.trudność = trudność;
    }
}
