package project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class FileManager {

    private HashMap<String, String[]> map;

    public FileManager() {
       //this.map = readDictionary("C:/Users/matia/Documents/GIT2023/tdt-4100-prosjekt-noah-matias/src/main/java/project/Words.txt");

       this.map = readDictionary("/Users/noahsyrdal/Desktop/OOP PROSJEKT/tdt-4100-prosjekt-noah-matias/src/main/java/project/Words.txt");
    }

    public HashMap<String, String[]> readDictionary(String fileName) {
        HashMap<String, String[]> dictionary = new HashMap<String, String[]>();
        BufferedReader reader = null;
        try {
            FileReader fileReader = new FileReader(fileName);
            reader = new BufferedReader(fileReader);
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] lineArr = line.split(";");
                if(lineArr.length == 2){
                    dictionary.put(lineArr[0], lineArr[1].split(","));
                }   
        }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return dictionary;
    }
    public HashMap<String, String[]> getMap() {
        return map;
    }

    public Set<String> getAllThemes() {
        return map.keySet();
    }

    public void addSolution(String theme, String[] words) {
        BufferedWriter writer;
        String wordString = String.join(",", words);

        try {
            //writer = new BufferedWriter(new FileWriter("C:/Users/matia/Documents/GIT2023/tdt-4100-prosjekt-noah-matias/src/main/java/project/Words.txt", true));
            writer = new BufferedWriter(new FileWriter("/Users/noahsyrdal/Desktop/OOP PROSJEKT/tdt-4100-prosjekt-noah-matias/src/main/java/project/Words.txt", true));

            writer.append(theme + ";" + wordString);
            writer.newLine();
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
