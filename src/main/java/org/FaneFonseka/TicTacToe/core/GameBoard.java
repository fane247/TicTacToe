package org.FaneFonseka.TicTacToe.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fane on 12/01/2017.
 */
public class GameBoard {

    private List<List<MarkSymbol>> board;
    private int boardSize;

    GameBoard() {

        boardSize = 3;
        clearBoard();
    }

    GameBoard(GameBoard anotherGameBoard) {

        boardSize = 3;

        board = new ArrayList<>();

        List<List<MarkSymbol>> tempBoard = anotherGameBoard.getBoard();

        for (int i = 0; i < boardSize; i++) {

            board.add(new ArrayList<>());

            for (int j = 0; j < boardSize; j++) {

                MarkSymbol markSymbol = tempBoard.get(i).get(j);

                board.get(i).add(markSymbol);
            }

        }


    }


    void clearBoard() {

        board = new ArrayList<>();

        for (int i = 0; i < boardSize; i++) {

            board.add(new ArrayList<>());

            for (int j = 0; j < boardSize; j++) {

                board.get(i).add(MarkSymbol.BLANK);
            }

        }

    }

    void placePlayersMove(Player player) throws InvalidCellException, IllegalMoveException {
        Point move = player.getMove();

        if (cellIsOccupied(move)) {

            throw new InvalidCellException();
        }

        int y = move.getY();
        int x = move.getX();

        List<MarkSymbol> row = board.get(y);
        MarkSymbol playerMarkSymbol = player.getMarkSymbol();

        row.set(x, playerMarkSymbol);

    }


    private Boolean cellIsOccupied(Point point) {

        int x = point.getX();
        int y = point.getY();

        MarkSymbol cellContent = getCell(x, y);

        return !cellContent.equals(MarkSymbol.BLANK);
    }


    List<List<MarkSymbol>> getBoard() {

        return board;
    }


    private MarkSymbol getCell(int x, int y) {

        return board.get(y).get(x);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameBoard)) return false;

        GameBoard gameBoard = (GameBoard) o;

        if (boardSize != gameBoard.boardSize) return false;
        return board.equals(gameBoard.board);
    }

}
