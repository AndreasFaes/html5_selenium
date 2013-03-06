package tests;

import helpers.ChromeManager;
import helpers.FeedbackInjector;
import helpers.SlideDeck;

import java.awt.AWTException;
import java.awt.Robot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.gargoylesoftware.htmlunit.javascript.host.MouseEvent;

public class DemoInteractiveCanvas {

	@Test
	public void test() throws InterruptedException, AWTException {
		WebDriver driver = ChromeManager.getDriver();

		// Go to slide 50 (the demo slide)
		driver.get(SlideDeck.slide(50));
		driver.findElement(By.id("container")).click();
		WebElement canvas = driver
				.findElement(By.cssSelector("#test > canvas"));
		
		
		spin(canvas);
		while(!isStopped()){
			Thread.sleep(200);		
		}

		FeedbackInjector.inject("canvasFeedback", getFormattedText(getPrize()));
		
		Thread.sleep(5000);
		driver.quit();
	}

	private void spin(WebElement canvas) throws AWTException {
		Robot robby = new Robot();
		robby.mouseMove(canvas.getLocation().getX() + 298, canvas.getLocation()
				.getY() + 100);
		robby.mousePress(MouseEvent.BUTTON_LEFT);
		robby.mouseMove(canvas.getLocation().getX() + 150, canvas.getLocation()
				.getY() + 100);
		robby.mouseRelease(MouseEvent.BUTTON_LEFT);

	}
	
	private boolean isStopped(){
		return (boolean)((JavascriptExecutor)ChromeManager.getDriver())
		.executeScript("return isStopped()");
	}
	
	private String getPrize(){
		return (String)((JavascriptExecutor)ChromeManager.getDriver())
				.executeScript("return getCurrentPrize()");
	}
	
	private String getFormattedText(String result) {
		StringBuilder sb = new StringBuilder();
		sb.append("<h5>The result is: " + result);
		sb.append("</h5>");

		return sb.toString();
	}

}
