package org.FaneFonseka.TicTacToe;

import java.util.List;

/**
 * Created by Fane on 19/01/2017.
 */
public abstract class LineExtractor {


    final List<List<Mark>> board;
    final GameBoard gameBoard;

    LineExtractor(GameBoard gameBoard) {

        this.gameBoard = gameBoard;
        this.board = gameBoard.getBoard();
    }

    ;

    abstract List<List<Mark>> getLines();


}
