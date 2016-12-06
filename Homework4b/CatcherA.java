import java.util.Scanner;


public class CatcherA extends FallingObjectsA{
	private final double minForwardSpeed = 2;
	private final double maxForwardSpeed = 3;
	private double forwardSpeed;
	private final double maxSpeed = 4.4;
	public static void main(String[] args) {

		Scanner sc  = new Scanner(System.in);
		CatcherA catcher = new CatcherA();
		
		System.out.println("Enter gravity value: ");
		assert(sc.hasNextDouble()):"Entered valued is not a double";
		catcher.setGravity(Double.valueOf(sc.next()));
		System.out.println("Enter speed on the impact: ");
		assert(sc.hasNextDouble()):"Entered valued is not a double";
		catcher.setSpeedOnImpact(Double.valueOf(sc.next()));
		System.out.println("Enter forward speed for the catcher: ");
		assert(sc.hasNextDouble()):"Entered valued is not a double";
		catcher.setForwardSpeed(Double.valueOf(sc.next()));
		}
	public void setSpeedOnImpact(double userInput) {
		assert (userInput < maxSpeed) : "Speed on the impact is more than 4.4 m/s";
		assert (userInput > 0) : "The value entered is either a negative no. or 0";
		this.speedOnImpact = userInput;
	}

		private void setForwardSpeed(double userInput) {
		assert(userInput > minForwardSpeed && userInput <= maxForwardSpeed) : "Forward speed is not in range. It should be from 2 to 3";
		this.forwardSpeed = userInput;
		}
	
}

