import java.util.List;
import java.util.Scanner;

public class Main {

    Gracz gracz;
    private static String s;

    void menuPowitalne(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Witaj w aplikacji do nauki języka angielskiego! Podaj swoje imię: ");
        gracz = new Gracz(scan.nextLine());
        System.out.println();
    }
    
    void menuGłówne(){
        Scanner scan = new Scanner(System.in);
        String s;
        System.out.println("Gracz : "+gracz.getName()+"   Poziom : "+gracz.getTrudność()+"");
        System.out.println();
        System.out.println("1. Nauka");
        System.out.println("2. Sprawdzian");
        System.out.println("3. Ustaw poziom");
        System.out.println("4. Zarządzaj słownikiem");

        while(1==1) {
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
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Nie ma takiej opcji :C");

            }
        }
    }

    public static void main(String[] args){
 
        Main main = new Main();
        main.menuPowitalne();
        main.menuGłówne();

//        1. polski na angielski
//        2. angielski na polski
    }


    public void zagraj(){
        //wybierz nauka lub sprawdzian
        //wybierz pol-ang lub ang-pol
        //wybierz dodatkowy tryb

        //

        //dodaj punkty dla Gracza
    }

    public void edytujSłownik(){}

    public void ustawTrudność(){}
}
