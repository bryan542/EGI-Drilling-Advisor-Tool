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
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.ShapeUtilities;

import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JSlider;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StressPolygonGraph extends JPanel {


    private ChartPanel chartPanel;

    /**
     * Create the panel.
     */
    public  StressPolygonGraph(XYDataset dataset, mainWindow mw) {
        SpringLayout springLayout = new SpringLayout();
        setLayout(springLayout);

        JFreeChart lineChart = ChartFactory.createXYLineChart(
                "Stress Polygon Graph",      // chart title
                "Sh Min (psi)",                      // x axis label
                "SH Max (psi)",            // y axis label
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
        XYPlot plot = (XYPlot) lineChart.getXYPlot();

        //Sets grid background and dashed line color
        plot.setDomainGridlinePaint(Color.BLACK);
        plot.setRangeGridlinePaint(Color.BLACK);
        plot.setBackgroundPaint(Color.WHITE);

        // Adds the plot marker
        XYLineAndShapeRenderer dotRenderer = new XYLineAndShapeRenderer();

        // sets up the marker properly to tell us what boundary we are in
        dotRenderer.setSeriesLinesVisible(6,false);
        dotRenderer.setSeriesShape(6,ShapeUtilities.createUpTriangle(4));
        dotRenderer.setSeriesShapesVisible(0,false);
        dotRenderer.setSeriesShapesVisible(1,false);
        dotRenderer.setSeriesShapesVisible(2,false);
        dotRenderer.setSeriesShapesVisible(3,false);
        dotRenderer.setSeriesShapesVisible(4,false);
        dotRenderer.setSeriesShapesVisible(5,false);
        dotRenderer.setSeriesShapesVisible(6,true);
        plot.setRenderer(dotRenderer);

        //Line Colors
        plot.getRenderer().setSeriesPaint(0,Color.darkGray);
        plot.getRenderer().setSeriesPaint(1,Color.RED);
        plot.getRenderer().setSeriesPaint(2,Color.GREEN);
        plot.getRenderer().setSeriesPaint(3,Color.BLUE);
        plot.getRenderer().setSeriesPaint(4,Color.RED);
        plot.getRenderer().setSeriesPaint(5,Color.BLUE);
        plot.getRenderer().setSeriesPaint(6,Color.BLACK);
        //Hide parts of the legend
        plot.getRenderer().setSeriesVisibleInLegend(0,false);
        plot.getRenderer().setSeriesVisibleInLegend(4,false);
        plot.getRenderer().setSeriesVisibleInLegend(5,false);



        //Thicken plot lines
        for(int i =0;i<plot.getSeriesCount();i++){

            plot.getRenderer().setSeriesStroke(i,new BasicStroke(3));
        }

        add( chartPanel );


    }
    public  ChartPanel StressPolygonGraphPanel(XYDataset dataset, mainWindow mw) {
        SpringLayout springLayout = new SpringLayout();
        setLayout(springLayout);

        JFreeChart lineChart = ChartFactory.createXYLineChart(
                "Stress Polygon Graph",      // chart title
                "Sh Min (psi)",                      // x axis label
                "SH Max (psi)",            // y axis label
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
        XYPlot plot = (XYPlot) lineChart.getXYPlot();

        //Sets grid background and dashed line color
        plot.setDomainGridlinePaint(Color.BLACK);
        plot.setRangeGridlinePaint(Color.BLACK);
        plot.setBackgroundPaint(Color.WHITE);

        // Adds the plot marker
        XYLineAndShapeRenderer dotRenderer = new XYLineAndShapeRenderer();

        // sets up the marker properly to tell us what boundary we are in
        dotRenderer.setSeriesLinesVisible(6,false);
        dotRenderer.setSeriesShape(6,ShapeUtilities.createUpTriangle(4));
        dotRenderer.setSeriesShapesVisible(0,false);
        dotRenderer.setSeriesShapesVisible(1,false);
        dotRenderer.setSeriesShapesVisible(2,false);
        dotRenderer.setSeriesShapesVisible(3,false);
        dotRenderer.setSeriesShapesVisible(4,false);
        dotRenderer.setSeriesShapesVisible(5,false);
        dotRenderer.setSeriesShapesVisible(6,true);
        plot.setRenderer(dotRenderer);

        //Line Colors
        plot.getRenderer().setSeriesPaint(0,Color.darkGray);
        plot.getRenderer().setSeriesPaint(1,Color.RED);
        plot.getRenderer().setSeriesPaint(2,Color.GREEN);
        plot.getRenderer().setSeriesPaint(3,Color.BLUE);
        plot.getRenderer().setSeriesPaint(4,Color.RED);
        plot.getRenderer().setSeriesPaint(5,Color.BLUE);
        plot.getRenderer().setSeriesPaint(6,Color.BLACK);
        //Hide parts of the legend
        plot.getRenderer().setSeriesVisibleInLegend(0,false);
        plot.getRenderer().setSeriesVisibleInLegend(4,false);
        plot.getRenderer().setSeriesVisibleInLegend(5,false);



        //Thicken plot lines
        for(int i =0;i<plot.getSeriesCount();i++){

            plot.getRenderer().setSeriesStroke(i,new BasicStroke(3));
        }

        add( chartPanel );

        return chartPanel;

    }

}
