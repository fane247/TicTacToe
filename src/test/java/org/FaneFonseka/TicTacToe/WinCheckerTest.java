package org.FaneFonseka.TicTacToe;

import org.junit.Test;

import java.util.List;

/**
 * Created by Fane on 23/01/2017.
 */
public class WinCheckerTest {

    @Test
    public void whenThereAreNoSpacesLeftGameIsOverReturnsTrue() {

        GameBoard gameBoard = new GameBoard();

        List<List<MarkSymbol>> board = gameBoard.getBoard();
        int size = board.size();

        for (int i = 0; i < size; i++) {

            int rowSize = board.get(i).size();

            for (int j = 0; j < rowSize; j++) {

                board.get(i).set(j, MarkSymbol.X);

            }

        }

        GameBoardFormatter gameBoardFormatter = new GameBoardFormatter(gameBoard);
        String formatedGameBoard = gameBoardFormatter.getFormattedGameBoard();
//        System.out.println(formatedGameBoard);

        WinChecker winChecker = new WinChecker(gameBoard);

        assert winChecker.gameIsOver();

    }


    @Test
    public void whenThereAreThreeInARowOfMarkSymbolXGameIsOverReturnsTrue() {

        GameBoard gameBoard = new GameBoard();

        List<List<MarkSymbol>> board = gameBoard.getBoard();
        int size = board.size();

        for (int i = 0; i < size; i++) {

            int rowSize = board.get(i).size();

            for (int j = 0; j < rowSize; j++) {

                board.get(i).set(i, MarkSymbol.X);

            }

        }

        GameBoardFormatter gameBoardFormatter = new GameBoardFormatter(gameBoard);
        String formatedGameBoard = gameBoardFormatter.getFormattedGameBoard();
//        System.out.println(formatedGameBoard);

        WinChecker winChecker = new WinChecker(gameBoard);

        assert winChecker.gameIsOver();

    }

    @Test
    public void whenGameBoardHasThreeOInARowAnnounceWinnerReturnsOHasWon() {

        GameBoard gameBoard = new GameBoard();

        List<List<MarkSymbol>> board = gameBoard.getBoard();
        int size = board.size();

        for (int i = 0; i < size; i++) {

            int rowSize = board.get(i).size();

            for (int j = 0; j < rowSize; j++) {


                if (i == j) {

                    board.get(i).set(i, MarkSymbol.O);
                } else {

                    board.get(i).set(j, MarkSymbol.X);

                }


            }

        }

        GameBoardFormatter gameBoardFormatter = new GameBoardFormatter(gameBoard);
        String formattedGameBoard = gameBoardFormatter.getFormattedGameBoard();
//        System.out.println(formattedGameBoard);

        WinChecker winChecker = new WinChecker(gameBoard);

        winChecker.gameIsOver();

        String actualGameOverStatement = winChecker.announceWinner();

        String expectedGameOverStatement = "O has won!";

//        System.out.println(actualGameOverStatement);

        assert actualGameOverStatement.equals(expectedGameOverStatement);

    }

    @Test
    public void whenGameBoardHasNoSpacesLeftAndNoWinnerAnnounceWinnerReturnsTieGame() {

        GameBoard gameBoard = new GameBoard();

        List<List<MarkSymbol>> board = gameBoard.getBoard();
        int size = board.size();

        for (int i = 0; i < size; i++) {

            int rowSize = board.get(i).size();

            for (int j = 0; j < rowSize; j++) {


                if (i == j) {

                    board.get(i).set(i, MarkSymbol.O);
                } else {

                    board.get(i).set(j, MarkSymbol.X);

                }


            }

        }

        board.get(1).set(1, MarkSymbol.X);
        board.get(2).set(0, MarkSymbol.O);
        board.get(1).set(2, MarkSymbol.O);
        board.get(0).set(1, MarkSymbol.O);

        GameBoardFormatter gameBoardFormatter = new GameBoardFormatter(gameBoard);
        String formattedGameBoard = gameBoardFormatter.getFormattedGameBoard();
//        System.out.println(formattedGameBoard);

        WinChecker winChecker = new WinChecker(gameBoard);

        winChecker.gameIsOver();

        String actualGameOverStatement = winChecker.announceWinner();

        String expectedGameOverStatement = "Tie Game!";

//        System.out.println(actualGameOverStatement);

        assert actualGameOverStatement.equals(expectedGameOverStatement);

    }


}