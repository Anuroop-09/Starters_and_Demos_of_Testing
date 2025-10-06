package com.company.SampleTestNGFrameWork.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.company.SampleTestNGFrameWork.base.BaseClass;
import com.company.SampleTestNGFrameWork.pages.HomePage;
import com.company.SampleTestNGFrameWork.pages.LoginPage;

public class LoginTest extends BaseClass {

	LoginPage loginPageIns;
	HomePage homePageIns;
	
	@Test
	public void loginPage1Test() {
		loginPageIns = new LoginPage(driver);
		loginPageIns.loginPageMethod1();
		System.out.println("Test Completed Login Page 1");
	}
	
	@Test
	public void loginPage2Test() {
		homePageIns = new HomePage(driver);
		homePageIns.homePageMethod1();
		System.out.println("Test Completed Login Page 2");
	}
	
	@Test(groups = {"smoke"})
	public void loginPage3Test() {
		loginPageIns = new LoginPage(driver);
		homePageIns = new HomePage(driver);
		loginPageIns.loginPageMethod1();
		homePageIns.homePageMethod1();
		System.out.println("Test Completed Login Page 3");
	}
	
	@Test(dataProvider = "dataTest", groups = {"dataProvider"})
	public void dataProviderTest(String email, String password) {
		System.out.println("Email: " + email + ", Password: " + password);
	}
	
	@DataProvider
	public Object[][] dataTest() {
		Object[][] data = new Object[][] {{ "email", "password"}};
		return data;
		
	}

}
