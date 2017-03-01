package org.FaneFonseka.TicTacToe;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Created by Fane on 27/02/2017.
 */
public class BlankPrintStream extends PrintStream {

    public BlankPrintStream(OutputStream out) {
        super(out);
    }

    @Override
    public void println() {

    }


}
