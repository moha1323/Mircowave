package display;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import states.PlayerContext;

/**
 * GUI to implement the commands of the {@link PlayerDisplay} interface.
 * 
 * @author Yahya Mohamed, Marvin Va, and Adnan Wazwaz
 * @version 12 December 2020
 *
 */
public class GUIDisplay extends Application implements PlayerDisplay {
	private ButtonPanel buttonPanel;
	private ShowPanel showPanel;
	private PlayerPanel playerPanel;
	private static PlayerDisplay display;
	private PlayerContext playerContext;

	public static PlayerDisplay getInstance() {
		return display;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		playerContext = PlayerContext.instance();
		playerContext.setDisplay(this);
		display = this;
		primaryStage.setTitle("Player-Remote Control");
		buttonPanel = new ButtonPanel();
		showPanel = ShowPanel.instance();
		showPanel.getItems();
		playerPanel = new PlayerPanel();
		displayPlayerOff();
		VBox vBox = new VBox();
		vBox.getChildren().add(playerPanel);
		vBox.getChildren().add(showPanel);
		BorderPane mainPane = new BorderPane();
		mainPane.setLeft(buttonPanel);
		mainPane.setRight(vBox);
		Scene scene = new Scene(mainPane);
		primaryStage.setScene(scene);
		primaryStage.show();
		try {
			while (playerContext == null) {
				Thread.sleep(1000);
			}
		} catch (Exception e) {

		}
		primaryStage.show();
		primaryStage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent window) {
				System.exit(0);
			}
		});
	}

	@Override
	public void displayPlayerOff() {
		playerPanel.overrideText("Off");
	}

	@Override
	public void displayPlayerOn() {
		playerPanel.overrideText("On");
	}

	@Override
	public void displayShowAtStart() {
		String name = PlayerContext.instance().getShowName();
		int time = PlayerContext.instance().getRunningTime();
		playerPanel.overrideText(name + " " + time + "/" + time);
	}

	@Override
	public void displayShowPlaying(int timer) {
		playerPanel.overrideText(showDisplayText(timer));
	}

	@Override
	public void displayShowPaused(int timer) {
		playerPanel.overrideText(showDisplayText(timer));
	}

	@Override
	public void displayShowRewinding(int timer) {
		playerPanel.overrideText(showDisplayText(timer));
	}

	@Override
	public void displayShowFastForwarding(int timer) {
		playerPanel.overrideText(showDisplayText(timer));
	}

	@Override
	public void displayShowCompleted() {
		playerPanel.overrideText("Press 'PLAY' to view again," + "\nPress 'STOP' to deselect the show,"
				+ "\nor select a different show.");
	}

	@Override
	public void displayScreenSaver() {
		playerPanel.overrideText("ICS 372");
	}

	/**
	 * Returns the name of the currently selected show, the current time left, and
	 * the running time of the show.
	 * 
	 * @param timer the timer
	 * @return the aforementioned content in the form: name timeLeft/runningTime.
	 */
	private String showDisplayText(int timer) {
		String name = PlayerContext.instance().getShowName();
		int time = PlayerContext.instance().getRunningTime();
		return name + " " + timer + "/" + time;
	}

}
