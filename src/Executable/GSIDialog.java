package Executable;

import javax.swing.*;
import java.awt.event.*;
import java.net.URL;

public class GSIDialog extends JDialog {
    private JPanel contentPane;
    private JLabel GSILabel;
    private JPanel GSIMainPanel;


    public GSIDialog() {

        setResizable(false); //removes the corner imageicon

        //Set GSI Image on the GSI Button
        URL urlGSI = mainWindow.class.getResource("/Images/GSIImage.png");
        ImageIcon bgGSI = new ImageIcon(urlGSI);
        GSILabel.setIcon(bgGSI);

    }

    public void initialize(){

        setModal(true);
        setContentPane(contentPane);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("GSI Table");
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }
    public JPanel getContentPane(){

        return contentPane;
    }
}
