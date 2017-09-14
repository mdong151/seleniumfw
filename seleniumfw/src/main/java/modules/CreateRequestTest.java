package modules;

import static supports.CommonFunctions.*;


import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import libraries.CreateRequestFunctions;

public class CreateRequestTest {

	@Test
	public static void testcase01() {
		setBrowser("chrome");
		// visit("https://mnguyen3@amaris.com:Amaris2017@qaarp.amaris.com/TravelAgency/Create");
		visit("https://mnguyen3@amaris.com:Amaris2017@inte.amaris.com/TravelAgency/Create");
		
		waitFor(10000);
		// check if login = Nguyen Manh Dong
		CreateRequestFunctions page = new CreateRequestFunctions(getDriver());
		page.fakeAuthenTo("Bach Phuong Chi");
		click("xpath", "//input[@id='radio_any_Transport']/following-sibling::*[1][name()='div']");
		setText("xpath", "//div[@id='FromDateTimeAllModule']/*[1]", "14/09/2017");
		setText("xpath", "//div[@id='ToDateTimeAllModule']/*[1]", "20/09/2017");

		click("id", "s2id_FromTransportationPlace");
		setText("id", "s2id_autogen6_search", "Ho Chi Minh");// done
		waitFor(10000);
		sendKey("id", "s2id_autogen6_search", Keys.ENTER);

		click("id", "s2id_ToTransportationPlace");
		setText("id", "s2id_autogen7_search", "Ha Noi");// done
		waitFor(10000);
		sendKey("id", "s2id_autogen7_search", Keys.ENTER);

		click("id", "btnNextFirstPage");
		waitFor(10000);
		click("xpath", "//*[@id=\"2page_PreferencesModule\"]/div/div/div[6]/div/button[2]");
		waitFor(7000);
		click("xpath", "//button[@id='btn-save']");
		waitFor(5000);
		click("xpath", "//button[@name='SubmitWithDetail']");
	}
}
