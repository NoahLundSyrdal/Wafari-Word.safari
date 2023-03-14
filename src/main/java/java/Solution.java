package java;

import java.util.ArrayList;

public class Solution {
    private ArrayList<String> solution = new ArrayList<>();

    Solution(Theme theme, int number){
        if(number>10){
            throw new IllegalStateException("too big of a grid");
        }
        for (int i = 0; i < number; i++) {
            String ord = theme.random();
            if(!solution.contains(ord)){
                solution.add(ord);
            }
            else{
                i = i-1;
            }
        }
    }
    public int getLongestWordSize(){
        String longest = "";
        for (String string : solution) {
            if(string.length()>longest.length()){
                longest = string;
            }
        }
        return longest.length();
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
