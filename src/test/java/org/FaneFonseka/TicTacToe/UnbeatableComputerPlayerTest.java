package org.FaneFonseka.TicTacToe;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.junit.Assert.*;

/**
 * Created by Fane on 17/01/2017.
 */
public class UnbeatableComputerPlayerTest {

    private GameBoard gameBoardWithPoint02Blank;
    private GameBoardFormatter gameBoardFormatter;
    private Point point00;
    private Point point01;
    private Point point02;
    private Point point10;
    private Point point11;
    private Point point12;
    private Point point20;
    private Point point22;
    private Point point21;
    private FixedMoveComputerPlayer fixedMoveComputerPlayerX;
    private FixedMoveComputerPlayer fixedMoveComputerPlayerO;
    private UnbeatableComputerPlayer unbeatableComputerPlayer;
    private GameBoard gameBoard;

    @Before
    public void setup() throws InvalidCellException, IllegalMoveException {

        gameBoardWithPoint02Blank = new GameBoard();
        gameBoardFormatter = new GameBoardFormatter(gameBoardWithPoint02Blank);

        point00 = new Point(0, 0);
        point01 = new Point(0, 1);
        point02 = new Point(0, 2);
        point10 = new Point(1, 0);
        point11 = new Point(1, 1);
        point12 = new Point(1, 2);
        point20 = new Point(2, 0);
        point22 = new Point(2, 2);
        point21 = new Point(2, 1);

        fixedMoveComputerPlayerX = new FixedMoveComputerPlayer(MarkSymbol.X, point00, point01,
                point12, point21);
        fixedMoveComputerPlayerO = new FixedMoveComputerPlayer(MarkSymbol.O, point11,
                point10, point20, point22);

//        gameBoardWithPoint02Blank.placeAllPlayersMoves(fixedMoveComputerPlayerO);
//        gameBoardWithPoint02Blank.placeAllPlayersMoves(fixedMoveComputerPlayerX);
//
        fixedMoveComputerPlayerO.placeAllPlayersMoves(gameBoardWithPoint02Blank);
        fixedMoveComputerPlayerX.placeAllPlayersMoves(gameBoardWithPoint02Blank);

        gameBoard = new GameBoard();
        unbeatableComputerPlayer = new UnbeatableComputerPlayer(MarkSymbol.X, gameBoard);
    }


    @Test
    public void whenGivenAnEmptyBoardASpaceIsChosen() throws InvalidCellException, IllegalMoveException {

        gameBoard.placePlayersMove(unbeatableComputerPlayer);

        GameBoard blankGameBoard = new GameBoard();

        assertNotEquals(gameBoard, blankGameBoard);

    }

    @Test
    public void whenGivenAGameBoardAllEmptySpacesAreReturned() throws InvalidCellException {

        ArrayList<Point> availableSpaces = unbeatableComputerPlayer.getAvailableSpaces(gameBoardWithPoint02Blank);

        Point actualPoint = availableSpaces.get(0);

        assertEquals(point02, actualPoint);

    }

    @Test
    public void whenGameBoardHasWinnerOrNoSpacesLeftGameIsOverReturnsTrue() throws InvalidCellException, IllegalMoveException {

        FixedMoveComputerPlayer fixedMoveComputerPlayerX = new FixedMoveComputerPlayer(MarkSymbol.X, point02);

        fixedMoveComputerPlayerX.placeAllPlayersMoves(gameBoardWithPoint02Blank);

        assertTrue(unbeatableComputerPlayer.gameIsOver(gameBoardWithPoint02Blank));

    }


    //todo add test for gameboard where opponent winning board evaluates to -1000

    @Test
    public void whenThereAreNoSpacesLeftOrThereIsAWinnerGetMaxMoveScoreReturnsScoreEvaluationOfBoard() throws InvalidCellException, IllegalMoveException {

        FixedMoveComputerPlayer fixedMoveComputerPlayerX = new FixedMoveComputerPlayer(MarkSymbol.X, point02);

//        gameBoardWithPoint02Blank.placeAllPlayersMoves(fixedMoveComputerPlayerX);

        fixedMoveComputerPlayerX.placeAllPlayersMoves(gameBoardWithPoint02Blank);

        gameBoardFormatter.getFormattedGameBoard();

        Integer score = unbeatableComputerPlayer.getMaxMoveScore(gameBoardWithPoint02Blank);

        assert score == 1000;

    }

    @Test
    public void whenGivenABoardWherePlayerHasWonEvaluateBoardReturns1000() throws InvalidCellException, IllegalMoveException {

        FixedMoveComputerPlayer fixedMoveComputerPlayerX = new FixedMoveComputerPlayer(MarkSymbol.X, point02);

        fixedMoveComputerPlayerX.placeAllPlayersMoves(gameBoardWithPoint02Blank);

        gameBoardFormatter.getFormattedGameBoard();

        Integer score = unbeatableComputerPlayer.getMinMoveScore(gameBoardWithPoint02Blank);

//        assert score == 1000;
        assertTrue(score == 1000);

    }

