/*
 * Test class for TrainingRecordGUI
 * It is not finished as we're not expecting you to implement GUI testing
 * However, you're welcome to use this starter template and extend it and add
 * test for public methods you implement in TrainingRecordGUI.java
 */
package stir.ae;

import java.awt.event.ActionEvent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
// Only used if you want to use reflection to test private features
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.swing.JButton;




/**
 * @author Shahyan Ahmed - 3057816
 *
 */
@SuppressWarnings("unused")
public class TrainingRecordGUITest {

    public TrainingRecordGUITest() {
    }

    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    /**
     * Test of main method, of class TrainingRecordGUI.
     * just tests if the class can be initialised without errors
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        TrainingRecordGUI.main(args);
    }

    /**
     * Test of actionPerformed method, of class TrainingRecordGUI.
     * This doesn't test anything but might be used in evaluations
     */
    @Test
    public void testActionPerformed() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        System.out.println("Action not performed");
    }

    /**
     * Test of blankDisplay method, of class TrainingRecordGUI.
     * It just executes the method to see if it doesn't throw an exception
     */
    @Test
    public void testBlankDisplay() {
        System.out.println("blankDisplay");
        TrainingRecordGUI instance = new TrainingRecordGUI();
        instance.blankDisplay();
    }
    
    /**
     * Test of addEntry method, of class TrainingRecordGUI
     * 
     */
    @Test
    public void testAddEntry(){
        System.out.println("addEntry");
        TrainingRecordGUI instance = new TrainingRecordGUI();
        Entry entry = new Entry("Alice", 1, 2, 2003, 0, 16, 7, 3);
        instance.fillDisplay(entry);
        String message = instance.addEntry("generic");
        System.out.println(message);
        if(message.contains("Invalid")) {
        	assertEquals(message, ("Invalid input. Please enter valid values\n"
            		+ "(Check for Date"));
        }
        else if(message.equals("Name cannot be empty")) {
        	assertEquals(message, "Name cannot be empty");
        }
        else if(message.equals("Entry already exists")) {
        	assertEquals(message,"Entry already exists");
        }
        else if(message.equals("Please enter the session type")) {
        	assertEquals(message,"Please enter the session type");
        }
        else if(message.equals("Terrain or Tempo not entered!! Please enter")) {
        	assertEquals(message,"Terrain or Tempo not entered!! Please enter");
        }
        else if(message.equals("Where not entered!! Please enter")) {
        	assertEquals(message,"Where not entered!! Please enter");
        }
        else {
        	assertEquals(message,"Record added\n");
        }
        
    }
    
    @Test
    public void testFindAllByName(){
    	System.out.println("addEntry");
        TrainingRecordGUI instance = new TrainingRecordGUI();
        Entry entry = new Entry("Alice", 1, 2, 2003, 0, 16, 7, 3);
        instance.fillDisplay(entry);
        String message = instance.addEntry("generic");
        System.out.println(message);
        Entry entry2 = new Entry("Alice", 1, 2, 2005, 0, 17, 7, 4);
        instance.fillDisplay(entry2);
        String message2 = instance.addEntry("generic");
        System.out.println(message2);
        String message3 = instance.FindAll_by_name();
        if(message3.equals("No entries found")){
            assertEquals(message3, "No entries found");
        } 
        else if(message3.equals("Name cannot be empty")) {
        	assertEquals(message3, "Name cannot be empty");
        }
        else {
            assertEquals(message3, "Alice ran 3.0 km in 0:16:7 on 1/2/2003\nAlice ran 4.0 km in 0:17:7 on 1/2/2005\n");
        }   
     }
    
    @Test
    public void testFindAllByDate(){
        System.out.println("addEntry");
        TrainingRecordGUI instance = new TrainingRecordGUI();
        Entry entry = new Entry("Alice", 1, 2, 2003, 0, 16, 7, 3);
        instance.fillDisplay(entry);
        String message = instance.addEntry("generic");
        System.out.println(message);
        Entry entry2 = new Entry("Baron", 1, 2, 2003, 0, 16, 7, 3);
        instance.fillDisplay(entry2);
        String message2 = instance.addEntry("generic");
        System.out.println(message2);
        String message3 = instance.FindAll_by_date();
        if(message3.equals("No entries found")){
            assertEquals(message3, "No entries found");
        } 
        else if(message3.contains("Invalid")) {
        	assertEquals(message3, ("Invalid input. Please enter valid values\n"
            		+ "(Check for Date"));
        }
        else {
            assertEquals(message3, "Alice ran 3.0 km in 0:16:7 on 1/2/2003\nBaron ran 3.0 km in 0:16:7 on 1/2/2003\n");
        }   
     }
    
    @Test
    public void testLookUp(){
    	System.out.println("addEntry");
        TrainingRecordGUI instance = new TrainingRecordGUI();
        Entry entry = new Entry("Alice", 1, 2, 2003, 0, 16, 7, 3);
        instance.fillDisplay(entry);
        String message = instance.addEntry("generic");
        System.out.println(message);
        message = instance.lookupEntry();
        if(message.equals("No entries found")){
            assertEquals(message, "No entries found");
        } 
        else if(message.equals("Name cannot be empty")) {
        	assertEquals(message, "Name cannot be empty");
        }
        else if(message.contains("Invalid")) {
        	assertEquals(message, ("Invalid input. Please enter valid values\n"
            		+ "(Check for Date"));
        }
        else {
            assertEquals(message, "Alice ran 3.0 km in 0:16:7 on 1/2/2003\n");
        }
    }
    
    @Test
    public void testAddRemove(){
        System.out.println("removeEntry");
        TrainingRecordGUI instance = new TrainingRecordGUI();
        Entry entry = new Entry("Alice", 1, 2, 2003, 0, 16, 7, 3);
        instance.fillDisplay(entry);
        String message = instance.addEntry("generic");
        System.out.println(message);
        message = instance.remove();
        if(message.equals("No such entry found")) {
        	assertEquals(message, "No such entry found");
        }
        else if(message.equals("Name cannot be empty")) {
        	assertEquals(message, "Name cannot be empty");
        }
        else {
        	assertEquals(message,"Entry removed");
        }
    }
    
    /**
     * Test to see if all display requirements have been met
     */
    @Test
    public void testButtonsPresentInGUI() throws IllegalAccessException, IllegalArgumentException{
        System.out.println("Check if you have added the buttons"); 
        TrainingRecordGUI instance = new TrainingRecordGUI();
        Class<?> instanceClass = instance.getClass();
        String[] expectedFields = {"addR","FindAllByDate","lookUpByDate","remove","FindAllByName"}; // add RemoveEntry when it is ready
        Field fields[] = instanceClass.getDeclaredFields();
        int found = 0;
        for (Field field : fields) {
            if (Arrays.asList(expectedFields).contains(field.getName())){
                found += 1;
                field.setAccessible(true);
                assertTrue(field.get(instance) instanceof JButton);
            }
        }
        assertEquals(found,expectedFields.length,"Have you added all required buttons?");
    }
}
