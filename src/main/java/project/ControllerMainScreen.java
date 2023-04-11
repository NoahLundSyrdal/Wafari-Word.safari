package project;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class ControllerMainScreen {
    private Stage primaryStage;

    @FXML
    private ComboBox<String> theme;
    @FXML
    private ComboBox<Integer> amount;
    @FXML
    private Button createButton;

    public ControllerMainScreen(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
        loader.setController(this);

        primaryStage.setScene(new Scene(loader.load()));
        primaryStage.setResizable(false);
    }
    
    public void show() {
        this.primaryStage.show();
    }

    @FXML
    public void initialize() {
        theme.getItems().addAll("Animals","Sports","Colors","Countries","Fruits","Capital Cities","Video Games","Football Teams","Mountains","Rivers","Easter","Halloween","Christmas","Music","Science","Nature","Landmarks","Creatures","Jobs","Planets","Languages","Insects");
        amount.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
    }
    
    @FXML
    public void buttonOnClick() throws IOException{
        if(theme.getValue()!= null && amount.getValue()!=null) {
            ControllerGameScreen controllerGameScreen = new ControllerGameScreen(this.primaryStage, this);
            controllerGameScreen.show();

        }
    } 

    public String getTheme() {
        return theme.getValue();
    }

    public int getAmount() {
        return amount.getValue();
    }

}

