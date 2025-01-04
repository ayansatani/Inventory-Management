/**
 * 
 * CET - CS Academic Level 4
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * 
 * Student Name: Ayan Satani(041089567) Guntas Singh Chugh (041091309)  
 * 
 */

package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Represents the play area grid for the Connect Four game.
 */
public class PlayArea extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JButton[][] cells;

	/**
	 * Constructs a PlayArea panel.
	 */
	public PlayArea() {
		setBackground(new Color(200, 191, 231));
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		setLayout(new GridLayout(6, 7)); // Change the grid layout to 6 rows by 7 columns
		setPreferredSize(new Dimension(490, 420)); // Adjust the preferred size accordingly

		initializeCells();
	}

	/**
	 * Initializes the grid cells.
	 */
	private void initializeCells() {
		cells = new JButton[6][7]; // Change the dimensions of the cells array
		for (int row = 0; row < 6; row++) {
			for (int col = 0; col < 7; col++) {
				cells[row][col] = new JButton();
				cells[row][col].setPreferredSize(new Dimension(50, 50));
				cells[row][col].setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
				add(cells[row][col]);
			}
		}
	}

	/**
	 * Retrieves the JButton at the specified row and column.
	 *
	 * @param row The row index.
	 * @param col The column index.
	 * @return The JButton at the specified position.
	 */
	public JButton getCell(int row, int col) {
		return cells[row][col];
	}

	/**
	 * Retrieves the column index of the JButton.
	 *
	 * @param button The JButton to find.
	 * @return The column index of the JButton.
	 */
	public int getColumn(JButton button) {
		for (int col = 0; col < 7; col++) {
			for (int row = 0; row < 6; row++) {
				if (cells[row][col] == button) {
					return col;
				}
			}
		}
		return -1; // Button not found
	}

	/**
	 * Updates the background color of the cell at the specified row and column.
	 *
	 * @param row   The row index.
	 * @param col   The column index.
	 * @param color The color to set.
	 */
	public void updateCell(int row, int col, Color color) {
		if (row >= 0 && row < 6 && col >= 0 && col < 7) {
			cells[row][col].setBackground(color);
		}
	}

	/**
	 * Resets the background color of all cells to white.
	 */
	public void resetCells() {
		for (JButton[] cell : cells) {
			for (JButton element : cell) {
				element.setBackground(Color.WHITE);
			}
		}
	}
}
