package Executable;



import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import com.qoppa.pdfWriter.PDFDocument;
import com.thehowtotutorial.splashscreen.JSplash;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeriesCollection;


/**
 * Created by Bryan on 10/3/2016.
 */
//This is the main frame execution class
public class mainWindow extends JFrame {

    private JTabbedPane tabbedPane1;
    private JPanel DrilOutPanel2;
    private JPanel InputPanel1;
    private JPanel WellControlRatingConditionResult;
    private JPanel MainPanel;
    private JPanel JPanelTest;
    private JPanel PicturePanel;
    private JPanel secondInputsPanel;
    private JPanel unconformityJPanel;
    private JPanel GSILocationSetter;

    private JComboBox poreCombo;
    private JComboBox faultTypeCombo;
    private JComboBox faultConductCombo;
    private JComboBox beddingCombo;
    private JComboBox naturalFractureCombo;
    private JComboBox lithologyCombo;
    private JComboBox permCombo;


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
    private JTextField criticalFailurePressureTextField;
    private JTextField UCSIntactOutputTextField;
    private JTextField UCSDamagedOutputTextField;
    private JTextField GSITextField;

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
    private JLabel naturalFractureFrequencyLabel;
    private JLabel inputStressGradientLabel;
    private JLabel porePressureOutputLabel;
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
    private JLabel UCSIntactOutputLabel;
    private JLabel UCSDamagedOutputLabel;
    private JLabel GSILabel;
    private JLabel criticalFailurePressureLabel;
    private JLabel faultTypeLabel;
    private JLabel porePressureTypeLabel;
    private JLabel lithologyLabel;
    private JLabel permeabilityLabel;
    private JLabel tensileFailureOutputLabel;
    private JLabel shearFailureOutputLabel;
    private JPanel criticalFailureOutputLabel;

    private JTextPane ratingTextPane;

    private JButton calculateButton;
    private JButton clearButton;
    private JButton exportReportButton;
    private JButton GSITableButton;
    private JButton stressPolygonButton;
    private JButton mohrCoulombFailureButton;
    private JButton rockDamageButton;
    private JButton formationPressureButton;

    private JRadioButton stressAutomaticRadioButton;
    private JRadioButton stressManualInputRadioButton;
    private JRadioButton tensileAutomaticRadioButton;
    private JRadioButton tensileManualRadioButton;
    private JRadioButton cohesionAutomaticButton;
    private JRadioButton cohesionManualButton;
    private JRadioButton coefficientManualRadioButton;
    private JRadioButton coefficientAutomaticRadioButton;

