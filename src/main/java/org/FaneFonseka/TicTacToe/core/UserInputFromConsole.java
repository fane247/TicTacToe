package org.FaneFonseka.TicTacToe.core;

import java.util.Scanner;

/**
 * Created by Fane on 30/01/2017.
 */
public class UserInputFromConsole implements UserInput{

    private Scanner scanner;


    UserInputFromConsole() {

        scanner = new Scanner(System.in);

    }

    @Override
    public int getGameMode() {

        return scanner.nextInt();

    }

    @Override
    public int getCurrentPlayerSelection() {
        return scanner.nextInt();
    }

    @Override
    public String getString() {

        return scanner.next();

    }

    @Override
    public String getMove() {
        return scanner.next();
    }


    public void flush() {

        scanner.nextLine();
    }


}
