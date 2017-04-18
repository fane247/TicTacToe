package org.FaneFonseka.TicTacToe.core;


/**
 * Created by Fane on 12/01/2017.
 */
public abstract class Player {

    protected MarkSymbol markSymbol;

    Player(MarkSymbol markSymbol) {
        this.markSymbol = markSymbol;
    }


    protected abstract Point getMove() throws IllegalMoveException;


    MarkSymbol getMarkSymbol() {

        return this.markSymbol;

    }

    protected void setMarkSymbol(MarkSymbol markSymbol) {

        this.markSymbol = markSymbol;
    }


}
