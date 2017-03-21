package Executable;



import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.Arrays;

import com.thehowtotutorial.splashscreen.JSplash;
import org.jfree.chart.ChartPanel;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeriesCollection;


/**
 * Created by Bryan on 10/3/2016.
 */
public class mainWindow extends JFrame {

    private JTabbedPane tabbedPane1;
    private JPanel DrilOutPanel2;
    private JPanel InputPanel1;
    private JPanel WellControlRatingConditionResult;
    private JPanel MainPanel;
    private JPanel JPanelTest;
    private JPanel PicturePanel;

    private JComboBox PoreCombo;
    private JComboBox FaultTypeCombo;
    private JComboBox FaultConductCombo;
    private JComboBox BeddingCombo;
    private JComboBox JointCombo;
    private JComboBox LithologyCombo;
    private JComboBox PermCombo;
    private JComboBox GSICombo;

    private JTextField depthText;
    private JTextField mudWeightText;
    private JTextField gammaText;
    private JTextField alpha1Text;
    private JTextField alpha2Text;
    private JTextField poissonText;
    private JTextField tensileText;
    private JTextField cohesionText;
    private JTextField sigmaVTextField;
    private JTextField sigmaMaxTextField;
    private JTextField sigmaMinTextField;
    private JTextField porePressureTextField;
    private JTextField beddingPlaneStrikeTextField;
    private JTextField faultConductivityStrikeTextField;
    private JTextField jointStrikeTextField;
    private JTextField beddingPlaneDipTextField;
    private JTextField faultConductivityDipTextField;
    private JTextField jointDipTextField;

    private JLabel AlphaImageLabel;
    private JLabel PorePressureResult;
    private JLabel SigmaVResult;
    private JLabel SigmaHResult;
    private JLabel SigmahResult;
    private JLabel Principle1Result;
    private JLabel Principle2Result;
    private JLabel Principle3Result;
    private JLabel TensileFailResult;
    private JLabel ShearFailResult;
    private JLabel InstabilityRating;
    private JLabel LostCirculationRating;
    private JLabel WellControlRating;
    private JLabel LongTermIntegrityRating;
    private JLabel ROPRating;
    private JLabel InstableConditionResult;
    private JLabel LostCirculationConditionResult;
    private JLabel LongTermIntegrityConditionResult;
    private JLabel ROPConditionResult;
    private JLabel WellControlConditionResult;
    private JLabel BetaImageLabel;
    private JLabel depthLabel;
    private JLabel mudWeightLabel;
    private JLabel gammaLabel;
    private JLabel alpha1Label;
    private JLabel alpha2Label;
    private JLabel tensileLabel;
    private JLabel poissonLabel;
    private JLabel inputPorePressureLabel;
    private JLabel inputSigmaMinLabel;
    private JLabel inputSigmaMaxLabel;
    private JLabel inputSigmaVLabel;
    private JLabel beddingPlaneConductivityLabel;
    private JLabel faultConductivityLabel;
    private JLabel jointLabel;
    private JLabel inputStressGradientLabel;
    private JLabel porePressureLabel;
    private JLabel farSigmaVLabel;
    private JLabel farSigmaHLabel;
    private JLabel farSigmahLabel;
    private JLabel principalSigma1Label;
    private JLabel principalSigma2Label;
    private JLabel principalSigma3Label;
    private JLabel tensileStrengthLabel;
    private JLabel inputTensileStrengthLabel;
    private JLabel tensileStrengthOutputLabel;
    private JLabel cohesionOutputLabel;
    private JLabel backgroundImageTest;
    private JLabel cohesionInputLabel;
    private JLabel cohesionTitleLabel;
    private JLabel coeffFrictionLabel;
    private JLabel rockDamageLabel;


    private JTextPane ratingTextPane;

    private JButton calculateButton;
    private JButton clearButton;
    private JButton exportReportButton;
    private JButton GSITableButton;
    private JButton stressPolygonButton;
    private JButton mohrCoulombFailureButton;
    private JButton rockDamageButton;

    private JRadioButton stressAutomaticRadioButton;
    private JRadioButton stressManualInputRadioButton;
    private JRadioButton tensileAutomaticRadioButton;
    private JRadioButton tensileManualRadioButton;
    private JRadioButton cohesionAutomaticButton;
    private JRadioButton cohesionManualButton;

    private JTextField principal1TextFieldResult;
    private JTextField principal2TextFieldResult;
    private JTextField principal3TextFieldResult;
    private JTextField porePressureTextFieldResult;
    private JTextField tensileStrengthTextFieldResult;
    private JTextField sigmaVTextFieldResult;
    private JTextField sigmaMaxTextFieldResult;
    private JTextField sigmaMinTextFieldResult;
    private JTextField cohesionOutputTextField;
    private JTextField coeffFrictionText;
    private JTextField rockDamageTextField;

    private JPanel secondInputsPanel;
    private JPanel unconformityJPanel;
    private JPanel GSILocationSetter;

    private JScrollPane scrollPane;


    private JRadioButton coefficientManualRadioButton;
    private JRadioButton coefficientAutomaticRadioButton;
    private JTextField UCSIntactOutputTextField;
    private JTextField UCSDamagedOutputTextField;
    private JLabel UCSIntactOutputLabel;
    private JLabel UCSDamagedOutputLabel;
    private JTextField GSITextField;
    private JLabel GSILabel;
    private JButton multivariateFailureRatioButton;


    private static String projectSettingButton = "General";
    private static String projectSettingType = "Oil Field Units";
    private static String projectCustomDensityType = "ppg";
    private static String shearCondition = "";
    private static String projectCustomPressureType = "psi";
    private static String projectCustomLengthType = "ft";
    private static double densityUM = 1;
    private static double pressureUM =1;
    private static double lengthUM =1;
    private static double gradientUM = 1;
    private static boolean buttonCount = true;


    //gets the latest version number

    public String getVersionNumber(){

        String versionNumber = "15";
        return versionNumber;
    }

    //getters

    public JLabel getRockDamageLabel() {
        return rockDamageLabel;
    }

    public JLabel getGSILabel(){

        return GSILabel;
    }

    public JTextField getRockDamageTextField() {
        return rockDamageTextField;
    }

    public static String getProjectSettingButton() {
        return projectSettingButton;
    }

    public static String getProjectSettingType() {
        return projectSettingType;
    }

    public static String getProjectCustomDensityType() {
        return projectCustomDensityType;
    }

    public static String getProjectCustomPressureType() {
        return projectCustomPressureType;
    }

    public static String getProjectCustomLengthType() {
        return projectCustomLengthType;
    }

    public JComboBox getFaultConductCombo() {
        return FaultConductCombo;
    }

    public JComboBox getBeddingCombo() {
        return BeddingCombo;
    }

    public JComboBox getJointCombo() {
        return JointCombo;
    }

    public JComboBox getLithologyCombo() {
        return LithologyCombo;
    }

    public JComboBox getPermCombo() {
        return PermCombo;
    }


    public JComboBox getPoreCombo() {
        return PoreCombo;
    }

    public JComboBox getFaultTypeCombo() {
        return FaultTypeCombo;
    }

    public JLabel getTensileFailResult() {
        return TensileFailResult;
    }

    public JLabel getShearFailResult() {
        return ShearFailResult;
    }

    public JLabel getDepthLabel() {
        return depthLabel;
    }

    public JLabel getMudWeightLabel() {
        return mudWeightLabel;
    }

    public JLabel getCohesionInputLabel() {
        return cohesionInputLabel;
    }

    public JLabel getCohesionTitleLabel() {
        return cohesionTitleLabel;
    }

    public JLabel getGammaLabel() {
        return gammaLabel;
    }

    public JLabel getAlpha1Label() {
        return alpha1Label;
    }

    public JLabel getAlpha2Label() {
        return alpha2Label;
    }

    public JLabel getTensileLabel() {
        return tensileLabel;
    }

    public JLabel getPoissonLabel() {
        return poissonLabel;
    }

    public JLabel getInputPorePressureLabel() {
        return inputPorePressureLabel;
    }

    public JLabel getInputSigmaMinLabel() {
        return inputSigmaMinLabel;
    }

