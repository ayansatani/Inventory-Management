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
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Control.MenuController;
import Control.Translator;

/**
 * Represents a panel for displaying menu options.
 */
public class MenuPanel extends JPanel {
	/**
	 * Serial UID for MenuPanel class
	 */
	private static final long serialVersionUID = 1L;
	private boolean isPlayer1Turn = true;
	private GameInfoPanel gameInfoPanel;

	/**
	 * Constructs a MenuPanel.
	 *
	 * @param menuController The controller for menu actions.
	 * @param translator     The translator for language translation.
	 */
	public MenuPanel(MenuController menuController, Translator translator, GameInfoPanel gameInfoPanel) {
		setBackground(new Color(0, 162, 232));
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setPreferredSize(new Dimension(140, 475));

		JLabel menuLabel = new JLabel("Menu");
		menuLabel.setForeground(new Color(0, 0, 0));
		menuLabel.setFont(new Font("Cooper Black", Font.BOLD, 40));
		add(menuLabel);
		add(newLinePanel());

		addButton("Play Again", menuController.getResetGameActionListener());

		addButton("Pause", e -> {
			gameInfoPanel.stopPlayer1Timer();
			gameInfoPanel.stopPlayer2Timer();
		});

		this.gameInfoPanel = gameInfoPanel;

		addButton("Resume", e -> {
			// Stop the timer of the other player
			if (isPlayer1Turn) {
				gameInfoPanel.stopPlayer2Timer();
				gameInfoPanel.startPlayer1Timer();
			} else {
				gameInfoPanel.stopPlayer1Timer();
				gameInfoPanel.startPlayer2Timer();
			}
		});

		addButton("Restart", menuController.getResetGameActionListener());
		addButton("Translate", translator.getTranslateActionListener(this));
		addButtonWithAction("Help", menuController.getHelpActionListener());
		addButtonWithAction("About", menuController.getAboutActionListener());
		addButtonWithAction("Exit", menuController.getExitActionListener());
	}

	private void addButton(String text, ActionListener actionListener) {
		JButton button = new JButton(text);
		customizeButton(button);
		button.addActionListener(actionListener);
		add(button);
		add(newLinePanel());
	}

	private void addButtonWithAction(String text, ActionListener actionListener) {
		JButton button = new JButton(text);
		customizeButton(button);
		button.addActionListener(actionListener);
		add(button);
		add(newLinePanel());
	}

	private void customizeButton(JButton button) {
		button.setFocusable(false);
		button.setFont(new Font("Cooper Black", Font.PLAIN, 18));
		button.setBackground(new Color(0, 162, 232));
		button.setForeground(new Color(0, 0, 0));
		button.setBorder(null);
	}

	private JPanel newLinePanel() {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(140, 10));
		panel.setOpaque(false);
		return panel;
	}
}
