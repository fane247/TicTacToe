package org.FaneFonseka.TicTacToe;

import java.io.PrintStream;

/**
 * Created by Fane on 27/02/2017.
 */
public class HumanVsHumanGameRunner extends GameRunner {


    public HumanVsHumanGameRunner(UserInput userInput, PrintStream printStream) {

        super(userInput, printStream);
    }

    @Override
    public void setPlayers() {

        player1 = new HumanPlayer(MarkSymbol.X);
        player2 = new HumanPlayer(MarkSymbol.O);

    }


}
