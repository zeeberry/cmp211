package project5;

/**
 * <p>Title: Customer.java</p>
 *
 * <p>Description: Represents a bank customer.</p>
 *
 * @author Darci Burdge
 */
public class Customer {
	  private String firstName;
	  private String lastName;
	  private int age;
	  private String phoneNumber;

	  /**
	   * default Constructor - initializes this customer using default values
	   */
	  public Customer()
	  {
	    firstName = "";
	    lastName = "";
	    age = 16;
	    phoneNumber = "";
	  }

	  /**
	   * parameterized Constructor - initializes this customer by storing user
	   * specified values
	   * @param firstName a reference to this customer's first name
	   * @param lastName a reference to this customer's last name
	   * @param age the age of this customer
	   * @param phoneNumber a reference to this customer's phone number
	   */
	  public Customer(String firstName, String lastName, int age, String phoneNumber)
	  {
	    this.firstName = firstName;
	    this.lastName = lastName;
	    this.age = age;
	    this.phoneNumber = phoneNumber;
	  }

	  /**
	   * setName - stores user-specified values in firstName and lastName
	   * @param firstName a reference to this customer's first name
	   * @param lastName a reference to this customer's last name
	   */
	  public void setName(String firstName, String lastName)
	  {
	    this.firstName = firstName;
	    this.lastName = lastName;
	  }
	  
	  /**
	   * setAge - stores a user-specified value in age
	   * @param age the age of this customer
	   */
	  public void setAge(int age)
	  {
	    this.age = age;
	  }

	  /**
	   * setPhoneNumber - stores a user-specified value in phoneNumber
	   * @param phoneNumber a reference to this customer's phone number
	   */
	  public void setPhoneNumber(String phoneNumber)
	  {
	    this.phoneNumber = phoneNumber;
	  }

	  /**
	   * getFirst - returns this customer's first name
	   * @return a reference to firstName
	   */
	  public String getFirst()
	  {
	    return firstName;
	  }

	  /**
	   * getLast - returns this customer's last name
	   * @return a reference to lastName
	   */
	  public String getLast()
	  {
	    return lastName;
	  }

	  /**
	   * getAge - returns the age of this customer
	   * @return the customer's age
	   */
	  public int getAge()
	  {
	    return age;
	  }

	  /**
	   * getPhoneNumber - returns this customer's phone number
	   * @return a reference to phoneNumber
	   */
	  public String getPhoneNumber()
	  {
	    return phoneNumber;
	  }

	  /**
	   * toString - returns a string representing the state of this 
	   * customer
	   * @return a string containing this customer's last name, first name,
	   * age, and phone number
	   */
	  public String toString()
	  {
	    return lastName + ", " + firstName + "\n" +
	           "Age: " + age + "\n" +
	           "Phone Number: " + phoneNumber;
	  }
	}

