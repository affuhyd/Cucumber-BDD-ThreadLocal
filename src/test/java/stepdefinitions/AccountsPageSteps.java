package stepdefinitions;

import java.util.List;
import java.util.Map;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class AccountsPageSteps {
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage;
	private String title;
	
	@Given("User has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable dataTable) {
		List<Map<String,String>> credList = dataTable.asMaps();
		String username = credList.get(0).get("username");
		String password = credList.get(1).get("password");
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		loginPage.enterUserName(username);
		loginPage.enterPassword(password);
		accountsPage = loginPage.clickOnLogin();
	}

	@Given("User is on Accounts Page")
	public void user_is_on_accounts_page() {
		System.out.println("Accounts page title is :"+ accountsPage.getTitle());
	    }

	
	@Then("user gets account section")
	public void user_gets_account_section(DataTable sectionsTable) {
		System.out.println("Expected list is :"+sectionsTable.asList());
		System.out.println("Actual list is :"+accountsPage.getAccountsSectionsList());
		boolean flag = sectionsTable.asList().containsAll(accountsPage.getAccountsSectionsList());
		Assert.assertTrue(flag);
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedCount) {
		Assert.assertEquals(accountsPage.getAccountsSectionCount(), expectedCount);
		
	}
}
