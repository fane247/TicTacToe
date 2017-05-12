package org.FaneFonseka.TicTacToe.GUI;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.FaneFonseka.TicTacToe.core.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fane on 20/04/2017.
 */
public class TicTacToeMainController extends Application {

    private final UserInput userInput;
    private String move;
    private GameRunner gameRunner;
    private Parent root;

    public TicTacToeMainController(GameRunner gameRunner) {

        this.gameRunner = gameRunner;
        this.gameBoard = gameRunner.gameBoard;
        userInput = gameRunner.getUserInput();

    }

    public void setGameRunner(GameRunner gameRunner) {
        this.gameRunner = gameRunner;
    }



    public void setGameBoard(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    private GameBoard gameBoard;

//    @FXML
//    private ImageView cell00;
//    @FXML
//    private ImageView cell10;
//    @FXML
//    private ImageView cell20;
//    @FXML
//    private ImageView cell01;
//    @FXML
//    private ImageView cell11;
//    @FXML
//    private ImageView cell21;
//    @FXML
//    private ImageView cell02;
//    @FXML
//    private ImageView cell12;
//    @FXML
//    private ImageView cell22;

    private List<List<ImageView>> grid;


    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/TicTacToeMainView.fxml"));

        fxmlLoader.setController(this);

        root = fxmlLoader.load();
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        initialise();

        if (gameRunner.getCurrentPlayer() instanceof UnbeatableComputerPlayer) {

            tryPlayOneRound();
        }

    }

    private void initialise() {

        grid = new ArrayList<>();

        grid.add(new ArrayList<>());
        grid.add(new ArrayList<>());
        grid.add(new ArrayList<>());

        ObservableList<Node> childrenUnmodifiable = root.getChildrenUnmodifiable();

        for (Node node : childrenUnmodifiable) {

            if (node instanceof ImageView) {

                String id = node.getId();
//                System.out.println("Node: " + node.toString());

                int x = Character.getNumericValue(id.charAt(0));
                int y = Character.getNumericValue(id.charAt(1));

//                System.out.println("x: " + x);
//                System.out.println("y: " + y);

                grid.get(y).add(x, (ImageView) node);
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
                    addMouseEventHandler(imageView);

                }

                if (markSymbol.equals(MarkSymbol.O)) {


                    ImageView imageView = grid.get(i).get(j);
                    imageView.setImage(new Image("images/O.png"));
                    addMouseEventHandler(imageView);

                }

                if (markSymbol.equals(MarkSymbol.BLANK)) {

                    ImageView imageView = grid.get(i).get(j);
                    imageView.setImage(new Image("images/BLANK.png"));
                    addMouseEventHandler(imageView);

                }

            }

        }

    }

    private void addMouseEventHandler(ImageView imageView) {
        imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                System.out.println("Tile pressed ");
                event.consume();
            }
        });
    }

    public static void main(String[] args) {

        launch(args);
    }


    private void playOneRound() throws IOException, InvalidCellException, IllegalMoveException {


        gameRunner.playOneGUIRound();
        updateView();


        if (gameRunner.gameIsOver()) {

            playAgainDialogue();
        }

        if (gameRunner.getCurrentPlayer() instanceof UnbeatableComputerPlayer && !gameRunner.gameIsOver()) {

            playOneRound();

        }


    }

    public void tryPlayOneRound(){

        try {
            playOneRound();
        } catch (InvalidCellException | IllegalMoveException e) {

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Invalid Move");
            alert.setHeaderText(null);
            alert.setContentText("this cell is already taken, please choose another");
            alert.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void playAgainDialogue() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/PlayAgainDialogue.fxml"));

        fxmlLoader.setController(this);

        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.initOwner(this.root.getScene().getWindow());
        primaryStage.setResizable(false);
        primaryStage.showAndWait();


    }

    private void playAgainHandler(ActionEvent e) {

        System.out.println(e.getSource().toString());


    }

    @FXML
    private void restartGame(ActionEvent e) throws Exception {
//
//        GameOptionsController gameOptionsController = new GameOptionsController();
//        gameOptionsController.start(new Stage());

        System.out.println("Target: " + e.getTarget());
        System.out.println();
        System.out.println("Source: " + e.getSource());
        System.out.println();

        Button response = (Button) e.getSource();


        switch (response.getId()) {

            case "yes":
                GameOptionsController gameOptionsController = new GameOptionsController();
                gameOptionsController.start(new Stage());
                root.getScene().getWindow().hide();
                ((Node)(e.getSource())).getScene().getWindow().hide();
                break;

            case "no":
                root.getScene().getWindow().hide();
                ((Node)(e.getSource())).getScene().getWindow().hide();
                break;

        }

    }

    @FXML
    private void playOneMove(ActionEvent e) throws IOException {

        Button cell = (Button) e.getSource();
        String id = cell.getId();
        setMove(id);


        tryPlayOneRound();

    }


    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }
}
