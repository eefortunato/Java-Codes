
public class Gallow {
	
	static int wrongGuess;
	
	static void drawGallow(int howManyWrongGuesses){
		if(howManyWrongGuesses == 1){
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Gallow drawing = new Gallow();
		drawing.wrongGuess = 9;
		drawing.drawGallow(Gallow.wrongGuess);
	}

}
