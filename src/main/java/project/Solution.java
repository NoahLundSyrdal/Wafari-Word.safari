package project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Solution {
    private ArrayList<String> solution = new ArrayList<>();
    private HashMap<String, String[]> map;


    public Solution(String theme, int number){
        Reader reader = new Reader();
        map = reader.getMap();
        String[] words = getWordsForTheme(theme);
        if(number>10 || number > words.length){
            throw new IllegalStateException("too big of a grid");
        }
        for (int i = 0; i < number; i++) {
            Random random = new Random();
            int rand = random.nextInt(words.length);
            String word = words[rand];
            if(!solution.contains(word)){
                solution.add(word);
            }
            else{
                i = i-1;
            }
        }
    }

    public String[] getWordsForTheme(String theme){
        try {
            return map.get(theme);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("no theme with name "+theme);
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
