import java.io.*;
import java.util.Scanner;

/**
 * Counter.java
 * Program that reads a text file and prints how often each character is repeated
 * in it.
 * 
 *  @version   $Id: Counter.java,v 1.0 2013/09/16 11:00am $
 * 
 * @author Pavan Kumar Pallerla
 * @author Eric Fortunato
 *
 */
public class Counter {
	static long startTime;
	static long endTime;
	static int[] expensiveCounterArray = new int[52];
	static int[] lessExpensiveCounterArray = new int[52];
	
	/**
	 * The main method instantiates a scanner object and passes it to
	 * expensiveCounter and lessExpensiveCounter methods.
	 * Using currentTimeMillis method it calculates the time taken to run 
	 * each of the above methods.Then it prints the character counters by
	 * calling printCounter.
	 * 
	 * @param args		contains the file name
	 */
	public static void main(String[] args) {
		for (String arg: args) {
			try {
				Scanner sc;
				File f = new File(System.getProperty("user.dir"), arg);
				sc = new Scanner( f );
				startTime = System.currentTimeMillis();
				expensiveCounter(sc);
				endTime = System.currentTimeMillis();
				printCounter(expensiveCounterArray);
				System.out.println("Time taken(in milli seconds) for the method"
						+ " expensiveCounter: "
				+ (endTime - startTime));
				sc = new Scanner( f );
				startTime = System.currentTimeMillis();
				lessExpensiveCounter(sc);
				endTime = System.currentTimeMillis();
				printCounter(lessExpensiveCounterArray);
				System.out.println("Time taken(in milli seconds) for the method"
						+ " lessExpensiveCounter: "
				+ (endTime - startTime));
				
			} catch (FileNotFoundException e ) {
				System.err.println("File not found.");
				System.exit(0);
			}
		}

	}
	/**
	 * The method traverses each character in every line and calculates the
	 * modulus by dividing it by 65(ascii value of 'A'). 
	 * Based on the remainder, it increases the count of respective element.
	 * 
	 * @param aInputHandle is a scanner object that reads the contents of the 
	 * 			file.
	 */
	public static void expensiveCounter( Scanner  aInputHandle  ) {
		while ( aInputHandle.hasNextLine() )    {
			String currentLine = aInputHandle.nextLine();
			for (int i = 0; i < currentLine.length(); i++) {
				int remainder = (int) currentLine.charAt(i) % 65;
				switch (remainder) {
				
				case 0: 
					expensiveCounterArray[0] += 1;
					break;
					
				case 1:
					expensiveCounterArray[1] += 1;
					break;
					
				case 2:
					expensiveCounterArray[2] += 1;
					break;
					
				case 3:
					expensiveCounterArray[3] += 1;
					break;
					
				case 4:
					expensiveCounterArray[4] += 1;
					break;
					
				case 5:
					expensiveCounterArray[5] += 1;
					break;
					
				case 6:
					expensiveCounterArray[6] += 1;
					break;
					
				case 7:
					expensiveCounterArray[7] += 1;
					break;
					
				case 8:
					expensiveCounterArray[8] += 1;
					break;
					
				case 9:
					expensiveCounterArray[9] += 1;
					break;
					
				case 10:
					expensiveCounterArray[10] += 1;
					break;
					
				case 11:
					expensiveCounterArray[11] += 1;
					break;
					
				case 12:
					expensiveCounterArray[12] += 1;
					break;
					
				case 13:
					expensiveCounterArray[13] += 1;
					break;
					
				case 14:
					expensiveCounterArray[14] += 1;
					break;
					
				case 15:
					expensiveCounterArray[15] += 1;
					break;
					
				case 16:
					expensiveCounterArray[16] += 1;
					break;
					
				case 17:
					expensiveCounterArray[17] += 1;
					break;
					
				case 18:
					expensiveCounterArray[18] += 1;
					break;
					
				case 19:
					expensiveCounterArray[19] += 1;
					break;
					
				case 20:
					expensiveCounterArray[20] += 1;
					break;
					
				case 21:
					expensiveCounterArray[21] += 1;
					break;
					
				case 22:
					expensiveCounterArray[22] += 1;
					break;
					
				case 23:
					expensiveCounterArray[23] += 1;
					break;
					
				case 24:
					expensiveCounterArray[24] += 1;
					break;
					
				case 25:
					expensiveCounterArray[25] += 1;
					break;
					
				case 32:
					expensiveCounterArray[26] += 1;
					break;
					
				case 33:
					expensiveCounterArray[27] += 1;
					break;
					
				case 34:
					expensiveCounterArray[28] += 1;
					break;
					
				case 35:
					expensiveCounterArray[29] += 1;
					break;
					
				case 36:
					expensiveCounterArray[30] += 1;
					break;
					
				case 37:
					expensiveCounterArray[31] += 1;
					break;
					
				case 38:
					expensiveCounterArray[32] += 1;
					break;
					
				case 39:
					expensiveCounterArray[33] += 1;
					break;
					
				case 40:
					expensiveCounterArray[34] += 1;
					break;
					
				case 41:
					expensiveCounterArray[35] += 1;
					break;
					
				case 42:
					expensiveCounterArray[36] += 1;
					break;
					
				case 43:
					expensiveCounterArray[37] += 1;
					break;
					
				case 44:
					expensiveCounterArray[38] += 1;
					break;
					
				case 45:
					expensiveCounterArray[39] += 1;
					break;
					
				case 46:
					expensiveCounterArray[40] += 1;
					break;
					
				case 47:
					expensiveCounterArray[41] += 1;
					break;
					
				case 48:
					expensiveCounterArray[42] += 1;
					break;
					
				case 49:
					expensiveCounterArray[43] += 1;
					break;
					
				case 50:
					expensiveCounterArray[44] += 1;
					break;
					
				case 51:
					expensiveCounterArray[45] += 1;
					break;
					
				case 52:
					expensiveCounterArray[46] += 1;
					break;
					
				case 53:
					expensiveCounterArray[47] += 1;
					break;
					
				case 54:
					expensiveCounterArray[48] += 1;
					break;
					
				case 55:
					expensiveCounterArray[49] += 1;
					break;
					
				case 56:
					expensiveCounterArray[50] += 1;
					break;
					
				case 57:
					expensiveCounterArray[51] += 1;
					break;
					
				default:
					break;
				}
			}
				
		}
	}
	/**
	 * The method reads every line and for every element in lessExpensiveCounterArray
	 * it compares the ascii value with every character present in the line.
	 * 
	 * @param aInputHandle		is a scanner object that reads the contents 
	 * of the file.
	 */
	public static void lessExpensiveCounter ( Scanner  aInputHandle  ) {
		while ( aInputHandle.hasNextLine() )    {
			int ascii;
			String currentLine = aInputHandle.nextLine();
			for (int i = 0; i < 52; i++) {
				if (i <= 25) {
					ascii = i + 65;
				} else {
					ascii = i + 71;
				}
				for (int j = 0; j < currentLine.length(); j++) {
					if (ascii == (int) currentLine.charAt(j)) {
						lessExpensiveCounterArray[i] += 1;
					}
				}
			}
			
		}
	}
	
	/**
	 * The method adds each index of the array to 65(ascii value of 'A') to
	 * and converts the sum to a char value and prints it. 
	 * 
	 * @param counter The array that contains number of times each character
	 * 			is repeated.
	 */
	public static void printCounter( int counter[] ) {
		for (int i = 0; i < counter.length; i++) {
			if (i <= 25) {
				System.out.println((char) (i + 65) + " : " + counter[i]);
			} else {
				System.out.println((char) (i + 65 + 6) + " : " + counter[i]);
			}
		}
	}

}
