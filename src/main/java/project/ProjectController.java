package project;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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
            GridGenerator gridGenerator = new GridGenerator(solution);
            gridGenerator.gridCreate();
            gridGenerator.fillGrid();

            VBox llayout = new VBox();


            GridPane layout = new GridPane();
            layout.setVgap(10);
            layout.setHgap(15);
            layout.setPadding(new Insets(10, 10, 10, 10));
            //layout.setPadding(new Insets(50, 50, 50, 50));
            for (int i = 0; i < gridGenerator.getGrid().length; i++) {
                for (int j = 0; j < gridGenerator.getGrid().length; j++) {
                    Label l = new Label(Character.toString(gridGenerator.getGrid()[i][j]));
                    l.setFont(new Font(12.0));
                    GridPane.setConstraints(l, 0+j, 0+i);
                    layout.getChildren().add(l);
                    
                }
                //Label l = new Label(new String(gridGenerator.getGrid()[i]));
                
            }
            layout.setAlignment(Pos.CENTER);
            
            llayout.getChildren().add(layout);
            llayout.setAlignment(Pos.CENTER);

            //llayout.setAlignment(Pos.CENTER);
            
            Scene newScene = new Scene(llayout, 600, 400);
            Stage newStage = (Stage)createButton.getScene().getWindow();
            newStage.setScene(newScene);

            newStage.show();
            //Stage newStage = (Stage)createButton.getScene().getWindow();
            //newStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Game.fxml"))));
            //newStage.show();
        }
        else{
            System.out.println("You need to select both values");
        }
       
        

} 


}

