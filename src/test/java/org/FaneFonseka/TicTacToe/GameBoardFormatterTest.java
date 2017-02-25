package org.FaneFonseka.TicTacToe;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Fane on 16/01/2017.
 */
public class GameBoardFormatterTest {

    private GameBoardFormatter gameBoardFormatter;
    private GameBoard gameBoard;

    @Before
    public void setup(){

        gameBoard = new GameBoard();
        gameBoardFormatter = new GameBoardFormatter(gameBoard);

        List<List<MarkSymbol>> board = gameBoard.getBoard();
        MarkSymbol markSymbol = MarkSymbol.X;

        board.get(0).set(0, markSymbol);
        board.get(0).set(1, markSymbol);
        board.get(0).set(2, markSymbol);

    }

    @Test
    public void whenGetLineIsCalledGameBoardLineIsReturnedWithPipeDelimiters() throws InvalidCellException {

        String firstGameBoardLine = gameBoardFormatter.getFormattedLine(0);
        String expectedGameBoardLine = " X | X | X ";

        assertEquals(expectedGameBoardLine, firstGameBoardLine);

    }

    @Test
    public void whenPrintGameBoardIsCalledGameBoardIsPrintedToConsoleWithPipes() throws InvalidCellException {

        String actualOutput = gameBoardFormatter.getFormatedGameBoard();

        String expectedOutput =

                "   | 0 | 1 | 2 " + "\n" +
                " 0 | X | X | X " + "\n" +
                " 1 |   |   |   " + "\n" +
                " 2 |   |   |   " + "\n";

        assertEquals(actualOutput, expectedOutput);
    }

}