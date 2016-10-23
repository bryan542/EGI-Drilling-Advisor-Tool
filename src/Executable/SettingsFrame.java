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
        densityChange = 1;
        pressureChange =1;
        lengthChange =1;


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
            String depth = "Depth ";
            String mudweight = "Mud Weight ECD ";
            String cohesion = "Cohesion ";
            String tensileStrength = "Tensile Strength ";
            String porePressure = "Pore Pressure ";
            String farSigmaV = "Far-field Vertical Stress σv ";
            String farSigmaH = "Far-field Vertical Stress σH ";
            String farSigmah = "Far-field Vertical Stress σh ";
            String principal1 = "Principal Stress at the Wellbore σ1 ";
            String principal2 = "Principal Stress at the Wellbore σ2 ";
            String principal3 = "Principal Stress at the Wellbore σ3 ";

            @Override
            public void actionPerformed(ActionEvent e) {

                if(generalRadio.isSelected()){

                    if(oilFieldUnitsRadioButton.isSelected() && oilFieldUnitsRadioButton.isEnabled()){
                        densityChange = 1;
                        pressureChange =1;
                        lengthChange =1;
                        String pressure = "(psi)";
                        String density = "(lb/gal)";
                        String length = "(ft)";
                        mw.setDepthLabel(depth+length);
                        mw.setMudWeightLabel(mudweight+density);
                        mw.setCohesionLabel(cohesion+pressure);
                        mw.setTensileLabel(tensileStrength+pressure);
                        mw.setPorePressureLabel(porePressure+pressure);
                        mw.setFarSigmaHLabel(farSigmaH+pressure);
                        mw.setFarSigmahLabel(farSigmah+pressure);
                        mw.setFarSigmaVLabel(farSigmaV+pressure);
                        mw.setPrincipalSigma1Label(principal1+pressure);
                        mw.setPrincipalSigma2Label(principal2+pressure);
                        mw.setPrincipalSigma3Label(principal3+pressure);
                        mw.setDensityUM(densityChange);
                        mw.setPressureUM(pressureChange);
                        mw.setLengthUM(lengthChange);

                    }
                    else if(SIUnitsRadioButton.isSelected() && SIUnitsRadioButton.isEnabled()){

                        densityChange = 8.3454;
                        pressureChange =0.145038;
                        lengthChange =3.28084;
                        String pressure = "(kPa)";
                        String density = "(g/cc)";
                        String length = "(m)";
                        mw.setDepthLabel(depth+length);
                        mw.setMudWeightLabel(mudweight+density);
                        mw.setCohesionLabel(cohesion+pressure);
                        mw.setTensileLabel(tensileStrength+pressure);
                        mw.setPorePressureLabel(porePressure+pressure);
                        mw.setFarSigmaHLabel(farSigmaH+pressure);
                        mw.setFarSigmahLabel(farSigmah+pressure);
                        mw.setFarSigmaVLabel(farSigmaV+pressure);
                        mw.setPrincipalSigma1Label(principal1+pressure);
                        mw.setPrincipalSigma2Label(principal2+pressure);
                        mw.setPrincipalSigma3Label(principal3+pressure);
                        mw.setDensityUM(densityChange);
                        mw.setPressureUM(pressureChange);
                        mw.setLengthUM(lengthChange);
                    }
                    else{

                    }
                }

                else {
                    if (comboBox1.getSelectedItem() =="ppg" && comboBox1.isEnabled()){

                        densityChange = 1;
                        String density = "(lb/gal)";
                        mw.setMudWeightLabel(mudweight+density);
                        mw.setDensityUM(densityChange);
                    }
                    else if(comboBox1.getSelectedItem() =="g/cc" && comboBox1.isEnabled()){

                        densityChange = 8.3454;
                        String density = "(g/cc)";
                        mw.setMudWeightLabel(mudweight+density);
                        mw.setDensityUM(densityChange);
                    }
                    else{

                    }

                    if (comboBox2.getSelectedItem() =="psi" && comboBox2.isEnabled()){

                        pressureChange =1;
                        String pressure = "(psi)";
                        mw.setCohesionLabel(cohesion+pressure);
                        mw.setTensileLabel(tensileStrength+pressure);
                        mw.setPorePressureLabel(porePressure+pressure);
                        mw.setFarSigmaHLabel(farSigmaH+pressure);
                        mw.setFarSigmahLabel(farSigmah+pressure);
                        mw.setFarSigmaVLabel(farSigmaV+pressure);
                        mw.setPrincipalSigma1Label(principal1+pressure);
                        mw.setPrincipalSigma2Label(principal2+pressure);
                        mw.setPrincipalSigma3Label(principal3+pressure);
                        mw.setPressureUM(pressureChange);
                    }
                    else if(comboBox2.getSelectedItem() =="Pa" && comboBox2.isEnabled()){

                        pressureChange =0.145038;
                        String pressure = "(kPa)";
                        mw.setCohesionLabel(cohesion+pressure);
                        mw.setTensileLabel(tensileStrength+pressure);
                        mw.setPorePressureLabel(porePressure+pressure);
                        mw.setFarSigmaHLabel(farSigmaH+pressure);
                        mw.setFarSigmahLabel(farSigmah+pressure);
                        mw.setFarSigmaVLabel(farSigmaV+pressure);
                        mw.setPrincipalSigma1Label(principal1+pressure);
                        mw.setPrincipalSigma2Label(principal2+pressure);
                        mw.setPrincipalSigma3Label(principal3+pressure);
                        mw.setPressureUM(pressureChange);
                    }
                    else{

                    }

                    if (comboBox3.getSelectedItem() =="ft" && comboBox3.isEnabled()){

                        lengthChange =1;
                        String length = "(ft)";
                        mw.setDepthLabel(depth+length);
                        mw.setLengthUM(lengthChange);
                    }
                    else if(comboBox3.getSelectedItem() =="m" && comboBox3.isEnabled()){

                        lengthChange =3.28084;
                        String length = "(m)";
                        mw.setDepthLabel(depth+length);
                        mw.setLengthUM(lengthChange);
                    }
                    else{

                    }
                }

            }

        });


        cancelButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {



            }
        });

    }



}

