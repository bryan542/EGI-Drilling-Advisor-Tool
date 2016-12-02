package Executable;

import java.util.Random;

/**
 * Created by bryan on 10/6/2016.
 */
public class SecondSetEquations {


    //Find betaAngle
    public double betaAngle(int strikeDirection,int thetaMaxAzimuth, int dipDirection,int gamma, double phi){

        int betaAngle=-1;
        int betaAzimuth = -1;
        int betaDip = -1;
        int sigma1Dip = -1;

        //sigma1Dip is the difference between phi and gamme. Phi is calculated in the drillingEquations class.
        //thetaMaxAzimuth comes from the theta angle that gives the max value of sigma1. Found in sigma1MinTheta method in drillingEquations class
        betaAzimuth = Math.abs(strikeDirection-thetaMaxAzimuth);

        phi = Math.round(phi);
        sigma1Dip = Math.abs((int) phi - gamma);
        betaDip = Math.abs(dipDirection - sigma1Dip);

        //If statements that makes sure our betaAzimuth falls into the 0-90 degree range
        if(betaAzimuth <= 90){

        }
        else if (90 < betaAzimuth && betaAzimuth <= 270){

            betaAzimuth = Math.abs(180-betaAzimuth);
        }
        else if (270< betaAzimuth && betaAzimuth < 360){

            betaAzimuth = Math.abs(360-betaAzimuth);
        }

        //If statement that will return a betaAngle range inbetween 30-75 if betadip or betaAzimuth is within that range
        if(30 <= betaAzimuth && betaAzimuth <= 75){

            betaAngle = betaAzimuth;
            return betaAngle;
        }
        else if (30 <= betaDip && betaDip<= 75){
            betaAngle = betaDip;
            return betaAngle;
        }
        else {

            betaAngle = betaAzimuth;
            return betaAngle;
        }

    }

