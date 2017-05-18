package org.FaneFonseka.TicTacToe.GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import org.FaneFonseka.TicTacToe.core.GameGenerator;
import org.FaneFonseka.TicTacToe.core.GameRunner;


/**
 * Created by Fane on 24/03/2017.
 */
public class GameOptionsController extends Application {

    @FXML
    private ToggleGroup gameTypeGroup;
    @FXML
    private ToggleGroup currentPlayerGroup;


    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/GameOptionsView.fxml"));

        Scene scene = new Scene(root, 250, 250);

        primaryStage.setTitle("Game Options");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }



    public static void main(String[] args) {
        launch(args);
    }


    public void startGame(ActionEvent e) throws Exception {

        UserInputFromGUI userInputFromGUI = getUserInputFromGUI();
        TicTacToeMainController ticTacToeMainController = getTicTacToeMainController(userInputFromGUI);
        userInputFromGUI.setTicTacToeMainController(ticTacToeMainController);

        Stage stage = new Stage();
        ticTacToeMainController.start(stage);

        ((Node)(e.getSource())).getScene().getWindow().hide();

    }

    private TicTacToeMainController getTicTacToeMainController(UserInputFromGUI userInputFromGUI) {
        GameGenerator gameGenerator = new GameGenerator(userInputFromGUI, System.out);
        GameRunner gameRunner = gameGenerator.tryGetGameRunnerType();
        gameRunner.trySetCurrentPlayer();
        return new TicTacToeMainController(gameRunner);
    }

    private UserInputFromGUI getUserInputFromGUI() {
        RadioButton selectedPlayerRB = (RadioButton) currentPlayerGroup.getSelectedToggle();
        String selectedPlayer = selectedPlayerRB.getText();

        RadioButton selectedGameTypeRB = (RadioButton) gameTypeGroup.getSelectedToggle();
        String selectedGameType = selectedGameTypeRB.getText();

        return new UserInputFromGUI(selectedGameType, selectedPlayer);
    }


}
