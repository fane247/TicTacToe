package org.FaneFonseka.TicTacToe;

import java.awt.*;

/**
 * Created by Fane on 13/01/2017.
 */
public class Mark {

    final MarkSymbol MARK_SYMBOL;
    private Point position;

    public Point getPosition() {
        return position;
    }

    Mark(MarkSymbol mark, Point position) {

        this.MARK_SYMBOL = mark;
        this.position = position;

    }

    Mark(MarkSymbol markSymbol) {

        this.MARK_SYMBOL = markSymbol;
        this.position = new Point(0, 0);


    }

    String getMarkName() {

        String markName = null;

        switch (MARK_SYMBOL) {

            case O:
                markName = " O ";
                break;

            case X:
                markName = " X ";
                break;

            case BLANK:
                markName = "   ";
                break;
        }

        return markName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mark)) return false;

        Mark mark = (Mark) o;

        return MARK_SYMBOL == mark.MARK_SYMBOL;
    }

}
