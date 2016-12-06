
public class Avocado extends Comodity implements PriceOfComodity{

	int amountForDiscount = 4;
	private final double weight = 0.5;
	
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
