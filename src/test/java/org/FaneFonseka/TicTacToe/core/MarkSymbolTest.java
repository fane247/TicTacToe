package org.FaneFonseka.TicTacToe.core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Fane on 16/01/2017.
 */
public class MarkSymbolTest {

    @Test
    public void whenGetMarkNameIsCalledUserFriendlyMarkNameIsReturned() {


        assertEquals(" X ", MarkSymbol.X.getMarkSymbolName());
        assertEquals(" O ", MarkSymbol.O.getMarkSymbolName());
        assertEquals("   ", MarkSymbol.BLANK.getMarkSymbolName());

    }

}