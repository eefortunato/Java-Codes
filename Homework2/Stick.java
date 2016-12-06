/**
 * Stick.java
 * Program that prints the small sticks which can cover the maximum of big stick
 * 
 *  @version   $Id: Stick.java,v 1.0 2013/09/08 11:00am $
 * 
 * @author Pavan Kumar Pallerla
 * @author Eric Fortunato
 * 
 * The big stick and short sticks' lengths are hard coded in the program
 * Change the lengths of the sticks and number of sticks to modify the input.
 *
 */
public class Stick {
	int numberOfCurrentCombinations;
	String[] stringCombinationsArrayI;	   // Iterative combinations of S0, S1, S2
	String[] stringCombinationsArrayR;	   // Recursive combinations of S0, S1, S2
	int[] intCombinationsArrayI;		   // sum of iterative combinations 
	int[] intCombinationsArrayR;		   // sum of recursive combinations
	static int longStickLength = 15;
	static int shortStickCount = 5;
	int[] shortSticksArray = {3,7,2,6,4};

	/**
	 * The main method calls setStringCombinationsI and setStringCombinationsR
	 * methods to calculate string combinations of S0, S1, S2 etc iteratively
	 * and recursively respectively
	 * Then calls setIntegerArray to calculate the sum of lengths of those 
	 * combinations.
	 * Calls printIndicesMaxLengthSticks which prints lengths of short sticks
	 * 
	 * @param args command line arguments (ignored)
	 */
	public static void main(String[] args) {
		Stick stick = new Stick();
		System.out.println("Stick length:\t" + longStickLength);
		for(int i = 0; i < stick.shortSticksArray.length; i++) {
			System.out.println("Stick " + i + " length:\t" + stick.shortSticksArray[i]);
		}
		stick.setStringCombinationsI(stick.getStringArray(shortStickCount));
		stick.setStringCombinationsR(stick.getStringArray(shortStickCount));
		stick.setIntegerArray();
		stick.printIndicesMaxLengthSticks(stick.intCombinationsArrayI, "I");
		stick.printIndicesMaxLengthSticks(stick.intCombinationsArrayR, "R");
	}
	/**
	 * Instantiates two arrays stringCombinationsArrayI and stringCombinationsArrayR
	 */
	public Stick () {
		stringCombinationsArrayI = new String[(int) Math.pow(2, shortStickCount)];
		stringCombinationsArrayR = new String[(int) Math.pow(2, shortStickCount)];

	}
	
	/**
	 * Given the number of short sticks the method generates a string like
	 * S0S1S2S3 for 4 sticks
	 * @param numberOfSticks number of short sticks
	 * @return string for short sticks(S0S1S2S3 and so on)
	 */
	public String getStringArray (int numberOfSticks) {
		int i = 0;
		String shortSticksString = "";
		while(i < numberOfSticks) {
			shortSticksString = shortSticksString + "S" + i;
			i++;
		}
		return shortSticksString;
	}
	
	/**
	 * Given the string of short sticks(like S0S1S2S3) the method generates
	 * all possible combinations of the sticks recursively. 
	 * @param sticks String of all short sticks
	 */
	public void setStringCombinationsR (String sticks) {
		String sticks1 = (String)sticks.subSequence(0, sticks.length()-2);
		String sticks2 = sticks.substring(sticks.length()-2);
		
		if (sticks1.length() > 2) {
			setStringCombinationsR(sticks1);
		} else {
			stringCombinationsArrayR[0] = "";
			stringCombinationsArrayR[1] = sticks1;
			stringCombinationsArrayR[2] = sticks2;
			stringCombinationsArrayR[3] = sticks1 + sticks2;
			numberOfCurrentCombinations = 4;
			return;
		}
		
		for (int i = 0; i < numberOfCurrentCombinations; i++) {
			stringCombinationsArrayR[i + numberOfCurrentCombinations] = 
					stringCombinationsArrayR[i] + sticks2;
		}
		
		numberOfCurrentCombinations*= 2;
	}
	
