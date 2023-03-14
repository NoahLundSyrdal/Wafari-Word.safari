package java;

import java.util.ArrayList;
import java.util.Random;


public class GridGenerator {
    private char[][] grid;
    private Solution solution;
    private ArrayList<String> horizontal;
    private ArrayList<String> vertical;
    private Random random = new Random();

    public GridGenerator(Solution solution) {
        this.solution = solution;
    }

    public void generateHorizontalVertical() {
        int horizontalSize = random.nextInt(this.solution.size()/2);
        int verticalSize= random.nextInt(this.solution.size() - horizontalSize);

        horizontal = new ArrayList<String>();
        vertical = new ArrayList<String>();

        for (int i = 0; i < horizontalSize; i++) {
            horizontal.add(this.solution.getWord(i));
        }
        for (int i = 0; i < verticalSize; i++) {
            vertical.add(this.solution.getWord(i+horizontalSize));
        }

    }

    public ArrayList<String> getHorizontal() {
        return horizontal;
    }

    public ArrayList<String> getVertical() {
        return vertical;
    }

    public void createGrid() {
        this.grid = new char[solution.getLongestWordSize()+2][solution.getLongestWordSize()+2];
        
        // Random random = new Random();
        // for (int i = 0; i < this.grid.length; i ++) {
        //     for (int j = 0; j < this.grid[0].length; j ++) {
        //         grid[i][j] = (char)(random.nextInt(26) + 'a');
        //     }
        // }
    }
    
    public void setWords() {
        int i;
        int j;
        
        while (horizontal.size() > 0 && vertical.size() > 0) {
            try {
                int r = random.nextInt(vertical.size())
                for (char c : horizontal.get(r)) {
                    
                }
            }
        

        else {

        }
    }
    }

}
 