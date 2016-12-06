
public class ClientMain {

	public static void main(String[] args) {
		try {
			ClientView theView = new ClientView();
			TossModel theModel = new TossModel();
			theView.setVisible(true);
			ClientController theController = new ClientController(theView,theModel, Integer.parseInt(args[0]));
			
		} catch (NumberFormatException nfe) {
			System.out.println("Port entered" + args[0] + " is not a valid number");
		}
	}

}
