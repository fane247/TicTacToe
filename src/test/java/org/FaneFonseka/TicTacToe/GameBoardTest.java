package org.FaneFonseka.TicTacToe;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.FaneFonseka.TicTacToe.MarkSymbol.X;


/**
 * Created by Fane on 12/01/2017.
 */

public class GameBoardTest {

    private GameBoard gameBoard;
    private GameBoardFormatter gameBoardFormatter;

    @Before
    public void setUp() {

        gameBoard = new GameBoard();
        gameBoardFormatter = new GameBoardFormatter(gameBoard);

    }

    @Test
    public void whenGameBoardIsCreatedAllSpacesAreBlank() throws InvalidCellException {

        MarkSymbol blankMark = MarkSymbol.BLANK;
        List<MarkSymbol> blankRow1 = Arrays.asList(blankMark, blankMark, blankMark);
        List<MarkSymbol> blankRow2 = Arrays.asList(blankMark, blankMark, blankMark);
        List<MarkSymbol> blankRow3 = Arrays.asList(blankMark, blankMark, blankMark);

        List<List<MarkSymbol>> expectedBoard = Arrays.asList(blankRow1, blankRow2, blankRow3);

        List<List<MarkSymbol>> actualBoard = gameBoard.getBoard();

        assert expectedBoard.equals(actualBoard);
    }

    @Test
    public void whenPlaceMarkIsCalledPlayersMarkIsPlacedOnBoard() throws InvalidCellException {

        Point move = new Point(0, 2);

        Player fixedMoveComputerPlayer = new FixedMoveComputerPlayer(X, move);

        gameBoard.placePlayersMove(fixedMoveComputerPlayer);

        gameBoardFormatter.formatGameBoard();

        MarkSymbol markSymbolPlayedOnBoard = gameBoard.getCell(move.getX(), move.getY());

        assert markSymbolPlayedOnBoard.equals(fixedMoveComputerPlayer.markSymbol);

    }

    @Test(expected = InvalidCellException.class)
    public void whenOccupiedCellIsChosenExceptionIsThrown() throws InvalidCellException {

        Player FixedMoveComputerPlayer = new FixedMoveComputerPlayer(X,
                new Point(0, 0),
                new Point(0, 0));

        gameBoard.placePlayersMove(FixedMoveComputerPlayer);
        gameBoard.placePlayersMove(FixedMoveComputerPlayer);

    }

}
