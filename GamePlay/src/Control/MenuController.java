/**
 * 
 * CET - CS Academic Level 4
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * 
 * Student Name: Ayan Satani(041089567) Guntas Singh Chugh (041091309)  
 * 
 */

package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 * Controls the menu actions of the Connect Four game.
 */
public class MenuController {
	private Connect4Controller gameController;

	/**
	 * Constructs a MenuController with the specified Connect4Controller.
	 *
	 * @param gameController The Connect4Controller instance to control the game.
	 */
	public MenuController(Connect4Controller gameController) {
		this.gameController = gameController;
	}

	/**
	 * Gets the ActionListener for the reset game action.
	 *
	 * @return The ActionListener for the reset game action.
	 */
	public ActionListener getResetGameActionListener() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gameController.resetGame();
			}
		};
	}

	/**
	 * Gets the ActionListener for the help action.
	 *
	 * @return The ActionListener for the help action.
	 */
	public ActionListener getHelpActionListener() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showHelpDialog();
			}
		};
	}

	/**
	 * Gets the ActionListener for the about action.
	 *
	 * @return The ActionListener for the about action.
	 */
	public ActionListener getAboutActionListener() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showAboutDialog();
			}
		};
	}

	/**
	 * Gets the ActionListener for the exit action.
	 *
	 * @return The ActionListener for the exit action.
	 */
	public ActionListener getExitActionListener() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exitApplication();
			}
		};
	}

	/**
	 * Displays the help dialog.
	 */
	private void showHelpDialog() {
		String helpMessage = "Welcome to Connect 4!\n\n" + "Objective:\n"
				+ "The goal of the game is to connect four of color either vertically,\n"
				+ "horizontally, or diagonally before your opponent does or the timer runs out.\n\n" + "How to Play:\n"
				+ "1. Players take turns to color the disc (yellow or blue) into any\n" + "   of the seven columns.\n"
				+ "2. The player can color the lowest available space within the chosen column.\n"
				+ "3. The game continues until one player connects four color or the board is full.\n\n" + "Controls:\n"
				+ "- Click the lowest column to play your move.\n\n" + "Have fun playing Connect 4!";
		JOptionPane.showMessageDialog(null, helpMessage, "Connect 4 - Help", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Displays the about dialog.
	 */
	private void showAboutDialog() {
		String aboutMessage = "Connect 4 Game\nVersion 1.0\n\nAyan Satani (041089567)\nGuntas Singh Chugh (041091309)";
		JOptionPane.showMessageDialog(null, aboutMessage, "About Connect 4", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Exits the application.
	 */
	private void exitApplication() {
		// Exit the application
		System.exit(0);
	}
}
