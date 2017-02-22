package org.FaneFonseka.TicTacToe;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * Created by Fane on 13/01/2017.
 */
public class GameRunnerTest {


    private GameRunner gameRunner;
    private Player player1;

    @Test
    public void whenAHumanVsHumanGameIsRequestedBothPlayersAreHumanPlayers() {

        UserInput userInput = new UserInput() {
            @Override
            public int getInt() {
                return 1;
            }
        };

        gameRunner = new GameRunner(userInput);

        gameRunner.selectGameType();

        player1 = gameRunner.getPlayer1();
        Player player2 = gameRunner.getPlayer2();

        assert (player1 instanceof HumanPlayer);
        assert (player2 instanceof HumanPlayer);

    }

    @Test
    public void whenAHumanVsComputerGameIsRequestedPlayerOneIsAHumanPlayerPlayerTwoIsAComputerPlayer() {

        UserInput userInput = new UserInput() {
            @Override
            public int getInt() {
                return 3;
            }
        };

        gameRunner = new GameRunner(userInput);

        gameRunner.selectGameType();

        player1 = gameRunner.getPlayer1();
        Player player2 = gameRunner.getPlayer2();

        assert (player1 instanceof HumanPlayer);
        assert (player2 instanceof UnbeatableComputerPlayer);

    }

    @Test
    public void whenAComputerVsComputerGameIsRequestedBothPlayersAreUnbeatableComputerPlayers() {

        UserInput userInput = new UserInput() {
            @Override
            public int getInt() {
                return 2;
            }
        };

        gameRunner = new GameRunner(userInput);

        gameRunner.selectGameType();

        player1 = gameRunner.getPlayer1();
        Player player2 = gameRunner.getPlayer2();

        assert (player1 instanceof UnbeatableComputerPlayer);
        assert (player2 instanceof UnbeatableComputerPlayer);

    }

    @Test
    public void whenSelectionForGameTypeIsInvalidQuestionIsAskedAgain() {

        Stack<Integer> userInputList = new Stack<>();
        userInputList.add(1);
        userInputList.add(6);

        UserInput userInput = new UserInput() {
            @Override
            public int getInt() {
                return userInputList.pop();
            }
        };

        gameRunner = new GameRunner(userInput);

        gameRunner.trySetCurrentPlayer();

        player1 = gameRunner.getPlayer1();

        Player currentPlayer = gameRunner.getCurrentPlayer();

        assert player1 ==currentPlayer;

    }

    @Test
    public void whenHumanPlayerRequestsToStartFirstPlayer1IsMadeCurrentPlayer() {

        UserInput userInput = new UserInput() {
            @Override
            public int getInt() {
                return 1;
            }
        };

        gameRunner = new GameRunner(userInput);

        gameRunner.setCurrentPlayer();

        player1 = gameRunner.getPlayer1();

        Player currentPlayer = gameRunner.getCurrentPlayer();

        assertEquals(player1, currentPlayer);

    }

    @Test
    public void whenSwapPlayerIsCalledCurrentPlayerSwapsToOtherPlayer() throws InvalidCellException {

        UserInput userInput = new UserInput() {
            @Override
            public int getInt() {
                return 1;
            }
        };

        gameRunner = new GameRunner(userInput);

        gameRunner.setCurrentPlayer();
        gameRunner.swapPlayer();

        Player currentPlayer = gameRunner.getCurrentPlayer();

        Player player2 = gameRunner.getPlayer2();

        assert currentPlayer == player2;

    }

}