    public JLabel getInputSigmaMaxLabel() {
        return inputSigmaMaxLabel;
    }

    public JLabel getInputSigmaVLabel() {
        return inputSigmaVLabel;
    }

    public JLabel getBeddingPlaneConductivityLabel() {
        return beddingPlaneConductivityLabel;
    }

    public JLabel getFaultConductivityLabel() {
        return faultConductivityLabel;
    }

    public JLabel getJointLabel() {
        return jointLabel;
    }

    public JTextField getAlpha1Text() {
        return alpha1Text;
    }

    public JTextField getGammaText() {
        return gammaText;
    }

    public JTextField getAlpha2Text() {
        return alpha2Text;
    }

    public JTextField getGSITextField()  {
        return GSITextField;
    }

    public JTextField getMudWeightText() {
        return mudWeightText;
    }

    public JTextField getTensileText() {
        return tensileText;
    }

    public JTextField getPoissonText() {
        return poissonText;
    }

    public JTextField getDepthText() {
        return depthText;
    }

    public JTextField getCohesionText() {
        return cohesionText;
    }

    public JTextField getCoeffFrictionText() {
        return coeffFrictionText;
    }

    public JTextField getSigmaVTextField() {
        return sigmaVTextField;
    }

    public JTextField getSigmaMaxTextField() {
        return sigmaMaxTextField;
    }

    public JTextField getSigmaMinTextField() {
        return sigmaMinTextField;
    }

    public JTextField getPorePressureTextField() {
        return porePressureTextField;
    }

    public JTextField getBeddingPlaneStrikeTextField() {
        return beddingPlaneStrikeTextField;
    }

    public JTextField getFaultConductivityStrikeTextField() {
        return faultConductivityStrikeTextField;
    }

    public JTextField getJointStrikeTextField() {
        return jointStrikeTextField;
    }

    public JTextField getBeddingPlaneDipTextField() {
        return beddingPlaneDipTextField;
    }

    public JTextField getFaultConductivityDipTextField() {
        return faultConductivityDipTextField;
    }

    public JTextField getJointDipTextField() {
        return jointDipTextField;
    }

    public JTextField getPrincipal1TextFieldResult() {
        return principal1TextFieldResult;
    }

    public JTextField getPrincipal2TextFieldResult() {
        return principal2TextFieldResult;
    }

    public JTextField getPrincipal3TextFieldResult() {
        return principal3TextFieldResult;
    }

    public JTextField getPorePressureTextFieldResult() {
        return porePressureTextFieldResult;
    }

    public JTextField getTensileStrengthTextFieldResult() {
        return tensileStrengthTextFieldResult;
    }





    public JTextField getSigmaVTextFieldResult() {
        return sigmaVTextFieldResult;
    }

    public JTextField getSigmaMaxTextFieldResult() {
        return sigmaMaxTextFieldResult;
    }

    public JTextField getSigmaMinTextFieldResult() {
        return sigmaMinTextFieldResult;
    }

    public JTextField getCohesionOutputTextField() {
        return cohesionOutputTextField;
    }

    public JTextField getUCSIntactOutputTextField() {
        return UCSIntactOutputTextField;
    }

    public JTextField getUCSDamagedOutputTextField() {
        return UCSDamagedOutputTextField;
    }

    public JRadioButton getCoefficientAutomaticRadioButton() {
        return coefficientAutomaticRadioButton;
    }

    public JRadioButton getCohesionAutomaticButton() {
        return cohesionAutomaticButton;
    }

    public JRadioButton getCohesionManualButton() {
        return cohesionManualButton;
    }

    public JRadioButton getStressAutomaticRadioButton() {
        return stressAutomaticRadioButton;
    }

    public JRadioButton getStressManualInputRadioButton() {
        return stressManualInputRadioButton;
    }

    public JRadioButton getTensileAutomaticRadioButton() {
        return tensileAutomaticRadioButton;
    }

    public JRadioButton getTensileManualRadioButton() {
        return tensileManualRadioButton;
    }

    public JLabel getCoeffFrictionLabel() {
        return coeffFrictionLabel;
    }

    //setters


    public void setRockDamageTextField(String text) {
        this.rockDamageTextField.setText(text);
    }

    public void setPoreCombo(String text) {
        getPoreCombo().setSelectedItem(text);
    }

    public void setFaultTypeCombo(String text) {
        FaultTypeCombo.setSelectedItem(text);
    }

    public void setFaultConductCombo(String text) {
        FaultConductCombo.setSelectedItem(text);
    }

    public void setBeddingCombo(String text) {
        BeddingCombo.setSelectedItem(text);
    }

    public void setJointCombo(String text) {
        JointCombo.setSelectedItem(text);
    }

    public void setLithologyCombo(String text) {
        LithologyCombo.setSelectedItem(text);
    }

    public void setPermCombo(String text) {
        PermCombo.setSelectedItem(text);
    }

    public void setGSITextField(String text){

        GSITextField.setText(text);
    }

    public void setDepthText(String text) {
        depthText.setText(text);
    }

    public void setMudWeightText(String text) {
        mudWeightText.setText(text);
    }

    public void setGammaText(String text) {
        gammaText.setText(text);
    }

    public void setAlpha1Text(String text) {
        alpha1Text.setText(text);
    }

    public void setAlpha2Text(String text) {
        alpha2Text.setText(text);
    }

    public void setPoissonText(String text) {
        poissonText.setText(text);
    }

    public void setTensileText(String text) {
        tensileText.setText(text);
    }

    public void setCohesionText(String text) {
        cohesionText.setText(text);
    }

    public void setSigmaVTextField(String text) {
        sigmaVTextField.setText(text);
    }

    public void setSigmaMaxTextField(String text) {
        sigmaMaxTextField.setText(text);
    }

    public void setSigmaMinTextField(String text) {
        sigmaMinTextField.setText(text);
    }

    public void setPorePressureTextField(String text) {
        porePressureTextField.setText(text);
    }

    public void setBeddingPlaneStrikeTextField(String text) {
        beddingPlaneStrikeTextField.setText(text);
    }

    public void setFaultConductivityStrikeTextField(String text) {
        faultConductivityStrikeTextField.setText(text);
    }

    public void setJointStrikeTextField(String text) {
        jointStrikeTextField.setText(text);
    }

    public void setBeddingPlaneDipTextField(String text) {
        beddingPlaneDipTextField.setText(text);
    }

    public void setFaultConductivityDipTextField(String text) {
        faultConductivityDipTextField.setText(text);
    }

    public void setJointDipTextField(String text) {
        jointDipTextField.setText(text);
    }

    public static void setProjectSettingButton(String text) {
        mainWindow.projectSettingButton = text;
    }

    public static void setProjectSettingType(String text) {
        mainWindow.projectSettingType = text;
    }

    public static void setProjectCustomDensityType(String text) {
        mainWindow.projectCustomDensityType = text;

    }

    public static void setProjectCustomPressureType(String text) {
        mainWindow.projectCustomPressureType = text;

    }

    public static void setProjectCustomLengthType(String text) {
        mainWindow.projectCustomLengthType = text;

    }

    public static void setShearCondition(String text) {
        mainWindow.shearCondition = text;
    }
    public void setTensileStrengthOutputLabel(String text) {
        this.tensileStrengthOutputLabel.setText(text);
    }

    public void setInputTensileStrengthLabel(String text) {
        this.inputTensileStrengthLabel.setText(text);
    }

    public void setDepthLabel(String text) {
        this.depthLabel.setText(text);
    }

    public void setMudWeightLabel(String text) {
        this.mudWeightLabel.setText(text);
    }

    public void setCohesionTitleLabel(String text) {
        this.cohesionTitleLabel.setText(text);
    }

    public void setCohesionInputLabel(String text) {
        this.cohesionInputLabel.setText(text);
    }

    public void setCohesionOutputLabel(String text) {
        this.cohesionOutputLabel.setText(text);
    }

    public void setUCSIntactOutputLabel(String text) {
        this.UCSIntactOutputLabel.setText(text);
    }

    public void setUCSDamagedOutputLabel(String text) {
        this.UCSDamagedOutputLabel.setText(text);
    }

