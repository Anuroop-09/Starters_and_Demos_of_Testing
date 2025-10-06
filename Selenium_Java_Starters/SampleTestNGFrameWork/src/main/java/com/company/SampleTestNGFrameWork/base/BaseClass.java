package com.company.SampleTestNGFrameWork.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseClass {

	public WebDriver driver;
	private Properties properties;
	
	// Run for every class before any method declared in the Class started executing
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException {
		initializeBrowser();
		launchApplication();
	}

	// Run for every class after all methods declared are completed executing in the Class
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			driver.quit();
			System.out.println("Browser Terminated & Session Closed");
		}
	}

	/**
	 * This method is used to create instance of browser and start launching the browser in maximized mode
	 * 
	 * In this method, It can read parameters / additional configurations that provided in command line execution
	 * List of configurations set:
	 * 	i. BROWSER: Run tests in a specific browser (chrome / firefox / edge). Syntax: -DBROWSER={value}
	 * @throws IOException
	 */
	public void initializeBrowser() throws IOException {
		String cmdBrowser = System.getProperty("BROWSER");
		String browserToInitialize = cmdBrowser != null ? cmdBrowser : getGlobalProperty("BROWSER");
		try {
			System.out.println("Started Initializing Browser: "+browserToInitialize.toUpperCase());
			if (browserToInitialize.contains("chrome")) {
				ChromeOptions options = new ChromeOptions();
				if (browserToInitialize.contains("headless")) {
					options.addArguments("headless");
				}
				driver = new ChromeDriver(options);
			} else if (browserToInitialize.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			} else if (browserToInitialize.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			} else {
				throw new IllegalArgumentException("Browser not supported! Please provide 'CHORME | EDGE | FIREFOX'");
			}
			driver.manage().window().maximize();
		} catch (Exception err) {
			// TODO: handle exception
			System.out.println("Failed to initialize the browser "+err.getMessage());
		}
	}

	/**
	 * This method is used to launch the application on the browser instance which got created in initializeBrowser() method
	 */
	public void launchApplication() {
		try {
			String applicationUrl = getGlobalProperty("APPLICATION_URL");
			driver.get(applicationUrl);
			System.out.println("Application launched successfully");
		} catch (Exception err) {
			// TODO: handle exception
			System.out.println("Failed to launch the application "+err.getMessage());
		}
	}
	
	/**
	 * This method is used to get global properties declared in configuration file
	 * It takes property key as an argument to get the desired key value
	 * @param keyName
	 * @return
	 * @throws IOException
	 */
	public String getGlobalProperty(String keyName) throws IOException {
		properties = new Properties();
		FileInputStream configFile = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties");
		properties.load(configFile);
		return properties.getProperty(keyName);
	}
	
	/**
	 * This method is used to take the screen shot of the page when the execution got failed
	 * It takes driver object and name of the test case as arguments
	 * It saves the file in the path :project_root_folder/screenshots/..(files)
	 * It returns the path of file saved to use the path in attaching in html reports to the respective failure
	 * @param driver
	 * @param testCaseName
	 * @return
	 * @throws IOException
	 */
	public String takeScreenShotOfThePage(WebDriver driver, String testCaseName) throws IOException {
		TakesScreenshot screenShot = (TakesScreenshot) driver;
		File sourceOfScreenShot = screenShot.getScreenshotAs(OutputType.FILE);
		String destinationPath = System.getProperty("user.dir")+"\\screenshots\\"+testCaseName+".png";
		File destinationToSaveFile = new File(destinationPath);
		FileUtils.copyFile(sourceOfScreenShot, destinationToSaveFile);
		return destinationPath;
	}
	
	/**
	 * This method is used to read and get the JSON data and return the retrieved data
	 * It takes file path of the JSON as argument
	 * It returns that data in Hashmap
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public List<HashMap<String, String>> readAndGetJsonData(String filePath) throws IOException {
		String jsonData = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonData, new TypeReference<List<HashMap<String, String>>>() {});
		return data;
	}

}