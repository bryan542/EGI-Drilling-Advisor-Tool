package Executable;

import org.jfree.chart.ChartPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MohrCoulombDialog extends JDialog {
    private JPanel contentPane;
    private JPanel mohrCoulombMainPanel;


    public MohrCoulombDialog() {

    }
    public void initialize(ChartPanel MohrGraphOutput){

        mohrCoulombMainPanel.setLayout(new java.awt.BorderLayout());
        mohrCoulombMainPanel.add(MohrGraphOutput, BorderLayout.CENTER);
        mohrCoulombMainPanel.validate();
        setResizable(false); //removes the corner imageicon
        setContentPane( mohrCoulombMainPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Mohr-Coulomb Graph");
    }
}
