
public class Melon extends Comodity{

	int amountForDiscount = 3;
	private final double weight = 1.0;
	private double quantityRemaining = 250;
	private double quantityPurchased;
	
	Melon(double price) {
		super();
		setPrice(price);
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public boolean isEligibleForDiscount(){
        if(this.quantityPurchased > amountForDiscount){
                return true;
        }
        return false;
	 }
	
	public double getWeight(){
        return this.weight;
	 }
	
	public boolean isQuantitySufficient(double quantity) {
		return quantityRemaining >= quantity;
	}
	
	public void setQuantity(double quantity) {
		this.quantityPurchased = quantity;
		quantityRemaining -= quantity;
	}
	
	public double getQuantityPurchased() {
		return this.quantityPurchased;
	}
	public double getRemainingItems() {
		return this.quantityRemaining;
	}
}
