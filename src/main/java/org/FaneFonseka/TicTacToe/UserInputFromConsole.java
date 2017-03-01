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

        int i = scanner.nextInt();
        return i;

    }

    @Override
    public String getString() {
//todo this returns null, any reason?
        scanner.next();
        return null;

    }


    public void flush() {

        scanner.nextLine();
    }


}
