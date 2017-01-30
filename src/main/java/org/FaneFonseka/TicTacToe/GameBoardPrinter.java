package org.FaneFonseka.TicTacToe;

import java.util.List;
import java.util.StringJoiner;

/**
 * Created by Fane on 16/01/2017.
 */
class GameBoardPrinter {


    private final GameBoard gameBoard;

    GameBoardPrinter(GameBoard gameBoard) {

        this.gameBoard = gameBoard;
    }


    String getLine(int rowIndex) {


        StringJoiner stringJoiner = new StringJoiner("|");
        List<Mark> row = gameBoard.getBoard().get(rowIndex);


        for (Mark mark : row) {

            stringJoiner.add(mark.getMarkName());

        }

        return stringJoiner.toString();
    }

    String printGameBoard() {

        int numberOfRows = gameBoard.getBoard().size();

        String boardOutput = "   | 0 | 1 | 2 " + "\n";

        for (int i = 0; i < numberOfRows; i++) {

            boardOutput = boardOutput + " " + i + " |" + getLine(i) + "\n";

        }

        System.out.println(boardOutput);

        return boardOutput;
    }
}
