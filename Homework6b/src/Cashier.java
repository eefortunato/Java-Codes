
public class Cashier {

	final double discount = 0.85;
	private double moneyInCounter = 0;
	private double bill = 0;
	Cashier() {
		
	}
	public void payMoney(double money) {
		moneyInCounter += money;
	}
	public double getMoneyInCounter () {
		return moneyInCounter;
	}
	
	public double getDiscountedAmount(Apple apple) {
		double amount = apple.getPrice() * apple.getQuantityPurchased();
		if (apple.isEligibleForDiscount()) {
			return amount * discount;
		} else {
			return amount;
		}
	}
	public double getDiscountedAmount(Avocado avocado) {
		double amount = avocado.getPrice() * avocado.getQuantityPurchased();
		if (avocado.isEligibleForDiscount()) {
			return amount * discount;
		} else {
			return amount;
		}
	}
	public double getDiscountedAmount(Banana banana) {
		double amount = banana.getPrice() * banana.getQuantityPurchased();
		if (banana.isEligibleForDiscount()) {
			return amount * discount;
		} else {
			return amount;
		}
	}
	public double getDiscountedAmount(Cucumber cucumber) {
		double amount = cucumber.getPrice() * cucumber.getQuantityPurchased();
		if (cucumber.isEligibleForDiscount()) {
			return amount * discount;
		} else {
			return amount;
		}
	}
	public double getDiscountedAmount(Grape grape) {
		double amount = grape.getPrice() * grape.getQuantityPurchased();
		if (grape.isEligibleForDiscount()) {
			return amount * discount;
		} else {
			return amount;
		}
	}
	public double getDiscountedAmount(Kiwi kiwi) {
		double amount = kiwi.getPrice() * kiwi.getQuantityPurchased();
		if (kiwi.isEligibleForDiscount()) {
			return amount * discount;
		} else {
			return amount;
		}
	}
	public double getDiscountedAmount(Lemon lemon) {
		double amount = lemon.getPrice() * lemon.getQuantityPurchased();
		if (lemon.isEligibleForDiscount()) {
			return amount * discount;
		} else {
			return amount;
		}
	}
	public double getDiscountedAmount(Melon melon) {
		double amount = melon.getPrice() * melon.getQuantityPurchased();
		if (melon.isEligibleForDiscount()) {
			return amount * discount;
		} else {
			return amount;
		}
	}
	public double getDiscountedAmount(Orange orange) {
		double amount = orange.getPrice() * orange.getQuantityPurchased();
		if (orange.isEligibleForDiscount()) {
			return amount * discount;
		} else {
			return amount;
		}
	}
	public double getDiscountedAmount(PassionFruit pfruit) {
		double amount = pfruit.getPrice() * pfruit.getQuantityPurchased();
		if (pfruit.isEligibleForDiscount()) {
			return amount * discount;
		} else {
			return amount;
		}
	}
	public double getDiscountedAmount(Pepper pepper) {
		double amount = pepper.getPrice() * pepper.getQuantityPurchased();
		if (pepper.isEligibleForDiscount()) {
			return amount * discount;
		} else {
			return amount;
		}
	}
	public double getDiscountedAmount(Pineapple papple) {
		double amount = papple.getPrice() * papple.getQuantityPurchased();
		if (papple.isEligibleForDiscount()) {
			return amount * discount;
		} else {
			return amount;
		}
	}
	
	public double checkOutCustomer(double amount) {
		this.bill += amount;
		return this.bill;
	}
 	
}
