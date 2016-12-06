/**
 * ServerController.java
 * Class ServerController  is our implementation of the controller for the game in the MVC architecture for the server side.
 * 
 *  @version   $Id: ServerController.java,v 1.0 2013/11/26 11:20pm $
 * 
 * @author Pavan Kumar Pallerla
 * @author Eric Fortunato
 * 
 *
 */

import java.io.*;
import java.net.*;


public class ServerController {

	private ServerView theView;
	private TossModel theModel;
	private int portNumber;
	
	/*
	 * Constructor that handles the connection
	 * 
	 * @params: It receives the view and the model and the port number
	 * 
	 * Returns: it returns nothing
	 */
	
	public ServerController(ServerView view, TossModel model, int port) {
		this.theView = view;
		this.theModel = model;
		this.portNumber = port;
		
		try {
			ServerSocket serverSocket = new ServerSocket(portNumber);
			Socket client = serverSocket.accept();
			ObjectInputStream in = new ObjectInputStream(client.getInputStream());
			theModel = (TossModel)in.readObject();
			theView.setWinner(theModel.getWinner());
			theView.setSelectedSide(theModel.getSelectedSide());
			in.close();
//		    BufferedReader in = new BufferedReader(
//		        new InputStreamReader(serverSocket.getInputStream()));
//		    ObjectOutputStream out = new ObjectOutputStream(serverSocket.getOutputStream());
//		    out.writeObject(theModel);
//		    out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException cnf) {
			System.out.println("TossModel class is not found");
		}
	}
}
