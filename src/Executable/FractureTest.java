package Executable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Bryan on 2/22/2017.
 */
public class FractureTest {

    double slickWater = 0;
    double hybrid = 0;
    double xlinked = 0;
    double volumeHigh = 0;
    double volumeMed = 0;
    double volumeLow = 0;
    double lossHigh = 0;
    double lossMedium = 0;
    double lossLow = 0;
    double treatRateHigh = 0;
    double treatRateMed = 0;
    double treatRateLow = 0;
    double fracPressureHigh = 0;
    double fracPressureMed = 0;
    double fracPressureLow = 0;
    double proppantConcHigh = 0;
    double proppantConcMed = 0;
    double proppantConcLow = 0;
    double propSize100 = 0;
    double propSizeHybrid = 0;
    double propSize2040 = 0;
    double propDensityHigh = 0;
    double propDensityMed = 0;
    double propDensityLow = 0;
    double propVolumeHigh = 0;
    double propVolumeMed = 0;
    double propVolumeLow = 0;
    double fracGeometryComplex = 0;
    double fracGeometryModerate = 0;
    double fracGeometryPlanar = 0;
    double fracHeightHigh= 0;
    double fracHeightModerate = 0;
    double fracHeightSmall = 0;
    double fracLengthLong = 0;
    double fracLengthModerate = 0;
    double fracLengthShort = 0;

