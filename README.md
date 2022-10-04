# Overview
This project follows the [POM design pattern](https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/) useing JAVA and Selenium on a [BDD/Cucumber](https://cucumber.io/) framework built on top of maven to automate test cases.

## Features of this BDD framework
* Test cases are written in [Gherkin](https://cucumber.io/docs/gherkin/) language in ``` *.feature ``` files for better understanding of non technical memebers of the team located in ```/src/test/resources/``` under the ``` features``` directory.
``` 
@login
Feature: Login to Heroku App

  Background: User is on the internet page and clicks on Form authentication
    Given User is on the main page

  
```
* Each ``` *.feature ``` file has a corresponding ```step definition``` class that is [linked](https://cucumber.io/docs/cucumber/step-definitions/?lang=java) to one or more gherkin steps located in ```/src/test/java/``` under the ```stepDefinitions``` package.
```
@Given("User is on the main page")
	public void user_is_on_the_main_page() {
	   //method checks whether user is on the main page
		login.userOnIndexPage();
		logger.info("user is on the main page");
	}

	
```
* Each Test case also has it's own page object class or repository to store all UI elements and their action methods located in ```/src/main/java/ ``` under the ``` pageObjects``` package. It uses the ```PageFactory``` to initialize all the elements in the class.
```
public LoginPageObjects() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(tagName = "h1") private WebElement indexPageHeader;

```
* Project has a ```Base``` class that every other class extends for defining the selenuim [WebDriver](https://www.selenium.dev/documentation/webdriver/), launching the browser(read from the properties file in **/src/test/resources/input/config.properties**), reading the url and setting up the ```log4j``` file for logging.

# Requirements to execute the project
  1. [JAVA installation](https://www.oracle.com/java/technologies/downloads/) is required to execute the project.
  2. [Cucumber installation](https://cucumber.io/docs/installation/) is required to execute the project.
  3. Maven.
# Steps to execute the Project
  * Clone the project 
  * Running on eclipse is simple as you direct to the **Runner** Class located in ``` src/test/java/ ``` under the package ``` testRunners``` and run as **Junit Test**.
# Reports 
Reports are generated through ``CucumberReportingConfig```
* HTML reports can be found under the ``` /target/cucumber-html-reports ``` directory with the filename ```overview-features.html```.
* JSON can be found under ``` /target ``` directory with the filename ```{}cucumber.json```
  
  
