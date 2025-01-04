/**
 * 
 * CET - CS Academic Level 4
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * 
 * Student Name: Ayan Satani(041089567) Guntas Singh Chugh (041091309)  
 * 
 */

package Control;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Panel for entering player names.
 */

public class PlayerName extends JPanel {
	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * JtextField for user to enter their name
	 */
	private JTextField player1NameField;
	/**
	 * JtextField for user to enter their name
	 */
	private JTextField player2NameField;

	/**
	 * Constructs a PlayerName panel.
	 */
	public PlayerName() {
		setLayout(new GridLayout(2, 2));

		// Create labels and text fields for player names
		JLabel player1Label = new JLabel("Player 1 Name:");
		player1NameField = new JTextField();
		JLabel player2Label = new JLabel("Player 2 Name:");
		player2NameField = new JTextField();

		// Add labels and text fields to the panel
		add(player1Label);
		add(player1NameField);
		add(player2Label);
		add(player2NameField);
	}

	/**
	 * Gets the player 1 name.
	 *
	 * @return The player 1 name.
	 */
	public String getPlayer1Name() {
		return player1NameField.getText();
	}

	/**
	 * Gets the player 2 name.
	 *
	 * @return The player 2 name.
	 */
	public String getPlayer2Name() {
		return player2NameField.getText();
	}
}
