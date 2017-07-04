/**
 * File Name: AdactinHomePage.java<br>
 * Alvarez, Jason<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Jul 1, 2017
 */
package com.sqa.ja.adactin;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import com.sqa.ja.adactin.*;
import com.sqa.ja.auto.*;

/**
 * AdactinHomePage //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Alvarez, Jason
 * @version 1.0.0
 * @since 1.0
 */
public class AdactinHomePage extends BasicPage {

	@FindBy(id = "username")
	private WebElement usernameField;

	@FindBy(id = "password")
	private WebElement passwordField;

	@FindBy(id = "login")
	private WebElement loginButton;

	/**
	 * @param test
	 */
	public AdactinHomePage(BasicTest test) {
		super(test);
	}

	public void login(String username, String password) {
		this.usernameField.clear();
		this.usernameField.sendKeys(username);
		this.passwordField.clear();
		this.passwordField.sendKeys(password);
		this.loginButton.click();
	}
}
