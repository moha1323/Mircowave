package buttons;

import events.PlayEvent;
import javafx.event.ActionEvent;
import states.PlayerContext;

/**
 * The "play" button.
 * 
 * @author Yahya Mohamed, Marvin Va, Adnan Wazwaz
 * @version 12 December 2020
 */

public class PlayButton extends GUIButton {

	/**
	 * Generates a new constructor for {@code PlayButton}. Creates a "play"
	 * button with the proper text on the button.
	 */
	public PlayButton() {
		super("PLAY");
	}

	@Override
	public void handle(ActionEvent event) {
		PlayerContext.instance().handleEvent(PlayEvent.instance());
	}
}
