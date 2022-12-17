package shows;

/**
 * The class, {@code Show} represents a single television show among the list of
 * available shows that a user can select and play.
 * 
 * @author Yahya Mohamed, Marvin Va, Adnan Wazwaz
 * @version 12 December 2020.
 *
 */
public class Show {
	private String name;
	private int runningTime;

	/**
	 * Generates a constructor for {@code Show}. Creates a "show" with the given
	 * name and running time
	 * 
	 * @param name
	 *            the name of the show
	 * @param runningTime
	 *            the running time in seconds
	 */
	public Show(String name, int runningTime) {
		this.name = name;
		this.runningTime = runningTime;
	}

	/**
	 * Returns the name of the show.
	 * 
	 * @return {@code name}
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the running time of the show.
	 * 
	 * @return {@code runningTime}
	 */
	public int getRunningTime() {
		return runningTime;
	}

	@Override
	public String toString() {
		return name + " " + runningTime + " seconds";
	}
}
