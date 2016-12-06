import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import java.io.*;
import java.util.*;


public class TossController {

	private TossView theView;
	private TossModel theModel;
	private ServerSocket theServer;
	private Socket player1;
	private Socket player2;
	private DataInputStream fromPlayer1;
	private DataOutputStream toPlayer1;
	private DataInputStream fromPlayer2;
	private DataOutputStream toPlayer2;
	 
	
	public TossController(TossView view, TossModel model) {
		this.theView = view;
		this.theModel = model;		
		this.theView.addTossListener(new TossListener());
	}
	
	class TossListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg) {
			int selectedSide, player;
			
			try {
				selectedSide = theView.getSelectedRadioButton();
				theModel.setSelectedSide(selectedSide);
				player = theModel.getPlayer();
				theView.setTossingPlayer();
				if (selectedSide == theModel.getWinningSide()) {
					theModel.setWinner(player);
				} else {
					theModel.setWinner(player); // set non-player as winner  
				}
				theView.setWinner(player);
			} catch (Exception e) {
				
			}
		}
		
	}
}
