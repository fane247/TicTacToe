package org.FaneFonseka.TicTacToe.GUI;

import org.FaneFonseka.TicTacToe.core.UserInput;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

/**
 * Created by Fane on 24/03/2017.
 */
public class UserInputFromGUI implements UserInput, ActionListener {


    private Stack<Integer> userResponses;

    public UserInputFromGUI(int gameTypeSelection, int playerToGoFirst){

        userResponses = new Stack<>();
        userResponses.add(gameTypeSelection);
        userResponses.add(playerToGoFirst);

    }

    @Override
    public int getInt() {
        return userResponses.pop();
    }

    @Override
    public String getString() {
        return null;
    }

    @Override
    public String getMove() {

        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {



    }
}
