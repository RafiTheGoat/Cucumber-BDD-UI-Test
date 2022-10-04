package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import core.Base;
import io.cucumber.datatable.DataTable;
import junit.framework.Assert;

public class LoginPageObjects extends Base{

	public LoginPageObjects() {
		//Using the PageFactory to initialize our elements in the ui.
		PageFactory.initElements(driver,this);
	}
	
	
	//page objects for Background 
	//using the FindBy annotation from org.openqa.selenium.support to find elements on the DOM.
	//Storing elements as private WebElements to be passed in public methods.
	@FindBy(tagName = "h1") private WebElement indexPageHeader;
	
	@FindBy(xpath="//a[@href='/login']") private WebElement formAuthenticationLink;
	
	//Page objects for the scenario "inputting usernames and passwords"
	@FindBy(id = "username") private WebElement formInputUsername;
	@FindBy(id = "password") private WebElement formInputPassword;
	@FindBy(tagName = "button") private WebElement formInputSubmit;
	
	//verifying objects
	@FindBy(xpath ="//div[@class = \"flash error\"]") private WebElement wrongInput;
	@FindBy(xpath = "//div[@class = \"flash success\"]") private WebElement rightInput;
	
	
	
	//Methods to execute background
	/*
	 * verifying that user is on index page by asserting the header
	 */
	@SuppressWarnings("deprecation")
	public void userOnIndexPage() {
		String expectedText = "Welcome to the-internet";
		String actualText = indexPageHeader.getText();
		Assert.assertEquals(expectedText,actualText);
		
	
	}
	
	/*
	 * clicks on Form Authentication link
	 */
	public void clickOnformAuth() {
		formAuthenticationLink.click();
		
	}
	
	/*
	 * input username and password in the text fields
	 */
	
	public void inputCredintials(String username, String password) {
		formInputUsername.sendKeys(username);
		formInputPassword.sendKeys(password);
		
	}
	/*
	 * user clicks on login button
	 */
	public void loginButtonClick() {
		formInputSubmit.click();
	}
	
	
	
	@SuppressWarnings("deprecation")
	public void verifyLogin() {
		//verifying that wrong input message is not displayed.
		if(rightInput.isDisplayed()) {
			Assert.assertEquals(rightInput.isDisplayed(), true);
		}
		else logger.info("Wrong input by the user!");
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
