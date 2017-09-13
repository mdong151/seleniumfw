package supports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonFunctions {
	private static WebDriver driver; 
	private static String filePath = System.getProperty("user.dir") ;
	
	public static void setBrowser(String browser){
		if (browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", filePath +"/Drivers/");
		}
		else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", filePath+"/Drivers/");
		}
	}
	public static WebElement findElement(String how, String locator){
		WebElement ele = null;
		
		
		return ele;
		
	}
	
}