    //Faults range calculations
    public static double fault(String conductivity, double beta,String chooseParam) {

        Random rand = new Random();
        double instability;
        double lossOfCirc;
        double wellControl;
        double longTermIntegrity;
        double ROP;


        if(conductivity =="Unknown/None"){
            instability=0;
            lossOfCirc=0;
            wellControl=0;
            longTermIntegrity=0;
            ROP=0;

        }
        else if(conductivity =="High"){

            if(beta>30 && beta<75){

                instability = 15+ (20-15)*rand.nextDouble();
                longTermIntegrity = 12+ (15-12)*rand.nextDouble();
                ROP = 12+ (15-12)*rand.nextDouble();
            }
            else{
                instability = 10 + (15-10)*rand.nextDouble();
                longTermIntegrity = 10+ (12-10)*rand.nextDouble();
                ROP = 10+ (12-10)*rand.nextDouble();
            }
            lossOfCirc = 15+ (20-15)*rand.nextDouble();
            wellControl = 15+ (20-15)*rand.nextDouble();
        }
        else if(conductivity =="Medium"){

            if(beta>30 && beta<75){

                instability = 10+ (15-10)*rand.nextDouble();
                longTermIntegrity = 12+ (14-12)*rand.nextDouble();
                ROP = 10+ (12-10)*rand.nextDouble();
            }
            else{
                instability = 5 + (9-5)*rand.nextDouble();
                longTermIntegrity = 9+ (10-9)*rand.nextDouble();
                ROP = 9+ (10-9)*rand.nextDouble();
            }
            lossOfCirc = 10+ (15-10)*rand.nextDouble();
            wellControl = 10+ (15-10)*rand.nextDouble();
        }
        else{

            if(beta>30 && beta<75){

                instability = 5+ (9-5)*rand.nextDouble();
                longTermIntegrity = 9+ (10-9)*rand.nextDouble();
                ROP = 5+ (7-5)*rand.nextDouble();
            }
            else{
                instability = 0 + (4-0)*rand.nextDouble();
                longTermIntegrity = 4+ (6-4)*rand.nextDouble();
                ROP = 0+ (5-0)*rand.nextDouble();
            }
            lossOfCirc = 5+ (10-5)*rand.nextDouble();
            wellControl = 3+ (7-3)*rand.nextDouble();
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

    //Joints range calculations
    public static double joint(String joint, double beta,String chooseParam) {

        Random rand = new Random();
        double instability;
        double lossOfCirc;
        double wellControl;
        double longTermIntegrity;
        double ROP;

        if(joint =="Unknown/None"){
            instability=0;
            lossOfCirc=0;
            wellControl=0;
            longTermIntegrity=0;
            ROP=0;

        }
        else if(joint =="High"){

            instability = 12 + (5-12)*rand.nextDouble();
            lossOfCirc = 15+ (20-15)*rand.nextDouble();
            wellControl = 15+ (20-15)*rand.nextDouble();
            longTermIntegrity = 10+ (12-10)*rand.nextDouble();
            ROP = 10+ (15-10)*rand.nextDouble();
        }
        else if(joint =="Medium"){

            instability = 8 + (10-8)*rand.nextDouble();
            lossOfCirc = 10+ (15-10)*rand.nextDouble();
            wellControl = 10+ (15-10)*rand.nextDouble();
            longTermIntegrity = 9+ (10-9)*rand.nextDouble();
            ROP = 7+ (10-7)*rand.nextDouble();
        }
        else{

            if(beta>30 && beta<75){

                instability = 12+ (17-12)*rand.nextDouble();
                longTermIntegrity = 10+ (15-10)*rand.nextDouble();
                ROP = 7+ (10-7)*rand.nextDouble();
            }
            else{
                instability = 5 + (7-5)*rand.nextDouble();
                longTermIntegrity = 4+ (6-4)*rand.nextDouble();
                ROP = 0+ (5-0)*rand.nextDouble();
            }
            lossOfCirc = 5+ (10-5)*rand.nextDouble();
            wellControl = 3+ (7-3)*rand.nextDouble();
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

    //Unconformity between bedding range calculations
    public static double unconformity(String unconformity, double beta, String chooseParam) {

        Random rand = new Random();
        double instability;
        double lossOfCirc;
        double wellControl;
        double longTermIntegrity;
        double ROP;

        if(unconformity =="Unknown/None"){
            instability=0;
            lossOfCirc=0;
            wellControl=0;
            longTermIntegrity=0;
            ROP=0;

        }

        else if(unconformity =="Highly Conductive"){

            if(beta>30 && beta<75){

                instability = 10+ (15-10)*rand.nextDouble();
                longTermIntegrity = 12+ (15-12)*rand.nextDouble();
                ROP = 12+ (15-12)*rand.nextDouble();
            }
            else{
                instability = 10 + (15-10)*rand.nextDouble();
                longTermIntegrity = 10+ (12-10)*rand.nextDouble();
                ROP = 10+ (12-10)*rand.nextDouble();
            }
            lossOfCirc = 15+ (20-15)*rand.nextDouble();
            wellControl = 10+ (15-10)*rand.nextDouble();
        }
        else if(unconformity =="Medium Conductive"){

            if(beta>30 && beta<75){

                instability = 10+ (15-10)*rand.nextDouble();
                longTermIntegrity = 12+ (15-12)*rand.nextDouble();
                ROP = 10+ (12-10)*rand.nextDouble();
            }
            else{
                instability = 5 + (9-5)*rand.nextDouble();
                longTermIntegrity = 9+ (10-9)*rand.nextDouble();
                ROP = 8+ (10-8)*rand.nextDouble();
            }
            lossOfCirc = 10+ (15-10)*rand.nextDouble();
            wellControl = 5+ (10-5)*rand.nextDouble();
        }
        else{

            if(beta>30 && beta<75){

                instability = 5+ (9-5)*rand.nextDouble();
                longTermIntegrity = 8+ (10-8)*rand.nextDouble();
                ROP = 5+ (7-5)*rand.nextDouble();
            }
            else{
                instability = 0 + (4-0)*rand.nextDouble();
                longTermIntegrity = 3+ (5-3)*rand.nextDouble();
                ROP = 3+ (5-3)*rand.nextDouble();
            }
            lossOfCirc = 3+ (7-3)*rand.nextDouble();
            wellControl = 0+ (5-0)*rand.nextDouble();
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

    //Find Instability,LossOfCirculation, WellControl, LongTermIntegrity, and ROP values

    public static double secondSetValues(String faultParam, String jointParam,String unconformityParam,double betaFaultParam, double betaJointParam, double betaUnconformityParam,String chooseParam) {
        double valueAverage;
        double value1=0;
        double value2=0;
        double value3=0;

        double count = 0;
        int i = 1;

        while(i <4) {

            if (i == 1) {

                value1 = fault(faultParam, betaFaultParam, chooseParam);
                if (value1 != 0) {

                    count = count + 1;
                }

            } else if (i == 2) {

                value2 = joint(jointParam, betaJointParam, chooseParam);
                if (value2 != 0) {

                    count = count + 1;
                }

            }  else {

                value3 = unconformity(unconformityParam, betaUnconformityParam, chooseParam);

                if (value3 != 0) {

                    count = count + 1;
                }
            }
            i++;
        }
        valueAverage = (value1+value2+value3)/count;

        if (Double.isNaN(valueAverage)){
            valueAverage = 0;
        }

        return valueAverage;
    }


}
