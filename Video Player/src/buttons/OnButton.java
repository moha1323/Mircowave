package buttons;

import events.OnEvent;
import javafx.event.ActionEvent;
import states.PlayerContext;

/**
 * The "on" button.
 * 
 * @author Yahya Mohamed, Marvin Va, Adnan Wazwaz
 * @version 12 December 2020
 */

public class OnButton extends GUIButton {

	/**
	 * Generates a new constructor for {@code OnButton}. Creates an "on" button
	 * with the proper text on the button.
	 */
	public OnButton() {
		super("ON");
	}

	@Override
	public void handle(ActionEvent event) {
		PlayerContext.instance().handleEvent(OnEvent.instance());
	}
}
