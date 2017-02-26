package coinpurse;
/**
 * Coin represents coinage (money) with a fixed value and currency.
 * 
 * @author Apichaya Tiwcharoensakul
 *
 */
public class Coin extends AbstractValuable {
	/**
	 * Initialize a coin with given value using the default currency.
	 * 
	 * @param value
	 *            is a value of coin
	 */
	public Coin(double value) {
		super(value, DEFAULT_CURRENCY);
	}

	/**
	 * Initialize a coin with value and currency.
	 * 
	 * @param value
	 *            is a value of coin
	 * @param currency
	 *            is a currency of coin
	 */
	public Coin(double value, String currency) {
		super(value, currency);

	}

	/**
	 * Get a string representation of this Coin.
	 * 
	 * @return a string representation of the value and currency of the coin.
	 */
	public String toString() {
		return printValue + "-" + printCurrency + " Coin";
	}


}

