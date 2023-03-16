package project;

import java.util.ArrayList;
import java.util.Random;


public class GridGenerator {
    private char[][] grid;
    private ArrayList<String> solution;
    private ArrayList<String> horizontal;
    private ArrayList<String> vertical;
    private Random random = new Random();

    public GridGenerator(ArrayList<String> solution) {
        this.solution = solution;
    }

    public void generateHorizontalVertical() {
        int horizontalSize = this.solution.size()/2;
        int verticalSize = this.solution.size() - horizontalSize;

        horizontal = new ArrayList<String>();
        vertical = new ArrayList<String>();

        for (int i = 0; i < horizontalSize; i++) {
            horizontal.add(this.solution.get(i));
        }
        for (int i = 0; i < verticalSize; i++) {
            vertical.add(this.solution.get(i+horizontalSize));
        }

    }

    public ArrayList<String> getHorizontal() {
        return horizontal;
    }

    public ArrayList<String> getVertical() {
        return vertical;
    }

    public void createGrid() {
        this.grid = new char[10][10];
        

    }

    public void fillGrid() {
        Random random = new Random();
        for (int i = 0; i < this.grid.length; i ++) {
            for (int j = 0; j < this.grid[i].length; j ++) {
                if (grid[i][j] == '\u0000') {
                    grid[i][j] = (char)(random.nextInt(26) + 'a');
            }
            }
        }
    }
    
    public void setWords() { 
        while (horizontal.size() > 0 || vertical.size() > 0) {
            int positionY = random.nextInt(2);
            int positionX = random.nextInt(2);
            if (horizontal.size() > 0) {
                try {
                    for (char c : horizontal.get(0).toCharArray()) {
                            System.out.println(1);
                            grid[positionY][positionX] = c;
                        }
                    horizontal.remove(0);
                    }

                finally {}
            }

            else {
                try {
                    for (char c : vertical.get(0).toCharArray()) {
                            System.out.println(1);
                            grid[positionY][positionX] = c;
                        }
                    vertical.remove(0);
                    }
                    
                finally {}
            }
        }
    }

    public char[][] getGrid() {
        return grid;
    }
    

}
 