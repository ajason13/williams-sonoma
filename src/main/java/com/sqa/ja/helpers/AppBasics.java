package com.sqa.ja.helpers;

import java.util.*;

public class AppBasics {

	private static Scanner scan = new Scanner(System.in);

	/**
	 * Method to farewell user from the application
	 */
	public static void farewellUser(String name) {
		System.out.print("Thanks for using this app.\nHave a great day " + name + "!");
		scan.close();
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

	public static boolean requestBoolean(String question) {
		System.out.println(question);
		return scan.nextBoolean();
	}

	public static char requestChar(String question) {
		System.out.println(question);
		char c = scan.next().charAt(0);
		return c;
	}

	public static float requestFloat(String question) {
		System.out.println(question);
		return scan.nextFloat();
	}

	public static long requestLong(String question) {
		System.out.println(question);
		return scan.nextLong();
	}

	public static short requestShort(String question) {
		System.out.println(question);
		return scan.nextShort();
	}

	public static String requestString(String question) {
		System.out.println(question);
		scan.nextLine();
		String s = scan.nextLine();
		scan.nextLine();
		return s;
	}
}
