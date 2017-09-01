package Executable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

public class AboutDialog extends JDialog {
    private JPanel contentPane;
    private JButton OKButton;
    private JLabel EGIAboutIconLabel;
    private JLabel versionLabel;
    private JLabel createdLabel;

    public AboutDialog(String versionNumber) {

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        setResizable(false); // removes the default java imageicon

        //Set Image Icon
        URL urlEGIAbout = mainWindow.class.getResource("/Images/About EGI Image.png");
        ImageIcon bgEGIAbout = new ImageIcon(urlEGIAbout);
        ImageResize Test1 = new ImageResize();
        bgEGIAbout =Test1.getScaledImage(bgEGIAbout,450,115);
        EGIAboutIconLabel.setIcon(bgEGIAbout);
        EGIAboutIconLabel.setBorder(BorderFactory.createLineBorder(Color.black));

        //closes the JDialog panel
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
            }
        });

        //grabs the version number defined in mainWindow class
        versionLabel.setText("Version: "+versionNumber);

        //sets the created date of this verison. Need to manually update this
        String createdDate = "11.21.2016";
        createdLabel.setText("Created: "+createdDate);


    }



    public void initialize(){

        setContentPane(contentPane);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }
}
