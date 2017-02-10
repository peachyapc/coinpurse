package coinpurse;
import java.util.Comparator;

/**
 * CoinComparator implement Comparator to override compare method.
 * 
 * @author Apichaya Tiwcharoensakul
 *
 */
public class CoinComparator implements Comparator<Coin> {

	/**
	 * Compare the currency between two coin. Return -1 if String of o1 has come
	 * first, 0 if they have the same string, 1 if string of o2 has come first.
	 * 
	 * @param o1
	 *            is the first coin object to compare. 
	 *        o2 is the second coin
	 *            object to compare.
	 * 
	 * @return -1 if String of o1 has come first, 
	 * 			0 if they have the same string. 
	 *          1 if string of o2 has come first.
	 */
	@Override
	public int compare(Coin o1, Coin o2) {
		return o1.getCurrency().compareTo(o2.getCurrency());
	}

}
