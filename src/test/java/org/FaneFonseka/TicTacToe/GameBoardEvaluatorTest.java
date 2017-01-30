package org.FaneFonseka.TicTacToe;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.List;

/**
 * Created by Fane on 23/01/2017.
 */
public class GameBoardEvaluatorTest {


    private GameBoard gameBoard;
    private GameBoardEvaluator gameBoardEvaluator;
    private List<List<Mark>> board;

    @Before
    public void setup() {

        gameBoard = new GameBoard();
        gameBoardEvaluator = new GameBoardEvaluator(gameBoard, MarkSymbol.X);
        board = gameBoard.getBoard();

    }

    @Test
    public void whenGivenABoardWith3InARowMarkSymbolOfMaximisingPlayerReturns1000() {

        board.get(0).set(0, new Mark(MarkSymbol.X));
        board.get(0).set(1, new Mark(MarkSymbol.X));
        board.get(0).set(2, new Mark(MarkSymbol.X));

        GameBoardPrinter gameBoardPrinter = new GameBoardPrinter(gameBoard);
        gameBoardPrinter.printGameBoard();

        int actualScore = gameBoardEvaluator.getScore3InARow();

        System.out.println(actualScore);

        assert actualScore == 1000;

    }


    @Test
    public void whenGivenABoardWith3InARowMarkSymbolOfMinimisingPlayerReturnsMinus1000() {

        board.get(0).set(0, new Mark(MarkSymbol.O));
        board.get(0).set(1, new Mark(MarkSymbol.O));
        board.get(0).set(2, new Mark(MarkSymbol.O));

        GameBoardPrinter gameBoardPrinter = new GameBoardPrinter(gameBoard);
        gameBoardPrinter.printGameBoard();

        int actualScore = gameBoardEvaluator.evaluateBoard();

        System.out.println(actualScore);

        assert actualScore == -1000;

    }


}