// GUI and main program for the Training Record
package stir.ae;
/**
 * @author Shahyan Ahmed - 3057816
 *
 */
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

@SuppressWarnings({ "serial", "unused" })
public class TrainingRecordGUI extends JFrame implements ActionListener {

	//initializing the text fields, buttons and text area of the GUI
    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    private JTextField recovery = new JTextField(2);
    private JTextField repetitions = new JTextField(2);
    private JTextField terrain = new JTextField(12);
    private JTextField tempo = new JTextField(12);
    private JTextField where = new JTextField(12);
    private JTextField session = new JTextField(10);
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km):");
    private JLabel labrec = new JLabel(" Recovery: ");
    private JLabel labrep = new JLabel(" Repetitions: ");
    private JLabel labter = new JLabel(" Terrain: ");
    private JLabel labwhere = new JLabel(" Where: ");
    private JLabel labtempo = new JLabel(" Tempo: ");
    private JLabel labses = new JLabel(" Session Type: ");
    private JButton addR = new JButton("Add");
    private JButton lookUpByDate = new JButton("Look Up");
    private JButton FindAllByDate = new JButton("Find All By Date");
    private JButton FindAllByName = new JButton("Find All By Name");
    private JButton remove = new JButton("Remove");

    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(5, 50);

    public static void main(String[] args) {
        @SuppressWarnings("unused")
		TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // set up the GUI 
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());
        add(labn);
        add(name);
        name.setEditable(true);
        add(labd);
        add(day);
        day.setEditable(true);
        add(labm);
        add(month);
        month.setEditable(true);
        add(laby);
        add(year);
        year.setEditable(true);
        add(labh);
        add(hours);
        hours.setEditable(true);
        add(labmm);
        add(mins);
        mins.setEditable(true);
        add(labs);
        add(secs);
        secs.setEditable(true);
        add(labdist);
        add(dist);
        dist.setEditable(true);
        add(labrec);
        add(recovery);
        recovery.setEditable(true);
        add(labrep);
        add(repetitions);
        repetitions.setEditable(true);
        add(labter);
        add(terrain);
        terrain.setEditable(true);
        add(labtempo);
        add(tempo);
        tempo.setEditable(true);
        add(labwhere);
        add(where);
        where.setEditable(true);
        add(labses);
        add(session);
        session.setEditable(true);
        add(addR);
        addR.addActionListener(this);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        add(FindAllByDate);
        FindAllByDate.addActionListener(this);
        add(FindAllByName);
        FindAllByName.addActionListener(this);
        add(remove);
        remove.addActionListener(this);
        add(outputArea);
        outputArea.setEditable(false);
        setSize(720, 200);
        setVisible(true);
        blankDisplay();
    } 

    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) {
        String message = "";
        if (event.getSource() == addR) {
            message = addEntry(session.getText()); //passing the session's input as parameter
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        if (event.getSource() == FindAllByDate) {
        	message = FindAll_by_date();
       }
        if (event.getSource() == remove) {
        	message = remove();
        }
        if (event.getSource() == FindAllByName) {
        	message = FindAll_by_name();
        }
        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed

    /**
     * Method to add the entry based on the session type
     * @param what session type
     * @return String
     */
    public String addEntry(String what) {
        String message = "Record added\n";
        System.out.println("Adding " + what + " entry to the records");
        // trim whitespace from input for String type
        String n = name.getText().trim(); 
        String temp = tempo.getText().trim();
        String ter = terrain.getText().trim();
        String wher = where.getText().trim();
        int m, d, y, h, mm, s,rec,rep;
        float km;

        try {
            m = Integer.parseInt(month.getText());
            d = Integer.parseInt(day.getText());
            y = Integer.parseInt(year.getText());
            km = java.lang.Float.parseFloat(dist.getText());
            h = Integer.parseInt(hours.getText());
            mm = Integer.parseInt(mins.getText());
            s = Integer.parseInt(secs.getText());
            
            if (n.isEmpty()) { // check if name input is empty
                message = "Name cannot be empty";
            } 
            else if (myAthletes.containsEntry(n, d, m, y)) { // check if entry already exists
                message = "Entry already exists";
            } 
            //checking if certain fields would be empty for different sessions
            else if(what.isEmpty()) {
            	message = "Please enter the session type";
            }
            else if(what.contains("ycl")) {
            	if(ter.isEmpty() || temp.isEmpty()) {
            		message = "Terrain or Tempo not entered!! Please enter";
            	}
            }
            else if(what.contains("wim")) {
            	if(wher.isEmpty()) {
            		message = "Where not entered!! Please enter";
            	}
            }
            else {
            	//used contains so that different types of inputs could be catered
            	//Cycle session
            	if (what.contains("ycl")) {
            		CycleEntry c = new CycleEntry(n, d, m, y, h, mm, s, km, ter, temp);
            		myAthletes.addEntry(c);
            	}
            	//Swim session
            	else if(what.contains("wim")) {
            		SwimEntry sw = new SwimEntry(n, d, m, y, h, mm, s, km, wher);
            		myAthletes.addEntry(sw);
            	}
            	//Sprint session
            	else if(what.contains("print")) {
            		if (!recovery.getText().equals("") && !repetitions.getText().equals("")) {
                    	rec = Integer.parseInt(recovery.getText());
                        rep = Integer.parseInt(repetitions.getText());
                        SprintEntry sp = new SprintEntry(n, d, m, y, h, mm, s, km, rep, rec);
                		myAthletes.addEntry(sp);
                    }
            	}
            }
        } 
        catch (NumberFormatException e) { // catch invalid input exceptions
            message = "Invalid input. Please enter valid values\n"
            		+ "(Check for Date, Time, Distance, Recovery & Repetitions(For Sprint))";
        }

        return message;
    }

    /**
     * Method to lookup entry with the date provided
     * @return String
     */
    public String lookupEntry() {
    	String message;
    	try {
    		int m = Integer.parseInt(month.getText());
            int d = Integer.parseInt(day.getText());
            int y = Integer.parseInt(year.getText());
            outputArea.setText("looking up record ...");
            message = myAthletes.lookupEntry(d, m, y);
    	}
    	catch (NumberFormatException e) { // catch invalid input exceptions
            message = "Invalid input. Please enter valid values\n"
            		+ "(Check for Date)";
        }
    	return message;
    }
    
    /**
     * Method to find all entries based on date
     * @return String
     */
    public String FindAll_by_date() {
    	String message;
    	try {
    		int m = Integer.parseInt(month.getText());
            int d = Integer.parseInt(day.getText());
            int y = Integer.parseInt(year.getText());
            outputArea.setText("looking up record ...");
            message = myAthletes.FindAll_by_date(d, m, y);
    	}
    	catch (NumberFormatException e) { // catch invalid input exceptions
            message = "Invalid input. Please enter valid values\n"
            		+ "(Check for Date";
        }
        
        return message;
    }
    
    /**
     * Method to find all entries based on name
     * @return
     */
    public String FindAll_by_name() {
    	String n = name.getText();
    	String message;
    	if (n.isEmpty()) { // check if name input is empty
            message = "Name cannot be empty";
        }
    	else {
    		outputArea.setText("looking up record ...");
            message = myAthletes.FindAll_by_name(n);
    	}
        
        return message;
    }
    
    /**
     * Method to remove an entry
     * @return String
     */
    public String remove() {
    	String n = name.getText();
    	String message;
    	try {
    		int m = Integer.parseInt(month.getText());
            int d = Integer.parseInt(day.getText());
            int y = Integer.parseInt(year.getText());
    		if (n.isEmpty()) { // check if name input is empty
                message = "Name cannot be empty";
            }
        	else {
                message = myAthletes.removeEntry(n,d,m,y);
        	}
    	}
    	catch (NumberFormatException e) { // catch invalid input exceptions
            message = "Invalid input. Please enter valid values\n"
            		+ "(Check for Date, Time";
        }
        return message;
    }
    
    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");
        tempo.setText("");
        terrain.setText("");
        where.setText("");
        recovery.setText("");
        repetitions.setText("");
        session.setText("");
    }// blankDisplay
    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
    }
    /*public void fillDisplayCycle(CycleEntry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
        tempo.setText(String.valueOf(ent.getTempo()));
        terrain.setText(String.valueOf(ent.getTerrain()));
    }
    public void fillDisplaySprint(SprintEntry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
        recovery.setText(String.valueOf(ent.getRecovery()));
        repetitions.setText(String.valueOf(ent.getRepetitions()));
    }
    public void fillDisplaySwim(SwimEntry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
        where.setText(String.valueOf(ent.getWhere()));
    }*/

} // TrainingRecordGUI

