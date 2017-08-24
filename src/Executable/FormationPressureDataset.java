package Executable;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * Created by Bryan on 4/11/2017.
 */
public class FormationPressureDataset {

    public XYSeriesCollection formationPressureDataset(double sigmaV, double sigmah, double porePressure, double depth, double mudweightPsi,double criticalCollapsePresure,double criticalFracturePresure){

        double sigmaVPressure = sigmaV*depth;
        double sigmahPressure = sigmah*depth;
        double mudWeightPressure = mudweightPsi*depth;

        final XYSeries collapsePressureLine = new XYSeries("Critical Borehole Collapse Pressure");
        collapsePressureLine.add(0,porePressure);
        collapsePressureLine.add(criticalCollapsePresure,0);

        final XYSeries hydrostaticLine = new XYSeries("Hydrostatic Pressure");
        hydrostaticLine.add(0,porePressure);
        hydrostaticLine.add(porePressure,0);


        final XYSeries minimumFractureLine = new XYSeries("Minimum Horizontal Fracture Pressure");

        minimumFractureLine.add(0,porePressure);
        minimumFractureLine.add(sigmahPressure,0);

        final XYSeries maximumFractureLine = new XYSeries("Critical Borehole Fracture Pressure");

        maximumFractureLine.add(0,porePressure);
        maximumFractureLine.add(criticalFracturePresure,0);



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
        dataset.addSeries(collapsePressureLine);

        return dataset;
    }
}
