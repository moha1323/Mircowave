package events;

/**
 * The singleton class, {@code RewindEvent} represents the event that the
 * television show will rewind.
 * 
 * @author Yahya Mohamed, Marvin Va, and Adnan Wazwaz
 * @version 12 December 2020
 *
 */
public class RewindEvent {
	private static RewindEvent instance;

	/**
	 * It is not necessary to have more than one instance of this class, because
	 * this represents one specific event from the click of a specific button.
	 */
	private RewindEvent() {

	}

	/**
	 * Returns the only instance of {@code RewindEvent}. If none exists, then it
	 * instantiates one and returns it.
	 * 
	 * @return {@code instance}.
	 */
	public static RewindEvent instance() {
		if (instance == null) {
			instance = new RewindEvent();
		}
		return instance;
	}
}
