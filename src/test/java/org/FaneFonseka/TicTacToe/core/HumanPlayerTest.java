package org.FaneFonseka.TicTacToe.core;

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
            public int getGameMode() {
                return 0;
            }

            @Override
            public int getCurrentPlayerSelection() {
                return 0;
            }

            @Override
            public String getString() {
                return "11";
            }

            @Override
            public String getMove() {
                return "11";
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
            public int getGameMode() {
                return 0;
            }

            @Override
            public int getCurrentPlayerSelection() {
                return 0;
            }

            @Override
            public String getString() {
                return "11";
            }

            @Override
            public String getMove() {
                return "11";
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
            public int getGameMode() {
                return 0;
            }

            @Override
            public int getCurrentPlayerSelection() {
                return 0;
            }

            @Override
            public String getString() {
                return "100";
            }

            @Override
            public String getMove() {
                return "100";
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