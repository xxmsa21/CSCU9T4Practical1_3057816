// An implementation of a Training Record as an ArrayList
package stir.ae;
/**
 * @author Shahyan Ahmed - 3057816
 *
 */
import java.util.*;


public class TrainingRecord {
	private List<Entry> tr;

	public TrainingRecord() {
		tr = new ArrayList<Entry>();
	} //constructor

	// add a record to the list
	public void addEntry(Entry e){
		if (!tr.contains(e)) {
			tr.add(e);    
		}
	} // addClass

	/**
	 * Method to check whether the entry already exists
	 * @param n name
	 * @param d day
	 * @param m month
	 * @param y year
	 * @return boolean
	 */
	public boolean containsEntry(String n, int d, int m, int y) {
		for (Entry e : tr) {
			if (e.getName().equals(n) && e.getDay() == d
					&& e.getMonth() == m && e.getYear() == y) {
				return true;
			}
		}
		return false;
	}
	// look up the entry of a given day and month
	/**
	 * @param d
	 * @param m
	 * @param y
	 * @return String
	 */
	public String lookupEntry (int d, int m, int y) {
		ListIterator<Entry> iter = tr.listIterator();
		String result = "";
		while (iter.hasNext()) {
			Entry current = iter.next();
			if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
				result = current.getEntry();
		}
		if (result.equals("")) {
			return "No entries found";
		}
		else {
			return result;
		}
	} // lookupEntry

	/**
	 * Method to find the entries based on the date
	 * @param d day
	 * @param m month
	 * @param y year
	 * @return String
	 */
	public String FindAll_by_date(int d, int m, int y) {
		ListIterator<Entry> iter = tr.listIterator();
		String result = "";
		while (iter.hasNext()) {
			Entry current = iter.next();
			if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
				result += current.getEntry();
		}
		if (result.equals("")) {
			return "No entries found";
		}
		else {
			return result;
		}
	}

	/**
	 * Method to find the entries based on name
	 * @param n name
	 * @return String
	 */
	public String FindAll_by_name(String n) {
		ListIterator<Entry> iter = tr.listIterator();
		String result = "";
		while (iter.hasNext()) {
			Entry current = iter.next();
			if ((current.getName()).compareToIgnoreCase(n) == 0) 
				result += current.getEntry();
		}
		if (result.equals("")) {
			return "No entries found";
		}
		else {
			return result;
		}
	}

	/**
	 * Method to remove an entry from the list that has matching name, date, month and year
	 * @param n name
	 * @param d day
	 * @param m month
	 * @param y year
	 * @return String
	 */
	public String removeEntry(String n, int d, int m, int y) {
		ListIterator<Entry> iter = tr.listIterator();
		String result = "";
		while (iter.hasNext()) {
			Entry current = iter.next();
			if ((current.getName()).compareToIgnoreCase(n) == 0 && current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
				iter.remove();
			result = "Entry removed";
		}
		if (result.equals("")){
			return "No such entry found";
		}
		else {
			return result;
		}
	}

	// Count the number of entries
	public int getNumberOfEntries(){
		return tr.size();
	}
	// Clear all entries
	public void clearAllEntries(){
		tr.clear();
	}

} // TrainingRecord