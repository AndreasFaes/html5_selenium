package helpers;

import org.openqa.selenium.JavascriptExecutor;

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
