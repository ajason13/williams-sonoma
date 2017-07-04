/**
 * File Name: AdactinTest.java<br>
 * Alvarez, Jason<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Jul 1, 2017
 */
package com.sqa.ja.adactin;

import java.time.*;
import java.time.format.*;
import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

import com.sqa.ja.helpers.*;

/**
 * AdactinTest //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Alvarez, Jason
 * @version 1.0.0
 * @since 1.0
 */
public class AdactinTest extends AbstractLoginTest {

	private String location = "Sydney";

	private String hotel = "Hotel Creek";

	private String roomType = "Standard";

	private String numOfRooms = "1 - One";

	private Date input;

	private LocalDate date;

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public AdactinTest() {
		super("http://adactin.com/HotelApp");
	}

	@BeforeClass
	public void adactinLogin() {
		login("d0ntkn0w321", "qwertbrz");
		this.input = new Date();
		this.date = this.input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	@AfterClass
	public void adactinLogout() {
		logout();
	}

	public String addDaysToCurrentDate(int days) {
		String temp = this.date.plusDays(days).format(this.formatter);
		return temp;
	}

	public Select createSelect(String id) {
		return new Select(createWebElement(id));
	}

	public WebElement createWebElement(String id) {
		if (this.isPresent(By.id(id))) {
			return getDriver().findElement(By.id(id));
		}
		return null;
	}

	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return this.date;
	}

	/**
	 * @return the hotel
	 */
	public String getHotel() {
		return this.hotel;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return this.location;
	}

	/**
	 * @return the numOfRooms
	 */
	public String getNumOfRooms() {
		return this.numOfRooms;
	}

	/**
	 * @return the roomType
	 */
	public String getRoomType() {
		return this.roomType;
	}

	/**
	 * @see com.sqa.ja.helpers.AbstractLoginTest#login()
	 */
	@Override
	public void login(String username, String password) {
		this.takeScreenshot("Pre-login");
		WebElement usernameField = getDriver().findElement(By.id("username"));
		WebElement passwordField = getDriver().findElement(By.id("password"));
		WebElement loginButton = getDriver().findElement(By.id("login"));
		usernameField.clear();
		usernameField.sendKeys(username);
		passwordField.clear();
		passwordField.sendKeys(password);
		loginButton.click();
		this.takeScreenshot("Post-login");
	}

	/**
	 * @see com.sqa.ja.helpers.AbstractLoginTest#logout()
	 */
	@Override
	public void logout() {
		this.takeScreenshot("Pre-logout");
		WebElement logoutField = getDriver().findElement(By.cssSelector("a[href='Logout.php']"));
		logoutField.click();
		this.takeScreenshot("Post-logout");
	}
}