    @Test
    public void whenGivenABoardWhereOpponentHasWonEvaluateBoardReturnsMinus1000() throws InvalidCellException, IllegalMoveException {

        FixedMoveComputerPlayer fixedMoveComputerPlayerO = new FixedMoveComputerPlayer(MarkSymbol.O, point02);

        fixedMoveComputerPlayerO.placeAllPlayersMoves(gameBoardWithPoint02Blank);

        System.out.println(gameBoardFormatter.getFormattedGameBoard());

        Integer score = unbeatableComputerPlayer.getMinMoveScore(gameBoardWithPoint02Blank);

        assertTrue(score == -1000);

    }

    //todo write more tests for scenarios that just calls MinMax
    //
    //
    //
    //
    //whenGivenABoardThatHasAMoveThatCreatesTwoWaysToWinForOpponentSpaceIsChosen

    @Test
    public void whenGivenABoardWithOneSpaceThatGivesAWinAndOneThatGivesALossWinSpaceIsChosen() throws InvalidCellException {

        gameBoardWithPoint02Blank.getBoard().get(0).set(1, MarkSymbol.BLANK);
        System.out.println(gameBoardFormatter.getFormattedGameBoard());

        UnbeatableComputerPlayer unbeatableComputerPlayer = new UnbeatableComputerPlayer(MarkSymbol.X, gameBoardWithPoint02Blank);

        Point actualMove = unbeatableComputerPlayer.getMinMax();

        Point winningMove = new Point(0, 2);

        assertEquals(winningMove, actualMove);

    }

    @Test
    public void whenGivenABoardThatHasAMoveThatCreatesTwoWaysToWinSpaceIsChosen() throws InvalidCellException, IllegalMoveException {

        GameBoard gameBoardWithTwoWaysToWinForPlayer = new GameBoard();

        fixedMoveComputerPlayerX = new FixedMoveComputerPlayer(MarkSymbol.X, point00, point12);
        fixedMoveComputerPlayerO = new FixedMoveComputerPlayer(MarkSymbol.O, point20, point10);

        fixedMoveComputerPlayerX.placeAllPlayersMoves(gameBoardWithTwoWaysToWinForPlayer);
        fixedMoveComputerPlayerO.placeAllPlayersMoves(gameBoardWithTwoWaysToWinForPlayer);
        GameBoardFormatter gameBoardFormatter = new GameBoardFormatter(gameBoardWithTwoWaysToWinForPlayer);

        System.out.println(gameBoardFormatter.getFormattedGameBoard());

        unbeatableComputerPlayer = new UnbeatableComputerPlayer(MarkSymbol.X, gameBoardWithTwoWaysToWinForPlayer);

        Point actualMove = unbeatableComputerPlayer.getMove();

        Point point1WithTwoWaysToWin = new Point(0, 1);
        Point point2WithTwoWaysToWin = new Point(1, 1);
        Point point3WithTwoWaysToWin = new Point(0, 2);

        assertThat(actualMove, anyOf(is(point1WithTwoWaysToWin), is(point2WithTwoWaysToWin), is(point3WithTwoWaysToWin)));
    }

    @Test
    public void whenGivenABoardThatHasAMoveThatCreatesTwoWaysToWinForOpponentSpaceIsChosen() throws InvalidCellException,
            IllegalMoveException {

        GameBoard gameBoardWithTwoWaysToWinForPlayer = new GameBoard();

        fixedMoveComputerPlayerO = new FixedMoveComputerPlayer(MarkSymbol.O, point00, point12);
        fixedMoveComputerPlayerX = new FixedMoveComputerPlayer(MarkSymbol.X, point20, point10);

        fixedMoveComputerPlayerX.placeAllPlayersMoves(gameBoardWithTwoWaysToWinForPlayer);
        fixedMoveComputerPlayerO.placeAllPlayersMoves(gameBoardWithTwoWaysToWinForPlayer);
        GameBoardFormatter gameBoardFormatter = new GameBoardFormatter(gameBoardWithTwoWaysToWinForPlayer);

        System.out.println(gameBoardFormatter.getFormattedGameBoard());

        unbeatableComputerPlayer = new UnbeatableComputerPlayer(MarkSymbol.X, gameBoardWithTwoWaysToWinForPlayer);

        Point actualMove = unbeatableComputerPlayer.getMove();

        Point point1WithTwoWaysToWinForOpponent = new Point(0, 1);
        Point point2WithTwoWaysToWinForOpponent = new Point(1, 1);
        Point point3WithTwoWaysToWinForOpponent = new Point(0, 2);

        assertThat(actualMove, anyOf(is(point1WithTwoWaysToWinForOpponent), is(point2WithTwoWaysToWinForOpponent),
                is(point3WithTwoWaysToWinForOpponent)));


    }




}