package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Iterator;

/**
 * Some Coin utility methods for practice using Lists and Comparator.
 * 
 * @author Apichaya Tiwcharoensakul
 */
public class CoinUtil {

	/**
	 * Method that examines all the coins in a List and returns only the coins
	 * that have a currency that matches the parameter value.
	 * 
	 * @param valuables
	 *            is a List of Coin objects. This list is not modified.
	 * @param currency
	 *            is the currency we want. Must not be null.
	 * @return a new List containing only the elements from coinlist that have
	 *         the requested currency.
	 */
	public static List<Valuable> filterByCurrency(final List<Valuable> valuables,
			String currency) {
		List<Valuable> list = new ArrayList<Valuable>();
		for (Valuable valuable : valuables) {
			if (valuable.getCurrency().equals(currency)) {
				list.add(valuable);
			}
		}
		return list;
	}

	/**
	 * Method to sort a list of coins by currency. On return, the list (coins)
	 * will be ordered by currency.
	 * 
	 * @param valueable
	 *            is a List of Coin objects we want to sort.
	 */
	public static void sortByCurrency(List<Valuable> valueable) {
		Collections.sort(valueable, new CoinComparator());

	}

	/**
	 * Sum coins by currency and print the sum for each currency. Print one line
	 * for the sum of each currency.
	 * 
	 * @param valuables
	 *            is the List of coin object to find sum.
	 */
	public static void sumByCurrency(List<Valuable> valuables) {
		Map<String, Double> map = new HashMap<>();
		for (Valuable each : valuables) {
			String currency = each.getCurrency();
			double value = map.getOrDefault(currency, 0.0);
			map.put(currency, value + each.getValue());
		}
		for (String currency : map.keySet()) {
			System.out.println(map.get(currency) + " " + currency);
		}
	}

	/**
	 * This method contains some code to test the above methods.
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		String currency = "Rupee";
		System.out.println("Filter coins by currency of " + currency);
		List<Valuable> valuables = makeInternationalCoins();
		int size = valuables.size();
		System.out.print(" INPUT: ");
		printList(valuables, " ");
		List<Valuable> rupees = filterByCurrency(valuables, currency);
		System.out.print("RESULT: ");
		printList(rupees, " ");
		if (valuables.size() != size)
			System.out.println("Error: you changed the original list.");

		System.out.println("\nSort coins by currency");
		valuables = makeInternationalCoins();
		System.out.print(" INPUT: ");
		printList(valuables, " ");
		sortByCurrency(valuables);
		System.out.print("RESULT: ");
		printList(valuables, " ");

		System.out.println("\nSum coins by currency");
		valuables = makeInternationalCoins();
		System.out.print("coins= ");
		printList(valuables, " ");
		sumByCurrency(valuables);

	}

	/** Make a list of coins containing different currencies. */
	public static List<Valuable> makeInternationalCoins() {
		List<Valuable> money = new ArrayList<Valuable>();
		money.addAll(makeCoins("Baht", 0.25, 1.0, 2.0, 5.0, 10.0, 10.0));
		money.addAll(makeCoins("Ringgit", 2.0, 50.0, 1.0, 5.0));
		money.addAll(makeCoins("Rupee", 0.5, 0.5, 10.0, 1.0));
		// randomize the elements
		Collections.shuffle(money);
		return money;
	}

	/** Make a list of coins using given values. */
	public static List<Valuable> makeCoins(String currency, double... values) {
		List<Valuable> list = new ArrayList<Valuable>();
		for (double value : values)
			list.add(new Coin(value, currency));
		return list;
	}

	/** Print the list on the console, on one line. */
	public static void printList(List items, String separator) {
		Iterator iter = items.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next());
			if (iter.hasNext())
				System.out.print(separator);

		}
		System.out.println(); // end the line
	}
}