package project;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ControllerGameScreen {
    private Stage primaryStage;
    private ControllerMainScreen controllerMainScreen;
    private Solution solution;
    private int scoreCount;

    @FXML
    private GridPane gridLayout;

    @FXML
    private Button homeButton;

    @FXML
    private TextField inputField;

    @FXML
    private Label score;
    

    public ControllerGameScreen(Stage primaryStage, ControllerMainScreen controllerMainScreen) throws IOException {
        this.primaryStage = primaryStage;
        this.controllerMainScreen = controllerMainScreen;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("GameScreen.fxml"));
        loader.setController(this);

        primaryStage.setScene(new Scene(loader.load()));
    }

    public void show() {
        primaryStage.show();
    }

    @FXML
    public void initialize() {
        score.setText("Score: 0/"+controllerMainScreen.getAmount());

        Solution solution = new Solution(controllerMainScreen.getTheme(), controllerMainScreen.getAmount());
        this.solution = solution;

        Grid grid = new Grid(solution);

        gridLayout.getColumnConstraints().remove(0);
        gridLayout.getRowConstraints().remove(0);

        gridLayout.setVgap(10);
        gridLayout.setHgap(20);
        gridLayout.setPadding(new Insets(10, 10, 10, 10));

        int fontSize = 22 - grid.getGrid().length;

        for (int i = 0; i < grid.getGrid().length; i++) {
            for (int j = 0; j < grid.getGrid().length; j++) {
                Label letter = new Label(Character.toString(grid.getGrid()[i][j]));

                letter.setFont(new Font(fontSize));

                GridPane.setConstraints(letter, 0+j, 0+i);
                gridLayout.getChildren().add(letter);
                
            }
        }

        gridLayout.setAlignment(Pos.CENTER);   
    }

    @FXML
    public void homeButtonClick() throws IOException {
        ControllerMainScreen controllerMainScreen = new ControllerMainScreen(primaryStage);
        controllerMainScreen.show();
    }

    @FXML
    public void inputFieldAction() {
        for (String word : solution.getSolution()) {
            if (word.toLowerCase().equals(inputField.getText())) {

                inputField.setText(null);

                scoreCount ++;

                if (scoreCount == solution.size()) {
                    inputField.setText("Well Done!");
                    inputField.editableProperty().set(false);
                }

                score.setText("Score "+Integer.toString(scoreCount)+"/"+controllerMainScreen.getAmount());
                break;
            }
        }
        

    }

}
