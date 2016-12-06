/**
 * Comodity.java
 * This is the abstract superclass Comodity where all the basic members and 
 * methods for subclasses are implemented except setPrice which is implemented by each subclass
 * 
 *  @version   $Id: Comodity.java,v 1.0 2013/10/08 10:00pm $
 * 
 * @author Pavan Kumar Pallerla
 * @author Eric Fortunato
 * 
 *
 */

public abstract class Comodity {
	public double price;
	public String colour;
	public double quantityRemaining;
	public double quantityPurchased;
	public int bags = 500;
	
	/**
	 * Accessor for price in comodity
	 * @return price it returns the price of the comodity
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * This method sets the colour of the comodity
	 * @param colour it receives the colour as an string
	 */
	public void setColour(String colour) {
		this.colour = colour;
	}
	
	/**
	 * This method returns the colour of the comodity
	 * @return colour the colour of the current object
	 */
	public String getColour() {
		return this.colour;
	}

	/**
	 * This method returns if the comodity is eligible for a discount
	 * @return true if it is eligible
	 */
	public boolean isEligibleForDiscount() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * This is the abstract method declaration that sets the price for each comodity,
	 * it is impleemented by each subclass.
	 * @param price it receives a double as the price to set
	 */
	abstract public void setPrice(double price);
 
}
