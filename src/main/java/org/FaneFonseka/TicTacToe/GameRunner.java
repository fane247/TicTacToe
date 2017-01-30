package org.FaneFonseka.TicTacToe;

/**
 * Created by Fane on 13/01/2017.
 */
public class GameRunner {

    private GameBoard gameBoard;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private WinChecker winChecker;
    private UserInput userInputFromConsole;

    GameRunner(UserInput userInput) {

        this.gameBoard = new GameBoard();
        this.userInputFromConsole = userInput;
    }

    public void selectGameType() {

        System.out.println("select players: ");
        System.out.println("Please enter a number");
        System.out.println();

        System.out.println("1. Human vs Human");
        System.out.println("2. Computer vs Computer");
        System.out.println("3. Human vs Computer");
        System.out.println();

        int selection = userInputFromConsole.getInt();

        switch (selection) {

            case 1:
                setPlayer1(new HumanPlayer(MarkSymbol.X));
                setPlayer2(new HumanPlayer(MarkSymbol.O));
                System.out.println("1. Human vs Human selected");
                break;

            case 2:
                setPlayer1(new UnbeatableComputerPlayer(MarkSymbol.X, this.gameBoard));
                setPlayer2(new UnbeatableComputerPlayer(MarkSymbol.O, this.gameBoard));
                System.out.println("2. Computer vs Computer selected");
                break;

            case 3:
                setPlayer1(new HumanPlayer(MarkSymbol.O));
                setPlayer2(new UnbeatableComputerPlayer(MarkSymbol.X, this.gameBoard));
                System.out.println("3. Human vs Computer selected");
                break;
            default:
                throw new IllegalArgumentException();
        }

    }

    public void trySetCurrentPlayer() {

        boolean isInvalidSelection = true;

        while(isInvalidSelection) {

            try {
                setCurrentPlayer();
                isInvalidSelection = false;

            } catch (IllegalArgumentException e) {

                System.out.println("Invalid selection");
                System.out.println("please choose again");
                System.out.println();

            }
        }

    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setCurrentPlayer() {

        System.out.println("Who you like to go first?");
        System.out.println("Please select a number");
        System.out.println();
        System.out.println("1. player 1?");
        System.out.println("2. player 2?");
        System.out.println();

        int selection = userInputFromConsole.getInt();

        switch (selection) {

            case 1:
                currentPlayer = player1;
                System.out.println("player 1 to start!");
                break;

            case 2:
                currentPlayer = player2;
                System.out.println("Player 2 to start!");
                break;

            default:
                throw new IllegalArgumentException();

        }

    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setPlayer1(Player player) {

        player1 = player;

    }


    public void setPlayer2(Player player) {

        player2 = player;
    }

    public void startGame() throws InvalidCellException {

        GameBoardPrinter gameBoardPrinter = new GameBoardPrinter(gameBoard);

        System.out.println("make your selection in the for xy");
        System.out.println("for example the bottom right square would be 22");
        System.out.println();

        while (!gameIsWon()) {

            System.out.println(currentPlayer.markSymbol + "'s move");
            gameBoardPrinter.printGameBoard();
            tryMove();
            swapPlayer();
        }

        gameBoardPrinter.printGameBoard();
        System.out.println(winChecker.announceWinner());

    }

    public void swapPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public void tryMove() {

        boolean invalidMove = true;

        while (invalidMove) {

            try {
                gameBoard.placePlayersMove(currentPlayer);
                invalidMove = false;

            } catch (InvalidCellException|IndexOutOfBoundsException e) {
                System.out.println("Not a valid move");
                System.out.println("Please try again");

            }
        }
    }

    private Boolean gameIsWon() {

        winChecker = new WinChecker(this.gameBoard);
        return winChecker.gameIsOver();

    }


    public static void main(String[] args) throws InvalidCellException {

        UserInputFromConsole userInputFromConsole = new UserInputFromConsole();
        GameRunner gameRunner = new GameRunner(userInputFromConsole);
        gameRunner.selectGameType();
        gameRunner.setCurrentPlayer();
        gameRunner.startGame();

    }

}