    public void setTensileLabel(String text) {
        this.tensileLabel.setText(text);
    }

    public void setInputStressGradientLabel(String text){
        this.inputStressGradientLabel.setText(text);
    }

    public void setPorePressureLabel(String text) {
        this.porePressureLabel.setText(text);
    }

    public void setCoeffFrictionText(String input) {
        this.coeffFrictionText.setText(input);
    }

    public void setFarSigmaVLabel(String text) {
        this.farSigmaVLabel.setText(text);
    }

    public void setFarSigmaHLabel(String text) {
        this.farSigmaHLabel.setText(text);
    }

    public void setFarSigmahLabel(String text) {
        this.farSigmahLabel.setText(text);
    }

    public void setPrincipalSigma1Label(String text) {
        this.principalSigma1Label.setText(text);
    }

    public void setPrincipalSigma2Label(String text) {
        this.principalSigma2Label.setText(text);
    }

    public void setPrincipalSigma3Label(String text) {
        this.principalSigma3Label.setText(text);
    }

    public void setInstableConditionResultText(String stringChange) {
        InstableConditionResult.setText(stringChange);
    }

    public void setLostCirculationConditionResultText(String stringChange) {
        LostCirculationConditionResult.setText(stringChange);
    }

    public void setLongTermIntegrityConditionResultText(String stringChange) {
        LongTermIntegrityConditionResult.setText(stringChange);
    }

    public void setROPConditionResultText(String stringChange) {
        this.ROPConditionResult.setText(stringChange);
    }

    public void setWellControlConditionResultText(String stringChange) {
        WellControlConditionResult.setText(stringChange);
    }

    public double getDensityUM() {
        return densityUM;
    }
    public void setDensityUM(double unitChange){
        densityUM = unitChange;
    }
    public double getPressureUM() {
        return pressureUM;
    }
    public void setPressureUM(double unitChange){
        pressureUM = unitChange;
    }
    public double getLengthUM() {
        return lengthUM;
    }
    public void setLengthUM(double unitChange){
        lengthUM = unitChange;
    }
    public static void setGradientUM(double unitChange) {
        gradientUM = unitChange;
    }


    XYSeriesCollection polygonCollectionfinal;

    XYSeriesCollection mohrCollectionFinal;

    public XYSeriesCollection getPolygonCollectionfinal() {
        return polygonCollectionfinal;
    }

    public void setPolygonCollectionFinal(XYSeriesCollection input) {
        this.polygonCollectionfinal = input;
    }

    public XYSeriesCollection getMohrCollectionFinal() {
        return mohrCollectionFinal;
    }

    public void setMohrCollectionFinal(XYSeriesCollection input) {
        this.mohrCollectionFinal = input;
    }

    double Sigma1Final;
    double Sigma2Final;
    double Sigma3Final;
    double cohesionInitialFinal;
    double coeffFriction;
    double sigmaVFinalGradient;
    double porePressureFinal;

    public double getSigma1Final() {
        return Sigma1Final;
    }

    public double getSigma2Final() {
        return Sigma2Final;
    }

    public double getSigma3Final() {
        return Sigma3Final;
    }

    public double getSigmaVFinalGradient() {
        return sigmaVFinalGradient;
    }

    public double getPorePressureFinal() {
        return porePressureFinal;
    }

    public void setSigma1Final(double input) {
        Sigma1Final = input;
    }

    public void setSigma2Final(double sigma2Final) {
        Sigma2Final = sigma2Final;
    }

    public void setSigma3Final(double input) {
        Sigma3Final = input;
    }

    public void setsigmaVFinalGradient(double input) {
        sigmaVFinalGradient = input;
    }

    public void setPorePressureFinal(double input) {
        porePressureFinal = input;
    }


    public double getCohesionInitialFinal() {
        return cohesionInitialFinal;
    }

    public void setCohesionInitialFinal(double cohesionInitialFinal) {
        this.cohesionInitialFinal = cohesionInitialFinal;
    }

    public double getCoeffFriction() {
        return coeffFriction;
    }

    public void setCoeffFriction(double input) {
        this.coeffFriction = input;
    }

    MohrFailureGraph MohrGraphOutputFinal;

    public MohrFailureGraph getMohrGraphOutputFinal() {
        return MohrGraphOutputFinal;
    }

    public void setMohrGraphOutputFinal(MohrFailureGraph mohrGraphOutputFinal) {
        MohrGraphOutputFinal = mohrGraphOutputFinal;
    }

    //reset everything back to default
    public void resetTool() {

        //resetTool() clears all of the JTextFields and JLabels in the program
        ClearResetValues cv = new ClearResetValues();
        cv.resetTool(mainWindow.this);


        //remove original graphs and reset buttonCount
        try{

            tabbedPane1.remove(4);
            tabbedPane1.remove(3);
            tabbedPane1.remove(2);
            buttonCount = true;
        }
        catch (Exception e2){

        }

        ratingTextPane.setText("");
    }

