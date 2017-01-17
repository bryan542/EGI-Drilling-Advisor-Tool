package Executable;

import org.jfree.chart.ChartPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StressPolygonDialog extends JDialog {
    private JPanel contentPane;
    private JPanel stressPolygonMainPanel;

    public StressPolygonDialog() {



    }
    public void initialize(ChartPanel polygonGraph){

        stressPolygonMainPanel.setLayout(new java.awt.BorderLayout());
        stressPolygonMainPanel.add(polygonGraph,BorderLayout.CENTER);
        stressPolygonMainPanel.validate();
        setResizable(false); //removes the corner imageicon
        setContentPane(stressPolygonMainPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Stress Polygon Graph");
    }
}
