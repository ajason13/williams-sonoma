/**
 * File Name: AutoBasics.java<br>
 * Alvarez, Jason<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Jun 28, 2017
 */
package com.sqa.ja.auto;

import java.io.*;
import java.util.*;
import java.util.NoSuchElementException;

import org.apache.commons.io.*;
import org.apache.log4j.*;
import org.openqa.selenium.*;

/**
 * AutoBasics //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods) all static methods
 *
 * @author Alvarez, Jason
 * @version 1.0.0
 * @since 1.0
 */
public class AutoBasics {

	public static String getProp(String propName, String fileLocation, String fileName, Logger logger) {
		Properties props = new Properties();
		InputStream input;
		try {
			input = new FileInputStream(fileLocation + fileName);
			props.load(input);
		} catch (FileNotFoundException e) {
			logger.warn("Can not load config properties file because it was not found: " + fileName);
		} catch (IOException e) {
			logger.warn("Can not load config properties file can not be read: " + fileName);
		}
		return props.getProperty(propName);
	}

	// For Pop Ups
	public static boolean isElementPresent(WebDriver driver, By by, Logger logger) {
		try {
			WebElement element = driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			logger.warn("Element was not found: " + by);
			return false;
		}
	}

	public static boolean takeScreenshot(String fileLocation, String fileName, WebDriver driver, Logger logger) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(fileLocation + "/" + fileName + ".png"));
		} catch (IOException e) {
			logger.warn("Screenshot " + fileName + " was not captured to disk correctly.");
			return false;
		}
		return true;
	}
}
