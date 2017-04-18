package org.FaneFonseka.TicTacToe.core;

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

        String move = userInput.getMove();

        if (move.length() > 2 || move.length() <= 1) {

            throw new IllegalMoveException();
        }

        int x = Character.getNumericValue(move.charAt(0));
        int y = Character.getNumericValue(move.charAt(1));

        return new Point(x, y);

    }


    String getInput() {

        return userInput.getString();
    }




}
