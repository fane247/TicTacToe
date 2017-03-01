package org.FaneFonseka.TicTacToe;

import java.io.PrintStream;
import java.util.InputMismatchException;

/**
 * Created by Fane on 25/02/2017.
 */
public abstract class GameRunner {

    public UserInput userInput;
    private final PrintStream printStream;
    public Player player1;
    public Player player2;
    public GameBoard gameBoard;
    private Player currentPlayer;
    private WinChecker winChecker;
    public Boolean userWantsRematch;

    public GameRunner(UserInput userInput, PrintStream printStream) {

        this.printStream = printStream;
        this.userInput = userInput;
        gameBoard = new GameBoard();
        winChecker = new WinChecker(gameBoard);
        setPlayers();
    }

    public abstract void setPlayers();

    public void trySetCurrentPlayer() {

        boolean isInvalidSelection = true;

        while (isInvalidSelection) {

            try {
                setCurrentPlayer();
                isInvalidSelection = false;

            } catch (IllegalArgumentException | InputMismatchException e) {

                printStream.println("Invalid selection");
                printStream.println("please choose again");
                printStream.println();

            }
        }

    }

    public void setCurrentPlayer() {

        printStream.println("Who you like to go first?");
        printStream.println("Please select a number");
        printStream.println();
        printStream.println("1. player 1?");
        printStream.println("2. player 2?");
        printStream.println();

        int selection = userInput.getInt();

        switch (selection) {

            case 1:
                currentPlayer = player1;
                currentPlayer.setMarkSymbol(MarkSymbol.X);
                player2.setMarkSymbol(MarkSymbol.O);
                printStream.println("player 1 to start!");
                break;

            case 2:
                currentPlayer = player2;
                currentPlayer.setMarkSymbol(MarkSymbol.X);
                player1.setMarkSymbol(MarkSymbol.O);
                printStream.println("Player 2 to start!");
                break;

            default:
                throw new IllegalArgumentException();

        }

    }

    public void startGame() throws InvalidCellException {

        GameBoardFormatter gameBoardFormatter = new GameBoardFormatter(gameBoard);

        userWantsRematch = true;

        while (userWantsRematch) {

            printStream.println("make your selection in the for xy");
            printStream.println("for example the bottom right square would be 22");
            printStream.println();

            while (!gameIsOver()) {

                printStream.println(currentPlayer.markSymbol + "'s move");
                printStream.println(gameBoardFormatter.getFormattedGameBoard());
                tryMove();
                swapPlayer();
            }

            printStream.println(gameBoardFormatter.getFormattedGameBoard());
            printStream.println(winChecker.announceWinner());

            tryPlayAgain();

        }

    }

    private Boolean gameIsOver() {

        winChecker = new WinChecker(this.gameBoard);
        return winChecker.gameIsOver();

    }


    public void tryMove() {

        boolean invalidMove = true;

        while (invalidMove) {

            try {
                gameBoard.placePlayersMove(currentPlayer);
                invalidMove = false;

            } catch (InvalidCellException | IndexOutOfBoundsException | IllegalMoveException | InputMismatchException e) {
                printStream.println("Not a valid move");
                printStream.println("Please try again");

            }
        }
    }

    public void swapPlayer() {

        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }



    public void tryPlayAgain() {

        boolean isInvalidSelection = true;

        while (isInvalidSelection) {

            try {
                playAgain();
                isInvalidSelection = false;

            } catch (IllegalArgumentException e) {

                printStream.println("Invalid selection");
                printStream.println("please choose again");
                printStream.println();

            }
        }

    }

    private void playAgain() {

        printStream.println("would you like to play again");
        printStream.println("y/n");


        String rematchResponse = userInput.getString().toLowerCase();

        switch (rematchResponse) {

            case "y":
                userWantsRematch = true;
                break;

            case "n":
                userWantsRematch = false;
                break;

            default:
                throw new IllegalArgumentException();

        }

    }


    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }






}
