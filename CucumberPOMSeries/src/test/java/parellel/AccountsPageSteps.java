package parellel;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.QA.factory.DriverFactory;
import com.pages.AccountsPage;
import com.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountsPageSteps {
	
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountspage;
	
	@Given("user has already logged into application")
	public void user_has_already_logged_into_application(DataTable credTable) {
		
	List<Map<String,String>> credList = credTable.asMaps();
	String userName = credList.get(0).get("username");
	String passWord = credList.get(0).get("password");
	
	DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	accountspage =  loginpage.doLogin(userName, passWord);
	    
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
	    String title = accountspage.getAccountsPageTitle();
	    System.out.println("Accounts Page title is: "+title);
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionsTable) {
		
		List<String> expectedAccountSectionList = sectionsTable.asList();
		System.out.println("Expected Accounts Section List: " +expectedAccountSectionList);
		
		List<String> actualAccountSectionList= accountspage.getAccountsSectionList();
		System.out.println("Actual Accounts Section List: " +actualAccountSectionList);
	    
		Assert.assertTrue(expectedAccountSectionList.containsAll(actualAccountSectionList));
	}

	@Then("Accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer ExpectedSectionCount) {
	    Assert.assertTrue(accountspage.getAccountsSectionCount() == ExpectedSectionCount);
	}


}
