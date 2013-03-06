package tests;

import helpers.ChromeManager;
import helpers.DragAndDrop;
import helpers.SlideDeck;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class DemoDragDrop {

	@Test
	public void test() throws InterruptedException {
		WebDriver driver = ChromeManager.getDriver();

		// Go to slide 32 (the demo slide)
		driver.get(SlideDeck.slide(41));
		
		Thread.sleep(2000);
		DragAndDrop.perform("chrome", "bin");
		Thread.sleep(2000);
		DragAndDrop.perform("ie", "bin");
		Thread.sleep(2000);
		DragAndDrop.perform("ff", "bin");
		Thread.sleep(2000);
		
		driver.quit();
	}

}
