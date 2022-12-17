package timer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * The singleton class, {@code Clock}, implements a clock as a Runnable. An
 * object adapter that uses {@link PropertyChangeSupport} to implement the
 * Observable part of the Observer. pattern.
 * 
 * @author Yahya Mohamed, Marvin Va, and Adnan Wazwaz
 *
 */
public class Clock implements Runnable {
	private Thread thread = new Thread(this);
	private static Clock clock;
	private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

	/**
	 * Adds a listener to the {@code propertyChangeSupport}.
	 *
	 * @param listener the listener to be added.
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		this.propertyChangeSupport.addPropertyChangeListener(listener);
	}

	/**
	 * Removes a listener from the {@code propertyChangeSupport}.
	 *
	 * @param listener the listener to be removed.
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		this.propertyChangeSupport.removePropertyChangeListener(listener);
	}

	/**
	 * Satisfies the singleton property. Start the thread.
	 */
	private Clock() {
		thread.start();
	}

	/**
	 * Returns the only instance of {@code Clock}. If none exists, then it
	 * instantiates one and returns it.
	 * 
	 * @see {@link #Clock()}
	 *
	 * @return {@code clock}
	 */
	public static Clock instance() {
		if (clock == null) {
			clock = new Clock();
		}
		return clock;
	}

	/**
	 * Infinite loop to generate the clock ticks. Notify all users when clock ticks.
	 */
	@Override
	public void run() {
		try {
			while (true) {
				Thread.sleep(1000);
				this.propertyChangeSupport.firePropertyChange(null, null, null);
			}
		} catch (InterruptedException ie) {
		}
	}

}
