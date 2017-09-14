package libraries;

import static supports.CommonFunctions.*;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


import objects.CreateRequestPage;


public class CreateRequestFunctions extends CreateRequestPage{

	public CreateRequestFunctions(WebDriver driver) {
		super(driver);
	}
	
	public void fakeAuthenTo(String username) {
		if (! (getText(usernameFld).trim().equalsIgnoreCase(username.trim())) ) {
			click(usernameFld);
			setText(usernameSearchFld, username);
			waitFor(15000);
			sendKey(usernameSearchFld, Keys.ENTER);
			refreshCurrentPage();
		}
	}
}
