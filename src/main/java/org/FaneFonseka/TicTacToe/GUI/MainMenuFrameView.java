package org.FaneFonseka.TicTacToe.GUI;

import com.jgoodies.forms.builder.PanelBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Enumeration;

public class MainMenuFrameView extends JDialog implements Serializable {


    private final JFrame parent;
    JRadioButton humanVsHumanRadioButton;
    JRadioButton computerVsComputerRadioButton;
    JRadioButton humanVsComputerRadioButton;
    JRadioButton player1RadioButton;
    JRadioButton player2RadioButton;
    JButton startButton;
    ButtonGroup gameTypeRadioButtonMenuItem;
    ButtonGroup playerToStartRadioButtonMenuItem;

    public MainMenuFrameView(JFrame parent, Boolean modal) {
        super(parent,modal);
        this.parent = parent;

        buildPanel();

    }


    private void buildPanel() {

        buildButtons();

        FormLayout formLayout = new FormLayout("left:pref, 3dlu, center:pref, 3dlu,",
                "p, 30dlu, p, 30dlu, p, 30dlu, p,30dlu");

        PanelBuilder builder = new PanelBuilder(formLayout);
        builder.setDefaultDialogBorder();

        //Finally we add the components. We reuse a CellConstraints object for all cells.
        // Obtain a reusable constraints object to place components in the grid.
        CellConstraints cc = new CellConstraints();

        // Fill the grid with components; the builder can create
        // frequently used components, e.g. separators and labels.

        // Add a titled separator to cell (1, 1) that spans 7 columns.
        //builder.addSeparator("General",   cc.xyw(1,  1, 7));

        builder.addSeparator("Game Type", cc.xyw(1, 1, 4));
        builder.add(humanVsHumanRadioButton, cc.xyw(1, 2, 1));
        builder.add(computerVsComputerRadioButton, cc.xyw(1, 3, 1));
        builder.add(humanVsComputerRadioButton, cc.xyw(1, 4, 1));
        builder.addSeparator("Player to go first", cc.xyw(1, 5, 4));
        builder.add(player1RadioButton, cc.xyw(1, 6, 1));
        builder.add(player2RadioButton, cc.xyw(1, 7, 1));
        builder.add(startButton, cc.xyw(1, 8, 1));

        JPanel panel = builder.getPanel();
        add(panel);
        pack();

        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void buildButtons() {

        humanVsHumanRadioButton = new JRadioButton("Human Vs Human", true);
        computerVsComputerRadioButton = new JRadioButton("Computer vs Computer");
        humanVsComputerRadioButton = new JRadioButton("Human vs Computer");

        gameTypeRadioButtonMenuItem = new ButtonGroup();

        gameTypeRadioButtonMenuItem.add(humanVsHumanRadioButton);
        gameTypeRadioButtonMenuItem.add(computerVsComputerRadioButton);
        gameTypeRadioButtonMenuItem.add(humanVsComputerRadioButton);

        player1RadioButton = new JRadioButton("Player 1", true);
        player2RadioButton = new JRadioButton("Player 2");

        playerToStartRadioButtonMenuItem = new ButtonGroup();

        playerToStartRadioButtonMenuItem.add(player1RadioButton);
        playerToStartRadioButtonMenuItem.add(player2RadioButton);

        startButton = new JButton("start");

        startButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                Enumeration<AbstractButton> gameTypesElements = gameTypeRadioButtonMenuItem.getElements();

                String gameTypeString;
                int gameTypeSelection = 0;

                for (Enumeration<AbstractButton> buttons = gameTypesElements; buttons.hasMoreElements(); ) {
                    AbstractButton button = buttons.nextElement();
                    gameTypeSelection += 1;

                    if (button.isSelected()) {

                        gameTypeString = button.getText();
                        System.out.println("gameTypeString: " + gameTypeString);
                        System.out.println(gameTypeSelection);
                        break;
                    }
                }

                Enumeration<AbstractButton> playerToStartElements = playerToStartRadioButtonMenuItem.getElements();
                int playerToStart = 0;

                for (Enumeration<AbstractButton> buttons = playerToStartElements; buttons.hasMoreElements(); ) {
                    AbstractButton button = buttons.nextElement();
                    playerToStart += 1;

                    if (button.isSelected()) {

                        gameTypeString = button.getText();
                        System.out.println("playerToStartFirstSelection: " + gameTypeString);
                        System.out.println(playerToStart);
                        break;
                    }
                }

//                UserInputFromGUI userInputFromGUI = new UserInputFromGUI(playerToStart, gameTypeSelection);
//                GameGenerator gameGenerator = new GameGenerator(userInputFromGUI, System.out);
//                GameRunner gameRunner = gameGenerator.tryGetGameRunnerType();
//                gameRunner.trySetCurrentPlayer();
//
//                try {
//                    gameRunner.startGame();
//                } catch (InvalidCellException e1) {
//                    e1.getMessage();
//                }

                dispose();

            }

        });


    }

}






