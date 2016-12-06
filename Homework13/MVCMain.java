
public class MVCMain {

	public static void main(String[] args) {

		TossView theView = new TossView();
		TossModel theModel = new TossModel();
		TossController theController = new TossController(theView,theModel);
		theView.setVisible(true);

	}

}
