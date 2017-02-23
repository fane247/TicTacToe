package org.FaneFonseka.TicTacToe;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Fane on 24/01/2017.
 */
public class MinMax {


    private final MarkSymbol maximisingPlayer;
    private final MarkSymbol minimisingPlayer;
    private MarkSymbol currentPlayer;

    public MinMax(MarkSymbol maximisingPlayer) {

        this.maximisingPlayer = maximisingPlayer;
        minimisingPlayer = maximisingPlayer.equals(MarkSymbol.X) ? MarkSymbol.O : MarkSymbol.X;
        currentPlayer = maximisingPlayer;
    }


    public Point getMinMax(GameBoard gameBoard) throws InvalidCellException {

        ArrayList<Point> availableSpaces = getAvailableSpaces(gameBoard);

        int bestScore = Integer.MIN_VALUE;
        Point bestPoint = null;

        for (Point move : availableSpaces) {

            currentPlayer = maximisingPlayer;
            GameBoard nextGameBoard = getNextGameBoard(gameBoard, move);

            Integer score = getMinMoveScore(nextGameBoard);

            if (score > bestScore) {

                bestScore = score;
                bestPoint = move;

            }

        }

        return bestPoint;

    }


    public Integer getMaxMoveScore(GameBoard gameBoard) throws InvalidCellException {

        if (gameIsOver(gameBoard)) {
            return evaluateGameBoard(gameBoard);
        }

        ArrayList<Point> availableSpaces = getAvailableSpaces(gameBoard);
        ArrayList<Integer> bestMoves = new ArrayList<>();

        for (Point nextMove : availableSpaces) {

            currentPlayer = maximisingPlayer;
            GameBoard nextGameBoard = getNextGameBoard(gameBoard, nextMove);

            bestMoves.add(getMinMoveScore(nextGameBoard));

        }

        return Collections.max(bestMoves);
    }

    public Integer getMinMoveScore(GameBoard gameBoard) throws InvalidCellException {

        if (gameIsOver(gameBoard)) {
            return evaluateGameBoard(gameBoard);

        }

        ArrayList<Point> availableSpaces = getAvailableSpaces(gameBoard);
        List<Integer> bestMoves = new ArrayList<>();

        for (Point nextMove : availableSpaces) {

            currentPlayer = minimisingPlayer;
            GameBoard nextGameBoard = getNextGameBoard(gameBoard, nextMove);
            bestMoves.add(getMaxMoveScore(nextGameBoard));

        }

        return Collections.min(bestMoves);
    }


    public ArrayList<Point> getAvailableSpaces(GameBoard gameBoard) {

        ArrayList<Point> availableSpaces = new ArrayList<>();

        List<List<MarkSymbol>> board = gameBoard.getBoard();

        // TODO: 23/02/2017 replace with regular loop to get index's


        int boardSize = board.size();


        for (int i = 0; i < boardSize; i++) {


            int rowSize = board.get(i).size();

            for (int j = 0; j < rowSize; j++) {

                MarkSymbol currentCell = board.get(i).get(j);

                if (currentCell.equals(MarkSymbol.BLANK)) {

                    availableSpaces.add(new Point(i, j));

                }

            }

        }

        return availableSpaces;
    }


    public boolean gameIsOver(GameBoard gameBoard) {

        WinChecker winChecker = new WinChecker(gameBoard);

        return winChecker.gameIsOver();

    }

    public int evaluateGameBoard(GameBoard gameBoard) {

        GameBoardEvaluator gameBoardEvaluator = new GameBoardEvaluator(gameBoard, maximisingPlayer);
        int score = gameBoardEvaluator.evaluateBoard();
        return score;

    }

    public GameBoard getNextGameBoard(GameBoard gameBoard, Point move) throws InvalidCellException {

        GameBoard nextGameBoard = new GameBoard(gameBoard);

        FixedMoveComputerPlayer fixedMoveComputerPlayer = new FixedMoveComputerPlayer(currentPlayer, move);
        nextGameBoard.placePlayersMove(fixedMoveComputerPlayer);

        return nextGameBoard;

    }

}


