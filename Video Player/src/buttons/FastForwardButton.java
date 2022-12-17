package buttons;

import events.FastForwardEvent;
import javafx.event.ActionEvent;
import states.PlayerContext;

/**
 * The "fast forward" button.
 * 
 * @author Yahya Mohamed, Marvin Va, Adnan Wazwaz
 * @version 12 December 2020
 */

public class FastForwardButton extends GUIButton {

	/**
	 * Generates a new constructor for {@code FastForwardButton}. Creates a
	 * "fast forward" button with the proper text on the button.
	 * <p>
	 * Note: the text of the button will be displayed as "FF".
	 */
	public FastForwardButton() {
		super("FF");
	}

	@Override
	public void handle(ActionEvent event) {
		PlayerContext.instance().handleEvent(FastForwardEvent.instance());
	}

}
