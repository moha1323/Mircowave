package states;

import events.FastForwardEvent;
import events.OffEvent;
import events.OnEvent;
import events.PauseEvent;
import events.PlayEvent;
import events.RewindEvent;
import events.SelectEvent;
import events.StopEvent;
import events.TimerRanOutEvent;
import events.TimerTickedEvent;

/**
 * The abstract class, {@code PlayerState} serves as an interface for the set of
 * common functions that a state would need to access in order for the program
 * to execute successfully in the FSM pattern.
 * <p>
 * Note: not to be confused with {@link PlayingState}, one of the subclasses of
 * this class.
 * 
 * @author Yahya Mohamed, Marvin Va, and Adnan Wazwaz
 * @version 12 December 2020
 *
 */
public abstract class PlayerState {

	/**
	 * When this method is called, a new state will take control of the event
	 * handling functions after the old state leaves.
	 */
	public abstract void enter();

	/**
	 * When this method is called, the current state relinquishes control of the
	 * event handling functions to the new state that will take its place.
	 */
	public abstract void leave();

	/**
	 * Changes the current state to the {@link OnState}
	 * 
	 * @param event
	 *            the {@link OnEvent}.
	 */
	public void handleEvent(OnEvent event) {

	}

	/**
	 * Changes the current state to the {@link OffState}
	 * 
	 * @param event
	 *            the {@link OffEvent}.
	 */
	public void handleEvent(OffEvent event) {

	}

	/**
	 * Changes the current state to the {@link ShowAtStartState}
	 * <p>
	 * Note: to go to this state, you must select a show.
	 * 
	 * @see {@link SelectEvent}
	 * 
	 * @param event
	 *            the {@link SelectEvent}.
	 */
	public void handleEvent(SelectEvent event) {

	}

	/**
	 * Changes the current state to the {@link PlayingState}
	 * 
	 * @param event
	 *            the {@link PlayEvent}.
	 */
	public void handleEvent(PlayEvent event) {

	}

	/**
	 * Changes the current state to the {@link CompletedState}
	 * <p>
	 * Note: to go to this state, the show must be stopped from viewing.
	 * 
	 * @see {@link StopEvent}
	 * 
	 * @param event
	 *            the {@link StopEvent}.
	 */
	public void handleEvent(StopEvent event) {

	}

	/**
	 * Changes the current state to the {@link PausedState}
	 * 
	 * @param event
	 *            the {@link PauseEvent}.
	 */
	public void handleEvent(PauseEvent event) {

	}

	/**
	 * Changes the current state to the {@link RewindingState}
	 * 
	 * @param event
	 *            the {@link RewindEvent}.
	 */
	public void handleEvent(RewindEvent event) {

	}

	/**
	 * Changes the current state to the {@link FastForwardingState}
	 * 
	 * @param event
	 *            the {@link FastForwardEvent}.
	 */
	public void handleEvent(FastForwardEvent event) {

	}

	/**
	 * Changes the current state to a new appropriate one depending on what the
	 * state to be replaced is.
	 * 
	 * @param event
	 *            the {@link TimerTickedEvent}.
	 */
	public void handleEvent(TimerTickedEvent event) {

	}

	/**
	 * Changes the current state to a new appropriate one depending on what the
	 * state to be replaced is.
	 * 
	 * @param event
	 *            the {@link TimerRanOutEvent}.
	 */
	public void handleEvent(TimerRanOutEvent event) {

	}

}
