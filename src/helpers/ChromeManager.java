package helpers;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeManager {
	private static WebDriver driver;
	
	/**
	 * Creates and maintains the WebDriver instance
	 * (in this case ChromeDriver, fullscreen).
	 * 
	 * @return ChromeDriver instance
	 */
	public static WebDriver getDriver(){
		if(driver == null){
			System.setProperty("webdriver.chrome.driver",
					"C:\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			fullscreen();	
		}
		
		return driver;
	}
	
	private static void fullscreen(){
		Robot robby = null;
		try {
			robby = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		robby.keyPress(KeyEvent.VK_F11);
		robby.keyRelease(KeyEvent.VK_F11);
	}
}
