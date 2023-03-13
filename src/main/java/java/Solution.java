package java;

import java.util.ArrayList;

public class Solution {
    private ArrayList<String> solution = new ArrayList<>();

    Solution(Theme theme, int number){

    }

    public ArrayList<String> getSolution() {
        return solution;
    }
    public int size(){
        return solution.size();
    }
    public String getWord(int i){
        return solution.get(i);
    }
    
}
