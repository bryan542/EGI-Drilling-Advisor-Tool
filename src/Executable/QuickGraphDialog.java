package Executable;

import org.jfree.chart.ChartPanel;

import javax.swing.*;
import java.awt.*;

public class QuickGraphDialog extends JDialog {
    private JPanel contentPane;
    private JPanel mainPanel;


    public QuickGraphDialog() {

    }
    public void initialize(ChartPanel chartPanelInput){

        mainPanel.setLayout(new java.awt.BorderLayout());
        mainPanel.add(chartPanelInput, BorderLayout.CENTER);
        mainPanel.validate();

        setResizable(false); //removes the corner imageicon
        setContentPane(mainPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }
}
