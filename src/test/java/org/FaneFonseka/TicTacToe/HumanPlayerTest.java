package org.FaneFonseka.TicTacToe;

import org.junit.Test;

import java.awt.*;
import java.io.*;

import static org.junit.Assert.*;

/**
 * Created by Fane on 23/01/2017.
 */
public class HumanPlayerTest {


    @Test
    public void whenUserEntersCoordinatesInConsolePointIsReturnedWithEnteredCoordinates() throws FileNotFoundException {

        String userInput = "11";

        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        HumanPlayer humanPlayer = new HumanPlayer(MarkSymbol.X);

        Point actualMove = humanPlayer.getMove();

        System.setOut(System.out);

        System.out.println("Actual Moves" + actualMove);

        Point expectedPoint = new Point(1, 1);

        assert actualMove.equals(expectedPoint);


    }


}