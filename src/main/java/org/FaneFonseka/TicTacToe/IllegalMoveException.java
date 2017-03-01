package org.FaneFonseka.TicTacToe;

/**
 * Created by Fane on 01/03/2017.
 */
public class IllegalMoveException extends Throwable {

    @Override
    public String getMessage() {
        return "Move must be 2 digits long";
    }
}
