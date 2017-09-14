package supports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctions {
	private static WebDriver driver; 
	private static String filePath = System.getProperty("user.dir") ;
	
	public static void waitForElementpresent(String how,String locator){
//		WebElement myDynamicElement = (new WebDriverWait(driver, 10))
//				  .until(ExpectedConditions.presenceOfElementLocated(locator)));
	}
	
	public static void waitForElementpresent(WebElement ele){
		
	}
	
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
	public static WebElement getElement(String how, String locator){
		WebElement ele = null;
		ele = driver.findElement(getElementBy(how, locator));
		return ele;
	}
	
	public static By getElementBy(String how,String locator){
		By by = null;
		
		if(how.equalsIgnoreCase("id")){
			by = By.id(locator);
		}
		else if(how.equalsIgnoreCase("name")){
			by = By.name(locator);
		}
		else if(how.equalsIgnoreCase("xpath")){
			by = By.xpath(locator);
		}
		else if(how.equalsIgnoreCase("css")){
			by = By.cssSelector(locator);
		}
		else if(how.equalsIgnoreCase("class")){
			by = By.className(locator);
		}
		return by;
	}
	
	public static void click(String how, String locator){
		getElement(how, locator).click();
	}
	
	public static void click (WebElement ele){
		ele.click();
	}
	
	public static void sendText(String how, String locator){
		
	}
}
