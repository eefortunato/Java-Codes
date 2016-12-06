import java.util.*;

/**
 * Toast.java
 * This is the Toast subclass where all the basic members and 
 * methods for toast are implemented
 * 
 *  @version   $Id: Toast.java,v 1.0 2013/09/23 11:00pm $
 * 
 * @author Pavan Kumar Pallerla
 * @author Eric Fortunato
 * 
 *
 */

public class Toast extends FallingObjects{

	private double rotation; //degrees per second.
	private boolean sideButtered = false; //if it has a side with butter
	private boolean nonButtered = false;  //if it doesn't have butter in any side
	private boolean bothButtered = false; // if it has both sides with butter.
	private int dropSide; //1 for non buttered side, 2 for buttered, 3 for middle
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
					
				Scanner objectToTry= new Scanner(System.in);
				System.out.println("Enter drop altitute:");
				double altitude = Double.parseDouble(objectToTry.next());
				System.out.println("\n" + "Enter degrees to rotate per second:");
				double rotation = Double.parseDouble(objectToTry.next());
				System.out.println("\n" + "Enter side of toast, 1 for non buttered, 2 for buttered and 3 for middle: ");
				int sideOfToast = Integer.parseInt(objectToTry.next());
					System.out.println("\n" + "Enter gravity:");
					double newGravity = Double.parseDouble(objectToTry.next());
					Toast newToast = new Toast();
					while(true){
					try{
						if(newGravity <= 0.1 || newGravity >= 274){
							throw new Exception("Given gravity is out of the range \n");
						}
						newToast.setGravity(newGravity);	
						break;
					}
					catch(Exception e){
						while(newGravity < 0.1 || newGravity > 274){
						System.out.println("Gravity is not valid enter another gravity between 0.1 and 274");
						newGravity = Double.parseDouble(objectToTry.next());
						newToast.setGravity(newGravity);
						System.out.println("\n");
						}				
					break;
				}
				}
				newToast.setAltitude(altitude);
				newToast.setRotation(rotation);
				double totalTime = newToast.getTimeToFall();
				System.out.println("Total time: " + totalTime);
				System.out.println("Enter impact speed:");
				double newSpeed = Double.parseDouble(objectToTry.next());
				try{
					if(newSpeed > 3 || newSpeed < 0.1){
						throw new Exception("Given speed not valid \n");
					}
					newToast.setSpeed(newSpeed);
				}				
				catch(Exception f){
						while(newSpeed > 3 || newSpeed < 1){
							System.out.println("Given Speed is not valid, enter speed between 1 - 3 ");	
							newSpeed=Double.parseDouble(objectToTry.next());
						}
						newToast.setSpeed(newSpeed);
				}								
				try{
					System.out.println("Rotation: " + newToast.getRotation());
					System.out.println("Total degrees: " + totalTime*newToast.getRotation());
					if(totalTime*newToast.getRotation() > 2250){
						throw new Exception("\n" + "Toast is rotating more than 7 times, enter less degrees per second: ");
					}
					newToast.setRotation(rotation);
				}
				catch(Exception g){
					while((totalTime*newToast.getRotation()) > 2250){
						System.out.println("\n" + "Toast is rotating more than 7 times, enter less degrees per second: ");
						rotation=Double.parseDouble(objectToTry.next());
						newToast.setRotation(rotation);
					}
				}
				newToast.setSideToDrop(sideOfToast);
				if(newToast.getSideToDrop()==3){
					newToast.setState(false);
					System.out.println("Toast landed in the side without butter");
				}
				else if(totalTime*newToast.getRotation() > 90 && totalTime*newToast.getRotation() < 180 && newToast.getSideToDrop()==1){
					newToast.setState(true);
					System.out.println("Toast landed in butter side");
				}
				else if(totalTime*newToast.getRotation() > 90 && totalTime*newToast.getRotation() < 180 && newToast.getSideToDrop()==2){
					newToast.setState(false);
					System.out.println("Toast landed in the side without butter");
				}
				else if(newToast.getSideToDrop()==1 && totalTime*newToast.getRotation() < 90 || newToast.getSideToDrop()==1 && totalTime*newToast.getRotation() > 180){
					newToast.setState(false);
					System.out.println("Toast landed in the side without butter");
				}
				else if(newToast.getSideToDrop()==2 && totalTime*newToast.getRotation() < 90 || newToast.getSideToDrop()==2 && totalTime*newToast.getRotation() > 180){
					newToast.setState(true);
					System.out.println("Toast landed in the butter side");
				}				
				System.out.println("Total Toasts: " + newToast.getCount());
				}
	
	/**
	 * Default Constructor	
	 */
	
	public Toast(){				
	}
	
	/**
	 * Toast constructor initializes the Toast object
	 * @param ToastOption is the option for choosing with or without butter, both or none
	 * @param ToastRotation is the given rotation per second of the toast
	 */
	
	public Toast(int ToastOption, int ToastRotation){
		super();
		this.rotation=ToastRotation;
		if(ToastOption==1){
			this.sideButtered=true;
		}
		else if(ToastOption==2){
			this.nonButtered=true;
		}
		else if(ToastOption==3){
			this.bothButtered=true;
		}
		this.rotation=ToastRotation;
	}
	
	/**
	 * Getter method for the rotation of the toast
	 * @return rotation the assigned rotation for a toast
	 */
	
	public double getRotation(){
		return this.rotation;
	}
	
	public void setRotation(double degreesPerSecond){
			
		this.rotation=degreesPerSecond;
	}
	
	/**
	 * Getter method for the side the toast will be dropped
	 * @return dropSide 1 for non buttered side, 2 for buttered, 3 for middle
	 */
	
	public int getSideToDrop(){		
		return this.dropSide;
	}
	
	/**
	 * This method sets from which side the toast will be dropped
	 * @param whichSide is a number chosen for the drop side of the toast
	 */
	
	public void setSideToDrop(int whichSide){
		 this.dropSide=whichSide;
	}
	
}
