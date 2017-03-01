package org.FaneFonseka.TicTacToe;

import java.util.Scanner;

/**
 * Created by Fane on 30/01/2017.
 */
public class UserInputFromConsole implements UserInput{

    private Scanner scanner;

    public UserInputFromConsole() {

        scanner = new Scanner(System.in);

    }

    @Override
    public int getInt() {

        return scanner.nextInt();

    }

    @Override
    public String getString() {

        scanner.next();
        return null;

    }


}
