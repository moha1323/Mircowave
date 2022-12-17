package states;

import events.OffEvent;
import events.PlayEvent;
import events.StopEvent;
import events.TimerRanOutEvent;
import events.TimerTickedEvent;
import timer.Notifiable;
import timer.Timer;

/**
 * The singleton class, {@code FastForwardingState} represents the state in the
 * television in which a show is fast forwarding.
 * 
 * @author Yahya Mohamed, Marvin Va, and Adnan Wazwaz
 * @version 12 December 2020
 *
 */
public class FastforwardingState extends PlayerState implements Notifiable {
	private static FastforwardingState instance;
	private Timer timer;
	private int fastforwardingTime;

	/**
	 * Satisfies the singleton property. It is not necessary to have more than one
	 * instance of this class because this is a specific predefined state with
	 * specific predefined [intended] unchangeable commands, which can be accessed
	 * globally.
	 */
	private FastforwardingState() {

	}

	/**
	 * Returns the only instance of {@code FastForwardingState}. If none exists,
	 * then it instantiates one and returns it.
	 * 
	 * @return {@code instance}
	 */
	public static FastforwardingState instance() {
		if (instance == null) {
			instance = new FastforwardingState();
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
		if (PlayerContext.instance().getTimeOn() == 1) {
			fastforwardingTime--;
		} else {
			fastforwardingTime -= 2;
		}
		PlayerContext.instance().setTimeOn(fastforwardingTime);
		PlayerContext.instance().displayShowRewinding(PlayerContext.instance().getTimeOn());
	}

	@Override
	public void handleEvent(TimerRanOutEvent event) {
		PlayerContext.instance().changeState(CompletedState.instance());
	}

	@Override
	public void enter() {
		fastforwardingTime = PlayerContext.instance().getTimeOn();
		int limit = PlayerContext.instance().getTimeOn() - 0;
		int timerLength = (int) Math.ceil((double) limit / 2) + 1;
		timer = new Timer(this, timerLength);
		PlayerContext.instance().displayShowFastForwarding(PlayerContext.instance().getTimeOn());
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
	}

}
