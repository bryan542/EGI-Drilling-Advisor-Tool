package Executable;

import org.jfree.data.xy.XYSeries;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by bryan on 10/4/2016.
 */
public class DrillingEquations {

    private double wellRadius;
    private double wellDepth;
    private double mudWeight;
    private double coefficientFriction = 0.6;
    private double Cohesion;
    private double beta;
    private double gamma;
    private double alpha1;
    private double alpha2;
    private double alpha;
    private double theta;
    private double tensileStrength;
    private double poisson;
    private double ThoRTheta;
    private double ThoRZ;

    //Find alpha value
    public double Alpha(double alpha1, double alpha2) {

        if (alpha1 < alpha2){

            this.alpha = 360+(alpha1-alpha2);
            return this.alpha;
        }
        else {
            this.alpha = alpha1 - alpha2;
            return this.alpha;
        }
    }

    // Find stress ranges sigv, sigH, sigh

    public static double SigmaVRange(String FaultType, String PorePressureType) {
        double sigmaV;
        Random rand = new Random();

        sigmaV = .91 + (1.1 - .91) * rand.nextDouble();

        return sigmaV;

    }
    //sigX
    public static double SigmaHRange(String FaultType, String PorePressureType) {
        double sigmaH = -1;
        Random rand = new Random();

        if (PorePressureType == "Hydrostatic") {

            if (FaultType == "Normal") {

                sigmaH = .77 + (.9 - .77) * rand.nextDouble();

            } else if (FaultType == "Strike-slip") {

                sigmaH = 1.1 + (1.2 - 1.1) * rand.nextDouble();

            } else {

                sigmaH = 1.2 + (1.6 - 1.2) * rand.nextDouble();
            }
        }
        else if (PorePressureType == "Overpressure") {

            if (FaultType == "Normal") {

                sigmaH = .8 + (.9 - .8) * rand.nextDouble();

            } else if (FaultType == "Strike-slip") {

                sigmaH = 1.1 + (1.42 - 1.1) * rand.nextDouble();

            } else {

                sigmaH = 1.2 + (1.9 - 1.2) * rand.nextDouble();
            }
        }
        else if (PorePressureType == "Underpressure") {

            if (FaultType == "Normal") {

                sigmaH = .58 + (.889 - .58) * rand.nextDouble();

            } else if (FaultType == "Strike-slip") {

                sigmaH = .883 + (1.188 - .883) * rand.nextDouble();

            } else {

                sigmaH = 1.03 + (1.588 - 1.03) * rand.nextDouble();
            }
        }

        return sigmaH;
    }
    //sigY
    public static double SigmahRange(String FaultType, String PorePressureType) {
        double sigmah =-1;
        Random rand = new Random();

        if (PorePressureType == "Hydrostatic") {

            if (FaultType == "Normal") {

                sigmah = .6 + (.77 - .6) * rand.nextDouble();

            } else if (FaultType == "Strike-slip") {

                sigmah = .6 + (.8 - .6) * rand.nextDouble();

            } else {

                sigmah = 1.1 + (1.2 - 1.1) * rand.nextDouble();
            }

        }
        else if (PorePressureType == "Overpressure") {

            if (FaultType == "Normal") {

                sigmah = .72 + (.79 - .72) * rand.nextDouble();

            } else if (FaultType == "Strike-slip") {

                sigmah = .76 + (.9 - .76) * rand.nextDouble();

            } else {

                sigmah = 1 + (1.2 - 1) * rand.nextDouble();
            }
        }
        else if (PorePressureType == "Underpressure") {

            if (FaultType == "Normal") {

                sigmah = .483 + (.758 - .483) * rand.nextDouble();

            } else if (FaultType == "Strike-slip") {

                sigmah = .483 + (.788 - .483) * rand.nextDouble();

            } else {

                sigmah = .883 + (1.38 - .883) * rand.nextDouble();
            }
        }
        return sigmah;
    }

