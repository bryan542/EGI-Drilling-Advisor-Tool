package Executable;



import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Bryan on 10/4/2016.
 */
//Populates all of the comboboxes on bootup
public class ComboBoxListPopulator {

    private String[] typeFault = {"Normal","Reverse","Strike-slip"};
    private String[] porePressure = {"Hydrostatic","Overpressure", "Underpressure"};
    private String[] faultConductivity = {"High","Medium","Low","Unknown/None"};
    private String[] joint = {"High","Medium","Low","Unknown/None"};
    private String[] beddingUnconformity = {"Highly Conductive","Medium Conductive","Low Conductive","Unknown/None"};
    private String[] lithology = {"Shale","Salt","Sandstone","Siltstone","Limestone","Dolomite"};
    private String[] permeability = {"Low (μD)","Medium (mD)","High (Darcy)"};

    private ArrayList stringArrayList = new ArrayList();
    private ArrayList comboArrayList = new ArrayList();
    public ComboBoxListPopulator(mainWindow mw){

        //adds strings to an arrayList
        stringArrayList.add(typeFault);
        stringArrayList.add(porePressure);
        stringArrayList.add(faultConductivity);
        stringArrayList.add(joint);
        stringArrayList.add(beddingUnconformity);
        stringArrayList.add(lithology);
        stringArrayList.add(permeability);

        //adds the JComboBoxes to an arrayList
        comboArrayList.add(mw.getFaultTypeCombo());
        comboArrayList.add(mw.getPoreCombo());
        comboArrayList.add(mw.getFaultConductCombo());
        comboArrayList.add(mw.getNaturalFractureCombo());
        comboArrayList.add(mw.getBeddingCombo());
        comboArrayList.add(mw.getLithologyCombo());
        comboArrayList.add(mw.getPermCombo());

        //Finds the amount of Strings and their lengths in each array and populates the JComboBoxes
        for(int i = 0;i<stringArrayList.size();i++){

            for(int j = 0;j < ((String[]) stringArrayList.get(i)).length;j++){

                ((JComboBox)comboArrayList.get(i)).addItem(((String[]) stringArrayList.get(i))[j]);
            }
        }

    }

}


