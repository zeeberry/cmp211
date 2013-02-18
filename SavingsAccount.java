package project5;
/**
 * <p>Title: SavingsAccount Class</p>
 * 
 * <p>Description: It able to create a SavingsAccount
 * object. It's a subclass of Account. It contains
 * a withdrawal and deposit method. </p>
 * 
 * @author Zainab Ebrahimi
 *
 */
public class SavingsAccount extends Account {

	/**
	 * SavingAccount default constructor--
	 * calls the default constructor in
	 * the parent class by using super().
	 */
	public SavingsAccount()
	{
		super();
	}
	/**
	 * SavingsAccount parameterized constructor--
	 * initializes instance variables in the parent class
	 * by calling super();
	 * @param balance containing balance amount to initialize 
	 * the account.
	 * @param accountN containing the account number.
	 */
	public SavingsAccount(double balance, int accountN, Customer c)
	{
		super(balance, accountN, c);
	}
	/**
	 * withdrawal method--
	 * accepts the amount to withdraw and
	 * decreases the balance amount. If the
	 * balance is equal to zero withdraw will
	 * not be able to process.
	 */
	public double withdrawal(double Wamount){
		
		double theBalance = this.getBalance();
		if(theBalance == 0){
			return 0;
			
		}else{
			if(theBalance < Wamount){
				this.setBalance(0);
				
			}else{
				this.setBalance(theBalance - Wamount);
				
			}
			return theBalance -(theBalance - Wamount);
		}
	}
	/**
	 * deposit method--
	 * accepts the amount to deposit and
	 * increases the balance.
	 * @param containing the amount to
	 * deposit.
	 */
	public void deposit(double Damount){
		
		this.setBalance(this.getBalance()+Damount);
	}
}
