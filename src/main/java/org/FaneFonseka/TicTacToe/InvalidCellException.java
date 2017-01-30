package org.FaneFonseka.TicTacToe;

/**
 * Created by Fane on 13/01/2017.
 */
public class InvalidCellException extends Exception {


    @Override
    public String getMessage() {

        return "Invalid Cell Chosen. Player must choose a cell which is unoccupied";

    }
}
