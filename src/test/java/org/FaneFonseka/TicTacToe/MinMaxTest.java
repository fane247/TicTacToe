package org.FaneFonseka.TicTacToe;


import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Fane on 24/01/2017.
 */
public class MinMaxTest {

    private GameBoard gameBoardWithPoint02Blank;
    private GameBoardPrinter gameBoardPrinter;
    private Point point00;
    private Point point01;
    private Point point02;
    private Point point10;
    private Point point11;
    private Point point12;
    private Point point20;
    private Point point22;
    private Point point21;
    private MinMax minMax;
    private FixedMoveComputerPlayer fixedMoveComputerPlayerX;
    private FixedMoveComputerPlayer fixedMoveComputerPlayerO;


    @Before
    public void setup() throws InvalidCellException {

        gameBoardWithPoint02Blank = new GameBoard();
        gameBoardPrinter = new GameBoardPrinter(gameBoardWithPoint02Blank);

        point00 = new Point(0, 0);
        point01 = new Point(0, 1);
        point02 = new Point(0, 2);
        point10 = new Point(1, 0);
        point11 = new Point(1, 1);
        point12 = new Point(1, 2);
        point20 = new Point(2, 0);
        point22 = new Point(2, 2);
        point21 = new Point(2, 1);

        minMax = new MinMax(MarkSymbol.X);

        fixedMoveComputerPlayerX = new FixedMoveComputerPlayer(MarkSymbol.X, point00, point01,
                point12, point21);
        fixedMoveComputerPlayerO = new FixedMoveComputerPlayer(MarkSymbol.O, point11,
                point10, point20, point22);

        gameBoardWithPoint02Blank.placeAllPlayersMoves(fixedMoveComputerPlayerO);
        gameBoardWithPoint02Blank.placeAllPlayersMoves(fixedMoveComputerPlayerX);

    }

    @Test
    public void whenGivenAGameBoardAllEmptySpacesAreReturned() throws InvalidCellException {

        ArrayList<Point> availableSpaces = minMax.getAvailableSpaces(gameBoardWithPoint02Blank);

        Point actualPoint = availableSpaces.get(0);

        assert actualPoint.equals(point02);

    }

    @Test
    public void whenGameBoardHasWinnerOrNoSpacesLeftGameIsOverReturnsTrue() throws InvalidCellException {

        FixedMoveComputerPlayer fixedMoveComputerPlayerX = new FixedMoveComputerPlayer(MarkSymbol.X, point02);

        gameBoardWithPoint02Blank.placeAllPlayersMoves(fixedMoveComputerPlayerX);

        gameBoardPrinter.printGameBoard();

        assert minMax.gameIsOver(gameBoardWithPoint02Blank);

    }

    @Test
    public void whenGameIsOverEvaluateGameBoardReturnsScore() throws InvalidCellException {

        FixedMoveComputerPlayer fixedMoveComputerPlayerX = new FixedMoveComputerPlayer(MarkSymbol.X, point02);

        gameBoardWithPoint02Blank.placeAllPlayersMoves(fixedMoveComputerPlayerX);

        gameBoardPrinter.printGameBoard();

        int score = minMax.evaluateGameBoard(gameBoardWithPoint02Blank);

        System.out.println(score);

        assert score == 1000;


    }

    @Test
    public void whenThereAreNoSpacesLeftOrThereIsAWinnerGetMaxMoveScoreReturnsScoreEvaluationOfBoard() throws InvalidCellException {

        FixedMoveComputerPlayer fixedMoveComputerPlayerX = new FixedMoveComputerPlayer(MarkSymbol.X, point02);

        gameBoardWithPoint02Blank.placeAllPlayersMoves(fixedMoveComputerPlayerX);

        gameBoardPrinter.printGameBoard();

        Integer score = minMax.getMaxMoveScore(gameBoardWithPoint02Blank);

        assert score == 1000;

    }

    @Test
    public void whenThereAreNoSpacesLeftOrThereIsAWinnerGetMinMoveScoreReturnsScoreEvaluationOfBoard() throws InvalidCellException {

        FixedMoveComputerPlayer fixedMoveComputerPlayerX = new FixedMoveComputerPlayer(MarkSymbol.X, point02);

        gameBoardWithPoint02Blank.placeAllPlayersMoves(fixedMoveComputerPlayerX);

        gameBoardPrinter.printGameBoard();

        Integer score = minMax.getMinMoveScore(gameBoardWithPoint02Blank);

        assert score == 1000;

    }

}