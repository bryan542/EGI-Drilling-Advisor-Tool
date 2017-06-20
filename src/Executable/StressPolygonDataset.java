package Executable;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * Created by bryan on 10/8/2016.
 */
public class StressPolygonDataset {

    public XYSeriesCollection stressPolygonDataset(double SigmaV,double SH, double Sh, double PorePR, double depth, double coeffFriction){

        double ShMin =-1;
        double SHMax =-1;
        double SHMaxDiagnolMin;
        double SHMaxDiagnolMax;
        double totalSigmaV =-1;
        double totalPorePressure =-1;
        double xMarker = Sh;
        double yMarker = SH;

        totalSigmaV= SigmaV*depth;
        totalPorePressure = PorePR*depth;

        double sigmaFactor = Math.pow((Math.sqrt(Math.pow(coeffFriction,2)+1)+coeffFriction),2);
        ShMin = ((totalSigmaV-totalPorePressure)/sigmaFactor)+totalPorePressure;
        SHMax = sigmaFactor*(totalSigmaV-totalPorePressure)+totalPorePressure;



        final XYSeries marker = new XYSeries("Current Value");

        marker.add(xMarker,yMarker);

        final XYSeries SVLine = new XYSeries("SigmaV Line");
        SVLine.add(0.0,0.0);
        SVLine.add(ShMin,ShMin);
        SVLine.add(totalSigmaV,totalSigmaV);
        SVLine.add(SHMax,SHMax);
        SVLine.add(SHMax*1.1,SHMax*1.1);

        final XYSeries SigmaMinSeries = new XYSeries("Normal Fault Boundary");

        SigmaMinSeries.add(ShMin,ShMin);
        SigmaMinSeries.add(ShMin,totalSigmaV);

        final XYSeries SigmaMaxnSeries = new XYSeries("Reverse Fault Boundary");

        SigmaMaxnSeries.add(totalSigmaV,SHMax);
        SigmaMaxnSeries.add(SHMax,SHMax);

        final XYSeries SigmaMaxDiagnolSeriesHorizontal = new XYSeries("Strike-Slip Boundary2");

        SigmaMaxDiagnolSeriesHorizontal.add(ShMin,totalSigmaV);
        SigmaMaxDiagnolSeriesHorizontal.add(totalSigmaV,totalSigmaV);


        final XYSeries SigmaMaxDiagnolSeriesVertical = new XYSeries("Reverse Faulting Boundary");

        SigmaMaxDiagnolSeriesVertical.add(totalSigmaV,totalSigmaV);
        SigmaMaxDiagnolSeriesVertical.add(totalSigmaV,SHMax);

        final XYSeries SigmaMaxDiagnolSeries1 = new XYSeries("Strike-Slip Diagonal Boundary");

        SigmaMaxDiagnolSeries1.add(ShMin,totalSigmaV);
        SigmaMaxDiagnolSeries1.add(totalSigmaV,SHMax);






        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries((SVLine));
        dataset.addSeries((SigmaMinSeries));
        dataset.addSeries(SigmaMaxDiagnolSeries1);
        dataset.addSeries((SigmaMaxDiagnolSeriesVertical));
        dataset.addSeries((SigmaMaxDiagnolSeriesHorizontal));
        dataset.addSeries((SigmaMaxnSeries));
        dataset.addSeries(marker);

        return dataset;
    }
}
