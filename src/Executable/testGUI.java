package Executable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created by bryan on 10/17/2016.
 */
public class testGUI extends JFrame{
    public JPanel mainPanel;
    public JLabel testLabel;
    public JMenuBar barTest;
    public JMenu menuTest;
    public JMenuItem clickMe;




    //Constructor
    public testGUI(){

        //build the dropdown menu bar
        barTest = new JMenuBar();
        menuTest = new JMenu("Tester");
        menuTest.addSeparator();


        clickMe = new JMenuItem("Click Me");


        //add the actionListener
        clickMe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = "hi";
                testLabel.setText(text);
                System.out.println(testLabel.getText());
                validate();

            }
        });

        //populate the menubar
        menuTest.add(clickMe);
        barTest.add(menuTest);

        // set the JmenuBar to the JFrame;
        testGUI.this.setJMenuBar(barTest);

    }

    //constructs the GUI
    public void initialize(){

        //set objects to a main panel
        testGUI.this.setContentPane(new testGUI().mainPanel);

        //center GUI location
        testGUI.this.setLocationRelativeTo(null);
        testGUI.this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //pack the GUI
        testGUI.this.pack();
        testGUI.this.setVisible(true);
    }

    public static void main(String[] args) {
        testGUI frame = new testGUI();
        frame.initialize();
    }
}
