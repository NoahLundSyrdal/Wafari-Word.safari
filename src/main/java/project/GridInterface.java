package project;

import java.util.ArrayList;
import java.util.HashMap;

public interface GridInterface {
    public void generateHorizontalVertical();
    public ArrayList<String> getHorizontal();
    public ArrayList<String> getVertical();
    public void createGrid(int size);
    public void fillGrid();
    public void gridCreate();
    public char[][] getGrid();
    public HashMap<String, String[]> getWordCoordinates();


}
