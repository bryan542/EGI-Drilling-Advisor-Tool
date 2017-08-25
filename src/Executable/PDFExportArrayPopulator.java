package Executable;

import java.util.ArrayList;

public class PDFExportArrayPopulator {

    public PDFExportArrayPopulator(mainWindow mw, ArrayList<String> drillingInputsLabelArray,ArrayList<String> drillingInputsValueArray,
                                   ArrayList<String> rockInputsLabelArray,ArrayList<String> rockInputsValueArray,
                                   ArrayList<String> discontinuitiesInputsLabelArray,ArrayList<String> discontinuitiesInputsValueArray,
                                   ArrayList<String> geomechanicalOutputsLabelArray,ArrayList<String> geomechanicalOutputsValueArray){

        //Grab all of the values to be put in the pdf report

        //drilling labels

        drillingInputsLabelArray.add(mw.getDepthLabel().getText());
        drillingInputsLabelArray.add(mw.getMudWeightLabel().getText());
        drillingInputsLabelArray.add(mw.getGammaLabel().getText());
        drillingInputsLabelArray.add(mw.getAlpha1Label().getText());
        drillingInputsLabelArray.add(mw.getAlpha2Label().getText());
        drillingInputsLabelArray.add(mw.getPoissonLabel().getText());

        if(mw.getPoreCombo().isEnabled()){
            drillingInputsLabelArray.add(mw.getPorePressureTypeLabel().getText());
        }
        if(mw.getFaultTypeCombo().isEnabled()){
            drillingInputsLabelArray.add(mw.getFaultTypeLabel().getText());
        }
        if(mw.getCoefficientManualRadioButton().isSelected()){

            drillingInputsLabelArray.add(mw.getCoeffFrictionLabel().getText());
        }
        if(mw.getTensileManualRadioButton().isSelected()){

            drillingInputsLabelArray.add(mw.getTensileLabel().getText());
        }
        if(mw.getCohesionManualButton().isSelected()){

            drillingInputsLabelArray.add(mw.getCohesionInputLabel().getText());
        }

        drillingInputsLabelArray.add(mw.getInputSigmaVLabel().getText());
        drillingInputsLabelArray.add(mw.getInputSigmaMaxLabel().getText());
        drillingInputsLabelArray.add(mw.getInputSigmaMinLabel().getText());
        drillingInputsLabelArray.add(mw.getInputPorePressureLabel().getText());

        //drilling values

        drillingInputsValueArray.add(mw.getDepthText().getText());
        drillingInputsValueArray.add(mw.getMudWeightText().getText());
        drillingInputsValueArray.add(mw.getGammaText().getText());
        drillingInputsValueArray.add(mw.getAlpha1Text().getText());
        drillingInputsValueArray.add(mw.getAlpha2Text().getText());
        drillingInputsValueArray.add(mw.getPoissonText().getText());

        if(mw.getPoreCombo().isEnabled()){

            drillingInputsValueArray.add(mw.getPoreCombo().getSelectedItem().toString());
        }
        if(mw.getFaultTypeCombo().isEnabled()){
            drillingInputsValueArray.add(mw.getFaultTypeCombo().getSelectedItem().toString());
        }
        if(mw.getCoefficientManualRadioButton().isSelected()){

            drillingInputsValueArray.add(mw.getCoeffFrictionText().getText());
        }
        if(mw.getTensileManualRadioButton().isSelected()){

            drillingInputsValueArray.add(mw.getTensileText().getText());
        }
        if(mw.getCohesionManualButton().isSelected()){

            drillingInputsValueArray.add(mw.getCohesionText().getText());
        }

        drillingInputsValueArray.add(Double.toString(mw.getSigmaVRFinal()));
        drillingInputsValueArray.add(Double.toString(mw.getSigmaHRFinal()));
        drillingInputsValueArray.add(Double.toString(mw.getSigmahRFinal()));
        drillingInputsValueArray.add(Double.toString(mw.getPorePressureGradientFinal()));


        //Rock labels

        rockInputsLabelArray.add(mw.getLithologyLabel().getText());
        rockInputsLabelArray.add(mw.getPermeabilityLabel().getText());
        rockInputsLabelArray.add(mw.getGSILabel().getText());
        rockInputsLabelArray.add(mw.getRockDamageLabel().getText());

        //Rock Values

        rockInputsValueArray.add(mw.getLithologyCombo().getSelectedItem().toString());
        rockInputsValueArray.add(mw.getPermCombo().getSelectedItem().toString());
        rockInputsValueArray.add(mw.getGSITextField().getText());
        rockInputsValueArray.add(mw.getRockDamageTextField().getText());


        //Discontinuities Labels

        discontinuitiesInputsLabelArray.add(mw.getBeddingPlaneConductivityLabel().getText());
        discontinuitiesInputsLabelArray.add(mw.getFaultConductivityLabel().getText());
        discontinuitiesInputsLabelArray.add(mw.getNaturalFractureFrequencyLabel().getText());

        //Discontinuities Values

        discontinuitiesInputsValueArray.add(mw.getBeddingCombo().getSelectedItem().toString());
        discontinuitiesInputsValueArray.add(mw.getFaultConductCombo().getSelectedItem().toString());
        discontinuitiesInputsValueArray.add(mw.getNaturalFractureCombo().getSelectedItem().toString());

        //Geomechanical outputs Labels

        geomechanicalOutputsLabelArray.add(mw.getTensileFailureOutputLabel().getText());
        geomechanicalOutputsLabelArray.add(mw.getShearFailureOutputLabel().getText());
        geomechanicalOutputsLabelArray.add(mw.getPorePressureOutputLabel().getText());
        geomechanicalOutputsLabelArray.add(mw.getTensileStrengthOutputLabel().getText());
        geomechanicalOutputsLabelArray.add(mw.getCohesionOutputLabel().getText());
        geomechanicalOutputsLabelArray.add(mw.getUCSIntactOutputLabel().getText());
        geomechanicalOutputsLabelArray.add(mw.getUCSDamagedOutputLabel().getText());
        geomechanicalOutputsLabelArray.add(mw.getCriticalFracturePressureLabel().getText());
        geomechanicalOutputsLabelArray.add(mw.getCriticalCollapsePressureLabel().getText());
        geomechanicalOutputsLabelArray.add(mw.getFarSigmaVLabel().getText());
        geomechanicalOutputsLabelArray.add(mw.getFarSigmaHLabel().getText());
        geomechanicalOutputsLabelArray.add(mw.getFarSigmahLabel().getText());
        geomechanicalOutputsLabelArray.add(mw.getPrincipalSigma1Label().getText());
        geomechanicalOutputsLabelArray.add(mw.getPrincipalSigma2Label().getText());
        geomechanicalOutputsLabelArray.add(mw.getPrincipalSigma3Label().getText());

        //Geomechanical outputs Values

        geomechanicalOutputsValueArray.add(mw.getTensileFailResult().getText());
        geomechanicalOutputsValueArray.add(mw.getShearFailResult().getText());
        geomechanicalOutputsValueArray.add(mw.getPorePressureTextFieldResult().getText());
        geomechanicalOutputsValueArray.add(mw.getTensileStrengthTextFieldResult().getText());
        geomechanicalOutputsValueArray.add(mw.getCohesionOutputTextField().getText());
        geomechanicalOutputsValueArray.add(mw.getUCSIntactOutputTextField().getText());
        geomechanicalOutputsValueArray.add(mw.getUCSDamagedOutputTextField().getText());
        geomechanicalOutputsValueArray.add(mw.getCriticalFracturePressureTextField().getText());
        geomechanicalOutputsValueArray.add(mw.getCriticalCollapsePressureTextField().getText());
        geomechanicalOutputsValueArray.add(mw.getSigmaVTextFieldResult().getText());
        geomechanicalOutputsValueArray.add(mw.getSigmaMaxTextFieldResult().getText());
        geomechanicalOutputsValueArray.add(mw.getSigmaMinTextFieldResult().getText());
        geomechanicalOutputsValueArray.add(mw.getPrincipal1TextFieldResult().getText());
        geomechanicalOutputsValueArray.add(mw.getPrincipal2TextFieldResult().getText());
        geomechanicalOutputsValueArray.add(mw.getPrincipal3TextFieldResult().getText());
    }
}
