package org.FaneFonseka.TicTacToe;

import java.io.PrintStream;

/**
 * Created by Fane on 27/02/2017.
 */
public class ComputerVsComputerGameRunner extends GameRunner {

    public ComputerVsComputerGameRunner(UserInput userInput, PrintStream printStream) {

        super(userInput, printStream);
    }

    @Override
    public void setPlayers() {

        player1 = new UnbeatableComputerPlayer(MarkSymbol.X, this.gameBoard);
        player2 = new UnbeatableComputerPlayer(MarkSymbol.O, this.gameBoard);

    }
}
