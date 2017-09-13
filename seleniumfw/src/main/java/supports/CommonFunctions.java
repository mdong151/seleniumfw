package supports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonFunctions {
	private static WebDriver driver; 
	private static String filePath = System.getProperty("user.dir") ;
	
	public static void setBrowser(String browser){
		if(System.getProperty("os.name").contains("Mac")){
			if (browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", filePath +"/Drivers/");
				driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver", filePath+"/Drivers/");
				driver = new FirefoxDriver();
			}
		}
		if(System.getProperty("os.name").contains("Windows")){
			if (browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", filePath +"/Drivers/");
				driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver", filePath+"/Drivers/");
				driver = new FirefoxDriver();
			}
		}
		
	}
	public static WebElement findElement(String how, String locator){
		WebElement ele = null;
		if (how.equalsIgnoreCase("id")){
			ele = driver.findElement(By.id(locator));
		}
		else if (how.equalsIgnoreCase("name")){
			ele = driver.findElement(By.name(locator));
		}
		else if (how.equalsIgnoreCase("xpath")){
			ele = driver.findElement(By.xpath(locator));
		}
		else if (how.equalsIgnoreCase("css")){
			ele = driver.findElement(By.cssSelector(locator));
		}
		else if (how.equalsIgnoreCase("class")){
			ele = driver.findElement(By.className(locator));
		}
		
		return ele;
	}
	
	public static void click(String how, String locator){
		findElement(how, locator).click();
	}
	
	public static void click (WebElement ele){
		ele.click();
	}
	
	public static void sendText(String how, String locator){
		
	}
}
