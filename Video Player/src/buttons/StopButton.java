package buttons;

import events.StopEvent;
import javafx.event.ActionEvent;
import states.PlayerContext;

/**
 * The "stop" button.
 * 
 * @author Yahya Mohamed, Marvin Va, Adnan Wazwaz
 * @version 12 December 2020
 */

public class StopButton extends GUIButton {

	/**
	 * Generates a new constructor for {@code StopButton}. Creates a stop button
	 * with the proper text on the button.
	 */
	public StopButton() {
		super("STOP");
	}

	@Override
	public void handle(ActionEvent event) {
		PlayerContext.instance().handleEvent(StopEvent.instance());
	}

}
