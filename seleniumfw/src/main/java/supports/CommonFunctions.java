package supports;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.bcel.classfile.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctions {
	private static WebDriver driver;
	private static String filePath = System.getProperty("user.dir");
	private static int TIMEOUT = 10;

	public static void waitForElementPresence(String how, String locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.presenceOfElementLocated(by(how, locator)));
	}

	public static void waitForElementPresence(WebElement ele) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
	}

	public static void waitForElementpresence(WebElement ele) {

	}
	
	public static void refreshCurrentPage() {
		String currentUrl = driver.getCurrentUrl();
		driver.get(currentUrl);
		waitFor(10000);
	}
	public static WebDriver getDriver () {
		return driver;
	}

	public static void setBrowser(String browser) {
		if (System.getProperty("os.name").contains("Mac")) {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", filePath + "/Drivers/chromedriver");
				//set options
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-blink-features=BlockCredentialedSubresources");
				
				driver = new ChromeDriver(options);
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", filePath + "/Drivers/chromedriver");
				driver = new FirefoxDriver();
			}
		}
		if (System.getProperty("os.name").contains("Windows")) {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", filePath + "/Drivers/chromedriver.exe");
				//set options
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-blink-features=BlockCredentialedSubresources");

				driver = new ChromeDriver(options);
				
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", filePath + "/Drivers/chromedriver.exe");
				driver = new FirefoxDriver();
			}
		}
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);

	}

	public static void sendKey(String how, String locator, Keys key) {
		getElement(how, locator).sendKeys(key);
	}
	public static void sendKey(WebElement ele, Keys key) {
		ele.sendKeys(key);
	}

	public static WebElement getElement(String how, String locator) {
		WebElement ele = driver.findElement(by(how, locator));
		return ele;
	}

	public static By by(String how, String locator) {
		By by = null;

		if (how.equalsIgnoreCase("id")) {
			by = By.id(locator);
		} else if (how.equalsIgnoreCase("name")) {
			by = By.name(locator);
		} else if (how.equalsIgnoreCase("xpath")) {
			by = By.xpath(locator);
		} else if (how.equalsIgnoreCase("css")) {
			by = By.cssSelector(locator);
		} else if (how.equalsIgnoreCase("class")) {
			by = By.className(locator);
		}
		return by;
	}

	public static void click(String how, String locator) {
		waitForElementPresence(how, locator);
		getElement(how, locator).click();
	}

	public static void click(WebElement ele) {
		ele.click();
	}

	public static void setText(String how, String locator, String textToSet) {
		waitForElementPresence(how, locator);
		getElement(how, locator).clear();
		getElement(how, locator).sendKeys(textToSet);
	}

	public static void setText(WebElement ele, String textToSet) {
		ele.clear();
		ele.sendKeys(textToSet);
	}

	public static void visit(String url) {
		driver.get(url);
	}

	public static void closeBrowser() {
		driver.close();
	}

	public static void waitFor(long timeout) {
		try {
			Thread.sleep(timeout);
			;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static String getText(String how, String locator) {
		System.out.println(getElement(how, locator).getText());
		return getElement(how, locator).getText();
	}
	public static String getText(WebElement ele) {
		System.out.println(ele.getText());
		return ele.getText();
	}
	public static void maximizeBrowser() {
		driver.manage().window().maximize();
	}
}
