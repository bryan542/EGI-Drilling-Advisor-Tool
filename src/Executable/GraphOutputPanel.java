package Executable;


import javax.swing.JPanel;
import javax.swing.SpringLayout;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.LineBorder;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleEdge;

import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JSlider;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GraphOutputPanel extends JPanel {


    private ChartPanel chartPanel;

    /**
     * Create the panel.
     */
    public GraphOutputPanel(XYDataset dataset, mainWindow mw) {
        SpringLayout springLayout = new SpringLayout();
        setLayout(springLayout);

        JFreeChart lineChart = ChartFactory.createXYLineChart(
                "Stress Polygon Graph",      // chart title
                "σ Min (psi)",                      // x axis label
                "σ Max (psi)",            // y axis label
                dataset,                  // data
                PlotOrientation.VERTICAL,
                true,                     // include legend
                true,                     // tooltips
                false                     // urls
        );

        if (mw.getStressAutomaticRadioButton().isSelected()){

            lineChart.setTitle(mw.getPoreCombo().getSelectedItem().toString()+" Stress Polygon Graph");
        }

        chartPanel = new ChartPanel(lineChart);
        springLayout.putConstraint(SpringLayout.WEST, chartPanel, 190, SpringLayout.WEST, this);
        springLayout.putConstraint(SpringLayout.NORTH, chartPanel, 10, SpringLayout.NORTH, this);
        springLayout.putConstraint(SpringLayout.SOUTH, chartPanel, -10, SpringLayout.SOUTH, this);
        springLayout.putConstraint(SpringLayout.EAST, chartPanel, -130, SpringLayout.EAST, this); // centers the plot
        chartPanel.setPreferredSize(new Dimension(800, 800) ); // sets plot size
        chartPanel.setBackground(new java.awt.Color(0,0,0,0));
        chartPanel.setForeground(new java.awt.Color(0,0,0,0));

        lineChart.setBorderPaint(Color.BLACK);
        lineChart.setBorderVisible(true);
        LegendTitle legend = lineChart.getLegend();
        legend.setMargin(5,5,10,5);


        //Setup chart UI
        XYPlot plot = lineChart.getXYPlot();

        XYItemRenderer renderer = plot.getRenderer();
        plot.setDomainGridlinePaint(Color.BLACK);
        plot.setRangeGridlinePaint(Color.BLACK);
        plot.setBackgroundPaint(Color.WHITE);


        //Line Colors
        renderer.setSeriesPaint(0,Color.BLACK);
        plot.getRenderer().setSeriesPaint(1,Color.RED);
        plot.getRenderer().setSeriesPaint(2,Color.GREEN);
        plot.getRenderer().setSeriesPaint(3,Color.BLUE);
        plot.getRenderer().setSeriesPaint(4,Color.RED);
        plot.getRenderer().setSeriesPaint(5,Color.BLUE);
        //Hide parts of the legend
        plot.getRenderer().setSeriesVisibleInLegend(4,false);
        plot.getRenderer().setSeriesVisibleInLegend(5,false);

        //Thicken plot lines
        for(int i =0;i<plot.getSeriesCount();i++){

            plot.getRenderer().setSeriesStroke(i,new BasicStroke(3));
        }

        add( chartPanel );


    }



}
