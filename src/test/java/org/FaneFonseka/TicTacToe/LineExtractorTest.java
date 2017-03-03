package org.FaneFonseka.TicTacToe;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.FaneFonseka.TicTacToe.MarkSymbol.X;
import static org.junit.Assert.*;

/**
 * Created by Fane on 24/02/2017.
 */
public class LineExtractorTest {

    private List<List<MarkSymbol>> expectedAllLines;
    private GameBoard gameBoard;

    @Before
    public void setup() throws InvalidCellException, IllegalMoveException {

        gameBoard = new GameBoard();

        Point point00 = new Point(0, 0);
        Point point01 = new Point(0, 1);
        Point point02 = new Point(0, 2);
        Point point10 = new Point(1, 0);
        Point point11 = new Point(1, 1);
        Point point12 = new Point(1, 2);
        Point point20 = new Point(2, 0);
        Point point22 = new Point(2, 2);
        Point point21 = new Point(2, 1);

        FixedMoveComputerPlayer fixedMoveComputerPlayerX = new FixedMoveComputerPlayer(X, point00, point01,
                point12, point21);
        FixedMoveComputerPlayer fixedMoveComputerPlayerO = new FixedMoveComputerPlayer(MarkSymbol.O, point11,
                point10, point20, point22);

        fixedMoveComputerPlayerO.placeAllPlayersMoves(gameBoard);
        fixedMoveComputerPlayerX.placeAllPlayersMoves(gameBoard);

        List<MarkSymbol> col0 = Arrays.asList(MarkSymbol.X, MarkSymbol.X, MarkSymbol.BLANK);
        List<MarkSymbol> col1 = Arrays.asList(MarkSymbol.O, MarkSymbol.O, MarkSymbol.X);
        List<MarkSymbol> col2 = Arrays.asList(MarkSymbol.O, MarkSymbol.X, MarkSymbol.O);

        List<MarkSymbol> row0 = Arrays.asList(MarkSymbol.X, MarkSymbol.O, MarkSymbol.O);
        List<MarkSymbol> row1 = Arrays.asList(MarkSymbol.X, MarkSymbol.O, MarkSymbol.X);
        List<MarkSymbol> row2 = Arrays.asList(MarkSymbol.BLANK, MarkSymbol.X, MarkSymbol.O);

        List<MarkSymbol> diagonalTopLeftDown = Arrays.asList(MarkSymbol.X, MarkSymbol.O, MarkSymbol.O);
        List<MarkSymbol> diagonalTopRightDown = Arrays.asList(MarkSymbol.O, MarkSymbol.O, MarkSymbol.BLANK);

        expectedAllLines = new ArrayList<>(Arrays.asList(col0, col1, col2, row0, row1, row2, diagonalTopLeftDown, diagonalTopRightDown));

    }

    @Test
    public void whenGivenAGameBoardReturnsAllWinLinesFromBoard() {

        LineExtractor lineExtractor = new LineExtractor(gameBoard);

        List<List<MarkSymbol>> actualAllLines = lineExtractor.getAllLines();

        assertEquals(expectedAllLines, actualAllLines);

    }


}