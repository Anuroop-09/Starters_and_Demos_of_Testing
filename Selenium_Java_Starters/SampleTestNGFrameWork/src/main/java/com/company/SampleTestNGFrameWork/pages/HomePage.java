package com.company.SampleTestNGFrameWork.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.company.SampleTestNGFrameWork.utils.Utils;

public class HomePage extends Utils {
	
private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Sample locator declaration as WebElements
	 * By using @Findby annotation and locator method create an element. Check below samples
	 */
	// @FindBy(id = "products") WebElement products;
	@FindBy(css = "svg[aria-label='Google']") WebElement googleLogo;
	
	/**
	 * Sample method declaration with using declared WebElements
	 */
	
	public void homePageMethod1() {
		waitForVisibilityOfElement(googleLogo);
		System.out.println(driver.getTitle());
		System.out.println("I'm a method 1 from Home Page");
	}

}
