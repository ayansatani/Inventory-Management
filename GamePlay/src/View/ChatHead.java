/**
 * 
 * CET - CS Academic Level 4
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * 
 * Student Name: Ayan Satani(041089567) Guntas Singh Chugh (041091309)  
 * 
 */

package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Represents a custom panel for a chat head with a label and a text field.
 */
public class ChatHead extends JPanel {

	/**
	 * Serial UID for ChatHead class
	 */
	private static final long serialVersionUID = 1L;
	private JLabel chatHeadLabel;

	/**
	 * Constructs a ChatHead panel.
	 */
	public ChatHead() {
		setBackground(new Color(0, 162, 232));
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		setPreferredSize(new Dimension(199, 80)); // Increased height to accommodate the text field

		// Set BorderLayout for the panel
		setLayout(new BorderLayout());

		// Create JPanel for top portion with FlowLayout
		JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		topPanel.setOpaque(false); // Make it transparent

		// Add a JLabel with text and set its foreground color
		chatHeadLabel = new JLabel("Chat");
		chatHeadLabel.setForeground(Color.BLACK);
		chatHeadLabel.setFont(new Font("Cooper Black", Font.CENTER_BASELINE, 22));

		// Add the JLabel to the topPanel
		topPanel.add(chatHeadLabel);

		// Add the topPanel to the NORTH position of the BorderLayout
		add(topPanel, BorderLayout.NORTH);

		// Create and configure the JTextField
		JTextField chatBox = new JTextField("Type here...");
		chatBox.setFont(new Font("Cooper Black", Font.PLAIN, 18));
		chatBox.setForeground(Color.BLACK); // Set text color to black

		// Add focus listener to clear the pre-text when focused
		chatBox.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (chatBox.getText().equals("Type here...")) {
					chatBox.setText("");
					chatBox.setForeground(Color.BLACK); // Change text color to black
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (chatBox.getText().isEmpty()) {
					chatBox.setText("Type here...");
					chatBox.setForeground(Color.BLACK); // Set text color back to black
				}
			}
		});

		// Add the JTextField to the SOUTH position of the BorderLayout
		add(chatBox, BorderLayout.SOUTH);
	}

	/**
	 * Updates the label text.
	 *
	 * @param text The new text for the label.
	 */
	public void updateLabelText(String text) {
		chatHeadLabel.setText(text);
	}

	/**
	 * Retrieves the chat head label.
	 *
	 * @return The chat head label.
	 */
	public JLabel getChatHeadLabel() {
		return chatHeadLabel;
	}

	/**
	 * Sets the chat head label.
	 *
	 * @param chatHeadLabel The new chat head label.
	 */
	public void setChatHeadLabel(JLabel chatHeadLabel) {
		this.chatHeadLabel = chatHeadLabel;
	}
}
