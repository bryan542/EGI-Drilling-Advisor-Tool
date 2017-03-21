package Executable;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.util.ShapeUtilities;

import javax.swing.*;
import java.awt.*;

/**
 * Created by bryan on 3/10/2017.
 */
public class MultivariateSolutionsGraph extends JPanel {

    private ChartPanel chartPanel;

    /**
     * Create the panel.
     */
    public  MultivariateSolutionsGraph(DefaultCategoryDataset dataset, mainWindow mw, String gradientType) {
        SpringLayout springLayout = new SpringLayout();
        setLayout(springLayout);
        String xAxisLabel = "";
        String yAxisLabel = "Failure Ratio";
        if(gradientType == "psi/ft"){
            xAxisLabel = "Sigma H Max (psi/ft)";
        }
        else if (gradientType == "Pa/m" || gradientType == "kPa/m"){
            xAxisLabel = "SH Max (kPa/m)";
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Multivariate Failure Ratio",      // chart title
                xAxisLabel,                      // x axis label
                yAxisLabel,            // y axis label
                dataset,                  // data
                PlotOrientation.VERTICAL,
                true,                     // include legend
                true,                     // tooltips
                false                     // urls
        );


        chartPanel = new ChartPanel(barChart);
        springLayout.putConstraint(SpringLayout.WEST, chartPanel, 50, SpringLayout.WEST, this);
        springLayout.putConstraint(SpringLayout.EAST, chartPanel, -50, SpringLayout.EAST, this); // centers the plot
        springLayout.putConstraint(SpringLayout.NORTH, chartPanel, 10, SpringLayout.NORTH, this);
        springLayout.putConstraint(SpringLayout.SOUTH, chartPanel, -10, SpringLayout.SOUTH, this);

        // sets plot size
        chartPanel.setPreferredSize(new Dimension(1000, 800) );

        //setup plot border
        barChart.setBorderPaint(Color.BLACK);
        barChart.setBorderStroke(new BasicStroke(1));
        barChart.setBorderVisible(true);

        //Set legend position
        LegendTitle legend = barChart.getLegend();
        legend.setMargin(5,5,10,5);


        add( chartPanel );


    }
    public  ChartPanel MultivariateSolutionsGraphPanel(DefaultCategoryDataset dataset, mainWindow mw, String gradientType) {
        SpringLayout springLayout = new SpringLayout();
        setLayout(springLayout);
        String xAxisLabel = "";
        String yAxisLabel = "Failure Ratio";
        if(gradientType == "psi/ft"){
            xAxisLabel = "Sigma H Max (psi/ft)";
        }
        else if (gradientType == "Pa/m" || gradientType == "kPa/m"){
            xAxisLabel = "SH Max (kPa/m)";
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Multivariate Failure Ratio",      // chart title
                xAxisLabel,                      // x axis label
                yAxisLabel,            // y axis label
                dataset,                  // data
                PlotOrientation.VERTICAL,
                true,                     // include legend
                true,                     // tooltips
                false                     // urls
        );


        chartPanel = new ChartPanel(barChart);
        springLayout.putConstraint(SpringLayout.WEST, chartPanel, 50, SpringLayout.WEST, this);
        springLayout.putConstraint(SpringLayout.EAST, chartPanel, -50, SpringLayout.EAST, this); // centers the plot
        springLayout.putConstraint(SpringLayout.NORTH, chartPanel, 10, SpringLayout.NORTH, this);
        springLayout.putConstraint(SpringLayout.SOUTH, chartPanel, -10, SpringLayout.SOUTH, this);

        // sets plot size
        chartPanel.setPreferredSize(new Dimension(1000, 800) );

        //setup plot border
        barChart.setBorderPaint(Color.BLACK);
        barChart.setBorderStroke(new BasicStroke(1));
        barChart.setBorderVisible(true);

        //Set legend position
        LegendTitle legend = barChart.getLegend();
        legend.setMargin(5,5,10,5);



        add( chartPanel );

        return chartPanel;

    }

}
