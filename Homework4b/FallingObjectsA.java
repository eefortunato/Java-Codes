
public class FallingObjectsA {
	
	final double maxSpeed = 3;
	final double minGravity = 0.1, maxGravity = 274;
	public double minSpeed, gravity;
	public double speedOnImpact;
	
	public double getSpeedOnImpact() {
		return speedOnImpact;
	}
	
	public void setSpeedOnImpact(double userInput){
		assert (userInput < maxSpeed):"Speed on the impact is more than 3 m/s"; 
		assert (userInput > 0):"The value entered is either a negative no. or 0";
		this.speedOnImpact = userInput;
	}
	
	public void setGravity(double userInput){
		assert (userInput > minGravity && userInput < maxGravity) : "Gravity value is out of range.";
		this.gravity = userInput;		
	}
	

}