    private JScrollPane scrollPane;

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
        return faultConductCombo;
    }

    public JComboBox getBeddingCombo() {
        return beddingCombo;
    }

    public JComboBox getNaturalFractureCombo() {
        return naturalFractureCombo;
    }

    public JComboBox getLithologyCombo() {
        return lithologyCombo;
    }

    public JComboBox getPermCombo() {
        return permCombo;
    }

    public JComboBox getPoreCombo() {
        return poreCombo;
    }

    public JComboBox getFaultTypeCombo() {
        return faultTypeCombo;
    }


    public JLabel getRockDamageLabel() {
        return rockDamageLabel;
    }

    public JLabel getGSILabel(){

        return GSILabel;
    }

    public JLabel getPorePressureOutputLabel() {
        return porePressureOutputLabel;
    }

    public JLabel getFarSigmaVLabel() {
        return farSigmaVLabel;
    }

    public JLabel getFarSigmaHLabel() {
        return farSigmaHLabel;
    }

    public JLabel getFarSigmahLabel() {
        return farSigmahLabel;
    }

    public JLabel getPrincipalSigma1Label() {
        return principalSigma1Label;
    }

    public JLabel getPrincipalSigma2Label() {
        return principalSigma2Label;
    }

    public JLabel getPrincipalSigma3Label() {
        return principalSigma3Label;
    }

    public JLabel getTensileStrengthOutputLabel() {
        return tensileStrengthOutputLabel;
    }

    public JLabel getCohesionOutputLabel() {
        return cohesionOutputLabel;
    }

    public JLabel getUCSIntactOutputLabel() {
        return UCSIntactOutputLabel;
    }

    public JLabel getUCSDamagedOutputLabel() {
        return UCSDamagedOutputLabel;
    }

    public JLabel getCriticalFailurePressureLabel() {
        return criticalFailurePressureLabel;
    }

    public JLabel getLithologyLabel() {
        return lithologyLabel;
    }

    public JLabel getPermeabilityLabel() {
        return permeabilityLabel;
    }

    public JLabel getTensileFailureOutputLabel() {
        return tensileFailureOutputLabel;
    }

    public JLabel getShearFailureOutputLabel() {
        return shearFailureOutputLabel;
    }

    public JPanel getCriticalFailureOutputLabel() {
        return criticalFailureOutputLabel;
    }


    public JLabel getPorePressureTypeLabel() {
        return porePressureTypeLabel;
    }

    public JLabel getFaultTypeLabel() {
        return faultTypeLabel;
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

    public JLabel getNaturalFractureFrequencyLabel() {
        return naturalFractureFrequencyLabel;
    }

    public JTextField getRockDamageTextField() {
        return rockDamageTextField;
    }

    public JTextField getCriticalFailurePressureTextField() {
        return criticalFailurePressureTextField;
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

    public JRadioButton getCoefficientManualRadioButton() {
        return coefficientManualRadioButton;
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
        faultTypeCombo.setSelectedItem(text);
    }

    public void setFaultConductCombo(String text) {
        faultConductCombo.setSelectedItem(text);
    }

    public void setBeddingCombo(String text) {
        beddingCombo.setSelectedItem(text);
    }

    public void setNaturalFractureCombo(String text) {
        naturalFractureCombo.setSelectedItem(text);
    }

    public void setLithologyCombo(String text) {
        lithologyCombo.setSelectedItem(text);
    }

    public void setPermCombo(String text) {
        permCombo.setSelectedItem(text);
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

    public void setPorePressureOutputLabel(String text) {
        this.porePressureOutputLabel.setText(text);
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


    public void setCriticalFailurePressureLabel(String text) {
        this.criticalFailurePressureLabel.setText(text);
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
    private double porePressureCombinationFinal;
    private double SigmaVRFinal =-1;
    private double SigmaHRFinal = -1;
    private double SigmahRFinal = -1;
    private double porePressureGradientFinal = -1;

    public double getSigma1Final() {
        return Sigma1Final;
    }
    public double getSigma2Final() {
        return Sigma2Final;
    }
    public double getSigma3Final() {
        return Sigma3Final;
    }
    public double getPorePressureCombinationFinal(){

        return porePressureCombinationFinal;
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
    //pressure gradient
    public void setPorePressureFinal(double input) {
        porePressureFinal = input;
    }
    //pressure*depth result
    public void setPorePressureCombinationFinal(double input){


        porePressureCombinationFinal = input;
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

    public double getSigmaVRFinal() {
        return SigmaVRFinal;
    }
    public double getSigmaHRFinal() {
        return SigmaHRFinal;
    }
    public double getSigmahRFinal() {
        return SigmahRFinal;
    }
    public double getPorePressureGradientFinal() {
        return porePressureGradientFinal;
    }
    public double setSigmaVRFinal(double value) {
        SigmaVRFinal = value;
        return SigmaVRFinal;
    }
    public double setSigmaHRFinal(double value) {
        SigmaHRFinal = value;
        return SigmaHRFinal;
    }
    public double setSigmahRFinal(double value) {
        SigmahRFinal = value;
        return SigmahRFinal;
    }
    public double setPorePressureGradientFinal(double value) {
        porePressureGradientFinal = value;
        return porePressureGradientFinal;
    }

    //pdf generated arrays that will be used
    ArrayList<String> drillingInputsLabelArray = new ArrayList();
    ArrayList<String> drillingInputsValueArray = new ArrayList();
    ArrayList<String> rockInputsLabelArray = new ArrayList();
    ArrayList<String> rockInputsValueArray = new ArrayList();
    ArrayList<String> discontinuitiesInputsLabelArray = new ArrayList<>();
    ArrayList<String> discontinuitiesInputsValueArray = new ArrayList<>();
    ArrayList<String> geomechanicalOutputsLabelArray = new ArrayList<>();
    ArrayList<String> geomechanicalOutputsValueArray = new ArrayList<>();
    ArrayList<ArrayList> arrayLabelHolder = new ArrayList();
    ArrayList<ArrayList> arrayValueHolder = new ArrayList();
    ArrayList<BufferedImage> chartBufferedImagesArray = new ArrayList();


    PDFDocument drillingPDFDoc = new PDFDocument();

    JFreeChart stressPolygonChart = null;
    JFreeChart formationPressureChart = null;
    JFreeChart mohrFailureChart = null;
    JFreeChart shearBarChart = null;
    JFreeChart tensileBarChart = null;

    public PDFDocument getDrillingPDFDoc() {
        return drillingPDFDoc;
    }

    public JFreeChart getStressPolygonChart() {
        return stressPolygonChart;
    }

    public JFreeChart getFormationPressureChart() {
        return formationPressureChart;
    }

    public JFreeChart getMohrFailureChart() {
        return mohrFailureChart;
    }

    public JFreeChart getShearBarChart() {
        return shearBarChart;
    }

    public JFreeChart getTensileBarChart() {
        return tensileBarChart;
    }

    public void setStressPolygonChart(JFreeChart stressPolygonChart) {
        this.stressPolygonChart = stressPolygonChart;
    }

    public void setFormationPressureChart(JFreeChart formationPressureChart) {
        this.formationPressureChart = formationPressureChart;
    }

    public void setMohrFailureChart(JFreeChart mohrFailureChart) {
        this.mohrFailureChart = mohrFailureChart;
    }

    public void setShearBarChart(JFreeChart shearBarChart) {
        this.shearBarChart = shearBarChart;
    }

    public void setTensileBarChart(JFreeChart tensileBarChart) {
        this.tensileBarChart = tensileBarChart;
    }

    public ArrayList<BufferedImage> getChartBufferedImagesArray() {
        return chartBufferedImagesArray;
    }

    public ArrayList<ArrayList> getArrayLabelHolder() {
        return arrayLabelHolder;
    }

    public ArrayList<ArrayList> getArrayValueHolder() {
        return arrayValueHolder;
    }

    public ArrayList<String> getDrillingInputsLabelArray() {
        return drillingInputsLabelArray;
    }

    public ArrayList<String> getDrillingInputsValueArray() {
        return drillingInputsValueArray;
    }

    public ArrayList<String> getRockInputsLabelArray() {
        return rockInputsLabelArray;
    }

    public ArrayList<String> getRockInputsValueArray() {
        return rockInputsValueArray;
    }

    public ArrayList<String> getDiscontinuitiesInputsLabelArray() {
        return discontinuitiesInputsLabelArray;
    }

    public ArrayList<String> getDiscontinuitiesInputsValueArray() {
        return discontinuitiesInputsValueArray;
    }

    public ArrayList<String> getGeomechanicalOutputsLabelArray() {
        return geomechanicalOutputsLabelArray;
    }

    public ArrayList<String> getGeomechanicalOutputsValueArray() {
        return geomechanicalOutputsValueArray;
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

            tabbedPane1.remove(6);
            tabbedPane1.remove(5);
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

        getDepthText().setText("10000");
        getMudWeightText().setText("16.0561");
        getCohesionText().setText("500");
        getGammaText().setText("0");
        getAlpha1Text().setText("90");
        getAlpha2Text().setText("0");
        getBeddingPlaneStrikeTextField().setText("50");
        getFaultConductivityStrikeTextField().setText("50");
        getJointStrikeTextField().setText("50");
        getBeddingPlaneDipTextField().setText("50");
        getFaultConductivityDipTextField().setText("50");
        getJointDipTextField().setText("50");
        getPoissonText().setText(".3");
        getRockDamageTextField().setText(".3");
        getGSITextField().setText("100");
        getSigmaVTextField().setText(".9");
        getSigmaMaxTextField().setText(".8");
        getSigmaMinTextField().setText(".6");
        getPorePressureTextField().setText(".433");




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
            faultTypeCombo.addItem(faultList[i]);
        }
        for  (int i =0; i< PorePressureList.length;i++) {
            poreCombo.addItem(PorePressureList[i]);
        }
        for  (int i =0; i< FaultConductivityList.length;i++) {
            faultConductCombo.addItem(FaultConductivityList[i]);
        }
        for  (int i =0; i< JointList.length;i++) {
            naturalFractureCombo.addItem(JointList[i]);
        }
        for  (int i =0; i< BeddingUnconformityList.length;i++) {
            beddingCombo.addItem(BeddingUnconformityList[i]);
        }
        for  (int i =0; i< LithologyList.length;i++) {
            lithologyCombo.addItem(LithologyList[i]);
        }

        for  (int i =0; i< PermeabilityList.length;i++) {
        permCombo.addItem(PermeabilityList[i]);
        }

        //disables jbuttons until calculated occurs
        tabbedPane1.setEnabledAt(1,false);
        stressPolygonButton.setEnabled(false);
        mohrCoulombFailureButton.setEnabled(false);
        formationPressureButton.setEnabled(false);

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
            poreCombo.setEnabled(true);
            faultTypeCombo.setEnabled(true);
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
            poreCombo.setEnabled(true);
            faultTypeCombo.setEnabled(true);
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
                poreCombo.setEnabled(true);
                faultTypeCombo.setEnabled(true);
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
                poreCombo.setEnabled(false);
                faultTypeCombo.setEnabled(false);
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

            private double sigmaZ;
            private double sigmaX;
            private double sigmaY;
            private double ThoXY;
            private double ThoXZ;
            private double ThoYZ;
            private double DeltaP;
            private double SigmaR;
            private double SigTheta;
            private double SigmaZ;
            private double ThoThetaZ;
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

            double failureAngle = -1;
            double depth = -1;
            double gamma = -1;
            double alpha1 = -1;
            double alpha2 = -1;
            double poissons = -1;
            double rockDamage = -1;
            String GSI = "";
            String lithology = "";
            String permeability = "";
            String faultConductivity = "";
            String jointFrequency = "";
            String beddingConductivity = "";


            @Override
            public void actionPerformed(ActionEvent e) {

                depth = Double.parseDouble(depthText.getText())*lengthUM;
                gamma = Double.parseDouble(gammaText.getText());
                alpha1 = Double.parseDouble(alpha1Text.getText());
                alpha2 = Double.parseDouble(alpha2Text.getText());
                poissons = Double.parseDouble(poissonText.getText());
                rockDamage = Double.parseDouble(rockDamageTextField.getText());
                GSI = GSITextField.getText();
                lithology = lithologyCombo.getSelectedItem().toString();
                permeability = permCombo.getSelectedItem().toString();
                faultConductivity = faultConductCombo.getSelectedItem().toString();
                jointFrequency = naturalFractureCombo.getSelectedItem().toString();
                beddingConductivity = beddingCombo.getSelectedItem().toString();

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
                    mudWeightPsiFt = Double.parseDouble(mudWeightText.getText())*.0529*getDensityUM();
                    //Retrieve alpha value
                    this.Alpha = Equations.Alpha(alpha1,alpha2);

                    //Retrieve sigma ranges

                    if(stressAutomaticRadioButton.isSelected()) {

                        this.SigmaVR = Equations.sigmaVRange();
                        this.SigmaHR = Equations.sigmaHRange(faultTypeCombo.getSelectedItem().toString(), poreCombo.getSelectedItem().toString());
                        this.SigmahR = Equations.sigmahRange(faultTypeCombo.getSelectedItem().toString(), poreCombo.getSelectedItem().toString());
                        this.porePressureGradient = Equations.porePressureRange(faultTypeCombo.getSelectedItem().toString(), poreCombo.getSelectedItem().toString());
                        porePressureTextFieldResult.setText(Integer.toString((int) (porePressureGradient * depth *(1/pressureUM))));

                        setSigmaVRFinal(this.SigmaVR);
                        setSigmaHRFinal(this.SigmaHR);
                        setSigmahRFinal(this.SigmahR);
                        setPorePressureGradientFinal(this.porePressureGradient);

                        //Retrieve sigma values
                        this.SigmaVGradient = Equations.SigmaV(depth,SigmaVR, porePressureGradient);
                        this.SigmaHGradient = Equations.sigmaH(depth,SigmaHR, porePressureGradient);
                        this.SigmahGradient = Equations.sigmah(depth,SigmahR, porePressureGradient);

                        //Retrieve stress tensors sigZ, sigX, sigY
                        this.sigmaZ = Equations.sigZ(SigmaVGradient, SigmaHGradient, SigmahGradient,gamma,Alpha);
                        this.sigmaX = Equations.sigX(SigmaVGradient, SigmaHGradient, SigmahGradient,gamma,Alpha);
                        this.sigmaY = Equations.sigY(SigmaHGradient, SigmahGradient, Alpha);

                        // DeltaP
                        this.DeltaP = Equations.deltaP(depth,mudWeightPsiFt, porePressureGradient);

                    }
                    else{
                        this.SigmaVR = Double.parseDouble(sigmaVTextField.getText())*gradientUM;
                        this.SigmaHR = Double.parseDouble(sigmaMaxTextField.getText())*gradientUM;
                        this.SigmahR = Double.parseDouble(sigmaMinTextField.getText())*gradientUM;
                        this.porePressureGradient = Double.parseDouble(porePressureTextField.getText())*gradientUM;
                        porePressureTextFieldResult.setText(Integer.toString((int) (porePressureGradient*depth*(1/pressureUM))));

                        setSigmaVRFinal(this.SigmaVR);
                        setSigmaHRFinal(this.SigmaHR);
                        setSigmahRFinal(this.SigmahR);
                        setPorePressureGradientFinal(this.porePressureGradient);
                        //Retrieve sigma values
                        this.SigmaVGradient = Equations.SigmaV(depth,SigmaVR, porePressureGradient);
                        this.SigmaHGradient = Equations.sigmaH(depth,SigmaHR, porePressureGradient);
                        this.SigmahGradient = Equations.sigmah(depth,SigmahR, porePressureGradient);

                        //Retrieve stress tensors sigZ, sigX, sigY
                        this.sigmaX = Equations.sigX(SigmaVGradient, SigmaHGradient, SigmahGradient,gamma,Alpha);
                        this.sigmaY = Equations.sigY(SigmaHGradient, SigmahGradient, Alpha);
                        this.sigmaZ = Equations.sigZ(SigmaVGradient, SigmaHGradient, SigmahGradient,gamma,Alpha);

                        // DeltaP
                        this.DeltaP = Equations.deltaP(depth,mudWeightPsiFt,porePressureGradient);

                    }


                    //Retrieve Tho values thoXY, thoXZ, thoYZ
                    this.ThoXY = Equations.thoXY(SigmaHGradient, SigmahGradient,Alpha,gamma);
                    this.ThoXZ = Equations.thoXZ(SigmaVGradient, SigmaHGradient, SigmahGradient,Alpha,gamma);
                    this.ThoYZ = Equations.thoYZ(SigmaHGradient, SigmahGradient,Alpha,gamma);

                    // Retrieve SigmaR
                    this.SigmaR = Equations.sigmaR(depth*mudWeightPsiFt);

                    //Find the angle that failure will occur first
                    this.failureAngle = Equations.failureAngle(ThoXY,sigmaX,sigmaY);

                    // Retrieve SigmaTheta and the input angle that give the maximum SigTheta
                    this.SigTheta = Equations.sigmaTheta(sigmaX, sigmaY,ThoXY, failureAngle,depth*mudWeightPsiFt);

                    // Retrieve sigmaZ
                    this.SigmaZ = Equations.sigmaZ(sigmaZ,poissons, sigmaY, sigmaX,ThoXY,failureAngle);

                    // Retrieve Tho theta values thoThetaZ,thoRTheta,thoRZ
                    this.ThoThetaZ = Equations.thoThetaZ(ThoXZ,ThoYZ,failureAngle);
                    this.ThoRTheta = Equations.thoRTheta();
                    this.ThoRZ = Equations.thoRZ();

                    // Retrieve principal effective stress values
                    if (mudWeightPsiFt>porePressureGradient){

                        this.Sigma1 = Equations.sigma3(SigmaR);
                        setSigma1Final(Sigma1);
                        this.Sigma2 = Equations.sigma2(SigTheta,SigmaZ,ThoThetaZ);
                        setSigma2Final(Sigma2);
                        this.Sigma3 = Equations.sigma1(SigTheta,SigmaZ,ThoThetaZ);
                        setSigma3Final(Sigma3);
                        setPorePressureFinal(porePressureGradient);
                        setsigmaVFinalGradient(SigmaVGradient);

                    }
                    else{

                        this.Sigma1 = Equations.sigma2(SigTheta,SigmaZ,ThoThetaZ);
                        setSigma1Final(Sigma1);
                        this.Sigma2 = Equations.sigma1(SigTheta,SigmaZ,ThoThetaZ);
                        setSigma2Final(Sigma2);
                        this.Sigma3 = Equations.sigma3(SigmaR);
                        setSigma3Final(Sigma3);
                        setPorePressureFinal(porePressureGradient);
                        setsigmaVFinalGradient(SigmaVGradient);
                    }


                    //populate textlabels with value results
                    double porePressureCombination = porePressureGradient *depth;
                    setPorePressureCombinationFinal(porePressureCombination);
                    //sorts the principal stresses from highest to lowest
                    double[] principalSortedStresses = {getSigma1Final(),getSigma2Final(),getSigma3Final()};
                    Arrays.sort(principalSortedStresses);

                    double[] effectiveSortedStresses = {principalSortedStresses[0]-porePressureCombination,principalSortedStresses[1]-porePressureCombination,principalSortedStresses[2]-porePressureCombination};

                    //Find the wellbore critical failure pressure
                    double criticalFailurePressure = -1;

                    // Determine if tensile failure
                    // conditionals if the automatic or manual tensile radiobuttons are selected
                    if(tensileManualRadioButton.isSelected()) {

                        tensileStrength = (int) (Double.parseDouble(tensileText.getText())*(1/pressureUM));
                        tensileStrengthTextFieldResult.setText(Integer.toString(tensileStrength));
                        criticalFailurePressure = Equations.criticalFailurePressure(sigmaX,sigmaY,sigmaZ,ThoXY,ThoThetaZ,(porePressureGradient*depth*(1/pressureUM)),tensileStrength,failureAngle, gamma);
                        this.failType = Equations.tensileFailureCondition(mudWeightPsiFt*depth, criticalFailurePressure);

                        //rounds the critical pressure value
                        criticalFailurePressure = Math.round((criticalFailurePressure)*100);
                        criticalFailurePressure = criticalFailurePressure/100;

                        criticalFailurePressureTextField.setText(Double.toString(criticalFailurePressure));

                    }
                    else if(tensileAutomaticRadioButton.isSelected()){

                        //find compressive strength
                        compressiveStrengthIntact = Equations.rockPropertyGSISolver(effectiveSortedStresses[2],effectiveSortedStresses[1],effectiveSortedStresses[0],GSI,lithology,rockDamage,(SigmaVGradient)*(1/pressureUM),"Compressive Strength Intact");
                        compressiveStrength = Equations.rockPropertyGSISolver(effectiveSortedStresses[2],effectiveSortedStresses[1],effectiveSortedStresses[0],GSI,lithology,rockDamage,(SigmaVGradient)*(1/pressureUM),"Compressive Strength");
                        tensileStrength = -1*(int) Equations.rockPropertyGSISolver(effectiveSortedStresses[2],effectiveSortedStresses[1],effectiveSortedStresses[0],GSI,lithology,rockDamage,(SigmaVGradient)*(1/pressureUM),"Tensile Strength");
                        tensileStrengthTextFieldResult.setText(Integer.toString(tensileStrength));
                        criticalFailurePressure = Equations.criticalFailurePressure(sigmaX,sigmaY,sigmaZ,ThoXY,ThoThetaZ,(porePressureGradient*depth*(1/pressureUM)),tensileStrength,failureAngle,gamma);
                        this.failType = Equations.tensileFailureCondition(mudWeightPsiFt*depth,criticalFailurePressure);

                        //rounds the critical pressure value
                        int criticalFailurePressureInt = (int) criticalFailurePressure;
                        criticalFailurePressureTextField.setText(Double.toString(criticalFailurePressureInt));

                    }





                    //Retrieve first set parameters
                    this.firstInstability = Equations.firstSetParameters(this.failType, poreCombo.getSelectedItem().toString(), faultTypeCombo.getSelectedItem().toString(),"Instability");
                    this.firstLossOfCirculation = Equations.firstSetParameters(this.failType, poreCombo.getSelectedItem().toString(), faultTypeCombo.getSelectedItem().toString(),"LossOfCirculation");
                    this.firstWellControl = Equations.firstSetParameters(this.failType, poreCombo.getSelectedItem().toString(), faultTypeCombo.getSelectedItem().toString(),"WellControl");
                    this.firstLongTermIntegrity = Equations.firstSetParameters(this.failType, poreCombo.getSelectedItem().toString(), faultTypeCombo.getSelectedItem().toString(),"LongTermIntegrity");
                    this.firstROP= Equations.firstSetParameters(this.failType, poreCombo.getSelectedItem().toString(), faultTypeCombo.getSelectedItem().toString(),"ROP");

                    //Retrieve second set parameters

                    SecondSetEquations secondEquations = new SecondSetEquations();
                    //find unique beta value for each second set type
                    betaFaultParam = secondEquations.betaAngle(Integer.parseInt(faultConductivityStrikeTextField.getText()), (int) failureAngle, Integer.parseInt(faultConductivityDipTextField.getText()),Integer.parseInt(gammaText.getText()), phi );
                    betaJointParam = secondEquations.betaAngle(Integer.parseInt(jointStrikeTextField.getText()), (int) failureAngle, Integer.parseInt(jointDipTextField.getText()),Integer.parseInt(gammaText.getText()), phi );
                    betaUnconformityParam = secondEquations.betaAngle(Integer.parseInt(beddingPlaneStrikeTextField.getText()), (int) failureAngle, Integer.parseInt(beddingPlaneDipTextField.getText()),Integer.parseInt(gammaText.getText()), phi );

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
                        cohesionInitial = Equations.rockPropertyGSISolver(effectiveSortedStresses[2],effectiveSortedStresses[1],effectiveSortedStresses[0],GSI,lithology,rockDamage,(SigmaVGradient),"Cohesion");
                        setCohesionInitialFinal(cohesionInitial);
                    }

                    //Build Default catagory dataset

                    FailureRatioSolutions multiSolutions = new FailureRatioSolutions()  ;
                    DefaultCategoryDataset multivariateShearDataset = multiSolutions.principalStresses(SigmaVGradient,SigmahGradient,SigmaHGradient,depth,mudWeightPsiFt,Alpha,gamma,DeltaP,poissons,gradientUM,porePressureGradient,lengthUM,GSI,lithology,rockDamage,SigmaVGradient, "Shear Failure Ratio");
                    DefaultCategoryDataset multivariateTensileDataset = multiSolutions.principalStresses(SigmaVGradient,SigmahGradient,SigmaHGradient,depth,mudWeightPsiFt,Alpha,gamma,DeltaP,poissons,gradientUM,porePressureGradient,lengthUM,GSI,lithology,rockDamage,SigmaVGradient, "Tensile Failure Ratio");

                    //Calculate and build stress polygon dataset and Mohr dataset
                    StressPolygonDataset polyDataset = new StressPolygonDataset();

                    XYSeriesCollection polygonCollection = new XYSeriesCollection();
                    MohrDataset mohrDataset = new MohrDataset();

                    //build pressure regime dataset
                    FormationPressureDataset formationDataset = new FormationPressureDataset();
                    XYSeriesCollection formationPressureCollection = formationDataset.formationPressureDataset(SigmaVR,SigmaHR,SigmahR,porePressureCombination,depth,mudWeightPsiFt,tensileStrength,criticalFailurePressure);


                    XYSeriesCollection mohrCollection = new XYSeriesCollection();
                    mohrCollection.removeAllSeries();
                    if (coefficientAutomaticRadioButton.isSelected()){

                        setCoeffFriction(Equations.rockPropertyGSISolver(effectiveSortedStresses[2],effectiveSortedStresses[1],effectiveSortedStresses[0],GSI,lithology,rockDamage,(SigmaVGradient),"CoeffFriction"));


                        polygonCollection = polyDataset.stressPolygonDataset(this.SigmaVR*lengthUM*(1/pressureUM),(SigmaHGradient)*(1/pressureUM),(this.SigmahGradient)*(1/pressureUM),this.porePressureGradient*lengthUM*(1/pressureUM),depth*(1/lengthUM),getCoeffFriction());

                        setPolygonCollectionFinal(polygonCollection);// sets a grabber for the dataset (used for the stresspolygon button in the initial input tab)



                        mohrCollection = mohrDataset.mohrDatasetBuild(principalSortedStresses[2]*(1/pressureUM),principalSortedStresses[1]*(1/pressureUM),principalSortedStresses[0]*(1/pressureUM),cohesionInitial*(1/pressureUM),getCoeffFriction(),mainWindow.this);

                        setMohrCollectionFinal(mohrCollection);

                        multivariateShearDataset = multiSolutions.principalStresses(SigmaVGradient,SigmahGradient,SigmaHGradient,depth,mudWeightPsiFt,Alpha,gamma,DeltaP,poissons,gradientUM,porePressureGradient,lengthUM,GSI,lithology,rockDamage,SigmaVGradient, "Shear Failure Ratio");
                        multivariateTensileDataset = multiSolutions.principalStresses(SigmaVGradient,SigmahGradient,SigmaHGradient,depth,mudWeightPsiFt,Alpha,gamma,DeltaP,poissons,gradientUM,porePressureGradient,lengthUM,GSI,lithology,rockDamage,SigmaVGradient, "Tensile Failure Ratio");


                    }

                    else if (coefficientManualRadioButton.isSelected()){

                        setCoeffFriction(Double.parseDouble(coeffFrictionText.getText()));

                        polygonCollection = polyDataset.stressPolygonDataset(this.SigmaVR*lengthUM*(1/pressureUM),(SigmaHGradient)*(1/pressureUM),(this.SigmahGradient)*(1/pressureUM),this.porePressureGradient*lengthUM*(1/pressureUM),depth*(1/lengthUM),getCoeffFriction());

                        setPolygonCollectionFinal(polygonCollection);// sets a grabber for the dataset (used for the stresspolygon button in the initial input tab)


                        mohrCollection = mohrDataset.mohrDatasetBuild(principalSortedStresses[2]*(1/pressureUM),principalSortedStresses[1]*(1/pressureUM),principalSortedStresses[0]*(1/pressureUM),cohesionInitial*(1/pressureUM),getCoeffFriction(),mainWindow.this);

                        setMohrCollectionFinal(mohrCollection);

                        multivariateShearDataset = multiSolutions.principalStresses(SigmaVGradient*(1/pressureUM),SigmahGradient*(1/pressureUM),SigmaHGradient*(1/pressureUM),depth,mudWeightPsiFt,Alpha,gamma,DeltaP,poissons,gradientUM,porePressureGradient,lengthUM,GSI,lithology,rockDamage,(SigmaVGradient)*(1/pressureUM), "Shear Failure Ratio");

                        multivariateTensileDataset = multiSolutions.principalStresses(SigmaVGradient,SigmahGradient,SigmaHGradient,depth,mudWeightPsiFt,Alpha,gamma,DeltaP,poissons,gradientUM,porePressureGradient,lengthUM,GSI,lithology,rockDamage,SigmaVGradient, "Tensile Failure Ratio");

                    }


                        if(coefficientManualRadioButton.isSelected()){

                            this.shearType = shearCondition;
                        }
                        else if (coefficientAutomaticRadioButton.isSelected()){

                            double coeffFrictionTest = Equations.rockPropertyGSISolver(getSigma1Final(),getSigma2Final(),getSigma3Final(),GSI,lithology,rockDamage,(SigmaVGradient)*(1/pressureUM),"CoeffFriction");
                            this.shearType = shearCondition;
                        }

                        BufferedImage stressPolygonBufferedImage = null;
                        BufferedImage formationPressureBufferedImage = null;
                        BufferedImage mohrGraphBufferedImage = null;
                        BufferedImage shearBarGraphBufferedImage = null;
                        BufferedImage tensileBarGraphBufferedImage = null;

                    //buttonCount is a true/false condition to check if the graph panes are added/removed
                    if (buttonCount) {
                        StressPolygonGraph polygonGraphOutput = new StressPolygonGraph(polygonCollection, mainWindow.this,projectCustomPressureType);
                        tabbedPane1.addTab("Stress Polygon", null, polygonGraphOutput, null);

                        FormationPressureGraph formationPressureGraph = new FormationPressureGraph(formationPressureCollection,mainWindow.this,projectCustomPressureType);
                        tabbedPane1.addTab("Formation Pressure Regime",null,formationPressureGraph,null);

                        MohrFailureGraph MohrGraphOutput = new MohrFailureGraph(mohrCollection, effectiveSortedStresses[2]*(1/pressureUM),effectiveSortedStresses[0]*(1/pressureUM),projectCustomPressureType,mainWindow.this);
                        setMohrGraphOutputFinal(MohrGraphOutput);
                        tabbedPane1.addTab("Mohr-Coulomb Failure",null,MohrGraphOutput,null);

                        ShearFailureRatioBarGraph shearFailureBarGraph = new ShearFailureRatioBarGraph(multivariateShearDataset,mainWindow.this,projectCustomPressureType);
                        tabbedPane1.addTab("Shear Fracture Ratio", null,shearFailureBarGraph,null);

                        TensileFailureRatioBarGraph tensileFailureBarGraph = new TensileFailureRatioBarGraph(multivariateTensileDataset,mainWindow.this,projectCustomPressureType);
                        tabbedPane1.addTab("Tensile Fracture Ratio", null,tensileFailureBarGraph,null);

                        tabbedPane1.setEnabledAt(1,true);
                        stressPolygonButton.setEnabled(true);
                        mohrCoulombFailureButton.setEnabled(true);
                        formationPressureButton.setEnabled(true);


                        int chartDimensions = 575;



                        stressPolygonBufferedImage = getStressPolygonChart().createBufferedImage(chartDimensions,chartDimensions);
                        formationPressureBufferedImage = getFormationPressureChart().createBufferedImage(chartDimensions,chartDimensions);
                        mohrGraphBufferedImage = getMohrFailureChart().createBufferedImage(chartDimensions,chartDimensions);
                        shearBarGraphBufferedImage = getShearBarChart().createBufferedImage(chartDimensions,chartDimensions);
                        tensileBarGraphBufferedImage = getTensileBarChart().createBufferedImage(chartDimensions,chartDimensions);

                        chartBufferedImagesArray.add(stressPolygonBufferedImage);
                        chartBufferedImagesArray.add(formationPressureBufferedImage);
                        chartBufferedImagesArray.add(mohrGraphBufferedImage);
                        chartBufferedImagesArray.add(shearBarGraphBufferedImage);
                        chartBufferedImagesArray.add(tensileBarGraphBufferedImage);


                    }
                    else{

                        tabbedPane1.remove(6);
                        tabbedPane1.remove(5);
                        tabbedPane1.remove(4);
                        tabbedPane1.remove(3);
                        tabbedPane1.remove(2);
                        chartBufferedImagesArray.clear();

                        StressPolygonGraph polygonGraphOutput = new StressPolygonGraph(polygonCollection, mainWindow.this,projectCustomPressureType);
                        tabbedPane1.addTab("Stress Polygon", null, polygonGraphOutput, null);

                        FormationPressureGraph formationPressureGraph = new FormationPressureGraph(formationPressureCollection,mainWindow.this,projectCustomPressureType);
                        tabbedPane1.addTab("Formation Pressure Regime",null,formationPressureGraph,null);

                        MohrFailureGraph MohrGraphOutput = new MohrFailureGraph(mohrCollection, effectiveSortedStresses[2]*(1/pressureUM),effectiveSortedStresses[0]*(1/pressureUM),projectCustomPressureType,mainWindow.this);
                        setMohrGraphOutputFinal(MohrGraphOutput);
                        tabbedPane1.addTab("Mohr-Coulomb Failure",null,MohrGraphOutput,null);

                        ShearFailureRatioBarGraph shearFailureBarGraph = new ShearFailureRatioBarGraph(multivariateShearDataset,mainWindow.this,projectCustomPressureType);
                        tabbedPane1.addTab("Shear Fracture Ratio", null,shearFailureBarGraph,null);

                        TensileFailureRatioBarGraph tensileFailureBarGraph = new TensileFailureRatioBarGraph(multivariateTensileDataset,mainWindow.this,projectCustomPressureType);
                        tabbedPane1.addTab("Tensile Fracture Ratio", null,tensileFailureBarGraph,null);


                        int chartDimensions = 575;

                        stressPolygonBufferedImage = getStressPolygonChart().createBufferedImage(chartDimensions,chartDimensions);
                        formationPressureBufferedImage = getFormationPressureChart().createBufferedImage(chartDimensions,chartDimensions);
                        mohrGraphBufferedImage = getMohrFailureChart().createBufferedImage(chartDimensions,chartDimensions);
                        shearBarGraphBufferedImage = getShearBarChart().createBufferedImage(chartDimensions,chartDimensions);
                        tensileBarGraphBufferedImage = getTensileBarChart().createBufferedImage(chartDimensions,chartDimensions);


                        chartBufferedImagesArray.add(stressPolygonBufferedImage);
                        chartBufferedImagesArray.add(formationPressureBufferedImage);
                        chartBufferedImagesArray.add(mohrGraphBufferedImage);
                        chartBufferedImagesArray.add(shearBarGraphBufferedImage);
                        chartBufferedImagesArray.add(tensileBarGraphBufferedImage);


                    }


                    sigmaVTextFieldResult.setText(Integer.toString((int) ((SigmaVGradient +porePressureCombination)*(1/pressureUM))));
                    sigmaMaxTextFieldResult.setText(Integer.toString((int) ((SigmaHGradient +porePressureCombination)*(1/pressureUM))));
                    sigmaMinTextFieldResult.setText(Integer.toString((int) ((SigmahGradient +porePressureCombination)*(1/pressureUM))));
                    principal1TextFieldResult.setText(Integer.toString((int) (effectiveSortedStresses[2]*(1/pressureUM))));
                    principal2TextFieldResult.setText(Integer.toString((int) (effectiveSortedStresses[1]*(1/pressureUM))));
                    principal3TextFieldResult.setText(Integer.toString((int) (effectiveSortedStresses[0]*(1/pressureUM))));
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

                            String[] stringTitle = {"Well Instability","Loss of Circulation","Well Control","Long Term Integrity","Rate of Penetratin"};

                            for(int i = 0; i<stringTitle.length;i++){

                                doc.insertString(ratingTextPane.getStyledDocument().getLength(),"   ",sim);
                                doc.insertString(ratingTextPane.getStyledDocument().getLength(),stringTitle[i],keyWord);
                                doc.insertString(ratingTextPane.getStyledDocument().getLength(),"\n\n",sim);
                                doc.insertString(ratingTextPane.getStyledDocument().getLength(),initSt[i]+ "\n\n",sim);

                            }


                    } catch (BadLocationException ble) {
                        System.err.println("Couldn't insert initial text into text pane.");
                    }

                        if(buttonCount){

                            //Grab all of the values to be put in the pdf report
                            PDFExportArrayPopulator pdfeap = new PDFExportArrayPopulator(mainWindow.this,drillingInputsLabelArray,drillingInputsValueArray,
                                    rockInputsLabelArray,rockInputsValueArray,discontinuitiesInputsLabelArray,discontinuitiesInputsValueArray,
                                    geomechanicalOutputsLabelArray,geomechanicalOutputsValueArray);
                            buttonCount = false;
                        }
                        else{

                            //clear the array holding the old data
                            drillingInputsLabelArray.clear();
                            drillingInputsValueArray.clear();
                            rockInputsLabelArray.clear();
                            rockInputsValueArray.clear();
                            discontinuitiesInputsLabelArray.clear();
                            discontinuitiesInputsValueArray.clear();
                            geomechanicalOutputsLabelArray.clear();
                            geomechanicalOutputsValueArray.clear();
                            arrayLabelHolder.clear();
                            arrayValueHolder.clear();

                            //Grab all of the values to be put in the pdf report
                            PDFExportArrayPopulator pdfeap = new PDFExportArrayPopulator(mainWindow.this,drillingInputsLabelArray,drillingInputsValueArray,
                                    rockInputsLabelArray,rockInputsValueArray,discontinuitiesInputsLabelArray,discontinuitiesInputsValueArray,
                                    geomechanicalOutputsLabelArray,geomechanicalOutputsValueArray);
                        }

                        //this array holds the jtextfield data that will be exported to the report pdf
                        arrayLabelHolder.add(drillingInputsLabelArray);
                        arrayLabelHolder.add(rockInputsLabelArray);
                        arrayLabelHolder.add(discontinuitiesInputsLabelArray);
                        arrayLabelHolder.add(geomechanicalOutputsLabelArray);


                        arrayValueHolder.add(drillingInputsValueArray);
                        arrayValueHolder.add(rockInputsValueArray);
                        arrayValueHolder.add(discontinuitiesInputsValueArray);
                        arrayValueHolder.add(geomechanicalOutputsValueArray);

                        //builds the drilling pdf document data
                        DrillingRatingReportPDF drr = new DrillingRatingReportPDF();
                        drillingPDFDoc = drr.generateDocumentReport(arrayLabelHolder,arrayValueHolder,chartBufferedImagesArray);

                        menu.getExportPDF().setEnabled(true); // sets jmenuitem to enabled if the calculation is successful
                        stressPolygonButton.setEnabled(true);
                        mohrCoulombFailureButton.setEnabled(true);


                }

            }

        });

        exportReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DrillingRatingReportPDF drr = new DrillingRatingReportPDF();
                drr.saveDocument(drillingPDFDoc);

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
                tabbedPane1.setEnabledAt(1,false);
                stressPolygonButton.setEnabled(false);
                mohrCoulombFailureButton.setEnabled(false  );
                formationPressureButton.setEnabled(false);
            }
        });
        stressPolygonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ChartPanel cp = new ChartPanel(stressPolygonChart);
                cp.setPreferredSize(new Dimension(760, 760) );

                QuickGraphDialog QGD = new QuickGraphDialog();
                QGD.initialize(cp);



            }
        });
        mohrCoulombFailureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ChartPanel cp = new ChartPanel(mohrFailureChart);
                cp.setPreferredSize(new Dimension(760, 760) );

                QuickGraphDialog QGD = new QuickGraphDialog();
                QGD.initialize(cp);


            }
        });

        formationPressureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ChartPanel cp = new ChartPanel(formationPressureChart);
                cp.setPreferredSize(new Dimension(760, 760));

                QuickGraphDialog QGD = new QuickGraphDialog();
                QGD.initialize(cp);


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