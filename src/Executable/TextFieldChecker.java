package Executable;

import javax.swing.*;

/**
 * Created by Bryan on 10/31/2016.
 */
public class TextFieldChecker {

    //method used to check if the input values are correct in the given textfields
    public TextFieldChecker(){

    }

    public boolean runInputCheck(mainWindow mw){

        boolean checkResult = true;

        //Depth textfield check
        try {

        if(Double.parseDouble(mw.getDepthText().getText())>=0){

            }
        else{

            JOptionPane.showMessageDialog(new JDialog(), mw.getDepthLabel().getText()+ ": Enter non-negative value.");
            checkResult = false;
            }


        } catch (NumberFormatException e){

            JOptionPane.showMessageDialog(new JDialog(),mw.getDepthLabel().getText()+ ":Enter a valid value.");
            checkResult = false;
        }

        //Mudweight textfield check
        try {

            if(Double.parseDouble(mw.getMudWeightText().getText())>=0){

            }
            else{

                JOptionPane.showMessageDialog(new JDialog(), mw.getMudWeightLabel().getText()+ ": Enter non-negative value.");
                checkResult = false;
            }


        } catch (NumberFormatException e){

            JOptionPane.showMessageDialog(new JDialog(),mw.getMudWeightLabel().getText()+ ":Enter a valid value.");
            checkResult = false;
        }

        //Cohesion textfield check
        try {

            if(Double.parseDouble(mw.getCohesionText().getText())>=0){

            }
            else{

                JOptionPane.showMessageDialog(new JDialog(), mw.getCohesionLabel().getText()+ ": Enter non-negative value.");
                checkResult = false;
            }


        } catch (NumberFormatException e){

            JOptionPane.showMessageDialog(new JDialog(),mw.getCohesionLabel().getText()+ ":Enter a valid value.");
            checkResult = false;
        }

        //Gamma angle textfield check
        try {

            if(0<=Double.parseDouble(mw.getGammaText().getText()) && Double.parseDouble(mw.getGammaText().getText())<=360){

            }
            else{

                JOptionPane.showMessageDialog(new JDialog(), mw.getGammaLabel().getText()+ ": Enter a value from 0-360 degrees.");
                checkResult = false;
            }


        } catch (NumberFormatException e){

            JOptionPane.showMessageDialog(new JDialog(),mw.getGammaLabel().getText()+ ":Enter a valid value from 0-360 degrees.");
            checkResult = false;
        }

        //Alpha 1 textfield check
        try {

            if(0<=Double.parseDouble(mw.getAlpha1Text().getText()) && Double.parseDouble(mw.getAlpha1Text().getText())<=360){

            }
            else{

                JOptionPane.showMessageDialog(new JDialog(), mw.getAlpha1Label().getText()+ ": Enter a value from 0-360 degrees.");
                checkResult = false;
            }


        } catch (NumberFormatException e){

            JOptionPane.showMessageDialog(new JDialog(),mw.getAlpha1Label().getText()+ ":Enter a valid value from 0-360 degrees.");
            checkResult = false;
        }

        //Alpha 2 textfield check
        try {

            if(0<=Double.parseDouble(mw.getAlpha2Text().getText()) && Double.parseDouble(mw.getAlpha2Text().getText())<=360){

            }
            else{

                JOptionPane.showMessageDialog(new JDialog(), mw.getAlpha2Label().getText()+ ": Enter a value from 0-360 degrees.");
                checkResult = false;
            }


        } catch (NumberFormatException e){

            JOptionPane.showMessageDialog(new JDialog(),mw.getAlpha2Label().getText()+ ":Enter a valid value from 0-360 degrees.");
            checkResult = false;
        }

        //Poisson ratio textfield check
        try {

            if(0<=Double.parseDouble(mw.getPoissonText().getText()) && Double.parseDouble(mw.getPoissonText().getText())<=.5){

            }
            else{

                JOptionPane.showMessageDialog(new JDialog(), mw.getPoissonLabel().getText()+ ": Enter a value between 0-0.5.");
                checkResult = false;
            }


        } catch (NumberFormatException e){

            JOptionPane.showMessageDialog(new JDialog(),mw.getPoissonLabel().getText()+ ":Enter a valid value between 0-0.5.");
            checkResult = false;
        }

        if(mw.getStressManualInputRadioButton().isSelected()){

        //Input sigmav gradient textfield check
        try {

            if(Double.parseDouble(mw.getSigmaVTextField().getText())>=0){

            }
            else{

                JOptionPane.showMessageDialog(new JDialog(), mw.getInputSigmaVLabel().getText()+ ": Enter non-negative value.");
                checkResult = false;
            }


        } catch (NumberFormatException e){

            JOptionPane.showMessageDialog(new JDialog(),mw.getInputSigmaVLabel().getText()+ ":Enter a valid value.");
            checkResult = false;
        }

        //Input sigmaH gradient textfield check
        try {

            if(Double.parseDouble(mw.getSigmaMaxTextField().getText())>=0){

            }
            else{

                JOptionPane.showMessageDialog(new JDialog(), mw.getInputSigmaMaxLabel().getText()+ ": Enter non-negative value.");
                checkResult = false;
            }


        } catch (NumberFormatException e){

            JOptionPane.showMessageDialog(new JDialog(),mw.getInputSigmaMaxLabel().getText()+ ":Enter a valid value.");
            checkResult = false;
        }

        //Input sigmah gradient textfield check
        try {

            if(Double.parseDouble(mw.getSigmaMinTextField().getText())>=0){

            }
            else{

                JOptionPane.showMessageDialog(new JDialog(), mw.getInputSigmaMinLabel().getText()+ ": Enter non-negative value.");
                checkResult = false;
            }


        } catch (NumberFormatException e){

            JOptionPane.showMessageDialog(new JDialog(),mw.getInputSigmaMinLabel().getText()+ ":Enter a valid value.");
            checkResult = false;
        }

        //Input porepressure gradient textfield check
        try {

            if(Double.parseDouble(mw.getPorePressureTextField().getText())>=0){

            }
            else{

                JOptionPane.showMessageDialog(new JDialog(), mw.getInputPorePressureLabel().getText()+ ": Enter non-negative value.");
                checkResult = false;
            }


        } catch (NumberFormatException e){

            JOptionPane.showMessageDialog(new JDialog(),mw.getInputPorePressureLabel().getText()+ ":Enter a valid value.");
            checkResult = false;
        }

        }

        if(mw.getSigmaVStrikeTextField().isEnabled() && mw.getSigmaVDipTextField().isEnabled()){

        //sigmaV strike textfield check
        try {

            if(0<=Double.parseDouble(mw.getSigmaVStrikeTextField().getText()) && Double.parseDouble(mw.getSigmaVStrikeTextField().getText())<=360){

            }
            else{

                JOptionPane.showMessageDialog(new JDialog(), mw.getInputSigmaVLabel().getText()+ ": Enter a strike value from 0-360 degrees.");
                checkResult = false;
            }


        } catch (NumberFormatException e){

            JOptionPane.showMessageDialog(new JDialog(),mw.getInputSigmaVLabel().getText()+ ":Enter a strike value from 0-360 degrees.");
            checkResult = false;
        }

        //sigmaV dip textfield check
        try {

            if(0<=Double.parseDouble(mw.getSigmaVDipTextField().getText()) && Double.parseDouble(mw.getSigmaVDipTextField().getText())<=90){

            }
            else{

                JOptionPane.showMessageDialog(new JDialog(), mw.getInputSigmaVLabel().getText()+ ": Enter a dip value from 0-90 degrees.");
                checkResult = false;
            }


        } catch (NumberFormatException e){

            JOptionPane.showMessageDialog(new JDialog(),mw.getInputSigmaVLabel().getText()+ ":Enter a dip value from 0-90 degrees.");
            checkResult = false;
        }
        }

        if(mw.getSigmaMaxStrikeTextField().isEnabled() && mw.getSigmaMaxDipTextField().isEnabled()){

            //sigmaH strike textfield check
        try {

            if(0<=Double.parseDouble(mw.getSigmaMaxStrikeTextField().getText()) && Double.parseDouble(mw.getSigmaMaxStrikeTextField().getText())<=360){

            }
            else{

                JOptionPane.showMessageDialog(new JDialog(), mw.getInputSigmaMaxLabel().getText()+ ": Enter a strike value from 0-360 degrees.");
                checkResult = false;
            }


        } catch (NumberFormatException e){

            JOptionPane.showMessageDialog(new JDialog(),mw.getInputSigmaMaxLabel().getText()+ ":Enter a strike value from 0-360 degrees.");
            checkResult = false;
        }

        //sigmaH dip textfield check
        try {

            if(0<=Double.parseDouble(mw.getSigmaMaxDipTextField().getText()) && Double.parseDouble(mw.getSigmaMaxDipTextField().getText())<=90){

            }
            else{

                JOptionPane.showMessageDialog(new JDialog(), mw.getInputSigmaMaxLabel().getText()+ ": Enter a dip value from 0-90 degrees.");
                checkResult = false;
            }


        } catch (NumberFormatException e){

            JOptionPane.showMessageDialog(new JDialog(),mw.getInputSigmaMaxLabel().getText()+ ":Enter a dip value from 0-90 degrees.");
            checkResult = false;
        }
        }

        if(mw.getSigmaMinStrikeTextField().isEnabled() && mw.getSigmaMinDipTextField().isEnabled()){

        //sigmah strike textfield check
        try {

            if(0<=Double.parseDouble(mw.getSigmaMinStrikeTextField().getText()) && Double.parseDouble(mw.getSigmaMinStrikeTextField().getText())<=360){

            }
            else{

                JOptionPane.showMessageDialog(new JDialog(), mw.getInputSigmaMinLabel().getText()+ ": Enter a strike value from 0-360 degrees.");
                checkResult = false;
            }


        } catch (NumberFormatException e){

            JOptionPane.showMessageDialog(new JDialog(),mw.getInputSigmaMinLabel().getText()+ ":Enter a strike value from 0-360 degrees.");
            checkResult = false;
        }

        //sigmah dip textfield check
        try {

            if(0<=Double.parseDouble(mw.getSigmaMinDipTextField().getText()) && Double.parseDouble(mw.getSigmaMinDipTextField().getText())<=90){

            }
            else{

                JOptionPane.showMessageDialog(new JDialog(), mw.getInputSigmaMinLabel().getText()+ ": Enter a dip value from 0-90 degrees.");
                checkResult = false;
            }


        } catch (NumberFormatException e){

            JOptionPane.showMessageDialog(new JDialog(),mw.getInputSigmaMinLabel().getText()+ ":Enter a dip value from 0-90 degrees.");
            checkResult = false;
        }
        }

        if(mw.getTensileManualRadioButton().isSelected()){

        //Input tensile strength textfield check
        try {

            if(Double.parseDouble(mw.getTensileText().getText())>=0){

            }
            else{

                JOptionPane.showMessageDialog(new JDialog(), mw.getTensileLabel().getText()+ ": Enter non-negative value.");
                checkResult = false;
            }


        } catch (NumberFormatException e){

            JOptionPane.showMessageDialog(new JDialog(),mw.getTensileLabel().getText()+ ":Enter a valid value.");
            checkResult = false;
        }

        }

        //Bedding Strike textfield check
        try {

            if(0<=Double.parseDouble(mw.getBeddingPlaneStrikeTextField().getText()) && Double.parseDouble(mw.getBeddingPlaneStrikeTextField().getText())<=360){

            }
            else{

                JOptionPane.showMessageDialog(new JDialog(), mw.getBeddingPlaneConductivityLabel().getText()+ ": Enter a strike value from 0-360 degrees.");
                checkResult = false;
            }


        } catch (NumberFormatException e){

            JOptionPane.showMessageDialog(new JDialog(),mw.getBeddingPlaneConductivityLabel().getText()+ ":Enter a strike value from 0-360 degrees.");
            checkResult = false;
        }

        //Bedding dip textfield check
        try {

            if(0<=Double.parseDouble(mw.getBeddingPlaneDipTextField().getText()) && Double.parseDouble(mw.getBeddingPlaneDipTextField().getText())<=90){

            }
            else{

                JOptionPane.showMessageDialog(new JDialog(), mw.getBeddingPlaneConductivityLabel().getText()+ ": Enter a dip value from 0-90 degrees.");
                checkResult = false;
            }


        } catch (NumberFormatException e){

            JOptionPane.showMessageDialog(new JDialog(),mw.getBeddingPlaneConductivityLabel().getText()+ ":Enter a dip value from 0-90 degrees.");
            checkResult = false;
        }

        //Fault conductivity Strike textfield check
        try {

            if(0<=Double.parseDouble(mw.getFaultConductivityStrikeTextField().getText()) && Double.parseDouble(mw.getFaultConductivityStrikeTextField().getText())<=360){

            }
            else{

                JOptionPane.showMessageDialog(new JDialog(), mw.getFaultConductivityLabel().getText()+ ": Enter a strike value from 0-360 degrees.");
                checkResult = false;
            }


        } catch (NumberFormatException e){

            JOptionPane.showMessageDialog(new JDialog(),mw.getFaultConductivityLabel().getText()+ ":Enter a strike value from 0-360 degrees.");
            checkResult = false;
        }

        //Fault conductivity dip textfield check
        try {

            if(0<=Double.parseDouble(mw.getFaultConductivityDipTextField().getText()) && Double.parseDouble(mw.getFaultConductivityDipTextField().getText())<=90){

            }
            else{

                JOptionPane.showMessageDialog(new JDialog(), mw.getFaultConductivityLabel().getText()+ ": Enter a dip from 0-90 degrees.");
                checkResult = false;
            }


        } catch (NumberFormatException e){

            JOptionPane.showMessageDialog(new JDialog(),mw.getFaultConductivityLabel().getText()+ ":Enter a dip value from 0-90 degrees.");
            checkResult = false;
        }

        //Joint/Natural fracture strike textfield check
        try {

            if(0<=Double.parseDouble(mw.getJointStrikeTextField().getText()) && Double.parseDouble(mw.getJointStrikeTextField().getText())<=360){

            }
            else{

                JOptionPane.showMessageDialog(new JDialog(), mw.getJointLabel().getText()+ ": Enter a value from 0-360 degrees.");
                checkResult = false;
            }


        } catch (NumberFormatException e){

            JOptionPane.showMessageDialog(new JDialog(),mw.getJointLabel().getText()+ ":Enter a valid value from 0-360 degrees.");
            checkResult = false;
        }

        //Joint/Natural fracture dip textfield check
        try {

            if(0<=Double.parseDouble(mw.getJointDipTextField().getText()) && Double.parseDouble(mw.getJointDipTextField().getText())<=90){

            }
            else{

                JOptionPane.showMessageDialog(new JDialog(), mw.getJointLabel().getText()+ ": Enter a value from 0-90 degrees.");
                checkResult = false;
            }


        } catch (NumberFormatException e){

            JOptionPane.showMessageDialog(new JDialog(),mw.getJointLabel().getText()+ ":Enter a valid value from 0-90 degrees.");
            checkResult = false;
        }

        return checkResult;
    }
}
