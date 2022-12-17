package events;

/**
 * The singleton class, {@code StopEvent} represents the event that the show
 * stops streaming, or is deselected.
 * 
 * @author Yahya Mohamed, Marvin Va, and Adnan Wazwaz
 * @version 12 December 2020
 *
 */
public class StopEvent {
	private static StopEvent instance;

	/**
	 * It is not necessary to have more than one instance of this class, because
	 * this represents one specific event from the click of a specific button.
	 */
	private StopEvent() {

	}

	/**
	 * Returns the only instance of {@code StopEvent}. If none exists, then it
	 * instantiates one and returns it.
	 * 
	 * @return {@code instance}.
	 */
	public static StopEvent instance() {
		if (instance == null) {
			instance = new StopEvent();
		}
		return instance;
	}
}
