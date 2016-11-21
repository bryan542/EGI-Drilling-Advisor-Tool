package Executable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;

public class AboutDialog extends JDialog {
    private JPanel contentPane;
    private JButton OKButton;
    private JLabel EGIAboutIconLabel;
    private JLabel versionLabel;
    private JLabel createdLabel;

    public AboutDialog(String versionNumber) {

        setResizable(false); // removes the default java imageicon

        //Set Image Icon
        URL urlEGIAbout = mainWindow.class.getResource("/Images/About EGI Image.png");
        ImageIcon bgEGIAbout = new ImageIcon(urlEGIAbout);
        ImageResize Test1 = new ImageResize();
        bgEGIAbout =Test1.getScaledImage(bgEGIAbout,450,125);
        EGIAboutIconLabel.setIcon(bgEGIAbout);
        EGIAboutIconLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
            }
        });

        versionLabel.setText("Version: "+versionNumber);

        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String createdDate = Integer.toString(year)+"."+Integer.toString(month)+"."+Integer.toString(day);

        createdLabel.setText("Created: "+createdDate);


    }


    public void initialize(){

        setContentPane(contentPane);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("EGI Exploration Tool");

    }
}
