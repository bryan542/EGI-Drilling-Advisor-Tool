package Executable;

/**
 * Created by bryan on 10/25/2016.
 */
public class StabilityConditions{

    public void sumInstabilityCriteria(double sumInstability, mainWindow mw){
        if(sumInstability >0 && sumInstability <20){


            mw.setInstableConditionResultText("Stable");
        }
        else if(sumInstability >20 && sumInstability <40){

            mw.setInstableConditionResultText("Semi-stable");
        }
        else if(sumInstability >40 && sumInstability <60){

           mw.setInstableConditionResultText("Partially Unstable");
        }
        else if(sumInstability >60 && sumInstability <80){

            mw.setInstableConditionResultText("Semi-Unstable");
        }
        else {

            mw.setInstableConditionResultText("Unstable");
        }
    }

    public void sumLossCirculationCriteria(double sumLossOfCirculation, mainWindow mw){

        if(sumLossOfCirculation >0 && sumLossOfCirculation <20){

            mw.setLostCirculationConditionResultText("No Loss");
        }
        else if(sumLossOfCirculation >20 && sumLossOfCirculation <40){

            mw.setLostCirculationConditionResultText("2-4 bbl/hr");
        }
        else if(sumLossOfCirculation >40 && sumLossOfCirculation <60){

            mw.setLostCirculationConditionResultText("4-10 bbl/hr");
        }
        else if(sumLossOfCirculation >60 && sumLossOfCirculation <80){

            mw.setLostCirculationConditionResultText("10-20 bbl/hr");
        }
        else {

            mw.setLostCirculationConditionResultText("Complete Loss");
        }
    }

    public void sumWellControlCriteria(double sumWellControl, mainWindow mw){

        if(sumWellControl >0 && sumWellControl <20){

            mw.setWellControlConditionResultText("No Flow");
        }
        else if(sumWellControl >20 &&sumWellControl <40){

            mw.setWellControlConditionResultText("Negligible Flow");
        }
        else if(sumWellControl >40 &&sumWellControl <60){

            mw.setWellControlConditionResultText("4-10 bbl/hr");
        }
        else if(sumWellControl >60 &&sumWellControl <80){

            mw.setWellControlConditionResultText("10-20 bbl/hr");
        }
        else {

           mw.setWellControlConditionResultText("Kick/Blow Out");
        }
    }

    public void sumLongTermIntegrityCriteria(double sumLongTermIntegrity, mainWindow mw){

        if(sumLongTermIntegrity >0 && sumLongTermIntegrity <20){

            mw.setLongTermIntegrityConditionResultText("Stable");
        }
        else if(sumLongTermIntegrity >20 && sumLongTermIntegrity <40){

            mw.setLongTermIntegrityConditionResultText("Semi-Stable");
        }
        else if(sumLongTermIntegrity >40 && sumLongTermIntegrity <60){

            mw.setLongTermIntegrityConditionResultText("Partially Unstable");
        }
        else if(sumLongTermIntegrity >60 && sumLongTermIntegrity <80){

            mw.setLongTermIntegrityConditionResultText("Semi-Unstable");
        }
        else {

            mw.setLongTermIntegrityConditionResultText("Unstable");
        }
    }

    public void sumROPCriteria(double sumROP, mainWindow mw){

        if(sumROP >0 && sumROP <20){

            mw.setROPConditionResultText("High");
        }
        else if(sumROP  >20 && sumROP  <40){

            mw.setROPConditionResultText("Medium-high");
        }
        else if(sumROP  >40 && sumROP  <60){

            mw.setROPConditionResultText("Medium");
        }
        else if(sumROP  >60 && sumROP  <80){

            mw.setROPConditionResultText("Medium-low");
        }
        else {

            mw.setROPConditionResultText("Low");
        }
    }

}