    public static double PorePressureRange(String FaultType, String PorePressureType){

        double porePR = -1;
        Random rand = new Random();

        if (PorePressureType == "Hydrostatic") {

                porePR = .43 + (.45 - .43) * rand.nextDouble();
        }
        else if (PorePressureType == "Overpressure") {

                porePR = .465 + (.9 - .465) * rand.nextDouble();
        }
        else if (PorePressureType == "Underpressure") {

            porePR = .2 + (.432 - .2) * rand.nextDouble();
        }

        return porePR;
    }
    // Sigma Values sigV, sigH, sigh

    public static double SigmaV(double depth, double SigVR, double PorePR){

        double SigmaV;
        SigmaV = depth*(SigVR);
        return SigmaV;
    }

    public static double SigmaH(double depth, double SigHR, double PorePR){

        double SigmaH;
        SigmaH = depth*(SigHR);
        return SigmaH;
    }
    public static double Sigmah(double depth, double SighR, double PorePR){

        double SigmaV;
        SigmaV = depth*(SighR);
        return SigmaV;
    }

    //Stress Tensors sigZ, sigX, and sigY
    //sigV = sigz, sigh = sigY, sigH = sigX
    public static double sigZ(double sigv, double sigH, double sigh, double gamma, double alpha){

        double sigZ;
        sigZ = sigv*Math.pow(Math.cos(Math.toRadians(gamma)),2)+sigH*Math.pow(Math.sin(Math.toRadians(gamma)),2)*Math.pow(Math.cos(Math.toRadians(alpha)),2)+sigh*Math.pow(Math.sin(Math.toRadians(gamma)),2)*Math.pow(Math.sin(Math.toRadians(alpha)),2);
        return sigZ;
    }
    //sigX
    public static double sigX(double sigv, double sigH, double sigh, double gamma, double alpha){

        double sigX;
        double cosAlphasq = Math.pow(Math.cos(Math.toRadians(alpha)),2);
        double cosGammasq = Math.pow(Math.cos(Math.toRadians(gamma)),2);
        double sinAlphasq = Math.pow(Math.sin(Math.toRadians(alpha)),2);
        double sinGammasq = Math.pow(Math.sin(Math.toRadians(gamma)),2);

        sigX = (sigH*cosAlphasq+sigh*sinAlphasq)*cosGammasq+sigv*sinGammasq;
        return sigX;
    }
    //sigY
    public static double sigY(double sigH, double sigh, double alpha){

        double sigY;
        sigY = sigH*Math.pow(Math.sin(Math.toRadians(alpha)),2)+sigh*Math.pow(Math.cos(Math.toRadians(alpha)),2);
        return sigY;
    }


    // Shear Stress Components thoXY, thoXZ, thoYZ

    //thoXY
    public static double thoXY(double sigH, double sigh, double alpha, double gamma){

        double ThoXY;

        ThoXY = -1*sigH*Math.sin(Math.toRadians(alpha))*Math.cos(Math.toRadians(alpha))*Math.cos(Math.toRadians(gamma))+sigh*Math.sin(Math.toRadians(alpha))*Math.cos(Math.toRadians(alpha))*Math.cos(Math.toRadians(gamma));

        return ThoXY;
    }

    //thoXZ
    public static double thoXZ(double sigv, double sigH, double sigh, double alpha, double gamma){

        double ThoXZ;

        ThoXZ = -1*sigv*Math.sin(Math.toRadians(gamma))*Math.cos(Math.toRadians(gamma))+sigH*Math.sin(Math.toRadians(gamma))*Math.cos(Math.toRadians(gamma))*Math.cos(Math.toRadians(alpha))*Math.cos(Math.toRadians(alpha))+sigh*Math.sin(Math.toRadians(gamma))*Math.cos(Math.toRadians(gamma))*Math.sin(Math.toRadians(alpha))*Math.sin(Math.toRadians(alpha));

        return ThoXZ;
    }

