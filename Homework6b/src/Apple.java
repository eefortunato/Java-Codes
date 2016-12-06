/**
 * Apple.java
 * This is the subclass Apple where all the basic members and 
 * methods for Apple are defined
 * 
 *  @version   $Id: Comodity.java,v 1.0 2013/10/08 10:00pm $
 * 
 * @author Pavan Kumar Pallerla
 * @author Eric Fortunato
 * 
 *
 */

public class Apple extends Comodity{

	int amountForDiscount = 2;
	private final double weight = 3;
	
	private double quantityRemaining = 250;
	private double quantityPurchased;
	
	/**
	 * Overloaded constructor to create an apple initializing it with the price
	 * @param price receives a double for the price
	 */
	Apple(double price) {
		super();
		setPrice(price);
	}
	
	/**
	 * This method sets the price for the apple
	 * @param price it receives a double as a parameter for the price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * This method returns true if the amount of apple purchased is enough for the discount
	 *  @return true if it is eligible
	 */ 
	public boolean isEligibleForDiscount(){
         if(this.quantityPurchased > amountForDiscount){
                 return true;
         }
         return false;
	 }
	
	/**
	 * This method gets the weight of the apple
	 * @return weight the weight of the current apple
	 */
	 public double getWeight(){
         return this.weight;
	 }
	 
	 /**
	  * This method  returns true if there are enough apples to buy	
	  * @param quantity receives a double for the quantity to purchase
	  * @return true if there are enough
	  */	
	 public boolean isQuantitySufficient(double quantity) {
			return quantityRemaining >= quantity;
		}
		
	 /**
	  * This method sets the quantity of apples the customer will buy and decreases the total	
	  * @param quantity receives a double as quantity
	  */
	 public void setQuantity(double quantity) {
			this.quantityPurchased = quantity;
			quantityRemaining -= quantity;
		}
		
	 /**
	  * This method returns the quantity of apples purchased by the customer
	  * @return quantityPurchased the quantity of apples purchased for the current apple
	  */	
	 public double getQuantityPurchased() {
			return this.quantityPurchased;
		}
		
	 /**
	  * This method returns the remaining apples
	  * @return quantityRamaining the remaining number of the current apple
	  */	
	 public double getRemainingItems() {
			return this.quantityRemaining;
		}
	
}
