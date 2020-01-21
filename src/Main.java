import dekorator.*;
import memento.Gracz;
import memento.Memento;
import singleton.Słownik;
import singleton.Słowo;
import singleton.SłowoKategoria;
import singleton.Trudność;
import strategia.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    Gracz gracz;
    Słownik słownik = Słownik.getInstance();

    public Main() throws IOException, ClassNotFoundException {

        gracz = new Gracz("gracz",0,Trudność.BradzoŁatwy,false);

        try{
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("gracz.bin")));
        Memento mem = (Memento) ois.readObject();
        gracz.przywroc(mem);
        ois.close();
        }
        catch (Exception e){
        }

        System.out.println();
        System.out.println();
        System.out.print("Witaj w aplikacji do nauki języka angielskiego!");
        System.out.println();
        menuGłówne();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new Main();
    }

    void menuGłówne() throws IOException {
        Scanner scan = new Scanner(System.in);
        String s;

        while(true) {

            System.out.println();
            System.out.println("Poziom : "+gracz.getTrudność()+"    Zdobyte punkty : "+gracz.getSumaPunktów());
            System.out.println("1. Nauka");
            System.out.println("2. Sprawdzian");
            System.out.println("3. Ustaw poziom trudności");
            System.out.println("4. Zarządzaj słownikiem");
            System.out.println("5. Zapisz stan gry");
            System.out.print("Wybierz opcję: ");
            s = scan.nextLine();
            int i = 0;

            try {
                i = Integer.parseInt(s.trim());
            } catch (Exception e) {
            }

            switch (i) {
                case 1:
                    nauka();
                    break;
                case 2:
                    sprawdzian();
                    break;
                case 3:
                    ustawTrudność();
                    break;
                case 4:
                    zarzadzajSlownikiem();
                    break;
                case 5:
                    Memento memento = gracz.stworzMemento();
                    ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("gracz.bin")));
                    oos.writeObject(memento);
                    oos.close();
                    System.out.println("Zapisano stan gry :)");
                    break;
                default:
                    System.out.println("Nie ma takiej opcji.");
            }
        }
    }

    public void nauka(){
        boolean polNaAng = ustawCzyPolNaAng();

        List<SłowoKategoria> kategorie = wybierzKategorie();

        Strategia strategia = dobierzStrategię();

        Rozgrywka rozgrywka = new RozgrywkaNauka();
        rozgrywka.setPolNaAng(polNaAng);
        rozgrywka.setKategorie(kategorie);
        rozgrywka.setStrategia(strategia);
        rozgrywka.setSłownik(słownik);

        boolean trybPodwojnePytania = ustawTrybPodwojnePytania();

        Rozgrywka rozgrywka1;

        if(trybPodwojnePytania)
            rozgrywka1 = new DekoratorTrybPodwojnePytania(rozgrywka);
        else
            rozgrywka1 = rozgrywka;

        rozgrywka1.graj();

        gracz.setSumaPunktów(rozgrywka1.zdobytePunkty());
    }

    public void sprawdzian() throws IOException {
        boolean polNaAng = ustawCzyPolNaAng();

        List<SłowoKategoria> kategorie = wybierzKategorie();

        Strategia strategia = dobierzStrategię();

        Rozgrywka rozgrywka = new RozgrywkaSprawdzian();
        rozgrywka.setPolNaAng(polNaAng);
        rozgrywka.setKategorie(kategorie);
        rozgrywka.setStrategia(strategia);
        rozgrywka.setSłownik(słownik);

        boolean trybPodwojnePytania = ustawTrybPodwojnePytania();
        boolean trybUltra = ustawTrybUltra();

        Rozgrywka rozgrywka1;
        Rozgrywka rozgrywka2;

        if(trybPodwojnePytania)
            rozgrywka1 = new DekoratorTrybPodwojnePytania(rozgrywka);
        else
            rozgrywka1 = rozgrywka;

        if(trybUltra)
            rozgrywka2 = new DekoratorTrybUltra(rozgrywka1);
        else
        rozgrywka2 = rozgrywka1;

        rozgrywka2.graj();

        gracz.setSumaPunktów(rozgrywka2.zdobytePunkty());
    }

    List<SłowoKategoria> wybierzKategorie(){
        Scanner scan = new Scanner(System.in);
        int wybór = 0;
        boolean ok;
        String s;
        List<SłowoKategoria> kategorie = new ArrayList<>();

        System.out.print("Ustawić kategorię? (T/N): ");

        s = scan.nextLine();
        if (!s.equalsIgnoreCase("t")){
            kategorie.add(SłowoKategoria.Zwierzęta);
            kategorie.add(SłowoKategoria.Kolory);
            kategorie.add(SłowoKategoria.Kolowkwium);
            return kategorie;
        }

        do{
            ok = true;
            System.out.println("Kategorie: ");
            System.out.println("1. Zwierzęta ");
            System.out.println("2. Kolowkwium");
            System.out.println("3. Kolory");
            System.out.print("Wybierz opcję: ");
            s = scan.nextLine();
            try {
                wybór = Integer.parseInt(s.trim());
            } catch (Exception e) {
                System.out.println("Należy wybrać wartość od 1 do 3!");
                ok = false;
                continue;
            }
            if(wybór<1||wybór>3)System.out.println("Należy wybrać wartość od 1 do 3!");
        } while(!ok||wybór<1||wybór>3);

        switch (wybór){
            case 1:
                kategorie.add(SłowoKategoria.Zwierzęta);
                break;
            case 2:
                kategorie.add(SłowoKategoria.Kolowkwium);
                break;
            default:
                kategorie.add(SłowoKategoria.Kolory);
                break;
        }

        return kategorie;
    }

    boolean ustawCzyPolNaAng(){
        Scanner scan = new Scanner(System.in);
        String s;
        System.out.println();
        System.out.println("Tryb");
        System.out.println("1. Polski na angielski");
        System.out.println("2. Angielski na polski");
        System.out.print("Wybierz opcję: ");
        s = scan.nextLine();
        int i = 0;

        try {
            i = Integer.parseInt(s.trim());
        } catch (Exception e) {
        }

        switch (i) {
            case 1:
                return true;
            case 2:
                return false;
            default:
                System.out.println("Nie ma takiej opcji. Ustawiono domyślnie tryb polski na angielski.");
                return true;
        }
    }

    boolean ustawTrybPodwojnePytania(){
        Scanner scan = new Scanner(System.in);
        String s;
        System.out.print("Podwójna ilość pytań? (T/N): ");
        s = scan.nextLine();

        if (s.equalsIgnoreCase("t")){
            return true;
        } else return false;
    }

    boolean ustawTrybUltra(){
        Scanner scan = new Scanner(System.in);
        String s;
        System.out.print("Dodać TrybUltra (punkty x2)? (T/N): ");
        s = scan.nextLine();

        if (s.equalsIgnoreCase("t")){
            return true;
        } else return false;
    }

    Strategia dobierzStrategię(){
        Strategia strategia;

        switch (gracz.getTrudność()){
            case BradzoŁatwy:
                strategia = new StrategiaBardzoŁatwy();
                break;
            case Łatwy:
                strategia = new StrategiaŁatwy();
                break;
            case Trudny:
                strategia = new StrategiaTrudny();
                break;
            case BardzoTrudny:
                strategia = new StrategiaBardzoTrudny();
                break;
            default:
                strategia = new StrategiaEkspert();
                break;
        }
        return strategia;
    }

    void zarzadzajSlownikiem(){

        Scanner scan = new Scanner(System.in);
        String s;
        System.out.println();
        System.out.println("1. Wyświetl słownik");
        System.out.println("2. Dodaj słowo");
        System.out.println("3. Edytuj słowo");
        System.out.println("4. Usuń słowo");
        System.out.print("Wybierz opcję: ");

        s = scan.nextLine();
        int i = 0;

        try {
            i = Integer.parseInt(s.trim());
        } catch (Exception e) {
        }

        switch (i) {
            case 1:
                System.out.println();
                System.out.println("Słownik:");
                List<Słowo> listaSłów=słownik.getAll();
                listaSłów.forEach((el) -> System.out.println(el.getPoPolsku()+" "+el.getPoAngielsku()+" "+el.getTrudnośćSłowa()+" "+el.getSłowoKategoria()));
                break;
            case 2:
                System.out.println();
                System.out.println("Dodawanie słowa");
                Słowo doDodania = pobierzSłowoOdUżytkownika();
                if(słownik.dodajSlowo(doDodania)){
                    System.out.println("Udało się");
                }else{
                    System.out.println("Nie udało się");
                }
                break;
            case 3:
                String nazwaPolska;
                System.out.println();
                System.out.println("Edytowanie słowa");
                System.out.println();

                System.out.print("Podaj słowo, które chcesz edytować w POLSKIEJ wersji: ");
                nazwaPolska = scan.nextLine();

                Słowo doEdycji = słownik.znajdzSlowo(nazwaPolska);
                if(doEdycji==null){
                    System.out.println("Nie znaleziono takiego słowa.");
                    break;
                }

                System.out.println();
                System.out.println("Wprowadzanie danych, które powinno posiadać słowo");
                Słowo noweDane = pobierzSłowoOdUżytkownika();
                if(słownik.edytujSlowo(doEdycji, noweDane)){
                    System.out.println("Udało się");
                }else{
                    System.out.println("Nie udało się");
                }
                break;
            case 4:
                String nazwaPl;
                System.out.println();
                System.out.println("Usuwanie słowa");
                System.out.println();

                System.out.print("Podaj słowo w POLSKIEJ wersji: ");
                nazwaPl = scan.nextLine();

                Słowo doUsunięcia = słownik.znajdzSlowo(nazwaPl);
                if(doUsunięcia==null){
                    System.out.println("Nie znaleziono takiego słowa.");
                }else{
                    słownik.usunSlowo(doUsunięcia);
                }
                break;
            default:
                System.out.println("Nie ma takiej opcji.");
        }
    }

    Słowo pobierzSłowoOdUżytkownika(){
        Scanner scan = new Scanner(System.in);
        String s;

        String nazwaPl, nazwaAng, kategoria, trudność;
        Trudność trudnośćSłowa;
        SłowoKategoria kategoriaSłowa;
        System.out.println();

        System.out.print("Podaj słowo w POLSKIEJ wersji: ");
        nazwaPl = scan.nextLine();

        System.out.println();
        System.out.print("Podaj słowo w ANGIELSKIEJ wersji: ");
        nazwaAng = scan.nextLine();

        boolean ok;
        int wybór = 0;
        do{
            ok = true;
            System.out.println("Trudności: ");
            System.out.println("1. Bardzo łatwy ");
            System.out.println("2. Łatwy");
            System.out.println("3. Trudny");
            System.out.println("4. Bardzo trudny");
            System.out.println("5. Ekspert");
            System.out.println();
            System.out.print("Wybierz trudność: ");
            s = scan.nextLine();


            try {
                wybór = Integer.parseInt(s.trim());
            } catch (Exception e) {
                System.out.println("Należy wybrać wartość od 1 do 5!");
                ok = false;
            }
        } while(!ok||wybór<1||wybór>5);

        switch (wybór) {
            case 1:
                trudnośćSłowa = Trudność.BradzoŁatwy;
                break;
            case 2:
                trudnośćSłowa = Trudność.Łatwy;
                break;
            case 3:
                trudnośćSłowa = Trudność.Trudny;
                break;
            case 4:
                trudnośćSłowa = Trudność.BardzoTrudny;
                break;
            case 5:
                trudnośćSłowa = Trudność.Ekspert;
                break;
            default:
                trudnośćSłowa = Trudność.Łatwy;
                System.out.println("Nie wyszło wybieranie trudności dodanego słowa (domyślne ustawienie łatwa)!");
        }

        do{
            ok = true;
            System.out.println("Kategorie: ");
            System.out.println("1. Zwierzęta ");
            System.out.println("2. Kolowkwium");
            System.out.println("3. Kolory");
            System.out.println();
            System.out.print("Wybierz opcję: ");
            s = scan.nextLine();
            try {
                wybór = Integer.parseInt(s.trim());
            } catch (Exception e) {
                System.out.println("Należy wybrać wartość od 1 do 3!");
                ok = false;
            }
        } while(!ok||wybór<1||wybór>3);

        switch (wybór) {
            case 1:
                kategoriaSłowa = SłowoKategoria.Zwierzęta;
                break;
            case 2:
                kategoriaSłowa = SłowoKategoria.Kolowkwium;
                break;
            case 3:
                kategoriaSłowa = SłowoKategoria.Kolory;
                break;
            default:
                kategoriaSłowa = SłowoKategoria.Zwierzęta;
                System.out.println("Nie wyszło wybieranie kategorii dodanego słowa (domyślne ustawienie zwierzęta)!");
        }

        return new Słowo(nazwaPl, nazwaAng, kategoriaSłowa, trudnośćSłowa);
    }

    void ustawTrudność(){
        Scanner scan = new Scanner(System.in);
        String s;
        System.out.println();
        System.out.print("Teraz poziom trudności ustawiany : ");

        if(gracz.isTrudnośćAutomatyczna())
            System.out.println("automatycznie");
        else
            System.out.println("ręcznie");

        System.out.println("1. BardzoŁatwy ");
        System.out.println("2. Łatwy");
        System.out.println("3. Trudny");
        System.out.println("4. BardzoTrudny");
        System.out.println("5. Ekspert");
        System.out.println("6. Ustawiaj automatycznie");

        System.out.print("Wybierz opcję: ");
        s = scan.nextLine();
        int i = 0;

        try {
            i = Integer.parseInt(s.trim());
        } catch (Exception e) {
        }

        switch (i) {
            case 1:
                gracz.setTrudnośćAutomatyczna(false);
                gracz.setTrudność(Trudność.BradzoŁatwy);
                break;
            case 2:
                gracz.setTrudnośćAutomatyczna(false);
                gracz.setTrudność(Trudność.Łatwy);
                break;
            case 3:
                gracz.setTrudnośćAutomatyczna(false);
                gracz.setTrudność(Trudność.Trudny);
                break;
            case 4:
                gracz.setTrudnośćAutomatyczna(false);
                gracz.setTrudność(Trudność.BardzoTrudny);
                break;
            case 5:
                gracz.setTrudnośćAutomatyczna(false);
                gracz.setTrudność(Trudność.Ekspert);
                break;
            case 6:
                gracz.setTrudnośćAutomatyczna(true);
                break;
            default:
                System.out.println("Nie ma takiej opcji.");

        }
    }
}
