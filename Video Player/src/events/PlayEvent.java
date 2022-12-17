package events;

/**
 * The singleton class, {@code PlayEvent} represents the event that the show
 * will play.
 * 
 * @author Yahya Mohamed, Marvin Va, and Adnan Wazwaz
 * @version 12 December 2020
 *
 */
public class PlayEvent {
	private static PlayEvent instance;

	/**
	 * It is not necessary to have more than one instance of this class, because
	 * this represents one specific event from the click of a specific button.
	 */
	private PlayEvent() {

	}

	/**
	 * Returns the only instance of {@code PlayEvent}. If none exists, then it
	 * instantiates one and returns it.
	 * 
	 * @return {@code instance}.
	 */
	public static PlayEvent instance() {
		if (instance == null) {
			instance = new PlayEvent();
		}
		return instance;
	}
}
