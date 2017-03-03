package org.FaneFonseka.TicTacToe;


/**
 * Created by Fane on 12/01/2017.
 */
public abstract class Player {

    protected Point position;

    protected MarkSymbol markSymbol;

    Player(MarkSymbol markSymbol) {
        this.markSymbol = markSymbol;
    }


    public abstract Point getMove() throws IllegalMoveException;


    MarkSymbol getMarkSymbol() {

        return this.markSymbol;

    }

    public void setMarkSymbol(MarkSymbol markSymbol) {

        this.markSymbol = markSymbol;
    }


    public int getX() {
        return position.getX();
    }

    public int getY() {
        return position.getY();
    }
}
