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
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Represents the title bar of the Connect Four game window.
 */
public class TitleBar extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a TitleBar panel.
	 */
	public TitleBar() {
		setBackground(new Color(0, 162, 232));
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

		setLayout(new FlowLayout(FlowLayout.CENTER));

		setPreferredSize(new Dimension(940, 143));

		JLabel titleBar = new JLabel("Connect 4");
		titleBar.setForeground(new Color(0, 0, 0));
		titleBar.setFont(new Font("Cooper Black", Font.BOLD, 70));
		add(titleBar);
	}
}
