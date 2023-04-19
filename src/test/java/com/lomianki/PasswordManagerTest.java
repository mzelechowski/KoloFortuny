package com.lomianki;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PasswordManagerTest {

    @Test
    void checkIfListOfPasswordsContainsRandomPassword() {
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
}