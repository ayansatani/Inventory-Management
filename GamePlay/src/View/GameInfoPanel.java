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
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Represents a panel to display game information, including player names and
 * timers.
 */
public class GameInfoPanel extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JLabel player1NameLabel;
	private JLabel player2NameLabel;
	private JLabel player1TimerLabel;
	private JLabel player2TimerLabel;
	private Timer player1Timer;
	private Timer player2Timer;

	/**
	 * Constructs a GameInfoPanel.
	 */
	public GameInfoPanel() {
		setPreferredSize(new Dimension(300, 170));
		setLayout(new GridBagLayout());
		setBackground(new Color(0, 162, 232));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(5, 5, 5, 5);

		// Player 1 name label
		JLabel player1Label = new JLabel("Player 1 Name:");
		player1Label.setForeground(new Color(0, 0, 0));
		player1Label.setFont(new Font("Cooper Black", Font.PLAIN, 18));
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(player1Label, gbc);

		player1NameLabel = new JLabel(); // Display player 1 name
		player1NameLabel.setForeground(new Color(0, 0, 0));
		player1NameLabel.setFont(new Font("Cooper Black", Font.PLAIN, 18));
		gbc.gridx = 1;
		gbc.gridy = 0;
		add(player1NameLabel, gbc);

		// Player 2 name label
		JLabel player2Label = new JLabel("Player 2 Name:");
		player2Label.setForeground(new Color(0, 0, 0));
		player2Label.setFont(new Font("Cooper Black", Font.PLAIN, 18));
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(player2Label, gbc);

		player2NameLabel = new JLabel(); // Display player 2 name
		player2NameLabel.setForeground(new Color(0, 0, 0));
		player2NameLabel.setFont(new Font("Cooper Black", Font.PLAIN, 18));
		gbc.gridx = 1;
		gbc.gridy = 1;
		add(player2NameLabel, gbc);

		// Player 1 timer label
		JLabel player1TimerTextLabel = new JLabel("Player 1 Time:");
		player1TimerTextLabel.setForeground(new Color(0, 0, 0));
		player1TimerTextLabel.setFont(new Font("Cooper Black", Font.PLAIN, 18));
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(player1TimerTextLabel, gbc);

		player1TimerLabel = new JLabel("00:00");
		player1TimerLabel.setForeground(new Color(0, 0, 0));
		player1TimerLabel.setFont(new Font("Cooper Black", Font.PLAIN, 18));
		gbc.gridx = 1;
		gbc.gridy = 2;
		add(player1TimerLabel, gbc);

		// Player 2 timer label
		JLabel player2TimerTextLabel = new JLabel("Player 2 Time:");
		player2TimerTextLabel.setForeground(new Color(0, 0, 0));
		player2TimerTextLabel.setFont(new Font("Cooper Black", Font.PLAIN, 18));
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(player2TimerTextLabel, gbc);

		player2TimerLabel = new JLabel("00:00");
		player2TimerLabel.setForeground(new Color(0, 0, 0));
		player2TimerLabel.setFont(new Font("Cooper Black", Font.PLAIN, 18));
		gbc.gridx = 1;
		gbc.gridy = 3;
		add(player2TimerLabel, gbc);

		// Initialize timers
		player1Timer = new Timer(1000, new TimerActionListener(player1TimerLabel));
		player2Timer = new Timer(1000, new TimerActionListener(player2TimerLabel));
	}

	/**
	 * Sets the player names.
	 *
	 * @param player1Name The name of player 1.
	 * @param player2Name The name of player 2.
	 */
	public void setPlayerNames(String player1Name, String player2Name) {
		player1NameLabel.setText(player1Name);
		player2NameLabel.setText(player2Name);
	}

	/**
	 * Starts player 1 timer.
	 */
	public void startPlayer1Timer() {
		player1Timer.start();
	}

	/**
	 * Stops player 1 timer.
	 */
	public void stopPlayer1Timer() {
		player1Timer.stop();
	}

	/**
	 * Starts player 2 timer.
	 */
	public void startPlayer2Timer() {
		player2Timer.start();
	}

	/**
	 * Stops player 2 timer.
	 */
	public void stopPlayer2Timer() {
		player2Timer.stop();
	}

	/**
	 * Resets the timers.
	 */
	public void resetTimer() {
		player1Timer.stop();
		player2Timer.stop();
		player1Timer = new Timer(1000, new TimerActionListener(player1TimerLabel));
		player2Timer = new Timer(1000, new TimerActionListener(player2TimerLabel));
	}

	private class TimerActionListener implements ActionListener {
		private int secondsRemaining = 60;
		private JLabel timerLabel;

		public TimerActionListener(JLabel timerLabel) {
			this.timerLabel = timerLabel;
			updateTimerLabel();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			secondsRemaining--;
			updateTimerLabel();
			if (secondsRemaining <= 0) {
				((Timer) e.getSource()).stop(); // Stop the timer when it reaches 0
				// You can add additional actions here when the timer reaches 0
			}
		}

		private void updateTimerLabel() {
			int minutes = secondsRemaining / 60;
			int seconds = secondsRemaining % 60;
			timerLabel.setText(String.format("%02d:%02d", minutes, seconds));
		}
	}
}
