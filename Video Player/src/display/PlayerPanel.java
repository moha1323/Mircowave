package display;

import javafx.scene.control.TextArea;

/**
 * The class, {@code PlayerPanel} acts as the television screen. In this
 * context, no actual graphics is displayed, but rather, the televsion displays
 * messages in the {@code TextArea} depending on the button clicked. For
 * example, if the user clicks the {@code OnButton}, then the
 * {@code PlayerPannel} will display the message: "On".
 * 
 * @author Yahya Mohamed, Marvin Va, and Adnan Wazwaz
 * @version 12 December 2020
 *
 */
public class PlayerPanel extends TextArea {

	/**
	 * Generates a constructor for {@code PlayerPanel}. Sets the panel to be
	 * non-editable so that only the system can change the contents of the
	 * screen when it needs to, and NOT the user.
	 * 
	 * @see TextArea#setEditable(boolean)
	 */
	public PlayerPanel() {
		setEditable(false);
	}

	/**
	 * Enables the system to access the {@code PlayerPanel} to simply overwrite
	 * the current content with the new appropriate one. Afterwards, the
	 * television disables panel editing once again.
	 * 
	 * @param text
	 *            the content to replace what's currently in the screen.
	 */
	public void overrideText(String text) {
		setEditable(true);
		setText(text);
		setEditable(false);
	}
}
