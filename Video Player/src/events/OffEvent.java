package events;

/**
 * The singleton class, {@code OffEvent} represents the event that the
 * television must be turned off.
 * 
 * @author Yahya Mohamed, Marvin Va, and Adnan Wazwaz
 * @version 12 December 2020
 *
 */
public class OffEvent {
	private static OffEvent instance;

	/**
	 * It is not necessary to have more than one instance of this class, because
	 * this represents one specific event from the click of a specific button.
	 */
	private OffEvent() {

	}

	/**
	 * Returns the only instance of {@code OffEvent}. If none exists, then it
	 * instantiates one and returns it.
	 * 
	 * @return {@code instance}.
	 */
	public static OffEvent instance() {
		if (instance == null) {
			instance = new OffEvent();
		}
		return instance;
	}
}
