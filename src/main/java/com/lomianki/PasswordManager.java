package com.lomianki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PasswordManager {

    private List<String> passwords;

    public List<String> getPasswords() {
        return passwords;
    }

    public PasswordManager() {
        passwords = new ArrayList<>(Arrays.asList("Apetyt rośnie w miarę jedzenia" , "Co dwie głowy, to nie jedna"
                , "Cwiczenie czyni mistrza" , "Darowanemu koniowi w zęby się nie zagląda" , "Diabeł tkwi w szczegółach"
                , "Elektryka prąd nie tyka"));
    }

    public String getRandomPassword() {
        if (passwords.size() == 0)
            throw new IllegalStateException("Brak unikalnego hasła");
        int randomIndex = (int) Math.floor((Math.random() * passwords.size()));
        String randomPassword = passwords.get(randomIndex);
        passwords.remove(randomIndex);
        return randomPassword;
    }


}
