package org.FaneFonseka.TicTacToe;

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
            public int getInt() {
                return 1;
            }

            @Override
            public String getString() {
                return null;
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
            public int getInt() {
                return 3;
            }

            @Override
            public String getString() {
                return null;
            }
        };

        gameGenerator = new GameGenerator(userInput, blankPrintStream);

        GameRunner actualGameRunnerType = gameGenerator.tryGetGameRunnerType();


        assertTrue(actualGameRunnerType instanceof HumanVsComputerGameRunner);

    }

    @Test
    public void whenSelectionForGameTypeIsInvalidInputQuestionIsAskedAgain() {

        Stack<Integer> userInputList = new Stack<>();
        userInputList.add(1);
        userInputList.add(6);

        UserInput userInput = new UserInput() {
            @Override
            public int getInt() {
                return userInputList.pop();
            }

            @Override
            public String getString() {
                return null;
            }
        };

        gameGenerator = new GameGenerator(userInput, blankPrintStream);

        GameRunner actualGameRunnerType = gameGenerator.tryGetGameRunnerType();

        assertTrue(actualGameRunnerType instanceof HumanVsHumanGameRunner);

    }

    @Test
    public void whenAComputerVsComputerGameIsRequestedAComputerVsComputerGameRunnerIsReturned() {

        UserInput userInput = new UserInput() {
            @Override
            public int getInt() {
                return 2;
            }

            @Override
            public String getString() {
                return null;
            }
        };

        gameGenerator = new GameGenerator(userInput, blankPrintStream);

        GameRunner actualGameRunnerType = gameGenerator.tryGetGameRunnerType();

        assertTrue(actualGameRunnerType instanceof ComputerVsComputerGameRunner);
    }


}