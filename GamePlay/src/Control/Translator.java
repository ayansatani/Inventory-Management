package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Class responsible for handling translations in the application.
 */
public class Translator {
    private ResourceBundle resourceBundle;

    /**
     * Constructs a Translator and loads the default resource bundle (Language.properties).
     */
    public Translator() {
        resourceBundle = ResourceBundle.getBundle("Control.Language");
    }

    /**
     * Translates a key to the specified language.
     *
     * @param key    The key to translate.
     * @param locale The locale representing the language.
     * @return The translated text.
     */
    public String translate(String key, Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("Control.Language", locale);
        return bundle.getString(key);
    }

    /**
     * Switches the language to French by loading the French resource bundle.
     */
    public void switchToFrench() {
        Locale frenchLocale = new Locale("fr", "FR");
        resourceBundle = ResourceBundle.getBundle("Control.Language", frenchLocale);
    }

    /**
     * Updates all UI components with translated text.
     *
     * @param panel The JPanel containing UI components to be updated.
     */
    public void updateUI(javax.swing.JPanel panel) {
        for (java.awt.Component component : panel.getComponents()) {
            if (component instanceof javax.swing.AbstractButton) {
                javax.swing.AbstractButton button = (javax.swing.AbstractButton) component;
                String key = button.getText();
                button.setText(resourceBundle.getString(key));
            } else if (component instanceof javax.swing.JLabel) {
                javax.swing.JLabel label = (javax.swing.JLabel) component;
                String key = label.getText();
                label.setText(resourceBundle.getString(key));
            } else if (component instanceof View.ChatHead) {
                View.ChatHead chatHead = (View.ChatHead) component;
                chatHead.updateLabelText(resourceBundle.getString("Chat"));
            }
        }
    }

    /**
     * ActionListener for the Translate button.
     *
     * @param panel The JPanel containing UI components to be updated.
     * @return The ActionListener for the Translate button.
     */
    public ActionListener getTranslateActionListener(javax.swing.JPanel panel) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchToFrench();
                updateUI(panel);
            }
        };
    }
}
