package events;

/**
 * The singleton class, {@code SelectEvent} represents the event that the user
 * is selecting a show to watch.
 * 
 * @author Yahya Mohamed, Marvin Va, and Adnan Wazwaz
 * @version 12 December 2020
 *
 */
public class SelectEvent {
	private static SelectEvent instance;

	/**
	 * It is not necessary to have more than one instance of this class, because
	 * this represents one specific event from the click of a specific button.
	 */
	private SelectEvent() {

	}

	/**
	 * Returns the only instance of {@code SelectEvent}. If none exists, then it
	 * instantiates one and returns it.
	 * 
	 * @return {@code instance}.
	 */
	public static SelectEvent instance() {
		if (instance == null) {
			instance = new SelectEvent();
		}
		return instance;
	}

}
