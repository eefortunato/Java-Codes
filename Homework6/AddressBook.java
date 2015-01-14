/*
 * AddressBook.java
 * 
 * Description: Using collections framework implement an interactive text-based address book
 *  			application.
 *  
 *  version:
 *  		$1.0$
 *  
 *  @author: Eric Fortunato
 *  @author: Sreeraj Paleri
 *  
 *  References: 
 *  
 *  	->http://www.tutorialspoint.com/java/java_serialization.htm
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.io.Serializable;


public class AddressBook implements Comparator<Contact>, Serializable {
	
	private ArrayList<Contact> addressBook = new ArrayList<Contact>();
	private int count;
	private boolean lastNameFlag;
	
	transient Scanner input = new Scanner(System.in);	//make Scanner serializable
	
	//constructor
	public AddressBook() {
		count = 0;
		lastNameFlag=true;
	}
	
	/*
	 * addContact()
	 * 
	 * Description: create new contact
	 * 
	 * @param: none
	 * #return: void
	 */
	public void addContact() {
		
		addressBook.add( new Contact());
		readData(addressBook.get(count));
		count++;
	}
	
	/*
	 * readData()
	 * 
	 * Description: read data into contact
	 * 
	 * @param: contact
	 * #return: void
	 */
	public void readData(Contact contact) {
		
		System.out.print("\nFirst Name: ");
		String str1 = input.nextLine();
		contact.setFirstName(str1);
		
		System.out.print("Last Name: ");
		String str2 = input.nextLine();
		contact.setLastName(str2);
		
		System.out.print("Phone No.: ");
		String str3 = input.nextLine();
		contact.setPhoneNumber(str3);
		
		System.out.print("Address: ");
		String str4 = input.nextLine();
		contact.setAddress(str4);
		
		System.out.print("e-mail: ");
		String str5 = input.nextLine();
		contact.setEmail(str5);
		
		System.out.print("Zip Code: ");
		int number = input.nextInt();
		input.nextLine();
		contact.setZipCode(number);
	}
	
	public void updateContact(int index, String firstName){
		int option=0, newZipCode=0;
		String newValue;
		System.out.println("1. Update First Name");
		System.out.println("2. Update Last Name");
		System.out.println("3. Update Phone No.");
		System.out.println("4. Update Address");
		System.out.println("5. Update Email");
		System.out.println("6. Update ZipCode");
		
		System.out.print("Enter [1 - 7]: ");
		option=input.nextInt();
		input.nextLine();
		switch(option){
			case 1: System.out.print("First Name: ");
					newValue=input.nextLine();
					this.addressBook.get(index).setFirstName(newValue);
					break;
			case 2:	System.out.print("Last Name: ");
					newValue=input.nextLine();
					this.addressBook.get(index).setLastName(newValue);
					break;
			case 3:	System.out.print("Phone No.: ");
					newValue=input.nextLine();
					this.addressBook.get(index).setPhoneNumber(newValue);
					break;
			case 4:	System.out.print("Address: ");
					newValue=input.nextLine();
					this.addressBook.get(index).setAddress(newValue);
					break;
			case 5:	System.out.print("Email: ");
					newValue=input.nextLine();
					this.addressBook.get(index).setEmail(newValue);
					break;
			case 6:	System.out.print("Zip Code: ");
					newZipCode=input.nextInt();
					this.addressBook.get(index).setZipCode(newZipCode);
					break;
		}
		
	}
	
	/*
	 * numberOfContacts()
	 * 
	 * Description: returns total number of contacts in AddressBook
	 * 
	 * @param: none
	 * @return: addressBook.size()
	 */
	public int numberOfContacts() {
		
		return addressBook.size();
	}
	
/*
 * printOne()
 * 
 * Description: print contacts by last name
 * 
 *  @param: lastname
 *  @return: void
 */
	public void printOne(String lastname) {
		
		for(Contact c : addressBook) {
			if( c.getLastName().equals(lastname) ) {
				c.printContact();
				return;
			}
		}
		System.out.println("\nContact not found !");	
	}
	
	/*
	 * remove()
	 * 
	 * Description: remove contacts by last name
	 * 
	 *  @param: lastname
	 *  @return: void
	 */
	public void remove(String lastname) {
		
		for(int index = 0; index < addressBook.size(); index++) {
			
			String last = addressBook.get(index).getLastName();
			if( last.equals(lastname) ) {
				addressBook.remove(index);
				return;
			}
		}
	}
	
	/*
	 * printByZip()
	 * 
	 * Description: prints contacts by zip code
	 * 
	 *  @param: none
	 *  @return: void
	 */
	public void printByZip(){
		Collections.sort(this.addressBook, new AddressBook());
		for(Contact c : this.addressBook) {
		      c.printContact();
		      System.out.println();
		    }
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(Contact c1, Contact c2) {
	         
		if(this.lastNameFlag== false){
			if(c1.getZipCode() > c2.getZipCode()){
	        	 return 1;
	         }
	        else if(c1.getZipCode() == c2.getZipCode()){
	        	 return 0;
	         }
	        return -1;
		}		
		int comparison = c1.getLastName().compareToIgnoreCase(c2.getLastName());
	    return (comparison != 0) ? comparison : c1.getFirstName().compareToIgnoreCase(c2.getFirstName());
		
	         
	      }
	
	/*
	 * printByName()
	 * 
	 * Description: prints contacts by name
	 * 
	 *  @param: none
	 *  @return: void
	 */
	public void printByName(){
		Collections.sort(this.addressBook, new AddressBook());
		for(Contact c : this.addressBook) {
		      c.printContact();
		      System.out.println();
		    }
		
	}
	
	/*
	 * getLastNameFlag()
	 * 
	 * Description: returns last name flag 
	 * 
	 *  @param: none
	 *  @return: lastnameFlag
	 */
	public boolean getLastNameFlag(){
		return this.lastNameFlag;
	}
	
	/*
	 * setLastNameFlag()
	 * 
	 * Description: set last name flag 
	 * 
	 *  @param: value
	 *  @return: void
	 */
	public void setLastNameFlag(boolean value){
		this.lastNameFlag=value;
	}
	
	public ArrayList<Contact> getAddressBook(){
		return addressBook;
	}

}
