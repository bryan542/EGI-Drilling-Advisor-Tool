package Executable;

import javax.swing.*;
import java.awt.event.*;
import java.net.URL;

public class GSIDialog extends JDialog {
    public JPanel contentPane;
    private JLabel GSILabel;
    private JPanel GSIMainPanel;


    public GSIDialog() {

        setResizable(false); //removes the corner imageicon

        //Set GSI Image on the GSI Button
        URL urlGSI = mainWindow.class.getResource("/Images/GSIImage.png");
        ImageIcon bgGSI = new ImageIcon(urlGSI);
        GSILabel.setIcon(bgGSI);

    }

}
