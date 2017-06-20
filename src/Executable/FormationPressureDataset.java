package Executable;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * Created by Bryan on 4/11/2017.
 */
public class FormationPressureDataset {

    public XYSeriesCollection formationPressureDataset(double sigmaV, double sigmaH, double sigmah, double porePressure, double depth, double mudweightPsi, double tensileStrength,double criticalFailurePressure){

        double sigmaVPressure = sigmaV*depth;
        double sigmaHPressure = sigmaH*depth;
        double sigmahPressure = sigmah*depth;
        double mudWeightPressure = mudweightPsi*depth;

        final XYSeries hydrostaticLine = new XYSeries("Hydrostatic Pressure");
        hydrostaticLine.add(0,porePressure);
        hydrostaticLine.add(porePressure,0);


        final XYSeries minimumFractureLine = new XYSeries("Minimum Horizontal Fracture Pressure");

        minimumFractureLine.add(0,porePressure);
        minimumFractureLine.add(sigmahPressure,0);

        final XYSeries maximumFractureLine = new XYSeries("Critical Wellbore Failure Pressure");

        maximumFractureLine.add(0,porePressure);
        maximumFractureLine.add(criticalFailurePressure,0);



        final XYSeries lithostaticLine = new XYSeries("Lithostatic Pressure");

        lithostaticLine.add(0,porePressure);
        lithostaticLine.add(sigmaVPressure,0);

        final XYSeries mudweightLine = new XYSeries("Actual Pressure");

        mudweightLine.add(0,porePressure);
        mudweightLine.add(mudWeightPressure,0);



        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries((mudweightLine));
        dataset.addSeries((hydrostaticLine));
        dataset.addSeries(minimumFractureLine);
        dataset.addSeries((maximumFractureLine));
        dataset.addSeries((lithostaticLine));

        return dataset;
    }
}
