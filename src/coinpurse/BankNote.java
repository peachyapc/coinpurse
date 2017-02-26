package coinpurse;

/**
 * A banknote with a monetary value and currency.
 * 
 * @author Apichaya Tiwcharoensakul
 *
 */
public class BankNote extends AbstractValuable {

	/** The unique serial number */
	private long serialNumber;

	/**
	 * Initialize a bank note with given value.
	 * 
	 * @param value
	 *            is a value of the bank note
	 */
	public BankNote(double value) {
		super(value, DEFAULT_CURRENCY);
	}

	/**
	 * Initialize a bank note with value and currency.
	 * 
	 * @param value
	 *            is a value of the bank note
	 * @param currency
	 *            is a currency of the bank note
	 */
	public BankNote(double value, String currency) {
		super(value, currency);
	}

	/**
	 * Get serial number from a bank note
	 * 
	 * @return the serial number of the bank note
	 */
	public long getSerial() {
		return serialNumber;
	}

	/**
	 * Set serial number from a bank note.
	 * 
	 * @param serial
	 */
	public void setSerial(long serial) {
		this.serialNumber = serial;
	}

	/**
	 * Get a string representation of this Bank note.
	 * 
	 * @return a string representation of the value, currency and serial number
	 *         of the bank note.
	 */
	public String toString() {
		return value + " " + currency + " note [" + serialNumber + "]";
	}
}
