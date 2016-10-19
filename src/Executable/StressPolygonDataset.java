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

        ShMin = (SigmaV/3.1)+PorePR*depth;
        SHMax = SigmaV*3.1-PorePR*depth;
        SHMaxDiagnolMin = (SHMax+depth*PorePR)/3.1+depth*PorePR;
        SHMaxDiagnolMax = SigmaV+PorePR*depth;

        final XYSeries SVLine = new XYSeries("SigmaV Line");
        SVLine.add(0.0,0.0);
        SVLine.add(ShMin,ShMin);
        SVLine.add(SHMax,SHMax);
        SVLine.add(SHMax*1.1,SHMax*1.1);

        final XYSeries SigmaMinSeries = new XYSeries("Normal Fault Boundary");
        SigmaMinSeries.add(ShMin,ShMin);
        SigmaMinSeries.add(ShMin,SHMaxDiagnolMax);

        final XYSeries SigmaMaxDiagnolSeries = new XYSeries("Strike-Slip Boundary");

        SigmaMaxDiagnolSeries.add(ShMin,SHMaxDiagnolMax);
        SigmaMaxDiagnolSeries.add(SHMaxDiagnolMin,SHMax);

        final XYSeries SigmaMaxnSeries = new XYSeries("Reverse Fault Boundary");
        SigmaMaxnSeries.add(SHMaxDiagnolMax,SHMax);
        SigmaMaxnSeries.add(SHMax,SHMax);

        final XYSeries DiagnolHorizontal = new XYSeries("Boundary 1");
        DiagnolHorizontal.add(ShMin,SHMaxDiagnolMax);
        DiagnolHorizontal.add(SHMaxDiagnolMin,SHMaxDiagnolMax);

        final XYSeries DiagnolVertical = new XYSeries("Boundary 2");
        DiagnolVertical.add(SHMaxDiagnolMin,SHMaxDiagnolMax);
        DiagnolVertical.add(SHMaxDiagnolMin,SHMax);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries((SVLine));
        dataset.addSeries((SigmaMinSeries));
        dataset.addSeries((SigmaMaxDiagnolSeries));
        dataset.addSeries((SigmaMaxnSeries));
        dataset.addSeries(DiagnolHorizontal);
        dataset.addSeries(DiagnolVertical);

        return dataset;
    }
}
