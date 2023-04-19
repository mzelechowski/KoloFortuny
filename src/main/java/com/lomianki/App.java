package com.lomianki;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final int ROUNDS = 4;

    public static void main(String[] args) {

//        Stwórz w klasie App stałą ROUNDS o wartości 4.
//        Przeiteruj od 1 do ROUNDS, w każdej iteracji wypisz „Rozpoczęła się runda <numer aktualnej rundy>”
//        W każdej rundzie przeiteruj po liście graczy (utworzonej w porzedniej user story) i wypisz komunikat „Tura gracza <imie>”
//        Utwórz Pull Request na GitHub.

        System.out.println("Witaj w Kole Fortuny");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbę graczy (2,3,4): ");
        String input = scanner.nextLine();
        int numOfPlayer = 0;
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
            System.out.println("Podaj imię gracza numer " + (i + 1) + ":");
            while ((input = scanner.nextLine()).equals("")) {
                System.out.println("Nie podałeś imienia. Proszę wprowadź imię dla gracza numer " + (i + 1) + ":");
            }
            players.add(new Player(input));
        }
        scanner.close();

        for (int i = 1; i <= ROUNDS; i++) {
            System.out.println("Rozpoczęła się runda " + i);
            players.forEach(p -> System.out.println("Tura graca " + p.getName()));
        }

    }
}
