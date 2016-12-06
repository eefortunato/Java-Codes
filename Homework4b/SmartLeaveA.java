import java.util.Scanner;

public class SmartLeaveA extends FallingObjectsA {
	
	private final double minForwardSpeed = 1;
	private final double maxForwardSpeed = 9;
	private double forwardSpeed;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc  = new Scanner(System.in);
		SmartLeaveA smartLeave = new SmartLeaveA();
		
		System.out.println("Enter gravity value: ");
		assert(sc.hasNextDouble()):"Entered valued is not a double";
		smartLeave.setGravity(Double.valueOf(sc.next()));
		System.out.println("Enter speed on the impact: ");
		assert(sc.hasNextDouble()):"Entered valued is not a double";
		smartLeave.setSpeedOnImpact(Double.valueOf(sc.next()));
		System.out.println("Enter forward speed for the smart leave: ");
		assert(sc.hasNextDouble()):"Entered valued is not a double";
		smartLeave.setForwardSpeed(Double.valueOf(sc.next()));
	}
	
	private void setForwardSpeed(double userInput){
		assert (userInput > 1 && userInput < 9): "Forward speed is not in range. It should be from 1 to 9";
		this.forwardSpeed = userInput;		
	}
}
