package display;

import events.SelectEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import shows.Show;
import shows.ShowList;
import states.PlayerContext;

/**
 * The singleton class, {@code ShowPanel} displays the list of available shows
 * in the television.
 * 
 * @author Yahya Mohamed, Marvin Va, and Adnan Wazwaz
 * @version 12 December 2020
 *
 */
public class ShowPanel extends ListView {
	private static ShowPanel instance;
	private Show show;

	/**
	 * Satisfies the singleton property. This class only needs to be
	 * instantiated once, because the user does not need to look at the same
	 * list of available shows.
	 */
	private ShowPanel() {
		super(ShowList.instance().getShows());
		setOnMouseClicked(new EventHandler<Event>() {

			/**
			 * This method should be completed to process the event. The
			 * selected Show is in the reference show.
			 */
			@Override
			public void handle(Event arg0) {
				show = (Show) getSelectionModel().getSelectedItem();
				PlayerContext.instance().handleEvent(SelectEvent.instance());
			}
		});
	}

	/**
	 * Returns the only instance of {@code ShowPanel}. If one does not exists,
	 * then it instantiates one and returns it.
	 * 
	 * @see {@link #ShowPanel()}.
	 * 
	 * @return {@code instance}
	 */
	public static ShowPanel instance() {
		if (instance == null) {
			instance = new ShowPanel();
		}
		return instance;
	}

	/**
	 * Returns the show that is currently selected.
	 * 
	 * @return {@code show}
	 */
	public Show getShow() {
		return show;
	}

}
