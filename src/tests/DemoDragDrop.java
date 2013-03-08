package tests;

import helpers.ChromeManager;
import helpers.DragAndDrop;
import helpers.SlideDeck;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

/**
 * Test class for drag and drop. Explanation can
 * be found mostly in the slides & in the
 * DragAndDrop class. 
 * 
 * @author afaes
 *
 */
public class DemoDragDrop {

	@Test
	public void test() throws InterruptedException {
		WebDriver driver = ChromeManager.getDriver();

		// Go to slide 42 (the demo slide)
		driver.get(SlideDeck.slide(42));
		
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
