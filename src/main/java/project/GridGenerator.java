package project;

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
        while (horizontal.size() > 0 || vertical.size() > 0) {
            int positionY = random.nextInt(solution.getLongestWordSize()+2);
            int positionX = random.nextInt(solution.getLongestWordSize()+2);
            if (horizontal.size() > 0) {
                try {
                    for (char c : horizontal.get(0).toCharArray()) {
                            grid[positionY][positionX] = c;
                        }
                    }
                finally {}
            }

            else {
                try {
                    for (char c : vertical.get(0).toCharArray()) {
                            grid[positionY][positionX] = c;
                        }
                    }
                finally {}
            }
        }
    }
    

}
 