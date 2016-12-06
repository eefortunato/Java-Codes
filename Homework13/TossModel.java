import java.io.*;


public class TossModel implements Serializable{

	private int player, winner;
	
	// 0 = Heads, 1 = Tails
	private int selectedSide, winningSide;
	
	public void setSelectedSide(int side) {
		selectedSide = side;
	}
	
	public int getSelectedSide() {
		return selectedSide;
	}
	
	public int getWinningSide() {
		return (int) (System.currentTimeMillis() % 2);
	}
	
	public int getPlayer() {
		return (int) (System.currentTimeMillis() % 2);
	}
	
	public void setWinner(int winner) {
		this.winner = winner;
	}
	
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