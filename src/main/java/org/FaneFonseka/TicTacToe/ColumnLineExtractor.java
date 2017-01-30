package org.FaneFonseka.TicTacToe;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fane on 16/01/2017.
 */
class ColumnLineExtractor extends LineExtractor {


    ColumnLineExtractor(GameBoard gameBoard) {
        super(gameBoard);

    }


    List<List<Mark>> getLines() {

        int numberOfRows = board.size();

        List<List<Mark>> lines = new ArrayList<List<Mark>>();

        for (int i = 0; i < numberOfRows; i++) {

            lines.add(getLine(i));

        }

        return lines;
    }


    List<Mark> getLine(int columnIndex) {

        List<Mark> markList = new ArrayList<Mark>();

        int numberOfRows = board.get(columnIndex).size();

        for (int i = 0; i < numberOfRows; i++) {

            markList.add(board.get(i).get(columnIndex));

        }

        return markList;

    }
}
