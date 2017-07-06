/**
 * File Name: AdactinTC102B.java<br>
 * Alvarez, Jason<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Jul 2, 2017
 */
package com.sqa.ja.adactin;

import org.testng.annotations.*;

import com.sqa.ja.auto.*;

/**
 * AdactinTC102B //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Alvarez, Jason
 * @version 1.0.0
 * @since 1.0
 */
public class AdactinTC102B extends BasicTest {

	public AdactinTC102B() {
		super("http://adactin.com/HotelApp");
		this.testingName = "AdactinTC102B";
	}

	@Test
	public void checkinGreaterThanCheckoutTest() {
		System.out.println("Adactin Test Login (TC-102B)");
		AdactinHomePage homePage = new AdactinHomePage(this);
		homePage.login("d0ntkn0w321", "qwertbrz");
		AdactinSearchHotelPage searchPage = new AdactinSearchHotelPage(this);
		searchPage.fillSearchHotelForm();
		String checkinDate = searchPage.addDaysToCurrentDate(7);
		String checkoutDate = searchPage.addDaysToCurrentDate(5);
		searchPage.setDate(checkinDate, checkoutDate);
		searchPage.clickOnSearchButton();
		this.takeScreenshot("TC-102B");
	}
	// @Test
	// public void sampleTest() {
	// System.out.println("Adactin Test Login (TC-102B)");
	// BasicPage resultsPage = new
	// AdactinHomePage(this).login("user","pass").searchForHotels("data");
	// }
}
