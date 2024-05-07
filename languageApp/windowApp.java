package languageApp;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class windowApp extends JFrame {
    private static final long serialVersionUID = 1L;
    private menu mainMenu;
    JButton button;

    public windowApp(String lang) throws HeadlessException {
        this.setLayout(new BorderLayout());
        this.setSize(1200, 700);
        this.setTitle("Language Change App");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        mainMenu = new menu(lang, getLocale()); // Default locale
        this.setJMenuBar(mainMenu);

        button = new JButton(mainMenu.messages.getString("panel.button"));
        this.add(button, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                windowApp window = new windowApp("pl");
                window.setVisible(true);
            }
        });
    }
    
    public void updateButtonText() {
		button.setText(mainMenu.messages.getString("panel.button"));
    }
    
}
