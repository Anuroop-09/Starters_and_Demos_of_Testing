package com.company.SampleTestNGFrameWork.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.company.SampleTestNGFrameWork.utils.Utils;

public class LoginPage extends Utils {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Sample locator declaration as WebElements
	 * By using @Findby annotation and locator method create an element. Check below samples
	 */
	// @FindBy(id = "username") WebElement usernameInput;
	// @FindBy(id = "password") WebElement passwordInput;
	// @FindBy(id = "login") WebElement loginBtn;
	@FindBy(css = "svg[aria-label='Google']") WebElement googleLogo;
	
	/**
	 * Sample method declaration with using declared WebElements
	 * 
	public void loginToApplication(String username, String password) {
		usernameInput.sendKeys(username);
		System.out.println("Entered " + username + " in Username field");
		passwordInput.sendKeys(password);
		System.out.println("Entered " + password + " in Password field");
		loginBtn.click();
		System.out.println("Clicked on Login button");
	}
	 */
	
	public void loginPageMethod1() {
		waitForVisibilityOfElement(googleLogo);
		System.out.println(driver.getTitle());
		System.out.println("I'm a method 1 from Login Page");
	}
	

}
