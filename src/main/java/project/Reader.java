package project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Reader {

    private HashMap<String, String[]> map;

    public Reader() {
        this.map = readDictionary("Words.txt");
    }
    public HashMap<String, String[]> readDictionary(String fileName) {
        HashMap<String, String[]> dictionary = new HashMap<String, String[]>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] lineArr = line.split(";");
                dictionary.put(lineArr[0], lineArr[1].split(" "));
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

    
}
