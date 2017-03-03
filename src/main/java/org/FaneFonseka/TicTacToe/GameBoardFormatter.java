package org.FaneFonseka.TicTacToe;

import java.util.List;
import java.util.StringJoiner;

/**
 * Created by Fane on 16/01/2017.
 */
class GameBoardFormatter {


    private final GameBoard gameBoard;

    GameBoardFormatter(GameBoard gameBoard) {

        this.gameBoard = gameBoard;
    }


    private String getFormattedLine(int rowIndex) {


        StringJoiner stringJoiner = new StringJoiner("|");
        List<MarkSymbol> row = gameBoard.getBoard().get(rowIndex);


        for (MarkSymbol markSymbol : row) {

            stringJoiner.add(markSymbol.getMarkSymbolName());

        }

        return stringJoiner.toString();
    }

    String getFormattedGameBoard() {

        int numberOfRows = gameBoard.getBoard().size();

        String boardOutput = "   | 0 | 1 | 2 " + "\n";

        for (int i = 0; i < numberOfRows; i++) {

            boardOutput = boardOutput + " " + i + " |" + getFormattedLine(i) + "\n";

        }

        return boardOutput;
    }
}
