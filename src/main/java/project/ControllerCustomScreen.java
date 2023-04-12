package project;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerCustomScreen {
    private Stage primaryStage; 
    
    @FXML 
    private Button saveTheme;

    @FXML
    private Button playWafari;

    @FXML
    private TextField themeField;

    @FXML
    private TextArea wordsField;

    @FXML
    private Label message;


    public ControllerCustomScreen(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CreateCustomScreen.fxml"));
        loader.setController(this);

        primaryStage.setScene(new Scene(loader.load()));
    }

    public void show() {
        primaryStage.show();
    }

    @FXML
    public void homeButtonClick() throws IOException {
        ControllerMainScreen controllerMainScreen = new ControllerMainScreen(primaryStage);
        controllerMainScreen.show();

    }

    @FXML
    public void playWafariClick() throws IOException {
        String[] words = wordsField.getText().split("\n");
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));

        outerloop:
        if (words.length != wordSet.size()) {
            message.setText("No duplicated please.");
            
        }
        else if (words.length > 10) {
            message.setText("Too many words.");
        }

        else {
            for (String word : words) {
                if (word.length()>10) {
                    message.setText("Maximum length for words is 10.");
                    break outerloop;
                    
                }
                else if (word.contains(" ")) {
                    message.setText("Singe words only.");
                    break outerloop;
                } 
                else if (word.length()== 0) {
                    message.setText("Error, remove empty words");
                    break outerloop;
                }
            }

            int finalAmount = words.length;
            ControllerGameScreen controllerGameScreen = new ControllerGameScreen(this.primaryStage, themeField.getText(), words, finalAmount);
            controllerGameScreen.show();
        }

    }

    @FXML
    public void saveThemeClick() {
        String[] words = wordsField.getText().split("\n");
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));

        outerloop:
        if (words.length != wordSet.size()) {
            message.setText("No duplicated please.");
            
        }
        else if (words.length > 10) {
            message.setText("Too many words.");
        }

        else {
            for (String word : words) {
                if (word.length()>10) {
                    message.setText("Maximum length for words is 10.");
                    break outerloop;
                    
                }
                else if (word.contains(" ")) {
                    message.setText("Singe words only.");
                    break outerloop;
                } 
                else if (word.length()== 0) {
                    message.setText("Error, remove empty words");
                    break outerloop;
                }
            }

            String theme = themeField.getText();
            FileManager fileManager = new FileManager();
            fileManager.addSolution(theme, words);
            saveTheme.setText("Saved");

            saveTheme.setOnAction(null);

        } 
    }
}
