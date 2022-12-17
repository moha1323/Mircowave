package shows;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * The singleton class, {@code ShowList} represents the collection of all of the
 * shows in the television.
 * 
 * @author Yahya Mohamed, Marvin Va, Adnan Wazwaz
 * @version 12 December 2020
 */

public class ShowList {
	private ObservableList<Show> shows = FXCollections.observableArrayList();
	private static ShowList eventsInstance;

	/**
	 * Constant that represents the number of shows to be added by the system at
	 * method call: {@link #addShows()}
	 */
	private static final int NUMBER_OF_SHOWS_TO_ADD = 5;

	/**
	 * Constant that represents the the increment of the duration for each
	 * successive show that is added to {@code shows}. For example: if this value
	 * was {@literal 10}, and {@link #NUMBER_OF_SHOWS_TO_ADD} was {@literal 5}, then
	 * the durations for each of the {@literal 5} shows will be {@literal 10},
	 * {@literal 20}, {@literal 30}, {@literal 40}, and {@literal 50}, in that same
	 * order.
	 */
	private static final int DURATION_MULTIPLE = 10;

	/**
	 * Satisfies the singleton property. This class only needs to be instantiated
	 * once, because the user only needs one copy of the list of available shows.
	 */
	private ShowList() {
	}

	/**
	 * Returns the only instance of {@code ShowList}. If one does not exists, then
	 * it instantiates one and returns it.
	 * 
	 * @return {@code eventsInstance}
	 */
	public static ShowList instance() {
		if (eventsInstance == null) {
			eventsInstance = new ShowList();
			eventsInstance.addShows();
		}
		return eventsInstance;
	}

	/**
	 * Adds a Show to the list of {@code Show}: {@code shows}.
	 * 
	 * @param show the new Show
	 */
	public void add(Show show) {
		shows.add(show);
	}

	/**
	 * Returns the list of shows in {@code ShowList}.
	 * 
	 * @return {@code shows}
	 */
	public ObservableList<Show> getShows() {
		return shows;
	}

	/**
	 * Creates a set of shows and adds them to the list: {@code shows}.
	 */
	private void addShows() {
		for (int index = 0; index < NUMBER_OF_SHOWS_TO_ADD; index++) {
			shows.add(new Show("N" + (index + 1), DURATION_MULTIPLE * (index + 1)));
		}
	}

	@Override
	public String toString() {
		return "Shows [shows=" + shows + "]";
	}
}
