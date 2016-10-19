package Executable;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYDataset;

import javax.swing.*;
import java.awt.*;

public class MohrFailureGraph extends JPanel {


    private ChartPanel chartPanel;

    /**
     * Create the panel.
     */
    public MohrFailureGraph(XYDataset dataset) {
        SpringLayout springLayout = new SpringLayout();
        setLayout(springLayout);

        JFreeChart lineChart = ChartFactory.createXYLineChart(
                "Mohr-Coulomb Failure Graph",      // chart title
                "σn (psi)",                      // x axis label
                "τ (psi)",            // y axis label
                dataset,                  // data
                PlotOrientation.VERTICAL,
                true,                     // include legend
                true,                     // tooltips
                false                     // urls
        );
        chartPanel = new ChartPanel(lineChart);
        springLayout.putConstraint(SpringLayout.WEST, chartPanel, 10, SpringLayout.WEST, this);
        springLayout.putConstraint(SpringLayout.SOUTH, chartPanel, -55, SpringLayout.SOUTH, this);
        springLayout.putConstraint(SpringLayout.EAST, chartPanel, -10, SpringLayout.EAST, this);
        chartPanel.setPreferredSize(new Dimension(662, 662) );
        chartPanel.setBackground(new Color(0,0,0,0));
        chartPanel.setForeground(new Color(0,0,0,0));

        //Setup chart UI
        XYPlot plot = lineChart.getXYPlot();
        XYItemRenderer renderer = plot.getRenderer();

        //Line Colors
        plot.getRenderer().setSeriesPaint(0,Color.RED);
        plot.getRenderer().setSeriesPaint(1,Color.BLUE);
        plot.getRenderer().setSeriesPaint(2,Color.BLACK);


        //Thicken plot lines
        for(int i =0;i<plot.getSeriesCount();i++){

            plot.getRenderer().setSeriesStroke(i,new BasicStroke(2));
        }

        add( chartPanel );


    }



}
