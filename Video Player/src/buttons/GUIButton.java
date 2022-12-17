package buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;

/**
 * The super class for all buttons.
 * 
 * @author Yahya Mohamed, Marvin Va, Adnan Wazwaz
 * @version 12 December 2020
 */

public abstract class GUIButton extends Button
		implements
			EventHandler<ActionEvent> {

	/**
	 * Generates a new constructor for {@code GUIButton}. Sets up a uniform size
	 * for all buttons and ensures that every button listens to clicks on
	 * itself.
	 * <p>
	 * Note: this class is intended to be called by only the subclasses of
	 * {@code GUIButton}.
	 * 
	 * @param label
	 *            the button text.
	 */
	public GUIButton(String label) {
		super(label);
		setPrefWidth(60);
		setPrefHeight(20);
		setPadding(new Insets(5, 10, 5, 10));
		setOnAction((EventHandler<ActionEvent>) this);
	}

	@Override
	public abstract void handle(ActionEvent event);

}