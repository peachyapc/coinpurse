package coinpurse;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/**
 * A coin purse contains coins. You can insert coins, withdraw money, check the
 * balance, and check if the purse is full. When you withdraw money, the coin
 * purse decides which coins to remove.
 * 
 * @author Apichaya Tiwcharoensakul
 */
public class Purse {
	/** Collection of objects in the purse. */
	private List<Coin> money = new ArrayList<Coin>();
	/**
	 * Capacity is maximum number of coins the purse can hold. Capacity is set
	 * when the purse is created and cannot be changed.
	 */
	private int capacity;

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity
	 *            is maximum number of coins you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * Count and return the number of coins in the purse. This is the number of
	 * coins, not their value.
	 * 
	 * @return the number of coins in the purse
	 */
	public int count() {
		return money.size();
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return the total value of items in the purse.
	 */
	public double getBalance() {
		double balance = 0;
		for (int i = 0; i < money.size(); i++) {
			balance += money.get(i).getValue();
		}
		return balance;
	}

	/**
	 * Return the capacity of the coin purse.
	 * 
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * Test whether the purse is full. The purse is full if number of items in
	 * purse equals or greater than the purse capacity.
	 * 
	 * @return true if purse is full.
	 */
	public boolean isFull() {
		if (money.size() >= this.capacity) {
			return true;
		}
		return false;
	}

	/**
	 * Insert a coin into the purse. The coin is only inserted if the purse has
	 * space for it and the coin has positive value. No worthless coins!
	 * 
	 * @param coin
	 *            is a Coin object to insert into purse
	 * @return true if coin inserted, false if can't insert
	 */
	public boolean insert(Coin coin) {
		// if the purse is already full then can't insert anything.
		if (isFull() == true || coin.getValue() <= 0) {
			return false;
		} else {
			money.add(coin);
			Collections.sort(money);
		}
		return true;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Coins
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of Coin objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Coin[] withdraw(double amount) {
		if (amount < 0) {
			return null;
		}

		List<Coin> keepMoney = new ArrayList<Coin>();

		if (amount > 0) {
			for (int i = money.size() - 1; i >= 0; i--) {
				Coin coin = money.get(i);
				if (coin.getValue() <= amount) {
					keepMoney.add(coin);
					amount = amount - coin.getValue();
				}

				if (amount == 0) {
					for (Coin remove : keepMoney) {
						this.money.remove(remove);
					}
					Coin[] withdraw = new Coin[keepMoney.size()];
					keepMoney.toArray(withdraw);
					return withdraw;
				}
			}
		}
		return null;
	}

	/**
	 * Return string describing what is in the purse.
	 * 
	 * @return a string representation of the number of coins in the purse and
	 *         the total value of all money in the purse
	 */
	public String toString() {
		return count() + " coins with value " + getBalance();
	}

}