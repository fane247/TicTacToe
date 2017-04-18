package org.FaneFonseka.TicTacToe.core;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Fane on 01/03/2017.
 */
public class PointTest {

    @Test
    public void whenGivenAPointGettersRetrieveAssignedCoordinates() {

        int expectedX = 1;
        int expectedY = 2;

        org.FaneFonseka.TicTacToe.core.Point point = new org.FaneFonseka.TicTacToe.core.Point(expectedX, expectedY);

        int actualX = point.getX();
        int actualY = point.getY();

        assertEquals(actualX, expectedX);
        assertEquals(actualY, expectedY);
    }

}