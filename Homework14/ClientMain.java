import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * ClientMain.java
 * 
 * @version $Id: ClientMain.java,v 1.0 2013/11/26 08:00am $
 * 
 * @author Pavan Kumar Pallerla
 * @author Eric Fortunato
 * 
 * 
 */
public class ClientMain {

	/**
	 * main method
	 * 
	 * @param args
	 *            first argument is the server's ip address 
	 */
	public static void main(String[] args) {

		try {
			
			String host = args[0];
			Registry registry = LocateRegistry.getRegistry(host, 10001);
			TossInfo tossInfo2 = (TossInfo) registry.lookup("TossModel");
			ClientView theView = new ClientView();
			//TossModel theModel = new TossModel();
			ClientController theController = new ClientController(theView, tossInfo2);
			theView.setVisible(true);

		} catch (NumberFormatException nfe) {
			System.out.println("Port entered" + args[1]
					+ " is not a valid number");
		} catch (Exception e){
			System.out.println("Issue with RMI: " + e.getMessage());
			e.printStackTrace();
		}

	}

}
