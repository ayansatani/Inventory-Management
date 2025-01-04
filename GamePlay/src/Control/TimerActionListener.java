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

import javax.swing.JLabel;

/**
 * ActionListener for updating a timer label.
 */
public class TimerActionListener implements ActionListener {
	private int secondsElapsed; // Variable to keep track of elapsed seconds
	private JLabel timerLabel; // Label to display the timer

	/**
	 * Constructs a TimerActionListener with the specified timer label.
	 *
	 * @param timerLabel The label to display the timer.
	 */
	public TimerActionListener(JLabel timerLabel) {
		this.timerLabel = timerLabel;
	}

	/**
	 * Called when an action occurs. Increments the elapsed time and updates the
	 * timer label.
	 *
	 * @param e The action event.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		secondsElapsed++; // Increment elapsed seconds
		int minutes = secondsElapsed / 60; // Calculate minutes
		int seconds = secondsElapsed % 60; // Calculate remaining seconds
		timerLabel.setText(String.format("%02d:%02d", minutes, seconds)); // Update timer label
	}

	/**
	 * Resets the timer to zero.
	 */
	public void resetTimer() {
		secondsElapsed = 0; // Reset elapsed seconds to zero
	}
}
