import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import javax.swing.JToggleButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class FindTheCookie {

    private JFrame frame;
    private JPanel content;
    private ButtonHandler listener;
    private FindTheCookieGrid grid;
    private JMenuBar menuBar;
    private JMenu file;
    private JMenuItem newGame;
    private JMenuItem options;
    private JMenuItem close;
    private JMenu help;
    private JMenuItem instructions;
    private JMenuItem about;
    MouseHandler handler;

    /**
     * 
     */
    private class ButtonHandler implements ActionListener {
        
    	@Override public void actionPerformed(ActionEvent evt) {
        	handler = new MouseHandler();
        }
    }

	/**
	 * Launch the application.
	 */
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
     * Create the application.
     */
    public FindTheCookie() {
        initialize();
    }

	
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("Find The Cookie v1.00");
        frame.setResizable(false);
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        content = new JPanel();
        content.setLayout(null);

        grid = new FindTheCookieGrid(10);
        grid.setBounds(0, 0, 444, 251);
        content.add(grid);

        menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        file = new JMenu("File");
        menuBar.add(file);

        newGame = new JMenuItem("New Game");
        file.add(newGame);

        options = new JMenuItem("Options...");
        file.add(options);

        close = new JMenuItem("Close");
        file.add(close);

        help = new JMenu("Help");
        menuBar.add(help);

        instructions = new JMenuItem("How to play?");
        help.add(instructions);

        about = new JMenuItem("About...");
        help.add(about);

        frame.setContentPane(content);
    }
}
