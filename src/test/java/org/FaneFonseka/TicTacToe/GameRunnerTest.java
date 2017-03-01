package org.FaneFonseka.TicTacToe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Stack;

import static org.junit.Assert.*;

/**
 * Created by Fane on 25/02/2017.
 */
public class GameRunnerTest {

    private PrintStream printStream;

    @Before
    public void setup() {

        printStream = new BlankPrintStream(new BlankOutPutStream());
    }

    @Test
    public void whenSwapPlayerIsCalledCurrentPlayerSwapsToOtherPlayer() throws InvalidCellException {

        UserInput userInput = new UserInput() {
            @Override
            public int getInt() {
                return 1;
            }

            @Override
            public String getString() {
                return null;
            }
        };

        GameRunner gameRunner = new HumanVsComputerGameRunner(userInput, printStream);

        gameRunner.setCurrentPlayer();

        gameRunner.swapPlayer();

        Player currentPlayer = gameRunner.getCurrentPlayer();

        Player player2 = gameRunner.getPlayer2();

        assertEquals(currentPlayer, player2);

        //this assumes that player1 is current player. need to add set current player?

    }

    @Test
    public void whenHumanPlayerRequestsToStartFirstPlayer1IsMadeCurrentPlayer() {

        UserInput userInput = new UserInput() {
            @Override
            public int getInt() {
                return 1;
            }

            @Override
            public String getString() {
                return null;
            }
        };

        HumanVsHumanGameRunner humanVsHumanGameRunner = new HumanVsHumanGameRunner(userInput, printStream);

        humanVsHumanGameRunner.trySetCurrentPlayer();

        Player player1 = humanVsHumanGameRunner.getPlayer1();

        Player currentPlayer = humanVsHumanGameRunner.getCurrentPlayer();

        assertEquals(player1, currentPlayer);

    }

    @Test
    public void playerToMakeFirstMoveHasXMarkSymbol() {

        UserInput userInput = new UserInput() {
            @Override
            public int getInt() {
                return 1;
            }

            @Override
            public String getString() {
                return null;
            }
        };

        HumanVsHumanGameRunner humanVsHumanGameRunner = new HumanVsHumanGameRunner(userInput, printStream);

        humanVsHumanGameRunner.trySetCurrentPlayer();

        Player player1 = humanVsHumanGameRunner.getPlayer1();

        assertEquals(MarkSymbol.X, player1.markSymbol);

    }

    @Test
    public void whenGameIsOverUserIsAskedForRematch() throws InvalidCellException {

        UserInput userInput = new UserInput() {
            @Override
            public int getInt() {
                return 1;
            }

            @Override
            public String getString() {
                return "n";
            }
        };

        ComputerVsComputerGameRunner computerVsComputerGameRunner = new ComputerVsComputerGameRunner(userInput, printStream);

        computerVsComputerGameRunner.trySetCurrentPlayer();

        computerVsComputerGameRunner.startGame();

        assertTrue(!computerVsComputerGameRunner.userWantsRematch);

    }


    @Test
    public void whenStartGameIsCalledGameIsPlayedAndFinalStateOfGameBoardIsNotBlank() throws InvalidCellException {

        UserInput userInput = new UserInput() {
            @Override
            public int getInt() {
                return 1;
            }

            @Override
            public String getString() {
                return "n";
            }
        };

        ComputerVsComputerGameRunner computerVsComputerGameRunner = new ComputerVsComputerGameRunner(userInput, printStream);

        computerVsComputerGameRunner.trySetCurrentPlayer();

        computerVsComputerGameRunner.startGame();

        GameBoard blankGameBoard = new GameBoard();

        GameBoard finalGameBoard = computerVsComputerGameRunner.gameBoard;

        assertNotEquals(finalGameBoard, blankGameBoard);

    }

    @Test
    public void WhenUserGivesInvalidInputInResponseToRematchQuestionIsAskedAgain() throws InvalidCellException {

        Stack<String> responses = new Stack<>();

        responses.add("n");
        responses.add("x");

        UserInput userInput = new UserInput() {
            @Override
            public int getInt() {
                return 1;
            }

            @Override
            public String getString() {
                return responses.pop();
            }
        };

        ComputerVsComputerGameRunner computerVsComputerGameRunner = new ComputerVsComputerGameRunner(userInput, printStream);

        computerVsComputerGameRunner.trySetCurrentPlayer();

        computerVsComputerGameRunner.startGame();

        GameBoard blankGameBoard = new GameBoard();

        GameBoard finalGameBoard = computerVsComputerGameRunner.gameBoard;

        assertNotEquals(finalGameBoard, blankGameBoard);

    }


}