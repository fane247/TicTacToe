package org.FaneFonseka.TicTacToe.GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Created by Fane on 24/03/2017.
 */
public class GameOptionsController extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/GameOptionsView.fxml"));

        Scene scene = new Scene(root, 250, 200);

        primaryStage.setTitle("Game Options");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }



//    public static void main(String[] args) {
//        launch(args);
//    }


    public void startGame(ActionEvent e){

        System.out.println("game Started");

    }


}
