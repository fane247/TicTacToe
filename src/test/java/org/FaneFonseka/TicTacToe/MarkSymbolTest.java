package org.FaneFonseka.TicTacToe;

import org.junit.Test;

/**
 * Created by Fane on 16/01/2017.
 */
public class MarkSymbolTest {

    @Test
    public void whenGetMarkNameIsCalledUserFriendlyMarkNameIsReturned() {


        assert MarkSymbol.X.getMarkName().equals(" X ");
        assert MarkSymbol.O.getMarkName().equals(" O ");
        assert MarkSymbol.BLANK.getMarkName().equals("   ");

    }

}