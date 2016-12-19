package Executable;

/**
 * Created by bryan on 10/23/2016.
 */
public class ReportStrings {

    public ReportStrings(){

    }
    public String[] getInitString(double sumInstability,double sumLossOfCirculation,double sumWellControl,double sumLongTermIntegrity,double sumROP) {

        String instabilityReport = "";
        String lossOfCirculationRerport= "";
        String wellControlReport= "";
        String longTermIntegrityRerpot= "";
        String ROPReport= "";

        if (sumInstability > 0 && sumInstability <20 ){

        instabilityReport = "Conditions are stable.";
        }
        else if (sumInstability > 20 && sumInstability < 40){

            instabilityReport = "1. If the Stress Regime Factor causes the instability in the wellbore, adjusting the mud weight, and pumping  pressure can solve the problem.";

        }
        else if (sumInstability > 40 && sumInstability < 60){

            instabilityReport = "1. If the Stress Regime Factor causes the instability in the wellbore, adjusting the mud weight, and pumping  pressure can solve the problem.";

        }
        else if (sumInstability > 60 && sumInstability < 80){

            instabilityReport = "1. Change mud-weight selection and check for required maintenance.\n" +
                    "2. Adjust to more stable hole-trajectory.\n" +
                    "3. Validate borehole fluid compatible with the formation being drilled";

        }
        else if (sumInstability > 80 && sumInstability < 100){

            instabilityReport = "Adjust mud-weight selection and check for required maintenance.\n" +
                    "1. Adjust to more stable hole-trajectory.\n" +
                    "2. Validate borehole fluid compatible with the formation being drilled";
        }

        if (sumLossOfCirculation > 0 && sumLossOfCirculation <20 ){

            lossOfCirculationRerport = "No circulation loss.";

        }
        else if (sumLossOfCirculation > 20 && sumLossOfCirculation < 40){

            lossOfCirculationRerport = "1. Monitor the circulation loss.";
        }
        else if (sumLossOfCirculation > 40 && sumLossOfCirculation < 60){

            lossOfCirculationRerport = "1. Monitor the fluid loss more frequently. \n"+
                    "2. Reduce GPM. \n"+
                    "3. Reduce mud weight about 0.5 PPG per hour inside the mud window till fluid loss stablalizes.";
        }
        else if (sumLossOfCirculation > 60 && sumLossOfCirculation < 80){

            lossOfCirculationRerport = "1. Design the casing program to case-off low pressure or suspected lost circulation zones\n" +
                    "2. Maintain mud weight to the minimum required to control known formation pressures.\n" +
                    "3. Weight is one of the major causes of lost circulation\n" +
                    "4. Pre-treat the mud system with LCM when drilling through known lost circulation intervals\n" +
                    "5. In extreme cases, 40+ ppb LCM concentrations have been successfully used in drilling applications\n" +
                    "6. Maintain low mud rheology values that are still sufficient to clean the hole\n" +
                    "7. Rotating the drill string when starting circulation helps to break the gels and minimize pump pressure\n" +
                    "8. Start circulation slowly after connections and periods of non-circulation\n" +
                    "9. Use minimum GPM flow rate to clean the hole when drilling known lost circulation zone\n" +
                    "10. Control drill known lost circulation zone to avoid loading the annulus with cuttings\n" +
                    "11. Reduce pipe tripping speeds to minimize swab/surge pressure\n" +
                    "12. Plan to break circulation at 2 to 3 foot depths while tripping in the hole\n" +
                    "13. Minimize annular restrictions";
        }
        else if (sumLossOfCirculation > 80 && sumLossOfCirculation < 100){

            lossOfCirculationRerport = "1. Design the casing program to case-off low pressure or suspected lost circulation zones\n" +
                    "2. Maintain mud weight to the minimum required to control known formation pressures.\n" +
                    "3. Weight is one of the major causes of lost circulation\n" +
                    "4. Pre-treat the mud system with LCM when drilling through known lost circulation intervals\n" +
                    "5. In extreme cases, 40+ ppb LCM concentrations have been successfully used in drilling applications\n" +
                    "6. Maintain low mud rheology values that are still sufficient to clean the hole\n" +
                    "7. Rotating the drill string when starting circulation helps to break the gels and minimize pump pressure\n" +
                    "8. Start circulation slowly after connections and periods of non-circulation\n" +
                    "9. Use minimum GPM flow rate to clean the hole when drilling known lost circulation zone\n" +
                    "10. Control drill known lost circulation zone to avoid loading the annulus with cuttings\n" +
                    "11. Reduce pipe tripping speeds to minimize swab/surge pressure\n" +
                    "12. Plan to break circulation at 2 to 3 foot depths while tripping in the hole\n" +
                    "13. Minimize annular restrictions";
        }

        if (sumWellControl > 0 && sumWellControl <20 ){

            wellControlReport = "Well control stable";
        }
        else if (sumWellControl > 20 && sumWellControl < 40){

            wellControlReport = "1. Monitor the well for signs of changing.\n"+
                    "2. Maintain full circulation.";
        }
        else if (sumWellControl > 40 && sumWellControl < 60){

            wellControlReport = "1. Monitor shut-in pressures for gas migration while making preparations for the kill operation (Weigh and record mud weight in and out every 30 minutes during any circulating operation)\n"+
                    "2. Monitor the well for signs of changing formation pressure.\n"+
                    "3. Adjust mud weight prior to drilling for regions with known abnormal pressure.\n"+
                    "4. Observe abnormal pressure warning signs.\n"+
                    "5. Maintain full circulation.\n"+
                    "6. Maintain degasser capacity to handle full returns.";
        }
        else if (sumWellControl > 60 && sumWellControl < 80){

            wellControlReport = "1. Monitor shut-in pressures for gas migration while making preparations for the kill operation (Weigh and record mud weight in and out every 30 minutes during any circulating operation)\n"+
                    "2. Monitor the well for signs of changing formation pressure.\n"+
                    "3. Adjust mud weight prior to drilling for regions with known abnormal pressure.\n"+
                    "4. Observe abnormal pressure warning signs.\n"+
                    "5. Maintain full circulation.\n"+
                    "6. Maintain degasser capacity to handle full returns.\n"+
                    "7. May have to use different well killing methods\n" +
                    "8. Open pump suctions to the heavy mud reserves and pump at maximum rate\n" +
                    "9. Build additional heavy mud volume Prepare to pump water if mud runs out.";

        }
        else if (sumWellControl > 80 && sumWellControl < 100){

            wellControlReport = "1. Monitor shut-in pressures for gas migration while making preparations for the kill operation (Weigh and record mud weight in and out every 30 minutes during any circulating operation)\n"+
                    "2. Monitor the well for signs of changing formation pressure.\n"+
                    "3. Adjust mud weight prior to drilling for regions with known abnormal pressure.\n"+
                    "4. Observe abnormal pressure warning signs.\n"+
                    "5. Maintain full circulation.\n"+
                    "6. Maintain degasser capacity to handle full returns.\n"+
                    "7. May have to use different well killing methods\n" +
                    "8. Open pump suctions to the heavy mud reserves and pump at maximum rate\n" +
                    "9. Build additional heavy mud volume Prepare to pump water if mud runs out \n."+
                    "10. Prepare to abandon the rig.";
        }

        if (sumLongTermIntegrity > 0 && sumLongTermIntegrity <20 ){

            longTermIntegrityRerpot = "Long term integrity is stable.";
        }
        else if (sumLongTermIntegrity > 20 && sumLongTermIntegrity < 40){

            longTermIntegrityRerpot = "1. Adjusting the mud weight and pumping  pressure if the stress regime factor is causing instability";
        }
        else if (sumLongTermIntegrity > 40 && sumLongTermIntegrity < 60){

            longTermIntegrityRerpot = "1. Adjusting the mud weight and pumping  pressure if the stress regime factor is causing instability";

        }
        else if (sumLongTermIntegrity > 60 && sumLongTermIntegrity < 80){

            longTermIntegrityRerpot = "1. Adjust mud-weight selection and perform maintenance.\n" +
                    "2. Use of proper hydraulics to control the equivalent circulating density (ECD)\n" +
                    "3. Adjust drilling trajectory.";
        }
        else if (sumLongTermIntegrity > 80 && sumLongTermIntegrity < 100){

            longTermIntegrityRerpot = "1. Adjust mud-weight selection and perform maintenance.\n" +
                    "2. Use of proper hydraulics to control the equivalent circulating density (ECD)\n" +
                    "3. Adjust drilling trajectory.\n"+
                    "4. Minimize the time spent in open hole drilling.";
        }

        if (sumROP > 0 && sumROP <20 ){

            ROPReport = "ROP at maximum efficiency";
        }
        else if (sumROP > 20 && sumROP < 40){

            ROPReport = "1. Adjust RPM, WOB, and GPM";
        }
        else if (sumROP > 40 && sumROP < 60){

            ROPReport = "1. Adjust RPM, WOB, and GPM";
        }
        else if (sumROP > 60 && sumROP < 80){

            ROPReport = "1. Adjust RPM, WOB, and GPM";
        }
        else if (sumROP > 80 && sumROP < 100){

            ROPReport = "1. Adjust RPM, WOB, and GPM";
        }

        String[] initString = {instabilityReport,lossOfCirculationRerport,wellControlReport,longTermIntegrityRerpot,ROPReport};
        return initString;
    }
}
