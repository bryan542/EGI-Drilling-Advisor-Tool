package Executable;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.util.Arrays;

/**
 * Created by bryan on 10/8/2016.
 */
public class MohrDataset {

    public XYSeriesCollection mohrDatasetBuild(double sigma1,double sigma2, double sigma3,double cohesionInitial, double coeffFrictionInput, mainWindow mw){

        double porePressureCombination = mw.getPorePressureCombinationFinal();
        double[] stressesMaxMinEffective = {sigma1-porePressureCombination,sigma2-porePressureCombination,sigma3-porePressureCombination};
        Arrays.sort(stressesMaxMinEffective);

        double sigma1mohr = stressesMaxMinEffective[2];
        double sigma2mohr = stressesMaxMinEffective[1];
        double sigma3mohr = stressesMaxMinEffective[0];
        int Sigma1int = (int) stressesMaxMinEffective[2];
        int Sigma2int = (int) stressesMaxMinEffective[1];
        int Sigma3int = (int) stressesMaxMinEffective[0];

        double MohryValue = -1;
        double MohrxValue = -1;
        double FailureyValue = -1;
        double FailurexValue = -1;
        double diameter;
        double radius;
        double midpoint;
        double coeffFriction = coeffFrictionInput;
        // used to find the zero root for the failure line
        double loopStart = -1*cohesionInitial/coeffFriction;
        int loopRange = (int) loopStart;

        //First mohr element x value
        int mohrxInitial = -1;
        int failurexInitial = -1;

        final XYSeries CohesionLine = new XYSeries("Failure Envelope");

        // makes sure the failure line is within the bounds of the failure circle
        if(Sigma3int < loopRange){

            loopRange = Sigma3int;
        }

        //Finding the failure criterion line
        for (int i = 0; i < Sigma1int; i++) {
            FailurexValue = (double) i;
            FailureyValue = coeffFriction * FailurexValue + cohesionInitial;
            CohesionLine.add(FailurexValue, FailureyValue);
        }


        final XYSeries Sigma3MohrLine = new XYSeries("σ3 Mohr Circle");
        for (int i=Sigma3int;i<=Sigma1int;i++){

            diameter = sigma1mohr-sigma3mohr;
            radius = diameter/2;
            midpoint = radius+sigma3mohr;
            MohrxValue = (double) i;
            MohryValue = Math.sqrt(Math.pow(radius,2)-Math.pow(MohrxValue-midpoint,2));
            if (Double.isNaN(MohryValue)){
                MohryValue = 0;
            }
            Sigma3MohrLine.add(MohrxValue,MohryValue);

        }

        mohrxInitial = Sigma3MohrLine.getDataItem(0).getX().intValue();

        //searches for the x-value to align the faliure curve to the Mohr curve.
        if(Sigma3MohrLine.getDataItem(0).getX().intValue()   < 0){

            for(int j = 0; j <= Sigma3MohrLine.getItemCount()-1;j++){

                if(Sigma3MohrLine.getDataItem(j).getX().intValue() == 0){

                    mohrxInitial = j;
                    break;
                }

            }
            failurexInitial = 0;
        }
        else if (Sigma3MohrLine.getDataItem(0).getX().intValue() >= 0){

            for(int j = 0; j <= CohesionLine.getItemCount()-1;j++){

                if(CohesionLine.getDataItem(j).getX().intValue() == Sigma3MohrLine.getDataItem(0).getX().intValue()){

                    failurexInitial = j;
                    break;
                }

            }

            mohrxInitial = 0;
        }

        //failure criteria check between mohr and failure curve. failurexInitial is the element offset to start comparing the value analysis between the 2 curves
        for (int i = 0;i<=Sigma3MohrLine.getItemCount()-mohrxInitial-2;i++){

            if(CohesionLine.getDataItem(failurexInitial+i).getY().doubleValue() < Sigma3MohrLine.getDataItem(i+mohrxInitial).getY().doubleValue()){


                mw.setShearCondition("Shear Failure");
                break;
            }
            else{

                mw.setShearCondition("No Shear Failure");

            }
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
