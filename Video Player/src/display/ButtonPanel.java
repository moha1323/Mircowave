package display;

import buttons.FastForwardButton;
import buttons.OffButton;
import buttons.OnButton;
import buttons.PauseButton;
import buttons.PlayButton;
import buttons.RewindButton;
import buttons.StopButton;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * Column of all of the television controls, excluding show selecting controls,
 * in the form of {@code Button}s.
 * 
 * @author Yahya Mohamed, Marvin Va, and Adnan Wazwaz
 * @version 12 December 2020
 */

public class ButtonPanel extends VBox {
	private Button onButton;
	private Button offButton;
	private Button playButton;
	private Button stopButton;
	private Button pauseButton;
	private Button fastForwardButton;
	private Button rewindButton;

	/**
	 * Generates a new constructor for {@code ButtonPanel}. Instantiates all of
	 * the buttons and adds them to the panel.
	 * 
	 */
	public ButtonPanel() {
		onButton = new OnButton();
		offButton = new OffButton();
		playButton = new PlayButton();
		stopButton = new StopButton();
		pauseButton = new PauseButton();
		fastForwardButton = new FastForwardButton();
		rewindButton = new RewindButton();
		setSpacing(5);
		this.getChildren().add(onButton);
		this.getChildren().add(offButton);
		this.getChildren().add(playButton);
		this.getChildren().add(stopButton);
		this.getChildren().add(pauseButton);
		this.getChildren().add(fastForwardButton);
		this.getChildren().add(rewindButton);
		setPadding(new Insets(10, 10, 10, 10));
	}

}
