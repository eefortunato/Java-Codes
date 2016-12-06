/**
 * Avocado.java
 * This is the subclass Avocado where all the basic members and 
 * methods for Avocado are defined
 * 
 *  @version   $Id: Comodity.java,v 1.0 2013/10/08 10:00pm $
 * 
 * @author Pavan Kumar Pallerla
 * @author Eric Fortunato
 * 
 *
 */
public class Avocado extends Comodity{

	int amountForDiscount = 4;
	private final double weight = 0.5;
	private double quantityRemaining = 200;
	private double quantityPurchased;
	
	/**
	 * Overloaded constructor to create an avocado initializing it with the price
	 * @param price receives a double for the price
	 */
	Avocado (double price) {
		super();
		setPrice(price);
	}
	
	/**
	 * This method sets the price for the avocado
	 * @param price it receives a double as a parameter for the price
	 */
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * This method returns true if the amount of avocado purchased is enough for the discount
	 *  @return true if it is eligible
	 */ 
	public boolean isEligibleForDiscount(){
        if(this.quantityPurchased > amountForDiscount){
                return true;
        }
        return false;
	 }
	
	/**
	 * This method gets the weight of the avocado
	 * @return weight the weight of the current avocado
	 */
	public double getWeight(){
        return this.weight;
	 }
	
	/**
	  * This method  returns true if there are enough avocados to buy	
	  * @param quantity receives a double for the quantity to purchase
	  * @return true if there are enough
	  */
	public boolean isQuantitySufficient(double quantity) {
		return quantityRemaining >= quantity;
	}
	
	/**
	  * This method sets the quantity of avocado the customer ill buy and decreases the total	
	  * @param quantity receives a double as quantity
	  */
	public void setQuantity(double quantity) {
		this.quantityPurchased = quantity;
		quantityRemaining -= quantity;
	}
	
	/**
	  * This method returns the quantity of avocados purchased by the customer
	  * @return quantityPurchased the quantity of apples purchased for the current avocado
	  */
	public double getQuantityPurchased() {
		return this.quantityPurchased;
	}
	
	/**
	  * This method returns the remaining avocados
	  * @return quantityRamaining the remaining number of the current avocado
	  */	
	public double getRemainingItems() {
		return this.quantityRemaining;
	}
}
