package stepDefinitions;

import core.Base;
import io.cucumber.java.en.*;
import pageObjects.LoginPageObjects;

public class LoginToHerokuApp  extends Base{
	
	//Object of corresponding page object class
	LoginPageObjects login = new LoginPageObjects();
	
	
	@Given("User is on the main page")
	public void user_is_on_the_main_page() {
	   //method checks whether user is on the main page
		login.userOnIndexPage();
		logger.info("user is on the main page");
	}

	@Then("clicks on form authentication")
	public void clicks_on_form_authentication() {
		login.clickOnformAuth();
		logger.info("user clicked on Form Authentication link");
	}

	//Using regular expressions we can format our input so that it runs multiple times and not require multiple steps
	@When("^user inputs \"(.*)\" and \"(.*)\"$")
	public void user_inputs_tomsmith_and_super_secret_password(String username, String password) {
	    login.inputCredintials(username, password);
	    logger.info("User input the username: "+username+ "and password: " +password);
	}

	@When("clicks on login")
	public void clicks_on_login() {
	    login.loginButtonClick();
	    logger.info("user clicks on login button");
	}

	@Then("user should be logged in to heroku app")
	public void user_should_be_logged_in_to_heroku_app() {
		login.verifyLogin();
		
	    driver.quit();
	}

}
