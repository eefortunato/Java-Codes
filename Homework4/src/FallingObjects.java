import java.math.*;

/**
 * FallingObjects.java
 * This is the superclass FallingObjects where all the basic members and 
 * methods for subclasses are implemented
 * 
 *  @version   $Id: FallingObjects.java,v 1.0 2013/09/23 11:00pm $
 * 
 * @author Pavan Kumar Pallerla
 * @author Eric Fortunato
 * 
 *
 */

class FallingObjects {
private static double gravity; // m/s^2
private double dropAltitude; // in meters
private double currentPosition; // in meters
private boolean state=false; //if false Toast landed without butter, Leave and SmartLeave were catched
private int ToastsCounter, LeaveCounter, SmartLeaveCounter, CatcherCounter; //counter for each Toast object, Leave, SmartLeave and Catcher create
private double speed; //the speed of every object



/**
 * FallingObjects constructor, it counts the instances of each subclass 
 * 
 */
public FallingObjects(){	
	
	if(this instanceof Toast){
		ToastsCounter++;
	}
	if(this instanceof Leave){
		LeaveCounter++;
	}
	if(this instanceof SmartLeave){
		SmartLeaveCounter++;
	}
	if(this instanceof Catcher){
		CatcherCounter++;
	}
	
}

public void setGravity(double gravityFromUser){
	this.gravity=gravityFromUser;
}

/**
 * Getter method for returning the times each subclass is instantiated
 * @return counter for each subclass
 */

public int getCount(){
	if(this instanceof Toast){
		return ToastsCounter;
	}
	else if(this instanceof Leave){
		return LeaveCounter;
	}
	else if(this instanceof SmartLeave){
		return SmartLeaveCounter;
	}
	else {
		return CatcherCounter;
	}
}

/**
 * It calculates and return the total time taken by each object to reach the ground
 * @param altitude receives the altitude of the object
 * @return timeToFall amount of time taken
 */

public double getTimeToFall(){
	double timeToFall = Math.sqrt((2*this.dropAltitude)/this.gravity); //in seconds
	return timeToFall;
	
}

public double calculateSpeed(double timeToFall){
			
		return this.dropAltitude/timeToFall;
	
	
}

public void setSpeed(double speedFromUser){
	
	this.speed=speedFromUser;
}

/**
 * This method sets the altitude for the object
 * @param altitude is the given altitude of the object
 */

public void setAltitude(double newAltitude){
	this.dropAltitude=newAltitude;
}

/**
 * This method is for getting the final state of the object
 * @param anyKind is a given subclass object
 * @return state true or false
 */
public boolean getState(FallingObjects anyKind){
	
	return anyKind.state;
}

/**
 * This method is for setting the state of the object
 * @param whichState is a given subclass state
 */
public void setState(boolean whichState){
			this.state=whichState;
}

/**
 * Getter method for the altitude of the object
 * @return dropAltitude the altitude before dropping object
 */
public double getDropAltitude(){
	return this.dropAltitude;
}


/**
 * This method gets the position of the object
 * @param anyKind is the given object
 * @return currentPosition the current position of the object that is falling
 */

public double getPosition(FallingObjects anyKind){
	return anyKind.currentPosition;
}

}
