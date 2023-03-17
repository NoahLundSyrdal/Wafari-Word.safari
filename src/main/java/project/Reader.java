package project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Reader {

    private HashMap<String, String[]> map;

    public Reader() {
        this.map = readDictionary("/Users/noahsyrdal/Desktop/Objekt orentert programmering PROSJEKT/tdt-4100-prosjekt-noah-matias/src/main/java/project/Words.txt");
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

    public static void main(String[] args) {
        
    }

    
}
