package Tests;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.FileWriter;

import Src.CLIHandler;

public class UnitTests {
    @Test
    public void testFunctional() {
        String str = "JUnit is working";
        assertEquals("JUnit is working", str);
    }





    //STRING
    /**Tests insertion sort on a string dataset from input, sorting by string length*/
    @Test
    public void testInsertionSortStringInput() {
        String[] testInput = {"Apple", "Banana", "Kiwi", "Strawberry"};
        String[] correctAnswer = {"Kiwi", "Apple", "Banana", "Strawberry"};
        CLIHandler handler = new CLIHandler();
        String[] givenAnswer = handler.splitArray("Insertion", true, testInput);
        
        for (int i = 0; i < givenAnswer.length; i++) {
            assertEquals("Sorted list does not match expected order", correctAnswer[i], givenAnswer[i]);
        }
        System.out.println("testInsertionSortStringInput() passed \n");
    }

    /**Tests insertion sort on a string dataset from file, sorting by string length*/
    @Test
    public void testInsertionSortStringFile() {
        String fileName = "Test\\testInsertionSortStringFile.csv";
        try { 
            FileWriter fileWrite = new FileWriter(fileName);
            fileWrite.write("Kiwi,Apple,Banana,Strawberry");
            fileWrite.close();

            String[] correctAnswer = {"Kiwi", "Apple", "Banana", "Strawberry"};
            CLIHandler handler = new CLIHandler();
            String[] testInput = handler.dataFromFile(fileName);
            String[] givenAnswer = handler.splitArray("Insertion", true, testInput);
            
            for (int i = 0; i < givenAnswer.length; i++) {
                assertEquals("Sorted list does not match expected order", correctAnswer[i], givenAnswer[i]);
            }
            System.out.println("testInsertionSortStringFile() passed \n");
        } 
        catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        
    }
    
    /**Tests insertion sort on a string dataset from input, trying to sort by string value*/
    @Test
    public void tryBreakInsertionSortStringInput() {
        String[] testInput = {"Apple", "Banana", "Kiwi", "Strawberry"};
        String[] correctAnswer = {"Kiwi", "Apple", "Banana", "Strawberry"};
        CLIHandler handler = new CLIHandler();
        String[] givenAnswer = handler.splitArray("Insertion", false, testInput);
        
        for (int i = 0; i < givenAnswer.length; i++) {
            assertEquals("Sorted list does not match expected order", correctAnswer[i], givenAnswer[i]);
        }
        System.out.println("testInsertionSortStringInput() passed \n");
    }

    /**Tests insertion sort on a string dataset from file, trying to sort by string value*/
    @Test
    public void tryBreakInsertionSortStringFile() {
        String fileName = "Test\\tryBreakInsertionSortStringFile.csv";
        try { 
            FileWriter fileWrite = new FileWriter(fileName);
            fileWrite.write("Kiwi,Apple,Banana,Strawberry");
            fileWrite.close();

            String[] correctAnswer = {"Kiwi", "Apple", "Banana", "Strawberry"};
            CLIHandler handler = new CLIHandler();
            String[] testInput = handler.dataFromFile(fileName);
            String[] givenAnswer = handler.splitArray("Insertion", false, testInput);
            
            for (int i = 0; i < givenAnswer.length; i++) {
                assertEquals("Sorted list does not match expected order", correctAnswer[i], givenAnswer[i]);
            }
            System.out.println("testInsertionSortStringFile() passed \n");
        } 
        catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        
    }





    //INTEGER
    /**Tests insertion sort on an integer dataset from input, sorting by integer length*/
    @Test
    public void testInsertionSortIntInputByLen() {
        String[] testInput = {"409", "16", "1000", "3"};
        String[] correctAnswer = {"3", "16", "409", "1000"};
        CLIHandler handler = new CLIHandler();
        String[] givenAnswer = handler.splitArray("Insertion", true, testInput);
        
        for (int i = 0; i < givenAnswer.length; i++) {
            assertEquals("Sorted list does not match expected order", correctAnswer[i], givenAnswer[i]);
        }
        System.out.println("testInsertionSortIntInputByLen() passed \n");
    }

