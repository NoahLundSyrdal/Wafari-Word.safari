package project;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

public class WafariLauncher extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("WAFARI");

        ControllerMainScreen controllerMainScreen = new ControllerMainScreen(primaryStage);
        controllerMainScreen.show();
    }
}
