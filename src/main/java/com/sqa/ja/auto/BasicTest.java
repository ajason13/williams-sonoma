package com.sqa.ja.auto;

import java.util.concurrent.*;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.*;
import org.testng.annotations.*;

import com.sqa.ja.auto.*;

public class BasicTest extends Core {

	/**
	 * @param baseURL
	 * @param driver
	 */
	public BasicTest(String baseUrl) {
		super(baseUrl);
	}

	@BeforeClass(enabled = true)
	public void setUpChrome() throws Exception {
		System.out.println("Setup Chrome");
		// Set system property to use Chrome driver
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		// Setup the driver to use Chrome
		setDriver(new ChromeDriver());
		// Set an implicit wait of 30 second (If pass 30 seconds to find
		// element, fail test case)
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Maximize the window
		getDriver().manage().window().maximize();
		// Goto Base URL
		getDriver().get(getBaseURL());
	}

	@BeforeClass(enabled = false)
	public void setUpFirefox() throws Exception {
		System.out.println("Setup Firefox");
		// Setup the driver to use Firefox
		setDriver(new FirefoxDriver());
		// Set an implicit wait of 30 second (If pass 30 seconds to find
		// element, fail test case)
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Maximize the window
		getDriver().manage().window().maximize();
		// Goto Base URL
		getDriver().get(getBaseURL());
	}

	@BeforeClass(enabled = false)
	public void setUpIE() throws Exception {
		System.out.println("Setup IE");
		// Set system property to use IE driver
		System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
		// Setup the driver to use Internet Explorer
		setDriver(new InternetExplorerDriver());
		// Set an implicit wait of 30 second (If pass 30 seconds to find
		// element, fail test case)
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Maximize the window
		getDriver().manage().window().maximize();
		// Goto Base URL
		getDriver().get(getBaseURL());
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		// Quit all instances of the bowser
		getDriver().quit();
		// Close method would close all instances
	}
	// @Test
	// public void test1() {
	// getDriver().get(getBaseURL());
	// this.takeScreenshot(); // Auto Test 01
	// this.takeScreenshot("Test Case 01"); // Test Case 01
	// this.takeScreenshot(); // Test Case 02
	// this.takeScreenshot(); // Test Case 03
	// this.testingName = "Adactin";
	// this.takeScreenshot("Adactin Test"); // Adactin Test
	// this.takeScreenshot(); // Adactin Test 04
	// AutoBasics.takeScreenshot("screenshots", "Adactin Test", getDriver(),
	// getLog());
	// }
}
