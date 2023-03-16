package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

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



    // public String[] getWordsForTheme(String theme) {
    //     switch (theme.toLowerCase()) {
    //         case "animals":
    //             return animals;
    //         case "sports":
    //             return sports;
    //         case "foods":
    //             return foods;
    //         case "colors":
    //             return colors;
    //         case "countries":
    //             return countries;
    //         case "fruits":
    //             return fruits;
    //         case "capital cities":
    //             return capitalCities;
    //         case "video games":
    //             return videoGames;
    //         case "football teams":
    //             return footballTeams;
    //         case "mountains":
    //             return mountains;
    //         case "rivers":
    //             return rivers;
    //         case "easter":
    //             return easter;
    //         case "halloween":
    //             return halloween;
    //         case "christmas":
    //             return christmas;
    //         case "music":
    //             return music;
    //         case "science":
    //             return science;
    //         case "nature":
    //             return nature;
    //         case "landmarks":
    //             return landmarks;
    //         case "mythological creatures":
    //             return creatures;
    //         case "jobs":
    //             return jobs;
    //         case "planets":
    //             return planets;
    //         case "languages":
    //             return languages;
    //         case "books":
    //             return books;
    //         case "insects":
    //             return insects;
    //         case "art styles":
    //             return artStyles;
    //         case "sports equipment":
    //             return sportsEquipment;
    //         case "dog breeds":
    //             return dogBreeds;
    //         default:
    //             throw new IllegalArgumentException("Invalid theme: " + theme);
    //     }
    // }
    
}
