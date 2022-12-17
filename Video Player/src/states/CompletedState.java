package states;

import display.ShowPanel;
import events.OffEvent;
import events.PlayEvent;
import events.SelectEvent;
import events.StopEvent;
import events.TimerRanOutEvent;
import events.TimerTickedEvent;
import timer.Notifiable;
import timer.Timer;

/**
 * The singleton class, {@code CompletedState} represents the state in the
 * television in which a show has stopped being viewed, whether by request of
 * the user, or by the show reaching the end of it's duration.
 * 
 * @author Yahya Mohamed, Marvin Va, and Adnan Wazwaz
 * @version 12 December 2020
 *
 */
public class CompletedState extends PlayerState implements Notifiable {
	private static CompletedState instance;
	private Timer timer;

	/**
	 * Satisfies the singleton property. It is not necessary to have more than one
	 * instance of this class because this is a specific predefined state with
	 * specific predefined [intended] unchangeable commands, which can be accessed
	 * globally.
	 */
	private CompletedState() {

	}

	/**
	 * Returns the only instance of {@code CompletedState}. If none exists, then it
	 * instantiates one and returns it.
	 * 
	 * @return {@code instance}
	 */
	public static CompletedState instance() {
		if (instance == null) {
			instance = new CompletedState();
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

	@Override
	public void handleEvent(PlayEvent event) {
		PlayerContext.instance().changeState(PlayingState.instance());
	}

	@Override
	public void handleEvent(StopEvent event) {
		PlayerContext.instance().changeState(OnState.instance());
	}

	@Override
	public void handleEvent(TimerTickedEvent event) {
		PlayerContext.instance().displayShowCompleted();
	}

	@Override
	public void handleEvent(TimerRanOutEvent event) {
		PlayerContext.instance().changeState(OnState.instance());
		PlayerContext.instance().changeState(ScreenSaverState.instance());
	}

	@Override
	public void enter() {
		timer = new Timer(this, 10);
		PlayerContext.instance().displayShowCompleted();
	}

	@Override
	public void leave() {
		PlayerContext.instance().setTimeOn(ShowPanel.instance().getShow().getRunningTime());
		timer.stop();
		timer = null;
	}
}
