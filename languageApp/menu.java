package languageApp;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
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



    public menu(String lang, Locale locale) {
        messages = ResourceBundle.getBundle("messages_"+lang, locale);
        
        /*
        ResourceBundle bundle = ResourceBundle.getBundle("messages_en");
        String chartMenu = bundle.getString("menu.chart");
        System.out.println(chartMenu);
        */

        JMenu file = new JMenu(messages.getString("menu.file"));
        JMenu chart = new JMenu(messages.getString("menu.chart"));
        JMenu language = new JMenu(messages.getString("menu.language"));
        file.setName("file");
        chart.setName("chart");
        language.setName("language");

        JMenuItem plItem = new JMenuItem(messages.getString("menu.language.polish"));
        JMenuItem enItem = new JMenuItem(messages.getString("menu.language.english"));
        language.add(plItem);
        language.add(enItem);
        plItem.setName("polish");
        enItem.setName("english");

        JMenu help = new JMenu(messages.getString("menu.help"));
        JMenuItem description = new JMenuItem(messages.getString("menu.help.description"));
        help.setName("help");
        description.setName("description");
        description.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, messages.getString("menu.help.description.dialog"));
            }
        });
        help.add(description);

        JMenuItem save = new JMenuItem(messages.getString("menu.file.save"));
        JMenuItem close = new JMenuItem(messages.getString("menu.file.close"));
        save.setName("save");
        close.setName("close");
        file.add(save);
        file.add(close);

        JMenuItem drawChart = new JMenuItem(messages.getString("menu.chart.draw"));
        drawChart.setName("draw");
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
                changeLanguage("pl", new Locale("pl", "PL"));
            }
        });

        enItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeLanguage("en", new Locale("en", "US"));
            }
        });
//        plItem.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//            	messages = ResourceBundle.getBundle("messages_pl", locale);
//            	System.out.println(messages.getString("menu.file"));
//                setLocale(new Locale("pl", "PL"));
//            	updateInterface("pl");
//            }
//        });
//
//        enItem.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//            	messages = ResourceBundle.getBundle("messages_en", locale);
//            	System.out.println(messages.getString("menu.file"));
//                setLocale(new Locale("en", "US"));
//            	updateInterface("en");
//            }
//        });
    }
        

    public void updateInterface(String lang) {
//    	SwingUtilities.updateComponentTreeUI(this);
//    	this.revalidate();
//    	this.repaint();
//    	System.out.println("update");
//        windowApp updatedWindowApp = new windowApp(lang);
//        updatedWindowApp.setVisible(true);
//    	//removeAll();

    }
    public void changeLanguage(String lang, Locale locale) {
        messages = ResourceBundle.getBundle("messages_" + lang, locale);


        for (Component component : this.getComponents()) {
            System.out.println(component.getName());
            if (component instanceof JMenu) {
                JMenu menu = (JMenu) component;
                System.out.println(menu.getName());
                menu.setText(messages.getString("menu." + menu.getName()));
                for (Component menuItemComponent : menu.getMenuComponents()) {
                    if (menuItemComponent instanceof JMenuItem) {
                        JMenuItem menuItem = (JMenuItem) menuItemComponent;
                        menuItem.setText(messages.getString("menu." + menu.getName() + "." + menuItem.getName()));
                    }
                }
            }
        }


        SwingUtilities.updateComponentTreeUI(this);
    }


}
    
