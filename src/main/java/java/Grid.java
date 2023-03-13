package java;

import java.util.ArrayList;

public class Grid {
    private ArrayList<ArrayList<Character>> grid = new ArrayList<>();
    private Solution solution;
    private int points;
    private int amount;

    public Grid(GridGenerator generator){
        ArrayListgrid = generator.gridGenerator(solution);
    }

    public void highlighter(String guess){
        for(int i = 0; i<solution.size();i++){
            String word = solution.getWord(i);
            if(guess.equals(word)){
                points++;
                

            }
        }
    }
}
