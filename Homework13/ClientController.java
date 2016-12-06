import java.io.*;
import java.net.*;


public class ClientController {

	private ClientView theView;
	private TossModel theModel;
	private int portNumber;
	
	public ClientController(ClientView view, TossModel model, int port) {
		this.theView = view;
		this.theModel = model;
		this.portNumber = port;
		//TossModel cm = null;
		
		try {
			ServerSocket serverSocket = new ServerSocket(portNumber);
			Socket client = serverSocket.accept();
			ObjectInputStream in = new ObjectInputStream(client.getInputStream());
			theModel = (TossModel)in.readObject();
			theView.setWinner(theModel.getWinner());
			theView.setSelectedSide(theModel.getWinner());
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
