package org.FaneFonseka.TicTacToe;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by Fane on 01/03/2017.
 */
public class PointTest {

    @Test
    public void whenGivenAPointGettersRetrieveAssignedCoordinates() {

        int expectedX = 1;
        int expectedY = 2;

        Point point = new Point(expectedX, expectedY);

        int actualX = point.getX();
        int actualY = point.getY();

        assertEquals(actualX, expectedX);
        assertEquals(actualY, expectedY);
    }

}