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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ControllerGameScreen {
    private Stage primaryStage;
    private ControllerMainScreen controllerMainScreen;
    private Solution solution;
    private Grid grid;
    private int scoreCount;
    private int solutionSize;

    @FXML
    private GridPane gridLayout;

    @FXML
    private Button homeButton;

    @FXML
    private TextField inputField;

    @FXML
    private Label score;

    @FXML
    private Label theme;

    @FXML
    private Button solutionButton;

    @FXML
    private Label moreText;

    private String finalTheme;
    private int finalAmount;
    private String[] words;
    

    public ControllerGameScreen(Stage primaryStage, ControllerMainScreen controllerMainScreen) throws IOException {
        this.primaryStage = primaryStage;
        this.controllerMainScreen = controllerMainScreen;
        this.finalAmount = controllerMainScreen.getAmount();
        this.finalTheme = controllerMainScreen.getTheme();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("GameScreen.fxml"));
        loader.setController(this);

        primaryStage.setScene(new Scene(loader.load()));
    }

    public void show() {
        primaryStage.show();
    }

    public ControllerGameScreen(Stage primaryStage, String theme, String[] words, int finalAmount) throws IOException {
        this.primaryStage = primaryStage;
        this.finalTheme = theme;
        this.words = words;
        this.finalAmount = finalAmount;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("GameScreen.fxml"));
        loader.setController(this);

        primaryStage.setScene(new Scene(loader.load()));

    }

    @FXML
    public void initialize() {
        score.setText("Score: 0/"+finalAmount);
        theme.setText(finalTheme);

        if (controllerMainScreen != null) {
            Solution solution = new Solution(finalTheme, finalAmount);
            this.solution = solution;
        }
        else {
            Solution solution = new Solution(words);
            this.solution = solution;
        }

        solutionSize = solution.size();

        Grid grid = new Grid(solution);
        this.grid = grid;
        System.out.println(grid.getWordCoordinates().keySet());
        System.out.println(grid.getWordCoordinates().values());

        gridLayout.getColumnConstraints().remove(0);
        gridLayout.getRowConstraints().remove(0);

        gridLayout.setVgap(7);
        gridLayout.setHgap(16);
        gridLayout.setPadding(new Insets(10, 10, 10, 10));


        for (int i = 0; i < grid.getGrid().length; i++) {
            for (int j = 0; j < grid.getGrid().length; j++) {
                Label letter = new Label(Character.toString(grid.getGrid()[i][j]));

                letter.setFont(new Font(10.5));

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
            if (word.toLowerCase().equals(inputField.getText().strip().toLowerCase())) {
                int positionX = Integer.parseInt(grid.getWordCoordinates().get(word.toLowerCase())[0]);
                int positionY = Integer.parseInt(grid.getWordCoordinates().get(word.toLowerCase())[1]);
                char direction = grid.getWordCoordinates().get(word.toLowerCase())[2].charAt(0);
                
                for (int i = 0; i < word.length(); i ++) {
                    Label letter = new Label(Character.toString(word.toLowerCase().charAt(i)));
                    letter.setFont(Font.font("System", FontWeight.BOLD, 10.5));

                    if (direction == 'v') {
                        GridPane.setConstraints(letter, positionX, positionY+i);
                    }
                    else {
                        GridPane.setConstraints(letter, positionX+i, positionY);
                    }

                    gridLayout.getChildren().add(letter);
                }
                

                inputField.setText(null);

                scoreCount ++;

                if (scoreCount == solutionSize) {
                    inputField.visibleProperty().set(false);
                    inputField.editableProperty().set(false);
                    moreText.setText("Well done!");
                    moreText.setVisible(true);
                }

                score.setText("Score "+Integer.toString(scoreCount)+"/"+finalAmount);

                solution.getSolution().remove(word);
                break;
            }
        }
    }

    @FXML
    public void showSolutionClick() {
        inputField.visibleProperty().set(false);
        inputField.editableProperty().set(false);
        moreText.setText("No more geussing now!");
        moreText.setVisible(true);

        for (String word : solution.getSolution()) {
            int positionX = Integer.parseInt(grid.getWordCoordinates().get(word.toLowerCase())[0]);
            int positionY = Integer.parseInt(grid.getWordCoordinates().get(word.toLowerCase())[1]);
            char direction = grid.getWordCoordinates().get(word.toLowerCase())[2].charAt(0);
            
            for (int i = 0; i < word.length(); i ++) {
                Label letter = new Label(Character.toString(word.toLowerCase().charAt(i)));
                letter.setFont(Font.font("System", FontWeight.BOLD, 10.5));

                if (direction == 'v') {
                    GridPane.setConstraints(letter, positionX, positionY+i);
                }
                else {
                    GridPane.setConstraints(letter, positionX+i, positionY);
                }

                gridLayout.getChildren().add(letter);
            }
        }
    }

}
