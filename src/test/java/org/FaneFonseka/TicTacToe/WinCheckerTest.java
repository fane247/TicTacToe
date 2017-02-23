package org.FaneFonseka.TicTacToe;

import org.junit.Test;

import java.util.List;

/**
 * Created by Fane on 23/01/2017.
 */
public class WinCheckerTest {

//    @Test
//    public void whenThereAreNoSpacesLeftGameIsOverReturnsTrue() {
//
//        GameBoard gameBoard = new GameBoard();
//
//        List<List<Mark>> board = gameBoard.getBoard();
//        int size = board.size();
//
//        for (int i = 0; i < size; i++) {
//
//            int rowSize = board.get(i).size();
//
//            for (int j = 0; j < rowSize; j++) {
//
//                board.get(i).set(j, new Mark(MarkSymbol.X));
//
//            }
//
//        }
//
//        GameBoardFormatter gameBoardFormatter = new GameBoardFormatter(gameBoard);
//        gameBoardFormatter.formatGameBoard();
//
//        WinChecker winChecker = new WinChecker(gameBoard);
//
//        assert winChecker.gameIsOver();
//
//    }
//
//
//    @Test
//    public void whenThereAreThreeInARowOfMarkSymbolXGameIsOverReturnsTrue() {
//
//        GameBoard gameBoard = new GameBoard();
//
//        List<List<Mark>> board = gameBoard.getBoard();
//        int size = board.size();
//
//        for (int i = 0; i < size; i++) {
//
//            int rowSize = board.get(i).size();
//
//            for (int j = 0; j < rowSize; j++) {
//
//                board.get(i).set(i, new Mark(MarkSymbol.X));
//
//            }
//
//        }
//
//        GameBoardFormatter gameBoardFormatter = new GameBoardFormatter(gameBoard);
//        gameBoardFormatter.formatGameBoard();
//
//        WinChecker winChecker = new WinChecker(gameBoard);
//
//        assert winChecker.gameIsOver();
//
//    }
//
//    @Test
//    public void whenGameBoardHasThreeOInARowAnnounceWinnerReturnsOHasWon() {
//
//        GameBoard gameBoard = new GameBoard();
//
//        List<List<Mark>> board = gameBoard.getBoard();
//        int size = board.size();
//
//        for (int i = 0; i < size; i++) {
//
//            int rowSize = board.get(i).size();
//
//            for (int j = 0; j < rowSize; j++) {
//
//
//                if (i==j){
//
//                    board.get(i).set(i, new Mark(MarkSymbol.O));
//                }
//                else{
//
//                    board.get(i).set(j, new Mark(MarkSymbol.X));
//
//                }
//
//
//            }
//
//        }
//
//        GameBoardFormatter gameBoardFormatter = new GameBoardFormatter(gameBoard);
//        gameBoardFormatter.formatGameBoard();
//
//        WinChecker winChecker = new WinChecker(gameBoard);
//
//        winChecker.gameIsOver();
//
//        String actualGameOverStatement= winChecker.announceWinner();
//
//        String expectedGameOverStatement = "O has won!";
//
//        System.out.println(actualGameOverStatement);
//
//        assert actualGameOverStatement.equals(expectedGameOverStatement);
//
//    }
//
//    @Test
//    public void whenGameBoardHasNoSpacesLeftAndNoWinnerAnnounceWinnerReturnsTieGame() {
//
//        GameBoard gameBoard = new GameBoard();
//
//        List<List<Mark>> board = gameBoard.getBoard();
//        int size = board.size();
//
//        for (int i = 0; i < size; i++) {
//
//            int rowSize = board.get(i).size();
//
//            for (int j = 0; j < rowSize; j++) {
//
//
//                if (i==j){
//
//                    board.get(i).set(i, new Mark(MarkSymbol.O));
//                }
//                else{
//
//                    board.get(i).set(j, new Mark(MarkSymbol.X));
//
//                }
//
//
//            }
//
//        }
//
//        board.get(1).set(1,new Mark(MarkSymbol.X));
//        board.get(2).set(0,new Mark(MarkSymbol.O));
//        board.get(1).set(2,new Mark(MarkSymbol.O));
//        board.get(0).set(1,new Mark(MarkSymbol.O));
//
//        GameBoardFormatter gameBoardFormatter = new GameBoardFormatter(gameBoard);
//        gameBoardFormatter.formatGameBoard();
//
//        WinChecker winChecker = new WinChecker(gameBoard);
//
//        winChecker.gameIsOver();
//
//        String actualGameOverStatement= winChecker.announceWinner();
//
//        String expectedGameOverStatement = "Tie Game!";
//
//        System.out.println(actualGameOverStatement);
//
//        assert actualGameOverStatement.equals(expectedGameOverStatement);
//
//    }


}