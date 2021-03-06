package org.FaneFonseka.TicTacToe.core;

import java.util.Stack;

/**
 * Created by Fane on 12/01/2017.
 */
public class FixedMoveComputerPlayer extends Player {


    Stack<Point> moves = new Stack<Point>();


    FixedMoveComputerPlayer(MarkSymbol mark, Point... selections) {
        super(mark);

        for (Point selection : selections) {

            this.moves.add(selection);
        }

    }


    public Point getMove() {

        return moves.pop();

    }

    void placeAllPlayersMoves(GameBoard gameBoard) throws InvalidCellException, IllegalMoveException {

        int movesSize = this.moves.size();

        for (int i = 0; i < movesSize; i++) {

            gameBoard.placePlayersMove(this);

        }

    }


}
