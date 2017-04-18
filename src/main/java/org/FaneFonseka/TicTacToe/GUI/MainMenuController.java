package org.FaneFonseka.TicTacToe.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Fane on 24/03/2017.
 */
public class MainMenuController implements ActionListener{


    JFrame ticTacToe;

    MainMenuController(){

        ticTacToe = new JFrame();

    }

    public static void main(String[] args) {

        MainMenuController mainMenuController = new MainMenuController();
        JFrame ticTacToe = mainMenuController.ticTacToe;

        XOGridBuilder xoGridBuilder = new XOGridBuilder();
        JPanel xoGrid = xoGridBuilder.buildPanel();

        MainMenuFrameView mainMenuFrameView = new MainMenuFrameView(ticTacToe, true);
        mainMenuFrameView.setVisible(true);

        ticTacToe.setResizable(false);
        ticTacToe.setContentPane(xoGrid);
        ticTacToe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ticTacToe.pack();
        ticTacToe.setLocationRelativeTo(null);
        ticTacToe.setVisible(true);



    }


    @Override
    public void actionPerformed(ActionEvent e) {




    }
}
