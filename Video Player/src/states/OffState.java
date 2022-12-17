package states;

import events.OnEvent;

/**
 * The singleton class, {@code OffState} represents the state in the television
 * in which the TV is off, and unable to do anything in this state except turn
 * on the TV.
 * 
 * @author Yahya Mohamed, Marvin Va, and Adnan Wazwaz
 * @version 12 December 2020
 *
 */
public class OffState extends PlayerState {
	private static OffState instance;

	/**
	 * Satisfies the singleton property. It is not necessary to have more than one
	 * instance of this class because this is a specific predefined state with
	 * specific predefined [intended] unchangeable commands, which can be accessed
	 * globally.
	 */
	private OffState() {

	}

	/**
	 * Returns the only instance of {@code OffState}. If none exists, then it
	 * instantiates one and returns it.
	 * 
	 * @return {@code instance}
	 */
	public static OffState instance() {
		if (instance == null) {
			instance = new OffState();
		}
		return instance;
	}

	@Override
	public void handleEvent(OnEvent event) {
		PlayerContext.instance().changeState(OnState.instance());
	}

	@Override
	public void enter() {
		PlayerContext.instance().displayPlayerOff();
		PlayerContext.instance().setTimeOn(0);
	}

	@Override
	public void leave() {

	}

}
