package states;

import display.ShowPanel;
import events.OffEvent;
import events.PlayEvent;
import events.StopEvent;
import events.TimerRanOutEvent;
import events.TimerTickedEvent;
import timer.Notifiable;
import timer.Timer;

/**
 * The singleton class, {@code RewindingState} represents the state in the
 * television in which a show is rewinding.
 * 
 * @author Yahya Mohamed, Marvin Va, and Adnan Wazwaz
 * @version 12 December 2020
 *
 */
public class RewindingState extends PlayerState implements Notifiable {
	private static RewindingState instance;
	private Timer timer;
	private int rewindingTime;

	/**
	 * Satisfies the singleton property. It is not necessary to have more than one
	 * instance of this class because this is a specific predefined state with
	 * specific predefined [intended] unchangeable commands, which can be accessed
	 * globally.
	 */
	private RewindingState() {

	}

	/**
	 * Returns the only instance of {@code RewindingState}. If none exists, then it
	 * instantiates one and returns it.
	 * 
	 * @return {@code instance}
	 */
	public static RewindingState instance() {
		if (instance == null) {
			instance = new RewindingState();
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
	public void handleEvent(TimerTickedEvent event) {
		if (ShowPanel.instance().getShow().getRunningTime() - PlayerContext.instance().getTimeOn() == 1) {
			rewindingTime++;
		} else {
			rewindingTime += 2;
		}
		PlayerContext.instance().setTimeOn(rewindingTime);
		PlayerContext.instance().displayShowRewinding(PlayerContext.instance().getTimeOn());
	}

	@Override
	public void handleEvent(TimerRanOutEvent event) {
		PlayerContext.instance().displayShowRewinding(PlayerContext.instance().getTimeOn());
		PlayerContext.instance().changeState(PausedState.instance());
	}

	@Override
	public void enter() {
		rewindingTime = PlayerContext.instance().getTimeOn();
		int limit = ShowPanel.instance().getShow().getRunningTime() - PlayerContext.instance().getTimeOn();
		int timerLength = (int) Math.ceil((double) limit / 2) + 1;
		timer = new Timer(this, timerLength);
		PlayerContext.instance().displayShowRewinding(PlayerContext.instance().getTimeOn());
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
	}

}
