package com.lomianki;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        System.out.println("Witaj w Kole Fortuny");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbę graczy (2,3,4): ");
        String input = scanner.nextLine();
        int numOfPlayer=0;
        try {
            numOfPlayer = Integer.parseInt(input);
            while (numOfPlayer > 4 || numOfPlayer < 2) {
                System.out.println("Podano złą ilość userów");
                System.out.println("Podaj liczbę graczy (2,3,4): ");
                numOfPlayer = Integer.parseInt(scanner.nextLine());
            }
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormat Exception: invalid input string");
            System.exit(0);
        }
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < numOfPlayer; i++) {
            System.out.println("Podaj imię gracza numer " + (i + 1) +":" );
            while((input=scanner.nextLine()).equals("")){
                System.out.println("Nie podałeś imienia. Proszę wprowadź imię dla gracza numer "+ (i + 1) +":" );
            }
            players.add(new Player(input));
        }
        scanner.close();
        players.forEach(System.out::println);

    }
}
