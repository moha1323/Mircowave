package start;

import display.GUIDisplay;
import display.PlayerDisplay;
import javafx.application.Application;
import states.PlayerContext;
import timer.Clock;

/**
 * Implementation of Project #2 in ICS 372.
 * <p>
 * Simulation of a television that allows users to select "shows", that can be
 * played, paused, fast forwarded, rewound, or stopped/deselcted. It is also
 * somewhat similar to a computer in which the TV goes into a screen saver after
 * a short period of inactivity.
 * 
 * @author Yahya Mohamed, Marvin Va, Adnan Wazwaz
 * @version 12 December 2020
 *
 */
public class Main {

	/**
	 * Runs the program. In this method, the {@link Clock} is instantiated and
	 * the GUI is displayed.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Clock.instance();
		new Thread() {
			@Override
			public void run() {
				Application.launch(GUIDisplay.class, null);
			}
		}.start();
		try {
			while (GUIDisplay.getInstance() == null) {
				Thread.sleep(1000);
			}
		} catch (InterruptedException ie) {

		}
		PlayerDisplay display = GUIDisplay.getInstance();
		PlayerContext.instance().setDisplay(display);
	}

}