    //thoYZ
    public static double thoYZ(double sigH, double sigh, double alpha, double gamma){

        double ThoYZ;

        ThoYZ = -1*sigH*Math.sin(Math.toRadians(alpha))*Math.cos(Math.toRadians(alpha))*Math.sin(Math.toRadians(gamma))+sigh*Math.sin(Math.toRadians(alpha))*Math.cos(Math.toRadians(alpha))*Math.sin(Math.toRadians(gamma));

        return ThoYZ;
    }

    //Change in pressure calculation deltaP
    public static double deltaP(double depth, double mudWeight, double porePressure){

        double deltaP;
        deltaP = depth*(mudWeight-porePressure);
        return deltaP;
    }

    //Sigma r, radial stress
    public static double sigmaR(double wellPressure){
        double sigmaR;
        sigmaR = wellPressure;
        return sigmaR;
    }

    //Failure Angle
    public static double failureAngle(double thoxy, double sigmaX, double sigmaY ){

        double failureAngle = -1;

        //Prevents NaN return statement
        if(sigmaX -sigmaY == 0){

            failureAngle = 0;
        }
        else {

            failureAngle = Math.toDegrees(Math.atan((2 * thoxy) / (sigmaX - sigmaY))) / 2;
        }

        return failureAngle;
    }

    //SigmaTheta
    public static double sigmaTheta(double sigX, double sigY, double ThoXY,double failureAngle, double wellPressure) {

        double sigmaTheta =-1;
        sigmaTheta = sigX + sigY - 2 * (sigX - sigY) * Math.cos(Math.toRadians(2 * failureAngle)) - 4 * ThoXY * Math.sin(Math.toRadians(2 * failureAngle)) - wellPressure;

        return sigmaTheta;
    }

    // Calculate thetaZ
    public static double sigmaZ(double sigZ, double poisson, double sigY, double sigX, double ThoXY, double failureAngle){

        double sigmaZ = -1;


        sigmaZ = sigZ - 2*poisson*(sigX-sigY)*Math.cos(Math.toRadians(2*failureAngle))-4*poisson*ThoXY*Math.sin(Math.toRadians(2*failureAngle));


        return sigmaZ;
    }

    //Calculate thoThetaZ
    public static double thoThetaZ(double ThoXZ, double ThoYZ, double failureAngle){

        double ThoThetaz = -1;

        ThoThetaz = 2 * (-1 * ThoXZ * Math.sin(Math.toRadians(failureAngle)) + ThoYZ * Math.cos(Math.toRadians(failureAngle)));

        return ThoThetaz;
    }

    //Set thoRTheta
    public  double thoRTheta(){

        this.ThoRTheta = 0;
        return this.ThoRTheta;
    }

    //Set thoRZ
    public  double thoRZ(){

        this.ThoRZ = 0;
        return this.ThoRZ;
    }
    //Critical failure Pressure
    public static double criticalFailurePressure(double sigmaX, double sigmaY,double sigmaZ,double thoXY, double thoThetaZ, double porePressure,double tensileStrength, double failureAngle, double gamma) {

        double criticalPressure = -1;

        if (gamma == 0) {

            criticalPressure = 3 * sigmaY - sigmaX - porePressure + tensileStrength;
        }
        else if (gamma == 90) {

            criticalPressure = 3 * sigmaX - sigmaY - porePressure + tensileStrength;
        }
        else {

            double a = 2 * (sigmaX - sigmaY) * Math.cos(Math.toRadians(2 * failureAngle));
            double b = 4 * thoXY * Math.sin(Math.toRadians(2 * failureAngle));
            double c = Math.pow(thoThetaZ, 2) / (sigmaZ - porePressure);

            criticalPressure = sigmaX + sigmaY - a - b - c - porePressure + tensileStrength;
          }
        return criticalPressure;
    }
    //Calculate sigma1 min
    public static double sigma1(double sigmaTheta, double sigmaZ, double ThoThetaZ){

        double sigma1 =-1;

        sigma1 = 0.5 * (sigmaTheta + sigmaZ) - 0.5 * Math.sqrt(Math.pow(sigmaTheta-sigmaZ,2) + 4 * Math.pow(ThoThetaZ,2));

        return sigma1;
    }

