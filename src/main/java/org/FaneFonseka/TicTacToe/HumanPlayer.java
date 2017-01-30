package org.FaneFonseka.TicTacToe;

import java.awt.*;
import java.util.Scanner;

/**
 * Created by Fane on 23/01/2017.
 */
public class HumanPlayer extends Player {

    HumanPlayer(MarkSymbol markSymbol) {
        super(markSymbol);
    }

    @Override
    public Point getMove() {

        String move = getInput();

        int x = Character.getNumericValue(move.charAt(0));

        int y = Character.getNumericValue(move.charAt(1));

        return new Point(x, y);

    }

    String getInput() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

}
