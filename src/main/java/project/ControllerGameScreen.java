package project;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ControllerGameScreen {
    private Stage primaryStage;
    private ControllerMainScreen controllerMainScreen;

    @FXML
    private GridPane gridLayout;

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
        Solution solution = new Solution(controllerMainScreen.getTheme(), controllerMainScreen.getAmount());
        Grid grid = new Grid(solution);

        gridLayout.getColumnConstraints().remove(0);
        gridLayout.getRowConstraints().remove(0);

        gridLayout.setVgap(10);
        gridLayout.setHgap(15);
        gridLayout.setPadding(new Insets(10, 10, 10, 10));

        for (int i = 0; i < grid.getGrid().length; i++) {
            for (int j = 0; j < grid.getGrid().length; j++) {
                Label letter = new Label(Character.toString(grid.getGrid()[i][j]));
                letter.setFont(new Font(12.0));
                GridPane.setConstraints(letter, 0+j, 0+i);
                gridLayout.getChildren().add(letter);
                
            }
        }

        gridLayout.setAlignment(Pos.CENTER);

        
    }
}
