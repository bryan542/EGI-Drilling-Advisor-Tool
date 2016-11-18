package Executable;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * Created by bryan on 10/8/2016.
 */
public class MohrDataset {

    public XYSeriesCollection mohrDatasetBuild(double sigma1,double sigma2, double sigma3,double cohesionInitial){

        int Sigma1int = (int) sigma1;
        int Sigma2int = (int) sigma2;
        int Sigma3int = (int) sigma3;


        double MohryValue;
        double MohrxValue;
        double FailureyValue;
        double FailurexValue;
        double diameter;
        double radius;
        double midpoint;

        final XYSeries CohesionLine = new XYSeries("Failure Envelope");


        for (int i = 0;i<Sigma3int;i++){
            FailurexValue = (double) i;
            FailureyValue = 0.6*FailurexValue+cohesionInitial;
            CohesionLine.add(FailurexValue,FailureyValue);

        }


        final XYSeries Sigma3MohrLine = new XYSeries("σ3 Mohr Circle");
        for (int i=Sigma1int;i<=Sigma3int;i++){

            diameter = sigma3-sigma1;
            radius = diameter/2;
            midpoint = radius+sigma1;
            MohrxValue = (double) i;
            MohryValue = Math.sqrt(radius*radius-(MohrxValue-midpoint)*(MohrxValue-midpoint));
            if (Double.isNaN(MohryValue)){
                MohryValue = 0;
            }
            Sigma3MohrLine.add(MohrxValue,MohryValue);

        }

        final XYSeries Sigma2MohrLine = new XYSeries("σ2 Mohr Circle");
        for (int i=Sigma1int;i<=Sigma2int;i++){

            diameter = sigma2-sigma1;
            radius = diameter/2;
            midpoint = radius+sigma1;
            MohrxValue = (double) i;
            MohryValue = Math.sqrt(radius*radius-(MohrxValue-midpoint)*(MohrxValue-midpoint));
            if (Double.isNaN(MohryValue)){
                MohryValue = 0;
            }
            Sigma2MohrLine.add(MohrxValue,MohryValue);
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries((Sigma2MohrLine));
        dataset.addSeries((Sigma3MohrLine));
        dataset.addSeries(CohesionLine);

        return dataset;
    }
}
