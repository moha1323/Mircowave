package events;

/**
 * The singleton class, {@code TimerRanOutEvent} represents the event that the
 * show is over.
 * 
 * @author Yahya Mohamed, Marvin Va, and Adnan Wazwaz
 * @version 12 December 2020
 *
 */
public class TimerRanOutEvent {
	private static TimerRanOutEvent instance;

	/**
	 * It is not necessary to have more than one instance of this class, because
	 * this represents one specific event from the click of a specific button.
	 */
	private TimerRanOutEvent() {

	}

	/**
	 * Returns the only instance of {@code TimerRanOutEvent}. If none exists,
	 * then it instantiates one and returns it.
	 * 
	 * @return {@code instance}.
	 */
	public static TimerRanOutEvent instance() {
		if (instance == null) {
			instance = new TimerRanOutEvent();
		}
		return instance;
	}
}
