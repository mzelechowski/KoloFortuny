package com.lomianki;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PasswordManagerTest {

    @Test
    void checkIfListOPasswordsNotContainsRandomPassword() {
        //given
        PasswordManager manager = new PasswordManager();
        //when
        String randomPassword = manager.getRandomPassword();
        //then
        assertThat(manager.getPasswords(), not(contains(randomPassword)));
    }

    @Test
    void checkSizeListOfPassword() {
        //given
        PasswordManager manager = new PasswordManager();
        int listSize=manager.getPasswords().size();

        //when
        for (int i = 0; i < listSize; i++) {
            manager.getRandomPassword();
        }

        //then
        assertThrows(IllegalStateException.class, manager::getRandomPassword);
    }
    @Test
    void checkGuessLetterIfReturnCorrectCountOfLetters(){
        //given
        PasswordManager manager = new PasswordManager();
        char letter='ś';

        //when
        manager.setCurrentPassword("Gdzie kucharek sześć tam nie ma co jeść");

        //then
        assertThat(manager.guessLetter(letter), equalTo(2));
    }
    @Test
    void checkGuessLetterIfReturnZeroOfLetters(){
        //given
        PasswordManager manager = new PasswordManager();
        char letter='x';

        //when
        manager.setCurrentPassword("Gdzie kucharek sześć tam nie ma co jeść");

        //then
        assertThat(manager.guessLetter(letter), equalTo(0));
    }

    @Test
    void checkGuessPasswordIfReturnTrue(){
        //given
        PasswordManager manager = new PasswordManager();
        String passwordToCompare="Gdzie kucharek sześć tam nie ma co jeść";

        //when
        manager.setCurrentPassword("Gdzie kucharek sześć tam nie ma co jeść");

        //then
        assertThat(manager.guessPassword(passwordToCompare), is(true));
    }

    @Test
    void checkGuessPasswordIfReturnFalse(){
        //given
        PasswordManager manager = new PasswordManager();
        String passwordToCompare="Gdzie kucharek sześć tam nie ma co jeść";

        //when
        manager.setCurrentPassword("Gdzie kucharek sześć tam nie ma co jeść123");

        //then
        assertThat(manager.guessPassword(passwordToCompare), is(false));
    }

}