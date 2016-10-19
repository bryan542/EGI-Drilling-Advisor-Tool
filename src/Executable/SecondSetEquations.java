package Executable;

import java.util.Random;

/**
 * Created by bryan on 10/6/2016.
 */
public class SecondSetEquations {

    //Faults range calculations
    public static double fault(String conductivity, double beta,String chooseParam) {

        Random rand = new Random();
        double instability;
        double lossOfCirc;
        double wellControl;
        double longTermIntegrity;
        double ROP;

        if(conductivity =="High"){

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

        if(joint =="High"){

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

    //Deformation range calculations
    public static double deformation(String deformation, double beta,String chooseParam) {

        Random rand = new Random();
        double instability;
        double lossOfCirc;
        double wellControl;
        double longTermIntegrity;
        double ROP;
        if (deformation == "Unknown"){

             instability=0;
             lossOfCirc=0;
             wellControl=0;
             longTermIntegrity=0;
             ROP=0;
        }

        else if(deformation =="Deformation Band"){

            if(beta>30 && beta<75){

                instability = 8+ (10-8)*rand.nextDouble();
                longTermIntegrity = 8+ (10-8)*rand.nextDouble();
                ROP = 8+ (10-8)*rand.nextDouble();
            }
            else{
                instability = 3 + (6-3)*rand.nextDouble();
                longTermIntegrity = 4+ (6-4)*rand.nextDouble();
                ROP = 4+ (7-4)*rand.nextDouble();
            }
            lossOfCirc = 10+ (15-10)*rand.nextDouble();
            wellControl = 10+ (15-10)*rand.nextDouble();
        }
        else if(deformation =="Compaction Band"){

            if(beta>30 && beta<75){

                instability = 10+ (15-10)*rand.nextDouble();
                longTermIntegrity = 10+ (15-10)*rand.nextDouble();
                ROP = 12+ (15-12)*rand.nextDouble();
            }
            else{
                instability = 8 + (10-8)*rand.nextDouble();
                longTermIntegrity = 8+ (10-8)*rand.nextDouble();
                ROP = 8+ (10-8)*rand.nextDouble();
            }
            lossOfCirc = 15+ (20-15)*rand.nextDouble();
            wellControl = 15+ (20-15)*rand.nextDouble();
        }
        else{

            if(beta>30 && beta<75){

                instability = 15+ (20-15)*rand.nextDouble();
                longTermIntegrity = 9+ (10-9)*rand.nextDouble();
                ROP = 5+ (7-5)*rand.nextDouble();
            }
            else{
                instability = 10 + (15-10)*rand.nextDouble();
                longTermIntegrity = 4+ (6-4)*rand.nextDouble();
                ROP = 0+ (5-0)*rand.nextDouble();
            }
            lossOfCirc = 5+ (10-5)*rand.nextDouble();
            wellControl = 5+ (10-5)*rand.nextDouble();
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

    //Stylolite range calculations
    public static double stylolite(String chooseParam) {

        Random rand = new Random();
        double instability;
        double lossOfCirc;
        double wellControl;
        double longTermIntegrity;
        double ROP;

              instability = 5 + (10-5)*rand.nextDouble();
              lossOfCirc = 10+ (15-10)*rand.nextDouble();
              wellControl = 10+ (15-10)*rand.nextDouble();
              longTermIntegrity = 5+ (10-5)*rand.nextDouble();
              ROP = 5+ (10-5)*rand.nextDouble();

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

        if(unconformity =="Unknown"){
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

    public static double secondSetValues(String faultParam, String jointParam,String deformationParam,String unconformityParam,double betaParam,String chooseParam) {
        double valueAverage;
        double value1=0;
        double value2=0;
        double value3=0;
        double value4=0;
        double count = 0;
        int i = 1;

        while(i <5) {

            if (i == 1) {

                value1 = fault(faultParam, betaParam, chooseParam);
                if (value1 != 0) {

                    count = count + 1;
                }

            } else if (i == 2) {

                value2 = joint(jointParam, betaParam, chooseParam);
                if (value2 != 0) {

                    count = count + 1;
                }

            } else if (i == 3) {

                value3 = deformation(deformationParam, betaParam, chooseParam);
                if (value3 != 0) {

                    count = count + 1;
                }

            } else {

                value4 = unconformity(unconformityParam, betaParam, chooseParam);

                if (value4 != 0) {

                    count = count + 1;
                }
            }
            i++;
        }
        valueAverage = (value1+value2+value3+value4)/count;

        return valueAverage;
    }


}
