package Executable;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.util.ShapeUtilities;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Bryan on 4/11/2017.
 */
public class FormationPressureGraph extends JPanel {

    private ChartPanel chartPanel;

    /**
     * Create the panel.
     */
    public  FormationPressureGraph(XYDataset dataset, mainWindow mw, String pressureType) {
        SpringLayout springLayout = new SpringLayout();
        setLayout(springLayout);
        String xAxisLabel = "";
        String yAxisLabel = "";
        if(pressureType == "psi"){
            xAxisLabel = "Mudweight Pressure (psi)";
            yAxisLabel = "Pore Pressure (psi)";
        }
        else if (pressureType == "Pa" || pressureType == "kPa"){
            xAxisLabel = "Mudweight Pressure (kPa)";
            yAxisLabel = "Pore Pressure (kPa)";
        }

        JFreeChart lineChart = ChartFactory.createXYLineChart(
                "Pressure Regime Graph",      // chart title
                xAxisLabel,                      // x axis label
                yAxisLabel,            // y axis label
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
        XYPlot plot = (XYPlot) lineChart.getXYPlot();

        //Sets grid background and dashed line color
        plot.setDomainGridlinePaint(Color.BLACK);
        plot.setRangeGridlinePaint(Color.BLACK);
        plot.setBackgroundPaint(Color.WHITE);

        // Adds the plot marker
        XYLineAndShapeRenderer dotRenderer = new XYLineAndShapeRenderer();


        //Line Colors
        plot.getRenderer().setSeriesPaint(0,Color.black);
        plot.getRenderer().setSeriesPaint(1,Color.green);
        plot.getRenderer().setSeriesPaint(2,Color.blue);
        plot.getRenderer().setSeriesPaint(3,Color.magenta);
        plot.getRenderer().setSeriesPaint(4,Color.red);
        plot.getRenderer().setSeriesPaint(5,Color.yellow);

        //This builds the dashed lines
        final BasicStroke dashedStroke = new BasicStroke(
                2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                1.0f, new float[] {6.0f, 6.0f}, 0.0f);

        //set the lines that are dashed
        plot.getRenderer().setSeriesStroke(1,dashedStroke);
        plot.getRenderer().setSeriesStroke(2,dashedStroke);
        plot.getRenderer().setSeriesStroke(3,dashedStroke);
        plot.getRenderer().setSeriesStroke(4,dashedStroke);
        plot.getRenderer().setSeriesStroke(5,dashedStroke);


        //Thicken plot line of the actual mudweight value
        plot.getRenderer().setSeriesStroke(0,new BasicStroke(3));


        add( chartPanel );
        mw.setFormationPressureChart(lineChart);


    }
    public  ChartPanel FormationPressureGraphPanel(XYDataset dataset, mainWindow mw, String pressureType) {
        SpringLayout springLayout = new SpringLayout();
        setLayout(springLayout);
        String xAxisLabel = "";
        String yAxisLabel = "";
        if(pressureType == "psi"){
            xAxisLabel = "Mudweight Pressure (psi)";
            yAxisLabel = "Pore Pressure (psi)";
        }
        else if (pressureType == "Pa" || pressureType == "kPa"){
            xAxisLabel = "Mudweight Pressure (kPa)";
            yAxisLabel = "Pore Pressure (kPa)";
        }

        JFreeChart lineChart = ChartFactory.createXYLineChart(
                "Pressure Regime Graph",      // chart title
                xAxisLabel,                      // x axis label
                yAxisLabel,            // y axis label
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
        XYPlot plot = (XYPlot) lineChart.getXYPlot();

        //Sets grid background and dashed line color
        plot.setDomainGridlinePaint(Color.BLACK);
        plot.setRangeGridlinePaint(Color.BLACK);
        plot.setBackgroundPaint(Color.WHITE);

        // Adds the plot marker
        XYLineAndShapeRenderer dotRenderer = new XYLineAndShapeRenderer();


        //Line Colors
        plot.getRenderer().setSeriesPaint(0,Color.black);
        plot.getRenderer().setSeriesPaint(1,Color.green);
        plot.getRenderer().setSeriesPaint(2,Color.blue);
        plot.getRenderer().setSeriesPaint(3,Color.MAGENTA);
        plot.getRenderer().setSeriesPaint(4,Color.red);
        plot.getRenderer().setSeriesPaint(5,Color.yellow);

        //This builds the dashed lines
        final BasicStroke dashedStroke = new BasicStroke(
                2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                1.0f, new float[] {6.0f, 6.0f}, 0.0f);

        //set the lines that are dashed
        plot.getRenderer().setSeriesStroke(1,dashedStroke);
        plot.getRenderer().setSeriesStroke(2,dashedStroke);
        plot.getRenderer().setSeriesStroke(3,dashedStroke);
        plot.getRenderer().setSeriesStroke(4,dashedStroke);
        plot.getRenderer().setSeriesStroke(5,dashedStroke);



        //Thicken plot line of the actual mudweight value
        plot.getRenderer().setSeriesStroke(0,new BasicStroke(3));

        add( chartPanel );

        return chartPanel;

    }
}
