package Executable;

import java.util.Random;

/**
 * Created by bryan on 10/6/2016.
 */
public class FifthSetEquations {

    public FifthSetEquations(){


    }

    // Retrieves the classification for the third set of parameters. String choosePara is where you define which parameter you want back (aka instability, loss of circ, ROP, ect)
    public static double fifthSetParameters(String Permeability, String chooseParam){

        double instability;
        double lossOfCirc;
        double wellControl;
        double longTermIntegrity;
        double ROP;
        Random rand = new Random();

        if (Permeability == "High(D)") {

            instability = 7 + (15-7)*rand.nextDouble();
            lossOfCirc = 10 + (15-10)*rand.nextDouble();
            wellControl= 12 + (20-12)*rand.nextDouble();
            longTermIntegrity= 7 + (10-7)*rand.nextDouble();
            ROP = 5 + (10-5)*rand.nextDouble();
        }
        else if (Permeability == "Medium(mD)"){

            instability = 3 + (7-3)*rand.nextDouble();
            lossOfCirc = 5+ (10-5)*rand.nextDouble();
            wellControl= 5 + (12-5)*rand.nextDouble();
            longTermIntegrity= 4 + (7-4)*rand.nextDouble();
            ROP = 0 + (5-0)*rand.nextDouble();
        }
        else  {

            instability = 0;
            lossOfCirc = 0 + (5-0)*rand.nextDouble();
            wellControl= 0 + (5-0)*rand.nextDouble();
            longTermIntegrity= 0 + (4-0)*rand.nextDouble();
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
