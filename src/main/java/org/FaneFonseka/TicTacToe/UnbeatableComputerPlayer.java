package org.FaneFonseka.TicTacToe;

import java.awt.*;

/**
 * Created by Fane on 17/01/2017.
 */
public class UnbeatableComputerPlayer extends Player {


    private final MinMax minMax;
    private final GameBoard gameBoard;

    UnbeatableComputerPlayer(MarkSymbol markSymbol, GameBoard gameBoard) {

        super(markSymbol);
        this.gameBoard = gameBoard;
        minMax = new MinMax(this.markSymbol);
    }


    private Point getBestMove() throws InvalidCellException {

        return minMax.getMinMax(gameBoard);

    }


    @Override
    public Point getMove() {

        Point bestMove = null;

        try {
            bestMove = getBestMove();
        } catch (InvalidCellException e) {
            e.getMessage();
        }

        return bestMove;
    }


}
