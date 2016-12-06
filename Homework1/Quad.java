/**
 * Quad.java
 * Program that prints out all possible combinations of actors.
 *
 * @version   $Id: Quad.java,v 1.0 2013/09/02 08:00am $
 *
 * @author 	  Pavan Kumar Pallerla
 * @author    Eric Fortunato
 *
 * The ACTORS string is hard coded in the program. 
 * Modify the ACTORS string to print the combinations of different actors
 * not mentioned in the program. 
 *
 */

public class Quad {
	
	int numberOfCurrentCombinations;
	String[] combinationsArray;
	final static String ACTORS = "abcdef";
	
	/**
	 * The main method calls quadCombinations method and prints all the
	 * combinations on the console.
	 * 
	 * @param args command line arguments (ignored)
	 */
	public static void main(String[] args) {
		Quad quadObject = new Quad(ACTORS);
		quadObject.quadCombinations(ACTORS);
		for (int i = 0; i < quadObject.combinationsArray.length; i++) {
			System.out.println("{" + quadObject.combinationsArray[i] + "}");
		}
	}
	
	/**
	 * Given the actors, instantiates the combinationArray in which all the
	 * combinations are stored.
	 * @param actors 
	 */
	public Quad(String actors) {
		combinationsArray = new String[(int) Math.pow(2, actors.length())];
	}
	
	/**
	 * Given the quad string which contains all the actors, it calculates 
	 * all the possible combinations of actors and stores in combinationsArray
	 * 
	 * @param quad String contains actors 
	 */
	public void quadCombinations (String quad) {
		String quad1 = (String)quad.subSequence(0, quad.length()-1);
		String quad2 = quad.substring(quad.length()-1);
		
		if (quad1.length() > 1) {
			quadCombinations(quad1);
		} else {
			numberOfCurrentCombinations = 2;
			combinationsArray[0] = "";
			combinationsArray[1] = quad1;
			combinationsArray[2] = quad2;
			combinationsArray[3] = quad1 + quad2;
			numberOfCurrentCombinations*= 2;
			return;
		}
		
		for (int i = 0; i < numberOfCurrentCombinations; i++) {
			combinationsArray[i + numberOfCurrentCombinations] = 
					combinationsArray[i] + quad2;
		}
		numberOfCurrentCombinations*= 2;
	}
	
}
