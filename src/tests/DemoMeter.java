package tests;

import helpers.ChromeManager;
import helpers.FeedbackInjector;
import helpers.SlideDeck;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ui.HTML5Meter;
import ui.Meter;

public class DemoMeter {

	@Test
	public void test() throws InterruptedException {
		WebDriver driver = ChromeManager.getDriver();
		
		// Go to slide 32 (the demo slide)
		driver.get(SlideDeck.slide(32));
		
		// Create the Meter objects
		Meter meter1 = new HTML5Meter(driver.findElement(By.id("meter1")));
		Meter meter2 = new HTML5Meter(driver.findElement(By.id("meter2")));
		
		// Inject the results
		FeedbackInjector.inject("meterFeedback", getFormattedText("Meter 1", meter1) +
				getFormattedText("Meter 2", meter2));
		
		Thread.sleep(8000);
		
		driver.quit();
	}
	
	private String getFormattedText(String name, Meter meter){
		StringBuilder sb = new StringBuilder();
		sb.append("<h3>" + name + " progress: " + meter.getProgress() + "%");
		if(meter.isDone()){
			sb.append(" (done)");
		}else{
			sb.append(" (not done)");
		}
		sb.append("</h3>");
		System.out.println(sb.toString());
		return sb.toString();
	}

}
