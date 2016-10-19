package Executable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import static sun.misc.PostVMInitHook.run;

/**
 * Created by Bryan on 10/13/2016.
 */
public class SettingsFrame extends JFrame{


    public JPanel projectPanel;
    private JTabbedPane projectUnits;
    private JRadioButton generalRadio;
    private JRadioButton oilFieldUnitsRadioButton;
    private JRadioButton SIUnitsRadioButton;
    private JRadioButton customRadio;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JButton applyChangesButton;
    private JButton cancelButton;
    private double test;
    private double densityChange;
    private double pressureChange;
    private double lengthChange;;


    public SettingsFrame(mainWindow mw){

        boolean generalCustom;
        boolean oilfieldSI;



    //Set Image Icon
    URL url = mainWindow.class.getResource("EGI.png");
    ImageIcon bg = new ImageIcon(url);
    this.setIconImage(bg.getImage());

    //populate comboboxes
    String[] densityList = {"ppg","g/cc"};
    String[] pressureList = {"psi","Pa"};
    String[] lengthList = {"ft","m"};

        for (int i =0; i< densityList.length;i++){

        comboBox1.addItem(densityList[i]);

    }
    for (int i =0; i< pressureList.length;i++){

        comboBox2.addItem(pressureList[i]);
    }
    for (int i =0; i< lengthList.length;i++){

        comboBox3.addItem(lengthList[i]);
    }

    //setup buttongroups
    ButtonGroup customGeneralBg = new ButtonGroup();
    customGeneralBg.add(generalRadio);
    customGeneralBg.add(customRadio);
    generalRadio.setSelected(true);


    ButtonGroup standardMetricBg =  new ButtonGroup();
    standardMetricBg.add(oilFieldUnitsRadioButton);
    standardMetricBg.add(SIUnitsRadioButton);
    oilFieldUnitsRadioButton.setSelected(true);

    //buttongroup action/listener setup
    if(generalRadio.isSelected()){
        comboBox1.setEnabled(false);
        comboBox2.setEnabled(false);
        comboBox3.setEnabled(false);
        oilFieldUnitsRadioButton.setEnabled(true);
        SIUnitsRadioButton.setEnabled(true);
    }

    else{
        comboBox1.setEnabled(true);
        comboBox2.setEnabled(true);
        comboBox3.setEnabled(true);
        oilFieldUnitsRadioButton.setEnabled(false);
        SIUnitsRadioButton.setEnabled(false);
    }


    generalRadio.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {



                comboBox1.setEnabled(false);
                comboBox2.setEnabled(false);
                comboBox3.setEnabled(false);
                oilFieldUnitsRadioButton.setEnabled(true);
                SIUnitsRadioButton.setEnabled(true);


        }
    });
    customRadio.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

                comboBox1.setEnabled(true);
                comboBox2.setEnabled(true);
                comboBox3.setEnabled(true);
            oilFieldUnitsRadioButton.setEnabled(false);
            SIUnitsRadioButton.setEnabled(false);

        }
    });

    //Apply unit changes
        applyChangesButton.addActionListener(new ActionListener() {
            double densityChange =mw.getDensityUM();
            double pressureChange=mw.getPressureUM();
            double lengthChange=mw.getLengthUM();

            @Override
            public void actionPerformed(ActionEvent e) {

                if(generalRadio.isSelected()){

                    if(oilFieldUnitsRadioButton.isSelected() && oilFieldUnitsRadioButton.isEnabled()){
                        this.densityChange = 1;
                        pressureChange =1;
                        lengthChange =1;

                    }
                    else if(SIUnitsRadioButton.isSelected() && SIUnitsRadioButton.isEnabled()){

                        densityChange = 8.3454;
                        pressureChange =0.000145038;
                        lengthChange =3.28084;

                    }
                    else{

                    }
                }

                else {
                    if (comboBox1.getSelectedItem() =="ppg" && comboBox1.isEnabled()){

                        densityChange = 1;
                    }
                    else if(comboBox1.getSelectedItem() =="g/cc" && comboBox1.isEnabled()){

                        densityChange = 8.3454;
                    }
                    else{

                    }

                    if (comboBox2.getSelectedItem() =="psi" && comboBox2.isEnabled()){

                        pressureChange =1;
                    }
                    else if(comboBox2.getSelectedItem() =="Pa" && comboBox2.isEnabled()){

                        pressureChange =0.000145038;
                    }
                    else{

                    }

                    if (comboBox3.getSelectedItem() =="ft" && comboBox3.isEnabled()){

                        lengthChange =1;
                    }
                    else if(comboBox3.getSelectedItem() =="m" && comboBox3.isEnabled()){

                        lengthChange =3.28084;
                    }
                    else{

                    }
                }

            }

        });


        cancelButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {

mw.labelChanger("hi");

            }
        });

    }



}

