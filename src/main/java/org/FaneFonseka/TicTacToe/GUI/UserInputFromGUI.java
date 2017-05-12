package org.FaneFonseka.TicTacToe.GUI;

import org.FaneFonseka.TicTacToe.core.UserInput;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

/**
 * Created by Fane on 24/03/2017.
 */
public class UserInputFromGUI implements UserInput{


    private final String gameTypeSelection;
    private final String playerToGoFirst;
    private String move;
    private TicTacToeMainController ticTacToeMainController;

    public UserInputFromGUI(String gameTypeSelection, String playerToGoFirst) {

        this.gameTypeSelection = gameTypeSelection;
        this.playerToGoFirst = playerToGoFirst;
    }

    @Override
    public int getGameMode() {

        int gameModeSelection = 0;

        switch (gameTypeSelection) {

            case "Human Vs Human":
                return 1;

            case "Computer vs Computer":
                return 2;

            case "Human vs Computer":
                return 3;

        }

        System.out.println("gameMode: " + gameModeSelection);

        return gameModeSelection;

    }

    @Override
    public int getCurrentPlayerSelection() {

        int playerToGoFirstSelection = 0;

        switch (playerToGoFirst){

            case "Player 1":
                playerToGoFirstSelection = 1;
                break;

            case "Player 2":
                playerToGoFirstSelection = 2;
                break;
        }

        System.out.println("currentPlayer: " + playerToGoFirstSelection);

        return playerToGoFirstSelection;

    }



    @Override
    public String getString() {
        return null;
    }

    @Override
    public String getMove() {

        move = ticTacToeMainController.getMove();
        return move;
    }

    @Override
    public void flush() {

    }

    public void setTicTacToeMainController(TicTacToeMainController ticTacToeMainController) {
        this.ticTacToeMainController = ticTacToeMainController;
    }

}
