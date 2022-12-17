package states;

import display.PlayerDisplay;
import events.FastForwardEvent;
import events.OffEvent;
import events.OnEvent;
import events.PauseEvent;
import events.PlayEvent;
import events.RewindEvent;
import events.SelectEvent;
import events.StopEvent;

/**
 * The singleton class, {@code PlayerContext} serves as the observer for the
 * {@link Clock} and stores the context info for the the states
 * 
 * @author Yahya Mohamed, Marvin Va, and Adnan Wazwaz
 * @version 12 December 2020
 *
 */
public class PlayerContext {
	private PlayerDisplay display;
	private PlayerState currentState;
	private PlayerState previousState;
	private static PlayerContext instance;
	private int timeOn;
	private String showName;
	private int runningTime;

	/**
	 * Satisfies the singleton property.
	 */
	private PlayerContext() {
		instance = this;
		currentState = OffState.instance();
	}

	/**
	 * Returns the only instance of {@code PlayerContext}. If there is none, then it
	 * instantiates one and returns it.
	 * 
	 * @see {@link #PlayerContext()}.
	 * 
	 * @return
	 */
	public static PlayerContext instance() {
		if (instance == null) {
			instance = new PlayerContext();
		}
		return instance;
	}

	/**
	 * Sets the display for the {@code PlayerContext}.
	 * 
	 * @param display the display.
	 */
	public void setDisplay(PlayerDisplay display) {
		this.display = display;
	}

	/**
	 * Sets a new state to the {@code PlayerContext}. The old state is stored to the
	 * variable, {@code previousState}.
	 * 
	 * @param nextState the new state that will replace the old state.
	 */
	public void changeState(PlayerState nextState) {
		previousState = currentState;
		currentState.leave();
		currentState = nextState;
		currentState.enter();
	}

	/**
	 * Returns the previous state that the television was in.
	 * 
	 * @return {@code previousState}
	 */
	public PlayerState getPreviousState() {
		return previousState;
	}

	public void initialize() {
		instance.changeState(OffState.instance());
	}

	public void handleEvent(OnEvent event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(OffEvent event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(SelectEvent event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(PlayEvent event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(StopEvent event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(PauseEvent event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(RewindEvent event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(FastForwardEvent event) {
		currentState.handleEvent(event);
	}

	public void displayPlayerOff() {
		display.displayPlayerOff();
	}

	public void displayPlayerOn() {
		display.displayPlayerOn();
	}

	public void displayShowAtStart() {
		display.displayShowAtStart();
	}

	public void displayShowPlaying(int time) {
		display.displayShowPlaying(time);
	}

	public void displayShowPaused(int time) {
		display.displayShowPaused(time);
	}

	public void displayShowRewinding(int time) {
		display.displayShowRewinding(time);
	}

	public void displayShowFastForwarding(int time) {
		display.displayShowFastForwarding(time);
	}

	public void displayShowCompleted() {
		display.displayShowCompleted();
	}

	public void displayScreenSaver() {
		display.displayScreenSaver();
	}

	public int getTimeOn() {
		return timeOn;
	}

	public void setTimeOn(int timeOn) {
		this.timeOn = timeOn;
	}

	/**
	 * Sets the name of the show for the screen to display.
	 * 
	 * @param showName the name of the show.
	 */
	public void setShowName(String showName) {
		this.showName = showName;
	}

	/**
	 * Sets the running time of the show for the screen to display.
	 * 
	 * @param runningTime the running time of the show (in seconds).
	 */
	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}

	/**
	 * Returns the name of the show that is currently being viewed.
	 * 
	 * @return {@code showName}
	 */
	public String getShowName() {
		return showName;
	}

	/**
	 * Returns the running time of the show that is currently being viewed.
	 * 
	 * @return {@code runningTime}
	 */
	public int getRunningTime() {
		return runningTime;
	}

}
