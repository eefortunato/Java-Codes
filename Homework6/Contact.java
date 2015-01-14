/*
 * Contact.java
 * 
 * Description: Contacts for Address Book
 *  
 *  version:
 *  		$1.0$
 *  
 *  @author: Eric Fortunato
 *  @author: Sreeraj Paleri
 */

import java.io.Serializable;

public class Contact implements Serializable{
	
	private String fname;
	private String lname;
	private String phone;
	private String address;
	private String email;
	private int zipCode; 
	
	//constructor
	public Contact() {
		fname = "";
		lname = "";
		phone = "";
		address = "";
		email = "";
		zipCode = 0;
	}
	
	/*
	 * setFirstName()
	 * 
	 * Description: set first name of the contact
	 * 
	 * @param: str;
	 * @return: void
	 */
	public void setFirstName(String str) {
		fname = str;
	}
	
	/*
	 * setLastName()
	 * 
	 * Description: set last name of the contact
	 * 
	 * @param: str;
	 * @return: void
	 */
	public void setLastName(String str) {
		lname = str;
	}
	
	/*
	 * setPhoneNumber()
	 * 
	 * Description: set phone number of the contact
	 * 
	 * @param: str;
	 * @return: void
	 */
	public void setPhoneNumber(String str) {
		phone = str;
	}
	
	/*
	 * setAddress()
	 * 
	 * Description: set address of the contact
	 * 
	 * @param: str;
	 * @return: void
	 */
	public void setAddress(String addr) {
		address = addr;
	}
	
	/*
	 * setEmail()
	 * 
	 * Description: set email of the contact
	 * 
	 * @param: mailId;
	 * @return: void
	 */
	public void setEmail(String mailId) {
		email = mailId;
	}
	
	/*
	 * setZipCode()
	 * 
	 * Description: set zip code of the contact
	 * 
	 * @param: zcode;
	 * @return: void
	 */
	public void setZipCode(int zcode) {
		zipCode = zcode;
	}
	
	/*
	 * getFirstName()
	 * 
	 * Description: returns first name of the contact
	 * 
	 * @param: none;
	 * @return: fname
	 */
	public String getFirstName() {
		return this.fname;
	}
	
	/*
	 * getLastName()
	 * 
	 * Description: returns last name of the contact
	 * 
	 * @param: none;
	 * @return: lname
	 */
	public String getLastName() {
		return this.lname;
	}
	
	/*
	 * getPhoneNumber()
	 * 
	 * Description: returns phone number of the contact
	 * 
	 * @param: none;
	 * @return: phone
	 */
	public String getPhoneNumber() {
		return this.phone;
	}
	
	/*
	 * getAddress()
	 * 
	 * Description: returns address of the contact
	 * 
	 * @param: none;
	 * @return: address
	 */
	public String getAddress() {
		return this.address;
	}
	
	/*
	 * getEmail()
	 * 
	 * Description: returns email of the contact
	 * 
	 * @param: none;
	 * @return: email
	 */
	public String getEmail() {
		return this.email;
	}
	
	/*
	 * getZipCode()
	 * 
	 * Description: returns zip code of the contact
	 * 
	 * @param: none;
	 * @return: zipCode
	 */
	public int getZipCode() {
		return this.zipCode;
	}
	
	/*
	 * printContact()
	 * 
	 * Description: prints details of the contact
	 * 
	 * @param: none;
	 * @return: void
	 */
	public void printContact() {
		
		System.out.println(this.getLastName() + ", " + this.getFirstName());
		System.out.println(this.getPhoneNumber());
		System.out.println(this.getAddress());
		System.out.println(this.getEmail());
		System.out.println(this.getZipCode());
	}
	
}
