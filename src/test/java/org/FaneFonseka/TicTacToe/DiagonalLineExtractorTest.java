package org.FaneFonseka.TicTacToe;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Fane on 19/01/2017.
 */
public class DiagonalLineExtractorTest {


    private GameBoard gameBoard;
    private DiagonalLineExtractor diagonalLineExtractor;
    private Mark markX;
    private Mark mark2;
    private Mark mark3;
    private List<Mark> expectedDiagonalLineTopRightDown;
    private List<Mark> expectedDiagonalLineTopLeftDown;
    private FixedMoveComputerPlayer fixedMoveComputerPlayer;

    @Before
    public void setup() throws InvalidCellException {

        gameBoard = new GameBoard();
        diagonalLineExtractor = new DiagonalLineExtractor(gameBoard);

        gameBoard.getBoard().get(2).set(0, new Mark(MarkSymbol.X));
        gameBoard.getBoard().get(1).set(1, new Mark(MarkSymbol.X));
        gameBoard.getBoard().get(0).set(2, new Mark(MarkSymbol.X));

        markX = new Mark(MarkSymbol.X);

        GameBoardPrinter gameBoardPrinter = new GameBoardPrinter(gameBoard);

        gameBoardPrinter.printGameBoard();

        expectedDiagonalLineTopRightDown = Arrays.asList(markX, markX, markX);

        Mark markBlank = new Mark(MarkSymbol.BLANK, new Point(0, 0));

        expectedDiagonalLineTopLeftDown = Arrays.asList(markBlank, markX, markBlank);

    }

    @Test
    public void whenGetDiagonalLineTopRightDownIsCalledDiagonalLineTopRightDownLineFromGameBoardIsReturned() throws InvalidCellException {

        List<Mark> actualDiagonalLineTopRightDown = diagonalLineExtractor.getDiagonalLineTopRightDown();

        assert expectedDiagonalLineTopRightDown.equals(actualDiagonalLineTopRightDown);

    }

    @Test
    public void whenGetDiagonalLineTopLeftDownIsCalledDiagonalLineTopLeftDownLineFromGameBoardIsReturned() {

        List<Mark> actualDiagonalLineTopLeftDown = diagonalLineExtractor.getDiagonalLineTopLeftDown();

        assert expectedDiagonalLineTopLeftDown.equals(actualDiagonalLineTopLeftDown);

    }

    @Test
    public void whenGetLinesIsCalledAllDiagonalsFromGameBoardIsReturned() {

        List<List<Mark>> actualLines = diagonalLineExtractor.getLines();

        List<List<Mark>> expectedLines = Arrays.asList(expectedDiagonalLineTopLeftDown, expectedDiagonalLineTopRightDown);

        assert actualLines.equals(expectedLines);

    }

}