    //Calculate sigma2
    public static double sigma2(double sigmaTheta, double sigmaZ, double ThoThetaZ){

        double sigma2 = -1;

        sigma2 = 0.5 * (sigmaTheta + sigmaZ) + 0.5 * Math.sqrt(Math.pow(sigmaTheta-sigmaZ,2) + 4 * Math.pow(ThoThetaZ,2));

        return sigma2;

    }

    //Calculate sigma3
    public double sigma3(double sigmaR){

        double sigma3;
        sigma3 = sigmaR;
        return sigma3;
    }

    public static int sigma1MaxTheta(double[] Sigma1, double sigma1Min){

        int index = -1;
        int arrayLength = Sigma1.length;


        //Find the angle that produced the highest sigTheta value.
        for (int i = 0;i<arrayLength;i++){

            if(Sigma1[i] == sigma1Min){
                index = i;
                break;
            }
        }


        return index;
    }


    public static String tensileFailureCondition(double mudweight, double criticalFailurePressure){

        String tensileCondition;

        if (mudweight > criticalFailurePressure){

            tensileCondition = "Failure";
        }
        else {

            tensileCondition = "No Failure";
        }

        return tensileCondition;
    }

/*
    //Shear failure condition

    public static String shearFailureCondition(XYSeries MohrLine, XYSeries failureCircle){


        String shearConditionFinalReport = "";


        shearConditionRange = new String[361];
        a = new double[361];
        b = new double[361];
        double coeffFriction = coefficientFrictionInput;

        int arrayLength = sigmaTheta.length;


        //Find the angle that give shear or no shear failure
        // .
        for (int i = 0;i<arrayLength;i++){

            a[i] = Math.sqrt(((sigmaTheta[i]-sigmaR)/2)*((sigmaTheta[i]-sigmaR)/2)+ThoRTheta*ThoRTheta);
            b[i] = coeffFriction/(Math.sqrt(1+coeffFriction*coeffFriction))*(sigmaTheta[i]+((sigmaTheta[i]+sigmaR)/2));

            if (a[i] >= b[i]){
                shearConditionRange[i] = "Shear failure";
            }
            else {
                shearConditionRange[i] = "No shear failure";
            }

        }

        // report the theta range that shear failure occurs
        for (int i = 0;i<arrayLength;i++){

            // i+1 != 361 statement ensures no array boundary errors at the end of the array
            if(i+1 != 361) {

                if (shearConditionRange[i] == "No shear failure" && shearConditionRange[i + 1] == "Shear failure") {

                    thetaStartRange = i + 1;

                }
                if (shearConditionRange[i] == "Shear failure" && shearConditionRange[i + 1] == "No shear failure" && thetaStartRange != -1) {

                    thetaEndRange = i;
                }
                //String reporting the ranges of failure
                if (thetaStartRange != -1 && thetaEndRange != -1) {

                    thetaStart180Range = thetaStartRange + 180;
                    thetaEnd180Range = thetaEndRange + 180;

                    if (thetaStart180Range > 360){
                        thetaStart180Range = thetaStart180Range -360;
                    }
                    if (thetaEnd180Range > 360){
                        thetaEnd180Range = thetaEnd180Range -360;
                    }
                    shearConditionFinalReport = "Shear failure θ = " + Integer.toString(thetaStartRange) + "-" + Integer.toString(thetaEndRange) + " and " + Integer.toString(thetaStart180Range) + "-" + Integer.toString(thetaEnd180Range);
                    break;
                }
            }
            else{
                break;
            }
        }

        //String reporting no failure if condition is satisfied
        if(thetaStartRange == -1 && thetaEndRange == -1){

            shearConditionFinalReport = "No shear failure";
        }

        return shearConditionFinalReport;
    }
*/

    //Calculated phi value if tensile failure happens