    public void brittleValues(double brittleness){

        if (brittleness >= 0.7){

            this.slickWater = this.slickWater+0.2;
            this.volumeHigh = this.volumeHigh+1;
            this.lossHigh = this.lossHigh+1;
            this.fracPressureHigh = this.fracPressureHigh+1;
            this.proppantConcLow = this.proppantConcLow+1;
            this.propSize100 = this.propSize100+1;
            this.propDensityLow = this.propDensityLow+1;
            this.propVolumeHigh = this.propVolumeHigh+.5;
            this.fracGeometryComplex = this.fracGeometryComplex+1;
            this.fracHeightHigh = this.fracHeightHigh+1;
            this.fracLengthShort = this.fracLengthShort+0;
        }
        else if (brittleness >= 0.6 && brittleness < 0.7){

            this.slickWater = this.slickWater+0.3;
            this.volumeHigh = this.volumeHigh+1;
            this.lossHigh = this.lossHigh+1;
            this.fracPressureHigh = this.fracPressureHigh+1;
            this.proppantConcLow = this.proppantConcLow+1;
            this.propSize100 = this.propSize100+1;
            this.propDensityLow = this.propDensityLow+1;
            this.propVolumeHigh = this.propVolumeHigh+.5;
            this.fracGeometryComplex = this.fracGeometryComplex+1;
            this.fracHeightHigh = this.fracHeightHigh+0.8;
            this.fracLengthShort = this.fracLengthShort+0.2;

        }
        else if (brittleness >= 0.5 && brittleness < 0.6){

            this.hybrid = this.hybrid+0.5;
            this.volumeMed = this.volumeMed+.75;
            this.lossMedium = this.lossMedium+1;
            this.fracPressureMed = this.fracPressureMed+0.75;
            this.proppantConcMed = this.proppantConcMed+0.75;
            this.propSizeHybrid = this.propSizeHybrid+0.75;
            this.propDensityMed = this.propDensityMed+0.75;
            this.propVolumeMed = this.propVolumeMed+.5;
            this.fracGeometryModerate = this.fracGeometryModerate+0.75;
            this.fracHeightModerate = this.fracHeightModerate+0.6;
            this.fracLengthModerate = this.fracLengthModerate+0.4;

        }
        else if (brittleness >= 0.4 && brittleness < 0.5){

            this.hybrid = this.hybrid+0.6;
            this.volumeMed = this.volumeMed+.75;
            this.lossMedium = this.lossMedium+1;
            this.fracPressureMed = this.fracPressureMed+0.75;
            this.proppantConcMed = this.proppantConcMed+0.5;
            this.propSizeHybrid = this.propSizeHybrid+0.5;
            this.propDensityMed = this.propDensityMed+0.75;
            this.propVolumeMed = this.propVolumeMed+.5;
            this.fracGeometryModerate = this.fracGeometryModerate+0.75;
            this.fracHeightModerate = this.fracHeightModerate+0.5;
            this.fracLengthModerate = this.fracLengthModerate+0.5;

        }
        else if (brittleness >= 0.3 && brittleness < 0.4){

            this.xlinked = this.xlinked+0.7;
            this.volumeLow = this.volumeLow+1;
            this.lossLow = this.lossLow+1;
            this.fracPressureLow = this.fracPressureLow+0.5;
            this.proppantConcHigh = this.proppantConcHigh+0.75;
            this.propSize2040 = this.propSize2040+0.75;
            this.propDensityHigh = this.propDensityHigh+0.75;
            this.propVolumeLow = this.propVolumeLow+.5;
            this.fracGeometryPlanar = this.fracGeometryPlanar+1;
            this.fracHeightSmall = this.fracHeightSmall+0.4;
            this.fracLengthLong = this.fracLengthLong+0.6;
        }
        else if (brittleness >= 0.2 && brittleness < 0.3){

            this.xlinked = this.xlinked+0.8;
            this.volumeLow = this.volumeLow+1;
            this.lossLow = this.lossLow+1;
            this.fracPressureLow = this.fracPressureLow+0.5;
            this.proppantConcHigh = this.proppantConcHigh+0.75;
            this.propSize2040 = this.propSize2040+0.75;
            this.propDensityHigh = this.propDensityHigh+0.75;
            this.propVolumeLow = this.propVolumeLow+.5;
            this.fracGeometryPlanar = this.fracGeometryPlanar+1;
            this.fracHeightSmall = this.fracHeightSmall+0.2;
            this.fracLengthLong = this.fracLengthLong+0.8;

        }
        else if (brittleness >= 0 && brittleness < 2){

            this.xlinked = this.xlinked+0.9;
            this.volumeLow = this.volumeLow+1;
            this.lossLow = this.lossLow+1;
            this.fracPressureLow = this.fracPressureLow+0.5;
            this.proppantConcHigh = this.proppantConcHigh+0.75;
            this.propSize2040 = this.propSize2040+1;
            this.propDensityHigh = this.propDensityHigh+0.75;
            this.propVolumeLow = this.propVolumeLow+.5;
            this.fracGeometryPlanar = this.fracGeometryPlanar+1;
            this.fracHeightSmall = this.fracHeightSmall+0;
            this.fracLengthLong = this.fracLengthLong+1;
        }
    }
    public void youngValues(double youngModulus){

        if (youngModulus >= 7e6){

            this.slickWater = this.slickWater+0.2;
            this.volumeHigh = this.volumeHigh+1;
            this.lossHigh = this.lossHigh+1;
            this.fracPressureHigh = this.fracPressureHigh+1;
            this.proppantConcLow = this.proppantConcLow+1;
            this.propSize100 = this.propSize100+1;
            this.propDensityLow = this.propDensityLow+1;
            this.propVolumeHigh = this.propVolumeHigh+.5;
            this.fracGeometryComplex = this.fracGeometryComplex+1;
            this.fracHeightHigh = this.fracHeightHigh+1;
            this.fracLengthShort = this.fracLengthShort+0;
        }
        else if (youngModulus >= 6e6 && youngModulus < 7e6){

            this.slickWater = this.slickWater+0.3;
            this.volumeHigh = this.volumeHigh+1;
            this.lossHigh = this.lossHigh+1;
            this.fracPressureHigh = this.fracPressureHigh+1;
            this.proppantConcLow = this.proppantConcLow+1;
            this.propSize100 = this.propSize100+1;
            this.propDensityLow = this.propDensityLow+1;
            this.propVolumeHigh = this.propVolumeHigh+.5;
            this.fracGeometryComplex = this.fracGeometryComplex+1;
            this.fracHeightHigh = this.fracHeightHigh+0.8;
            this.fracLengthShort = this.fracLengthShort+0.2;

        }
        else if (youngModulus >= 5e6 && youngModulus < 6e6){

            this.hybrid = this.hybrid+0.5;
            this.volumeMed = this.volumeMed+.75;
            this.lossMedium = this.lossMedium+1;
            this.fracPressureMed = this.fracPressureMed+0.75;
            this.proppantConcMed = this.proppantConcMed+0.75;
            this.propSizeHybrid = this.propSizeHybrid+0.75;
            this.propDensityMed = this.propDensityMed+0.75;
            this.propVolumeMed = this.propVolumeMed+.5;
            this.fracGeometryModerate = this.fracGeometryModerate+0.75;
            this.fracHeightModerate = this.fracHeightModerate+0.6;
            this.fracLengthModerate = this.fracLengthModerate+0.4;

        }
        else if (youngModulus >= 4e6 && youngModulus < 5e6){

            this.hybrid = this.hybrid+0.6;
            this.volumeMed = this.volumeMed+.75;
            this.lossMedium = this.lossMedium+1;
            this.fracPressureMed = this.fracPressureMed+0.75;
            this.proppantConcMed = this.proppantConcMed+0.5;
            this.propSizeHybrid = this.propSizeHybrid+0.5;
            this.propDensityMed = this.propDensityMed+0.75;
            this.propVolumeMed = this.propVolumeMed+.5;
            this.fracGeometryModerate = this.fracGeometryModerate+0.75;
            this.fracHeightModerate = this.fracHeightModerate+0.5;
            this.fracLengthModerate = this.fracLengthModerate+0.5;

        }
        else if (youngModulus >= 3e6 && youngModulus < 4e6){

            this.xlinked = this.xlinked+0.7;
            this.volumeLow = this.volumeLow+1;
            this.lossLow = this.lossLow+1;
            this.fracPressureLow = this.fracPressureLow+0.5;
            this.proppantConcHigh = this.proppantConcHigh+0.75;
            this.propSize2040 = this.propSize2040+0.75;
            this.propDensityHigh = this.propDensityHigh+0.75;
            this.propVolumeLow = this.propVolumeLow+.5;
            this.fracGeometryPlanar = this.fracGeometryPlanar+1;
            this.fracHeightSmall = this.fracHeightSmall+0.4;
            this.fracLengthLong = this.fracLengthLong+0.6;

        } else if (youngModulus >= 2e6 && youngModulus < 3e6){

            this.xlinked = this.xlinked+0.8;
            this.volumeLow = this.volumeLow+1;
            this.lossLow = this.lossLow+1;
            this.fracPressureLow = this.fracPressureLow+0.5;
            this.proppantConcHigh = this.proppantConcHigh+0.75;
            this.propSize2040 = this.propSize2040+0.75;
            this.propDensityHigh = this.propDensityHigh+0.75;
            this.propVolumeLow = this.propVolumeLow+.5;
            this.fracGeometryPlanar = this.fracGeometryPlanar+1;
            this.fracHeightSmall = this.fracHeightSmall+0.2;
            this.fracLengthLong = this.fracLengthLong+0.8;

        }
        else if (youngModulus >= 0 && youngModulus < 2e6){

            this.xlinked = this.xlinked+0.9;
            this.volumeLow = this.volumeLow+1;
            this.lossLow = this.lossLow+1;
            this.fracPressureLow = this.fracPressureLow+0.5;
            this.proppantConcHigh = this.proppantConcHigh+0.75;
            this.propSize2040 = this.propSize2040+1;
            this.propDensityHigh = this.propDensityHigh+0.75;
            this.propVolumeLow = this.propVolumeLow+.5;
            this.fracGeometryPlanar = this.fracGeometryPlanar+1;
            this.fracHeightSmall = this.fracHeightSmall+0;
            this.fracLengthLong = this.fracLengthLong+1;

        }


    }
    public void valueCalculationReport(){

        double[] fluidSystem = {this.slickWater,this.hybrid,this.xlinked};
        double[] fluidVolume = {this.volumeHigh,this.volumeMed,this.volumeLow};
        double[] fluidLoss = {this.lossHigh,this.lossMedium,this.lossLow};
        double[] fracPresure = {this.fracPressureHigh,this.fracPressureMed,this.fracPressureLow};
        double[] proppantConcentration = {this.proppantConcHigh,this.proppantConcMed,this.proppantConcLow};
        double[] proppantDensity = {this.propDensityHigh,this.propDensityMed,this.propDensityLow};
        double[] proppantVolume = {this.propVolumeHigh,this.propVolumeMed,this.propVolumeLow};
        double[] fracGeometry = {this.fracGeometryComplex,this.fracGeometryModerate,this.fracGeometryPlanar};
        double[] fracHeight = {this.fracHeightHigh,this.fracHeightModerate,this.fracHeightSmall};
        double[] fracLength = {this.fracLengthLong,this.fracLengthModerate,this.fracLengthModerate};
        String[] fluidSystemName = {"Slick Water","Hybrid","Cross-Linked"};
        String[] fluidVolumeName = {"High Fluid Volume","Moderate Fluid Volume","Low Fluid Volume"};
        String[] fluidLossName = {"High Fluid Loss","Moderate Fluid Loss","Low Fluid Loss"};
        String[] fracPressureName = {"High Fracture Pressure","Moderate Fracture Pressure","Low Fracture Pressure"};
        String[] proppantConcentrationName = {"High Proppant Concentration","Moderate Proppant Concentration","Low Proppant Concentration"};
        String[] proppantDensityName = {"High Proppant Density","Moderate Proppant Density","Low Proppant Density"};
        String[] proppantVolumeName = {"High Proppant Volume","Moderate Proppant Volume","Low Proppant Volume"};
        Arrays.sort(fluidSystem);
        Arrays.sort(fluidVolume);
        Arrays.sort(fluidLoss);
        Arrays.sort(fracPresure);
        Arrays.sort(proppantConcentration);
        Arrays.sort(proppantDensity);
        Arrays.sort(proppantVolume);
        Arrays.sort(fracGeometry);
        Arrays.sort(fracHeight);
        Arrays.sort(fracLength);

        System.out.println("");
        System.out.println("Fluid Type: " + fluidSystem[2]);
        System.out.println("Fluid Volume: " + fluidVolume[2]);
        System.out.println("Fluid Loss: " + fluidLoss[2]);
        System.out.println("Fracture Pressure: " + fracPresure[2]);
        System.out.println("Proppant Concentration: " + proppantConcentration[2]);
        System.out.println("Proppant Density: " + proppantDensity[2]);
        System.out.println("Proppant Volume: " + proppantVolume[2]);
        System.out.println("Fracture Geometry: " + fracGeometry[2]);
        System.out.println("Fracture Height: " + fracHeight[2]);
        System.out.println("Fracture Length: " + fracLength[2]);
    }
    public void reportValues(){

        System.out.println("SlickWater: " +Double.toString(slickWater));
        System.out.println("Hybrid: " + Double.toString(hybrid));
        System.out.println("Cross-Linked: " + Double.toString(xlinked));
        System.out.println("High Volume: " + Double.toString(volumeHigh));
        System.out.println("Moderate Volume: " + Double.toString(volumeMed));
        System.out.println("Low Volume: " + Double.toString(volumeLow));
        System.out.println("High Fluid Loss: " + Double.toString(lossHigh));
        System.out.println("Moderate Fluid Loss: " + Double.toString(lossMedium));
        System.out.println("Low Fluid Loss: " + Double.toString(lossLow));
        System.out.println("High Fracture Pressure: " + Double.toString(fracPressureHigh));
        System.out.println("Moderate Fracture Pressure: " + Double.toString(fracPressureMed));
        System.out.println("Low Fracture Pressure: " + Double.toString(fracPressureLow));
        System.out.println("High Proppant Concentration: " + Double.toString(proppantConcHigh));
        System.out.println("Moderate Proppant Concentration: " + Double.toString(proppantConcMed));
        System.out.println("Low Proppant Concentration: " + Double.toString(proppantConcLow));
        System.out.println("Mesh size 40/70 or 100: " + Double.toString(propSize100));
        System.out.println("Hybrid Mesh: " + Double.toString(propSizeHybrid));
        System.out.println("Mesh size 20/40: " + Double.toString(propSize2040));
        System.out.println("High Proppant Density: " + Double.toString(propDensityHigh));
        System.out.println("Moderate Proppant Density: " + Double.toString(propDensityMed));
        System.out.println("Low Proppant Density: " + Double.toString(propDensityLow));
        System.out.println("High Proppant Volume: " + Double.toString(propVolumeHigh));
        System.out.println("Moderate Proppant Volume: " + Double.toString(propVolumeMed));
        System.out.println("Low Proppant Volume: " + Double.toString(propVolumeLow));
        System.out.println("Complex Fracture Geometry: " + Double.toString(fracGeometryComplex));
        System.out.println("Moderately Complex Fracture Geometry: " + Double.toString(fracGeometryModerate));
        System.out.println("Planar Fracture Geometry: " + Double.toString(fracGeometryPlanar));
        System.out.println("Fracture Height High: " + Double.toString(fracHeightHigh));
        System.out.println("Fracture Height Moderate: " + Double.toString(fracHeightModerate));
        System.out.println("Fracture Height Low: " + Double.toString(fracHeightSmall));
        System.out.println("Fracture Length High: " + Double.toString(fracLengthLong));
        System.out.println("Fracture Length Moderate: " + Double.toString(fracLengthModerate));
        System.out.println("Fracture Length Low: " + Double.toString(fracLengthShort));



    }
    public static void main(String[] args) {

        FractureTest ft = new FractureTest();

        ft.brittleValues(.4);
        ft.youngValues(5e6);
        ft.reportValues();
        ft.valueCalculationReport();
    }
}

