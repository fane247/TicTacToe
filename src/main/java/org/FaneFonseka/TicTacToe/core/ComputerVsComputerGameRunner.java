package org.FaneFonseka.TicTacToe.core;

import java.io.PrintStream;

/**
 * Created by Fane on 27/02/2017.
 */
class ComputerVsComputerGameRunner extends GameRunner {

    ComputerVsComputerGameRunner(UserInput userInput, PrintStream printStream) {

        super(userInput, printStream);
    }

    @Override
    void setPlayers() {

        player1 = new UnbeatableComputerPlayer(MarkSymbol.X, this.gameBoard);
        player2 = new UnbeatableComputerPlayer(MarkSymbol.O, this.gameBoard);

    }
}
