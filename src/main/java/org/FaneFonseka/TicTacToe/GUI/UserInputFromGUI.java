package org.FaneFonseka.TicTacToe.GUI;

import org.FaneFonseka.TicTacToe.core.UserInput;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

/**
 * Created by Fane on 24/03/2017.
 */
public class UserInputFromGUI implements UserInput, ActionListener {


    private Stack<Integer> setupResponses;
    private String move;

    public UserInputFromGUI(int gameTypeSelection, int playerToGoFirst){

        setupResponses = new Stack<>();
        setupResponses.add(gameTypeSelection);
        setupResponses.add(playerToGoFirst);

    }

    @Override
    public int getGameMode() {

        return setupResponses.pop();

    }

    @Override
    public int getCurrentPlayerSelection() {
        return setupResponses.pop();
    }

    @Override
    public String getString() {
        return null;
    }

    @Override
    public String getMove() {

        return move;
    }

    @Override
    public void flush() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        move = e.getActionCommand();

    }



}
