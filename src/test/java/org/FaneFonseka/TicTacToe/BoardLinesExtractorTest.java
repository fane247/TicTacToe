package org.FaneFonseka.TicTacToe;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Fane on 20/01/2017.
 */
public class BoardLinesExtractorTest {

    private List<List<Mark>> expectedAllLines;
    private FixedMoveComputerPlayer fixedMoveComputerPlayerX;
    private FixedMoveComputerPlayer fixedMoveComputerPlayerO;
    private GameBoard gameBoard;
    private GameBoardFormatter gameBoardFormatter;

//    @Before
//    public void setup() throws InvalidCellException {
//
//        gameBoard = new GameBoard();
//        gameBoardFormatter = new GameBoardFormatter(gameBoard);
//
//        Point point00 = new Point(0, 0);
//        Point point01 = new Point(0, 1);
//        Point point02 = new Point(0, 2);
//        Point point10 = new Point(1, 0);
//        Point point11 = new Point(1, 1);
//        Point point12 = new Point(1, 2);
//        Point point20 = new Point(2, 0);
//        Point point22 = new Point(2, 2);
//        Point point21 = new Point(2, 1);
//
//        fixedMoveComputerPlayerX = new FixedMoveComputerPlayer(MarkSymbol.X, point00, point01,
//                point12, point21);
//        fixedMoveComputerPlayerO = new FixedMoveComputerPlayer(MarkSymbol.O, point11,
//                point10, point20, point22);
//
//        gameBoard.placeAllPlayersMoves(fixedMoveComputerPlayerO);
//        gameBoard.placeAllPlayersMoves(fixedMoveComputerPlayerX);
//
//        System.out.println("starting GameBoard");
//        gameBoardFormatter.formatGameBoard();
//
//        List<Mark> col0 = Arrays.asList(new Mark(MarkSymbol.X, point00), new Mark(MarkSymbol.X, point01), new Mark(MarkSymbol.BLANK, point02));
//        List<Mark> col1 = Arrays.asList(new Mark(MarkSymbol.O, point10), new Mark(MarkSymbol.O, point11), new Mark(MarkSymbol.X, point12));
//        List<Mark> col2 = Arrays.asList(new Mark(MarkSymbol.O, point20), new Mark(MarkSymbol.X, point21), new Mark(MarkSymbol.O, point22));
//
//        List<Mark> row0 = Arrays.asList(new Mark(MarkSymbol.X, point00), new Mark(MarkSymbol.O, point10), new Mark(MarkSymbol.O, point20));
//        List<Mark> row1 = Arrays.asList(new Mark(MarkSymbol.X, point01), new Mark(MarkSymbol.O, point11), new Mark(MarkSymbol.X, point21));
//        List<Mark> row2 = Arrays.asList(new Mark(MarkSymbol.BLANK, point02), new Mark(MarkSymbol.X, point12), new Mark(MarkSymbol.O, point22));
//
//        List<Mark> diagonalTopLeftDown = Arrays.asList(new Mark(MarkSymbol.X, point00), new Mark(MarkSymbol.O, point11), new Mark(MarkSymbol.O, point22));
//        List<Mark> diagonalTopRightDown = Arrays.asList(new Mark(MarkSymbol.O, point02), new Mark(MarkSymbol.O, point11), new Mark(MarkSymbol.BLANK, point20));
//
//        expectedAllLines = new ArrayList<>(Arrays.asList(col0, col1, col2, row0, row1, row2, diagonalTopLeftDown, diagonalTopRightDown));
//
//    }
//
//    @Test
//    public void whenGivenAGameBoardReturnsAllWinLinesFromBoard() {
//
//        BoardLinesExtractor boardLinesExtractorTest = new BoardLinesExtractor(gameBoard);
//
//        List<List<Mark>> actualAllLines = boardLinesExtractorTest.getLines();
//
//        assert actualAllLines.equals(expectedAllLines);
//
//    }

}