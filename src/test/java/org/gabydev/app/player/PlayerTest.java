package org.gabydev.app.player;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void play_lose_when_dice_number_is_too_low() {
        //creando un mock
        Dice dice = Mockito.mock(Dice.class);

        //con mockito simulamos que cuando el dado haga roll devuelva un 2
        Mockito.when(dice.roll()).thenReturn(2);

        Player player = new Player(dice, 5);

        assertFalse(player.play());
    }

    @Test
    public void play_win_when_dice_number_is_big() {
        //creando un mock
        Dice dice = Mockito.mock(Dice.class);

        //con mockito simulamos que cuando el dado haga roll devuelva un 2
        Mockito.when(dice.roll()).thenReturn(4);

        Player player = new Player(dice, 3);

        assertTrue(player.play());
    }
}