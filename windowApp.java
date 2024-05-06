package languageApp;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.LayoutManager;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class windowApp extends JFrame {
    private static final long serialVersionUID = 1L;
    private menu mainMenu;
    JButton button;

    public windowApp() throws HeadlessException {
        this.setLayout(new BorderLayout());
        this.setSize(1200, 700);
        this.setTitle("Language Change App");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        mainMenu = new menu(Locale.getDefault()); // Default locale
        this.setJMenuBar(mainMenu);

        button = new JButton(mainMenu.messages.getString("panel.button"));
        this.add(button, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                windowApp window = new windowApp();
                window.setVisible(true);
            }
        });
    }
    
    public void updateButtonText() {
		button.setText(mainMenu.messages.getString("panel.button"));
    }
    
}
