package states;

import display.ShowPanel;
import events.FastForwardEvent;
import events.OffEvent;
import events.PauseEvent;
import events.RewindEvent;
import events.StopEvent;
import events.TimerRanOutEvent;
import events.TimerTickedEvent;
import timer.Notifiable;
import timer.Timer;

/**
 * The singleton class, {@code PlayingState} represents the state in the
 * television in which the currently viewing show is playing.
 * <p>
 * Note: not to be confused with {@link PlayerState}, the superclass of this
 * class.
 * 
 * @author Yahya Mohamed, Marvin Va, and Adnan Wazwaz
 * @version 12 December 2020
 *
 */
public class PlayingState extends PlayerState implements Notifiable {
	private static PlayingState instance;
	private Timer timer;

	/**
	 * Satisfies the singleton property. It is not necessary to have more than one
	 * instance of this class because this is a specific predefined state with
	 * specific predefined [intended] unchangeable commands, which can be accessed
	 * globally.
	 */
	private PlayingState() {

	}

	/**
	 * Returns the only instance of {@code PlayingState}. If none exists, then it
	 * instantiates one and returns it.
	 * 
	 * @return {@code instance}
	 */
	public static PlayingState instance() {
		if (instance == null) {
			instance = new PlayingState();
		}
		return instance;
	}

	@Override
	public void handleEvent(OffEvent event) {
		PlayerContext.instance().changeState(OffState.instance());
	}

	@Override
	public void handleEvent(StopEvent event) {
		PlayerContext.instance().changeState(CompletedState.instance());
	}

	@Override
	public void handleEvent(PauseEvent event) {
		PlayerContext.instance().changeState(PausedState.instance());
	}

	@Override
	public void handleEvent(RewindEvent event) {
		PlayerContext.instance().changeState(RewindingState.instance());
	}

	@Override
	public void handleEvent(FastForwardEvent event) {
		PlayerContext.instance().changeState(FastforwardingState.instance());
	}

	@Override
	public void handleEvent(TimerTickedEvent event) {
		PlayerContext.instance().setTimeOn(timer.getTimeValue());
		PlayerContext.instance().displayShowPlaying(PlayerContext.instance().getTimeOn());
	}

	@Override
	public void handleEvent(TimerRanOutEvent event) {
		PlayerContext.instance().displayShowPlaying(0);
		PlayerContext.instance().changeState(CompletedState.instance());
	}

	@Override
	public void enter() {
		if (PlayerContext.instance().getTimeOn() == 0) {
			timer = new Timer(this, ShowPanel.instance().getShow().getRunningTime());
		} else {
			timer = new Timer(this, PlayerContext.instance().getTimeOn());
		}
		PlayerContext.instance().setTimeOn(timer.getTimeValue());
		PlayerContext.instance().displayShowPlaying(PlayerContext.instance().getTimeOn());
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
	}
}
