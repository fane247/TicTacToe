package org.FaneFonseka.TicTacToe;

import java.util.Scanner;

/**
 * Created by Fane on 30/01/2017.
 */
public class UserInputFromConsole implements UserInput{

    @Override
    public int getInt() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();

    }



}
