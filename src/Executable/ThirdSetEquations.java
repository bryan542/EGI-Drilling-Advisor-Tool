package Executable;

import java.util.Random;

/**
 * Created by bryan on 10/6/2016.
 */
public class ThirdSetEquations {

    public ThirdSetEquations(){

    }

    // Retrieves the classification for the third set of parameters. String choosePara is where you define which parameter you want back (aka instability, loss of circ, ROP, ect)
    public static double thirdSetParameters(String lithology, String chooseParam){

        double instability;
        double lossOfCirc;
        double wellControl;
        double longTermIntegrity;
        double ROP;
        Random rand = new Random();

        if (lithology == "Shale") {

            instability = 7 + (10-7)*rand.nextDouble();
            lossOfCirc = 5 + (15-5)*rand.nextDouble();
            wellControl= 2 + (4-2)*rand.nextDouble();
            longTermIntegrity= 10 + (20-10)*rand.nextDouble();
            ROP = 10 + (20-10)*rand.nextDouble();
        }
        else if (lithology == "Salt"){

            instability = 7 + (10-7)*rand.nextDouble();
            lossOfCirc = 10+ (15-10)*rand.nextDouble();
            wellControl= 7 + (10-7)*rand.nextDouble();
            longTermIntegrity= 15 + (20-15)*rand.nextDouble();
            ROP = 15 + (20-15)*rand.nextDouble();
        }
        else if (lithology == "Sandstone"){

            instability = 3 + (8-3)*rand.nextDouble();
            lossOfCirc = 10 + (15-10)*rand.nextDouble();
            wellControl= 5 + (8-5)*rand.nextDouble();
            longTermIntegrity= 5 + (8-5)*rand.nextDouble();
            ROP = 2 + (5-2)*rand.nextDouble();
        }
        else if (lithology == "Siltstone"){

            instability = 6 + (9-6)*rand.nextDouble();
            lossOfCirc = 3 + (10-3)*rand.nextDouble();
            wellControl= 4 + (6-4)*rand.nextDouble();
            longTermIntegrity= 10 + (15-10)*rand.nextDouble();
            ROP = 10 + (15-10)*rand.nextDouble();
        }
        else if (lithology == "Limestone"){

            instability = 3 + (7-3)*rand.nextDouble();
            lossOfCirc = 3 + (6-3)*rand.nextDouble();
            wellControl= 4 + (6-4)*rand.nextDouble();
            longTermIntegrity= 3 + (5-3)*rand.nextDouble();
            ROP = 2 + (5-2)*rand.nextDouble();
        }
        else {

            instability = 3 + (5-3)*rand.nextDouble();
            lossOfCirc = 0 + (5-0)*rand.nextDouble();
            wellControl= 2 + (4-2)*rand.nextDouble();
            longTermIntegrity= 3;
            ROP = 2 + (5-2)*rand.nextDouble();
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
