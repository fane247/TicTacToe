package org.FaneFonseka.TicTacToe;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Fane on 18/01/2017.
 */
public class RowLineExtractorTest {

    private GameBoard gameBoard;
    private RowLineExtractor rowLineExtractor;

    @Before
    public void setup() {

        gameBoard = new GameBoard();
        rowLineExtractor = new RowLineExtractor(gameBoard);
        gameBoard.getBoard().get(0).set(0, new Mark(MarkSymbol.X));

    }

    @Test
    public void whenGetLineIsCalledSpecifiedLineFromGameBoardIsReturned() {

        Mark mark = new Mark(MarkSymbol.X);
        Mark mark2 = new Mark(MarkSymbol.BLANK);
        Mark mark3 = new Mark(MarkSymbol.BLANK);

        List<Mark> expectedBoard = Arrays.asList(mark, mark2, mark3);

        List<Mark> actualBoard = rowLineExtractor.getLine(0);

        assert expectedBoard.equals(actualBoard);

    }

    @Test
    public void whenGetLinesAllRowsFromGameBoardIsReturned() {

        Mark mark = new Mark(MarkSymbol.X);
        Mark markBlank = new Mark(MarkSymbol.BLANK);

        List<Mark> expectedLine1 = Arrays.asList(mark, markBlank, markBlank);
        List<Mark> expectedLine2 = Arrays.asList(markBlank, markBlank, markBlank);
        List<Mark> expectedLine3 = Arrays.asList(markBlank, markBlank, markBlank);

        List<List<Mark>> expectedLines = Arrays.asList(expectedLine1, expectedLine2, expectedLine3);

        List<List<Mark>> actualLines = gameBoard.getBoard();

        assert actualLines.equals(expectedLines);

    }

}