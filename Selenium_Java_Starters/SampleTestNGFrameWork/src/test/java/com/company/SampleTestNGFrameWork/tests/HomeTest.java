package com.company.SampleTestNGFrameWork.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.company.SampleTestNGFrameWork.base.BaseClass;
import com.company.SampleTestNGFrameWork.pages.HomePage;
import com.company.SampleTestNGFrameWork.pages.LoginPage;

public class HomeTest extends BaseClass {
	
	LoginPage loginPageIns;
	HomePage homePageIns;
	
	@Test(groups = {"smoke"})
	public void homePage1Test() {
		loginPageIns = new LoginPage(driver);
		homePageIns = new HomePage(driver);
		loginPageIns.loginPageMethod1();
		homePageIns.homePageMethod1();
		System.out.println("Test Completed Home Page 1");
	}
	
	@Test
	public void homePage2Test() {
		loginPageIns = new LoginPage(driver);
		loginPageIns.loginPageMethod1();
		System.out.println("Test Completed Home Page 2");
	}
	
	@Test
	public void homePage3Test() {
		homePageIns = new HomePage(driver);
		homePageIns.homePageMethod1();
		System.out.println("Test Completed Home Page 3");
	}
	
	@Test
	public void homePage4FailTest() {
		homePageIns = new HomePage(driver);
		homePageIns.homePageMethod1();
		driver.findElement(By.linkText("Abouts")).getText();
		System.out.println("Test Completed Home Page 4");
	}

}
