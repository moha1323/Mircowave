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
 * The singleton class, {@code ScreenSaverState} represents the state in the
 * television in which the user has selected a show and the show is displayed.
 * 
 * @author Yahya Mohamed, Marvin Va, and Adnan Wazwaz
 * @version 12 December 2020
 *
 */
public class ShowAtStartState extends PlayerState implements Notifiable {
	private static ShowAtStartState instance;
	private Timer timer;

	/**
	 * Satisfies the singleton property. It is not necessary to have more than one
	 * instance of this class because this is a specific predefined state with
	 * specific predefined [intended] unchangeable commands, which can be accessed
	 * globally.
	 */
	private ShowAtStartState() {

	}

	/**
	 * Returns the only instance of {@code ShowAtStartState}. If none exists, then
	 * it instantiates one and returns it.
	 * 
	 * @return {@code instance}
	 */
	public static ShowAtStartState instance() {
		if (instance == null) {
			instance = new ShowAtStartState();
		}
		return instance;
	}

	@Override
	public void handleEvent(OffEvent event) {
		PlayerContext.instance().changeState(OffState.instance());
	}

	public void handleEvent(SelectEvent event) {
		PlayerContext.instance().setTimeOn(ShowPanel.instance().getShow().getRunningTime());
		PlayerContext.instance().setShowName(ShowPanel.instance().getShow().getName());
		PlayerContext.instance().setRunningTime(ShowPanel.instance().getShow().getRunningTime());
		PlayerContext.instance().displayShowAtStart();
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
		PlayerContext.instance().displayShowAtStart();
	}

	@Override
	public void handleEvent(TimerRanOutEvent event) {
		PlayerContext.instance().changeState(ScreenSaverState.instance());
	}

	@Override
	public void enter() {
		timer = new Timer(this, 10);
		PlayerContext.instance().setTimeOn(ShowPanel.instance().getShow().getRunningTime());
		PlayerContext.instance().setShowName(ShowPanel.instance().getShow().getName());
		PlayerContext.instance().setRunningTime(ShowPanel.instance().getShow().getRunningTime());
		PlayerContext.instance().displayShowAtStart();
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
	}

}
