package Executable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.MathContext;
import java.net.URL;

/**
 * Created by Bryan on 10/13/2016.
 */
public class SettingDialog extends JDialog{


    private JPanel projectPanel;
    private JRadioButton oilFieldUnitsRadioButton;
    private JRadioButton SIUnitsRadioButton;   ;
    private JButton applyChangesButton;
    private JButton cancelButton;
    private double test;
    private double densityChange;
    private double pressureChange;
    private double lengthChange;
    private double gradientChange;

    double depthTextFieldChange = 0;
    double mudTextFieldChange = 0;
    double tensileTextFieldChange = 0;
    double cohesionTextFieldChange = 0;
    double sigmaVTextFieldChange = 0;
    double sigmaMaxTextFieldChange = 0;
    double sigmaMinTextFieldChange = 0;
    double porePressureFieldChange = 0;

    public SettingDialog(final mainWindow mw, final JMenuItem exportPDF){

        // call onCancel() on ESCAPE
        projectPanel.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        boolean generalCustom;
        boolean oilfieldSI;
        densityChange = 1;
        pressureChange =1;
        lengthChange =1;
        gradientChange = 1;
        String settingButton = mw.getProjectSettingButton();
        String settingType = mw.getProjectSettingType();
        String customDensityType = mw.getProjectCustomDensityType();
        String customPressureType = mw.getProjectCustomPressureType();
        String customLengthType = mw.getProjectCustomLengthType();

    //Set Image Icon
    URL url = mainWindow.class.getResource("/Images/EGI.png");
    ImageIcon bg = new ImageIcon(url);
    this.setIconImage(bg.getImage());

    //populate comboboxes
    String[] densityList = {"ppg","g/cc"};
    String[] pressureList = {"psi","Pa"};
    String[] lengthList = {"ft","m"};


    ButtonGroup standardMetricBg =  new ButtonGroup();
    standardMetricBg.add(oilFieldUnitsRadioButton);
    standardMetricBg.add(SIUnitsRadioButton);


    // this if/else statement makes reloads the project settings if the user comes back to it.
    // Also, this will be used to save/load the project setting data properly

    if(settingType == "Oil Field Units"){
        oilFieldUnitsRadioButton.setSelected(true);
    }
    else if(settingType == "SI Units"){
        SIUnitsRadioButton.setSelected(true);
    }

    //Apply unit changes
        applyChangesButton.addActionListener(new ActionListener() {
            String depth = "Depth ";
            String mudweight = "Mud Weight ";
            String cohesion = "Cohesion ";
            String tensileStrength = "Tensile Strength ";
            String porePressure = "Pore Pressure ";
            String farSigmaV = "Far-field Vertical Stress σv ";
            String farSigmaH = "Far-field Vertical Stress σH ";
            String farSigmah = "Far-field Vertical Stress σh ";
            String principal1 = "Principal Stress at the Wellbore σ1 ";
            String principal2 = "Principal Stress at the Wellbore σ2 ";
            String principal3 = "Principal Stress at the Wellbore σ3 ";
            String inputStressGradients = "Stress Gradients ";
            String UCSIntact = "UCS Intact ";
            String UCSDamaged = "UCS Damaged ";
            String criticalFracture = "Critical Fracture Pressure ";
            String criticalCollapse = "Critical Collapse Pressure";

            @Override
            public void actionPerformed(ActionEvent e) {



               mw.setProjectSettingButton("General");

                if(oilFieldUnitsRadioButton.isSelected() && oilFieldUnitsRadioButton.isEnabled()){
                    mw.setStandardUMBoolean(true);
                    mw.setMetricUMBoolean(false);
                    densityChange = 1;
                    pressureChange =1;
                    lengthChange =1;
                    gradientChange =1;
                    String pressure = "(psi)";
                    String density = "(ppg)";
                    String length = "(ft)";
                    String gradient = "(psi/ft)";
                    mw.setDepthLabel(depth+length);
                    mw.setMudWeightLabel(mudweight+density);
                    mw.setCohesionInputLabel(cohesion+pressure);
                    mw.setCohesionTitleLabel(cohesion+pressure);
                    mw.setCohesionOutputLabel(cohesion+pressure);
                    mw.setUCSIntactOutputLabel(UCSIntact + pressure);
                    mw.setUCSDamagedOutputLabel(UCSDamaged + pressure);
                    mw.setTensileLabel(tensileStrength+pressure);
                    mw.setInputTensileStrengthLabel(tensileStrength+pressure);
                    mw.setTensileStrengthOutputLabel(tensileStrength+pressure);
                    mw.setPorePressureOutputLabel(porePressure+pressure);
                    mw.setFarSigmaHLabel(farSigmaH+pressure);
                    mw.setFarSigmahLabel(farSigmah+pressure);
                    mw.setFarSigmaVLabel(farSigmaV+pressure);
                    mw.setPrincipalSigma1Label(principal1+pressure);
                    mw.setPrincipalSigma2Label(principal2+pressure);
                    mw.setPrincipalSigma3Label(principal3+pressure);
                    mw.setCriticalFracturePressureLabel(criticalFracture +pressure);
                    mw.setCriticalCollapsePressureLabel(criticalCollapse +pressure);
                    mw.setInputStressGradientLabel(inputStressGradients+gradient);
                    mw.setDensityUM(densityChange);
                    mw.setPressureUM(pressureChange);
                    mw.setLengthUM(lengthChange);
                    mw.setGradientUM(gradientChange);
                    mw.setProjectSettingType("Oil Field Units");
                    mw.setProjectCustomPressureType("psi");
                    mw.setProjectCustomDensityType(density);
                    mw.setProjectCustomLengthType(length);
                }
                else if(SIUnitsRadioButton.isSelected() && SIUnitsRadioButton.isEnabled()){
                    mw.setStandardUMBoolean(false);
                    mw.setMetricUMBoolean(true);

                    densityChange = 8.3454;
                    pressureChange =0.145038;
                    lengthChange =3.28084;
                    gradientChange = 4.4208e-5;
                    String pressure = "(kPa)";
                    String density = "(g/cc)";
                    String length = "(m)";
                    String gradient = "(Pa/m)";
                    mw.setDepthLabel(depth+length);
                    mw.setMudWeightLabel(mudweight+density);
                    mw.setCohesionInputLabel(cohesion+pressure);
                    mw.setCohesionTitleLabel(cohesion+pressure);
                    mw.setCohesionOutputLabel(cohesion+pressure);
                    mw.setUCSIntactOutputLabel(UCSIntact + pressure);
                    mw.setUCSDamagedOutputLabel(UCSDamaged + pressure);
                    mw.setTensileLabel(tensileStrength+pressure);
                    mw.setInputTensileStrengthLabel(tensileStrength+pressure);
                    mw.setTensileStrengthOutputLabel(tensileStrength+pressure);
                    mw.setPorePressureOutputLabel(porePressure+pressure);
                    mw.setFarSigmaHLabel(farSigmaH+pressure);
                    mw.setFarSigmahLabel(farSigmah+pressure);
                    mw.setFarSigmaVLabel(farSigmaV+pressure);
                    mw.setPrincipalSigma1Label(principal1+pressure);
                    mw.setPrincipalSigma2Label(principal2+pressure);
                    mw.setPrincipalSigma3Label(principal3+pressure);
                    mw.setCriticalFracturePressureLabel(criticalFracture +pressure);
                    mw.setCriticalCollapsePressureLabel(criticalCollapse +pressure);
                    mw.setInputStressGradientLabel(inputStressGradients+gradient);
                    mw.setDensityUM(densityChange);
                    mw.setPressureUM(pressureChange);
                    mw.setLengthUM(lengthChange);
                    mw.setGradientUM(gradientChange);
                    mw.setProjectSettingType("SI Units");
                    mw.setProjectCustomPressureType("kPa");
                    mw.setProjectCustomDensityType(density);
                    mw.setProjectCustomLengthType(length);
                }
                else{

                }



               if(mw.isMetricUMBoolean() && mw.getMetricUMCount() == 0) {


                   try {
                       depthTextFieldChange = Double.parseDouble(mw.getDepthText().getText()) / lengthChange;
                       BigDecimal bd = new BigDecimal(depthTextFieldChange);
                       bd = bd.round(new MathContext(5));
                       depthTextFieldChange = bd.doubleValue();
                   } catch (Exception e1) {
                   }
                   try {
                       mudTextFieldChange = Double.parseDouble(mw.getMudWeightText().getText()) / densityChange;
                       BigDecimal bd = new BigDecimal(mudTextFieldChange);
                       bd = bd.round(new MathContext(5));
                       mudTextFieldChange = bd.doubleValue();
                   } catch (Exception e1) {
                   }
                   try {
                       tensileTextFieldChange = Double.parseDouble(mw.getTensileText().getText()) / pressureChange;
                       BigDecimal bd = new BigDecimal(tensileTextFieldChange);
                       bd = bd.round(new MathContext(5));
                       tensileTextFieldChange = bd.doubleValue();
                   } catch (Exception e1) {
                   }
                   try {
                       cohesionTextFieldChange = Double.parseDouble(mw.getCohesionText().getText()) / pressureChange;
                       BigDecimal bd = new BigDecimal(cohesionTextFieldChange);
                       bd = bd.round(new MathContext(5));
                       cohesionTextFieldChange = bd.doubleValue();
                   } catch (Exception e1) {
                   }
                   try {
                       sigmaVTextFieldChange = Double.parseDouble(mw.getSigmaVTextField().getText()) / gradientChange;
                       BigDecimal bd = new BigDecimal(sigmaVTextFieldChange);
                       bd = bd.round(new MathContext(5));
                       sigmaVTextFieldChange = bd.doubleValue();
                   } catch (Exception e1) {
                   }
                   try {
                       sigmaMaxTextFieldChange = Double.parseDouble(mw.getSigmaMaxTextField().getText()) / gradientChange;
                       BigDecimal bd = new BigDecimal(sigmaMaxTextFieldChange);
                       bd = bd.round(new MathContext(5));
                       sigmaMaxTextFieldChange = bd.doubleValue();
                   } catch (Exception e1) {
                   }
                   try {
                       sigmaMinTextFieldChange = Double.parseDouble(mw.getSigmaMinTextField().getText()) / gradientChange;
                       BigDecimal bd = new BigDecimal(sigmaMinTextFieldChange);
                       bd = bd.round(new MathContext(5));
                       sigmaMinTextFieldChange = bd.doubleValue();
                   } catch (Exception e1) {
                   }
                   try {
                       porePressureFieldChange = Double.parseDouble(mw.getPorePressureTextField().getText()) / gradientChange;
                       BigDecimal bd = new BigDecimal(porePressureFieldChange);
                       bd = bd.round(new MathContext(5));
                       porePressureFieldChange = bd.doubleValue();
                   } catch (Exception e1) {
                   }
                   mw.getDepthText().setText(Double.toString(depthTextFieldChange));
                   mw.getMudWeightText().setText(Double.toString(mudTextFieldChange));
                   mw.getTensileText().setText(Double.toString(tensileTextFieldChange));
                   mw.getCohesionText().setText(Double.toString(cohesionTextFieldChange));
                   mw.getSigmaVTextField().setText(Double.toString(sigmaVTextFieldChange));
                   mw.getSigmaMaxTextField().setText(Double.toString(sigmaMaxTextFieldChange));
                   mw.getSigmaMinTextField().setText(Double.toString(sigmaMinTextFieldChange));
                   mw.getPorePressureTextField().setText(Double.toString(porePressureFieldChange));

                   mw.setMetricUMCount(1);
                   mw.setStandardUMCount(0);
               }
               else if (mw.isStandardUMBoolean() && mw.getStandardUMCount() == 0){

                   try {
                       depthTextFieldChange = Double.parseDouble(mw.getDepthText().getText()) * 3.28084;
                       BigDecimal bd = new BigDecimal(depthTextFieldChange);
                       bd = bd.round(new MathContext(5));
                       depthTextFieldChange = bd.doubleValue();
                   } catch (Exception e1) {
                   }
                   try {
                       mudTextFieldChange = Double.parseDouble(mw.getMudWeightText().getText()) * 8.3454;
                       BigDecimal bd = new BigDecimal(mudTextFieldChange);
                       bd = bd.round(new MathContext(5));
                       mudTextFieldChange = bd.doubleValue();
                   } catch (Exception e1) {
                   }
                   try {
                       tensileTextFieldChange = Double.parseDouble(mw.getTensileText().getText()) * .145038;
                       BigDecimal bd = new BigDecimal(tensileTextFieldChange);
                       bd = bd.round(new MathContext(5));
                       tensileTextFieldChange = bd.doubleValue();
                   } catch (Exception e1) {
                   }
                   try {
                       cohesionTextFieldChange = Double.parseDouble(mw.getCohesionText().getText()) * .145038;
                       BigDecimal bd = new BigDecimal(cohesionTextFieldChange);
                       bd = bd.round(new MathContext(5));
                       cohesionTextFieldChange = bd.doubleValue();
                   } catch (Exception e1) {
                   }
                   try {
                       sigmaVTextFieldChange = Double.parseDouble(mw.getSigmaVTextField().getText()) * 4.4208e-5;
                       BigDecimal bd = new BigDecimal(sigmaVTextFieldChange);
                       bd = bd.round(new MathContext(5));
                       sigmaVTextFieldChange = bd.doubleValue();
                   } catch (Exception e1) {
                   }
                   try {
                       sigmaMaxTextFieldChange = Double.parseDouble(mw.getSigmaMaxTextField().getText()) * 4.4208e-5;
                       BigDecimal bd = new BigDecimal(sigmaMaxTextFieldChange);
                       bd = bd.round(new MathContext(5));
                       sigmaMaxTextFieldChange = bd.doubleValue();
                   } catch (Exception e1) {
                   }
                   try {
                       sigmaMinTextFieldChange = Double.parseDouble(mw.getSigmaMinTextField().getText()) * 4.4208e-5;
                       BigDecimal bd = new BigDecimal(sigmaMinTextFieldChange);
                       bd = bd.round(new MathContext(5));
                       sigmaMinTextFieldChange = bd.doubleValue();
                   } catch (Exception e1) {
                   }
                   try {
                       porePressureFieldChange = Double.parseDouble(mw.getPorePressureTextField().getText()) * 4.4208e-5;
                       BigDecimal bd = new BigDecimal(porePressureFieldChange);
                       bd = bd.round(new MathContext(5));
                       porePressureFieldChange = bd.doubleValue();
                   } catch (Exception e1) {
                   }
                   mw.getDepthText().setText(Double.toString(depthTextFieldChange));
                   mw.getMudWeightText().setText(Double.toString(mudTextFieldChange));
                   mw.getTensileText().setText(Double.toString(tensileTextFieldChange));
                   mw.getCohesionText().setText(Double.toString(cohesionTextFieldChange));
                   mw.getSigmaVTextField().setText(Double.toString(sigmaVTextFieldChange));
                   mw.getSigmaMaxTextField().setText(Double.toString(sigmaMaxTextFieldChange));
                   mw.getSigmaMinTextField().setText(Double.toString(sigmaMinTextFieldChange));
                   mw.getPorePressureTextField().setText(Double.toString(porePressureFieldChange));

                   mw.setMetricUMCount(0);
                   mw.setStandardUMCount(1);

               }
                exportPDF.setEnabled(false); // sets the jmenuitem to disabled if we clear values

                dispose();
            }

        });


        cancelButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {

            dispose();

            }
        });

    }

    public void initialize(){

        setContentPane(projectPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Project Settings");
    }

}

