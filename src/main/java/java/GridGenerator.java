package java;

import java.util.ArrayList;
import java.util.Random;


public class GridGenerator {
    private char[][] grid;
    private Solution solution;
    private String[] horizontal;
    private String[] vertical;

    public GridGenerator(Solution solution) {
        this.solution = solution;
    }

    public void generateHorizontalVertical() {
        Random random = new Random();
        int horizontalSize = random.nextInt(this.solution.size()/2);
        int verticalSize= random.nextInt(this.solution.size() - horizontalSize);

        horizontal = new String[horizontalSize];
        vertical = new String[verticalSize];

        for (int i = 0; i < horizontalSize; i++) {
            horizontal[i] = this.solution.getWord(i);
        }
        for (int i = 0; i < verticalSize; i++) {
            vertical[i] = this.solution.getWord(i+horizontalSize);
        }

    }

    public String[] getHorizontal() {
        return horizontal;
    }

    public String[] getVertical() {
        return vertical;
    }

    public void createGrid() {
        this.grid = new char[10][10];
    }
    
    public void setWord() {
        if (horizontal.length > vertical.length) {

        }

        else {

        }
    }

}
 