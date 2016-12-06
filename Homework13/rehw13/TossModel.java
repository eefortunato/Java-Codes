/**
 * TossModel.java
 * Class TossModel.java which is our class for implementing the model for in the MVC architecture and it also implements 
 * the interface Serializable.
 * 
 *  @version   $Id: TossModel.java,v 1.0 2013/11/26 11:26pm $
 * 
 * @author Pavan Kumar Pallerla
 * @author Eric Fortunato
 * 
 *
 */

import java.io.*;


public class TossModel implements Serializable {

	private int player, winner;
	
	// 0 = Heads, 1 = Tails
	private String selectedSide;
	
	/*
	 * Setter method for the coin side selection
	 * 
	 * @params: It receives the number for the side of the coin
	 * 
	 * Returns: it returns nothing
	 */
	
	public void setSelectedSide(int side) {
		if (side == 0) {
			selectedSide = "Heads";
		} else {
			selectedSide = "Tails";
		}
		
	}
	
	/*
	 * Getter method for the coin side selection
	 * 
	 * @params: It receives nothing
	 * 
	 * Returns: it returns the string for the side of the coin selected
	 */
	
	public String getSelectedSide() {
		return selectedSide;
	}
		/*
		 *Getter method for the winning side
		 *
		 * @params: it receives nothing
		 * 
		 * Returns: it returns the number for the side of the coin
		 */
	
	public int getWinningSide() {
		return (int) (System.currentTimeMillis() % 2);
	}
	
	/*
	 * Getter method for the player
	 * 
	 * @params: It receives nothing
	 * 
	 * Returns: it returns the number of the player
	 */
	
	public int getPlayer() {
		return (int) (System.currentTimeMillis() % 2);
	}
	
	/*
	 * Setter method for winner
	 * 
	 * @params: It receives the number of the inner
	 * 
	 * Returns: it returns nothing
	 */
	
	public void setWinner(int winner) {
		this.winner = winner;
	}
	
	/*
	 * Getter method for the winner
	 * 
	 * @params: It receives nothing
	 * 
	 * Returns: It returns the name of the winner
	 */
	
	public String getWinner() {
		String winner;
		if (this.winner == 0) {
			winner = "Player - I";
		} else {
			winner = "Player - II";
		}
		return winner;
	}
	
}
