package coinpurse;
/**
 * Coin represents coinage (money) with a fixed value and currency.
 * 
 * @author Apichaya Tiwcharoensakul
 *
 */
public class Coin implements Comparable<Coin>, Valuable{
	public static String DEFAULT_CURRENCY = "Baht";
	/** Value of the coin. */
	private final double value;
	/** The currency, of course. */
	private final String currency;

	/**
	 * Initialize a coin with given value using the default currency.
	 * 
	 * @param value
	 *            is a value of coin
	 */
	public Coin(double value) {
		this.value = value;
		this.currency = DEFAULT_CURRENCY;
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
		this.value = value;
		this.currency = currency;

	}

	/**
	 * Get value from a coin
	 * 
	 * @return the vale of the coin
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * Get currency from a coin
	 * 
	 * @return the currency of the coin
	 */
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * Two coins are equal if they have the same value and currency.
	 * 
	 * @param other
	 *            is another Object to compare to this one.
	 * @return true if value and currency is same, false otherwise.
	 */
	public boolean equals(Object obj) {
		// don't allow other to be null.
		if (obj == null) {
			return false;
		}
		if (obj.getClass() != this.getClass()) {
			return false;
		}
		// cast other to Coin so we can get its attributes.
		Coin other = (Coin) obj;
		if (other.value == this.value && other.currency.equals(this.currency)) {
			return true;
		}
		return false;
	}

	/**
	 * Get a string representation of this Coin.
	 * 
	 * @return a string representation of the value and currency of the coin.
	 */
	public String toString() {
		return value + " " + currency;
	}

	/**
	 * Compare this coin with another coin. If this coin has less value than
	 * another coin it will return -1, if it equal it will return 0, and if this
	 * coin has a greater value it will return 1.
	 * 
	 * @param c
	 *            is the coin object to compare
	 * @return -1 if another coin has greater value 
	 * 			0 if they have the same value 
	 *         -1 if another value have lesser value
	 */
	@Override
	public int compareTo(Coin c) {
		if (c == null) {
			return -1;
		}
		return (int) Math.signum(this.value - c.value);
	}

}

