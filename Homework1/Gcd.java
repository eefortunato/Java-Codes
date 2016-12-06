/**
 * Gcd.java
 * Program that calculates the Greatest Common Divisor of
 * two positive integers.
 * This program is based upon the Euclidean algorithm to calculate the gcd 
 *
 *
 * @version   $Id: Gcd.java,v 1.0 2013/09/01 05:00pm $
 *
 * @author    Eric Fortunato
 * @author 	  Pavan Kumar Pallerla
 *
 * The Gcd only applies for natural numbers and 0 can only be
 * use as a first number because of mathematical reasons.
 *
 */


public class Gcd {
	
	int remainder; 
	int remainder2;
	int divisor; //if the first number is less than the second
	int number1;
	int number2;
	
/**
 * This method calculates GCD of two positive integers using iterative 
 * algorithm 
 * 
 * @param firstNumber positive integer
 * @param secondNumber positive integer
 * @return remainder (is the GCD if remainder was not 0 in the first iteration)
 * @return number2 (is the GCD if remainder was 0 in the first iteration)
 */
	
	public int gcdI(int firstNumber, int secondNumber){
	number1 = firstNumber;
	number2 = secondNumber;
		
		if(number1 < number2){
			divisor = number2 - number1;		
			remainder = number1 % divisor;
			number2 = divisor;
		}
		else{
			remainder = number1 % number2;
		}
		//Iteration process, if remainder is greater than 0		
		if(remainder != 0){
			while(remainder != 0){
				remainder2 = number2 % remainder;
				if(remainder2 !=0){
					remainder %= remainder2;
					number2 = remainder2;
				} else {
					return remainder;
				}
			}
		}
		return number2;
		
	}
	
/**
 *
 *The method calculates gcd of two positive integers using recursive algorithm
 *
 * @param firstNumber positive integer
 * @param secondNumber positive integer
 * @return number2 calculated GCD of the inputs
 */
	
	public int gcdR(int firstNumber, int secondNumber){
		number1=firstNumber;
		number2=secondNumber;
		if(number1 < number2){
			divisor = number2 - number1;		
			remainder = number1 % divisor;
			number2 = divisor;
		}
		else{
remainder = number1 % number2;
		}
		//Recursive process, if remainder is greater than 0
		if(remainder != 0){
				gcdR(number2, remainder);
					}
						
			return number2;
	}

	/**
	 * The main method receives two numbers from command line and calculates 
	 * their GCD using iterative and recursive methods and prints them.
	 *  
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		
		int firstInput = Integer.parseInt(args[0]);
		int secondInput = Integer.parseInt(args[1]);
		Gcd gcdObject = new Gcd();
		System.out.println("Calculating GCD of (" + firstInput + ", " + secondInput + ")");
	
		
		System.out.println("gcdI("+ firstInput + ", " + secondInput +") = " + gcdObject.gcdI(firstInput, secondInput));
		System.out.println("gcdR("+ firstInput + ", " + secondInput +") = " + gcdObject.gcdR(firstInput, secondInput));

	}

}
