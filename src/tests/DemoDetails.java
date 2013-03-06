package tests;

import helpers.ChromeManager;
import helpers.FeedbackInjector;
import helpers.SlideDeck;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ui.Details;
import ui.HTML5Details;

public class DemoDetails {

	@Test
	public void test() throws InterruptedException {
		WebDriver driver = ChromeManager.getDriver();

		// Go to slide 32 (the demo slide)
		driver.get(SlideDeck.slide(36));

		// Create the Details objects
		Details details1 = new HTML5Details(driver.findElement(By.id("details1")));
		Details details2 = new HTML5Details(driver.findElement(By.id("details2")));

		// Inject the results
		FeedbackInjector.inject(
				"detailsFeedback",
				getFormattedText("Details 1", details1)
						+ getFormattedText("Details 2", details2));

		Thread.sleep(10000);
		details1.expand(); // Show the details to the public
		
		Thread.sleep(6000);
		
		driver.quit();
	}

	private String getFormattedText(String name, Details details) {
		StringBuilder sb = new StringBuilder();
		sb.append("<h5>" + name);
		if(details.isCollapsed()){
			sb.append(" (collapsed)");
		}else{
			sb.append(" (open)");
		}
		
		sb.append(" - text: " + details.getDetails());
		
		sb.append("</h5>");

		return sb.toString();
	}

}
