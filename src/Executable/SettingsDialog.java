package Executable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bryan on 10/14/2016.
 */
public final class SettingsDialog extends JDialog {

    private JLabel label;
    private JTextField field = new JTextField(15);
    private JButton acceptButton = new JButton("Accept");
    private JButton button = new JButton("Close");
    private String s = "";

    public SettingsDialog(mainWindow frame, boolean modal, JLabel label) {
        super(frame, modal);

        this.label = label;

        setLayout(new BorderLayout());
        add(field, BorderLayout.NORTH);
        add(button,BorderLayout.EAST);
        add(acceptButton,BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(frame);

        field.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                s = field.getText();
                label.setText("Message from Settings Dialog: " + s);
            }
        });
        acceptButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                s = field.getText();
                label.setText( s);
            }
        });
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                SettingsDialog.this.setVisible(false);
            }
        });
    }
}
