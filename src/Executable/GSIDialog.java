package Executable;

import javax.swing.*;
import java.awt.event.*;
import java.net.URL;

public class GSIDialog extends JDialog {
    public JPanel contentPane;
    private JLabel GSILabel;
    private JPanel GSIMainPanel;


    public GSIDialog() {

//Set Image Icon
        URL url = mainWindow.class.getResource("EGI.png");
        ImageIcon bg = new ImageIcon(url);
        this.setIconImage(bg.getImage());

        ImageIcon bgGSI = new ImageIcon(getClass().getResource(("GSIImage.png")));
        GSILabel.setIcon(bgGSI);


        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    public void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        GSIDialog dialog = new GSIDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
