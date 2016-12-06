import java.util.*;
public class Catcher extends FallingObjects{

	private static double speed=0.4; //meters per second
	private static int vectorX;
	private static int vectorY;
	private static int LeavesCatched;
	private static int SmartLeavesCatched;
	private static double CatcherAltitude;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private Catcher(){
		
	}
	
	private Catcher(double newSpeed, int newVectorX, int newVectorY){
		super();
		this.speed=newSpeed;
		this.vectorX=newVectorX;
		this.vectorY=newVectorY;
	}
	
	private boolean getLeavePosition(Leave kindOfLeave){
		boolean isNear=false;
		if(kindOfLeave.getDistanceFromCatcher()==0 && kindOfLeave.getCurrentAltitude()==this.CatcherAltitude){
			isNear=true;
		}
		return isNear;
	}
	
	public void tryToCatch(Leave anyLeave){
		
		if(anyLeave instanceof SmartLeave ){
			this.SmartLeavesCatched++;
		}
		else {
		this.LeavesCatched++;
		}
		
	}
}
