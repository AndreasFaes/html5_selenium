package helpers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;

public class DragAndDrop {
	public static void perform(String idFrom, String idTo) {
		injectJavaScriptFunction();		 
		useFunction(idFrom, idTo);
	}
	
	private static void useFunction(String idFrom, String idTo) {
		((JavascriptExecutor)ChromeManager.getDriver())
		.executeScript("$('#"+ idFrom
				+ "').simulateDragDrop({ dropTarget: '#" 
				+ idTo + "'});");
		
	}

	private static void injectJavaScriptFunction(){
		File helper = new File("src/helpers/drag_and_drop_helper.js");
		StringBuilder contents = new StringBuilder();
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(helper));
			String text = null;

			while ((text = reader.readLine()) != null) {
				contents.append(text).append(
						System.getProperty("line.separator"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		((JavascriptExecutor)ChromeManager.getDriver()).executeScript(contents.toString());
	}
}
