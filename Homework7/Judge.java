/**
 * Judge.java
 * Class Judge which implements runnable and is our test program for musical chairs.
 * 
 *  @version   $Id: Judge.java,v 1.0 2014/03/15 6:00pm $
 * 
 * @author Sreeraj Paleri
 * @author Eric Fortunato
 * 
 *
 */

import java.util.Random;
import java.util.Scanner;
public class Judge implements Runnable {

	int [] chairs;
	int kidCounter;
	int roundCounter;
	
	/*
	 * Constructor
	 * Initializes the array of chairs with kids-1, kidCounter with 0 and roundCounter with kid-1 
	 * @param howManyKids it receives the number of kids
	 */

	public Judge(int howManyKids) {
		// TODO Auto-generated constructor stub
		chairs=new int[howManyKids-1];
		kidCounter=0;
		roundCounter=howManyKids-1;
		//kidsPlaying=allKids;
	}
	
	
	
	@SuppressWarnings("deprecation")
	/*
	 * This method plays the music until all kids are sat down
	 * It prints the ones playing currently
	 */
	public synchronized void playMusic(){
		try{						
			if(kidCounter < roundCounter){
				chairs[kidCounter]=Integer.parseInt(Thread.currentThread().getName());
				kidCounter++;
				wait();
			}
			else{
				System.out.println(roundCounter+1 + " are playing");
				roundCounter--;
				kidCounter=0;
				System.out.println("\t"+Thread.currentThread().getName() + " is out");	
				
					System.out.print("=== ");
					for(int i=0; i <= roundCounter; i++){
						System.out.print(chairs[i]);
						System.out.print(" ");
					}	
					System.out.println("");					
					notifyAll();
					Thread.currentThread().stop();
			}		
			
		}catch(Exception e){
			e.getMessage();
		}		
	}
	
	@SuppressWarnings("static-access")
	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 * This is the implementation of the run method, it calls play music and set priority again
	 */
	public void  run(){
		
				while(roundCounter > 0){
						
					playMusic();						
					Random rand2 = new Random();
					int randomPriority = rand2.nextInt(roundCounter+1)+1;
					Thread.currentThread().setPriority(randomPriority);
													
						
							
				}
			if(roundCounter==0){
				System.out.println("Ok, and the winner is: " + chairs[0]);
			}
			
	}
	
	/*
	 * This is the main method in which we receive all the kids after the program starts
	 * Creating multiple threads to play the game
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Scanner kidReader = new Scanner(System.in);
			int childNumber=0;
			System.out.println("Enter number of kids: ");
			childNumber=kidReader.nextInt();
			kidReader.nextLine();
			Thread[] kidToPlay = new Thread[childNumber];
			Judge gameJudge = new Judge(childNumber);			
			Random rand = new Random();
			String kidNumber = "0";
			for(int i=0; i < childNumber; i++){
				int randomNumber = rand.nextInt(9)+1;
				kidNumber=String.valueOf(i+1);
				kidToPlay[i] = new Thread(gameJudge, kidNumber);
				kidToPlay[i].setPriority(randomNumber);
				kidToPlay[i].start();				
			}
			
			for(int i = 0 ; i < childNumber; i++){
				try{
					kidToPlay[i].join();
					}catch(Exception InterruptedThread){
					InterruptedThread.getMessage();
					}	
			}
		}catch(Exception e){
			e.getMessage();
		}
		
	}

}
