package project;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class ProjectController {
    public ComboBox<String> theme;
    public ComboBox<Integer> amount;
    public Button createButton;

    @FXML
    public void initialize() {
        theme.getItems().addAll("animals","sports","foods","colors","countries","fruits","capitalCities","videoGames","footballTeams","mountains","rivers","easter","halloween","christmas","music","science","nature","landmarks","creatures","jobs","planets","languages","books","insects","artStyles","sportsEquipment","dogBreeds");
        amount.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
    }

    public void buttonOnClick() throws IOException{
        if(theme.getValue()!= null && amount.getValue()!=null){
            Solution solution = new Solution(theme.getValue(), amount.getValue());
            System.out.println(solution);
            GridGenerator grid = new GridGenerator(solution);
        }
        else{
            System.out.println("You need to select both values");
        }
        Stage newStage = (Stage)createButton.getScene().getWindow();
        newStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Game.fxml"))));
        newStage.show();
        

} 


}

