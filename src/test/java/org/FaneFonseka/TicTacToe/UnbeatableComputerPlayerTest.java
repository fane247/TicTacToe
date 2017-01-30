package org.FaneFonseka.TicTacToe;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Fane on 17/01/2017.
 */
public class UnbeatableComputerPlayerTest {


    @Test
    public void whenGivenAnEmptyBoardASpaceIsChosen() throws InvalidCellException {

        GameBoard gameBoard = new GameBoard();
        GameBoardPrinter gameBoardPrinter = new GameBoardPrinter(gameBoard);

        UnbeatableComputerPlayer unbeatableComputerPlayer = new UnbeatableComputerPlayer(MarkSymbol.X, gameBoard);

        gameBoard.placePlayersMove(unbeatableComputerPlayer);

        gameBoardPrinter.printGameBoard();

        GameBoard blankGameBoard = new GameBoard();

        assertNotEquals(gameBoard, blankGameBoard);

    }

}