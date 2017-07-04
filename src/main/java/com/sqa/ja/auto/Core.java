/**
 * File Name: Core.java<br>
 * Alvarez, Jason<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Jun 28, 2017
 */
package com.sqa.ja.auto;

import org.apache.log4j.*;
import org.openqa.selenium.*;

import com.sqa.ja.adactin.*;

/**
 * Core //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Alvarez, Jason
 * @version 1.0.0
 * @since 1.0
 */
public class Core {

	private String baseURL;

	private WebDriver driver;

	private Logger log = Logger.getLogger(this.getClass());

	private int screenshotCount = 1;

	protected String testingName = "Auto Test";

	private BasicTest relTest;

	public Core(BasicTest test) {
		this.baseURL = test.getBaseURL();
		this.driver = test.getDriver();
		this.relTest = test;
	}

	public Core(String baseURL) {
		this.baseURL = baseURL;
		this.driver = null;
	}

	/**
	 * @param baseURL
	 * @param driver
	 */
	public Core(String baseURL, WebDriver driver) {
		this.baseURL = baseURL;
		this.driver = driver;
	}

	/**
	 * @return the baseURL
	 */
	public String getBaseURL() {
		return this.baseURL;
	}

	/**
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return this.driver;
	}

	public Logger getLog() {
		return this.log;
	}

	public boolean isPresent(By by) {
		return AutoBasics.isElementPresent(getDriver(), by, getLog());
	}

	/**
	 * @param driver
	 *            the driver to set
	 */
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public boolean takeScreenshot() {
		boolean tookScreenShot = AutoBasics.takeScreenshot("screenshots", this.testingName + this.screenshotCount,
				getDriver(), getLog());
		if (tookScreenShot) {
			this.screenshotCount++;
		}
		return tookScreenShot;
	}

	public boolean takeScreenshot(String fileName) {
		return AutoBasics.takeScreenshot("screenshots", fileName, getDriver(), getLog());
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " driver=" + this.driver + ", baseURL=" + this.baseURL + ", log="
				+ this.log + "]";
	}
}
