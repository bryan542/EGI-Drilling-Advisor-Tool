package Executable;

import java.util.Random;

/**
 * Created by bryan on 10/6/2016.
 */
public class FourthSetEquations {

    public FourthSetEquations(){

    }

    // Retrieves the classification for the third set of parameters. String choosePara is where you define which parameter you want back (aka instability, loss of circ, ROP, ect)
    public static double fourthSetParameters(String GSI, String chooseParam){

        double instability;
        double lossOfCirc;
        double wellControl;
        double longTermIntegrity;
        double ROP;
        double GSIValue = Double.parseDouble(GSI);
        Random rand = new Random();

        if (GSIValue > 75 && GSIValue <= 100) {

            instability = 0 + (2-0)*rand.nextDouble();
            lossOfCirc = 0;
            wellControl= 0;
            longTermIntegrity= 0 + (2-0)*rand.nextDouble();
            ROP = 3 + (7-3)*rand.nextDouble();
        }
        else if (GSIValue > 55 && GSIValue <= 75){

            instability = 2 + (6-2)*rand.nextDouble();
            lossOfCirc = 1;
            wellControl= 1;
            longTermIntegrity= 2 + (5-2)*rand.nextDouble();
            ROP = 0 + (3-0)*rand.nextDouble();
        }
        else if (GSIValue > 35 && GSIValue <= 55){

            instability = 6 + (9-6)*rand.nextDouble();
            lossOfCirc = 3;
            wellControl= 3;
            longTermIntegrity= 6 + (8-6)*rand.nextDouble();
            ROP = 7 + (8-7)*rand.nextDouble();
        }
        else {

            instability = 9 + (10-9)*rand.nextDouble();
            lossOfCirc = 5;
            wellControl= 5;
            longTermIntegrity= 8 + (10-8)*rand.nextDouble();
            ROP = 7 + (10-7)*rand.nextDouble();
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
