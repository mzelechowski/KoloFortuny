package com.lomianki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PasswordManager {

    private List<String> passwords;
    private String currentPassword;
    List<String> getPasswords() {
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
        currentPassword = passwords.get(randomIndex);
        passwords.remove(randomIndex);
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public int guessLetter(char letter){
        int count=0;
        if (currentPassword.toLowerCase().contains(String. valueOf(letter).toLowerCase())) {
            System.out.println("Zgadnięta :D)");
            count= (int) currentPassword.chars().filter(ch -> ch == letter).count();
        } else {
            System.out.println("Taka litera nie występuje w haśle :(");
        }
        return count;
    }

    public boolean guessPassword(String inputPassword){
        if (currentPassword.equalsIgnoreCase(inputPassword.trim())) {
            System.out.println("Hasło odgadnięte :D)");
            return true;
        } else {
            System.out.println("Niepoprawne hasło :(");
            return false;
        }
    }

}
