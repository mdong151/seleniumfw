package modules;

import static supports.CommonFunctions.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import libraries.CreateRequestFunctions;

public class CreateRequestTest {
	
	
	@BeforeMethod
	public static void setup() {
		setBrowser("chrome");
	}
	
	@Test
	public static void testcase01() {
		CreateRequestFunctions page = new CreateRequestFunctions(getDriver());
		page.openHomePage();
		page.fakeAuthenTo("Nguyen Manh Dong");
		page.fillPlanTrip("any","30/09/2017", "01/10/2017", "Ho Chi Minh", "Ha Noi");
		page.fillTripDetails();
		page.fillTravelPreferencePopup();
		page.fillOtherServices();
	}
}
