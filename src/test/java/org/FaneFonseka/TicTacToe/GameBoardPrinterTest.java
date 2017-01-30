package org.FaneFonseka.TicTacToe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Fane on 16/01/2017.
 */
public class GameBoardPrinterTest {

    private GameBoardPrinter gameBoardPrinter;
    private GameBoard gameBoard;

    @Before
    public void setup(){

        gameBoard = new GameBoard();
        gameBoardPrinter = new GameBoardPrinter(gameBoard);

        List<List<Mark>> board = gameBoard.getBoard();
        MarkSymbol markSymbol = MarkSymbol.X;

        board.get(0).set(0,new Mark(markSymbol));
        board.get(0).set(1,new Mark(markSymbol));
        board.get(0).set(2,new Mark(markSymbol));

    }

    @Test
    public void whenGetLineIsCalledGameBoardLineIsReturnedWithPipeDelimiters() throws InvalidCellException {

        String firstGameBoardLine = gameBoardPrinter.getLine(0);
        String expectedGameBoardLine = " X | X | X ";

        assert firstGameBoardLine.equals(expectedGameBoardLine);

    }

    @Test
    public void whenPrintGameBoardIsCalledGameBoardIsPrintedToConsoleWithPipes() throws InvalidCellException {

        String actualOutput = gameBoardPrinter.printGameBoard();

        String expectedOutput =

                "   | 0 | 1 | 2 " + "\n" +
                " 0 | X | X | X " + "\n" +
                " 1 |   |   |   " + "\n" +
                " 2 |   |   |   " + "\n";

        Assert.assertEquals(actualOutput,expectedOutput);
    }

}