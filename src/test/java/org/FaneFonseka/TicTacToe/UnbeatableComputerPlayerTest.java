package org.FaneFonseka.TicTacToe;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
    public void setup() throws InvalidCellException {

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
    public void whenGivenAnEmptyBoardASpaceIsChosen() throws InvalidCellException {

        GameBoardFormatter gameBoardFormatter = new GameBoardFormatter(gameBoard);

        gameBoard.placePlayersMove(unbeatableComputerPlayer);

        gameBoardFormatter.getFormattedGameBoard();

        GameBoard blankGameBoard = new GameBoard();

        assertNotEquals(gameBoard, blankGameBoard);

    }

    @Test
    public void whenGivenAGameBoardAllEmptySpacesAreReturned() throws InvalidCellException {

//        System.out.println(gameBoardFormatter.getFormattedGameBoard());

        ArrayList<Point> availableSpaces = unbeatableComputerPlayer.getAvailableSpaces(gameBoardWithPoint02Blank);

        Point actualPoint = availableSpaces.get(0);

//        System.out.println(actualPoint);
//        System.out.println(point02);

        assertEquals(point02, actualPoint);

    }

    @Test
    public void whenGameBoardHasWinnerOrNoSpacesLeftGameIsOverReturnsTrue() throws InvalidCellException {

        FixedMoveComputerPlayer fixedMoveComputerPlayerX = new FixedMoveComputerPlayer(MarkSymbol.X, point02);

//        gameBoardWithPoint02Blank.placeAllPlayersMoves(fixedMoveComputerPlayerX);

        fixedMoveComputerPlayerX.placeAllPlayersMoves(gameBoardWithPoint02Blank);

        gameBoardFormatter.getFormattedGameBoard();

        assert unbeatableComputerPlayer.gameIsOver(gameBoardWithPoint02Blank);

    }

    @Test
    public void whenGameIsOverEvaluateGameBoardReturnsScore() throws InvalidCellException {

        FixedMoveComputerPlayer fixedMoveComputerPlayerX = new FixedMoveComputerPlayer(MarkSymbol.X, point02);

//        gameBoardWithPoint02Blank.placeAllPlayersMoves(fixedMoveComputerPlayerX);

        fixedMoveComputerPlayerX.placeAllPlayersMoves(gameBoardWithPoint02Blank);

        gameBoardFormatter.getFormattedGameBoard();

        int score = unbeatableComputerPlayer.evaluateGameBoard(gameBoardWithPoint02Blank);

//        System.out.println(score);

        assert score == 1000;


    }

    @Test
    public void whenThereAreNoSpacesLeftOrThereIsAWinnerGetMaxMoveScoreReturnsScoreEvaluationOfBoard() throws InvalidCellException {

        FixedMoveComputerPlayer fixedMoveComputerPlayerX = new FixedMoveComputerPlayer(MarkSymbol.X, point02);

//        gameBoardWithPoint02Blank.placeAllPlayersMoves(fixedMoveComputerPlayerX);

        fixedMoveComputerPlayerX.placeAllPlayersMoves(gameBoardWithPoint02Blank);

        gameBoardFormatter.getFormattedGameBoard();

        Integer score = unbeatableComputerPlayer.getMaxMoveScore(gameBoardWithPoint02Blank);

        assert score == 1000;

    }

    @Test
    public void whenThereAreNoSpacesLeftOrThereIsAWinnerGetMinMoveScoreReturnsScoreEvaluationOfBoard() throws InvalidCellException {

        FixedMoveComputerPlayer fixedMoveComputerPlayerX = new FixedMoveComputerPlayer(MarkSymbol.X, point02);

//        gameBoardWithPoint02Blank.placeAllPlayersMoves(fixedMoveComputerPlayerX);

        fixedMoveComputerPlayerX.placeAllPlayersMoves(gameBoardWithPoint02Blank);

        gameBoardFormatter.getFormattedGameBoard();

        Integer score = unbeatableComputerPlayer.getMinMoveScore(gameBoardWithPoint02Blank);

        assert score == 1000;

    }

}