package org.FaneFonseka.TicTacToe.core;

import java.io.PrintStream;

/**
 * Created by Fane on 27/02/2017.
 */
public class HumanVsComputerGameRunner extends GameRunner {

    public HumanVsComputerGameRunner(UserInput userInput, PrintStream printStream) {

        super(userInput, printStream);
    }

    @Override
    public void setPlayers() {

        player1 = new HumanPlayer(MarkSymbol.X, this.userInput);
        player2 = new UnbeatableComputerPlayer(MarkSymbol.O, this.gameBoard);
    }
}
