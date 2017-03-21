package Executable;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
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
    public MohrFailureGraph(XYDataset dataset, double Sigma1, double Sigma2, String pressureType, mainWindow mw) {
        SpringLayout springLayout = new SpringLayout();
        setLayout(springLayout);

        String xAxisLabel = "";
        String yAxisLabel = "";
        if(pressureType == "psi"){
            xAxisLabel = "σn (psi)";
            yAxisLabel = "τ (psi)";
        }
        else if (pressureType == "Pa" || pressureType == "kPa"){
            xAxisLabel = "σn (kPa)";
            yAxisLabel = "τ (kPa)";
        }

        JFreeChart lineChart = ChartFactory.createXYLineChart(
                "Mohr-Coulomb Failure Graph",      // chart title
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
        XYPlot plot = lineChart.getXYPlot();
        XYItemRenderer renderer = plot.getRenderer();

        NumberAxis domain = (NumberAxis) plot.getDomainAxis();
        NumberAxis range = (NumberAxis) plot.getRangeAxis();

        if(Sigma2 < 0){
            domain.setRange(Sigma2,Sigma1);
            range.setRange(0, Sigma1-Sigma2 );
        }
        else {
            domain.setRange(0, Sigma1);
            range.setRange(0, Sigma1 );
        }



        /*
        int rangeMaxInterval = (int) Sigma1-1;
        double rangeMaxDouble = (double) mw.getMohrCollectionFinal().getY(1,rangeMaxInterval);
        int rangeMaxInt = (int) rangeMaxDouble;
        */






        //Sets grid background and dashed line color
        plot.setDomainGridlinePaint(Color.BLACK);
        plot.setRangeGridlinePaint(Color.BLACK);
        plot.setBackgroundPaint(Color.WHITE);

        //Line Colors

        plot.getRenderer().setSeriesPaint(0,Color.BLUE);
        plot.getRenderer().setSeriesPaint(1,Color.BLACK);

        //Thicken plot lines
        for(int i =0;i<plot.getSeriesCount();i++){

            plot.getRenderer().setSeriesStroke(i,new BasicStroke(2));
        }

        add( chartPanel );


    }

    public ChartPanel MohrFailureGraphPanel(XYDataset dataset, double Sigma1, double Sigma2, String pressureType) {
        SpringLayout springLayout = new SpringLayout();
        setLayout(springLayout);
        String xAxisLabel = "";
        String yAxisLabel = "";
        if(pressureType == "psi"){
            xAxisLabel = "σn (psi)";
            yAxisLabel = "τ (psi)";
        }
        else if (pressureType == "Pa" || pressureType == "kPa"){
            xAxisLabel = "σn (kPa)";
            yAxisLabel = "τ (kPa)";
        }



        JFreeChart lineChart = ChartFactory.createXYLineChart(
                "Mohr-Coulomb Failure Graph",      // chart title
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
        XYPlot plot = lineChart.getXYPlot();
        XYItemRenderer renderer = plot.getRenderer();

        NumberAxis domain = (NumberAxis) plot.getDomainAxis();
        if(Sigma2 < 0){
            domain.setRange(Sigma2,Sigma1);
        }
        else {
            domain.setRange(0, Sigma1);
        }

        NumberAxis range = (NumberAxis) plot.getRangeAxis();
        range.setRange(0,Sigma1);


        //Sets grid background and dashed line color
        plot.setDomainGridlinePaint(Color.BLACK);
        plot.setRangeGridlinePaint(Color.BLACK);
        plot.setBackgroundPaint(Color.WHITE);

        //Line Colors

        plot.getRenderer().setSeriesPaint(0,Color.BLUE);
        plot.getRenderer().setSeriesPaint(1,Color.BLACK);

        //Thicken plot lines
        for(int i =0;i<plot.getSeriesCount();i++){

            plot.getRenderer().setSeriesStroke(i,new BasicStroke(2));
        }

        add( chartPanel );

        return chartPanel;
    }
}
