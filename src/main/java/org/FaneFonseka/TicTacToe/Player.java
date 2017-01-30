package org.FaneFonseka.TicTacToe;

import java.awt.*;

/**
 * Created by Fane on 12/01/2017.
 */
public abstract class Player {

    protected Point position;

    protected MarkSymbol markSymbol;

    Player(MarkSymbol markSymbol) {
        this.markSymbol = markSymbol;
    }


    public abstract Point getMove();


    public Point getPosition() {
        return position;

    }

    Mark getMarkSymbol() {

        return new Mark(this.markSymbol, this.position);

    }


    public int getX() {
        return (int) position.getX();
    }

    public int getY() {
        return (int) position.getY();
    }
}
