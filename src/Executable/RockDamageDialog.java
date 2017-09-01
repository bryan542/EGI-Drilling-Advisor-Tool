package Executable;

import javax.swing.*;
import java.awt.event.*;
import java.net.URL;

public class RockDamageDialog extends JDialog {
    private JPanel contentRockPane;
    private JPanel rockDamageMainPanel;
    private JLabel rockDamageLabel;
    private JButton buttonOK;
    private JButton buttonCancel;

    public RockDamageDialog() {

        setResizable(false); //removes the corner imageicon

        //Set rock damage image
        URL urlRock = mainWindow.class.getResource("/Images/Rock Damage Table.png");
        ImageIcon bgRock = new ImageIcon(urlRock);
        rockDamageLabel.setIcon(bgRock);

    }

    public void initialize(){

        setModal(true);
        setContentPane(contentRockPane);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Rock Damage Table");
        pack();
        setLocationRelativeTo(null);
        setVisible(true);


    }
    public JPanel getContentPane(){

        return contentRockPane;
    }

}
