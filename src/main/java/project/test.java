package project;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {


        Solution solution = new Solution("colors", 5);
        GridGenerator gridGenerator = new GridGenerator(solution);

        gridGenerator.gridCreate();
        gridGenerator.fillGrid();

        for (int i = 0; i < gridGenerator.getGrid().length; i++) {
            System.out.println(gridGenerator.getGrid()[i]);

        }


    }
}
