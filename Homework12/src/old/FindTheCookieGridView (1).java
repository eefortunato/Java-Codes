import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial") public class FindTheCookieGrid extends JPanel {
    public final int size; // The size of this grid.
    private int theCookie; // The cookie to find.
    private final int attempts=5; // The attemps left to guess.
    private int attemptsCounter=0;
    private CookieButton[][] grid; // The grid itself, which is represented as an array of CookieButtons.

   
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindTheCookie window = new FindTheCookie();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    
    /**
     * Creates a new CookieFinderGrid object according to the size specified as the argument.
     * @param size
     *            The length or breadth of the grid. The number of buttons in the grid will be size*size.
     */
    public FindTheCookieGrid(int size) {
        super(); // Call the superclass constructor.
        /*
         if(size < 3) // This is minimum limit of the size, because our code won't work properly with a size lesser than
         
                        // this.
            throw new IllegalArgumentException("The size of the grid cannot be less than three.");
        */
        setLayout(new GridLayout(10, 10)); // Set the layout of this panel.
        this.size = size;
        grid = new CookieButton[size][size];
        int id = theCookie = 0; // Initialize id, theCookie & attempts to 0.

        // Initialize each button of the grid.
        for(int i = 0; i < size; i++)
            for(int j = 0; j < size; j++) {
                grid[i][j] = new CookieButton(id); // Construct the button.
                if(!grid[i][j].found)
                    theCookie++;
                grid[i][j].addActionListener(new CookieListener()); // Add a listener to it (which does not work
                                                                    // properly).
                grid[i][j].setEnabled(true); // Disable this button.
                add(grid[i][j]); // Add it to the grid.
                id++;
            }
    }

    /**
     * 
     * The ActionListener for the CookieButtons in our grid.
     */
    private class CookieListener implements ActionListener {
        /*
         * This is test code. Not working currently!
         */
        @Override public void actionPerformed(ActionEvent evt) {
            CookieButton btn = (CookieButton)evt.getSource(); // Get the button which generated this event.
            btn.setSelected(false);
            if(btn.found) {
            	JOptionPane.showMessageDialog(null, "Congrats! you win");
                System.exit(0);
            }
            btn.setEnabled(false); // Since now we know he's safe, disable this button.
            CookieButton[] btns = getNeighbours(btn); // Get this button's neighbours, i.e., the
                                                    // buttons that surround it.
            int count = 0; // Initialize count to 0.
            for(int i = 0; i < btns.length; i++)
                if(!btns[i].found)
                    count++;
            btn.setText("" + count + "");
            attemptsCounter++;
            if(attemptsCounter == attempts) {
                JOptionPane.showMessageDialog(null, "You have reached the limit of attemps! You lose");
                System.exit(0);

            }
        }

        /**
         * Method which computes the buttons surrounding the button passed as parameter.
         * 
         * @param btn
         *            The button passed as parameter.
         * @return The buttons surrounding this button as an array of buttons.
         * @throws IllegalArgumentException
         *             If the parameter passed is null.
         */
        private CookieButton[] getNeighbours(CookieButton btn) {
            int x = btn.buttonId / size, y = btn.buttonId % size;
            System.out.println(x + ", " + y);
            if((x == 0) && (y == 0)) // This is the first button in the grid, in the top left corner.
                return new CookieButton[] {grid[x][y + 1], grid[x + 1][y], grid[x + 1][y + 1]}; // This is OK.

            else if((x == (size - 1)) && (y == (size - 1))) // This is the last button in the grid, in the lower right
                                                            // corner.
                return new CookieButton[] {grid[x - 1][y - 1], grid[x - 1][y], grid[x][y - 1]}; // This is OK.

            else if((x == 0) && (y == (size - 1))) // This is the button in the top right corner.
                return new CookieButton[] {grid[x][y - 1], grid[x + 1][y], grid[x + 1][y - 1]};

            else if((x == (size - 1)) && (y == 0)) // This is the button in the lower left corner.
                return new CookieButton[] {grid[x][y + 1], grid[x - 1][y], grid[x - 1][y + 1]}; // This is OK.

            else if(x == 0) // This is a button belonging to the first row.
                return new CookieButton[] {grid[x][y + 1], grid[x + 1][y], grid[x + 1][y + 1], grid[x + 1][y - 1],
                        grid[x][y - 1]}; // This is OK.

            else if(y == 0) // This is a button belonging to the first column.
                return new CookieButton[] {grid[x][y + 1], grid[x + 1][y], grid[x + 1][y + 1], grid[x - 1][y],
                        grid[x - 1][y + 1]}; // This is OK.

            else if(x == (size - 1)) // This is a button in the last row.
                return new CookieButton[] {grid[x][y - 1], grid[x - 1][y], grid[x - 1][y - 1], grid[x - 1][y + 1],
                        grid[x][y + 1]}; // This is OK.;

            else if(y == (size - 1)) // This is a button in the last column.
                return new CookieButton[] {grid[x][y - 1], grid[x - 1][y], grid[x - 1][y - 1], grid[x + 1][y],
                        grid[x + 1][y - 1]}; // This is OK.

            // For all other buttons.
            return new CookieButton[] {grid[x + 1][y + 1], grid[x + 1][y], grid[x][y + 1], grid[x - 1][y - 1],
                    grid[x - 1][y], grid[x][y - 1], grid[x - 1][y + 1], grid[x + 1][y - 1]}; // This is OK.

        }
    }
}