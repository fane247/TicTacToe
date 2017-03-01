package org.FaneFonseka.TicTacToe;

import java.util.ArrayList;
import java.util.Collections;


/**
 * Created by Fane on 17/01/2017.
 */
public class UnbeatableComputerPlayer extends Player {

    private final GameBoard gameBoard;
    private final MarkSymbol maximisingPlayer;
    private final MarkSymbol minimisingPlayer;
    private MarkSymbol currentPlayer;

    UnbeatableComputerPlayer(MarkSymbol markSymbol, GameBoard gameBoard) {

        super(markSymbol);
        this.gameBoard = gameBoard;
        this.maximisingPlayer = markSymbol;
        minimisingPlayer = maximisingPlayer.equals(MarkSymbol.X) ? MarkSymbol.O : MarkSymbol.X;
        currentPlayer = maximisingPlayer;
    }

    @Override
    public Point getMove() {

        Point bestMove = null;

        try {
            bestMove = getMinMax();
        } catch (InvalidCellException e) {
            e.getMessage();
        }

        return bestMove;
    }


    public Point getMinMax() throws InvalidCellException {

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
        java.util.List<Integer> bestMoves = new ArrayList<>();

        for (Point nextMove : availableSpaces) {

            currentPlayer = minimisingPlayer;
            GameBoard nextGameBoard = getNextGameBoard(gameBoard, nextMove);
            bestMoves.add(getMaxMoveScore(nextGameBoard));

        }

        return Collections.min(bestMoves);
    }


    public ArrayList<Point> getAvailableSpaces(GameBoard gameBoard) {

        ArrayList<Point> availableSpaces = new ArrayList<>();

        java.util.List<java.util.List<MarkSymbol>> board = gameBoard.getBoard();

        // TODO: 23/02/2017 replace with regular loop to get index's


        int boardSize = board.size();


        for (int i = 0; i < boardSize; i++) {


            int rowSize = board.get(i).size();

            for (int j = 0; j < rowSize; j++) {

                MarkSymbol currentCell = board.get(i).get(j);

                if (currentCell.equals(MarkSymbol.BLANK)) {

                    availableSpaces.add(new Point(j, i));

                }

            }

        }

        return availableSpaces;
    }


    public boolean gameIsOver(GameBoard gameBoard) {

        WinChecker winChecker = new WinChecker(gameBoard);

        return winChecker.gameIsOver();

    }

    private int evaluateGameBoard(GameBoard gameBoard) {

        WinChecker winChecker = new WinChecker(gameBoard);

        Boolean maximisingPlayerHasWon = winChecker.markSymbolHasWon(maximisingPlayer);
        Boolean minimisingPlayerHasWon = winChecker.markSymbolHasWon(minimisingPlayer);

        int score = 0;

        if (maximisingPlayerHasWon) {

            score = 1000;

        } else if (minimisingPlayerHasWon) {

            score = -1000;
        }

        return score;

    }

    public GameBoard getNextGameBoard(GameBoard gameBoard, Point move) throws InvalidCellException {

        GameBoard nextGameBoard = new GameBoard(gameBoard);

        int x = move.getX();
        int y = move.getY();

        nextGameBoard.getBoard().get(y).set(x, currentPlayer);

        return nextGameBoard;

    }

}
