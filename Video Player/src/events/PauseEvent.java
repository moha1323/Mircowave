package events;

/**
 * The singleton class, {@code PauseEvent} represents the event that the show
 * will pause.
 * 
 * @author Yahya Mohamed, Marvin Va, and Adnan Wazwaz
 * @version 12 December 2020
 *
 */
public class PauseEvent {
	private static PauseEvent instance;

	/**
	 * It is not necessary to have more than one instance of this class, because
	 * this represents one specific event from the click of a specific button.
	 */
	private PauseEvent() {

	}

	/**
	 * Returns the only instance of {@code PauseEvent}. If none exists, then it
	 * instantiates one and returns it.
	 * 
	 * @return {@code instance}.
	 */
	public static PauseEvent instance() {
		if (instance == null) {
			instance = new PauseEvent();
		}
		return instance;
	}
}
