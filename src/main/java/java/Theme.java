package java;
import java.util.random.*;

public class Theme {

    private final String[] animals = {"lion", "tiger", "bear", "elephant", "giraffe", "rhinoceros", "hippopotamus", "crocodile", "monkey", "zebra"};
    private final String[] sports = {"baseball", "football", "basketball", "soccer", "tennis", "hockey", "golf", "swimming", "cycling", "running"};
    private final String[] foods = {"pizza", "hamburger", "sushi", "spaghetti", "tacos", "burrito", "steak", "salad", "sandwich", "fries"};
    private final String[] colors = {"red", "blue", "green", "yellow", "purple", "orange", "pink", "brown", "black", "white"};
    private final String[] countries = {"USA", "Canada", "Mexico", "France", "Germany", "Spain", "China", "Japan", "Russia", "Brazil"};
    private final String[] fruits = {"apple", "banana", "orange", "strawberry", "kiwi", "grapefruit", "peach", "mango", "papaya", "watermelon"};
    private final String[] capitalCities = {"Tokyo", "Washington", "Paris", "London", "Beijing", "Moscow", "Berlin", "New Delhi", "Canberra", "Rome"};
    private final String[] videoGames = {"Minecraft", "Fortnite", "League of Legends", "World of Warcraft", "Overwatch", "Halo", "Call of Duty", "GTA", "Zelda", "Mario"};
    private final String[] footballTeams = {"Barcelona", "Real Madrid", "Manchester United", "Liverpool", "Bayern Munich", "Juventus", "PSG", "Manchester City", "Chelsea", "Arsenal"};
    private final String[] mountains = {"Mount Everest", "Kilimanjaro", "Denali", "Mount Fuji", "Matterhorn", "K2", "Mount Whitney", "Aconcagua", "Mont Blanc", "Mount Elbrus"};
    private final String[] rivers = {"Nile", "Amazon", "Mississippi", "Yangtze", "Ganges", "Danube", "Mekong", "Volga", "Colorado", "Thames"};
    private final String[] easter = {"egg", "bunny", "basket", "chocolate", "jesus", "lamb", "cross", "resurrection", "daffodil", "spring"};
    private final String[] halloween = {"pumpkin", "witch", "ghost", "bat", "candy", "spider", "skeleton", "costume", "zombie", "vampire"};
    private final String[] christmas = {"tree", "santa", "gift", "reindeer", "ornament", "cookie", "snowman", "candle", "jingle", "mistletoe"};
    private final String[] music = {"rock", "jazz", "pop", "classical", "hip hop", "country", "blues", "folk", "metal", "reggae"};
    private final String[] science = {"chemistry", "biology", "physics", "astronomy", "geology", "ecology", "psychology", "sociology", "anthropology", "botany"};
    private final String[] nature = {"ocean", "forest", "mountain", "lake", ""}
    

    public String[] getWordsForTheme(String theme) {
        switch (theme.toLowerCase()) {
            case "animals":
                return animals;
            case "sports":
                return sports;
            case "foods":
                return foods;
            case "colors":
                return colors;
            case "countries":
                return countries;
            case "fruits":
                return fruits;
            case "capital cities":
                return capitalCities;
            case "video games":
                return videoGames;
            case "football teams":
                return footballTeams;
            case "mountains":
                return mountains;
            case "rivers":
                return rivers;
            case "easter":
                return easter;
            case "halloween":
                return halloween;
            case "christmas":
                return christmas;
            case "music":
                return music;
            case "science":
                return science;
            case "nature":
                return nature;
            default:
                throw new IllegalArgumentException("Invalid theme: " + theme);
        }
    }
}