    /**Tests insertion sort on an integer dataset from file, sorting by integer length*/
    @Test
    public void testInsertionSortIntFileByLen() {
        String fileName = "Test\\testInsertionSortIntFile.csv";
        try { 
            FileWriter fileWrite = new FileWriter(fileName);
            fileWrite.write("409,16,1000,3");
            fileWrite.close();

            String[] correctAnswer = {"3", "16", "409", "1000"};
            CLIHandler handler = new CLIHandler();
            String[] testInput = handler.dataFromFile(fileName);
            String[] givenAnswer = handler.splitArray("Insertion", true, testInput);
            
            for (int i = 0; i < givenAnswer.length; i++) {
                assertEquals("Sorted list does not match expected order", correctAnswer[i], givenAnswer[i]);
            }
            System.out.println("testInsertionSortIntFileByLen() passed \n");
        } 
        catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        
    }

    /**Tests insertion sort on an integer dataset from input, sorting by integer value*/
    @Test
    public void testInsertionSortIntInputByVal() {
        String[] testInput = {"49", "16", "10", "3"};
        String[] correctAnswer = {"3", "10", "16", "49"};
        CLIHandler handler = new CLIHandler();
        String[] givenAnswer = handler.splitArray("Insertion", false, testInput);
        
        for (int i = 0; i < givenAnswer.length; i++) {
            assertEquals("Sorted list does not match expected order", correctAnswer[i], givenAnswer[i]);
        }
        System.out.println("testInsertionSortIntInputByVal() passed \n");
    }

    /**Tests insertion sort on an integer dataset from file, sorting by integer value*/
    @Test
    public void testInsertionSortIntFileByVal() {
        String fileName = "Test\\testInsertionSortIntFile.csv";
        try { 
            FileWriter fileWrite = new FileWriter(fileName);
            fileWrite.write("49,16,10,3");
            fileWrite.close();

            String[] correctAnswer = {"3", "10", "16", "49"};
            CLIHandler handler = new CLIHandler();
            String[] testInput = handler.dataFromFile(fileName);
            String[] givenAnswer = handler.splitArray("Insertion", false, testInput);
            
            for (int i = 0; i < givenAnswer.length; i++) {
                assertEquals("Sorted list does not match expected order", correctAnswer[i], givenAnswer[i]);
            }
            System.out.println("testInsertionSortIntFileByVal() passed \n");
        } 
        catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        
    }





    //FLOAT
    /**Tests insertion sort on a float dataset from input, sorting by float length*/
    @Test
    public void testInsertionSortFloatInputByLen() {
        String[] testInput = {"0.0012", "16.2", "1", "77.25"};
        String[] correctAnswer = {"1", "16.2", "77.25", "0.0012"};
        CLIHandler handler = new CLIHandler();
        String[] givenAnswer = handler.splitArray("Insertion", true, testInput);
        
        for (int i = 0; i < givenAnswer.length; i++) {
            assertEquals("Sorted list does not match expected order", correctAnswer[i], givenAnswer[i]);
        }
        System.out.println("testInsertionSortFloatInputByLen() passed \n");
    }

    /**Tests insertion sort on a float dataset from file, sorting by float length*/
    @Test
    public void testInsertionSortFloatFileByLen() {
        String fileName = "Test\\testInsertionSortFloatFile.csv";
        try { 
            FileWriter fileWrite = new FileWriter(fileName);
            fileWrite.write("0.0012,16.2,1,77.25");
            fileWrite.close();

            String[] correctAnswer = {"1", "16.2", "77.25", "0.0012"};
            CLIHandler handler = new CLIHandler();
            String[] testInput = handler.dataFromFile(fileName);
            String[] givenAnswer = handler.splitArray("Insertion", true, testInput);
            
            for (int i = 0; i < givenAnswer.length; i++) {
                assertEquals("Sorted list does not match expected order", correctAnswer[i], givenAnswer[i]);
            }
            System.out.println("testInsertionSortFloatFileByLen() passed \n");
        } 
        catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        
    }

    /**Tests insertion sort on a float dataset from input, sorting by float value*/
    @Test
    public void testInsertionSortFloatInputByVal() {
        String[] testInput = {"1", "0.009", "0.12", "3"};
        String[] correctAnswer = {"0.009", "0.12", "1", "3"};
        CLIHandler handler = new CLIHandler();
        String[] givenAnswer = handler.splitArray("Insertion", false, testInput);
        
        for (int i = 0; i < givenAnswer.length; i++) {
            assertEquals("Sorted list does not match expected order", correctAnswer[i], givenAnswer[i]);
        }
        System.out.println("testInsertionSortFLoatInputByVal() passed \n");
    }

