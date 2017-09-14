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
	
	public void planTrip(String startDate,String endDate, String fromPlace, String toPlace) {
		click(anyTransportRad);
		setText(startDateFld, startDate);
		setText(endDateFld, endDate);
		selectSearchFld(fromPlaceFld, fromPlaceSearchFld, fromPlace);
		selectSearchFld(toPlaceFld, toPlaceSearchFld, toPlace);		
	}
}
