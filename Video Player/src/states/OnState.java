package states;

import events.OffEvent;
import events.SelectEvent;
import events.TimerRanOutEvent;
import events.TimerTickedEvent;
import timer.Notifiable;
import timer.Timer;

/**
 * The singleton class, {@code OffState} represents the state in the television
 * in which the TV is on and can access other controls.
 * 
 * @author Yahya Mohamed, Marvin Va, and Adnan Wazwaz
 * @version 12 December 2020
 *
 */
public class OnState extends PlayerState implements Notifiable {
	private static OnState instance;
	private Timer timer;

	/**
	 * Satisfies the singleton property. It is not necessary to have more than one
	 * instance of this class because this is a specific predefined state with
	 * specific predefined [intended] unchangeable commands, which can be accessed
	 * globally.
	 */
	private OnState() {
		instance = this;
	}

	/**
	 * Returns the only instance of {@code OnState}. If none exists, then it
	 * instantiates one and returns it.
	 * 
	 * @return {@code instance}
	 */
	public static OnState instance() {
		if (instance == null) {
			instance = new OnState();
		}
		return instance;
	}

	@Override
	public void handleEvent(OffEvent event) {
		PlayerContext.instance().changeState(OffState.instance());
	}

	@Override
	public void handleEvent(SelectEvent event) {
		PlayerContext.instance().changeState(ShowAtStartState.instance());
	}

	public void handleEvent(TimerTickedEvent event) {
		PlayerContext.instance().displayPlayerOn();
	}

	public void handleEvent(TimerRanOutEvent event) {
		PlayerContext.instance().changeState(ScreenSaverState.instance());
	}

	@Override
	public void enter() {
		timer = new Timer(this, 10);
		PlayerContext.instance().displayPlayerOn();
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
	}

}
