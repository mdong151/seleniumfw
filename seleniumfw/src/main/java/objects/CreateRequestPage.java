package objects;

import static supports.CommonFunctions.*;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class CreateRequestPage {
public WebDriver driver;
	
	public CreateRequestPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	public WebElement usernameFld;
	
	@FindBy(id="s2id_autogen18_search")
	public WebElement usernameSearchFld;
	
	@FindBy(xpath="//input[@id='radio_any_Transport']/following-sibling::*[1][name()='div']")
	public WebElement anyTransportRad;
	
	@FindBy(xpath="//div[@id='FromDateTimeAllModule']/*[1]")
	public WebElement startDateFld;
	
	@FindBy(xpath="//div[@id='ToDateTimeAllModule']/*[1]")
	public WebElement endDateFld;
	
	@FindBy(id="s2id_FromTransportationPlace")
	public WebElement fromPlaceFld;
	
	@FindBy(id="s2id_autogen6_search")
	public WebElement fromPlaceSearchFld;
	
	@FindBy(id="s2id_ToTransportationPlace")
	public WebElement toPlaceFld;
	
	@FindBy(id="s2id_autogen7_search")
	public WebElement toPlaceSearchFld;
	
	@FindBy(id="btnNextFirstPage")
	public WebElement nextFirstPageBtn;
	
}