    public static double calculatePhi(double ThoThetaZ,double sigmaTheta,double sigmaZ){

        double phi;
        phi = 0.5*Math.atan((2*ThoThetaZ)/(sigmaTheta-sigmaZ));
        return phi;
    }

    // Retrieves the classification for the first set of parameters. String choosePara is where you define which parameter you want back (aka instability, loss of circ, ROP, ect)
    public static double firstSetParameters(String failType, String pressureType, String faultType, String chooseParam){

        double instability = -1;
        double lossOfCirc = -1;
        double wellControl= -1;
        double longTermIntegrity= -1;
        double ROP= -1;
        Random rand = new Random();

        if(failType == "Failure"){

            instability = 40 + (45-40)*rand.nextDouble();
            lossOfCirc = 40 + (45-40)*rand.nextDouble();
            wellControl= 40 + (45-40)*rand.nextDouble();
            longTermIntegrity= 40 + (45-40)*rand.nextDouble();
            ROP = 40 + (45-40)*rand.nextDouble();
        }
        else{

            if ( pressureType == "Overpressure"){

                if(faultType == "Normal"){

                    instability = 25 + (30-25)*rand.nextDouble();
                    lossOfCirc = 25 + (30-25)*rand.nextDouble();
                    wellControl= 25 + (30-25)*rand.nextDouble();
                    longTermIntegrity= 25 + (30-25)*rand.nextDouble();
                    ROP = 25 + (30-25)*rand.nextDouble();
                }
                else if(faultType == "Reverse") {

                    instability = 35 + (40-35)*rand.nextDouble();
                    lossOfCirc = 35 + (40-35)*rand.nextDouble();
                    wellControl= 35 + (40-35)*rand.nextDouble();
                    longTermIntegrity= 35 + (40-35)*rand.nextDouble();
                    ROP = 35 + (40-35)*rand.nextDouble();
                }

                else {
                    instability = 30 + (35-30)*rand.nextDouble();
                    lossOfCirc = 30 + (35-30)*rand.nextDouble();
                    wellControl= 30 + (35-30)*rand.nextDouble();
                    longTermIntegrity= 30 + (35-30)*rand.nextDouble();
                    ROP = 30 + (35-30)*rand.nextDouble();
                }
            }
            else if (pressureType == "Hydrostatic"){

                if(faultType == "Normal"){

                    instability = 10 + (15-10)*rand.nextDouble();
                    lossOfCirc = 10 + (15-10)*rand.nextDouble();
                    wellControl= 10 + (15-10)*rand.nextDouble();
                    longTermIntegrity= 10 + (15-10)*rand.nextDouble();
                    ROP = 10 + (15-10)*rand.nextDouble();
                }
                else if(faultType == "Reverse") {

                    instability = 20 + (25-20)*rand.nextDouble();
                    lossOfCirc = 20 + (25-20)*rand.nextDouble();
                    wellControl= 20 + (25-20)*rand.nextDouble();
                    longTermIntegrity= 20 + (25-20)*rand.nextDouble();
                    ROP = 20 + (25-20)*rand.nextDouble();
                }

                else {

                    instability = 15 + (20-15)*rand.nextDouble();
                    lossOfCirc = 15 + (20-15)*rand.nextDouble();
                    wellControl= 15 + (20-15)*rand.nextDouble();
                    longTermIntegrity= 15 + (20-15)*rand.nextDouble();
                    ROP = 15 + (20-15)*rand.nextDouble();
                }
            }
            else if (pressureType == "Under pressure"){

                if(faultType == "Normal"){

                    instability = 10 + (15-10)*rand.nextDouble();
                    lossOfCirc = 10 + (15-10)*rand.nextDouble();
                    wellControl= 10 + (15-10)*rand.nextDouble();
                    longTermIntegrity= 10 + (15-10)*rand.nextDouble();
                    ROP = 10 + (15-10)*rand.nextDouble();
                }
                else if(faultType == "Reverse") {

                    instability = 20 + (25-20)*rand.nextDouble();
                    lossOfCirc = 20 + (25-20)*rand.nextDouble();
                    wellControl= 20 + (25-20)*rand.nextDouble();
                    longTermIntegrity= 20 + (25-20)*rand.nextDouble();
                    ROP = 20 + (25-20)*rand.nextDouble();
                }

                else {

                    instability = 15 + (20-15)*rand.nextDouble();
                    lossOfCirc = 15 + (20-15)*rand.nextDouble();
                    wellControl= 15 + (20-15)*rand.nextDouble();
                    longTermIntegrity= 15 + (20-15)*rand.nextDouble();
                    ROP = 15 + (20-15)*rand.nextDouble();
                }
            }

        }

        if (chooseParam == "Instability"){

            return instability;
        }
        else if(chooseParam == "LossOfCirculation"){

            return lossOfCirc;
        }
        else if (chooseParam == "WellControl"){

            return wellControl;
        }
        else if (chooseParam == "LongTermIntegrity"){

            return longTermIntegrity;
        }
        else{

            return ROP;
        }
    }

/*
    public double compressionStrengthInitial(double sigma1, double sigma3,String GSIValue, String jointValue, String lithology){

        double compressionStrength=-1;
        double[] mIndexArray = {15, 7, 10, 7.5, 3.5 ,5, 0.3, 0.14, 0.2, 0.15, .04, .05};
        double mIndex =-1;
        double calibrationFactor = -1;
        double b;
        double c = sigma3*sigma3-sigma1*sigma1;

        // find the correct mIndex value
        if (GSIValue == "75-100" && lithology =="Sandstone"){

            mIndex = mIndexArray[0];
        }
        else if (GSIValue == "75-100" && (lithology =="Limestone" || lithology == "Dolomite")){

            mIndex = mIndexArray[1];
        }
        else if (GSIValue == "75-100" && (lithology =="Shale" || lithology =="Siltstone")){

            mIndex = mIndexArray[2];
        }
        else if (GSIValue == "75-100" && lithology =="Salt"){
            compressionStrength = 3625;
        }
        else if (GSIValue == "55-75" && lithology =="Sandstone"){

            mIndex = mIndexArray[3];
        }
        else if (GSIValue == "55-75" && (lithology =="Limestone" || lithology == "Dolomite")){

            mIndex = mIndexArray[4];
        }
        else if (GSIValue == "55-75" && (lithology =="Shale" || lithology =="Siltstone")){

            mIndex = mIndexArray[5];
        }
        else if (GSIValue == "55-75" && lithology =="Salt"){

            compressionStrength = 3625;
        }
        else if (GSIValue == "35-55" && lithology =="Sandstone"){

            mIndex = mIndexArray[6];
        }
        else if (GSIValue == "35-55" && (lithology =="Limestone" || lithology == "Dolomite")){

            mIndex = mIndexArray[7];
        }
        else if (GSIValue == "35-55" && (lithology =="Shale" || lithology =="Siltstone")){

            mIndex = mIndexArray[8];
        }
        else if (GSIValue == "35-55" && lithology =="Salt"){
            compressionStrength = 3625;
        }

        else if (GSIValue == "0-35" && lithology =="Sandstone"){

            mIndex = mIndexArray[9];
        }
        else if (GSIValue == "0-35" && (lithology =="Limestone" || lithology == "Dolomite")){

            mIndex = mIndexArray[10];
        }
        else if (GSIValue == "0-35" && (lithology =="Shale" || lithology =="Siltstone")){

            mIndex = mIndexArray[11];
        }
        else if (GSIValue == "0-35" && lithology =="Salt"){
            compressionStrength = 3625;
        }




        //find the compression strength
        mIndex = mIndex;
        b = mIndex*sigma3;
        compressionStrength = -1*b*sigma3+Math.sqrt(b*b-4*c)/2;
        return compressionStrength;
    }
*/
/*
    public double cohesionStrength(double compressiveStrength){

        double cohesion = -1;
        double coeffFriction = 0.6;
        double q = (Math.sqrt(coeffFriction*coeffFriction+1)+coeffFriction)*2;
        cohesion = compressiveStrength/q;

        return cohesion;
    }
*/
    public double rockPropertyGSISolver(double sig1,double sig2, double sig3, String GSIString, String Lithology, double D, double verticalStress, String returnParam) {

        double guess = 1;
        double result = -1;
        double mb = -1;
        double mi = -1;
        double s = -1;
        double a = -1;
        double compressiveStrengthIntact = -1;
        double compressiveStrength = -1;
        double tensileStrength = -1;
        double cohesion = -1;
        double sigma3Max = -1;
        double angleOfFriction = -1;
        double shearStrength = -1;
        double GSI = Double.parseDouble(GSIString);

        double[] stressesMaxMin = {sig1,sig2,sig3};
        Arrays.sort(stressesMaxMin);
        sig1 =  stressesMaxMin[2];
        sig2 = stressesMaxMin[1];
        sig3 = stressesMaxMin[0];


        //Retrieve mi value from lithology
        if (Lithology == "Shale" ){

            mi = 6;
        }
        else if (Lithology == "Salt"){

            mi = 12;
        }
        else if (Lithology == "Sandstone"){

            mi = 17;
        }
        else if (Lithology == "Siltstone"){

            mi = 17;
        }
        else if (Lithology == "Limestone"){

            mi = 10;
        }
        else if (Lithology == "Dolomite"){

            mi = 9;
        }

        mb = mi * Math.exp((GSI - 100) / (28 - 14 * D));
        s = Math.exp((GSI - 100) / (9 - 3 * D));
        a = .5 + (.16667) * Math.exp(-1 * GSI / 15) - Math.exp(-6.66667);

        //compressive strength of intact rock. S = 1 for intact rock
        compressiveStrengthIntact = (-1*sig3+Math.sqrt(Math.pow(mb*sig3,2)+4*Math.pow(sig1-sig3,2)))/2;

        compressiveStrength = compressiveStrengthIntact * Math.pow(s, a);
        tensileStrength = (-s * compressiveStrengthIntact / mb);

        double sigCM = (compressiveStrengthIntact * (mb + 4 * s - a * (mb - 8 * s)) * Math.pow((mb / 4 + s), a - 1)) / (2 * (1 - a) * (2 + a));
        sigma3Max = 0.47 * Math.pow((sigCM / verticalStress), -0.94) * sigCM;
        double sigma3n = sigma3Max / compressiveStrengthIntact;
        cohesion = (compressiveStrengthIntact * ((1 + 2 * a) * s + (1 - a) * mb * sigma3n) * Math.pow((s + mb * sigma3n), a - 1)) / ((1 + a) * (2 + a) * Math.sqrt(1 + (6 * a * mb * Math.pow(s + mb * sigma3n, a - 1)) / ((1 + a) * (2 + a))));

        angleOfFriction = Math.toDegrees(Math.asin((6 * a * mb * Math.pow(s + mb * sigma3n, a - 1)) / (2 * (1 + a) * (2 + a) + 6 * a * mb * Math.pow(s + mb * sigma3n, a - 1))));

        double sig1Sig3Derivative = 1 + a * mb * Math.pow(mb * sig3 / compressiveStrengthIntact + s, a - 1);
        double normalStress = (sig1 + sig3) / 2 - (sig1 - sig3) / 2 * ((sig1Sig3Derivative - 1) / (sig1Sig3Derivative + 1));

        shearStrength = cohesion + normalStress * Math.tan(Math.toRadians(angleOfFriction));


        if(returnParam == "Tensile Strength"){

            return tensileStrength;
        }
        else if (returnParam == "Cohesion"){

            return cohesion;
        }
        else if (returnParam == "Compressive Strength"){

            return compressiveStrength;
        }

        else if (returnParam == "Compressive Strength Intact"){

            return compressiveStrengthIntact;
        }
        else if (returnParam == "CoeffFriction"){

            return Math.tan(Math.toRadians(angleOfFriction));
        }

        else {

            return shearStrength;
        }
    }

}
