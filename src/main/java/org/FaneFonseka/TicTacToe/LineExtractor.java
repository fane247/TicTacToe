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


    List<List<MarkSymbol>> getLines() {


        List<List<MarkSymbol>> columns = getColumns();


    }


    List<List<MarkSymbol>> getColumns() {


        for (int i = 0; i < board.size(); i++) {

            int numberOfColumns = board.get(i).size();

            List<MarkSymbol> markColumn = new ArrayList<>();

            for (int j = 0; j < numberOfColumns; i++) {

                markColumn.add(board.get(j).get(i));

            }

            markSymbolLists.add(markColumn);

        }

        return markSymbolLists;

    }

    List<List<MarkSymbol>> getRows() {

        List<List<MarkSymbol>> markSymbolsLists = new ArrayList<>();

        for (int i = 0; i < board.size(); i++) {

            List<MarkSymbol> markSymbols = board.get(0);
            markSymbolsLists.add(markSymbols);

        }

        return markSymbolsLists;

    }

    List<List<MarkSymbol>> getDiagonal() {

        List<List<MarkSymbol>> markSymbolsLists = new ArrayList<>();


        int j = board.size() - 1;

//        0,2 1,1 2,0

        List<MarkSymbol> markSymbolsDiagonals = new ArrayList<>();

        for (int i = 0; i < board.size(); i++) {

            MarkSymbol markSymbol = board.get(i).get(j);
            markSymbolsDiagonals.add(markSymbol);

            j--;

        }

        for (int i = 0; i < board.size(); i++) {

            MarkSymbol markSymbol = board.get(i).get(i);
            markSymbolsDiagonals.add(markSymbol);

        }

        markSymbolsLists.add(markSymbolsDiagonals);

        return markSymbolsLists;

    }



}
