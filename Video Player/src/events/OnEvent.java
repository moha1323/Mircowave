package events;
/**
 * The singleton class, {@code OnEvent} represents the event that the television
 * must be turned on.
 * 
 * @author Yahya Mohamed, Marvin Va, and Adnan Wazwaz
 * @version 12 December 2020
 *
 */
public class OnEvent {
	private static OnEvent instance;

	/**
	 * It is not necessary to have more than one instance of this class, because
	 * this represents one specific event from the click of a specific button.
	 */
	private OnEvent() {

	}

	/**
	 * Returns the only instance of {@code OnEvent}. If none exists, then it
	 * instantiates one and returns it.
	 * 
	 * @return {@code instance}.
	 */
	public static OnEvent instance() {
		if (instance == null) {
			instance = new OnEvent();
		}
		return instance;
	}
}
