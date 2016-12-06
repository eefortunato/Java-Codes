
public class MainClass {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		
			
				System.out.println("Which object do you want to try? Toast or Leave or SmartLeave");
				String objectToTry= System.console().readLine();
				if(objectToTry.equalsIgnoreCase("Toast")){
					System.out.println("Enter drop altitute:");
					double altitude = Float.parseFloat(System.console().readLine());
					System.out.println("\n" + "Enter degrees to rotate per second:");
					double rotation = Double.parseDouble(System.console().readLine());
					System.out.println("\n" + "Enter side of toast, 1 for non buttered, 2 for buttered and 3 for middle: ");
					int sideOfToast = Integer.parseInt(System.console().readLine());
					System.out.println("\n" + "Enter gravity:");
					double newGravity = Double.parseDouble(System.console().readLine());
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
						newGravity = Double.parseDouble(System.console().readLine());
						newToast.setGravity(newGravity);
						System.out.println("\n");
						}				
					break;
				}
				}
				newToast.setAltitude(altitude);
				double totalTime = newToast.getTimeToFall();
				double calculatedSpeed=0;
				System.out.println("Enter impact speed of " + objectToTry + ":");
				double newSpeed = Double.parseDouble(System.console().readLine());
				try{
					if(newSpeed > 3 || newSpeed < 0.1){
						throw new Exception("Given speed not valid \n");
					}
					newToast.setSpeed(newSpeed);
				}				
				catch(Exception f){
						while(newSpeed > 3 || newSpeed < 1){
							System.out.println("Given Speed is not valid, enter speed between 1 - 3 ");	
							newSpeed=Double.parseDouble(System.console().readLine());
						}
						newToast.setSpeed(newSpeed);
				}
								
				try{
					if(totalTime*newToast.getRotation() > 2250){
						throw new Exception("\n" + "Toast is rotating more than 7 times, enter less degrees per second: ");
					}
					newToast.setRotation(rotation);
				}
				catch(Exception g){
					while(totalTime*newToast.getRotation() > 2250){
						System.out.println("\n" + "Toast is rotating more than 7 times, enter less degrees per second: ");
						rotation=Double.parseDouble(System.console().readLine());
						newToast.setRotation(rotation);
					}
					break;
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
							
						else{
				
			}
			
	
				

	
	}

}
