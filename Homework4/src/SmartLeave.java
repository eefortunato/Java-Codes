
public class SmartLeave extends Leave{

	private  int directionVectorX;
	private  int directionVectorY;
	

	
	public SmartLeave(int finalDestinationX, int finalDestinationY){
		super();
		this.directionVectorX=finalDestinationX;
		this.directionVectorY=finalDestinationY;
	}
	
	public int getVectorX(){
		return this.directionVectorX;
	}
	public void setVectorX(int modifiedVectorX){
		this.directionVectorX=modifiedVectorX;
	}
	public int getVectorY(){
		return this.directionVectorY;
	}
	public void setVectorY(int modifiedVectorY){
		this.directionVectorY=modifiedVectorY;
	}
}
