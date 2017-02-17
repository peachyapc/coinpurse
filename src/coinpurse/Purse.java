package coinpurse;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
/**
 * A coin purse contains coins. You can insert coins, withdraw money, check the
 * balance, and check if the purse is full. When you withdraw money, the coin
 * purse decides which coins to remove.
 * 
 * @author Apichaya Tiwcharoensakul
 */
public class Purse {
	/** Collection of objects in the purse. */
	private List<Valuable> money = new ArrayList<Valuable>();
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
	 * @param value
	 *            is a Valuable object to insert into purse
	 * @return true if coin inserted, false if can't insert
	 */
	public boolean insert(Valuable value) {
		// if the purse is already full then can't insert anything.
		if (isFull() == true || value.getValue() <= 0) {
			return false;
		} else {
			money.add(value);
			Collections.sort(money, new Comparator<Valuable>() {

				@Override
				public int compare(Valuable o1, Valuable o2) {
					return o1.getCurrency().compareTo(o2.getCurrency());
				}			
			});
			Collections.reverse(money);
		}
		return true;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Valuable
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of Valuable objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Valuable[] withdraw(double amount) {
		if (amount < 0) {
			return null;
		}

		List<Valuable> keepMoney = new ArrayList<Valuable>();

		if (amount > 0) {
			for (int i = money.size() - 1; i >= 0; i--) {
				Valuable value = money.get(i);
				if (value.getValue() <= amount) {
					keepMoney.add(value);
					amount = amount - value.getValue();
				}

				if (amount == 0) {
					for (Valuable remove : keepMoney) {
						this.money.remove(remove);
					}
					Valuable[] withdraw = new Valuable[keepMoney.size()];
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
	
	public static void main(String[] args) {
		 Purse purse = new Purse(3);
		  System.out.println(purse.getBalance());
		  System.out.println(purse.count());
		  System.out.println(purse.isFull());
		  System.out.println(purse.insert(new Coin(5)));
		  System.out.println(purse.insert(new Coin(10)));
		  System.out.println(purse.insert(new Coin(0)));
		  System.out.println(purse.insert(new Coin(1)));
		  System.out.println(purse.insert(new Coin(5)));
		  System.out.println(purse.count());
		  System.out.println(purse.isFull());
		  System.out.println(purse.getBalance());
		  System.out.println(purse.toString());
		  System.out.println(purse.withdraw(12));
		  System.out.println(Arrays.toString(purse.withdraw(11)));
	}

}