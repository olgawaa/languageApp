package languageApp;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class menu extends JMenuBar {
    private static final long serialVersionUID = 1L;
    ResourceBundle messages;

    public menu(Locale locale) {
        messages = ResourceBundle.getBundle("messages_en", locale);
        
        /*
        ResourceBundle bundle = ResourceBundle.getBundle("messages_en");
        String chartMenu = bundle.getString("menu.chart");
        System.out.println(chartMenu);
        */

        JMenu file = new JMenu(messages.getString("menu.file"));
        JMenu chart = new JMenu(messages.getString("menu.chart"));
        JMenu language = new JMenu(messages.getString("menu.language"));

        JMenuItem plItem = new JMenuItem(messages.getString("menu.language.polish"));
        JMenuItem enItem = new JMenuItem(messages.getString("menu.language.english"));
        language.add(plItem);
        language.add(enItem);

        JMenu help = new JMenu(messages.getString("menu.help"));
        JMenuItem description = new JMenuItem(messages.getString("menu.help.description"));
        description.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, messages.getString("menu.help.description.dialog"));
            }
        });
        help.add(description);

        JMenuItem save = new JMenuItem(messages.getString("menu.file.save"));
        JMenuItem close = new JMenuItem(messages.getString("menu.file.close"));
        file.add(save);
        file.add(close);

        JMenuItem drawChart = new JMenuItem(messages.getString("menu.chart.draw"));
        chart.add(drawChart);

        this.add(file);
        this.add(chart);
        this.add(language);
        this.add(help);

        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        

        plItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	messages = ResourceBundle.getBundle("messages_pl", locale);
            	System.out.println(messages.getString("menu.file"));
                //setLocale(new Locale("pl", "PL"));
            	updateInterface();
            }
        });

        enItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	messages = ResourceBundle.getBundle("messages_en", locale);
            	System.out.println(messages.getString("menu.file"));
                //setLocale(new Locale("en", "US"));
            	updateInterface();
            }
        });
    }
        

    public void updateInterface() {
    	SwingUtilities.updateComponentTreeUI(this);
    	this.revalidate();
    	this.repaint();
    	//System.out.println("update");
    	//removeAll(); 
    }
    
}
    
