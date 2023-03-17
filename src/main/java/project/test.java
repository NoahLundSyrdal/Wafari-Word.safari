package project;

import java.util.ArrayList;

public class test {
    // public static void main(String[] args) {


    //     Solution solution = new Solution("sports", 4);
    //     GridGenerator grid = new GridGenerator(solution);
    //     grid.createGrid();
    //     grid.generateHorizontalVertical();
    //     grid.setWords();
    //     grid.fillGrid();
        
    //     for (int i = 0; i <= grid.getGrid().length; i++) {
    //         System.out.println(grid.getGrid()[i]);

    //     }
        
        
    // }

    public static void main(String[] args) {
        Reader reader = new Reader();
        System.out.println(reader.getMap());;

        Solution solution = new Solution("animals", 5);
        System.out.println(solution.getSolution());
    }
}
