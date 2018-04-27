package Executable;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class TextFieldSelectAllListeners {

    public TextFieldSelectAllListeners(mainWindow mw){

        final ArrayList<JTextField> obj = new ArrayList<>();
        ArrayList<JLabel> obj2 = new ArrayList<>();

        //add all of the Jtextfields to obj
        obj.add(mw.getDepthText());
        obj.add(mw.getMudWeightText());
        obj.add(mw.getGammaText());
        obj.add(mw.getAlpha1Text());
        obj.add(mw.getAlpha2Text());
        obj.add(mw.getPoissonText());


        obj.add(mw.getSigmaVTextField());
        obj.add(mw.getSigmaMaxTextField());
        obj.add(mw.getSigmaMinTextField());
        obj.add(mw.getPorePressureTextField());

        obj.add(mw.getCoeffFrictionText());
        obj.add(mw.getTensileText());
        obj.add(mw.getCohesionOutputTextField());

        obj.add(mw.getGSITextField());
        obj.add(mw.getRockDamageTextField());

        obj.add(mw.getBeddingPlaneStrikeTextField());
        obj.add(mw.getFaultConductivityStrikeTextField());
        obj.add(mw.getJointStrikeTextField());

        obj.add(mw.getBeddingPlaneDipTextField());
        obj.add(mw.getFaultConductivityDipTextField());
        obj.add(mw.getJointDipTextField());


       for (int i = 0 ; i<obj.size();i++){

           final int j = i;
           obj.get(i).addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                   obj.get(j).selectAll();
               }
           });
       }




    }
}
