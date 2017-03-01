package org.FaneFonseka.TicTacToe;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Fane on 16/01/2017.
 */
public class MarkSymbolTest {

    @Test
    public void whenGetMarkNameIsCalledUserFriendlyMarkNameIsReturned() {


        assertEquals(" X ", MarkSymbol.X.getMarkName());
        assertEquals(" O ", MarkSymbol.O.getMarkName());
        assertEquals("   ", MarkSymbol.BLANK.getMarkName());

    }

}