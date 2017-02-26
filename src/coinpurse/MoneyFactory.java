package coinpurse;

/**
 * MoneyFactory class for sreating money. Provides a concrete factory instance
 * from a subclass and defines the methods used to create coins and bank note
 * 
 * @author Apichaya Tiwcharoensakul
 *
 */
public abstract class MoneyFactory {
	/** Unique serial number starting from 1,000,000 */
	protected long nextSerialNumber = 1000000;
	private static MoneyFactory factory;

	/**
	 * Get instance of MoneyFactory
	 * 
	 * @return the MoneyFactory instance.
	 */
	public static MoneyFactory getInstance() {
		return factory;
	}

	/**
	 * Set the instance of MoneyFactory
	 * 
	 * @param factory
	 *            will be MalayMoneyFactory or ThaiMoneyFactory.
	 */
	public static void setMoneyFactory(MoneyFactory factory) {
		MoneyFactory.factory = factory;
	}

	/**
	 * Create money by its value
	 * 
	 * @param is
	 *            the amount of money to be created
	 * @return a Valuable object of the specified amount.
	 */
	abstract Valuable createMoney(double value);

	/**
	 * Create money by its value in String.
	 * 
	 * @param value
	 *            the amount of money to be created.
	 * @return a Valuable object of the specified amount.
	 * @throws IllegalArgumentException
	 *             if the value of the money is invalid.
	 */
	Valuable createMoney(String value) {
		try {
			return createMoney(Double.parseDouble(value));
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}

	}

}
