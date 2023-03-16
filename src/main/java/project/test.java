package project;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        ArrayList<String> solution = new ArrayList<String>();
        solution.add("TEST");

        GridGenerator grid = new GridGenerator(solution);
        grid.createGrid();
        grid.generateHorizontalVertical();
        grid.setWords();
        grid.fillGrid();
        
        System.out.println(grid.getGrid()[0]);
        System.out.println(grid.getGrid()[1]);
        System.out.println(grid.getGrid()[2]);
        System.out.println(grid.getGrid()[3]);
        System.out.println(grid.getGrid()[4]);
        System.out.println(grid.getGrid()[5]);
        System.out.println(grid.getGrid()[6]);
        System.out.println(grid.getGrid()[7]);
        System.out.println(grid.getGrid()[8]);
        System.out.println(grid.getGrid()[9]);
        
    }
}
