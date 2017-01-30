package org.FaneFonseka.TicTacToe;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.*;
import java.util.List;

import static org.FaneFonseka.TicTacToe.MarkSymbol.BLANK;
import static org.FaneFonseka.TicTacToe.MarkSymbol.X;


/**
 * Created by Fane on 12/01/2017.
 */

public class GameBoardTest {

    private GameBoard gameBoard;
    private GameBoardPrinter gameBoardPrinter;

    @Before
    public void setUp() {

        gameBoard = new GameBoard();
        gameBoardPrinter = new GameBoardPrinter(gameBoard);

    }

    @Test
    public void whenGameBoardIsCreatedAllSpacesAreBlank() throws InvalidCellException {

        Mark blankMark = new Mark(BLANK);
        List<Mark> blankRow1 = Arrays.asList(blankMark,blankMark,blankMark);
        List<Mark> blankRow2 = Arrays.asList(blankMark,blankMark,blankMark);
        List<Mark> blankRow3 = Arrays.asList(blankMark,blankMark,blankMark);

        List<List<Mark>> expectedBoard = Arrays.asList(blankRow1, blankRow2, blankRow3);

        List<List<Mark>> actualBoard = gameBoard.getBoard();

        assert expectedBoard.equals(actualBoard);
    }

    @Test
    public void whenPlaceMarkIsCalledPlayersMarkIsPlacedOnBoard() throws InvalidCellException {

        Point move = new Point(0, 2);

        Player fixedMoveComputerPlayer = new FixedMoveComputerPlayer(X, move);

        gameBoard.placePlayersMove(fixedMoveComputerPlayer);

        gameBoardPrinter.printGameBoard();

        Mark markPlayedOnBoard = gameBoard.getCell(move.x, move.y);
        MarkSymbol markOnGameBoard = markPlayedOnBoard.MARK_SYMBOL;

        assert markOnGameBoard.equals(fixedMoveComputerPlayer.markSymbol);

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
