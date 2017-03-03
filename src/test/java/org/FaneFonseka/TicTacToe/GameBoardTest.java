package org.FaneFonseka.TicTacToe;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.FaneFonseka.TicTacToe.MarkSymbol.X;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


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
    public void whenGivenAnotherGameBoardANewGameBoardIsCreatedWhichIsTheSameAsTheGivenGameBoard() {


        List<List<MarkSymbol>> board = gameBoard.getBoard();

        for (int i = 0; i < board.size(); i++) {

            for (int j = 0; j < board.get(i).size(); j++) {

                board.get(i).set(j, MarkSymbol.X);
            }

        }

        System.out.println(gameBoardFormatter.getFormattedGameBoard());

        GameBoard anotherGameBoard = new GameBoard(gameBoard);

        assertEquals(anotherGameBoard, gameBoard);

    }

    @Test
    public void whenGameBoardIsCreatedAllSpacesAreBlank() throws InvalidCellException {

        List<List<MarkSymbol>> expectedBoard = new ArrayList<>();

        for (int i = 0; i < 3; i++) {

            expectedBoard.add(new ArrayList<>());

            for (int j = 0; j < 3; j++) {

                expectedBoard.get(i).add(MarkSymbol.BLANK);

            }

        }

        List<List<MarkSymbol>> actualBoard = gameBoard.getBoard();

        assertEquals(expectedBoard, actualBoard);
    }

    @Test
    public void whenPlaceMarkIsCalledPlayersMarkIsPlacedOnBoard() throws InvalidCellException, IllegalMoveException {

        Point move = new Point(0, 2);

        Player fixedMoveComputerPlayer = new FixedMoveComputerPlayer(X, move);

        gameBoard.placePlayersMove(fixedMoveComputerPlayer);

        MarkSymbol markSymbolPlayedOnBoard = gameBoard.getBoard().get(move.getY()).get(move.getX());

        assertEquals(markSymbolPlayedOnBoard, fixedMoveComputerPlayer.markSymbol);

    }

    @Test(expected = InvalidCellException.class)
    public void whenOccupiedCellIsChosenExceptionIsThrown() throws InvalidCellException, IllegalMoveException {

        Player FixedMoveComputerPlayer = new FixedMoveComputerPlayer(X,
                new Point(0, 0),
                new Point(0, 0));

        gameBoard.placePlayersMove(FixedMoveComputerPlayer);
        gameBoard.placePlayersMove(FixedMoveComputerPlayer);

        //if no exception is thrown test fails
        fail();

    }

    @Test
    public void whenClearBoardIsCalledAllSpacesOnBoardBecomeBlank() {

        List<List<MarkSymbol>> board = gameBoard.getBoard();

        for (int i = 0; i < board.size(); i++) {

            for (int j = 0; j < board.get(i).size(); j++) {

                board.get(i).set(j, MarkSymbol.X);
            }

        }

        System.out.println(gameBoardFormatter.getFormattedGameBoard());

        GameBoard blankGameBoard = new GameBoard();

        gameBoard.clearBoard();
        System.out.println(gameBoardFormatter.getFormattedGameBoard());

        assertEquals(blankGameBoard, gameBoard);


    }

}
