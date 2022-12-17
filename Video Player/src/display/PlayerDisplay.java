package display;

/**
 * Displays what the appropriate content on the screen. Specifies what the
 * display system should do. In this context, this interface is intended to be
 * implemented by only the {@link GUIDisplay}.
 * 
 * @author Yahya Mohamed, Marvin Va, Adnan Wazwaz
 * @version 12 December 2020
 *
 */
public interface PlayerDisplay {

	/**
	 * Indicates that the television is now off.
	 */
	public void displayPlayerOff();

	/**
	 * Indicates that the television is now off.
	 */
	public void displayPlayerOn();

	/**
	 * Displays the duration of the selected show. The current time remaining is
	 * displayed along with the duration. In this case, the current time is the
	 * value of the duration of the show itself.
	 * <p>
	 * Note: it is intended to display the appropriate content in the form of a
	 * fraction: currentTime / duration.
	 * 
	 */
	public void displayShowAtStart();

	/**
	 * Displays the current time remaining in the show. This value is updated every
	 * second, indicating that the currently selected show is playing.
	 * <p>
	 * Note: it is intended to display the appropriate content in the form of a
	 * fraction: currentTime / duration.
	 * 
	 * @param timer the duration of the show.
	 */
	public void displayShowPlaying(int timer);

	/**
	 * Displays the current time remaining in the show. This value is intended to
	 * remain the same, indicating that the currently selected show is paused.
	 * <p>
	 * Note: it is intended to display the appropriate content in the form of a
	 * fraction: currentTime / duration.
	 * <p>
	 * Not to be confused with {@link #displayShowAtStart(int)}.
	 * 
	 * @param timer the duration of the show.
	 */
	public void displayShowPaused(int timer);

	/**
	 * Displays the current time remaining in the show. This value is updated, but
	 * the counting direction is reversed along with a higher rate of change,
	 * indicating that the currently selected show is rewinding.
	 * <p>
	 * Note: it is intended to display the appropriate content in the form of a
	 * fraction: currentTime / duration.
	 * 
	 * @param timer the duration of the show.
	 */
	public void displayShowRewinding(int timer);

	/**
	 * Displays the current time remaining in the show. This value is updated, but
	 * with a higher rate of change, indicating that the currently selected show is
	 * fast forwarding.
	 * <p>
	 * Note: it is intended to display the appropriate content in the form of a
	 * fraction: currentTime / duration.
	 * 
	 * @param timer the duration of the show.
	 */
	public void displayShowFastForwarding(int timer);

	/**
	 * Indicates that the show has reached the end of its duration, and now gives
	 * you the appropriate options of what to do next.
	 */
	public void displayShowCompleted();

	/**
	 * Indicates that the television has gone to the screen saver due to lack of
	 * activity.
	 */
	public void displayScreenSaver();

}
