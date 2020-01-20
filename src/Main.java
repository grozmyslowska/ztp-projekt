import singleton.Słownik;
import singleton.Słowo;
import singleton.Trudność;
import strategia.*;

import java.util.List;
import java.util.Scanner;

public class Main {

    Gracz gracz;
    Słownik słownik = Słownik.getInstance();
    private static String s;

    public static void main(String[] args){
        Main main = new Main();

        System.out.print("Witaj w aplikacji do nauki języka angielskiego!");
        main.gracz = new Gracz("gracz");
        System.out.println();

        main.menuGłówne();
    }

    void menuGłówne(){
        Scanner scan = new Scanner(System.in);
        String s;

        while(1==1) {

            System.out.println();
            System.out.println("Poziom : "+gracz.getTrudność()+"");
            System.out.println();
            System.out.println("1. Nauka");
            System.out.println("2. Sprawdzian");
            System.out.println("3. Ustaw poziom");
            System.out.println("4. Zarządzaj słownikiem");
            System.out.println("5. Pokaż historię przeprowadzonych gier");
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
                    break;
                default:
                    System.out.println("Nie ma takiej opcji.");
            }
        }
    }

    public void nauka(){

        boolean polNaAng = ustawCzyPolNaAng();
        boolean trybPodwojnePytania = ustawTrybPodwojnePytania();
        boolean trybUltra = ustawTrybUltra();

        Strategia strategia = dobierzStrategię();

        // stwórz obiekt klasy rozgrywka

        // wywołaj metodę gra

        // auaktualnij liczbę punktów
    }

    public void sprawdzian(){

    }

    boolean ustawCzyPolNaAng(){
        Scanner scan = new Scanner(System.in);
        String s;
        System.out.println();
        System.out.println("Tryb");
        System.out.println("1. Polski na angielski");
        System.out.println("2. Angielski na polski");

        System.out.println();
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

        if (s=="T" || s=="t"){
            return true;
        } else return false;
    }

    boolean ustawTrybUltra(){
        Scanner scan = new Scanner(System.in);
        String s;
        System.out.print("Dodać TrybUltra (punkty x2)? (T/N): ");
        s = scan.nextLine();

        if (s=="T" || s=="t"){
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
                //strategia = new StrategiaŁatwy();
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
        return null;//strategia;
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
                słownik.wyswietlSlownik();
                break;
            case 2:
                słownik.dodajSlowo();
                break;
            case 3:
                słownik.edytujSlowo();
                break;
            case 4:
                słownik.usunSlowo();
                break;
            default:
                System.out.println("Nie ma takiej opcji.");
        }
    }

    void ustawTrudność(){
        Scanner scan = new Scanner(System.in);
        String s;
        System.out.println();
        System.out.print("Poziom trudności ustawiany : ");

        if(gracz.isTrudnośćAutomatyczna())
            System.out.println("automatycznie");
        else
            System.out.println("ręcznie");

        System.out.println();
        System.out.println("1. BardzoŁatwy ");
        System.out.println("2. Łatwy");
        System.out.println("3. Trudny");
        System.out.println("4. BardzoTrudny");
        System.out.println("5. Ekspert");
        System.out.println("6. Ustawiany automatycznie");


        System.out.println();
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
