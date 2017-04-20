package org.FaneFonseka.TicTacToe.core;

/**
 * Created by Fane on 30/01/2017.
 */
public interface UserInput {

    int getGameMode();

    int getCurrentPlayerSelection();

    String getString();

    String getMove();

    default void flush(){

    };
}
