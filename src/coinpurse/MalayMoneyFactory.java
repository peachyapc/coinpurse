package coinpurse;

/**
 * Create Malaysia money with Sen and Ringgit currency
 * 
 * @author Apichaya Tiwcharoensakul
 *
 */
public class MalayMoneyFactory extends MoneyFactory {

	/**
	 * If this value can create then it will decompose the currency of the coin,
	 * First, if value of the coin less than 1, Program will create a coin and
	 * the currency will be Sen else, it will create a bank note and the
	 * currency will be Ringgit.
	 * 
	 * @param value
	 *            of the coin
	 */
	@Override
	Valuable createMoney(double value) {
		if (this.isCreatable(value)) {
			if (value < 1) {
				Coin coin = new Coin(value, "Ringgit");
				coin.setPrintValue(value * 100);
				coin.setPrintCurrency("Sen");

				return coin;
			} else {
				BankNote bank = new BankNote(value, "Ringgit");
				bank.setPrintValue(value);
				bank.setPrintCurrency("Ringgit");
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
	 *         0.05,0.1,0.2,0.5,1,2,5,10,20,50,100 
	 *         false if the value is not in
	 *         the provision.
	 */
	private boolean isCreatable(double value) {
		double[] available = {0.05, 0.1, 0.2, 0.5, 1, 2, 5, 10, 20, 50, 100};
		for (double canCreate : available) {
			if (value == canCreate) {
				return true;
			}
		}
		return false;
	}

}
