package buttons;

import events.PauseEvent;
import javafx.event.ActionEvent;
import states.PlayerContext;

/**
 * The "pause" button.
 * 
 * @author Yahya Mohamed, Marvin Va, Adnan Wazwaz
 * @version 12 December 2020
 */

public class PauseButton extends GUIButton {

	/**
	 * Generates a new constructor for {@code PauseButton}. Creates a "pause"
	 * button with the proper text on the button.
	 */
	public PauseButton() {
		super("PAUSE");
	}

	@Override
	public void handle(ActionEvent event) {
		PlayerContext.instance().handleEvent(PauseEvent.instance());
	}
}
