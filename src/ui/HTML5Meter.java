package ui;

import org.openqa.selenium.WebElement;

public class HTML5Meter implements Meter {
	private WebElement meter;
	public HTML5Meter(WebElement meter){
		this.meter = meter;
	}
	
	@Override
	public double getProgress() {
		// value from 0 to 1
		String value = meter.getAttribute("value");
		return Double.parseDouble(value) * 100;
	}

	@Override
	public boolean isDone() {
		return getProgress() == 100;
	}
}
