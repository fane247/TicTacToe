package org.FaneFonseka.TicTacToe;

import org.junit.Test;

import static org.FaneFonseka.TicTacToe.MarkSymbol.X;

/**
 * Created by Fane on 13/01/2017.
 */
public class FixedMoveComputerPlayerTest {

    @Test
    public void whenSetMoveIsCalledAMoveIsPoppedFromMovesList() throws IllegalMoveException {

        Point expectedMove = new Point(0, 0);

        Player player = new FixedMoveComputerPlayer(X, expectedMove);
        Point actualMove = player.getMove();

        assert actualMove.equals(expectedMove);

    }

}