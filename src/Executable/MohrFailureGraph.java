package Executable;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.title.LegendTitle;
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
        springLayout.putConstraint(SpringLayout.WEST, chartPanel, 150, SpringLayout.WEST, this);
        springLayout.putConstraint(SpringLayout.EAST, chartPanel, -90, SpringLayout.EAST, this); // centers the plot
        springLayout.putConstraint(SpringLayout.NORTH, chartPanel, 10, SpringLayout.NORTH, this);
        springLayout.putConstraint(SpringLayout.SOUTH, chartPanel, -10, SpringLayout.SOUTH, this);

        // sets plot size
        chartPanel.setPreferredSize(new Dimension(800, 800) );

        //setup plot border
        lineChart.setBorderPaint(Color.BLACK);
        lineChart.setBorderStroke(new BasicStroke(1));
        lineChart.setBorderVisible(true);

        //Set legend position
        LegendTitle legend = lineChart.getLegend();
        legend.setMargin(5,5,10,5);

        //Setup chart UI
        XYPlot plot = lineChart.getXYPlot();
        XYItemRenderer renderer = plot.getRenderer();

        //Sets grid background and dashed line color
        plot.setDomainGridlinePaint(Color.BLACK);
        plot.setRangeGridlinePaint(Color.BLACK);
        plot.setBackgroundPaint(Color.WHITE);

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
