package com.company.SampleTestNGFrameWork.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

	private WebDriver driver;
	private WebDriverWait wait;

	public Utils(WebDriver driver) {
		// TODO Auto-generated constructor stub\
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void waitForVisibilityOfElement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		System.out.println("Element located on the page");
	}
	
	public void waitForInvisibilityOfElement(WebElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));
		System.out.println("Element is disappeared on the page");
	}
	
	public void selectValueFromDropDown(WebElement element, String selectBy, String valueToSelect) {
		Select dropdown = new Select(element);
		switch (selectBy) {
		case "ByValue": {
			dropdown.selectByValue(valueToSelect);
			System.out.println(valueToSelect + " got selected from the dropdown");
			break;
		}
		case "ByVisibleText": {
			dropdown.selectByVisibleText(valueToSelect);
			System.out.println(valueToSelect + " got selected from the dropdown");
			break;
		}
		case "ByIndex": {
			dropdown.selectByIndex(Integer.parseInt(valueToSelect));
			System.out.println(valueToSelect + " got selected from the dropdown");
			break;
		}
		default:
			throw new IllegalArgumentException("IllegalArgument provided: " + selectBy);
		}
	}

}
