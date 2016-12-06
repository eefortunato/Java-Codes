/**
 * Leave.java
 * This is the Leave subclass where all the basic members and 
 * methods for leave are implemented
 * 
 *  @version   $Id: Leave.java,v 1.0 2013/09/23 11:00pm $
 * 
 * @author Pavan Kumar Pallerla
 * @author Eric Fortunato
 * 
 *
 */

public class Leave extends FallingObjects{

	private  int frequency;
	private  int distanceFromCatcher;
	private double currentAltitude;
	private String[] oscilation={"left", "middle", "right"};
	private String currentPosition;
	
	public main (String[] args){
		else if(objectToTry.equalsIgnoreCase("Leave")){
			System.out.println("Enter drop altitute:");
			double altitude = Float.parseFloat(System.console().readLine());
			System.out.println("\n" + "Enter frequency of oscilation in second:");
			double frequency = Double.parseDouble(System.console().readLine());
			System.out.println("\n" + "Enter gravity:");
			double newGravity = Double.parseDouble(System.console().readLine());
			Leave newLeave = new Leave();
			try{
				newLeave.setGravity(newGravity);					
			}
			catch(Exception e){
				while(newGravity < 0.1 || newGravity > 274){
				System.out.println("Gravity is not valid enter another gravity between 0.1 and 274");
				newGravity = Double.parseDouble(System.console().readLine());						
				System.out.println("\n");
				}				
			return;
		}				
		newLeave.setAltitude(altitude);
		double totalTime = newLeave.getTimeToFall();
		double calculatedSpeed=0;
		try{
		calculatedSpeed = newLeave.calculateSpeed(totalTime);										
		}
		catch(Exception f){
			if(calculatedSpeed > 3){
				while(calculatedSpeed > 3){
					System.out.println("Calculated Speed is not valid, enter a greater gravity ");	
					newGravity=Double.parseDouble(System.console().readLine());		
					newLeave.setGravity(newGravity);
					totalTime = newLeave.getTimeToFall();
					calculatedSpeed = newLeave.calculateSpeed(totalTime);
					}
					return;
				}
			while(calculatedSpeed < 1){
				System.out.println("Calculated Speed is not valid, enter a lesser gravity ");	
				newGravity=Double.parseDouble(System.console().readLine());
				newLeave.setGravity(newGravity);
				totalTime = newLeave.getTimeToFall();
				calculatedSpeed = newLeave.calculateSpeed(totalTime);
			}		
			return;	
			}	
		System.out.println("Enter forward speed of " + objectToTry + ":");
		double newSpeed = Double.parseDouble(System.console().readLine());
		try{
			if(speedFromUser > 3 || speedFromUser < 1){
				throw new Exception("Given forward speed not valid \n");
			}
			newToast.setSpeed(newSpeed);
		}				
		catch(Exception f){
				while(newSpeed > 3 || newSpeed < 1){
					System.out.println("Given Speed is not valid, enter speed between 1 - 3 ");	
					newSpeed=Double.parseDouble(System.console().readLine());
				}
				newToast.setSpeed(newSpeed);
				return;
		}
		try{
			newToast.setRotation(rotation);
		}catch(Exception g){
			while(totalTime*newToast.getRotation() > 2250){
				System.out.println("\n" + "Toast is rotating more than 7 times, enter less degrees per second: ");
				rotation=Double.parseDouble(System.console().readLine());
				newToast.setRotation(rotation);
			}
			return;
		}
		}

	}
	
	/**
	 * Default constructor
	 */
	
	public Leave(){
		super();
	}
	
	/**
	 * The Leave constructor initializes the object with the basic input
	 * @param newFrequency frequency of oscilation
	 * @param newDistance the distance from the catcher
	 * @param newAltitude the altitude for dropping
	 */
	
	public Leave (int newFrequency, int newDistance, double newAltitude){
		super();
		this.frequency=newFrequency;
		this.distanceFromCatcher=newDistance;
		this.setAltitude(newAltitude);		
	}
	
	/**
	 * Getter method for the current altitude of the leave
	 * @return currentAltitude the altitude that the leave has so far
	 */
	
	public double getCurrentAltitude(){
		return this.currentAltitude;
	}
	
	/**
	 * This method sets teh altitude for the leave object
	 * @param modifiedAltitude is the new altitude of the leave
	 */
	
	public void setCurrentAltitude(double modifiedAltitude){
		this.currentAltitude=modifiedAltitude;
	}
	
	/**
	 * Getter method for the distance between catcher and leave
	 * @return distanceFromCatcher the current distance
	 */
	
	public int getDistanceFromCatcher(){
		return this.distanceFromCatcher;
	}
	
	/**
	 * This methods sets the new distance between leave and catcher
	 * @param modifiedDistance the new distance after getting near the catcher
	 */
	
	public void setDistanceFromCatcher(int modifiedDistance){
		this.distanceFromCatcher=modifiedDistance;
	}
	

}