    public mainWindow() {

        getDepthText().setText("5000");
        getMudWeightText().setText("9");
        getCohesionText().setText("500");
        getGammaText().setText("50");
        getAlpha1Text().setText("50");
        getAlpha2Text().setText("50");
        getBeddingPlaneStrikeTextField().setText("50");
        getFaultConductivityStrikeTextField().setText("50");
        getJointStrikeTextField().setText("50");
        getBeddingPlaneDipTextField().setText("50");
        getFaultConductivityDipTextField().setText("50");
        getJointDipTextField().setText("50");
        getPoissonText().setText(".3");
        getRockDamageTextField().setText(".3");
        getGSITextField().setText("100");


        //Does not let you resize the window
        mainWindow.this.setResizable(false);

        //sets EGI image icon
        URL EGIURL = mainWindow.class.getResource("/Images/EGI.png");
        ImageIcon EGIImageIcon = new ImageIcon(EGIURL);
        Image EGIImage = EGIImageIcon.getImage();
        mainWindow.this.setIconImage(EGIImage);

        //set tool title
        this.setTitle("EGI Exploration Tool");

        DropdownMenu menu = new DropdownMenu();
        menu.buildMenuBar(mainWindow.this);

        //ratingTextPane UI settings in drilling input tab
        ratingTextPane.setBorder(new LineBorder(Color.black,1));
        Font font = new Font("Candara", Font.PLAIN,12);     //set font
        ratingTextPane.setFont(font);       //font
        ratingTextPane.setEditable(false);     // User in the GUI cannot edit the pane now

        //Generate dropdown lists.
        ComboBoxLists listComboLists = new ComboBoxLists();
        String faultList[] = listComboLists.GetFaultTypes();
        String PorePressureList[] = listComboLists.GetPorePressure();
        String FaultConductivityList[] = listComboLists.GetFaultConductivity();

        String JointList[] = listComboLists.GetJoint();
        String BeddingUnconformityList[] = listComboLists.GetBeddingUnconformity();
        String LithologyList[] = listComboLists.GetLithology();
        String PermeabilityList[] = listComboLists.GetPermeability();

        for  (int i =0; i< faultList.length;i++) {
            FaultTypeCombo.addItem(faultList[i]);
        }
        for  (int i =0; i< PorePressureList.length;i++) {
            PoreCombo.addItem(PorePressureList[i]);
        }
        for  (int i =0; i< FaultConductivityList.length;i++) {
            FaultConductCombo.addItem(FaultConductivityList[i]);
        }
        for  (int i =0; i< JointList.length;i++) {
            JointCombo.addItem(JointList[i]);
        }
        for  (int i =0; i< BeddingUnconformityList.length;i++) {
            BeddingCombo.addItem(BeddingUnconformityList[i]);
        }
        for  (int i =0; i< LithologyList.length;i++) {
            LithologyCombo.addItem(LithologyList[i]);
        }

        for  (int i =0; i< PermeabilityList.length;i++) {
        PermCombo.addItem(PermeabilityList[i]);
        }

        //set textfields to non-editable
        principal1TextFieldResult.setEditable(false);
        principal2TextFieldResult.setEditable(false);
        principal3TextFieldResult.setEditable(false);
        sigmaMinTextFieldResult.setEditable(false);
        sigmaMaxTextFieldResult.setEditable(false);
        sigmaVTextFieldResult.setEditable(false);
        porePressureTextFieldResult.setEditable(false);
        tensileStrengthTextFieldResult.setEditable(false);
        cohesionOutputTextField.setEditable(false);
        UCSIntactOutputTextField.setEditable(false);
        UCSDamagedOutputTextField.setEditable(false);

        //set textfield allignment to horizontal
        principal1TextFieldResult.setHorizontalAlignment(SwingConstants.CENTER);
        principal2TextFieldResult.setHorizontalAlignment(SwingConstants.CENTER);
        principal3TextFieldResult.setHorizontalAlignment(SwingConstants.CENTER);
        sigmaMinTextFieldResult.setHorizontalAlignment(SwingConstants.CENTER);
        sigmaMaxTextFieldResult.setHorizontalAlignment(SwingConstants.CENTER);
        sigmaVTextFieldResult.setHorizontalAlignment(SwingConstants.CENTER);
        porePressureTextFieldResult.setHorizontalAlignment(SwingConstants.CENTER);
        tensileStrengthTextFieldResult.setHorizontalAlignment(SwingConstants.CENTER);
        cohesionOutputTextField.setHorizontalAlignment(SwingConstants.CENTER);
        UCSIntactOutputTextField.setHorizontalAlignment(SwingConstants.CENTER);
        UCSDamagedOutputTextField.setHorizontalAlignment(SwingConstants.CENTER);


        //Assemble stress gradient buttongroup
        ButtonGroup stressBg = new ButtonGroup();
        stressBg.add(stressAutomaticRadioButton);
        stressBg.add(stressManualInputRadioButton);

        //set the automatic button as the default
        stressAutomaticRadioButton.setSelected(true);

        //set launch conditional parameters. Kinda redundant, but acts as a failsafe too.
        if(stressAutomaticRadioButton.isSelected()){
            sigmaVTextField.setEnabled(false);
            sigmaMaxTextField.setEnabled(false);
            sigmaMinTextField.setEnabled(false);
            porePressureTextField.setEnabled(false);
            inputPorePressureLabel.setEnabled(false);
            inputSigmaMaxLabel.setEnabled(false);
            inputSigmaMinLabel.setEnabled(false);
            inputSigmaVLabel.setEnabled(false);
            inputStressGradientLabel.setEnabled(false);
            PoreCombo.setEnabled(true);
            FaultTypeCombo.setEnabled(true);
        }
        else{
            sigmaVTextField.setEnabled(true);
            sigmaMaxTextField.setEnabled(true);
            sigmaMinTextField.setEnabled(true);
            porePressureTextField.setEnabled(true);
            inputPorePressureLabel.setEnabled(true);
            inputSigmaMaxLabel.setEnabled(true);
            inputSigmaMinLabel.setEnabled(true);
            inputSigmaVLabel.setEnabled(true);
            inputStressGradientLabel.setEnabled(true);
            PoreCombo.setEnabled(true);
            FaultTypeCombo.setEnabled(true);
        }

        //enable/disable actions when the gradient buttons are clicked.
        stressAutomaticRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sigmaVTextField.setEnabled(false);
                sigmaMaxTextField.setEnabled(false);
                sigmaMinTextField.setEnabled(false);
                porePressureTextField.setEnabled(false);
                inputPorePressureLabel.setEnabled(false);
                inputSigmaMaxLabel.setEnabled(false);
                inputSigmaMinLabel.setEnabled(false);
                inputSigmaVLabel.setEnabled(false);
                inputStressGradientLabel.setEnabled(false);
                PoreCombo.setEnabled(true);
                FaultTypeCombo.setEnabled(true);
            }
        });

        stressManualInputRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                sigmaVTextField.setEnabled(true);
                sigmaMaxTextField.setEnabled(true);
                sigmaMinTextField.setEnabled(true);
                porePressureTextField.setEnabled(true);
                inputPorePressureLabel.setEnabled(true);
                inputSigmaMaxLabel.setEnabled(true);
                inputSigmaMinLabel.setEnabled(true);
                inputSigmaVLabel.setEnabled(true);
                inputStressGradientLabel.setEnabled(true);
                PoreCombo.setEnabled(false);
                FaultTypeCombo.setEnabled(false);
            }
        });

        //Assemble coefficient of friction buttongroup
        ButtonGroup coeffBg = new ButtonGroup();
        coeffBg.add(coefficientAutomaticRadioButton);
        coeffBg.add(coefficientManualRadioButton);

        //set coeff automatic as default
        coefficientAutomaticRadioButton.setSelected(true);

        //set launch conditional parameters. Kinda redundant, but acts as a failsafe too.
        if(coefficientAutomaticRadioButton.isSelected()){
            coeffFrictionText.setEnabled(false);
        }
        else{
            coeffFrictionText.setEnabled(true);
        }

        //enable/disable actions when the gradient buttons are clicked.
        coefficientAutomaticRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                coeffFrictionText.setEnabled(false);
            }
        });

        coefficientManualRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                coeffFrictionText.setEnabled(true);
            }
        });



        //Assemble cohesion buttongroup
        ButtonGroup cohesionBg = new ButtonGroup();
        cohesionBg.add(cohesionAutomaticButton);
        cohesionBg.add(cohesionManualButton);

        cohesionAutomaticButton.setSelected(true);

        //set cohesion buttongroup launch parameters
        if(cohesionAutomaticButton.isSelected()){

            cohesionText.setEnabled(false);
        }
        else{

            cohesionText.setEnabled(true);
        }

        cohesionAutomaticButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cohesionText.setEnabled(false);
            }
        });
        cohesionManualButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cohesionText.setEnabled(true);
            }
        });


        //Assemble tensile button group
        ButtonGroup tensileBG = new ButtonGroup();
        tensileBG.add(tensileAutomaticRadioButton);
        tensileBG.add(tensileManualRadioButton);
        tensileAutomaticRadioButton.setSelected(true);

        if(tensileAutomaticRadioButton.isSelected()){
            tensileText.setEnabled(false);
        }
        else{

            tensileText.setEnabled(true);
        }

        tensileAutomaticRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                tensileText.setEnabled(false);
            }
        });

        tensileManualRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                tensileText.setEnabled(true);
            }
        });
        /*
        //Add alpha and beta images to input panel and resize
        ImageIcon AlphaIcon = new ImageIcon(getClass().getResource(("DrillingGUIPicture.png")));
        ImageResize Test1 = new ImageResize();
        AlphaIcon = Test1.getScaledImage(AlphaIcon,400,300);
        AlphaImageLabel.setIcon(AlphaIcon);

        ImageIcon BetaIcon = new ImageIcon(getClass().getResource(("betaImage.png")));
        ImageResize Test2 = new ImageResize();
        BetaIcon = Test2.getScaledImage(BetaIcon,395,325);
        BetaImageLabel.setIcon(BetaIcon);
        Border b2 = new LineBorder(Color.BLACK, 2);
        BetaImageLabel.setBorder(b2);
*/

        calculateButton.addActionListener(new ActionListener() {
            private boolean checkResult;
            private double mudWeightPsiFt;
            private double phi;
            private double Alpha;
            private double SigmaVR;
            private double SigmaHR;
            private double SigmahR;

            private double porePressureGradient;
            private double SigmaVGradient;
            private double SigmaHGradient;
            private double SigmahGradient;

            private double Sigma1;
            private double Sigma2;
            private double Sigma3;

            private double SV;
            private double SH;
            private double Sh;
            private double ThoXY;
            private double ThoXZ;
            private double ThoYZ;
            private double DeltaP;
            private double SigmaR;
            private double[] SigTheta;
            private double[] SigmaZ;
            private double[] ThoThetaZ;
            private double ThoRTheta;
            private double ThoRZ;

            private String failType;
            private String shearType;
            private double firstInstability;
            private double firstLossOfCirculation;
            private double firstWellControl;
            private double firstLongTermIntegrity;
            private double firstROP;
            private double secondInstability;
            private double secondLossOfCirculation;
            private double secondWellControl;
            private double secondLongTermIntegrity;
            private double secondROP;
            private double thirdInstability;
            private double thirdLossOfCirculation;
            private double thirdWellControl;
            private double thirdLongTermIntegrity;
            private double thirdROP;
            private double fourthInstability;
            private double fourthLossOfCirculation;
            private double fourthWellControl;
            private double fourthLongTermIntegrity;
            private double fourthROP;
            private double fifthInstability;
            private double fifthLossOfCirculation;
            private double fifthWellControl;
            private double fifthLongTermIntegrity;
            private double fifthROP;
            private double sumInstability;
            private double sumLossOfCirculation;
            private double sumWellControl;
            private double sumLongTermIntegrity;
            private double sumROP;
            private double cohesionInitial;
            private double compressiveStrength;
            private double compressiveStrengthIntact;
            private int tensileStrength;
            private int betaAngle;

            double betaFaultParam = -1;
            double betaJointParam = -1;
            double betaUnconformityParam = -1;


            double depth = Double.parseDouble(depthText.getText())*lengthUM;
            double gamma = Double.parseDouble(gammaText.getText());
            double alpha1 = Double.parseDouble(alpha1Text.getText());
            double alpha2 = Double.parseDouble(alpha2Text.getText());
            double poissons = Double.parseDouble(poissonText.getText());
            double rockDamage = Double.parseDouble(rockDamageTextField.getText());
            String GSI = GSITextField.getText();
            String lithology = LithologyCombo.getSelectedItem().toString();
            String permeability = PermCombo.getSelectedItem().toString();
            String faultConductivity = FaultConductCombo.getSelectedItem().toString();
            String jointFrequency = JointCombo.getSelectedItem().toString();
            String beddingConductivity = BeddingCombo.getSelectedItem().toString();


            @Override
            public void actionPerformed(ActionEvent e) {

                //checks all the input values and makes sure they are valid inputs
                TextFieldChecker tfc = new TextFieldChecker();
                checkResult =tfc.runInputCheck(mainWindow.this);

                //if checkresult is false, the button action will not be performed and
                // JDialog warnings will tell you which inputs need to be filled out
                if (checkResult == false){

                }
                else{

                // Equations
                DrillingEquations Equations = new DrillingEquations();
                // Convert mudweight to psi/ft
                mudWeightPsiFt = Double.parseDouble(mudWeightText.getText())*.05194805195*getDensityUM();
                //Retrieve alpha value
                this.Alpha = Equations.Alpha(alpha1,alpha2);

                //Retrieve sigma ranges

                if(stressAutomaticRadioButton.isSelected()) {

                    this.SigmaVR = Equations.SigmaVRange(FaultTypeCombo.getSelectedItem().toString(), PoreCombo.getSelectedItem().toString());
                    this.SigmaHR = Equations.SigmaHRange(FaultTypeCombo.getSelectedItem().toString(), PoreCombo.getSelectedItem().toString());
                    this.SigmahR = Equations.SigmahRange(FaultTypeCombo.getSelectedItem().toString(), PoreCombo.getSelectedItem().toString());
                    this.porePressureGradient = Equations.PorePressureRange(FaultTypeCombo.getSelectedItem().toString(), PoreCombo.getSelectedItem().toString());
                    porePressureTextFieldResult.setText(Integer.toString((int) (porePressureGradient * depth *(1/pressureUM))));

                    //Retrieve sigma values
                    this.SigmaVGradient = Equations.SigmaV(depth,SigmaVR, porePressureGradient);
                    this.SigmaHGradient = Equations.SigmaH(depth,SigmaHR, porePressureGradient);
                    this.SigmahGradient = Equations.Sigmah(depth,SigmahR, porePressureGradient);

                    //Retrieve stress tensors SV, SH, Sh
                    this.SV = Equations.SV(SigmaVGradient, SigmaHGradient, SigmahGradient,gamma,Alpha);
                    this.SH = Equations.SH(SigmaVGradient, SigmaHGradient, SigmahGradient,gamma,Alpha);
                    this.Sh = Equations.Sh(SigmaVGradient, SigmaHGradient, SigmahGradient,gamma,Alpha);

                    // DeltaP
                    this.DeltaP = Equations.deltaP(depth,mudWeightPsiFt, porePressureGradient);

                }
                else{
                    this.SigmaVR = Double.parseDouble(sigmaVTextField.getText())*gradientUM;
                    this.SigmaHR = Double.parseDouble(sigmaMaxTextField.getText())*gradientUM;
                    this.SigmahR = Double.parseDouble(sigmaMinTextField.getText())*gradientUM;
                    this.porePressureGradient = Double.parseDouble(porePressureTextField.getText())*gradientUM;
                    porePressureTextFieldResult.setText(Integer.toString((int) (porePressureGradient*depth*(1/pressureUM))));

                    //Retrieve sigma values
                    this.SigmaVGradient = Equations.SigmaV(depth,SigmaVR, porePressureGradient);
                    this.SigmaHGradient = Equations.SigmaH(depth,SigmaHR, porePressureGradient);
                    this.SigmahGradient = Equations.Sigmah(depth,SigmahR, porePressureGradient);

                    //Retrieve stress tensors SV, SH, Sh
                    this.SV = Equations.SV(SigmaVGradient, SigmaHGradient, SigmahGradient,gamma,Alpha);
                    this.SH = Equations.SH(SigmaVGradient, SigmaHGradient, SigmahGradient,gamma,Alpha);
                    this.Sh = Equations.Sh(SigmaVGradient, SigmaHGradient, SigmahGradient,gamma,Alpha);

                    // DeltaP
                    this.DeltaP = Equations.deltaP(depth,mudWeightPsiFt,porePressureGradient);

                }


                //Retrieve Tho values thoXY, thoXZ, thoYZ
                this.ThoXY = Equations.thoXY(SigmaHGradient, SigmahGradient,Alpha,gamma);
                this.ThoXZ = Equations.thoXZ(SigmaVGradient, SigmaHGradient, SigmahGradient,Alpha,gamma);
                this.ThoYZ = Equations.thoYZ(SigmaHGradient, SigmahGradient,Alpha,gamma);

                // Retrieve SigmaR
                this.SigmaR = Equations.sigmaR(DeltaP);

                // Retrieve SigmaTheta and the input angle that give the maximum SigTheta
                this.SigTheta = Equations.sigmaTheta(SH,Sh,ThoXY,DeltaP);

                // Retrieve sigmaZ
                this.SigmaZ = Equations.sigmaZ(SV,poissons,Sh,SH,ThoXY);

                // Retrieve Tho theta values thoThetaZ,thoRTheta,thoRZ
                this.ThoThetaZ = Equations.thoThetaZ(ThoXZ,ThoYZ);
                this.ThoRTheta = Equations.thoRTheta();
                this.ThoRZ = Equations.thoRZ();

                // Retrieve principal effective stress values

                this.Sigma1 = Equations.sigma1(SigTheta,SigmaZ,ThoThetaZ);
                setSigma1Final(Sigma1);
                double[] sigma1Array = Equations.Sigma1Array(SigTheta,SigmaZ,ThoThetaZ);
                this.Sigma2 = Equations.sigma2(SigTheta,SigmaZ,ThoThetaZ);
                setSigma2Final(Sigma2);
                this.Sigma3 = Equations.sigma3(SigmaR);
                setSigma3Final(Sigma3);
                setPorePressureFinal(porePressureGradient);
                setsigmaVFinalGradient(SigmaVGradient);

                /*
                //find the phi value at the angle that gives the maximum sigma1 value
                phi = Equations.phi(SigTheta,SigmaZ,ThoThetaZ,Equations.sigma1MaxTheta(sigma1Array,this.Sigma1)) ;
                */

                //populate textlabels with value results
                double porePressureCombination = porePressureGradient *depth;

                // Determine if tensile failure
                // conditionals if the automatic or manual tensile radiobuttons are selected
                if(tensileManualRadioButton.isSelected()) {

                    this.failType = Equations.tensileFailureCondition(Sigma2, Double.parseDouble(tensileText.getText())*(1/pressureUM));
                    tensileStrength = (int) (Double.parseDouble(tensileText.getText())*(1/pressureUM));
                    tensileStrengthTextFieldResult.setText(Integer.toString(tensileStrength));
                }
                else if(tensileAutomaticRadioButton.isSelected()){

                    //find compressive strength
                    compressiveStrengthIntact = Equations.rockPropertyGSISolver(this.Sigma1,this.Sigma2,this.Sigma3,GSI,lithology,rockDamage,(SigmaVGradient+porePressureCombination)*(1/pressureUM),"Compressive Strength Intact");
                    compressiveStrength = Equations.rockPropertyGSISolver(this.Sigma1,this.Sigma2,this.Sigma3,GSI,lithology,rockDamage,(SigmaVGradient+porePressureCombination)*(1/pressureUM),"Compressive Strength");
                    tensileStrength = -1*(int) Equations.rockPropertyGSISolver(this.Sigma1,this.Sigma2,this.Sigma3,GSI,lithology,rockDamage,(SigmaVGradient+porePressureCombination)*(1/pressureUM),"Tensile Strength");
                    tensileStrengthTextFieldResult.setText(Integer.toString(tensileStrength));
                    this.failType = Equations.tensileFailureCondition(Sigma2,tensileStrength);

                }

                //Retrieve first set parameters

                this.firstInstability = Equations.firstSetParameters(this.failType,PoreCombo.getSelectedItem().toString(),FaultTypeCombo.getSelectedItem().toString(),"Instability");
                this.firstLossOfCirculation = Equations.firstSetParameters(this.failType,PoreCombo.getSelectedItem().toString(),FaultTypeCombo.getSelectedItem().toString(),"LossOfCirculation");
                this.firstWellControl = Equations.firstSetParameters(this.failType,PoreCombo.getSelectedItem().toString(),FaultTypeCombo.getSelectedItem().toString(),"WellControl");
                this.firstLongTermIntegrity = Equations.firstSetParameters(this.failType,PoreCombo.getSelectedItem().toString(),FaultTypeCombo.getSelectedItem().toString(),"LongTermIntegrity");
                this.firstROP= Equations.firstSetParameters(this.failType,PoreCombo.getSelectedItem().toString(),FaultTypeCombo.getSelectedItem().toString(),"ROP");

                //Retrieve second set parameters

                SecondSetEquations secondEquations = new SecondSetEquations();
                //find unique beta value for each second set type
                betaFaultParam = secondEquations.betaAngle(Integer.parseInt(faultConductivityStrikeTextField.getText()), Equations.sigma1MaxTheta(sigma1Array,this.Sigma1), Integer.parseInt(faultConductivityDipTextField.getText()),Integer.parseInt(gammaText.getText()), phi );
                betaJointParam = secondEquations.betaAngle(Integer.parseInt(jointStrikeTextField.getText()), Equations.sigma1MaxTheta(sigma1Array,this.Sigma1), Integer.parseInt(jointDipTextField.getText()),Integer.parseInt(gammaText.getText()), phi );
                betaUnconformityParam = secondEquations.betaAngle(Integer.parseInt(beddingPlaneStrikeTextField.getText()), Equations.sigma1MaxTheta(sigma1Array,this.Sigma1), Integer.parseInt(beddingPlaneDipTextField.getText()),Integer.parseInt(gammaText.getText()), phi );

                this.secondInstability = secondEquations.secondSetValues(faultConductivity,jointFrequency,beddingConductivity,betaFaultParam,betaJointParam,betaUnconformityParam,"Instability");
                this.secondLossOfCirculation = secondEquations.secondSetValues(faultConductivity,jointFrequency,beddingConductivity,betaFaultParam,betaJointParam,betaUnconformityParam,"LossOfCirculation");
                this.secondWellControl = secondEquations.secondSetValues(faultConductivity,jointFrequency,beddingConductivity,betaFaultParam,betaJointParam,betaUnconformityParam,"WellControl");
                this.secondLongTermIntegrity = secondEquations.secondSetValues(faultConductivity,jointFrequency,beddingConductivity,betaFaultParam,betaJointParam,betaUnconformityParam,"LongTermIntegrity");
                this.secondROP = secondEquations.secondSetValues(faultConductivity,jointFrequency,beddingConductivity,betaFaultParam,betaJointParam,betaUnconformityParam,"ROP");

                //Retrieve third set parameters

                ThirdSetEquations thirdEquations = new ThirdSetEquations();

                this.thirdInstability = ThirdSetEquations.thirdSetParameters(lithology,"Instability");
                this.thirdLossOfCirculation = ThirdSetEquations.thirdSetParameters(lithology,"LossOfCirculation");
                this.thirdWellControl = ThirdSetEquations.thirdSetParameters(lithology,"WellControl");
                this.thirdLongTermIntegrity = ThirdSetEquations.thirdSetParameters(lithology,"LongTermIntegrity");
                this.thirdROP = ThirdSetEquations.thirdSetParameters(lithology,"ROP");

                //Retrieve fourth set parameters

                FourthSetEquations fourthEquations = new FourthSetEquations();

                this.fourthInstability = FourthSetEquations.fourthSetParameters(GSI,"Instability");
                this.fourthLossOfCirculation = FourthSetEquations.fourthSetParameters(GSI,"LossOfCirculation");
                this.fourthWellControl = FourthSetEquations.fourthSetParameters(GSI,"WellControl");
                this.fourthLongTermIntegrity = FourthSetEquations.fourthSetParameters(GSI,"LongTermIntegrity");
                this.fourthROP = FourthSetEquations.fourthSetParameters(GSI,"ROP");

                //Retrieve fifth set parameters

                FifthSetEquations fifthEquations = new FifthSetEquations();

                this.fifthInstability = FifthSetEquations.fifthSetParameters(permeability,"Instability");
                this.fifthLossOfCirculation = FifthSetEquations.fifthSetParameters(permeability,"LossOfCirculation");
                this.fifthWellControl = FifthSetEquations.fifthSetParameters(permeability,"WellControl");
                this.fifthLongTermIntegrity = FifthSetEquations.fifthSetParameters(permeability,"LongTermIntegrity");
                this.fifthROP = FifthSetEquations.fifthSetParameters(permeability,"ROP");


                //Final parameter sums used in solution rubric
                sumInstability = this.firstInstability+this.secondInstability+this.thirdInstability+this.fourthInstability+this.fifthInstability;
                sumLossOfCirculation = this.firstLossOfCirculation+this.secondLossOfCirculation+this.thirdLossOfCirculation+this.fourthLossOfCirculation+this.fifthLossOfCirculation;
                sumWellControl = this.firstWellControl+this.secondWellControl+this.thirdWellControl+this.fourthWellControl+this.fifthWellControl;
                sumLongTermIntegrity = this.firstLongTermIntegrity+this.secondLongTermIntegrity+this.thirdLongTermIntegrity+this.fourthLongTermIntegrity+this.fifthLongTermIntegrity;
                sumROP = this.firstROP+this.secondROP+this.thirdROP+this.fourthROP+this.fifthROP;

                //find cohesionInitial value

                if(cohesionManualButton.isSelected()){

                    cohesionInitial = Double.parseDouble(cohesionText.getText());
                    setCohesionInitialFinal(cohesionInitial*(1/pressureUM));
                }
                else{
                    cohesionInitial = Equations.rockPropertyGSISolver(this.Sigma1,this.Sigma2,this.Sigma3,GSI,lithology,rockDamage,(SigmaVGradient+porePressureCombination),"Cohesion");
                    setCohesionInitialFinal(cohesionInitial);
                }

                //Build Default catagory dataset

                MultiVariateSolutions multiSolutions = new MultiVariateSolutions()  ;
                DefaultCategoryDataset multivariateDataset = multiSolutions.principalStresses(SigmaVGradient,SigmahGradient,depth,mudWeightPsiFt,Alpha,gamma,DeltaP,poissons,gradientUM,porePressureGradient,lengthUM,GSI,lithology,rockDamage,SigmaVGradient+porePressureCombination);


                //Calculate and build stress polygon dataset and Mohr dataset
                StressPolygonDataset polyDataset = new StressPolygonDataset();

                XYSeriesCollection polygonCollection = polyDataset.stressPolygonDataset(this.SigmaVR*lengthUM*(1/pressureUM),(SigmaHGradient+ porePressureCombination)*(1/pressureUM),(this.SigmahGradient+ porePressureCombination)*(1/pressureUM),this.porePressureGradient*lengthUM*(1/pressureUM),depth*(1/lengthUM),getCoeffFriction());
                polygonCollection.removeAllSeries();
                MohrDataset mohrDataset = new MohrDataset();




                XYSeriesCollection mohrCollection = new XYSeriesCollection();
                mohrCollection.removeAllSeries();
                if (coefficientAutomaticRadioButton.isSelected()){

                    setCoeffFriction(Equations.rockPropertyGSISolver(this.Sigma1,this.Sigma2,this.Sigma3,GSI,lithology,rockDamage,(SigmaVGradient+porePressureCombination),"CoeffFriction"));


                    polygonCollection = polyDataset.stressPolygonDataset(this.SigmaVR*lengthUM*(1/pressureUM),(SigmaHGradient+ porePressureCombination)*(1/pressureUM),(this.SigmahGradient+ porePressureCombination)*(1/pressureUM),this.porePressureGradient*lengthUM*(1/pressureUM),depth*(1/lengthUM),getCoeffFriction());

                    setPolygonCollectionFinal(polygonCollection);// sets a grabber for the dataset (used for the stresspolygon button in the initial input tab)

                    mohrCollection = mohrDataset.mohrDatasetBuild(this.Sigma1*(1/pressureUM),this.Sigma2*(1/pressureUM),this.Sigma3*(1/pressureUM),cohesionInitial*(1/pressureUM),getCoeffFriction(),mainWindow.this);

                    setMohrCollectionFinal(mohrCollection);

                    multivariateDataset = multiSolutions.principalStresses(SigmaVGradient,SigmahGradient,depth,mudWeightPsiFt,Alpha,gamma,DeltaP,poissons,gradientUM,porePressureGradient,lengthUM,GSI,lithology,rockDamage,SigmaVGradient+porePressureCombination);


                }

                else if (coefficientManualRadioButton.isSelected()){

                    setCoeffFriction(Double.parseDouble(coeffFrictionText.getText()));

                    polygonCollection = polyDataset.stressPolygonDataset(this.SigmaVR*lengthUM*(1/pressureUM),(SigmaHGradient+ porePressureCombination)*(1/pressureUM),(this.SigmahGradient+ porePressureCombination)*(1/pressureUM),this.porePressureGradient*lengthUM*(1/pressureUM),depth*(1/lengthUM),getCoeffFriction());

                    setPolygonCollectionFinal(polygonCollection);// sets a grabber for the dataset (used for the stresspolygon button in the initial input tab)

                    mohrCollection = mohrDataset.mohrDatasetBuild(this.Sigma1*(1/pressureUM),this.Sigma2*(1/pressureUM),this.Sigma3*(1/pressureUM),cohesionInitial*(1/pressureUM),getCoeffFriction(),mainWindow.this);
                    setMohrCollectionFinal(mohrCollection);

                    multivariateDataset = multiSolutions.principalStresses(SigmaVGradient*(1/pressureUM),SigmahGradient*(1/pressureUM),depth,mudWeightPsiFt,Alpha,gamma,DeltaP,poissons,gradientUM,porePressureGradient,lengthUM,GSI,lithology,rockDamage,(SigmaVGradient+porePressureCombination)*(1/pressureUM));

                }

                    //Determine if shear failure
                    double sigThetaMax;
                    double[] sortedSigTheta = SigTheta.clone();
                    Arrays.sort(sortedSigTheta);
                    sigThetaMax = sortedSigTheta[sortedSigTheta.length-1];

                    if(coefficientManualRadioButton.isSelected()){

                        this.shearType = shearCondition;
                    }
                    else if (coefficientAutomaticRadioButton.isSelected()){

                        double coeffFrictionTest = Equations.rockPropertyGSISolver(this.Sigma1,this.Sigma2,this.Sigma3,GSI,lithology,rockDamage,(SigmaVGradient+porePressureCombination)*(1/pressureUM),"CoeffFriction");
                        this.shearType = shearCondition;
                    }

                //buttonCount is a true/false condition to check if the graph panes are added/removed
                if (buttonCount == true) {
                    StressPolygonGraph polygonGraphOutput = new StressPolygonGraph(polygonCollection, mainWindow.this,projectCustomPressureType);
                    tabbedPane1.addTab("Stress Polygon", null, polygonGraphOutput, null);

                    MohrFailureGraph MohrGraphOutput = new MohrFailureGraph(mohrCollection, Sigma1*(1/pressureUM),Sigma2*(1/pressureUM),projectCustomPressureType,mainWindow.this);
                    setMohrGraphOutputFinal(MohrGraphOutput);
                    tabbedPane1.addTab("Mohr-Coulomb Failure",null,MohrGraphOutput,null);

                    MultivariateSolutionsGraph multiGraph = new MultivariateSolutionsGraph(multivariateDataset,mainWindow.this,projectCustomPressureType);
                    tabbedPane1.addTab("Fracture Ratio", null,multiGraph,null);

                    buttonCount = false;

                }
                else if (buttonCount == false){

                    tabbedPane1.remove(4);
                    tabbedPane1.remove(3);
                    tabbedPane1.remove(2);

                    StressPolygonGraph graphOutput = new StressPolygonGraph(polygonCollection, mainWindow.this,projectCustomPressureType);
                    tabbedPane1.addTab("Stress Polygon", null, graphOutput, null);

                    MohrFailureGraph MohrGraphOutput = new MohrFailureGraph(mohrCollection, Sigma1*(1/pressureUM),Sigma2*(1/pressureUM),projectCustomPressureType,mainWindow.this);
                    setMohrGraphOutputFinal(MohrGraphOutput);
                    tabbedPane1.addTab("Mohr-Coulomb Failure",null,MohrGraphOutput,null);

                    MultivariateSolutionsGraph multiGraph = new MultivariateSolutionsGraph(multivariateDataset,mainWindow.this,projectCustomPressureType);
                    tabbedPane1.addTab("Fracture Ratio", null,multiGraph,null);

                }




                sigmaVTextFieldResult.setText(Integer.toString((int) ((SigmaVGradient +porePressureCombination)*(1/pressureUM))));
                sigmaMaxTextFieldResult.setText(Integer.toString((int) ((SigmaHGradient +porePressureCombination)*(1/pressureUM))));
                sigmaMinTextFieldResult.setText(Integer.toString((int) ((SigmahGradient +porePressureCombination)*(1/pressureUM))));
                principal1TextFieldResult.setText(Integer.toString((int) (Sigma1*(1/pressureUM))));
                principal2TextFieldResult.setText(Integer.toString((int) (Sigma2*(1/pressureUM))));
                principal3TextFieldResult.setText(Integer.toString((int) (Sigma3*(1/pressureUM))));
                cohesionOutputTextField.setText(Integer.toString((int) (cohesionInitial*(1/pressureUM))));
                UCSIntactOutputTextField.setText(Integer.toString((int) (compressiveStrengthIntact*(1/pressureUM))));
                UCSDamagedOutputTextField.setText(Integer.toString((int) (compressiveStrength*(1/pressureUM))));
                TensileFailResult.setText(failType);
                ShearFailResult.setText(shearType);

                //set the stability rating criteria (output under well rating drilling output tab)
                StabilityConditions sc = new StabilityConditions();

                sc.sumInstabilityCriteria(sumInstability,mainWindow.this);
                sc.sumLossCirculationCriteria(sumLossOfCirculation,mainWindow.this);
                sc.sumWellControlCriteria(sumWellControl,mainWindow.this);
                sc.sumLongTermIntegrityCriteria(sumLongTermIntegrity,mainWindow.this);
                sc.sumROPCriteria(sumROP,mainWindow.this);


                //generate rating textpane report

                ReportStrings reportList = new ReportStrings();
                String[] initSt = reportList.getInitString(sumInstability,sumLossOfCirculation,sumWellControl,sumLongTermIntegrity,sumROP);
                SimpleAttributeSet sim = new SimpleAttributeSet();
                StyleConstants.setFontSize(sim,14);

                SimpleAttributeSet keyWord = new SimpleAttributeSet();
                StyleConstants.setFontSize(keyWord,16);
                StyleConstants.setBold(keyWord,true);
                StyleConstants.setUnderline(keyWord, Boolean.TRUE );

                StyledDocument doc = ratingTextPane.getStyledDocument();

                    sumInstability = this.firstInstability+this.secondInstability+this.thirdInstability+this.fourthInstability+this.fifthInstability;
                    sumLossOfCirculation = this.firstLossOfCirculation+this.secondLossOfCirculation+this.thirdLossOfCirculation+this.fourthLossOfCirculation+this.fifthLossOfCirculation;
                    sumWellControl = this.firstWellControl+this.secondWellControl+this.thirdWellControl+this.fourthWellControl+this.fifthWellControl;
                    sumLongTermIntegrity = this.firstLongTermIntegrity+this.secondLongTermIntegrity+this.thirdLongTermIntegrity+this.fourthLongTermIntegrity+this.fifthLongTermIntegrity;
                    sumROP = this.firstROP+this.secondROP+this.thirdROP+this.fourthROP+this.fifthROP;


                    try {
                        ratingTextPane.setText(""); // Resets the pane

                        doc.insertString(ratingTextPane.getStyledDocument().getLength(),"   ",sim);
                        doc.insertString(ratingTextPane.getStyledDocument().getLength(),"Well Instability",keyWord);
                        doc.insertString(ratingTextPane.getStyledDocument().getLength(),"\n\n",sim);
                        doc.insertString(ratingTextPane.getStyledDocument().getLength(),initSt[0]+ "\n\n",sim);

                        doc.insertString(ratingTextPane.getStyledDocument().getLength(),"   ",sim);
                        doc.insertString(ratingTextPane.getStyledDocument().getLength(),"Loss of Circulation",keyWord);
                        doc.insertString(ratingTextPane.getStyledDocument().getLength(),"\n\n",sim);
                        doc.insertString(ratingTextPane.getStyledDocument().getLength(),initSt[1]+"\n\n",sim);

                        doc.insertString(ratingTextPane.getStyledDocument().getLength(),"  ",sim);
                        doc.insertString(ratingTextPane.getStyledDocument().getLength(),"Well Control",keyWord);
                        doc.insertString(ratingTextPane.getStyledDocument().getLength(),"\n\n",sim);
                        doc.insertString(ratingTextPane.getStyledDocument().getLength(),initSt[2]+"\n\n",sim);

                        doc.insertString(ratingTextPane.getStyledDocument().getLength(),"   ",sim);
                        doc.insertString(ratingTextPane.getStyledDocument().getLength(),"Long Term Integrity",keyWord);
                        doc.insertString(ratingTextPane.getStyledDocument().getLength(),"\n\n",sim);
                        doc.insertString(ratingTextPane.getStyledDocument().getLength(),initSt[3]+"\n\n",sim);

                        doc.insertString(ratingTextPane.getStyledDocument().getLength(),"   ",sim);
                        doc.insertString(ratingTextPane.getStyledDocument().getLength(),"Rate of Penetration",keyWord);
                        doc.insertString(ratingTextPane.getStyledDocument().getLength(),"\n\n",sim);
                        doc.insertString(ratingTextPane.getStyledDocument().getLength(),initSt[4]+"\n\n",sim);

                } catch (BadLocationException ble) {
                    System.err.println("Couldn't insert initial text into text pane.");
                }

                    menu.getExportPDF().setEnabled(true); // sets jmenuitem to enabled if the calculation is successful
                    stressPolygonButton.setEnabled(true);
                    mohrCoulombFailureButton.setEnabled(true);
                }


            }

        });

        exportReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PDFCreator pt = new PDFCreator();
                pt.getSaveLocation(mainWindow.this);

            }
        });


        GSIDialog GD = new GSIDialog();

        GSITableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                GD.setContentPane(GD.getContentPane());
                GD.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                GD.pack();
                GD.setLocationRelativeTo(GSILocationSetter);
                GD.setVisible(true);
                GD.setTitle("GSI Selection Table");
            }
        });

        /*
        GSITableButton.addMouseListener(new java.awt.event.MouseAdapter(){

            public void mouseEntered(java.awt.event.MouseEvent evt) {

                GD.setContentPane(GD.contentPane);
                GD.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                GD.pack();
                GD.setLocationRelativeTo(GSILocationSetter);
                GD.setVisible(true);
                GD.setTitle("GSI Selection Table");

            }
            @Override
            public void mouseClicked(MouseEvent e) {

                GD.dispose();
            }
        });
        */

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            resetTool();
            menu.getExportPDF().setEnabled(false); //disables the export option to the jmenuitem if all data is cleared
            stressPolygonButton.setEnabled(false);
            mohrCoulombFailureButton.setEnabled(false);
            }
        });
        stressPolygonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Calculate and build stress polygon dataset and Mohr dataset
                StressPolygonDataset polyDataset = new StressPolygonDataset();


                XYSeriesCollection polygonCollection = getPolygonCollectionfinal();

                StressPolygonGraph polygonGraphOutput = new StressPolygonGraph(polygonCollection, mainWindow.this,getProjectCustomPressureType());
                StressPolygonDialog sd = new StressPolygonDialog();

                ChartPanel cp = polygonGraphOutput.StressPolygonGraphPanel(polygonCollection, mainWindow.this,projectCustomPressureType);
                sd.initialize(cp);


            }
        });
        mohrCoulombFailureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                MohrDataset mohrDataset = new MohrDataset();

                XYSeriesCollection mohrCollection = mohrDataset.mohrDatasetBuild(getSigma1Final()*(1/pressureUM), getSigma2Final()*(1/pressureUM), getSigma3Final()*(1/pressureUM), getCohesionInitialFinal()*(1/pressureUM),getCoeffFriction(),mainWindow.this);

                MohrFailureGraph MohrGraphOutput = new MohrFailureGraph(mohrCollection, getSigma1Final()*(1/pressureUM), getSigma2Final()*(1/pressureUM),projectCustomPressureType,mainWindow.this);

                ChartPanel cp = MohrGraphOutput.MohrFailureGraphPanel(mohrCollection, getSigma1Final()*(1/pressureUM), getSigma2Final()*(1/pressureUM),projectCustomPressureType);

                MohrCoulombDialog mcd = new MohrCoulombDialog();
                mcd.initialize(cp);


            }
        });

        multivariateFailureRatioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MultiVariateSolutions multiSolutions = new MultiVariateSolutions();

            }
        });
        RockDamageDialog RD = new RockDamageDialog();
        rockDamageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                RD.setContentPane(RD.getContentPane());
                RD.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                RD.pack();
                RD.setLocationRelativeTo(GSILocationSetter);
                RD.setVisible(true);
                RD.setTitle("Rock Damage Selection Table");
            }
        });
    }

    //initializer method that builds the frame
    public void initialize(){

        mainWindow.this.setContentPane(this.MainPanel);
        mainWindow.this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.this.pack();
        mainWindow.this.setLocationRelativeTo(null);
        mainWindow.this.setVisible(true);
    }

    //Builds the EGI splash screen
    public void buildSplashScreen(){


        URL splashURL = mainWindow.class.getResource("/Images/tech EGI Splash Image.png");
        ImageIcon splashImage = new ImageIcon(splashURL);
        //Image URL, progres bool, message bool, percent bool, version string, setlocation, textcolor, progress text color
        JSplash splash = new JSplash(splashURL, true, false, true, "Beta Version: " + getVersionNumber() ,null,Color.WHITE,Color.GREEN );

        splash.splashOn();
        splash.setProgress(25);
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        splash.setProgress(50);
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        splash.setProgress(75);
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        splash.setProgress(100);
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        splash.splashOff();


    }

    public static void main(String[] args) {

        mainWindow mw = new mainWindow();
        mw.buildSplashScreen();

        //sets the look and feel
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (Exception e) {
        }

        //builds the GUI and all it's functionality
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                new mainWindow().initialize();
            }
        });
    }


}