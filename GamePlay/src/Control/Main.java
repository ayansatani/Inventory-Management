/**
 * 
 * CET - CS Academic Level 4
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * 
 * Student Name: Ayan Satani(041089567) Guntas Singh Chugh (041091309)  
 * 
 */

package Control;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import Model.Connect4;
import View.ChatHead;
import View.GameInfoPanel;
import View.MenuPanel;
import View.PlayArea;
import View.TitleBar;

/**
 * The main class for the Connect Four game application.
 */
public class Main {

	/**
	 * Entry point of the application
	 *
	 * @param args not used in this application
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Connect 4");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(1350, 850));
		ImageIcon logo = new ImageIcon("logo.jpg");
		frame.setIconImage(logo.getImage());

		Translator translator = new Translator();

		GameInfoPanel gameInfoPanel = new GameInfoPanel();
		Connect4 game = new Connect4(gameInfoPanel);

		PlayArea playArea = new PlayArea(); // Adjust dimensions if necessary
		TitleBar titleBar = new TitleBar();
		ChatHead chatHead = new ChatHead();

		Connect4Controller controller = new Connect4Controller(game, playArea, gameInfoPanel);
		MenuController menuController = new MenuController(controller);
		MenuPanel menuPanel = new MenuPanel(menuController, translator, gameInfoPanel);
		PlayerName playerNamePanel = new PlayerName();

		// Retrieve player names and update GameInfoPanel labels
		int option = JOptionPane.showConfirmDialog(frame, playerNamePanel, "Enter Player Names",
				JOptionPane.OK_CANCEL_OPTION);

		while (option == JOptionPane.OK_OPTION) {
			String player1Name = playerNamePanel.getPlayer1Name();
			String player2Name = playerNamePanel.getPlayer2Name();

			if (player1Name == null || player1Name.isEmpty() || player2Name == null || player2Name.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please enter both player names!", "Error",
						JOptionPane.INFORMATION_MESSAGE);
				option = JOptionPane.showConfirmDialog(frame, playerNamePanel, "Enter Player Names",
						JOptionPane.OK_CANCEL_OPTION);
			} else {
				gameInfoPanel.setPlayerNames(player1Name, player2Name);
				break; // Exit the loop once both names are provided
			}
		}

		// If the user clicks Cancel or closes the dialog, handle accordingly
		if (option != JOptionPane.OK_OPTION) {
			System.exit(0);
		}

		frame.setLayout(new BorderLayout());
		frame.add(titleBar, BorderLayout.NORTH);
		frame.add(menuPanel, BorderLayout.WEST);
		frame.add(playArea, BorderLayout.CENTER);
		frame.add(chatHead, BorderLayout.EAST);
		frame.add(gameInfoPanel, BorderLayout.SOUTH);
		frame.pack();

		// frame.setResizable(false); // Uncomment to disable resizing
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
