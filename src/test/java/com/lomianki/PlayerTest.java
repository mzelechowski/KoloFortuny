package com.lomianki;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    void newPlayerWithNoEmptyNameCreated() {
        //given
        Player player = new Player("Maciek");
        //when
        //then
        assertThat(player.getName(),notNullValue());
    }

    @Test
    void newPlayerWithEmptyStringNameShouldThrowException() {
        //given
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> new Player(new String()));
    }
    @Test
    void newPlayerWithNullStringNameShouldThrowException() {
        //given
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> new Player(null));
    }
    @Test
    void testToString(){
        //given
        Player player = new Player("Maciek");
        String answer="[<"+player.getName()+">]";
        String output=player.toString();

        //then
        assertEquals(answer,output);
    }
}