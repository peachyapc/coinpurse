package coinpurse;

/**
 * The parent class of the Coin and Banknote.
 * 
 * @author Apichaya Tiwcharoensakul
 *
 */
public abstract class AbstractValuable implements Valuable {

	public static String DEFAULT_CURRENCY = "Baht";
	/** Value of the coin. */
	protected final double value;
	/** The currency, of course. */
	protected final String currency;
	/** The coin value up to the currency of the coin */
	protected double printValue;
	/** The coin currency use a different denomination from base currency */
	protected String printCurrency;

	/**
	 * Initialize a AbstractValuable with value and currency.
	 * 
	 * @param value
	 *            is a value of coin
	 * @param currency
	 *            is a currency of coin
	 */
	public AbstractValuable(double value, String currency) {
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
	 * Get the value of the coin with different currency
	 * 
	 * @return the vale of the coin
	 */
	public double getPrintValue() {
		return printValue;
	}

	/**
	 * Get currency from a coin use a different denomination from base currency.
	 * 
	 * @return the currency of the coin
	 */
	public String getPrintCurrency() {
		return printCurrency;
	}

	/**
	 * Set the value of the coin.
	 * 
	 * @param printValue
	 * 
	 */
	public void setPrintValue(double printValue) {
		this.printValue = printValue;
	}

	/**
	 * Set the currency of the coin.
	 * 
	 * @param printCurrency
	 * 
	 */
	public void setPrintCurrency(String printCurrency) {
		this.printCurrency = printCurrency;
	}

	/**
	 * Two valuable are equal if they have the same value and currency.
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
		Valuable other = (Valuable) obj;
		if (other.getValue() == this.getValue()
				&& other.getCurrency().equals(this.getCurrency())) {
			return true;
		}
		return false;
	}

	/**
	 * Compare this coin with another coin. If this coin has less value than
	 * another coin it will return -1, if it equal it will return 0, and if this
	 * coin has a greater value it will return 1.
	 * 
	 * @param c
	 *            is the coin object to compare
	 * @return -1 if another coin has greater value 0 if they have the same
	 *         value -1 if another value have lesser value
	 */
	@Override
	public int compareTo(Valuable c) {
		if (c == null) {
			return -1;
		}
		if (c.getCurrency().equals(this.getCurrency())) {
			return (int) Math.signum(this.getValue() - c.getValue());
		} else {
			return c.getCurrency().compareTo(this.getCurrency());
		}
	}

}