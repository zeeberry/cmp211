package project5;
import lists.*;
/**
 * <p>Title: Bank Class</p>
 * 
 * <p>Description:It capable of creating a
 * Bank class. By default the size of the 
 * ArrayOrderedList is 10. It contains
 * addAccount(),withdrawal(), deposit()
 * and balanceInquiry()methods.  </p>
 * 
 * @author Zainab Ebrahimi
 *
 */
public class Bank {
	
	private ArrayOrderedList<Account> bankList;
	
	/**
	 * Bank default constructor--
	 * initialized the instance variable 
	 * theAccount to size 10.
	 */
	public Bank(){
		
		bankList = new ArrayOrderedList<Account>(10);
	}
	/**
	 * addAccount method--
	 * Adds an Account to BankList.
	 * @param anAccount
	 */
	public void addAccount(Account anAccount){
		
		bankList.add(anAccount);
	}
	/**
	 * deposit method--
	 * looks for the Account in the list,
	 * and calls the deposit method.
	 * @param anAccount initialized Account object.
	 * @param amount
	 */
	public void deposit(Account anAccount, double amount){
		//what if it doesn't find it? noooooooooooooo!! ElementNotFoundException!!!
		Account theAccount= bankList.recursiveBinSearch(anAccount);
		theAccount.deposit(amount);
	}
	/**
	 * withdrawal method--
	 * looks for the Account in the list,
	 * and calls the withdraw method.
	 * @param anAccount initialized Account object.
	 * @param amount
	 * @return
	 */
	public double withdrawal(Account anAccount, double amount){
		
		return bankList.recursiveBinSearch(anAccount).withdrawal(amount);
	}
	/**
	 * balanceInquiry method--
	 * looks for the Account in the list,
	 * and gets access to the balance of
	 * the account.
	 * @param anAccount initialized Account object.
	 * @return double containing the current balance
	 * of the account.
	 */
	public double balanceInquiry(Account anAccount){
		
		return bankList.recursiveBinSearch(anAccount).getBalance();
	}
	/**
	 * displayAccounts method--
	 * displays the state of bankList.
	 * @return a String containing the
	 * state of bankList.
	 */
	public String displayAccounts(){
		
		return bankList.toString();
	}

}