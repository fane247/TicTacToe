package org.FaneFonseka.TicTacToe.core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Fane on 13/01/2017.
 */
public class FixedMoveComputerPlayerTest {

    @Test
    public void whenSetMoveIsCalledAMoveIsPoppedFromMovesList() throws IllegalMoveException {

        Point expectedMove = new Point(0, 0);

        Player player = new FixedMoveComputerPlayer(MarkSymbol.X, expectedMove);
        Point actualMove = player.getMove();

        assertEquals(expectedMove, actualMove);

    }

}