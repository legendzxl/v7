package uk.co.q3c.v7.base.view;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Component;

public interface V7View {
	/**
	 * This view is navigated to.
	 * 
	 * This method is always called before the view is shown on screen. {@link ViewChangeEvent#getParameters()
	 * event.getParameters()} may contain extra parameters relevant to the view.
	 * 
	 * @param event
	 *            ViewChangeEvent representing the view change that is occurring. {@link ViewChangeEvent#getNewView()
	 *            event.getNewView()} returns <code>this</code>.
	 * 
	 */
	public void enter(V7ViewChangeEvent event);

	/**
	 * To enable implementations to implement this interface without descending from Component. If the implementation
	 * does descend from Component, just return 'this'
	 * 
	 * @return
	 */
	public Component getRootComponent();

	/**
	 * A name for the view, typically displayed in a title bar
	 * 
	 * @return
	 */
	public String viewName();

	/**
	 * Ids are used primarily for testing with Vaadin TestBench. If you are not using them, this can be an empty method
	 */
	public void setIds();

}
