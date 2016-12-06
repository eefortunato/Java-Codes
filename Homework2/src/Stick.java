
public class Stick {

	final static int length=12;
	static int numberOfCurrentCombinations;
	static String[] stickCombinationsArray;
	static int numberOfSticks =5;
	final static int[] sticksGiven = {5,3,2,3,8};
	final static String sticksIndex = "S0S1S2S3S4";
	static String stickCoverCombination;
	static int sticksAddition=0;
	static int closestStick=0;
	static String[] lastStickCharacter;
	
	public static int getLength( Stick anyStick){
		return anyStick.length;
	}
	
	
	public Stick(String sticks) {
		stickCombinationsArray = new String[(int) Math.pow(2, (sticks.length()/2))];
	}
	
	
	
	
	public static String stickCombinationsI (String stickIndex, int[] sticksToUse, Stick givenStick) {
		
		String stick1 = (String)stickIndex.subSequence(0, (stickIndex.length()-2));
		String stick2 = stickIndex.substring(stickIndex.length()-2);
		lastStickCharacter[0]=stick2;
		int stickCount=1;
		while (stick1.length() > 2) {
			stick2 = stick1.substring(stick1.length()-2);
			stick1 = (String)stick1.subSequence(0, stick1.length()-2);
			lastStickCharacter[stickCount] = stick2;
			stickCount++;
		} 
			numberOfCurrentCombinations = 2;
			stickCombinationsArray[0] = "";
			stickCombinationsArray[1] = stick1;
			stickCombinationsArray[2] = stick2;
			stickCombinationsArray[3] = stick1 + stick2;
			numberOfCurrentCombinations *=2;
			
			for(int i=0; i < numberOfCurrentCombinations; i++){	
				for(int j = 0; j < (stickCombinationsArray.length-numberOfCurrentCombinations); j++) {
			stickCombinationsArray[(stickCombinationsArray.length-numberOfCurrentCombinations)-j] = stickCombinationsArray[j] + lastStickCharacter[i];
			}		
		}
		numberOfCurrentCombinations*= 2;
		
		for(int i=1; i < numberOfCurrentCombinations; i++){
			
			for(int j=1; j < stickCombinationsArray[i].length(); j++){
				sticksAddition+=stickCombinationsArray[i].charAt(j);
				if(sticksAddition <= givenStick.length ){
					if(sticksAddition > closestStick){
						closestStick=sticksAddition;
						stickCoverCombination=stickCombinationsArray[i];
					}
			}
			}
			
		}
		return stickCoverCombination;
	}
	

	//This function stores all the sticks combinations in which the sticks added are less or equal to S
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stick S = new Stick(sticksIndex);
		lastStickCharacter= new String [(sticksIndex.length()-2)/2];
		String stickSolutionI;
		
		
		//int[] stickSolutionR;
		//stickSolutionR = new int [4];
		System.out.println("Stick   length: 	" + S.length);
		for(int sticks = 0; sticks < numberOfSticks; sticks++){
			System.out.println("Stick " + sticksGiven[sticks] + " length: 		" + sticksGiven[sticks]);
		}
		
		stickSolutionI = stickCombinationsI(sticksIndex, sticksGiven, S);
		
		//stickSolutionR = getStickCombinationsR(numberOfSticks, kSticks, S, 0);
		
		System.out.println("Iterative: Maximum length of the smaller sticks: " + closestStick + "\n");
		
		for(int i=0; i < stickSolutionI.length(); i++){
		System.out.println("Stick " + stickSolutionI.charAt(i) + " \n");
		//System.out.println("Recursive: Maximum length of the smaller sticks: " + (stickSolutionR[2] + stickSolutionR[3] ) + "\n" + "Stick " + stickSolutionR[0] + "			Stick " + stickSolutionR[1] + " \n\n\n");
		
		
	}
	}

}
