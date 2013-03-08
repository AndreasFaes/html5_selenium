package helpers;

import org.openqa.selenium.JavascriptExecutor;

/**
 * Convenience class to inject the feedback 
 * (test results) right back into the website (presentation)
 * and format it while we're at it.
 * 
 * @author afaes
 *
 */
public class FeedbackInjector {
	public static void inject(String id, String feedback){
		StringBuilder script = new StringBuilder();
		script.append("$('#" + id + "').append('");
		script.append("<h2>Test results:</h2>");
		script.append(feedback);
		script.append("')");
		
		((JavascriptExecutor)ChromeManager.getDriver()).executeScript(script.toString());
	}
}
