package project;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class ProjectController {
    public ComboBox<String> theme;
    public ComboBox<Integer> amount;

    @FXML
    public void initialize() {
        theme.getItems().addAll("animals","sports","foods","colors","countries","fruits","capitalCities","videoGames","footballTeams","mountains","rivers","easter","halloween","christmas","music","science","nature","landmarks","creatures","jobs","planets","languages","books","insects","artStyles","sportsEquipment","dogBreeds");
        amount.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
    }

}

