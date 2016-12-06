
public class Apple extends Comodity implements PriceOfComodity {

	int amountForDiscount = 2;
	private final double weight = 3;
	Apple(String colour) {
		this.setColour(colour);
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
	
}
