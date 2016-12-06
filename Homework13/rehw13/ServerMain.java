/**
 * ServerMain.java
 * Class ServerMain is our test class for the server side game.
 * 
 *  @version   $Id: ServerMain.java,v 1.0 2013/11/26 11:00pm $
 * 
 * @author Pavan Kumar Pallerla
 * @author Eric Fortunato
 * 
 *
 */
public class ServerMain {

	public static void main(String[] args) {
		try {
			ServerView theView = new ServerView();
			TossModel theModel = new TossModel();
			theView.setVisible(true);
			ServerController theController = new ServerController(theView,theModel, Integer.parseInt(args[0]));
			
		} catch (NumberFormatException nfe) {
			System.out.println("Port entered" + args[0] + " is not a valid number");
		}
	}

}
