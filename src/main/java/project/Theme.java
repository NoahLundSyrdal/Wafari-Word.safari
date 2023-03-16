package project;
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
    private final String[] nature = {"ocean", "forest", "mountain", "lake", ""};
    private final String[] landmarks = {"Eiffel Tower", "Taj Mahal", "Golden Gate Bridge", "Great Wall of China", "Statue of Liberty", "Machu Picchu", "Burj Khalifa", "Pyramids of Giza", "Colosseum", "Stonehenge"};
    private final String[] creatures = {"Dragon", "Phoenix", "Mermaid", "Minotaur", "Cerberus", "Sphinx", "Kraken", "Unicorn", "Chimera", "Centaur"};
    private final String[] jobs = {"Doctor", "Teacher", "Engineer", "Chef", "Lawyer", "Police Officer", "Firefighter", "Pilot", "Dentist", "Accountant"};
    private final String[] planets = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto", "Eris"};
    private final String[] languages = {"English", "Spanish", "Mandarin", "Arabic", "French", "Russian", "Portuguese", "German", "Japanese", "Korean"};
    private final String[] books = {"To Kill a Mockingbird", "The Great Gatsby", "1984", "Pride and Prejudice", "The Lord of the Rings", "The Catcher in the Rye", "Brave New World", "Animal Farm", "Fahrenheit 451", "The Hobbit"};
    private final String[] insects = {"Butterfly", "Ant", "Ladybug", "Mosquito", "Grasshopper", "Cockroach", "Bee", "Dragonfly", "Moth", "Cicada"};
    private final String[] artStyles = {"Impressionism", "Surrealism", "Cubism", "Realism", "Abstract Expressionism", "Pop Art", "Renaissance", "Baroque", "Minimalism", "Conceptual Art"};
    private final String[] sportsEquipment = {"Soccer Ball", "Basketball", "Football", "Baseball Bat", "Golf Club", "Tennis Racquet", "Hockey Stick", "Skateboard", "Surfboard", "Bicycle"};
    private final String[] dogBreeds = {"Golden Retriever", "Labrador Retriever", "German Shepherd", "Poodle", "Bulldog", "Beagle", "Boxer", "Dachshund", "Chihuahua", "Siberian Husky"};
    

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
            case "landmarks":
                return landmarks;
            case "mythological creatures":
                return creatures;
            case "jobs":
                return jobs;
            case "planets":
                return planets;
            case "languages":
                return languages;
            case "books":
                return books;
            case "insects":
                return insects;
            case "art styles":
                return artStyles;
            case "sports equipment":
                return sportsEquipment;
            case "dog breeds":
                return dogBreeds;
            default:
                throw new IllegalArgumentException("Invalid theme: " + theme);
        }
    }
}
