package project;

import java.util.ArrayList;
import java.util.Random;


public class GridGenerator {
    private char[][] grid;
    private Solution solution;
    private ArrayList<String> horizontal;
    private ArrayList<String> vertical;
    private Random random = new Random();
    private int horizontalSize;
    private int verticalSize;


    public GridGenerator(Solution solution) {
        this.solution = solution;
        this.horizontalSize = this.solution.size()/2;
        this.verticalSize = this.solution.size() - this.horizontalSize;
    }

    public void generateHorizontalVertical() {
        
        horizontal = new ArrayList<String>();
        vertical = new ArrayList<String>();

        for (int i = 0; i < this.horizontalSize; i++) {
            horizontal.add(this.solution.getWord(i).toLowerCase());
        }
        for (int i = 0; i < this.verticalSize; i++) {
            vertical.add(this.solution.getWord(i+this.horizontalSize).toLowerCase());
        }

    }

    public ArrayList<String> getHorizontal() {
        return horizontal;
    }

    public ArrayList<String> getVertical() {
        return vertical;
    }

    public void createGrid(int size) {
        this.grid = new char[solution.getLongestWordSize()+size][solution.getLongestWordSize()+size];
        

    }

    public void fillGrid() {
        Random random = new Random();
        for (int i = 0; i < this.grid.length; i ++) {
            for (int j = 0; j < this.grid[i].length; j ++) {
                if (grid[i][j] == '\u0000') {
                    grid[i][j] = '-';
                    //grid[i][j] = (char)(random.nextInt(26) + 'a');
                    
            }
            }
        }
    }
    
    public void gridCreate() {
        int counter = 0; 
        int sizeCounter = 0;

        createGrid(sizeCounter);
        generateHorizontalVertical();


        outerloop: 
        while (horizontal.size() > 0 || vertical.size() > 0) {
            counter ++;

            if (counter > 100) {
                createGrid(sizeCounter);
                generateHorizontalVertical();
            }

            if (counter > 10000) {
                sizeCounter ++;
                createGrid(sizeCounter);
                generateHorizontalVertical();
                counter = 0;
            }

            if (vertical.size() > horizontal.size()) {
                int positionY = random.nextInt(grid.length-vertical.get(0).length()+1);
                int positionX = random.nextInt(grid[0].length);

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
                int positionY = random.nextInt(grid.length);
                int positionX = random.nextInt(grid[0].length-horizontal.get(0).length()+1);


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
 