package Executable;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;
import java.awt.*;

/**
 * Created by bryan on 3/10/2017.
 */
public class ShearFailureRatioBarGraph extends JPanel {

    private ChartPanel chartPanel;

    /**
     * Create the panel.
     */
    public ShearFailureRatioBarGraph(DefaultCategoryDataset dataset, mainWindow mw, String gradientType) {
        SpringLayout springLayout = new SpringLayout();
        setLayout(springLayout);
        String xAxisLabel = "";
        String yAxisLabel = "Failure Ratio";
        if(gradientType == "psi/ft"){
            xAxisLabel = "Sigma H Max (psi/ft)";
        }
        else if (gradientType == "Pa/m" || gradientType == "kPa/m"){
            xAxisLabel = "sigX Max (kPa/m)";
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Shear Failure Ratio",      // chart title
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

        CategoryPlot plot = barChart.getCategoryPlot();

        //This builds the dashed lines
        final BasicStroke dashedStroke = new BasicStroke(
                2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                1.0f, new float[] {6.0f, 6.0f}, 0.0f);

        //This valuemarker sets the horizontal line in the shear graph at the failure line, 1.0
        ValueMarker VM = new ValueMarker(1.0);
        VM.setOutlinePaint(Color.black);
        VM.setPaint(Color.black);
        VM.setStroke(dashedStroke);
        plot.addRangeMarker(VM);


        NumberAxis range = (NumberAxis) plot.getRangeAxis();
        double maxFailureValue = -1;

        for (int i = 0 ; i<dataset.getColumnCount();i++){


           if (maxFailureValue < (double) dataset.getValue(0,i)){

               maxFailureValue = (double) dataset.getValue(0,i);
           }
        }

        if( maxFailureValue < 1 ){

            range.setRange(0, 2 );

        }


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
            xAxisLabel = "sigX Max (kPa/m)";
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Shear Failure Ratio",      // chart title
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

        CategoryPlot plot = barChart.getCategoryPlot();

        //This builds the dashed lines
        final BasicStroke dashedStroke = new BasicStroke(
                2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                1.0f, new float[] {6.0f, 6.0f}, 0.0f);

        //This valuemarker sets the horizontal line in the shear graph at the failure line, 1.0
        ValueMarker VM = new ValueMarker(1.0);
        VM.setOutlinePaint(Color.black);
        VM.setPaint(Color.black);
        VM.setStroke(dashedStroke);
        plot.addRangeMarker(VM);

        // sometimes the dotted line on the graph isn't shown and this makes sure you will always see it if the ratio is
        // below 1.0
        NumberAxis range = (NumberAxis) plot.getRangeAxis();
        double maxFailureValue = -1;

        for (int i = 0 ; i<dataset.getColumnCount();i++){


            if (maxFailureValue < (double) dataset.getValue(0,i)){

                maxFailureValue = (double) dataset.getValue(0,i);
            }
        }

        if( maxFailureValue < 1 ){

            range.setRange(0, 2 );

        }

        add( chartPanel );

        return chartPanel;

    }

}
