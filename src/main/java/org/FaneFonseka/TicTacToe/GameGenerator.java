package org.FaneFonseka.TicTacToe;

import java.io.PrintStream;
import java.util.InputMismatchException;

/**
 * Created by Fane on 13/01/2017.
 */
public class GameGenerator {

    private PrintStream printStream;
    private GameBoard gameBoard;
    private Player player1;
    private Player player2;
    private UserInput userInput;

    GameGenerator(UserInput userInput, PrintStream printStream) {

        this.printStream = printStream;
        this.gameBoard = new GameBoard();
        this.userInput = userInput;
    }

    public GameRunner tryGetGameRunnerType() {

        boolean isInvalidSelection = true;

        GameRunner gameRunner = null;

        while (isInvalidSelection) {

            try {
                gameRunner = getGameRunnerType();
                isInvalidSelection = false;

            } catch (IllegalArgumentException | InputMismatchException e) {

                printStream.println("Invalid selection");
                printStream.println("please choose again");
                printStream.println();
                userInput.flush();
            }
        }

        return gameRunner;
    }

    private GameRunner getGameRunnerType() {

        printStream.println("select players: ");
        printStream.println("Please enter a number");
        printStream.println();

        printStream.println("1. Human vs Human");
        printStream.println("2. Computer vs Computer");
        printStream.println("3. Human vs Computer");
        printStream.println();

        int selection = userInput.getInt();

        GameRunner gameRunner;

        switch (selection) {

            case 1:
                gameRunner = new HumanVsHumanGameRunner(userInput, printStream);
                printStream.println("1. Human vs Human selected");
                break;

            case 2:
                gameRunner = new ComputerVsComputerGameRunner(userInput, printStream);
                printStream.println("2. Computer vs Computer selected");
                break;

            case 3:
                gameRunner = new HumanVsComputerGameRunner(userInput, printStream);
                printStream.println("3. Human vs Computer selected");
                break;

            default:
                throw new IllegalArgumentException();
        }

        return gameRunner;

    }

    public static void main(String[] args) throws InvalidCellException {

        UserInputFromConsole userInputFromConsole = new UserInputFromConsole();
        GameGenerator gameGenerator = new GameGenerator(userInputFromConsole, System.out);
        GameRunner gameRunnerType = gameGenerator.tryGetGameRunnerType();
        gameRunnerType.trySetCurrentPlayer();
        gameRunnerType.startGame();
    }

}
