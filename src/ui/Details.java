package ui;

public interface Details {
	void expand();
	void collapse();
	boolean isCollapsed();
	String getDetails();
	String getSummary();
}