	/**
	 * Given the string of short sticks(like S0S1S2S3) the method generates
	 * all possible combinations of the sticks iteratively. 
	 * @param sticks String of all short sticks
	 */
	public void setStringCombinationsI (String sticks) {
		for (int i = 0; i < sticks.length(); i+=2) {
			stringCombinationsArrayI[numberOfCurrentCombinations] = (String)sticks.subSequence(i, i+2);
			numberOfCurrentCombinations++;
			for (int j = i+2; j < sticks.length(); j+=2) {
				String comb = (String)sticks.subSequence(j, j+2);
				stringCombinationsArrayI[numberOfCurrentCombinations] = (String)sticks.subSequence(i, i+2) + comb;
				numberOfCurrentCombinations++;
				for(int k = j+2; k < sticks.length(); k+=2) {
					stringCombinationsArrayI[numberOfCurrentCombinations] = (String)sticks.subSequence(i, i+2) + comb + (String)sticks.subSequence(k, k+2);
					numberOfCurrentCombinations++;
					if (!comb.equals((String)sticks.subSequence(i+2, i+4)) ) {
						stringCombinationsArrayI[numberOfCurrentCombinations] = (String)sticks.subSequence(i, j+2) + (String)sticks.subSequence(k, k+2);
						numberOfCurrentCombinations++;
					}
				}
			}
		}
	}
	/**
	 * The method takes each array element from stringCombinationsArrayI 
	 * and stringCombinationsArrayR and sums up the sticks combination present
	 * and stores them in intCombinationsArrayI and intCombinationsArrayR
	 *
	 */
	public void setIntegerArray() {
		intCombinationsArrayI = new int[stringCombinationsArrayI.length];
		intCombinationsArrayR = new int[stringCombinationsArrayR.length];
		
		for (int i = 0; i < stringCombinationsArrayI.length; i++) {
			if (null != stringCombinationsArrayI[i]) {
				String[] numberArray = stringCombinationsArrayI[i].split("S");
				for (int j = 0; j < numberArray.length; j++) {
					if (!numberArray[j].isEmpty()) {
						intCombinationsArrayI[i]+=shortSticksArray[Integer.parseInt(numberArray[j])];
					}
				}
			}
			
		}
		for (int i = 0; i < stringCombinationsArrayR.length; i++) {
			if (null != stringCombinationsArrayR[i]) {
				String[] numberArray = stringCombinationsArrayR[i].split("S");
				for (int j = 0; j < numberArray.length; j++) {
					if (!numberArray[j].isEmpty()) {
						intCombinationsArrayR[i]+=shortSticksArray[Integer.parseInt(numberArray[j])];
					}
				}
			}
		}
	}
	/**
	 * Given integer array that contains sums of short sticks and the kind of
	 * method used, the method prints the sticks and their lengths that covers
	 * the largest stick the most. 
	 * @param integerArray		integer array that has sums of all the
	 * 		  combinations of short sticks.
	 * @param typeOfFunction	Accepts "R" and "I" values for recursive
	 * 		  and iterative respectively
	 */
	public void printIndicesMaxLengthSticks (int[] integerArray, String typeOfFunction) {
		int maximumLength = integerArray[0];
		int index = 0;
		for (int i = 0; i < integerArray.length; i++) {
			if (integerArray[i] > maximumLength && integerArray[i] <= longStickLength) {
				maximumLength = integerArray[i];
				index = i;
			}
		}
		String lenghtyStickCombo;
		if (typeOfFunction == "R") {
			lenghtyStickCombo = stringCombinationsArrayR[index];
			System.out.println("\nRecursive: Maximum length of the smaller sticks: " + maximumLength);
		} else {
			lenghtyStickCombo = stringCombinationsArrayI[index];
			System.out.println("\nIterative: Maximum length of the smaller sticks: " + maximumLength);
		}
		// Printing the sticks and their lengths 
		String[] lengthySticksArray = lenghtyStickCombo.split("S");
		for (int j = 0; j < lengthySticksArray.length; j++) {
			if (!lengthySticksArray[j].isEmpty()) {
				System.out.print("Stick " + lengthySticksArray[j] + " length:\t(" + shortSticksArray[j] + ")\t");
			}
		}
	}

}
