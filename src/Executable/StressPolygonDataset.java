package Executable;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * Created by bryan on 10/8/2016.
 */
public class StressPolygonDataset {

    public XYSeriesCollection stressPolygonDataset(double SigmaV,double SH, double Sh, double PorePR, double depth, double coeffFriction){

        double ShMin;
        double SHMax;
        double SHMaxDiagnolMin;
        double SHMaxDiagnolMax;
        double totalSigmaV;
        double xMarker = Sh;
        double yMarker = SH;

        double sigmaFactor = (Math.sqrt(coeffFriction*coeffFriction+1)+coeffFriction)* (Math.sqrt(coeffFriction*coeffFriction+1)+coeffFriction);
        ShMin = ((SigmaV-PorePR)*depth/sigmaFactor)+PorePR*depth;
        SHMax = sigmaFactor*(SigmaV-PorePR)*depth+PorePR*depth;
        totalSigmaV= SigmaV*depth;


        SHMaxDiagnolMin = (SigmaV/sigmaFactor-PorePR/sigmaFactor+PorePR)*depth;
        SHMaxDiagnolMax = (SigmaV*sigmaFactor-PorePR*sigmaFactor+PorePR)*depth;

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
        SigmaMinSeries.add(ShMin,SigmaV*depth);

        final XYSeries SigmaMaxnSeries = new XYSeries("Reverse Fault Boundary");

        SigmaMaxnSeries.add(SigmaV*depth,SHMax);
        SigmaMaxnSeries.add(SHMax,SHMax);

        final XYSeries SigmaMaxDiagnolSeriesHorizontal = new XYSeries("Strike-Slip Boundary2");

        SigmaMaxDiagnolSeriesHorizontal.add(ShMin,SigmaV*depth);
        SigmaMaxDiagnolSeriesHorizontal.add(SigmaV*depth,SigmaV*depth);


        final XYSeries SigmaMaxDiagnolSeriesVertical = new XYSeries("Reverse Faulting Boundary");

        SigmaMaxDiagnolSeriesVertical.add(SigmaV*depth,SigmaV*depth);
        SigmaMaxDiagnolSeriesVertical.add(SigmaV*depth,SHMax);

        final XYSeries SigmaMaxDiagnolSeries1 = new XYSeries("Strike-Slip Diagonal Boundary");

        SigmaMaxDiagnolSeries1.add(ShMin,SigmaV*depth);
        SigmaMaxDiagnolSeries1.add(SigmaV*depth,SHMax);






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
