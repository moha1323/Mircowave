package events;

/**
 * The singleton class, {@code FastForwardEvent} represents the event that a
 * show will fast forward.
 * 
 * @author Yahya Mohamed, Marvin Va, and Adnan Wazwaz
 * @version 12 December 2020
 *
 */
public class FastForwardEvent {
	private static FastForwardEvent instance;

	/**
	 * It is not necessary to have more than one instance of this class, because
	 * this represents one specific event from the click of a specific button.
	 */
	private FastForwardEvent() {

	}

	/**
	 * Returns the only instance of {@code FastForwardEvent}. If none exists,
	 * then it instantiates one and returns it.
	 * 
	 * @return {@code instance}.
	 */
	public static FastForwardEvent instance() {
		if (instance == null) {
			instance = new FastForwardEvent();
		}
		return instance;
	}

}
