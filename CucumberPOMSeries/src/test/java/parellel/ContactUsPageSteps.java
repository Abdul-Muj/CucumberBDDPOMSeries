package parellel;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import com.QA.factory.DriverFactory;
import com.QA.util.ExcelReader;
import com.pages.ContactUsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsPageSteps {
	
	private ContactUsPage contactuspage = new ContactUsPage(DriverFactory.getDriver());
	ExcelReader excelreader = new ExcelReader();
	
	@Given("user navigates to contact us page")
	public void user_navigates_to_contact_us_page() {
	    DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=contact");
	}

	@When("user fills the form from given sheet name {string} and rownumber {int}")
	public void user_fills_the_form_from_given_sheet_name_and_rownumber(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
	    List<Map<String,String>> testData = 
	    		excelreader.getData("C:/Users/Waseem Akram/OneDrive/Desktop/automation.xlsx", sheetName);
	   String heading =  testData.get(rowNumber).get("subjectheading");
	   String email =  testData.get(rowNumber).get("email");
	   String orderref =  testData.get(rowNumber).get("orderref");
	   String message =  testData.get(rowNumber).get("message");
	   
	   contactuspage.fillContactUsForm(heading, email, orderref, message);
	}

	@When("user clicks on Send button")
	public void user_clicks_on_send_button() {
		contactuspage.clickSend();
	}

	@Then("it shows successfull message {string}")
	public void it_shows_successfull_message(String expectedSuccessMessage) {
		String actualSuccessMsg = contactuspage.getSuccessMessg();
		Assert.assertEquals(actualSuccessMsg, expectedSuccessMessage);
	}


}
