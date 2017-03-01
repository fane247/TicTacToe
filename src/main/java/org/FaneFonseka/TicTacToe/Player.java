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

    //todo inconsistent naming

    MarkSymbol getMarkSymbol() {

        return this.markSymbol;

    }

    public void setMarkSymbol(MarkSymbol markSymbol) {

        this.markSymbol = markSymbol;
    }


    public int getX() {
        return (int) position.getX();
    }

    public int getY() {
        return (int) position.getY();
    }
}
