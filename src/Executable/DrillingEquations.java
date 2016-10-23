package Executable;

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
    //SH
    public static double SigmaHRange(String FaultType, String PorePressureType) {
        double sigmaH;
        Random rand = new Random();

        if (PorePressureType == "Hydrostatic") {

            if (FaultType == "Normal") {

                sigmaH = .7 + (.9 - .7) * rand.nextDouble();

            } else if (FaultType == "Strike-slip") {

                sigmaH = 1 + (1.2 - 1) * rand.nextDouble();

            } else {

                sigmaH = 1 + (1.6 - 1) * rand.nextDouble();
            }

            return sigmaH;
        } else {

            if (FaultType == "Normal") {

                sigmaH = .8 + (.92 - .8) * rand.nextDouble();

            } else if (FaultType == "Strike-slip") {

                sigmaH = 1.1 + (1.42 - 1.1) * rand.nextDouble();

            } else {

                sigmaH = 1.1 + (1.9 - 1.1) * rand.nextDouble();
            }

            return sigmaH;
        }
    }
    //Sh
    public static double SigmahRange(String FaultType, String PorePressureType) {
        double sigmah;
        Random rand = new Random();

        if (PorePressureType == "Hydrostatic") {

            if (FaultType == "Normal") {

                sigmah = .6 + (.7 - .6) * rand.nextDouble();

            } else if (FaultType == "Strike-slip") {

                sigmah = .6 + (.8 - .6) * rand.nextDouble();

            } else {

                sigmah = 1 + (1.2 - 1) * rand.nextDouble();
            }

            return sigmah;
        } else {

            if (FaultType == "Normal") {

                sigmah = .72 + (.79 - .72) * rand.nextDouble();

            } else if (FaultType == "Strike-slip") {

                sigmah = .76 + (.9 - .76) * rand.nextDouble();

            } else {

                sigmah = 1 + (1.2 - 1) * rand.nextDouble();
            }

            return sigmah;
        }
    }

    public static double PorePressureRange(String FaultType, String PorePressureType){

        double porePR;
        Random rand = new Random();

        if (PorePressureType == "Hydrostatic") {

                porePR = .43 + (.45 - .43) * rand.nextDouble();

            return porePR;
        }
        else {

                porePR = .465 + (.9 - .465) * rand.nextDouble();

            return porePR;
        }
    }
    // Sigma Values sigV, sigH, sigh

    public static double SigmaV(double depth, double SigVR, double PorePR){

        double SigmaV;
        SigmaV = depth*(SigVR - PorePR);
        return SigmaV;
    }

    public static double SigmaH(double depth, double SigHR, double PorePR){

        double SigmaH;
        SigmaH = depth*(SigHR - PorePR);
        return SigmaH;
    }
    public static double Sigmah(double depth, double SighR, double PorePR){

        double SigmaV;
        SigmaV = depth*(SighR - PorePR);
        return SigmaV;
    }

    //Stress Tensors SV, SH, and Sh

    public static double SV(double sigv, double sigH, double sigh, double gamma, double alpha){

        double SV;
        SV = sigv*Math.cos(Math.toRadians(gamma))*Math.cos(Math.toRadians(gamma))+sigH*Math.sin(Math.toRadians(gamma))*Math.sin(Math.toRadians(gamma))*Math.cos(Math.toRadians(alpha))*Math.cos(Math.toRadians(alpha))+sigh*Math.sin(Math.toRadians(gamma))*Math.sin(Math.toRadians(gamma))*Math.sin(Math.toRadians(alpha))*Math.sin(Math.toRadians(alpha));
        return SV;
    }
    //SH
    public static double SH(double sigv, double sigH, double sigh, double gamma, double alpha){

        double SH;
        SH = sigv*Math.sin(Math.toRadians(gamma))*Math.sin(Math.toRadians(gamma))+sigH*Math.cos(Math.toRadians(gamma))*Math.cos(Math.toRadians(gamma))*Math.cos(Math.toRadians(alpha))*Math.cos(Math.toRadians(alpha))+sigh*Math.cos(Math.toRadians(gamma))*Math.cos(Math.toRadians(gamma))*Math.sin(Math.toRadians(alpha))*Math.sin(Math.toRadians(alpha));
        return SH;
    }
    //Sh
    public static double Sh(double sigv, double sigH, double sigh, double gamma, double alpha){

        double Sh;
        Sh = sigH*Math.sin(Math.toRadians(alpha))*Math.sin(Math.toRadians(alpha))+sigh*Math.cos(Math.toRadians(alpha))*Math.cos(Math.toRadians(alpha));
        return Sh;
    }


    // Shear Stress Components ThoXY, ThoXZ, ThoYZ

    //ThoXY
    public static double ThoXY(double sigH, double sigh, double alpha, double gamma){

        double ThoXY;

        ThoXY = -1*sigH*Math.sin(Math.toRadians(alpha))*Math.cos(Math.toRadians(alpha))*Math.cos(Math.toRadians(gamma))+sigh*Math.sin(Math.toRadians(alpha))*Math.cos(Math.toRadians(alpha))*Math.cos(Math.toRadians(gamma));

        return ThoXY;
    }

    //ThoXZ
    public static double ThoXZ(double sigv, double sigH, double sigh, double alpha, double gamma){

        double ThoXZ;

        ThoXZ = -1*sigv*Math.sin(Math.toRadians(gamma))*Math.cos(Math.toRadians(gamma))+sigH*Math.sin(Math.toRadians(gamma))*Math.cos(Math.toRadians(gamma))*Math.cos(Math.toRadians(alpha))*Math.cos(Math.toRadians(alpha))+sigh*Math.sin(Math.toRadians(gamma))*Math.cos(Math.toRadians(gamma))*Math.sin(Math.toRadians(alpha))*Math.sin(Math.toRadians(alpha));

        return ThoXZ;
    }

    //ThoYZ
    public static double ThoYZ(double sigH, double sigh, double alpha, double gamma){

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
    public static double sigmaR(double deltaP){
        double sigmaR;
        sigmaR = deltaP;
        return sigmaR;
    }
    //SigmaTheta
    public static double[] sigmaTheta(double SH, double Sh, double ThoXY, double deltaP) {

        double sigmaTheta[];
        double highestSigmaTheta;
        int index = -1;
        sigmaTheta = new double[361];
        int arrayLength = sigmaTheta.length;

        //sigmaTheta at all angles 0-360 degrees
        for (int i = 0; i < arrayLength; i++) {

            sigmaTheta[i] = SH + Sh - 2 * (SH - Sh) * Math.cos(Math.toRadians(2 * i)) - 4 * ThoXY * Math.sin(Math.toRadians(2 * i)) - deltaP;


        }

        return sigmaTheta;
    }
/*
    // Use to return the highest Sigma Theta Value
    public static double highestSigmaTheta(double SH, double Sh, double ThoXY, double deltaP) {

        double sigmatheta[];
        double sortedsigmatheta[];
        double highestSigmaTheta;
        int index = -1;
        sigmatheta = new double[361];
        int arrayLength = sigmatheta.length;

        for (int i = 0; i < arrayLength; i++) {

            sigmatheta[i] = SH + Sh - 2 * (SH - Sh) * Math.cos(Math.toRadians(2 * i)) - 4 * ThoXY * Math.sin(Math.toRadians(2 * i)) - deltaP;

        }

        // Clone the original array to find the original theta value that generates the highest sigTheta
        sortedsigmatheta = sigmatheta.clone();

        // Sort the array from smallest to highest
        Arrays.sort(sortedsigmatheta);

        //Find highest sigTheta value
        highestSigmaTheta = sortedsigmatheta[sortedsigmatheta.length - 1];

        //Find the angle that produced the highest sigTheta value.
        for (int i = 0;i<arrayLength;i++){

            if(sigmatheta[i] == highestSigmaTheta){
                index = i;
                break;
            }
        }

        return highestSigmaTheta;
    }
*/
/*
    //Overload the method to return the angle theta that produced the highest sigTheta value
    public static double highestSigmaTheta(double SH, double Sh, double ThoXY, double deltaP,String returnAngle) {

        double sigmatheta[];
        double sortedsigmatheta[];
        double highestSigmaTheta;
        //index = theta return
        int index = -1;
        sigmatheta = new double[361];
        int arrayLength = sigmatheta.length;

        for (int i = 0; i < arrayLength; i++) {

            sigmatheta[i] = SH + Sh - 2 * (SH - Sh) * Math.cos(Math.toRadians(2 * i)) - 4 * ThoXY * Math.sin(Math.toRadians(2 * i)) - deltaP;

        }

        // Clone the original array to find the original theta value that generates the highest sigTheta
        sortedsigmatheta = sigmatheta.clone();

        // Sort the array from smallest to highest
        Arrays.sort(sortedsigmatheta);

        //Find highest sigTheta value
        highestSigmaTheta = sortedsigmatheta[sortedsigmatheta.length - 1];

        //Find the angle that produced the highest sigTheta value.
        for (int i = 0;i<arrayLength;i++){

            if(sigmatheta[i] == highestSigmaTheta){
                index = i;
                break;
            }
        }


        return index;

    }
*/
    // Calculate thetaZ
    public static double[] SigmaZ(double SV, double poisson, double Sh, double SH, double ThoXY){

        double sigmaZ[];
        double highestSigmaTheta;

        sigmaZ = new double[361];
        int arrayLength = sigmaZ.length;

        //sigmaZ at all angles 0-360 degrees
        for (int i = 0; i < arrayLength; i++) {

            sigmaZ[i] = SV - 2*poisson*(SH-Sh)*Math.cos(Math.toRadians(2*i))-4*ThoXY*Math.sin(Math.toRadians(2*i));
        }

        return sigmaZ;
    }

    //Calculate ThoThetaZ
    public static double[] ThoThetaZ(double ThoXZ,double ThoYZ){

        double[] ThoThetaz;
        ThoThetaz = new double [361];
        int arrayLength = ThoThetaz.length;

        //ThoThetaz at all angles 0-360 degrees
        for (int i = 0; i < arrayLength; i++) {
            ThoThetaz[i] = 2 * (-1 * ThoXZ * Math.sin(Math.toRadians(i)) + ThoYZ * Math.cos(Math.toRadians(i)));
        }
        return ThoThetaz;
    }

    //Set ThoRTheta
    public  double ThoRTheta(){

        this.ThoRTheta = 0;
        return this.ThoRTheta;
    }

    //Set ThoRZ
    public  double ThoRZ(){

        this.ThoRZ = 0;
        return this.ThoRZ;
    }

    //Calculate Sigma1
    public static double Sigma1(double[] sigmaTheta, double[] sigmaZ, double[] ThoThetaZ){

        double[] Sigma1;
        double sigma1Max;
        Sigma1 = new double[361];
        int arrayLength = Sigma1.length;

        //Sigma1 at all angles 0-360 degrees
        for (int i = 0; i < arrayLength; i++) {
            Sigma1[i] = 0.5 * (sigmaTheta[i] + sigmaZ[i]) + 0.5 * Math.sqrt((sigmaTheta[i] - sigmaZ[i]) * (sigmaTheta[i] - sigmaZ[i]) + 4 * ThoThetaZ[i] * ThoThetaZ[i]);
        }

        // Sort the array from smallest to highest
        Arrays.sort(Sigma1);

        //Find highest sigTheta value
        sigma1Max = Sigma1[Sigma1.length - 1];

        return sigma1Max;
    }

    //Calculate Sigma2
    public static double Sigma2(double[] sigmaTheta, double[] sigmaZ, double[] ThoThetaZ){
        double[] Sigma2;
        double sigma2Max;
        Sigma2 = new double[361];
        int arrayLength = Sigma2.length;
        //Sigma2 at all angles 0-360 degrees
        for (int i = 0; i < arrayLength; i++) {
            Sigma2[i] = 0.5 * (sigmaTheta[i] + sigmaZ[i]) - 0.5 * Math.sqrt((sigmaTheta[i] - sigmaZ[i]) * (sigmaTheta[i] - sigmaZ[i]) + 4 * ThoThetaZ[i] * ThoThetaZ[i]);
        }

        // Sort the array from smallest to highest
        Arrays.sort(Sigma2);

        //Find highest sigTheta value
        sigma2Max = Sigma2[Sigma2.length - 1];

        return sigma2Max;
    }

    //Calculate Sigma3
    public double Sigma3(double sigmaR){

        double Sigma3;
        Sigma3 = sigmaR;
        return Sigma3;
    }

    //Tensile fracture condition

    public static String tensileFailureCondition(double Sigma1, double tensile){

        String tensileCondition;

        if (Sigma1 > tensile){

            tensileCondition = "Failure";
        }
        else {

            tensileCondition = "No Failure";
        }

        return tensileCondition;
    }

    //Shear failure condition

    public static String shearFailureCondition(double sigmaTheta, double sigmaR, double ThoRTheta){

        String shearCondition;

        double a;
        double b;
        double coeffFriction = 0.6;

        a = Math.sqrt(((sigmaTheta-sigmaR)/2)*((sigmaTheta-sigmaR)/2)+ThoRTheta*ThoRTheta);
        b = coeffFriction/(Math.sqrt(1+coeffFriction*coeffFriction))*(sigmaTheta+((sigmaTheta+sigmaR)/2));

        if (a >= b){
            shearCondition = "Shear failure";
        }
        else {
            shearCondition = "No shear failure";
        }

        return shearCondition;
    }

    //Calculated phi value if tensile failure happens

    public static double calculatePhi(double ThoThetaZ,double sigmaTheta,double sigmaZ){

        double phi;
        phi = 0.5*Math.atan((2*ThoThetaZ)/(sigmaTheta-sigmaZ));
        return phi;
    }

    // Retrieves the classification for the first set of parameters. String choosePara is where you define which parameter you want back (aka instability, loss of circ, ROP, ect)
    public static double firstSetParameters(String failType, String pressureType, String faultType, String chooseParam){

        double instability;
        double lossOfCirc;
        double wellControl;
        double longTermIntegrity;
        double ROP;
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
            else{

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
}