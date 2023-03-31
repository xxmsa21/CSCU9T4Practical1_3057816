//This class holds information for a single Cycling session
package stir.ae;
/**
 * @author Shahyan Ahmed - 3057816
 *
 */
public class CycleEntry extends Entry{
	String terrain;
	String tempo;
	
	/**
	 * Constructor
	 * @param n name
	 * @param d day
	 * @param m month
	 * @param y year
	 * @param h hours
	 * @param min minutes
	 * @param s seconds
	 * @param dist distance
	 * @param terrain
	 * @param tempo
	 */
	public CycleEntry(String n, int d, int m, int y, int h, int min, int s, float dist,
			String terrain, String tempo) {
		super(n, d, m, y, h, min, s, dist);
		this.terrain = terrain;
		this.tempo = tempo;
	}

	/**
	 * @return the terrain
	 */
	public String getTerrain() {
		return terrain;
	}

	/**
	 * @param terrain the terrain to set
	 */
	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}

	/**
	 * @return the tempo
	 */
	public String getTempo() {
		return tempo;
	}

	/**
	 * @param tempo the tempo to set
	 */
	public void setTempo(String tempo) {
		this.tempo = tempo;
	}
	
	@Override
	public String getEntry () {
		   String result = getName()+" cycled " + getDistance() + " km in "
		             +getHour()+":"+getMin()+":"+ getSec() + " on "
		             +getDay()+"/"+getMonth()+"/"+getYear() + " on "
		             +getTerrain()+ " at " +getTempo()+ " tempo" + "\n";
		   return result;
		  }
	
}
