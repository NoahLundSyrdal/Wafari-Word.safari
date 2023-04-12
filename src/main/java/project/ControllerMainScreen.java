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
    @FXML
    private Button customButton;

    private String finalTheme;
    private int finalAmount;

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
        FileManager fileManager = new FileManager();
        theme.getItems().addAll(fileManager.getAllThemes());
        amount.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
    }
    
    @FXML
    public void buttonOnClick() throws IOException{
        if(theme.getValue()!= null && amount.getValue()!=null) {
            finalAmount = amount.getValue();
            finalTheme = theme.getValue();

            ControllerGameScreen controllerGameScreen = new ControllerGameScreen(this.primaryStage, this);
            controllerGameScreen.show();

        }
    } 
    @FXML
    public void createCustomClick() throws IOException {
        ControllerCustomScreen controllerCustomScreen = new ControllerCustomScreen(this.primaryStage);
        controllerCustomScreen.show();

    }

    public String getTheme() {
        return finalTheme;
    }

    public int getAmount() {
        return finalAmount;
    }

}

