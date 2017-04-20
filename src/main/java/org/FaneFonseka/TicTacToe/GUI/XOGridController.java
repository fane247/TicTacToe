package org.FaneFonseka.TicTacToe.GUI;

import org.FaneFonseka.TicTacToe.core.GameBoard;

import javax.swing.*;

/**
 * Created by Fane on 24/03/2017.
 */

public class XOGridController extends JFrame{


    private final GameBoard gameBoard;

    public XOGridController(GameBoard gameBoard) {

        this.gameBoard=gameBoard;

        buildPanel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

    }

    private JPanel buildPanel() {

//        XOGridBuilder xoGridBuilder = new XOGridBuilder();
//
//        return xoGridBuilder.buildPanel();

        return null;

    }


}
