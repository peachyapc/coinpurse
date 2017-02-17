package coinpurse;

/**
 * A banknote with a monetary value and currency.
 * 
 * @author Apichaya Tiwcharoensakul
 *
 */
public class BankNote implements Valuable {
	/** Unique serial number starting from 1,000,000 */
	private static long nextSerialNumber = 1000000;
	/** Value of the bank note. */
	private double value;
	/** The currency, of bank note. */
	private String currency;
	/** The unique serial number */
	private long serialNumber;

	/**
	 * Initialize a bank note with given value.
	 * 
	 * @param value
	 *            is a value of the bank note
	 */
	public BankNote(double value) {
		this.value = value;
		this.serialNumber = BankNote.nextSerialNumber;
		BankNote.nextSerialNumber++;
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
		this.value = value;
		this.currency = currency;
		this.serialNumber = BankNote.nextSerialNumber;
		BankNote.nextSerialNumber++;
	}

	/**
	 * Get value from a bank note
	 * 
	 * @return the vale of the bank note
	 */
	@Override
	public double getValue() {
		return value;
	}

	/**
	 * Get currency from a bank note
	 * 
	 * @return the currency of the bank note
	 */
	@Override
	public String getCurrency() {
		return currency;
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
	 * Two bank note are equal if they have the same value and currency.
	 * 
	 * @param other
	 *            is another Object to compare to this one.
	 * @return true if value and currency is same, false otherwise.
	 */
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj.getClass() != this.getClass()) {
			return false;
		}
		BankNote other = (BankNote) obj;
		if (other.currency.equals(this.currency) && other.value == this.value) {
			return true;
		}
		return false;
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
