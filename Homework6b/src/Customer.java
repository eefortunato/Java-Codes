import java.util.Scanner;


public class Customer {

	public static void main(String[] args) {
		double bill = 0;
		Scanner sc = new Scanner(System.in);
		Apple apple = new Apple(0.49);
		Avocado avocado = new Avocado(1.2);
		Banana banana = new Banana(1.2);
		Cucumber cucumber = new Cucumber(0.79);
		Grape grape = new Grape(0.12);
		Kiwi kiwi = new Kiwi(2.1);
		Lemon lemon = new Lemon(0.33);
		Melon melon = new Melon(2.3);
		Orange orange = new Orange(0.55);
		Pepper pepper = new Pepper(0.23);
		Pineapple pineapple = new Pineapple(2.2);
		PassionFruit pfruit = new PassionFruit(1.2);
		
		//Instantiating the 10 cash counters
		Cashier c[] = new Cashier[10];
		for (int i = 0; i<10; i++) {
			c[i] = new Cashier();
		}
		long counterNumber = System.currentTimeMillis() % 10;
		
		
		
		boolean picked = false;
		
		do {
			System.out.println("Pick a number adjacent to any item : ");
			System.out.println("1. Banana");
			System.out.println("2. Melon");
			System.out.println("3. Grapes");
			System.out.println("4. Apples");
			System.out.println("5. Oranges");
			System.out.println("6. Lemons");
			System.out.println("7. Kiwis");
			System.out.println("8. Pepper");
			System.out.println("9. Cucumber");
			System.out.println("10. Pineapple");
			System.out.println("11. Passion fruit");
			System.out.println("12. Avocados");
			System.out.println("13. Exit Menu");
			if (sc.hasNextInt() ) { 
				int selection = sc.nextInt();
				int quantity;
					switch (selection) {
					case 1: System.out.println("Enter weight of Banana you would like to purchase: ");
					quantity = sc.nextInt();
					if (banana.isQuantitySufficient(quantity)) {
						banana.setQuantity(quantity);
						bill = c[(int) counterNumber].checkOutCustomer(c[(int) counterNumber].getDiscountedAmount(banana));
					}
					break;
					
					case 2: System.out.println("Enter weight of Melon you would like to purchase: ");
					quantity = sc.nextInt();
					if (melon.isQuantitySufficient(quantity)) {
						melon.setQuantity(quantity);
						bill = c[(int) counterNumber].checkOutCustomer(c[(int) counterNumber].getDiscountedAmount(melon));
					}
					break;
					
					case 3: System.out.println("Enter weight of Grapes you would like to purchase: ");
					quantity = sc.nextInt();
					if (grape.isQuantitySufficient(quantity)) {
						grape.setQuantity(quantity);
						bill = c[(int) counterNumber].checkOutCustomer(c[(int) counterNumber].getDiscountedAmount(grape));
					}
					break;
					
					case 4: System.out.println("Enter no. of bags of Apples you would like to purchase: ");
					quantity = sc.nextInt();
					if (apple.isQuantitySufficient(quantity)) {
						apple.setQuantity(quantity);
						bill = c[(int) counterNumber].checkOutCustomer(c[(int) counterNumber].getDiscountedAmount(apple));
					}
					break;

					case 5: System.out.println("Enter no. of bags of oranges you would like to purchase: ");
					quantity = sc.nextInt();
					if (orange.isQuantitySufficient(quantity)) {
						orange.setQuantity(quantity);
						bill = c[(int) counterNumber].checkOutCustomer(c[(int) counterNumber].getDiscountedAmount(orange));
					}
					break;

					case 6: System.out.println("Enter no. of bags of lemons you would like to purchase: ");
					quantity = sc.nextInt();
					if (lemon.isQuantitySufficient(quantity)) {
						lemon.setQuantity(quantity);
						bill = c[(int) counterNumber].checkOutCustomer(c[(int) counterNumber].getDiscountedAmount(lemon));
					}
					break;

					case 7: System.out.println("Enter no. of kiwis you would like to purchase: ");
					quantity = sc.nextInt();
					if (kiwi.isQuantitySufficient(quantity)) {
						kiwi.setQuantity(quantity);
						bill = c[(int) counterNumber].checkOutCustomer(c[(int) counterNumber].getDiscountedAmount(kiwi));
					}
					break;

					case 8: System.out.println("Enter no. of peppers you would like to purchase: ");
					quantity = sc.nextInt();
					if (pepper.isQuantitySufficient(quantity)) {
						pepper.setQuantity(quantity);
						bill = c[(int) counterNumber].checkOutCustomer(c[(int) counterNumber].getDiscountedAmount(pepper));
					}
					break;

					case 9: System.out.println("Enter no. of cucumber you would like to purchase: ");
					quantity = sc.nextInt();
					if (cucumber.isQuantitySufficient(quantity)) {
						cucumber.setQuantity(quantity);
						bill = c[(int) counterNumber].checkOutCustomer(c[(int) counterNumber].getDiscountedAmount(cucumber));
					}
					break;
					
					case 10: System.out.println("Enter no. of pineapples you would like to purchase: ");
					quantity = sc.nextInt();
					if (pineapple.isQuantitySufficient(quantity)) {
						pineapple.setQuantity(quantity);
						bill = c[(int) counterNumber].checkOutCustomer(c[(int) counterNumber].getDiscountedAmount(pineapple));
					}
					break;
					
					case 11: 
					System.out.println("Enter no. of passion fruits you would like to purchase: ");
					quantity = sc.nextInt();
					if (pfruit.isQuantitySufficient(quantity)) {
						pfruit.setQuantity(quantity);
						bill = c[(int) counterNumber].checkOutCustomer(c[(int) counterNumber].getDiscountedAmount(pfruit));
					}
					break;
					
					case 12: 
					System.out.println("Enter no. of Avocados you would like to purchase: ");
					quantity = sc.nextInt();
					if (avocado.isQuantitySufficient(quantity)) {
						avocado.setQuantity(quantity);
						bill = c[(int) counterNumber].checkOutCustomer(c[(int) counterNumber].getDiscountedAmount(avocado));
					}
					break;
					
					case 13: 
						picked = true;
						break;
					
					default : 
						picked = true;
						break;	

					}
			}
		} while (!picked );
		
		System.out.println("Money in cash counter" + (int) counterNumber + " = " + bill);
		System.out.println("Number of Apples left : " + (int)apple.getRemainingItems());
		System.out.println("Number of Banana left : " + (int)banana.getRemainingItems());
		System.out.println("Number of Melon left : " + (int)melon.getRemainingItems());
		System.out.println("Number of Grapes left : " + (int)grape.getRemainingItems());
		System.out.println("Number of Oranges left : " + (int)orange.getRemainingItems());
		System.out.println("Number of Lemons left : " + (int)lemon.getRemainingItems());
		System.out.println("Number of Kiwis left : " + (int)kiwi.getRemainingItems());
		System.out.println("Number of Pepper left : " + (int)pepper.getRemainingItems());
		System.out.println("Number of Cucumber left : " + (int)cucumber.getRemainingItems());
		System.out.println("Number of Pineapple left : " + (int)pineapple.getRemainingItems());
		System.out.println("Number of Passion fruit left : " + (int)pfruit.getRemainingItems());
		System.out.println("Number of Avocados left : " + (int)avocado.getRemainingItems());
		sc.close();

	}
	

}