    /**Tests insertion sort on a float dataset from file, sorting by float value*/
    @Test
    public void testInsertionSortFloatFileByVal() {
        String fileName = "Test\\testInsertionSortFloatFile.csv";
        try { 
            FileWriter fileWrite = new FileWriter(fileName);
            fileWrite.write("1,0.009,0.12,3");
            fileWrite.close();

            String[] correctAnswer = {"0.009", "0.12", "1", "3"};
            CLIHandler handler = new CLIHandler();
            String[] testInput = handler.dataFromFile(fileName);
            String[] givenAnswer = handler.splitArray("Insertion", false, testInput);
            
            for (int i = 0; i < givenAnswer.length; i++) {
                assertEquals("Sorted list does not match expected order", correctAnswer[i], givenAnswer[i]);
            }
            System.out.println("testInsertionSortFloatFileByVal() passed \n");
        } 
        catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        
    }





    //MIXED
    /**Tests insertion sort on a mixed value dataset from input, sorting numeric and string types by length*/
    @Test
    public void testInsertionSortMixedInputByLen() {
        String[] testInput = {"0.0012", "2", "Apple", "Kiwi"};
        String[] correctAnswer = {"2", "0.0012", "Kiwi", "Apple"};
        CLIHandler handler = new CLIHandler();
        String[] givenAnswer = handler.splitArray("Insertion", true, testInput);
        
        for (int i = 0; i < givenAnswer.length; i++) {
            assertEquals("Sorted list does not match expected order", correctAnswer[i], givenAnswer[i]);
        }
        System.out.println("testInsertionSortFloatInputByLen() passed \n");
    }

    /**Tests insertion sort on a mixed dataset from file, sorting numeric and string types by length*/
    @Test
    public void testInsertionSortMixedFileByLen() {
        String fileName = "Test\\testInsertionSortMixedFileByLen.csv";
        try { 
            FileWriter fileWrite = new FileWriter(fileName);
            fileWrite.write("0.0012,2,Apple,Kiwi");
            fileWrite.close();

            String[] correctAnswer = {"2", "0.0012", "Kiwi", "Apple"};
            CLIHandler handler = new CLIHandler();
            String[] testInput = handler.dataFromFile(fileName);
            String[] givenAnswer = handler.splitArray("Insertion", true, testInput);
            
            for (int i = 0; i < givenAnswer.length; i++) {
                assertEquals("Sorted list does not match expected order", correctAnswer[i], givenAnswer[i]);
            }
            System.out.println("testInsertionSortMixedFileByLen() passed \n");
        } 
        catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        
    }

    /**Tests insertion sort on a mixed dataset from input, sorting numeric by value and string by length*/
    @Test
    public void testInsertionSortMixedInputByVal() {
        String[] testInput = {"0.0012", "2", "Apple", "1.01", "Kiwi", "100"};
        String[] correctAnswer = {"0.0012", "1.01", "2", "100", "Kiwi", "Apple"};
        CLIHandler handler = new CLIHandler();
        String[] givenAnswer = handler.splitArray("Insertion", false, testInput);
        
        for (int i = 0; i < givenAnswer.length; i++) {
            assertEquals("Sorted list does not match expected order", correctAnswer[i], givenAnswer[i]);
        }
        System.out.println("testInsertionSortMixedInputByVal() passed \n");
    }

    /**Tests insertion sort on a mixed dataset from file, sorting numeric by value and string by length*/
    @Test
    public void testInsertionSortMixedFileByVal() {
        String fileName = "Test\\testInsertionSortMixedFile.csv";
        try { 
            FileWriter fileWrite = new FileWriter(fileName);
            fileWrite.write("0.0012,2,Apple,1.01,Kiwi,100");
            fileWrite.close();

            String[] correctAnswer = {"0.0012", "1.01", "2", "100", "Kiwi", "Apple"};
            CLIHandler handler = new CLIHandler();
            String[] testInput = handler.dataFromFile(fileName);
            String[] givenAnswer = handler.splitArray("Insertion", false, testInput);
            
            for (int i = 0; i < givenAnswer.length; i++) {
                assertEquals("Sorted list does not match expected order", correctAnswer[i], givenAnswer[i]);
            }
            System.out.println("testInsertionSortMixedFileByVal() passed \n");
        } 
        catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}
