package project;

import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;


public class Grid implements GridInterface{
    private char[][] grid;
    private Solution solution;
    private ArrayList<String> horizontal;
    private ArrayList<String> vertical;
    private Random random = new Random();
    private int horizontalSize;
    private int verticalSize;
    private HashMap<String,String[]> wordCoordinates = new HashMap<String, String[]>();


    public Grid(Solution solution) {
        this.solution = solution;
        this.verticalSize = this.solution.size()/2;
        this.horizontalSize = this.solution.size() - this.verticalSize;

        this.gridCreate();
        this.fillGrid();
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
        //this.grid = new char[solution.getLongestWordSize()+size][solution.getLongestWordSize()+size];
        this.grid = new char[size][size];

    }

    public void fillGrid() {
        Random random = new Random();
        for (int i = 0; i < this.grid.length; i ++) {
            for (int j = 0; j < this.grid[i].length; j ++) {
                if (grid[i][j] == '\u0000') {
                    //grid[i][j] = '-';
                    grid[i][j] = (char)(random.nextInt(26) + 'a');
                    
            }
            }
        }
    }
    
    public void gridCreate() {
        int counter = 0; 
        int sizeCounter = 12;

        createGrid(sizeCounter);
        generateHorizontalVertical();


        outerloop: 
        while (horizontal.size() > 0 || vertical.size() > 0) {
            counter ++;

            if (counter > 1000) {
                wordCoordinates.clear();
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
                String[] coordinates = {Integer.toString(positionX), Integer.toString(positionY), "v"};
                wordCoordinates.put(vertical.get(0), coordinates);
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

                
                String[] coordinates = {Integer.toString(positionX), Integer.toString(positionY), "h"};
                wordCoordinates.put(horizontal.get(0), coordinates);
                horizontal.remove(0);

            }



        }
    }
            

    public char[][] getGrid() {
        return grid;
    }
    
    public HashMap<String, String[]> getWordCoordinates() {
        return wordCoordinates;
    }

}
 