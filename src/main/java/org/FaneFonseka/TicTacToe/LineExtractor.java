package org.FaneFonseka.TicTacToe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fane on 19/01/2017.
 */
public class LineExtractor {


    final List<List<MarkSymbol>> board;
    final GameBoard gameBoard;
    private List<List<MarkSymbol>> allLines;

    LineExtractor(GameBoard gameBoard) {

        this.gameBoard = gameBoard;
        this.board = gameBoard.getBoard();
        allLines = new ArrayList<>();
    }


    public List<List<MarkSymbol>> getAllLines() {

        allLines = new ArrayList<>();
        getColumns();
        getRows();
        getDiagonals();
        return allLines;
    }


    private void getColumns() {

        for (int i = 0; i < board.size(); i++) {

            int numberOfColumns = board.get(i).size();

            List<MarkSymbol> markColumn = new ArrayList<>();

            for (int j = 0; j < numberOfColumns; j++) {

                markColumn.add(board.get(j).get(i));

            }

            allLines.add(markColumn);

        }

    }

    private void getRows() {

        for (int i = 0; i < board.size(); i++) {

            List<MarkSymbol> markSymbols = board.get(i);
            allLines.add(markSymbols);

        }

    }

    private void getDiagonals() {

        int j = board.size() - 1;

//        0,2 1,1 2,0

        List<MarkSymbol> diagonalTopRightDown = new ArrayList<>();
        List<MarkSymbol> diagonalTopLeftDown = new ArrayList<>();

        for (int i = 0; i < board.size(); i++) {

            MarkSymbol markSymbol = board.get(i).get(j);
            diagonalTopRightDown.add(markSymbol);

            j--;

        }

        for (int i = 0; i < board.size(); i++) {

            MarkSymbol markSymbol = board.get(i).get(i);
            diagonalTopLeftDown.add(markSymbol);

        }

        allLines.add(diagonalTopLeftDown);
        allLines.add(diagonalTopRightDown);

    }


}
