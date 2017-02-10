package Executable;

import javax.swing.*;
import java.awt.event.*;
import java.net.URL;

public class RockDamageDialog extends JDialog {
    private JPanel contentPane;
    private JPanel rockDamageMainPanel;
    private JLabel rockDamageLabel;
    private JButton buttonOK;
    private JButton buttonCancel;

    public RockDamageDialog() {

        setResizable(false); //removes the corner imageicon

        //Set GSI Image on the GSI Button
        URL urlGSI = mainWindow.class.getResource("/Images/Rock Damage Table.png");
        ImageIcon bgGSI = new ImageIcon(urlGSI);
        rockDamageLabel.setIcon(bgGSI);

    }

    public JPanel getContentPane(){

        return contentPane;
    }
}
