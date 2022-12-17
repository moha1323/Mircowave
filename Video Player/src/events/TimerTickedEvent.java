package events;

/**
 * This class, {@code TimerTickedEvent} represents a clock tick. The object
 * contains the amount of time left in the timer. This event for the most part
 * runs as a background process.
 * 
 * @author Yahya Mohamed, Marvin Va, and Adnan Wazwaz.z
 *
 */

public class TimerTickedEvent {
	private int timeLeft;

	/**
	 * Generates a new constructor for {@code TimerTickedEvent}. Stores the
	 * amount of time left in the Timer.
	 * 
	 * @param value
	 *            the amount of time left in seconds.
	 */
	public TimerTickedEvent(int value) {
		this.timeLeft = value;
	}

	/**
	 * Returns the amount of time left in the timer.
	 * 
	 * @return {@code timeLeft}.
	 */
	public int getTimeLeft() {
		return timeLeft;
	}
}
