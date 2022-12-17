package states;

import events.OffEvent;
import events.PlayEvent;
import events.StopEvent;

/**
 * The singleton class, {@code PausedState} represents the state in the
 * television in which the currently viewing show is paused.
 * 
 * @author Yahya Mohamed, Marvin Va, and Adnan Wazwaz
 * @version 12 December 2020
 *
 */
public class PausedState extends PlayerState {
	private static PausedState instance;

	/**
	 * Satisfies the singleton property. It is not necessary to have more than one
	 * instance of this class because this is a specific predefined state with
	 * specific predefined [intended] unchangeable commands, which can be accessed
	 * globally.
	 */
	private PausedState() {

	}

	/**
	 * Returns the only instance of {@code PausedState}. If none exists, then it
	 * instantiates one and returns it.
	 * 
	 * @return {@code instance}
	 */
	public static PausedState instance() {
		if (instance == null) {
			instance = new PausedState();
		}
		return instance;
	}

	@Override
	public void handleEvent(OffEvent event) {
		PlayerContext.instance().changeState(OffState.instance());
	}

	@Override
	public void handleEvent(PlayEvent event) {
		PlayerContext.instance().changeState(PlayingState.instance());
	}

	@Override
	public void handleEvent(StopEvent event) {
		PlayerContext.instance().changeState(CompletedState.instance());
	}

	@Override
	public void enter() {
		PlayerContext.instance().displayShowPaused(PlayerContext.instance().getTimeOn());
	}

	@Override
	public void leave() {

	}

}
