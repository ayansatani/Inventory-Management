/**
 * 
 * CET - CS Academic Level 4
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * 
 * Student Name: Ayan Satani(041089567) Guntas Singh Chugh (041091309)  
 * 
 */

package Control;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Model.Connect4;
import View.GameInfoPanel;
import View.PlayArea;

/**
 * Controls the logic and interaction of the Connect Four game.
 */
public class Connect4Controller {
	private Connect4 game;
	private PlayArea playArea;
	private GameInfoPanel gameInfoPanel;

	/**
	 * Constructs a Connect4Controller.
	 *
	 * @param game          The Connect4 game logic.
	 * @param playArea      The play area panel.
	 * @param gameInfoPanel The game information panel.
	 */
	public Connect4Controller(Connect4 game, PlayArea playArea, GameInfoPanel gameInfoPanel) {
		this.game = game;
		this.playArea = playArea;
		this.gameInfoPanel = gameInfoPanel;
		attachEventHandlers();
	}

	/**
	 * Attaches event handlers to the play area buttons.
	 */
	private void attachEventHandlers() {
		for (int row = 0; row < 6; row++) {
			for (int col = 0; col < 7; col++) {
				playArea.getCell(row, col).addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JButton clickedButton = (JButton) e.getSource();
						int columnClicked = playArea.getColumn(clickedButton);
						makeMove(columnClicked);
					}
				});
			}
		}
	}

	/**
	 * Makes a move in the game.
	 *
	 * @param column The column where the move is made.
	 */
	private void makeMove(int column) {
		if (game.makeMove(column)) {
			updateBoard();
			char winner = game.checkWinner();
			if (winner != ' ') {
				displayWinner(winner);
			}
		} else {
			// Display error message for invalid move
			JOptionPane.showMessageDialog(null, "Invalid move. Please try again.", "Invalid Move",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Updates the play area board based on the game state.
	 */
	private void updateBoard() {
		char[][] board = game.getBoard();
		for (int row = 0; row < 6; row++) {
			for (int col = 0; col < 7; col++) {
				char cellValue = board[row][col];
				Color cellColor = (cellValue == 'B') ? Color.BLUE : (cellValue == 'Y') ? Color.YELLOW : Color.WHITE;
				playArea.updateCell(row, col, cellColor);
			}
		}
	}

	/**
	 * Displays a message indicating the winner of the game.
	 *
	 * @param winner The winner of the game.
	 */
	private void displayWinner(char winner) {
		String message = (winner == 'T') ? "It's a tie!" : winner + " wins!";
		JOptionPane.showMessageDialog(null, message, "Game Over", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Resets the game to its initial state.
	 */
	public void resetGame() {
		game.resetBoard();
		playArea.resetCells();
		gameInfoPanel.resetTimer(); // Reset the timer when restarting the game
	}

	/**
	 * Sets the names of the players.
	 *
	 * @param player1Name The name of player 1.
	 * @param player2Name The name of player 2.
	 */
	public void setPlayersNames(String player1Name, String player2Name) {
	}
}
