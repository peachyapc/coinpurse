package coinpurse;

/**
 * Create Thai money with Satang and Baht currency
 * 
 * @author Apichaya Tiwcharoensakul
 *
 */
public class ThaiMoneyFactory extends MoneyFactory {

	/**
	 * If this value can create then it will decompose the currency of the coin,
	 * First, if value of the coin less than 20, Program will create a coin
	 * else, it will create a bank note. Second, If the value of money less than
	 * 1 it will be create a coin with Satang currency.
	 * 
	 * 
	 * @param value
	 *            of the coin
	 */
	@Override
	Valuable createMoney(double value) {
		if (this.isCreatable(value)) {
			if (value < 20) {
				Coin coin = new Coin(value, "Baht");
				if (value < 1) {
					coin.setPrintValue(value * 100);
					coin.setPrintCurrency("Satang");
				} else {
					coin.setPrintValue(value);
					coin.setPrintCurrency("Baht");
				}
				return coin;
			} else {
				BankNote bank = new BankNote(value, "Baht");
				bank.setSerial(this.nextSerialNumber);
				this.nextSerialNumber++;
				return bank;
			}
		}
		throw new IllegalArgumentException();
	}

	/**
	 * To check that is this value can create a coin or not.
	 * 
	 * @param value
	 *            of the coin that the user has input.
	 * @return true if the value of the coin is
	 *         0.25,0.5,1,2,5,10,20,50,100,500,1000 false if the value is not in
	 *         the provision.
	 */
	private boolean isCreatable(double value) {
		double[] available = {0.5, 0.25, 1, 2, 5, 10, 20, 50, 100, 500, 1000};
		for (double d : available) {
			if (value == d) {
				return true;
			}
		}
		return false;
	}

}
