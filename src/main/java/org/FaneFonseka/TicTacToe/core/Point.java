package org.FaneFonseka.TicTacToe.core;

/**
 * Created by Fane on 23/02/2017.
 */
public class Point {

    private int x;
    private int y;

    Point(int x, int y) {

        this.x = x;
        this.y = y;

    }


    int getY() {

        return y;
    }


    int getX() {

        return x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;
    }

    @Override
    public String toString() {
        return "X= " + x + ", Y= " + y;
    }
}
