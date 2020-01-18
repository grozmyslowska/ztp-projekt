package singleton;

public enum SłowoKategoria {
    IT(1),
    Zwierzęta(2),
    Kolowkwium1_Lektorat(3),
    Kolory(4);

    private final int kategoria;

    SłowoKategoria(int kategoria){
        this.kategoria=kategoria;
    }

    public int getCategoryAsInt() {
        return kategoria;
    }

//    public int getCategoryAsString() {
//        return String.valueOf(kategoria);
//    }

}
