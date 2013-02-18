package project5;
import java.io.*;
import lists.*;
import java.util.*;
import javax.swing.*;
//import exceptionclasses.*;
/**
 * <p>Title: Application Class</p>
 * 
 * <p>Description: Displays a menu to 
 * create a new account, deposit, 
 * withdraw from an existing account, and
 * request an account inquiry.</p>
 * 
 * @author Zainab Ebrahimi
 *
 */
public class Proj5App {
	public static void main(String[] args)
	{
		Bank theBank = new Bank();
		int accountNum = 56789;
		
		try{
		Scanner sc = new Scanner(new File("bankdata.txt"));
		int i =0;
		while(i<5){
			String kind = sc.next();
			String first = sc.next();
			String last = sc.next();
			int theAge = Integer.parseInt(sc.next());
			String phone = sc.next();
			Customer customer = new Customer(first,last,theAge,phone);
			double balance = Double.parseDouble(sc.next());
			int accountN = Integer.parseInt(sc.next());
			
			if(kind.equals("c")){
		
			 CheckingAccount aChecking = new CheckingAccount(balance,accountN,customer);
			 theBank.addAccount(aChecking);
			}else{
				
			 SavingsAccount aSavings = new SavingsAccount(balance,accountN, customer);
			 theBank.addAccount(aSavings);
			}
			i++;
		}
		
		boolean keepIt = true;
		while(keepIt==true){
			String[] options = {"New Account","Deposit",
					"Withdrawal", "Balance Inquiry","Display Accounts","Exit"};
			
			int choice =JOptionPane.showOptionDialog(null,
					"What would you like to do today?.","Bank Menu",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					options, options[0]);
			
			if(choice == 0){
				
				String fname = JOptionPane.showInputDialog("Please enter your first name");
				
				if( stringVerification(fname)==false){
					JOptionPane.showMessageDialog(null,
							"Invalid Data.\n ",
							"ERROR", JOptionPane.INFORMATION_MESSAGE);
				}
				String lname = JOptionPane.showInputDialog("Please enter your last name");
				
				if( stringVerification(lname)==false){
					JOptionPane.showMessageDialog(null,
							"Invalid Data.\n ",
							"ERROR", JOptionPane.INFORMATION_MESSAGE);
				}
				String anAge =
						JOptionPane.showInputDialog("Please enter your age");
				
				if( numVerification(anAge)==false){
					JOptionPane.showMessageDialog(null,
							"Invalid Data.\n ",
							"ERROR", JOptionPane.INFORMATION_MESSAGE);
				}
				int age = Integer.parseInt(anAge);
				
				String phoneN =
					JOptionPane.showInputDialog("Please enter your phone number");
				
				if( numVerification(phoneN)==false){
				JOptionPane.showMessageDialog(null,
						"Invalid Data.\n ",
						"ERROR", JOptionPane.INFORMATION_MESSAGE);
				}
				
				Customer theCustomer = new Customer(fname,lname,age,phoneN);
				
				String[] accountOptions = {"Checking","Savings"};
				
				int accountChoice =JOptionPane.showOptionDialog(null,
						"Which type of account would you like to create?.",
						"New Account Menu",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,
						accountOptions, accountOptions[0]);
				
				if(accountChoice == 0){
					
					String dAmount = JOptionPane.showInputDialog(
					"Please enter deposit amount");
					
					if( numVerification(dAmount)==false){
						JOptionPane.showMessageDialog(null,
								"Invalid Data.\n ",
								"ERROR", JOptionPane.INFORMATION_MESSAGE);
						}
					double theAmount = Double.parseDouble(dAmount);
					
					CheckingAccount newChecking = new CheckingAccount(
							theAmount, accountNum, theCustomer);
					
					theBank.addAccount(newChecking);
					
					JOptionPane.showMessageDialog(null, "YOUR ACCOUNT HAS BEEN " +
							" CREATED SUCCESFULLY\n"+newChecking.toString());
					
				}else{
					String[] depositOptions = {"Yes","No"};
					
					int depositChoice =JOptionPane.showOptionDialog(null,
							"Would you like to make an initial deposit?.",
							"New Account Menu",
							JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							null,
							depositOptions, depositOptions[0]);
					
					if(depositChoice == 0)
					{
						String depositAmount =JOptionPane.showInputDialog(
								"Please enter deposit amount");
						
						if( numVerification(depositAmount)==false){
							JOptionPane.showMessageDialog(null,
									"Invalid Data.\n ",
									"ERROR", JOptionPane.INFORMATION_MESSAGE);
							}
						
						double theDeposit = Double.parseDouble(depositAmount);
						
						SavingsAccount newSavings=new SavingsAccount(
														theDeposit, accountNum, theCustomer);
						
						theBank.addAccount(newSavings);
						JOptionPane.showMessageDialog(null, "YOUR ACCOUNT HAS BEEN " +
								" CREATED SUCCESFULLY \n"+newSavings.toString());
						
					}else{
						SavingsAccount newSavings=new SavingsAccount(
								0, accountNum, theCustomer);
						theBank.addAccount(newSavings);
						JOptionPane.showMessageDialog(null, "YOUR ACCOUNT HAS BEEN " +
								" CREATED SUCCESFULLY.\n"+newSavings.toString());
					}
				}
			
			}else if(choice == 1){//deposit
				
				String accountn = JOptionPane.showInputDialog(
				"Please enter your Account Number");
				
				if( numVerification(accountn)==false){
					JOptionPane.showMessageDialog(null,
							"Invalid Data.\n ",
							"ERROR", JOptionPane.INFORMATION_MESSAGE);
					}
				int theaccountN = Integer.parseInt(accountn);
				
				String depositing = JOptionPane.showInputDialog(
				"Please enter deposit amount");
				
				if( numVerification(depositing)==false){
					JOptionPane.showMessageDialog(null,
							"Invalid Data.\n ",
							"ERROR", JOptionPane.INFORMATION_MESSAGE);
					}
				double thedeposit = Double.parseDouble(depositing);
				
				//theBank.deposit();//handle exception!!!!
				
			}else if(choice == 2){//withdrawal
				String accountn = JOptionPane.showInputDialog(
				"Please enter your Account Number");
				
				if( numVerification(accountn)==false){
					JOptionPane.showMessageDialog(null,
							"Invalid Data.\n ",
							"ERROR", JOptionPane.INFORMATION_MESSAGE);
					}
				
				//theBank.withdrawal(anAccount, amount);
				
			}else if(choice == 3){
				String accountn = JOptionPane.showInputDialog(
				"Please enter your Account Number");
				
				if( numVerification(accountn)==false){
					JOptionPane.showMessageDialog(null,
							"Invalid Data.\n ",
							"ERROR", JOptionPane.INFORMATION_MESSAGE);
					}
				//theBank.balanceInquiry();
			}else if(choice ==4){
				
				JOptionPane.showMessageDialog(null,theBank.displayAccounts());
			}else
				keepIt = false;
		}
		}catch(FileNotFoundException ex){
			System.out.println(ex.getMessage());
		}
		
		
	}
	public static boolean stringVerification(String s){
		String str = s.toLowerCase();
		boolean valid= false;
		boolean looping = true;
		int i = 0;
		while( i<s.length()&& looping ==true)
		{
			char c = str.charAt(i);
			if(c <=122 && c>=65){
				valid = true;
			}else{
				valid =false;
				looping =false;
			}
			i++;	
		}
		return valid;
			
	}
	public static boolean numVerification(String n){

		String str = n.toLowerCase();
		boolean valid= false;
		boolean looping = true;
		int i = 0;
		while( i<n.length()&& looping ==true)
		{
			char c = str.charAt(i);
			if(c <=57 && c>=48){
				valid = true;
			}else{
				valid =false;
				looping =false;
			}
			i++;	
		}
		return valid;
	}
	/**
	 * 
	 */
	public static void accountNumGenerator()
	{
		ArrayOrderedList<Integer> accountNums = new ArrayOrderedList<Integer>();
		
	}
}