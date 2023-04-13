package project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WafariTest {

    @Test
    public void testSolutionConstructor() {
        Assertions.assertThrows(IllegalStateException.class, () -> new Solution("random", 20));
        Assertions.assertDoesNotThrow(() -> new Solution("Fruits", 8), "Too big of a grid");
    }

    @Test
    public void testGetLongestWordSize() {
        String[] testWords = {"apples", "bananas", "watermelons"};
        Solution solution = new Solution(testWords);
        
        assertEquals(11, solution.getLongestWordSize());
    };

    @Test
    public void testGetWordsForTheme() {
        Solution solution = new Solution("Fruits", 5);
        String[] Fruits = {"apple","banana","orange","strawberry","kiwi","grapefruit","peach","mango","papaya","watermelon"};
        assertArrayEquals(Fruits, solution.getWordsForTheme("Fruits"));
    }

    @Test 
    public void testGrid() {
        Solution solution = new Solution("Fruits", 6);
        Grid grid = new Grid(solution);
        assertEquals(0, grid.getHorizontal().size());
        assertEquals(0, grid.getVertical().size());
    }

    
    @Test
    public void testWriteFile() {
        FileManager fileManager = new FileManager();
        String[] testWords = {"BMW", "Mercedes", "VW"};
        assertDoesNotThrow(() -> fileManager.addSolution("Cars", testWords));   
    }

    @Test
    public void testFileManager() {
        FileManager fileManager = new FileManager();
        assertDoesNotThrow(() -> fileManager.getMap());
    }
}
