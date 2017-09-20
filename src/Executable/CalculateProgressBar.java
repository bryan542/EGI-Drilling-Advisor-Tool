package Executable;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.beans.*;
import java.util.Random;

public class CalculateProgressBar extends JDialog   {
    private JPanel contentPane;
    private JProgressBar progressBar1;
    private JButton cancelButton;
    private JLabel progressLabel;
    private Task task;

    public CalculateProgressBar() {

        progressBar1 = new JProgressBar(0, 100);
        progressBar1.setValue(0);
        progressBar1.setStringPainted(true);









        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                //Instances of javax.swing.SwingWorker are not reusuable, so
                //we create new instances as needed.
                task = new Task();
                task.addPropertyChangeListener(new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        if ("progress" == evt.getPropertyName()) {
                            int progress = (Integer) evt.getNewValue();
                            progressBar1.setValue(progress);
                            progressLabel.setText(String.format(
                                    "Progress [%d%%}", task.getProgress()));
                        }
                    }
                });
                //task.addPropertyChangeListener(this);
                task.execute();
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }


    public void initialize(){

        setModal(true);
        setContentPane(contentPane);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Calculation Progress");
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
       CalculateProgressBar cpb = new CalculateProgressBar();
       cpb.initialize();
    }
}
