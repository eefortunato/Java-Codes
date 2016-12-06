/**
 * HangMan.java
 * Program that emulates the Hangman game
 * 
 *  @version   $Id: HangMan.java,v 1.0 2013/09/16 5:30pm $
 * 
 * @author Pavan Kumar Pallerla
 * @author Eric Fortunato
 * 
 * The user has to guess the words from the file, he has 8 opportunities before
 * the program draws the gallows and passes to the next word, you can enter 1 for changing the word.
 *
 */

import java.util.Scanner;
import java.io.File;
import java.io.*;

public class HangMan {
	
	static String guess; //current user´s guess
	static int wrongGuessNumber=0; //counter for wrong guesses
	static String[] guessSoFar; //array for storing and printing each correct guess for the current word
	static String currentWord; //current word from the file
	static int characterCounter=0; //counter for each correct character guessed 
	
	/**
	 * Reads the file from the command line and stores it in an string array 
	 * @param fileScanned the file opened in the command line
	 * @return string of arrays containing the words from the file
	 */
	static String[] readWords(Scanner fileScanned){
		String[] wordToGuess= new String[10];
		try {
			
			int lineCounter=0;
			while (fileScanned.hasNextLine()){
				
				wordToGuess[lineCounter]= fileScanned.nextLine();
				lineCounter++;
			}
			fileScanned.close();	//we have to put this in the finally
						
		} catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
		}
		return wordToGuess;
	}
	
	/**
	 * The method checks whether the guess from the user is correct or not
	 * @param userGuess the current guess of the user
	 * @param currentWordToGuess the current word from the file
	 * @return true if is correct or false if not
	 */
	static boolean checkGuess(String userGuess, String currentWordToGuess){
		boolean charExists=false;	
		
		for(int i=0; i < currentWordToGuess.length(); i++){
			if(!userGuess.equalsIgnoreCase(guessSoFar[i])){//it will check if the character was guessed already or not
			if(userGuess.equalsIgnoreCase((Character.toString(currentWordToGuess.charAt(i))))){//it does the check ignoring the case, whether is upper or lower case
				charExists=true;				
			}			
		}
		}
		return charExists;
	}
	
	/**
	 * The function prints each guess of the user and all guessed so far
	 * @param userGuess the current guess of the user
	 * @param currentWordToGuess current word from file
	 */
	static void printGuess(String userGuess, String currentWordToGuess){
		
			
		    System.out.print(wrongGuessNumber + ": ");		    
			for(int i=0; i<currentWordToGuess.length(); i++){				
				
				if(userGuess.equalsIgnoreCase((Character.toString(currentWordToGuess.charAt(i))))){
					characterCounter++;					
					guessSoFar[i]=userGuess;					
				}
				else if(userGuess.matches("1")){
					break;
				}
				if(characterCounter <= currentWordToGuess.length()){
					System.out.print(guessSoFar[i]);
				}
				else{
					System.out.println("\n");
					return;
				}
			}			
			System.out.println("\n");
	}	
	
	/**
	 * The function draws the gallows each time there is a wrong guess from the user
	 * @param howManyWrongGuesses number of wrong guesses
	 */
	static void drawGallow(int howManyWrongGuesses){
		if(howManyWrongGuesses == 1){
			System.out.println("\n\n\n\n\n\n\n\n\n");
			System.out.println("\t #########");
			System.out.println("\t ##\t##");
			System.out.println("\t###\t###");
		}
		else if(howManyWrongGuesses == 2){
			System.out.println("\t    #\n\t    #\n\t    #\n\t    #\n\t    #\n\t    #\n\t    #\n\t    #");
			System.out.println("\t #########");
			System.out.println("\t ##\t##");
			System.out.println("\t###\t###");
		}
		else if(howManyWrongGuesses == 3){
			System.out.println("\t    ##############\n\t    #\n\t    #\n\t    #\n\t    #\n\t    #\n\t    #\n\t    #");
			System.out.println("\t #########");
			System.out.println("\t ##\t##");
			System.out.println("\t###\t###");
		}
		else if(howManyWrongGuesses == 4){
			System.out.println("\t    ##############\n\t    #  #\n\t    # #\n\t    ##\n\t    #\n\t    #\n\t    #\n\t    #");
			System.out.println("\t #########");
			System.out.println("\t ##\t##");
			System.out.println("\t###\t###");
		}
		else if(howManyWrongGuesses == 5){
			System.out.println("\t    ##############\n\t    #  #         #\n\t    # #          #\n\t    ##\n\t    #\n\t    #\n\t    #\n\t    #");
			System.out.println("\t #########");
			System.out.println("\t ##\t##");
			System.out.println("\t###\t###");
		}
		else if(howManyWrongGuesses == 6){
			System.out.println("\t    ##############\n\t    #  #         #\n\t    # #          #\n\t    ##         #####\n\t    #          #####\n\t    #\n\t    #\n\t    #");
			System.out.println("\t #########");
			System.out.println("\t ##\t##");
			System.out.println("\t###\t###");
		}
		else if(howManyWrongGuesses == 7){
			System.out.println("\t    ##############\n\t    #  #         #\n\t    # #          #\n\t    ##         #####\n\t    #          #####\n\t    #            #\n\t    #            #\n\t    #");
			System.out.println("\t #########");
			System.out.println("\t ##\t##");
			System.out.println("\t###\t###");
		}
		else if(howManyWrongGuesses == 8){
			System.out.println("\t    ##############\n\t    #  #         #\n\t    # #          #\n\t    ##         #####\n\t    #          #####\n\t    #            #\n\t    #           ###\n\t    #            #");
			System.out.println("\t #########");
			System.out.println("\t ##\t##");
			System.out.println("\t###\t###");
		}
		else if(howManyWrongGuesses == 9){
			System.out.println("\t    ##############\n\t    #  #         #\n\t    # #          #\n\t    ##         #####\n\t    #          #####\n\t    #            #\n\t    #           ###\n\t    #            #");
			System.out.println("\t #########      # #");
			System.out.println("\t ##\t##");
			System.out.println("\t###\t###");
		}
	}

	/**
	 * The main function will receive the file from the command line and iterate with the user the guesses for all the words
	 * @param args name of the file with the words
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			File fileInCommandLine = new File(args[0]);
			Scanner fileToRead = new Scanner(fileInCommandLine);
			String[] wordsFromFile;
			wordsFromFile=readWords(fileToRead);
			for(int i=0; i<wordsFromFile.length;i++){//we store in each iteration the word from the array in a single string
				currentWord=wordsFromFile[i];				
				System.out.print(wrongGuessNumber + ": ");
				guessSoFar = new String[currentWord.length()];
				for(int j=0; j < currentWord.length(); j++){
					System.out.print(".");
					guessSoFar[j]=".";
				}
				System.out.println("\n");				
				guess=System.console().readLine();
				while(characterCounter < currentWord.length()){//it will iterate until the user has guessed the complete word
					if(checkGuess(guess,currentWord)){
						printGuess(guess, currentWord);
					}
					else if(guess.matches("1")){
						break;//if the user surrenders it will go to the for loop to take another word
					}					
					else if(!checkGuess(guess, currentWord)){	
						wrongGuessNumber++;
						System.out.println("\n\n\n");
						drawGallow(wrongGuessNumber);
						System.out.print(wrongGuessNumber +": ");
						if(wrongGuessNumber==9){
							System.out.println("The word was: "+ currentWord);
							wrongGuessNumber=0;
							System.out.println("\n");
							break;//if the user does not guess it will print the word and go to the for loop for th next word
						}
						for(int k=0; k < currentWord.length(); k++){
							System.out.print(guessSoFar[k]);							
						}
						
						System.out.println("\n");
					}
					if(characterCounter < currentWord.length()){
						guess=System.console().readLine();
					}
					
				}
				characterCounter=0;
				wrongGuessNumber=0;
				if(i==(wordsFromFile.length-1)){//if there are no more words in the array it will prrint a last message and end/exit the program
					System.out.println("You guessed all the words or the file reached the last word, Congratulations and thanks for playing!");
					break;
				}
			}
			} catch (Exception e){//Catch exception if any
				System.err.println("Error: " + e.getMessage());
			}	 	
		}
	}
