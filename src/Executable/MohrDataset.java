package Executable;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.util.Arrays;

/**
 * Created by bryan on 10/8/2016.
 */
public class MohrDataset {

    public XYSeriesCollection mohrDatasetBuild(double sigma1,double sigma2, double sigma3,double cohesionInitial){

        double[] stressesMaxMin = {sigma1,sigma2,sigma3};
        Arrays.sort(stressesMaxMin);
        int Sigma1int = (int) stressesMaxMin[2];
        int Sigma2int = (int) stressesMaxMin[1];
        int Sigma3int = (int) stressesMaxMin[0];


        double MohryValue;
        double MohrxValue;
        double FailureyValue;
        double FailurexValue;
        double diameter;
        double radius;
        double midpoint;
        double coeffFriction = 0.6;
        final XYSeries CohesionLine = new XYSeries("Failure Envelope");

        if(Sigma2int < 0) {
            for (int i = Sigma3int; i < Sigma1int; i++) {
                FailurexValue = (double) i;
                FailureyValue = coeffFriction * FailurexValue + cohesionInitial;
                CohesionLine.add(FailurexValue, FailureyValue);

            }
        }
        else{
            for (int i = 0; i < Sigma1int; i++) {
                FailurexValue = (double) i;
                FailureyValue = coeffFriction * FailurexValue + cohesionInitial;
                CohesionLine.add(FailurexValue, FailureyValue);
            }
        }

        final XYSeries Sigma3MohrLine = new XYSeries("σ3 Mohr Circle");
        for (int i=Sigma3int;i<=Sigma1int;i++){

            diameter = sigma1-sigma3;
            radius = diameter/2;
            midpoint = radius+sigma3;
            MohrxValue = (double) i;
            MohryValue = Math.sqrt(radius*radius-(MohrxValue-midpoint)*(MohrxValue-midpoint));
            if (Double.isNaN(MohryValue)){
                MohryValue = 0;
            }
            Sigma3MohrLine.add(MohrxValue,MohryValue);

        }

        /*
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
*/
        XYSeriesCollection dataset = new XYSeriesCollection();
       // dataset.addSeries((Sigma2MohrLine));
        dataset.addSeries((Sigma3MohrLine));
        dataset.addSeries(CohesionLine);

        return dataset;
    }
}
