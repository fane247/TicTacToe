package org.FaneFonseka.TicTacToe;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Fane on 23/01/2017.
 */
public class HumanPlayerTest {


    @Test
    public void whenUserEntersCoordinatesInConsolePointIsReturnedWithEnteredCoordinates() throws IllegalMoveException {

        UserInput userInput1 = new UserInput() {
            @Override
            public int getInt() {
                return 11;
            }

            @Override
            public String getString() {
                return null;
            }

            @Override
            public void flush() {

            }
        };

        HumanPlayer humanPlayer = new HumanPlayer(MarkSymbol.X, userInput1);

        Point actualMove = humanPlayer.getMove();

        Point expectedPoint = new Point(1, 1);

        assertEquals(expectedPoint, actualMove);

    }

    @Test
    public void whenUserEntersInvalidCoordinatesPointIsReturnedWithEnteredCoordinates() throws IllegalMoveException {

        UserInput userInput1 = new UserInput() {
            @Override
            public int getInt() {
                return 11;
            }

            @Override
            public String getString() {
                return null;
            }

            @Override
            public void flush() {

            }
        };

        HumanPlayer humanPlayer = new HumanPlayer(MarkSymbol.X, userInput1);

        Point actualMove = humanPlayer.getMove();

        Point expectedPoint = new Point(1, 1);

        assertEquals(expectedPoint, actualMove);

    }

    @Test(expected = IllegalMoveException.class)
    public void whenUserGivesInvalidInputForMoveIllegalMoveExceptionIsThrown() throws IllegalMoveException {

        UserInput userInput1 = new UserInput() {
            @Override
            public int getInt() {
                return 100;
            }

            @Override
            public String getString() {
                return null;
            }

            @Override
            public void flush() {

            }
        };

        HumanPlayer humanPlayer = new HumanPlayer(MarkSymbol.X, userInput1);

        Point actualMove = humanPlayer.getMove();

        //if no IllegalMoveException was thrown test has failed
        fail();
    }

}