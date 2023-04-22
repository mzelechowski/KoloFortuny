package com.lomianki;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PasswordManager {

    private final static String fileName = ".\\src\\main\\java\\com\\lomianki\\password.json";

    private final List<String> passwords;
    private String currentPassword;
    private List<Character> correctGuesses = new ArrayList<>();

    List<String> getPasswords() {
        return passwords;
    }

    public PasswordManager() {
//        passwords = new ArrayList<>(Arrays.asList("Apetyt rośnie w miarę jedzenia", "Co dwie głowy, to nie jedna"
//                , "Cwiczenie czyni mistrza", "Darowanemu koniowi w zęby się nie zagląda", "Diabeł tkwi w szczegółach"
//                , "Elektryka prąd nie tyka"));
        passwords = getPasswords(fileName);
    }

    public String getRandomPassword() {
        if (passwords.size() == 0)
            throw new IllegalStateException("Brak unikalnego hasła");
        int randomIndex = (int) Math.floor((Math.random() * passwords.size()));
        currentPassword = passwords.get(randomIndex);
        passwords.remove(randomIndex);
        this.correctGuesses.clear();
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
        this.correctGuesses.clear();
    }

    public void setCorrectGuesses(Character... args) {
        this.correctGuesses.addAll(Arrays.asList(args));
    }

    public int guessLetter(char letter) {
        int count = 0;
        if (correctGuesses.contains(Character.toLowerCase(letter))) {
            System.out.println("Taka litera jest już na tablicy");
            return 0;
        }
        if (currentPassword.toLowerCase().contains(String.valueOf(letter).toLowerCase())) {
            System.out.println("Zgadnięta :D)");
            this.correctGuesses.add(Character.toLowerCase(letter));
            count = (int) currentPassword.chars().filter(ch -> ch == letter).count();
        } else {
            System.out.println("Taka litera nie występuje w haśle :(");
        }
        return count;
    }

    public boolean guessPassword(String inputPassword) {
        if (currentPassword.equalsIgnoreCase(inputPassword.trim())) {
            System.out.println("Hasło odgadnięte :D)");
            return true;
        } else {
            System.out.println("Niepoprawne hasło :(");
            return false;
        }
    }

    public String getObscuredPassword() {
        StringBuilder obPwd = new StringBuilder();
        obPwd.append(currentPassword);
        for (int i = 0; i < obPwd.length(); i++) {
            if (obPwd.charAt(i) != ',' && obPwd.charAt(i) != ' ')
                obPwd.replace(i, i + 1, "-");
        }
        for (int i = 0; i < obPwd.length(); i++) {
            for (Character c : correctGuesses) {
                if (c.equals(currentPassword.toLowerCase().charAt(i))) {
                    obPwd.replace(i, i + 1, currentPassword.substring(i, i + 1));
                }
            }
        }
        return obPwd.toString();
    }

    public boolean checkPassword() {
        return currentPassword.equals(getObscuredPassword());
    }

    private static List<String> getPasswords(String baseURL) {
        List<String> passwords = new ArrayList<>();
        String jsonData = getData(baseURL);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(jsonData).get("passwords");
            if (jsonNode.isArray()) {
                for (JsonNode objNode : jsonNode) {
                    passwords.add(objNode.asText());
                }
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return passwords;
    }

    private static String getData(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("Dictionary file does not exist. The program will be interrupted.!!!");
            System.out.println("Check that the given path to file and fileName of the dictionary file are correct.");
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return stringBuilder.toString();
    }
}
