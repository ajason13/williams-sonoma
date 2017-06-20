package com.sqa.ja.helpers;

import java.util.*;

public class AppBasics {

	private static Scanner scan = new Scanner(System.in);

	/**
	 * Method to farewell user from the application
	 */
	public static void farewellUser(String name) {
		System.out.print("Thanks for using this app.\nHave a great day " + name + "!");
	}

	/**
	 * Method to greet user and get name
	 *
	 * @return The user's name
	 */
	public static String greetUserAndGetName(String appName) {
		System.out.println("Welcome to the " + appName + " Application");
		System.out.print("Could I get your name please: ");
		return scan.nextLine();
	}
}
