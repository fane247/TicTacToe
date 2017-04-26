package org.FaneFonseka.TicTacToe.core;

import java.io.PrintStream;
import java.util.InputMismatchException;

/**
 * Created by Fane on 25/02/2017.
 */
public abstract class GameRunner {

    UserInput userInput;
    private final PrintStream printStream;
    Player player1;
    Player player2;
    public GameBoard gameBoard;
    private Player currentPlayer;
    private WinChecker winChecker;
    Boolean userWantsRematch;
    private GameBoardFormatter gameBoardFormatter;

    public GameRunner(UserInput userInput, PrintStream printStream) {

        this.printStream = printStream;
        this.userInput = userInput;
        gameBoard = new GameBoard();
        winChecker = new WinChecker(gameBoard);
        userWantsRematch = true;
        setPlayers();
        gameBoardFormatter = new GameBoardFormatter(gameBoard);
    }

    abstract void setPlayers();

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
                userInput.flush();
            }
        }

    }

    private void setCurrentPlayer() {

        printStream.println("Who you like to go first?");
        printStream.println("Please select a number");
        printStream.println();
        printStream.println("1. player 1?");
        printStream.println("2. player 2?");
        printStream.println();

        int selection = userInput.getGameMode();

        System.out.println();
        System.out.println("user selection: " + selection);

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

            announceWinner();

            tryPlayAgain();

        }

    }

    //re-arranging startGame method
    //todo check tests are still relevant and if necessary write new ones

    public void setupGame(){

        gameBoardFormatter = new GameBoardFormatter(gameBoard);
        userWantsRematch = true;

        printStream.println("make your selection in the for xy");
        printStream.println("for example the bottom right square would be 22");
        printStream.println();

    }

    public void playOneRound(){

        printStream.println(currentPlayer.markSymbol + "'s move");
        printStream.println(gameBoardFormatter.getFormattedGameBoard());
        tryMove();
        swapPlayer();

    }

    public void announceWinner() {
        printStream.println(gameBoardFormatter.getFormattedGameBoard());
        printStream.println(winChecker.getWinner());
    }


    public Boolean gameIsOver() {

        winChecker = new WinChecker(this.gameBoard);
        return winChecker.gameIsOver();

    }


    private void tryMove() {

        boolean invalidMove = true;

        while (invalidMove) {

            try {
                gameBoard.placePlayersMove(currentPlayer);
                invalidMove = false;

            } catch (InvalidCellException | IllegalMoveException | IndexOutOfBoundsException | InputMismatchException e) {
                printStream.println("Not a valid move");
                printStream.println("Please try again");
                userInput.flush();

            }
        }
    }

    void swapPlayer() {

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
                gameBoard.clearBoard();
                break;

            case "n":
                userWantsRematch = false;
                break;

            default:
                throw new IllegalArgumentException();

        }

    }


    Player getPlayer1() {
        return player1;
    }

    Player getPlayer2() {
        return player2;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }






}
