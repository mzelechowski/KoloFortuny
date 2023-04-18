package com.lomianki;

import java.util.Arrays;
import java.util.List;

public class PasswordManager {
//
//    Utwórz klasę PasswordManager, z jednym pole – listą stringów o nazwie passwords.
//    Utwórz bezargumentowy konstruktor, w którym do listy dodasz kilka przysłów, np.: „Apetyt rośnie w miarę jedzenia”, „Co dwie głowy, to nie jedna”, „Cwiczenie czyni mistrza”, „Darowanemu koniowi w zęby się nie zagląda”, „Diabeł tkwi w szczegółach”, „Elektryka prąd nie tyka”
//    Utwórz metodę getRandomPassword, która zwróci losowo wybrane hasło z listy.
//    Utwórz nowy obiekt klasy PasswordManager w metodzie main klas App. Na początku każdej rundy wyświetl losowo wybrane hasło.
//
    private List<String> passwords;

    public PasswordManager() {
        passwords= Arrays.asList("Apetyt rośnie w miarę jedzenia", "Co dwie głowy, to nie jedna"
                ,"Cwiczenie czyni mistrza", "Darowanemu koniowi w zęby się nie zagląda", "Diabeł tkwi w szczegółach"
                , "Elektryka prąd nie tyka");
    }

    public void getRandomPassword(){
        System.out.println(passwords.get((int) Math.floor((Math.random()* passwords.size()))));
    }


}
