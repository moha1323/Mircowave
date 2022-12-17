package buttons;

import events.RewindEvent;
import javafx.event.ActionEvent;
import states.PlayerContext;

/**
 * The "rewind" button.
 * 
 * @author Yahya Mohamed, Marvin Va, Adnan Wazwaz
 * @version 12 December 2020
 */

public class RewindButton extends GUIButton {

	/**
	 * Generates a new constructor for {@code RewindButton}. Creates a "rewind"
	 * button with the proper text on the button.
	 * <p>
	 * Note: the text of the button will be displayed as "REW".
	 */
	public RewindButton() {
		super("REW");
	}

	@Override
	public void handle(ActionEvent event) {
		PlayerContext.instance().handleEvent(RewindEvent.instance());
	}
}
