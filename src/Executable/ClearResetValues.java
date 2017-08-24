package Executable;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Bryan on 11/2/2016.
 */
public class ClearResetValues {

    public ClearResetValues(){

    }

    public void resetTool(mainWindow mw){

        ArrayList<JTextField> obj = new ArrayList<>();
        ArrayList<JLabel> obj2 = new ArrayList<>();

        //add all of the Jtextfields to obj
        obj.add(mw.getDepthText());
        obj.add(mw.getMudWeightText());
        obj.add(mw.getSigmaVTextField());
        obj.add(mw.getSigmaMaxTextField());
        obj.add(mw.getSigmaMinTextField());
        obj.add(mw.getPorePressureTextField());
        obj.add(mw.getTensileText());
        obj.add(mw.getGammaText());
        obj.add(mw.getAlpha1Text());
        obj.add(mw.getAlpha2Text());
        obj.add(mw.getGSITextField());
        obj.add(mw.getBeddingPlaneStrikeTextField());
        obj.add(mw.getFaultConductivityStrikeTextField());
        obj.add(mw.getJointStrikeTextField());
        obj.add(mw.getBeddingPlaneDipTextField());
        obj.add(mw.getFaultConductivityDipTextField());
        obj.add(mw.getJointDipTextField());
        obj.add(mw.getPoissonText());
        obj.add(mw.getPrincipal1TextFieldResult());
        obj.add(mw.getPrincipal2TextFieldResult());
        obj.add(mw.getPrincipal3TextFieldResult());
        obj.add(mw.getPorePressureTextFieldResult());
        obj.add(mw.getTensileStrengthTextFieldResult());
        obj.add(mw.getUCSIntactOutputTextField());
        obj.add(mw.getUCSDamagedOutputTextField());
        obj.add(mw.getSigmaVTextFieldResult());
        obj.add(mw.getSigmaMaxTextFieldResult());
        obj.add(mw.getSigmaMinTextFieldResult());
        obj.add(mw.getCohesionOutputTextField());
        obj.add(mw.getCoeffFrictionText());
        obj.add(mw.getRockDamageTextField());
        obj.add(mw.getCriticalFracturePressureTextField());

        //add all of the JLabels to obj2
        obj2.add(mw.getTensileFailResult());
        obj2.add(mw.getShearFailResult());

        //looops through the objects and sets them to empty
        for(int i =0;i<obj.size();i++){

            obj.get(i).setText("");
        }

        for(int i = 0;i<obj2.size();i++){

            obj2.get(i).setText("");
        }
    }
}
