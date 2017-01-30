package org.FaneFonseka.TicTacToe;

import java.util.List;

/**
 * Created by Fane on 16/01/2017.
 */
class RowLineExtractor extends LineExtractor {


    RowLineExtractor(GameBoard gameBoard) {
        super(gameBoard);

    }


    List<List<Mark>> getLines() {

        return board;
    }

    List<Mark> getLine(int rowIndex) {

        return board.get(rowIndex);

    }


}
