package Executable;

import javax.swing.*;

//This class sets the initial bootup fields that are enabled or disabled based on the default buttongroup selections
//Also includes the field setters to dynamically update if a button is clicked
public class ButtonGroupFieldEnableSetter {

    public ButtonGroupFieldEnableSetter(mainWindow mw, JRadioButton button, String buttonName){


        if(buttonName.equalsIgnoreCase("Stress Button")){

            if(button.isSelected()){

                mw.getSigmaVTextField().setEnabled(false);
                mw.getSigmaMaxTextField().setEnabled(false);
                mw.getSigmaMinTextField().setEnabled(false);
                mw.getPorePressureTextField().setEnabled(false);
                mw.getInputPorePressureLabel().setEnabled(false);
                mw.getInputSigmaMaxLabel().setEnabled(false);
                mw.getInputSigmaMinLabel().setEnabled(false);
                mw.getInputSigmaVLabel().setEnabled(false);
                mw.getInputStressGradientLabel().setEnabled(false);
                mw.getPoreCombo().setEnabled(true);
                mw.getFaultTypeCombo().setEnabled(true);
            }
            else{
                mw.getSigmaVTextField().setEnabled(true);
                mw.getSigmaMaxTextField().setEnabled(true);
                mw.getSigmaMinTextField().setEnabled(true);
                mw.getPorePressureTextField().setEnabled(true);
                mw.getInputPorePressureLabel().setEnabled(true);
                mw.getInputSigmaMaxLabel().setEnabled(true);
                mw.getInputSigmaMinLabel().setEnabled(true);
                mw.getInputSigmaVLabel().setEnabled(true);
                mw.getInputStressGradientLabel().setEnabled(true);
                mw.getPoreCombo().setEnabled(false);
                mw.getFaultTypeCombo().setEnabled(false);

            }

        }
        else if(buttonName.equalsIgnoreCase("Coeff Friction")){

            if(button.isSelected()){

                mw.getCoeffFrictionText().setEnabled(false);
            }
            else{
                mw.getCoeffFrictionText().setEnabled(true);

            }
        }

        else if(buttonName.equalsIgnoreCase("Cohesion")){

            if(button.isSelected()){

                mw.getCohesionText().setEnabled(false);
            }
            else{
                mw.getCohesionText().setEnabled(true);

            }
        }
        else if(buttonName.equalsIgnoreCase("Tensile")){

            if(button.isSelected()){

                mw.getTensileText().setEnabled(false);
            }
            else{
                mw.getTensileText().setEnabled(true);

            }
        }

    }
   public void fieldEnablerSetter(mainWindow mw, String buttonName, boolean selected){

       if(buttonName.equalsIgnoreCase("Stress Button")){

           if(selected){

               mw.getSigmaVTextField().setEnabled(false);
               mw.getSigmaMaxTextField().setEnabled(false);
               mw.getSigmaMinTextField().setEnabled(false);
               mw.getPorePressureTextField().setEnabled(false);
               mw.getInputPorePressureLabel().setEnabled(false);
               mw.getInputSigmaMaxLabel().setEnabled(false);
               mw.getInputSigmaMinLabel().setEnabled(false);
               mw.getInputSigmaVLabel().setEnabled(false);
               mw.getInputStressGradientLabel().setEnabled(false);
               mw.getPoreCombo().setEnabled(true);
               mw.getFaultTypeCombo().setEnabled(true);
           }
           else{
               mw.getSigmaVTextField().setEnabled(true);
               mw.getSigmaMaxTextField().setEnabled(true);
               mw.getSigmaMinTextField().setEnabled(true);
               mw.getPorePressureTextField().setEnabled(true);
               mw.getInputPorePressureLabel().setEnabled(true);
               mw.getInputSigmaMaxLabel().setEnabled(true);
               mw.getInputSigmaMinLabel().setEnabled(true);
               mw.getInputSigmaVLabel().setEnabled(true);
               mw.getInputStressGradientLabel().setEnabled(true);
               mw.getPoreCombo().setEnabled(false);
               mw.getFaultTypeCombo().setEnabled(false);

           }

       }
       else if(buttonName.equalsIgnoreCase("Coeff Friction")){

           if(selected){

               mw.getCoeffFrictionText().setEnabled(false);
           }
           else{
               mw.getCoeffFrictionText().setEnabled(true);

           }
       }

       else if(buttonName.equalsIgnoreCase("Cohesion")){

           if(selected){

               mw.getCohesionText().setEnabled(false);
           }
           else{
               mw.getCohesionText().setEnabled(true);

           }
       }
       else if(buttonName.equalsIgnoreCase("Tensile")){

           if(selected){

               mw.getTensileText().setEnabled(false);
           }
           else{
               mw.getTensileText().setEnabled(true);

           }
       }

   }
}
