import java.util.Scanner;


public class ToastA extends FallingObjectsA {
	
	private int numberOfRotations;

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		ToastA toast = new ToastA();
		System.out.println("Enter gravity value: ");
		assert(sc.hasNextDouble()):"Entered valued is not a double";
		toast.setGravity(Double.valueOf(sc.next()));
		System.out.println("Enter speed on the impact: ");
		assert(sc.hasNextDouble()):"Entered valued is not a double";
		toast.setSpeedOnImpact(Double.valueOf(sc.next()));
		System.out.println("Enter number of rotations for the Toast: ");
		assert(sc.hasNextInt()):"Entered valued is not a integer";
		toast.setNumberOfRotations(Integer.valueOf(sc.next())); 
		}
	
//	private int getNumberOfRotations() {
//		return numberOfRotations;
//	}
	
	private void setNumberOfRotations(int userInput) {
		assert (userInput > 0) :"No. of rotations is out of range.";
		assert (userInput < 7) :"No. of rotations is out of range.";
		this.numberOfRotations = userInput;
		}
	

}
