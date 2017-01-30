package org.FaneFonseka.TicTacToe;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Fane on 19/01/2017.
 */
public class ColumnLineExtractorTest {

    private GameBoard gameBoard;
    private ColumnLineExtractor columnLineExtractor;

    @Before
    public void setUp() {

        gameBoard = new GameBoard();

        gameBoard.getBoard().get(0).set(0, new Mark(MarkSymbol.X));

        columnLineExtractor = new ColumnLineExtractor(gameBoard);

    }

    @Test
    public void whenGetLineIsCalledSpecifiedColumnFromGameBoardIsReturned() {

        Mark markX = new Mark(MarkSymbol.X);
        Mark blankMark = new Mark(MarkSymbol.BLANK);

        List<Mark> expectedColumn = Arrays.asList(markX, blankMark, blankMark);
        List<Mark> actualColumn = columnLineExtractor.getLine(0);

        assert expectedColumn.equals(actualColumn);

    }

    @Test
    public void whenGetLinesIsCalledAllColumnsFromGameBoardIsReturned() {

        ColumnLineExtractor columnLineExtractor = new ColumnLineExtractor(gameBoard);

        Mark markX = new Mark(MarkSymbol.X);
        Mark blankMark = new Mark(MarkSymbol.BLANK);

        List<Mark> expectedColumn1 = Arrays.asList(markX, blankMark, blankMark);
        List<Mark> expectedColumn2 = Arrays.asList(blankMark, blankMark, blankMark);
        List<Mark> expectedColumn3 = Arrays.asList(blankMark, blankMark, blankMark);

        List<List<Mark>> expectedColumns = Arrays.asList(expectedColumn1, expectedColumn2, expectedColumn3);

        List<List<Mark>> actualColumns = columnLineExtractor.getLines();

        assert expectedColumns.equals(actualColumns);

    }

}