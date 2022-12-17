package buttons;

import events.OffEvent;
import javafx.event.ActionEvent;
import states.PlayerContext;

/**
 * The "off" button.
 * 
 * @author Yahya Mohamed, Marvin Va, Adnan Wazwaz
 * @version 12 December 2020
 */

public class OffButton extends GUIButton {

	/**
	 * Generates a new constructor for {@code OffButton}. Creates a "off" button
	 * with the proper text on the button.
	 */
	public OffButton() {
		super("OFF");
	}

	@Override
	public void handle(ActionEvent event) {
		PlayerContext.instance().handleEvent(OffEvent.instance());
	}
}
