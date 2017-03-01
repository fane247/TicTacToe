package org.FaneFonseka.TicTacToe;

/**
 * Created by Fane on 23/01/2017.
 */
public class HumanPlayer extends Player {

    private final UserInput userInput;

    HumanPlayer(MarkSymbol markSymbol, UserInput userInput) {
        super(markSymbol);
        this.userInput = userInput;
    }

    @Override
    public Point getMove() throws IllegalMoveException {

        int move = getInput();

        if (move >= 100 || move < 10) {

            throw new IllegalMoveException();
        }

        int x = move % 10;
        move /= 10;
        int y = move % 10;

        return new Point(x, y);

    }


    int getInput() {

        return userInput.getInt();
    }


}
