package project5;

import lists.ArrayOrderedList;

/**
 * <p>Title: Account Class</p>
 * <p>Description: Its able to create an
 * Account object. This class is a parent class.
 * It contains three instance variables:
 * aCustomer, balance and accountNumber.
 * It also contains accesors, mutators and methods
 * such as updateBalance, compareTo, equals and
 * toString.</p>
 * @author Zainab Ebrahimi
 *
 */
public abstract class Account implements Comparable {
	
	private Customer aCustomer;
	private double balance;
	private int accountNumber;
	
	/**
	 * Account default constructor--
	 * Initializes instance variables.
	 */
	public Account()
	{
		aCustomer = new Customer();
		balance = 0.0;
		accountNumber = 0;
	}
	/**
	 * Account parameterized constructor--
	 * Initializes instance variables based on 
	 * information passed to the constructor.
	 * @param balance
	 * @param account
	 */
	public Account(double b, int account, Customer c)
	{
		aCustomer =c;
		balance = b;
		accountNumber = account;
	}
	/**
	 * getCustomer --
	 * gets access to aCustomer instance variable. 
	 * @return Customer object.
	 */
	public Customer getCustomer()
	{
		return aCustomer;
	}
	/**
	 * getBalance--
	 * gets access to balance.
	 * @return
	 */
	public double getBalance()
	{
		return balance;
	}
	/**
	 * getAccoutnNumber--
	 * gets access to accountNumber.
	 * @return
	 */
	public int getAccountNumber()
	{
		return accountNumber;
	}
	/**
	 * setCustomer--
	 * assigns c to aCustomer instance variable.
	 * @param c Customer object.
	 */
	public void setCustomer(Customer c)
	{
		aCustomer = c;
	}
	/**
	 * setBalance--
	 * assigns b to balance.
	 * @param b double containing balance amount 
	 * to be assigned to balance.
	 */
	public void setBalance(double b)
	{
		balance = b;
	}
	/**
	 * setAccountNumber--
	 * assigns a to accountNumber.
	 * @param a int containing account number 
	 * to be assigned to accountNumber.
	 */
	public void setAccountNumber(int a)
	{
		accountNumber = a;
	}
	/**
	 * updateBalance method--
	 * the method accepts a positive number if a 
	 * deposit is being processed and a negative
	 * number if a withdrawal is being processed.
	 * @param update int containing a positive 
	 * number if a deposit is being processed and 
	 * a negative number if a withdrawal is being 
	 * processed.
	 */
	public void updateBalance(int update)
	{
		balance += update;
	}
	/**
	 * equals method--
	 * determines whether or not this Account
	 * object is equal to the Account object
	 * passed to the method based on the 
	 * accountNumber.
	 * @param anAccount Account object to be
	 * compared.
	 * @return boolean true if objects are equal,
	 * otherwise false.
	 */
	public boolean equals(Object anAccount)
	{
		if(this.accountNumber == ((Account)anAccount).getAccountNumber())
			return true;
		else
			return false;
	}
	/**
	 * compareTo method--
	 * compares two Account objects 
	 * based on their account number.
	 * @param anAccount Account object
	 * to be compared.
	 * @return int
	 */
	public int compareTo(Object anAccount)
	{
		return this.accountNumber - ((Account)anAccount).getAccountNumber();
	}
	/**
	 * withdrawal abstract method--
	 * will be implemented in all subclasses.
	 * @param Wamount double amount to withdrawal. 
	 * @return returns true if withdrawal was successful.
	 */
	public abstract double withdrawal(double Wamount);
	/**
	 * deposit abstract method--
	 * will be implemented in all subclasses.
	 * @param Damount double amount to deposit
	 */
	public abstract void deposit(double Damount);
	
	/**
	 * toString method--
	 * Displays state of Account object.
	 */
	public String toString()
	{
		return "Customer: "+ aCustomer +"\nBalance: "+balance+
				"\nAccount Number: "+accountNumber;
	}

}