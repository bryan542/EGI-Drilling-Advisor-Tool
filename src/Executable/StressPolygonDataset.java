package Executable;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * Created by bryan on 10/8/2016.
 */
public class StressPolygonDataset {

    public XYSeriesCollection stressPolygonDataset(double SigmaV, double PorePR, double depth){

        double ShMin;
        double SHMax;
        double SHMaxDiagnolMin;
        double SHMaxDiagnolMax;

        double coeffFriction = (Math.sqrt(.6*.6+1)+.6)* (Math.sqrt(.6*.6+1)+.6);
        ShMin = ((SigmaV-PorePR)*depth/coeffFriction)+PorePR*depth;
        SHMax = coeffFriction*(SigmaV-PorePR)*depth+PorePR*depth;


        SHMaxDiagnolMin = (SigmaV/coeffFriction-PorePR/coeffFriction+PorePR)*depth;
        SHMaxDiagnolMax = (SigmaV*coeffFriction-PorePR*coeffFriction+PorePR)*depth;


        final XYSeries SVLine = new XYSeries("SigmaV Line");
        SVLine.add(0.0,0.0);
        SVLine.add(ShMin,ShMin);
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


        return dataset;
    }
}
