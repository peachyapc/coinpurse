package coinpurse;

import java.util.Scanner;

/**
 * A main class to create objects and connect objects together. The user
 * interface needs a reference to coin purse.
 * 
 * @author Apichaya Tiwcharoensakul
 */
public class Main {

	/** Capacity of the purse */
	private static int CAPASITY = 10;

	/**
	 * Configure and start the application.
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {

		MoneyFactory.setMoneyFactory(new MalayMoneyFactory());

		Purse purse = new Purse(CAPASITY);
		ConsoleDialog ui = new ConsoleDialog(purse);
		ui.run();


	}

}
