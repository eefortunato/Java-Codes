import java.util.Scanner;


public class LeaveA extends FallingObjectsA {

	private int numberOfOscillations;
	public static void main(String[] args) {
		
		Scanner sc  = new Scanner(System.in);
		LeaveA leave = new LeaveA();
		System.out.println("Enter gravity value: ");
		assert(sc.hasNextDouble()):"Entered valued is not a double";
		leave.setGravity(Double.valueOf(sc.next()));
		System.out.println("Enter speed on the impact: ");
		assert(sc.hasNextDouble()):"Entered valued is not a double";
		leave.setSpeedOnImpact(Double.valueOf(sc.next()));
		System.out.println("Enter number of oscillations for the leave: ");
		assert(sc.hasNextInt()):"Entered valued is not a integer";
		leave.setNumberOfOscillations(Integer.valueOf(sc.next()));
	}
	
	private void setNumberOfOscillations(int userInput) {
		assert (userInput > 0): "The value entered is either a negative no. or 0";
		assert (userInput < 5) : "No. of oscillations is out of range.";
		numberOfOscillations = userInput;
		}

}
