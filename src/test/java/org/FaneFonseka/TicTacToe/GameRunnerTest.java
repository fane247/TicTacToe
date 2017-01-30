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
    private Point point00;
    private Point point01;
    private Point point02;
    private Point point10;
    private Point point11;
    private Point point12;
    private Point point20;
    private Point point22;
    private Point point21;

    @Before
    public void setup() {

        point00 = new Point(0, 0);
        point01 = new Point(0, 1);
        point02 = new Point(0, 2);
        point10 = new Point(1, 0);
        point11 = new Point(1, 1);
        point12 = new Point(1, 2);
        point20 = new Point(2, 0);
        point22 = new Point(2, 2);
        point21 = new Point(2, 1);

    }

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