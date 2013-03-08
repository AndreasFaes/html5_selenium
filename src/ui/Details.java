package ui;

/**
 * Interface for the HTML5 details tag.
 * 
 * @author afaes
 *
 */
public interface Details {
	void expand();
	void collapse();
	boolean isCollapsed();
	String getDetails();
	String getSummary();
}
