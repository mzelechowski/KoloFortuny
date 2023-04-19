package com.lomianki;

import java.util.*;

public class App {
    private static final int ROUNDS = 4;
    private static final int POINTS_PER_GUESS = 10;

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

            boolean goOn;
            PasswordManager passwordManager = new PasswordManager();
            for (int i = 1; i <= ROUNDS; i++) {
                goOn = true;
                System.out.println("Rozpoczęła się runda " + i);
                //String passwordToGuess = passwordManager.getRandomPassword();
                passwordManager.getRandomPassword();
                while (goOn) {
                    for (Player p : players) {
                        System.out.println("\t\t\t" + passwordManager.getObscuredPassword());
                        System.out.println("Tura gracza " + p.getName());
                        System.out.println("Podaj hasło lub literkę: ");

                        if ((input = scanner.nextLine()).equals("")) {
                            System.out.println("Nie podałeś hasła ani literki. Rezygnujesz z tury.");
                        } else if (input.length() == 1) {
                            System.out.println("Zgaduję literę");
                            p.addPoint(passwordManager.guessLetter(input.charAt(0)) * POINTS_PER_GUESS);
                        } else {
                            System.out.println("Zgaduję hasło");
                            if (passwordManager.guessPassword(input)) {
                                p.addPoint((int) (passwordManager.getObscuredPassword()
                                        .chars().filter(ch -> ch == '-').count() * POINTS_PER_GUESS));
                                goOn = false;
                                break;
                            }
                        }
                        if (passwordManager.checkPassword()) {
                            System.out.println("\t\t\t" + passwordManager.getObscuredPassword());
                            goOn = false;
                            break;
                        }
                    }
                }
                Collections.sort(players);
                for (Player p : players) {
                    System.out.println(p);
                }
            }

            scanner.close();
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormat Exception: invalid input string");
            System.exit(0);
        }
    }
}
