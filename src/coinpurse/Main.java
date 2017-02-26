package coinpurse;

import java.util.ResourceBundle;
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

		ResourceBundle bundle = ResourceBundle.getBundle("purse");
		String factoryclass = bundle.getString("moneyfactory");
		MoneyFactory factory = null;
		try {
			factory = (MoneyFactory) Class.forName(factoryclass).newInstance();
		} catch (ClassCastException cce) {
			System.out.println(factoryclass + " is not type MoneyFactor");
		} catch (Exception ex) {
			System.out
					.println("Error creating MoneyFactory " + ex.getMessage());
		}
		if (factory == null)
			System.exit(1);
		else
			MoneyFactory.setMoneyFactory(factory);

		Purse purse = new Purse(CAPASITY);
		ConsoleDialog ui = new ConsoleDialog(purse);
		ui.run();

	}

}
