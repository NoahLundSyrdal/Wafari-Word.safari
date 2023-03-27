package project;


public class Grid{
    private char[][] grid;
    private Solution solution;
    private int points;
    private int amount;

    public Grid(GridGenerator generator){
        generator = new GridGenerator(solution);
        amount = solution.size();
        points = 0;
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
