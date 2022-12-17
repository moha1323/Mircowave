package states;

import events.FastForwardEvent;
import events.OffEvent;
import events.OnEvent;
import events.PauseEvent;
import events.PlayEvent;
import events.RewindEvent;
import events.SelectEvent;
import events.StopEvent;

/**
 * The singleton class, {@code ScreenSaverState} represents the state in the
 * television in which the TV is in the screen saver.
 * 
 * @author Yahya Mohamed, Marvin Va, and Adnan Wazwaz
 * @version 12 December 2020
 *
 */
public class ScreenSaverState extends PlayerState {
	private static ScreenSaverState instance;

	/**
	 * Satisfies the singleton property. It is not necessary to have more than one
	 * instance of this class because this is a specific predefined state with
	 * specific predefined [intended] unchangeable commands, which can be accessed
	 * globally.
	 */
	private ScreenSaverState() {

	}

	/**
	 * Returns the only instance of {@code ScreenSaverState}. If none exists, then
	 * it instantiates one and returns it.
	 * 
	 * @return {@code instance}
	 */
	public static ScreenSaverState instance() {
		if (instance == null) {
			instance = new ScreenSaverState();
		}
		return instance;
	}

	@Override
	public void handleEvent(OnEvent event) {
		PlayerContext.instance().changeState(PlayerContext.instance().getPreviousState());
	}

	@Override
	public void handleEvent(OffEvent event) {
		PlayerContext.instance().changeState(OffState.instance());
	}

	@Override
	public void handleEvent(SelectEvent event) {
		PlayerContext.instance().changeState(PlayerContext.instance().getPreviousState());
	}

	@Override
	public void handleEvent(PlayEvent event) {
		if (PlayerContext.instance().getPreviousState() == ShowAtStartState.instance()) {
			PlayerContext.instance().changeState(PlayingState.instance());
		} else {
			PlayerContext.instance().changeState(PlayerContext.instance().getPreviousState());
		}
	}

	@Override
	public void handleEvent(StopEvent event) {
		PlayerContext.instance().changeState(PlayerContext.instance().getPreviousState());
	}

	@Override
	public void handleEvent(PauseEvent event) {
		PlayerContext.instance().changeState(PlayerContext.instance().getPreviousState());
	}

	@Override
	public void handleEvent(RewindEvent event) {
		PlayerContext.instance().changeState(PlayerContext.instance().getPreviousState());
	}

	@Override
	public void handleEvent(FastForwardEvent event) {
		PlayerContext.instance().changeState(PlayerContext.instance().getPreviousState());
	}

	@Override
	public void enter() {
		PlayerContext.instance().displayScreenSaver();
	}

	@Override
	public void leave() {

	}

}
