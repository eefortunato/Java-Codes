import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JProgressBar;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.SpringLayout;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;

import java.awt.Rectangle;

import javax.swing.JLayeredPane;
import javax.swing.JSplitPane;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.Box;


public class SimpleRace extends JFrame {

		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleRace frame = new SimpleRace();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SimpleRace() {
		setTitle("Simple Race, Whoever gets first to finish line wins!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 563);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblWinner = new JLabel("  Player # wins");
		lblWinner.setLabelFor(lblWinner);
		GridBagConstraints gbc_lblWinner = new GridBagConstraints();
		gbc_lblWinner.insets = new Insets(0, 0, 5, 5);
		gbc_lblWinner.gridx = 8;
		gbc_lblWinner.gridy = 0;
		getContentPane().add(lblWinner, gbc_lblWinner);
		
		JPanel finishLine = new JPanel();
		finishLine.setBackground(Color.YELLOW);
		GridBagConstraints gbc_finishLine = new GridBagConstraints();
		gbc_finishLine.gridwidth = 11;
		gbc_finishLine.insets = new Insets(0, 0, 5, 5);
		gbc_finishLine.fill = GridBagConstraints.HORIZONTAL;
		gbc_finishLine.gridx = 3;
		gbc_finishLine.gridy = 2;
		getContentPane().add(finishLine, gbc_finishLine);
		
		JPanel raceLine1 = new JPanel();
		raceLine1.setBackground(Color.BLACK);
		GridBagConstraints gbc_raceLine1 = new GridBagConstraints();
		gbc_raceLine1.gridheight = 5;
		gbc_raceLine1.gridwidth = 3;
		gbc_raceLine1.insets = new Insets(0, 0, 5, 5);
		gbc_raceLine1.fill = GridBagConstraints.BOTH;
		gbc_raceLine1.gridx = 3;
		gbc_raceLine1.gridy = 3;
		getContentPane().add(raceLine1, gbc_raceLine1);
				
		
		
		
		JPanel raceLine2 = new JPanel();
		raceLine2.setBackground(Color.BLACK);
		GridBagConstraints gbc_raceLine2 = new GridBagConstraints();
		gbc_raceLine2.gridheight = 5;
		gbc_raceLine2.gridwidth = 3;
		gbc_raceLine2.insets = new Insets(0, 0, 5, 5);
		gbc_raceLine2.fill = GridBagConstraints.BOTH;
		gbc_raceLine2.gridx = 11;
		gbc_raceLine2.gridy = 3;
		getContentPane().add(raceLine2, gbc_raceLine2);
		
		JButton player1 = new JButton("Player 1");
		GridBagConstraints gbc_player1 = new GridBagConstraints();
		gbc_player1.insets = new Insets(0, 0, 5, 5);
		gbc_player1.gridx = 1;
		gbc_player1.gridy = 9;
		getContentPane().add(player1, gbc_player1);
		
		JButton player2 = new JButton("Player 2");
		GridBagConstraints gbc_player2 = new GridBagConstraints();
		gbc_player2.insets = new Insets(0, 0, 5, 5);
		gbc_player2.gridx = 15;
		gbc_player2.gridy = 9;
		getContentPane().add(player2, gbc_player2);
		}
}
