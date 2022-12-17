package timer;

import events.TimerRanOutEvent;
import events.TimerTickedEvent;

/**
 * The interface, {@code Notifiable}, serves as an entity that can be notified
 * of timing events
 * 
 * @author Yahya Mohamed, Marvin Va, and Adnan Wazwaz
 * @version 12 December 2020
 *
 */
public interface Notifiable {
	/**
	 * Processes the timer when a unit of time ticks.
	 * 
	 * @param event
	 *            the {@code TimerTickedEvent}.
	 */
	public void handleEvent(TimerTickedEvent event);

	/**
	 * Processes the timer when the amount of time has run out.
	 * 
	 * @param event
	 *            the {@code TimerRanOutEvent}.
	 */
	public void handleEvent(TimerRanOutEvent event);
}
