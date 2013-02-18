package project5;
/**
 * <p>Title: CheckingsAccount Class</p>
 * 
 * <p>Description: Is able to create a CheckingAccount Object.
 * This class is a subclass of Account. I contains withdrawal 
 * and deposit method.</p>
 * 
 * @author Zainab Ebrahimi
 *
 */
public class CheckingAccount extends Account{
	
	double overdraft;
	final double MAX = 1000;
	
	/**
	 * CheckingAccount default constructor--
	 * Calls the default constructor in the
	 * parent class and initializes instance
	 * variable overdraft.
	 */
	public CheckingAccount()
	{
		super();
		overdraft = 0;
	}
	/**
	 * CheckingAccount parameterized constructor--
	 * Calls the parameterized constructor in the 
	 * parent class and initializes overdraft.
	 * @param balance double containing the balance 
	 * amount that will be passed to the parent 
	 * parameterized constructor.
	 * @param accountN int containing the account
	 * number to be passed to the parent parameterized
	 * construtor.
	 */
	public CheckingAccount(double balance, int accountN, Customer c)
	{
		super(balance, accountN, c);
		overdraft = 0;
	}
	/**
	 * withdrawal method--
	 * gets access to balance and deducts amount
	 * to withdraw. If balance is zero the 
	 * overdraft will increase. If overdraft 
	 * is equal to maximum overdraft limit
	 * withdrawal is not permitted. 
	 * @param accepts a double containing the
	 * amount to withdraw
	 */
	public double withdrawal(double Wamount)
	{
		double theBalance = this.getBalance();
		if(overdraft ==MAX){
			return 0;
		}else{
			if(theBalance==0){
				overdraft+= Wamount; 
			
			}else if(theBalance<Wamount){
				this.setBalance(0);
				overdraft+= Wamount-theBalance;
			}
			else{
				this.setBalance(theBalance-Wamount);
			}
				return Wamount;
		}
		
	}
	/**
	 * deposit method--
	 * accepts amount to be deposited and
	 * increments balance.
	 * @param Damount containing amount 
	 * to deposit.
	 */
	public void deposit(double Damount) {
		
		double newBalance = this.getBalance();
		this.setBalance(newBalance+Damount);
	
	}

	
}
