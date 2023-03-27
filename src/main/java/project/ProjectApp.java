package project;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;


public class ProjectApp extends Application {
    ObservableList<String> optionsList = FXCollections.observableArrayList("animals","sports","foods","colors","countries","fruits","capitalCities","videoGames","footballTeams","mountains","rivers","easter","halloween","christmas","music","science","nature","landmarks","creatures","jobs","planets","languages","books","insects","artStyles","sportsEquipment","dogBreeds");
    FXMLLoader loader = new FXMLLoader(getClass().getResource("App.fxml"));
    Parent root = loader.load();
    ComboBox<String> comboBox = (ComboBox<String>) loader.getNamespace().get("MyComboBox");
    comboBox.setItems(optionsList);
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("WAFARI");
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("App.fxml"))));
        primaryStage.show();
    }
    

}
