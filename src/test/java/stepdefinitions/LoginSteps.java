package stepdefinitions;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private String title;
	
	@Given("User is on Login Page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

	}

	@When("User gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginPage.getLoginPageTitle();
		System.out.println("login page title is :"+title);
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
		Assert.assertTrue(title.contains(expectedTitleName));
	}

	@Then("Forgot Password link should be displayed")
	public void forgot_password_link_should_be_displayed() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExists());
	}

	@When("User enters username {string}")
	public void user_enters_username(String username) {
		loginPage.enterUserName(username);
	}

	@When("User enters password {string}")
	public void user_enters_password(String pwd) {
		loginPage.enterPassword(pwd);
	}
	

	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
		loginPage.clickOnLogin();
	}
}
