package com.lomianki;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final int ROUNDS = 4;

    public static void main(String[] args) {
        try {
            System.out.println("Witaj w Kole Fortuny");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Podaj liczbę graczy (2,3,4): ");
            String input = scanner.nextLine();
            int numOfPlayer;

            numOfPlayer = Integer.parseInt(input);
            while (numOfPlayer > 4 || numOfPlayer < 2) {
                System.out.println("Podano złą ilość userów");
                System.out.println("Podaj liczbę graczy (2,3,4): ");
                numOfPlayer = Integer.parseInt(scanner.nextLine());
            }

            List<Player> players = new ArrayList<>();
            for (int i = 0; i < numOfPlayer; i++) {
                System.out.println("Podaj imię gracza numer " + (i + 1) + ":");
                while ((input = scanner.nextLine()).equals("")) {
                    System.out.println("Nie podałeś imienia. Proszę wprowadź imię dla gracza numer " + (i + 1) + ":");
                }
                players.add(new Player(input));
            }

            PasswordManager passwordManager = new PasswordManager();
            for (int i = 1; i <= ROUNDS; i++) {
                System.out.println("Rozpoczęła się runda " + i);
                //String passwordToGuess = passwordManager.getRandomPassword();
                passwordManager.getRandomPassword();
                for (int j = 0; j < 7; j++) {
                     for (Player p : players) {
                        // System.out.println("\t\t\t" + passwordToGuess);
                        System.out.println("\t\t\t" + passwordManager.getObscuredPassword());
                        System.out.println("Tura gracza " + p.getName());
                        System.out.println("Podaj hasło lub literkę: ");

                        if ((input = scanner.nextLine()).equals("")) {
                            System.out.println("Nie podałeś hasła ani literki. Rezygnujesz z tury.");
                        } else if (input.length() == 1) {
                            System.out.println("Zgaduję literę");
                            passwordManager.guessLetter(input.charAt(0));
                        } else {
                            System.out.println("Zgaduję hasło");
                            passwordManager.guessPassword(input);
                        }
                    }
                }
            }
            scanner.close();
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormat Exception: invalid input string");
            System.exit(0);
        }
    }
}
