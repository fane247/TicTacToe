package org.FaneFonseka.TicTacToe;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fane on 12/01/2017.
 */
class GameBoard {

    private List<List<Mark>> board;
    private int boardSize;

    GameBoard() {

        boardSize = 3;
        setupBoard();
    }

    GameBoard(GameBoard anotherGameBoard) {

        boardSize = 3;

        board = new ArrayList<>();

        List<List<Mark>> tempBoard = anotherGameBoard.getBoard();

        for (int i = 0; i < boardSize; i++) {

            board.add(new ArrayList<>());

            for (int j = 0; j < boardSize; j++) {

                MarkSymbol markSymbol = tempBoard.get(i).get(j).MARK_SYMBOL;

                board.get(i).add(new Mark(markSymbol, new Point(j, i)));
            }

        }


    }


    private void setupBoard() {

        board = new ArrayList<>();

        for (int i = 0; i < boardSize; i++) {

            board.add(new ArrayList<>());

            for (int j = 0; j < boardSize; j++) {

                board.get(i).add(new Mark(MarkSymbol.BLANK, new Point(j, i)));
            }

        }

    }

    void placePlayersMove(Player player) throws InvalidCellException {
        Point move = player.getMove();

        if (cellIsOccupied(move)) {

            throw new InvalidCellException();
        }

        int y = (int) move.getY();
        int x = (int) move.getX();

        List<Mark> row = board.get(y);
        Mark playerMark = player.getMarkSymbol();

        row.set(x, playerMark);

    }

    void placeAllPlayersMoves(FixedMoveComputerPlayer player) throws InvalidCellException {

        int movesSize = player.moves.size();

        for (int i = 0; i < movesSize; i++) {

            placePlayersMove(player);

        }

    }

    private Boolean cellIsOccupied(Point point) {

        int x = (int) point.getX();
        int y = (int) point.getY();

        MarkSymbol cellContent = getCell(x, y).MARK_SYMBOL;

        return !cellContent.equals(MarkSymbol.BLANK);
    }


    List<List<Mark>> getBoard() {

        return board;
    }


    Mark getCell(int x, int y) {

        return board.get(y).get(x);
    }

}
