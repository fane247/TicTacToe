package org.FaneFonseka.TicTacToe.core;

import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertTrue;

/**
 * Created by Fane on 13/01/2017.
 */
public class GameGeneratorTest {


    private GameGenerator gameGenerator;
    private BlankPrintStream blankPrintStream;

    @Before
    public void setup() {

        blankPrintStream = new BlankPrintStream(new BlankOutPutStream());
    }

    @Test
    public void whenAHumanVsHumanGameIsRequestedAHumanVsHumanGameRunnerIsReturned() {

        UserInput userInput = new UserInput() {
            @Override
            public int getGameMode() {
                return 1;
            }

            @Override
            public int getCurrentPlayerSelection() {
                return 0;
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
        };

        gameGenerator = new GameGenerator(userInput, blankPrintStream);

        GameRunner actualGameRunnerType = gameGenerator.tryGetGameRunnerType();

        assertTrue(actualGameRunnerType instanceof HumanVsHumanGameRunner);

    }

    @Test
    public void whenAHumanVsComputerGameIsRequestedAHumanVsComputerGameRunnerIsReturned() {

        UserInput userInput = new UserInput() {
            @Override
            public int getGameMode() {
                return 3;
            }

            @Override
            public int getCurrentPlayerSelection() {
                return 0;
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
        };

        gameGenerator = new GameGenerator(userInput, blankPrintStream);

        GameRunner actualGameRunnerType = gameGenerator.tryGetGameRunnerType();


        assertTrue(actualGameRunnerType instanceof HumanVsComputerGameRunner);

    }

    @Test
    public void whenAComputerVsComputerGameIsRequestedAComputerVsComputerGameRunnerIsReturned() {

        UserInput userInput = new UserInput() {
            @Override
            public int getGameMode() {
                return 2;
            }

            @Override
            public int getCurrentPlayerSelection() {
                return 0;
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
        };

        gameGenerator = new GameGenerator(userInput, blankPrintStream);

        GameRunner actualGameRunnerType = gameGenerator.tryGetGameRunnerType();

        assertTrue(actualGameRunnerType instanceof ComputerVsComputerGameRunner);
    }

    @Test
    public void whenSelectionForGameTypeIsInvalidInputQuestionIsAskedAgain() {

        Stack<Integer> userInputList = new Stack<>();
        userInputList.add(1);
        userInputList.add(6);

        UserInput userInput = new UserInput() {
            @Override
            public int getGameMode() {
                return userInputList.pop();
            }

            @Override
            public int getCurrentPlayerSelection() {
                return 0;
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
        };

        gameGenerator = new GameGenerator(userInput, blankPrintStream);

        GameRunner actualGameRunnerType = gameGenerator.tryGetGameRunnerType();

        assertTrue(actualGameRunnerType instanceof HumanVsHumanGameRunner);

    }

}