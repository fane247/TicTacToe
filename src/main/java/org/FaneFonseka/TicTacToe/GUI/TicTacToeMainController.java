package org.FaneFonseka.TicTacToe.GUI;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.FaneFonseka.TicTacToe.core.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Fane on 20/04/2017.
 */
public class TicTacToeMainController extends Application {

    private final GameRunner gameRunner;
    private Parent root;
    private final GameBoard gameBoard;

    @FXML
    private ImageView cell00;
    @FXML
    private ImageView cell10;
    @FXML
    private ImageView cell20;
    @FXML
    private ImageView cell01;
    @FXML
    private ImageView cell11;
    @FXML
    private ImageView cell21;
    @FXML
    private ImageView cell02;
    @FXML
    private ImageView cell12;
    @FXML
    private ImageView cell22;
    private List<List<ImageView>> grid;


    public TicTacToeMainController(GameRunner gameRunner) {


        this.gameRunner = gameRunner;
        gameBoard = gameRunner.gameBoard;

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/TicTacToeMainView.fxml"));

        TicTacToeMainController ticTacToeMainController = new TicTacToeMainController(gameRunner);
        fxmlLoader.setController(ticTacToeMainController);

        root = fxmlLoader.load();
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        initialise();

        if (gameRunner.getCurrentPlayer() instanceof UnbeatableComputerPlayer) {

            playOneRound();
        }

    }

    private void initialise() {

        grid = new ArrayList<>();

        grid.add(new ArrayList<>());
        grid.add(new ArrayList<>());
        grid.add(new ArrayList<>());

        ObservableList<Node> childrenUnmodifiable = root.getChildrenUnmodifiable();

        for (Node imageViewNode : childrenUnmodifiable) {

            if (imageViewNode instanceof ImageView) {

                String id = imageViewNode.getId();
                System.out.println("Node: " + imageViewNode.toString());

                int x = Character.getNumericValue(id.charAt(0));
                int y = Character.getNumericValue(id.charAt(1));

                System.out.println("x: " + x);
                System.out.println("y: " + y);

                grid.get(y).add(x, (ImageView) imageViewNode);
            }
        }


    }

    private void updateView() {

        List<List<MarkSymbol>> board = gameBoard.getBoard();

        for (int i = 0; i < board.size(); i++) {

            List<MarkSymbol> markSymbols = board.get(i);

            for (int j = 0; j < markSymbols.size(); j++) {

                MarkSymbol markSymbol = markSymbols.get(j);


                if (markSymbol.equals(MarkSymbol.X)) {

                    ImageView imageView = grid.get(i).get(j);
                    imageView.setImage(new Image("images/X.png"));

                }

                if (markSymbol.equals(MarkSymbol.O)) {


                    ImageView imageView = grid.get(i).get(j);
                    imageView.setImage(new Image("images/O.png"));

                }

                if (markSymbol.equals(MarkSymbol.BLANK)) {

                    ImageView imageView = grid.get(i).get(j);
                    imageView.setImage(new Image("images/BLANK.png"));

                }

            }

        }

    }

    public static void main(String[] args) {

        launch(args);
    }


    public void playOneRound() throws IOException {


        gameRunner.playOneRound();
        updateView();


        if (gameRunner.gameIsOver()) {

            playAgainDialogue();
        }

        if (gameRunner.getCurrentPlayer() instanceof UnbeatableComputerPlayer) {

            playOneRound();

        }


    }

    private void playAgainDialogue() throws IOException {

        Stage stage = new Stage();
        Parent dialogueRoot = FXMLLoader.load(getClass().getResource("/PlayAgainDialogue.fxml"));
        stage.setScene(new Scene(dialogueRoot));
        stage.setTitle("My modal window");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(this.root.getScene().getWindow());
        stage.showAndWait();


    }

    private void playAgainHandler(ActionEvent e){

        System.out.println(e.getSource().toString());



    }

    private void restartGame(){

        gameRunner.setupGame();


    }


}
