/**
 * 

 * CET - CS Academic Level 4
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * 
 * Student Name: Ayan Satani(041089567) Guntas Singh Chugh (041091309)  
 * 
 */

package Model;

import View.GameInfoPanel;

/**
 * Represents a Connect4 game.
 */
public class Connect4 {
	private static final int ROWS = 6;
	private static final int COLUMNS = 7;
	private static final int CONNECT_TO_WIN = 4;

	private char[][] board;
	private boolean blueToMove;
	private GameInfoPanel gameInfoPanel;

	/**
	 * Constructs a Connect4 game.
	 *
	 * @param gameInfoPanel The panel to display game information.
	 */
	public Connect4(GameInfoPanel gameInfoPanel) {
		this.gameInfoPanel = gameInfoPanel;
		board = new char[ROWS][COLUMNS];
		resetBoard();
	}

	/**
	 * Resets the game board.
	 */
	public void resetBoard() {
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLUMNS; col++) {
				board[row][col] = ' ';
			}
		}
		blueToMove = true;
	}

	/**
	 * Makes a move in the specified column.
	 *
	 * @param column The column to make the move.
	 * @return true if the move is valid, false otherwise.
	 */
	public boolean makeMove(int column) {
		if (column < 0 || column >= COLUMNS || board[0][column] != ' ') {
			return false; // Invalid move
		}

		int row = ROWS - 1;
		while (row >= 0 && board[row][column] != ' ') {
			row--;
		}

		if (row >= 0) {
			board[row][column] = blueToMove ? 'B' : 'Y';
			if (gameInfoPanel != null) {
				if (blueToMove) {
					gameInfoPanel.stopPlayer1Timer();
					gameInfoPanel.startPlayer2Timer();
				} else {
					gameInfoPanel.stopPlayer2Timer();
					gameInfoPanel.startPlayer1Timer();
				}
			}
			blueToMove = !blueToMove; // Switch turns
			return true; // Valid move
		} else {
			return false; // Column is full
		}
	}

	/**
	 * Checks if there is a winner.
	 *
	 * @return The symbol of the winner ('B' for blue, 'Y' for yellow, 'T' for tie,
	 *         ' ' for ongoing game).
	 */
	public char checkWinner() {
		// Check horizontal
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col <= COLUMNS - CONNECT_TO_WIN; col++) {
				char symbol = board[row][col];
				if (symbol != ' ' && symbol == board[row][col + 1] && symbol == board[row][col + 2]
						&& symbol == board[row][col + 3]) {
					return symbol;
				}
			}
		}

		// Check vertical
		for (int col = 0; col < COLUMNS; col++) {
			for (int row = 0; row <= ROWS - CONNECT_TO_WIN; row++) {
				char symbol = board[row][col];
				if (symbol != ' ' && symbol == board[row + 1][col] && symbol == board[row + 2][col]
						&& symbol == board[row + 3][col]) {
					return symbol;
				}
			}
		}

		// Check diagonals
		for (int row = 0; row <= ROWS - CONNECT_TO_WIN; row++) {
			for (int col = 0; col <= COLUMNS - CONNECT_TO_WIN; col++) {
				char symbol = board[row][col];
				if (symbol != ' ' && symbol == board[row + 1][col + 1] && symbol == board[row + 2][col + 2]
						&& symbol == board[row + 3][col + 3]) {
					return symbol;
				}
			}
		}

		for (int row = 0; row <= ROWS - CONNECT_TO_WIN; row++) {
			for (int col = CONNECT_TO_WIN - 1; col < COLUMNS; col++) {
				char symbol = board[row][col];
				if (symbol != ' ' && symbol == board[row + 1][col - 1] && symbol == board[row + 2][col - 2]
						&& symbol == board[row + 3][col - 3]) {
					return symbol;
				}
			}
		}

		// Check for a tie
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLUMNS; col++) {
				if (board[row][col] == ' ') {
					return ' '; // Game is still ongoing
				}
			}
		}
		return 'T'; // Tie
	}

	/**
	 * Gets the current game board.
	 *
	 * @return The current game board.
	 */
	public char[][] getBoard() {
		return board;
	}

	/**
	 * Checks whose turn it is.
	 *
	 * @return true if it's blue's turn, false if it's yellow's turn.
	 */
	public boolean isBlueToMove() {
		return blueToMove;
	}
}
