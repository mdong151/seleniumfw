package modules;

import static supports.CommonFunctions.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import libraries.CreateRequestFunctions;

public class CreateRequestTest {
	static CreateRequestFunctions page = new CreateRequestFunctions(getDriver());
	
	@BeforeMethod
	public static void setup() {
		setBrowser("chrome");
		page.openHomePage();	
	}
	
	@Test
	public static void testcase01() {
		
		page.fakeAuthenTo("Nguyen Manh Dong");
		page.fillPlanTrip("plane","20/09/2017", "25/09/2017", "Ho Chi Minh", "Ha Noi");
		waitFor(10000);
		page.fillTripDetails();
		waitFor(10000);
		page.fillTravelPreferencePopup();
		waitFor(5000);
		page.fillOtherServices();
	}
}
