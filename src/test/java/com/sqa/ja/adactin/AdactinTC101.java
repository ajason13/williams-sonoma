/**
 * File Name: AdactinTC101.java<br>
 * Alvarez, Jason<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Jul 1, 2017
 */
package com.sqa.ja.adactin;

import org.testng.*;
import org.testng.annotations.*;

/**
 * AdactinTC101 //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Alvarez, Jason
 * @version 1.0.0
 * @since 1.0
 */
public class AdactinTC101 extends AdactinTest {

	@Test
	public void doTest() {
		System.out.println("Adactin Test Login (TC-101)");
		String expectPageTitle = "AdactIn.com - Search Hotel";
		String actualPageTitle = getDriver().getTitle();
		Assert.assertEquals(actualPageTitle, expectPageTitle);
	}
}
