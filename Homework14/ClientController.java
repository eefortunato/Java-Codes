/**
 * ClientController.java
 * Class ClientController  is our implementation of the controller for the game in the MVC architecture for the client side.
 * 
 *  @version   $Id: ClientController.java,v 1.0 2013/11/26 11:20pm $
 * 
 * @author Pavan Kumar Pallerla
 * @author Eric Fortunato
 * 
 *
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * ClientController.java
 * 
 * @version $Id: ClientController.java,v 1.0 2013/11/26 08:00am $
 * 
 * @author Pavan Kumar Pallerla
 * @author Eric Fortunato
 * 
 * 
 */
public class ClientController {

	private ClientView theView;
	private TossInfo theObject;

	/**
	 * Constructor for ClientController
	 * 
	 * @param view
	 *            ClientView object
	 * @param stub
	 *            TossInfo object
	 
	 */
	public ClientController(ClientView view, TossInfo stub) {
		this.theView = view;
		this.theObject = stub;
		this.theView.addTossListener(new TossListener());
	}

	/**
	 * TossListener is action listener class for toss button
	 * 
	 * @author Pavan Kumar Pallerla & Eric Fortunato
	 * 
	 */
	class TossListener implements ActionListener {

		@Override
		/**
		 * called when toss button is clicked
		 */
		public void actionPerformed(ActionEvent arg) {
			int selectedSide, player;

			try {
				selectedSide = theView.getSelectedRadioButton();
				theObject.setSelectedSide(selectedSide);
				player = theObject.getPlayer();
				if (selectedSide == theObject.getWinningSide()) {
					theObject.setWinner(player);
				} else {
					theObject.setWinner(player);
				}
				theView.setWinner(player);				
				theObject.updateServer(theObject);
			} catch (Exception e) {

			}
		}
	}

}
