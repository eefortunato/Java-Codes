/**
 * PrimeTest.java
 * Class PrimeTest which implement runnable and add each prime number to a list
 * 
 *  @version   $Id: PrimeTest.java,v 1.0 2013/10/28 10:00pm $
 * 
 * @author Pavan Kumar Pallerla
 * @author Eric Fortunato
 * 
 *
 */
import java.util.*;
import java.math.*;


public class PrimeTest implements Runnable {

	@SuppressWarnings("rawtypes")
	private static List allPrimes = new ArrayList(); //List of all the prime numbers
	@SuppressWarnings("rawtypes")
	private static List allNumbers; //List of all the given numbers
	
	/*
	 * This method returns true if the number is prime
	 * @param number it receives the number to check
	 * @return true if the number is prime
	 */
	public boolean isPrime(int number){
		if( number > 0 ) {
			for (int i = 2; i <= (int)Math.sqrt(number); i++) {
		        if (number % i == 0)
		            return false;
		    }
		    return true;
		}
		return false;
		
	}
	
	/*
	 * Default constructor
	 */
	 public PrimeTest(){		
	}
	

	@SuppressWarnings("unchecked")
	/*
	 * This method calls isPrime to check if the number in the thread is prime or not and then inserts it to a list 
	 * @see java.lang.Runnable#run()
	 */
	public synchronized void run(){
		try{
			int number = Integer.parseInt((Thread.currentThread().getName()));
			if(isPrime(number)){			
				allPrimes.add(number);	
			}
		}catch(NumberFormatException nfe){
			
		}
		 
	}
	/*
	 * This is the main function in which test and create all the threads to check the number given in the command line
	 * @param args it receives all the numbers as strings form command line
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			allNumbers = Arrays.asList(args);
			PrimeTest primeTest = new PrimeTest();
			Thread[] numberToCheck = new Thread[args.length];
			for(int i=0; i < args.length; i++){
				numberToCheck[i] = new Thread(primeTest, args[i]);
				numberToCheck[i].start();				
			}
			for(int i = 0 ; i < numberToCheck.length; i++){
				try{
					numberToCheck[i].join();
					}catch(Exception InterruptedThread){
					InterruptedThread.getMessage();
					}	
			}
			
			
			Collections.sort(allPrimes); //sorting all primes
			System.out.println("All numbers: " + allNumbers);			
			System.out.print( "Prime numbers sorted" + allPrimes + "\n");
		
	}

}
