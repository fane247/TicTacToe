package org.FaneFonseka.TicTacToe;

import org.junit.Test;

/**
 * Created by Fane on 16/01/2017.
 */
public class MarkTest {

    @Test
    public void whenGetMarkNameIsCalledUserFriendlyMarkNameIsReturned() {

        Mark markX = new Mark(MarkSymbol.X);
        Mark markO = new Mark(MarkSymbol.O);
        Mark markBlank = new Mark(MarkSymbol.BLANK);

        assert markX.getMarkName().equals(" X ");
        assert markO.getMarkName().equals(" O ");
        assert markBlank.getMarkName().equals("   ");

    }

}