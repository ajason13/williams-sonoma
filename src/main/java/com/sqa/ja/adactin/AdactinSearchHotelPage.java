/**
 * File Name: AdactinSearchHotelPage.java<br>
 * Alvarez, Jason<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Jul 3, 2017
 */
package com.sqa.ja.adactin;

import java.time.*;
import java.time.format.*;
import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import com.sqa.ja.auto.*;

/**
 * AdactinSearchHotelPage //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Alvarez, Jason
 * @version 1.0.0
 * @since 1.0
 */
public class AdactinSearchHotelPage extends BasicPage {

	@FindBy(id = "location")
	private WebElement locationField;

	@FindBy(id = "hotels")
	private WebElement hotelField;

	@FindBy(id = "room_type")
	private WebElement roomTypeField;

	@FindBy(id = "room_nos")
	private WebElement numOfRoomsField;

	@FindBy(id = "datepick_in")
	private WebElement checkinDateField;

	@FindBy(id = "datepick_out")
	private WebElement checkoutDateField;

	@FindBy(id = "Submit")
	private WebElement submitButton;

	private Date input;

	private LocalDate date;

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	/**
	 * @param test
	 */
	public AdactinSearchHotelPage(BasicTest test) {
		super(test);
	}

	public String addDaysToCurrentDate(int days) {
		String temp = this.date.plusDays(days).format(this.formatter);
		return temp;
	}

	public void clickOnSearchButton() {
		this.submitButton.click();
	}

	public void fillSearchHotelForm() {
		new Select(this.locationField).selectByVisibleText("Sydney");
		new Select(this.hotelField).selectByVisibleText("Hotel Creek");
		new Select(this.roomTypeField).selectByVisibleText("Standard");
		new Select(this.numOfRoomsField).selectByVisibleText("1 - One");
		this.input = new Date();
		this.date = this.input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return this.date;
	}

	public void setDate(String checkinDate, String checkoutDate) {
		this.checkinDateField.clear();
		this.checkinDateField.sendKeys(checkinDate);
		this.checkoutDateField.clear();
		this.checkoutDateField.sendKeys(checkoutDate);
	}
}
