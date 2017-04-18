package org.FaneFonseka.TicTacToe.GUI;

import com.jgoodies.forms.builder.PanelBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Fane on 30/03/2017.
 */
public class XOGridBuilder implements ActionListener {


    private final UserInputFromGUI userInputFromGUI;
    private JButton jButton00;
    private JButton jButton10;
    private JButton jButton20;
    private JButton jButton01;
    private JButton jButton11;
    private JButton jButton21;
    private JButton jButton02;
    private JButton jButton12;
    private JButton jButton22;


    XOGridBuilder(UserInputFromGUI userInputFromGUI){

        this.userInputFromGUI = userInputFromGUI;

    }


    JPanel buildPanel() {
        buildButtons();

        FormLayout formLayout = new FormLayout("300px, 300px, 300px",
                "300px, 300px, 300px");

        PanelBuilder builder = new PanelBuilder(formLayout);
        builder.setDefaultDialogBorder();

        CellConstraints cc = new CellConstraints();

        jButton00.setPreferredSize(new Dimension(300,300));
        jButton10.setPreferredSize(new Dimension(300,300));
        jButton20.setPreferredSize(new Dimension(300,300));

        jButton01.setPreferredSize(new Dimension(300,300));
        jButton11.setPreferredSize(new Dimension(300,300));
        jButton21.setPreferredSize(new Dimension(300,300));

        jButton02.setPreferredSize(new Dimension(300,300));
        jButton12.setPreferredSize(new Dimension(300,300));
        jButton22.setPreferredSize(new Dimension(300,300));


        builder.add(jButton00, cc.xyw(1, 1, 1));
        builder.add(jButton10, cc.xyw(2, 1, 1));
        builder.add(jButton20, cc.xyw(3, 1, 1));

        builder.add(jButton01, cc.xyw(1, 2, 1));
        builder.add(jButton11, cc.xyw(2, 2, 1));
        builder.add(jButton21, cc.xyw(3, 2, 1));

        builder.add(jButton02, cc.xyw(1, 3, 1));
        builder.add(jButton12, cc.xyw(2, 3, 1));
        builder.add(jButton22, cc.xyw(3, 3, 1));

        return builder.getPanel();

    }

    private void buildButtons() {

        jButton00 = new JButton("00");
        jButton10 = new JButton("10");
        jButton20 = new JButton("20");

        jButton01 = new JButton("01");
        jButton11 = new JButton("11");
        jButton21 = new JButton("21");

        jButton02 = new JButton("02");
        jButton12 = new JButton("12");
        jButton22 = new JButton("22");

        jButton00.addActionListener(userInputFromGUI);
        jButton01.addActionListener(userInputFromGUI);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

//        System.out.println(e.getSource().toString());

        System.out.println(e.getActionCommand());

    }

}
