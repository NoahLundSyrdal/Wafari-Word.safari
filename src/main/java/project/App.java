package project;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Wafari - Word Safari");
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource(App.STYLESHEET_MODENA))));
        
    }
    public static void main(Stage args) {
        start(args);
    }
    
}
