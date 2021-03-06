package org.FaneFonseka.TicTacToe.core;

/**
 * Created by Fane on 15/01/2017.
 */
public enum MarkSymbol {

    O, X, BLANK;


    String getMarkSymbolName() {

        String markName = null;

        switch (this) {

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

}
