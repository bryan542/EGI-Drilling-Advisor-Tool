package Executable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by bryan on 10/17/2016.
 */
public class testGUI extends JFrame{
    public JPanel mainPanel;
    public JLabel testLabel;
    public JMenuBar barTest;
    public JMenu menuTest;
    public JMenuItem clickMe;
    private String labelText;

private JLabel ext;

    private ActionListener action = new ActionListener()
    {
        public void actionPerformed(ActionEvent ae)
        {
            setLabelText((String) ae.getActionCommand());
            testLabel.setText(getLabelText());
        }
    };

    public void setLabelText(String labelText) {
        this.labelText = labelText;
    }


    public String getLabelText() {
        return labelText;
    }


    //Constructor
    public testGUI(){

        //build the dropdown menu bar
        barTest = new JMenuBar();
        menuTest = new JMenu("Tester");



        clickMe = new JMenuItem("Click Me");
        clickMe.setActionCommand("lols");
        clickMe.addActionListener(action);

        //add the actionListener


        //populate the menubar
        menuTest.add(clickMe);
        barTest.add(menuTest);

        // set the JmenuBar to the JFrame;
        testGUI.this.setJMenuBar(barTest);

    }

    //constructs the GUI
    public void initialize(){

        //set objects to a main panel
        testGUI.this.setContentPane(this.mainPanel);

        //center GUI location
        testGUI.this.setLocationRelativeTo(null);
        testGUI.this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //pack the GUI
        testGUI.this.pack();
        testGUI.this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){

                new testGUI().initialize();

            }
        });

    }


}
