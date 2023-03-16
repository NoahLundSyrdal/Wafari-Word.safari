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
        outerloop: 
        while (horizontal.size() > 0 || vertical.size() > 0) {
            if (vertical.size() > horizontal.size()) {
                int positionY = random.nextInt(grid.length-vertical.get(0).length()-1);
                int positionX = random.nextInt(grid[0].length-1);

                for (int i = 0; i < vertical.get(0).length(); i++) {
                    if (grid[positionY+i][positionX] != vertical.get(0).charAt(i)) {
                        if (grid[positionY+i][positionX] != '\u0000') {
                            continue outerloop;
                        }
                    }
                }

                for (int i = 0; i < vertical.get(0).length(); i++) {
                    grid[positionY+i][positionX] = vertical.get(0).charAt(i);
                }

                vertical.remove(0);
            }

            else {
                int positionY = random.nextInt(grid.length-1);
                int positionX = random.nextInt(grid[0].length-horizontal.get(0).length()-1);


                for (int i = 0; i < horizontal.get(0).length(); i++) {
                    if (grid[positionY][positionX+i] != horizontal.get(0).charAt(i)) {
                        if (grid[positionY][positionX+i] != '\u0000') {
                            continue outerloop;
                        }
                    }
                }

                for (int i = 0; i < horizontal.get(0).length(); i++) {
                    grid[positionY][positionX+i] = horizontal.get(0).charAt(i);
                }

                horizontal.remove(0);

            }
        }
    }
            

    public char[][] getGrid() {
        return grid;
    }
    

}
 