package Executable;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Created by bryan on 10/25/2016.
 */
public class StabilityConditions{

    public void sumInstabilityCriteria(double sumInstability, mainWindow mw){

        BigDecimal bd = new BigDecimal(sumInstability);
        bd = bd.round(new MathContext(2));
        double sumInstabilityRounded = bd.doubleValue();

        if(sumInstability >0 && sumInstability <20){


            mw.setInstableConditionResultText("Stable - " +sumInstabilityRounded);
        }
        else if(sumInstability >20 && sumInstability <40){

            mw.setInstableConditionResultText("Semi-stable - "+sumInstabilityRounded);
        }
        else if(sumInstability >40 && sumInstability <60){

           mw.setInstableConditionResultText("Partially Unstable - "+sumInstabilityRounded);
        }
        else if(sumInstability >60 && sumInstability <80){

            mw.setInstableConditionResultText("Semi-Unstable - "+sumInstabilityRounded);
        }
        else {

            mw.setInstableConditionResultText("Unstable - "+sumInstabilityRounded);
        }
    }

    public void sumLossCirculationCriteria(double sumLossOfCirculation, mainWindow mw){

        BigDecimal bd = new BigDecimal(sumLossOfCirculation);
        bd = bd.round(new MathContext(2));
        double sumLossOfCirculationRounded = bd.doubleValue();

        if(sumLossOfCirculation >0 && sumLossOfCirculation <20){

            mw.setLostCirculationConditionResultText("No Loss - " +sumLossOfCirculationRounded);
        }
        else if(sumLossOfCirculation >20 && sumLossOfCirculation <40){

            mw.setLostCirculationConditionResultText("2-4 bbl/hr - " +sumLossOfCirculationRounded);
        }
        else if(sumLossOfCirculation >40 && sumLossOfCirculation <60){

            mw.setLostCirculationConditionResultText("4-10 bbl/hr - " +sumLossOfCirculationRounded);
        }
        else if(sumLossOfCirculation >60 && sumLossOfCirculation <80){

            mw.setLostCirculationConditionResultText("10-20 bbl/hr - " +sumLossOfCirculationRounded);
        }
        else {

            mw.setLostCirculationConditionResultText("Complete Loss - " +sumLossOfCirculationRounded);
        }
    }

    public void sumWellControlCriteria(double sumWellControl, mainWindow mw){

        BigDecimal bd = new BigDecimal(sumWellControl);
        bd = bd.round(new MathContext(2));
        double sumWellControlRounded = bd.doubleValue();

        if(sumWellControl >0 && sumWellControl <20){

            mw.setWellControlConditionResultText("No Flow - " +sumWellControlRounded);
        }
        else if(sumWellControl >20 &&sumWellControl <40){

            mw.setWellControlConditionResultText("Negligible Flow - " +sumWellControlRounded);
        }
        else if(sumWellControl >40 &&sumWellControl <60){

            mw.setWellControlConditionResultText("4-10 bbl/hr - " +sumWellControlRounded);
        }
        else if(sumWellControl >60 &&sumWellControl <80){

            mw.setWellControlConditionResultText("10-20 bbl/hr - " +sumWellControlRounded);
        }
        else {

           mw.setWellControlConditionResultText("Kick/Blow Out - " +sumWellControlRounded);
        }
    }

    public void sumLongTermIntegrityCriteria(double sumLongTermIntegrity, mainWindow mw){


        BigDecimal bd = new BigDecimal(sumLongTermIntegrity);
        bd = bd.round(new MathContext(2));
        double sumLongTermIntegrityRounded = bd.doubleValue();

        if(sumLongTermIntegrity >0 && sumLongTermIntegrity <20){

            mw.setLongTermIntegrityConditionResultText("Stable - " +sumLongTermIntegrityRounded);
        }
        else if(sumLongTermIntegrity >20 && sumLongTermIntegrity <40){

            mw.setLongTermIntegrityConditionResultText("Semi-Stable - " +sumLongTermIntegrityRounded);
        }
        else if(sumLongTermIntegrity >40 && sumLongTermIntegrity <60){

            mw.setLongTermIntegrityConditionResultText("Partially Unstable - " +sumLongTermIntegrityRounded);
        }
        else if(sumLongTermIntegrity >60 && sumLongTermIntegrity <80){

            mw.setLongTermIntegrityConditionResultText("Semi-Unstable - " +sumLongTermIntegrityRounded);
        }
        else {

            mw.setLongTermIntegrityConditionResultText("Unstable - " +sumLongTermIntegrityRounded);
        }
    }

    public void sumROPCriteria(double sumROP, mainWindow mw){

        BigDecimal bd = new BigDecimal(sumROP);
        bd = bd.round(new MathContext(2));
        double sumROPRounded = bd.doubleValue();

        if(sumROP >0 && sumROP <20){

            mw.setROPConditionResultText("High - " +sumROPRounded);
        }
        else if(sumROP  >20 && sumROP  <40){

            mw.setROPConditionResultText("Medium-high - " +sumROPRounded);
        }
        else if(sumROP  >40 && sumROP  <60){

            mw.setROPConditionResultText("Medium - " +sumROPRounded);
        }
        else if(sumROP  >60 && sumROP  <80){

            mw.setROPConditionResultText("Medium-low - " +sumROPRounded);
        }
        else {

            mw.setROPConditionResultText("Low - " +sumROPRounded);
        }
    }

}
