package Executable;



import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
//scatter plotting tool imports
import com.sun.scenario.Settings;
import com.sun.xml.internal.ws.api.config.management.policy.ManagementAssertion;
import org.jfree.data.xy.XYSeriesCollection;


/**
 * Created by Bryan on 10/3/2016.
 */
public class mainWindow extends JFrame {


    private JTabbedPane tabbedPane1;
    private JPanel DrilOutPanel2;
    private JPanel InputPanel1;
    private JComboBox PoreCombo;
    private JComboBox FaultTypeCombo;
    private JComboBox FaultConductCombo;
    private JComboBox BeddingCombo;
    private JComboBox DeformationCombo;
    private JComboBox JointCombo;
    private JComboBox LithologyCombo;
    private JComboBox PermCombo;
    private JComboBox GSICombo;
    private JTextField Alpha1Text;
    private JTextField BetaText;
    private JTextField GammaText;
    private JTextField Alpha2Text;
    private JTextField MudWeightText;
    private JTextField TensileText;
    private JFormattedTextField PoissonText;
    private JButton calculateButton;
    private JButton clearButton;
    private JLabel AlphaImageLabel;
    private JPanel MainPanel;
    private JTextField DepthText;
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
    private JPanel WellControlRatingConditionResult;
    private JLabel DepthLabel;
    private JPanel secondInputsPanel;
    private JLabel mudWeightLabel;
    private JLabel CohesionLabel;
    private JLabel gammaLabel;
    private JLabel alpha1Label;
    private JLabel alpha2Label;
    private JLabel tensileLabel;
    private JLabel poissonLabel;
    private JTextField CohesionText;
    private JLabel porePressureLabel;
    private JLabel farSigmaVLabel;
    private JLabel farSigmaHLabel;
    private JLabel farSigmahLabel;
    private JLabel principalSigma1Label;
    private JLabel principalSigma2Label;
    private JLabel principalSigma3Label;
    private JLabel betaLabel;
    private JTextPane ratingTextPane;
    private JButton exportReportButton;
    private JPanel PicturePanel;
    private static double densityUM = 1;
    private static double pressureUM =1;
    private static double lengthUM =1;

    public void setDepthLabel(String text) {
        this.DepthLabel.setText(text);
    }
    public void setMudWeightLabel(String text) {
        this.mudWeightLabel.setText(text);
    }
    public void setCohesionLabel(String text) {
        this.CohesionLabel.setText(text);
    }

    public void setTensileLabel(String text) {
        this.tensileLabel.setText(text);
    }

    public void setPorePressureLabel(String text) {
        this.porePressureLabel.setText(text);
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
    private ActionListener action = new ActionListener() {
        public void actionPerformed(ActionEvent ae){
            String text = "hi";
            labelChanger(text);
        }
    };

public void labelChanger(String input) {
    DepthLabel.setText(input);
    System.out.println(DepthLabel.getText());
    DepthLabel.validate();
}
public JLabel getLabel(){

    return DepthLabel;
}

    public mainWindow() {

        //sets EGI image icon
        URL url = mainWindow.class.getResource("EGI.png");
        ImageIcon bg = new ImageIcon(url);
        this.setIconImage(bg.getImage());




        //Build the menu bar
       // SettingsFrame sf = new SettingsFrame(mainWindow.this);

/*
        DropdownMenu menu = new DropdownMenu();
        JMenuBar mb = menu.buildMenuBar(sf, mainWindow.this);
        mainWindow.this.setJMenuBar(mb);
*/


        //set tool title
        this.setTitle("EGI Drilling Advisory Tool");
        SettingsFrame sf = new SettingsFrame(mainWindow.this);
        DropdownMenu menu = new DropdownMenu();
        menu.buildMenuBar(sf,mainWindow.this);

        //ratingTextPane UI settings
        ratingTextPane.setBorder(new LineBorder(Color.black,1));



        //Generate dropdown lists.
        ComboBoxLists listComboLists = new ComboBoxLists();
        String faultList[] = listComboLists.GetFaultTypes();
        String PorePressureList[] = listComboLists.GetPorePressure();
        String FaultConductivityList[] = listComboLists.GetFaultConductivity();
        String DeformationList[] = listComboLists.GetDeformation();
        String JointList[] = listComboLists.GetJoint();
        String BeddingUnconformityList[] = listComboLists.GetBeddingUnconformity();
        String LithologyList[] = listComboLists.GetLithology();
        String GSIList[] = listComboLists.GetGSI();
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
        for  (int i =0; i< DeformationList.length;i++) {
            DeformationCombo.addItem(DeformationList[i]);
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
        for  (int i =0; i< GSIList.length;i++) {
            GSICombo.addItem(GSIList[i]);
        }
        for  (int i =0; i< PermeabilityList.length;i++) {
        PermCombo.addItem(PermeabilityList[i]);
    }


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

        calculateButton.addActionListener(new ActionListener() {
            private double mudWeightPsiFt;
            private double phi;
            private double Alpha;
            private double SigmaVR;
            private double SigmaHR;
            private double SigmahR;
            private double PorePR;
            private double SigmaV;
            private double SigmaH;
            private double Sigmah;
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
            private double Sigma1;
            private double Sigma2;
            private double Sigma3;
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
            private double ShMin;
            private double SHMax;
            private double SHMaxDiagnol;
            private double SHMaxDiagnolMin;
            private double SHMaxDiagnolMax;
            private int buttonCount = 0;




            @Override
            public void actionPerformed(ActionEvent e) {

                // Equations
                DrillingEquations Equations = new DrillingEquations();
                // Convert mudweight to psi/ft
                mudWeightPsiFt = Double.parseDouble(MudWeightText.getText())*.05194805195*getDensityUM();
                //Retrieve alpha value
                this.Alpha = Equations.Alpha(Double.parseDouble(Alpha1Text.getText()),Double.parseDouble((Alpha2Text.getText())));

                //Retrieve sigma ranges
                this.SigmaVR = Equations.SigmaVRange(FaultTypeCombo.getSelectedItem().toString(),PoreCombo.getSelectedItem().toString());
                this.SigmaHR = Equations.SigmaHRange(FaultTypeCombo.getSelectedItem().toString(),PoreCombo.getSelectedItem().toString());
                this.SigmahR = Equations.SigmahRange(FaultTypeCombo.getSelectedItem().toString(),PoreCombo.getSelectedItem().toString());
                this.PorePR =  Equations.PorePressureRange(FaultTypeCombo.getSelectedItem().toString(),PoreCombo.getSelectedItem().toString());

                //Retrieve sigma values
                this.SigmaV = Equations.SigmaV(Double.parseDouble(DepthText.getText())*lengthUM,SigmaVR,PorePR);
                this.SigmaH = Equations.SigmaH(Double.parseDouble(DepthText.getText())*lengthUM,SigmaHR,PorePR);
                this.Sigmah = Equations.Sigmah(Double.parseDouble(DepthText.getText())*lengthUM,SigmahR,PorePR);

                //Retrieve stress tensors SV, SH, Sh
                this.SV = Equations.SV(SigmaV,SigmaH,Sigmah,Double.parseDouble(GammaText.getText()),Alpha);
                this.SH = Equations.SH(SigmaV,SigmaH,Sigmah,Double.parseDouble(GammaText.getText()),Alpha);
                this.Sh = Equations.Sh(SigmaV,SigmaH,Sigmah,Double.parseDouble(GammaText.getText()),Alpha);

                //Retrieve Tho values ThoXY, ThoXZ, ThoYZ
                this.ThoXY = Equations.ThoXY(SigmaH,Sigmah,Alpha,Double.parseDouble(GammaText.getText()));
                this.ThoXZ = Equations.ThoXZ(SigmaV,SigmaH,Sigmah,Alpha,Double.parseDouble(GammaText.getText()));
                this.ThoYZ = Equations.ThoYZ(SigmaH,Sigmah,Alpha,Double.parseDouble(GammaText.getText()));

                // DeltaP
                this.DeltaP = Equations.deltaP(Double.parseDouble(DepthText.getText())*lengthUM,mudWeightPsiFt,PorePR);

                // Retrieve SigmaR
                this.SigmaR = Equations.sigmaR(DeltaP);

                // Retrieve SigmaTheta and the input angle that give the maximum SigTheta
                this.SigTheta = Equations.sigmaTheta(SH,Sh,ThoXY,DeltaP);


                // Retrieve SigmaZ
                this.SigmaZ = Equations.SigmaZ(SV,Double.parseDouble(PoissonText.getText()),Sh,SH,ThoXY);

                // Retrieve Tho theta values ThoThetaZ,ThoRTheta,ThoRZ
                this.ThoThetaZ = Equations.ThoThetaZ(ThoXZ,ThoYZ);
                this.ThoRTheta = Equations.ThoRTheta();
                this.ThoRZ = Equations.ThoRZ();

                // Retrieve principal effective stress values

                this.Sigma1 = Equations.Sigma1(SigTheta,SigmaZ,ThoThetaZ);
                this.Sigma2 = Equations.Sigma2(SigTheta,SigmaZ,ThoThetaZ);
                this.Sigma3 = Equations.Sigma3(SigmaR);

                //Find the initial cohesion value
                double sigThetaTest = this.SigmaH+this.Sigmah-2*(this.SigmaH-this.Sigmah)*Math.cos(Math.toRadians(2*0))-this.DeltaP;

                cohesionInitial = Math.sqrt(1+.6*.6)*Math.sqrt(((sigThetaTest-this.SigmaR)/2)*((sigThetaTest-this.SigmaR)/2)-ThoRTheta)-0.6*((sigThetaTest+this.SigmaR)/2);

                // Determine if tensile failure

                this.failType = Equations.tensileFailureCondition(Sigma1,Double.parseDouble(TensileText.getText()));

                //phi if tensile failure occurs
/*
                if (failType == "Failure"){

                    this.phi = Equations.calculatePhi(ThoThetaZ,SigTheta,SigmaZ);
                }
*/
                //Determine if shear failure
                double sigThetaMax;
                double[] sortedSigTheta = SigTheta.clone();
                Arrays.sort(sortedSigTheta);
                sigThetaMax = sortedSigTheta[sortedSigTheta.length-1];

                this.shearType = Equations.shearFailureCondition(sigThetaMax,SigmaR,ThoRTheta);

                //Retrieve first set parameters

                this.firstInstability = Equations.firstSetParameters(this.failType,PoreCombo.getSelectedItem().toString(),FaultTypeCombo.getSelectedItem().toString(),"Instability");
                this.firstLossOfCirculation = Equations.firstSetParameters(this.failType,PoreCombo.getSelectedItem().toString(),FaultTypeCombo.getSelectedItem().toString(),"LossOfCirculation");
                this.firstWellControl = Equations.firstSetParameters(this.failType,PoreCombo.getSelectedItem().toString(),FaultTypeCombo.getSelectedItem().toString(),"WellControl");
                this.firstLongTermIntegrity = Equations.firstSetParameters(this.failType,PoreCombo.getSelectedItem().toString(),FaultTypeCombo.getSelectedItem().toString(),"LongTermIntegrity");
                this.firstROP= Equations.firstSetParameters(this.failType,PoreCombo.getSelectedItem().toString(),FaultTypeCombo.getSelectedItem().toString(),"ROP");

                //Retrieve second set parameters

                SecondSetEquations secondEquations = new SecondSetEquations();
                this.secondInstability = secondEquations.secondSetValues(FaultConductCombo.getSelectedItem().toString(),JointCombo.getSelectedItem().toString(),DeformationCombo.getSelectedItem().toString(),BeddingCombo.getSelectedItem().toString(),Double.parseDouble(BetaText.getText()),"Instability");
                this.secondLossOfCirculation = secondEquations.secondSetValues(FaultConductCombo.getSelectedItem().toString(),JointCombo.getSelectedItem().toString(),DeformationCombo.getSelectedItem().toString(),BeddingCombo.getSelectedItem().toString(),Double.parseDouble(BetaText.getText()),"LossOfCirculation");
                this.secondWellControl = secondEquations.secondSetValues(FaultConductCombo.getSelectedItem().toString(),JointCombo.getSelectedItem().toString(),DeformationCombo.getSelectedItem().toString(),BeddingCombo.getSelectedItem().toString(),Double.parseDouble(BetaText.getText()),"WellControl");
                this.secondLongTermIntegrity = secondEquations.secondSetValues(FaultConductCombo.getSelectedItem().toString(),JointCombo.getSelectedItem().toString(),DeformationCombo.getSelectedItem().toString(),BeddingCombo.getSelectedItem().toString(),Double.parseDouble(BetaText.getText()),"LongTermIntegrity");
                this.secondROP = secondEquations.secondSetValues(FaultConductCombo.getSelectedItem().toString(),JointCombo.getSelectedItem().toString(),DeformationCombo.getSelectedItem().toString(),BeddingCombo.getSelectedItem().toString(),Double.parseDouble(BetaText.getText()),"ROP");

                //Retrieve third set parameters

                ThirdSetEquations thirdEquations = new ThirdSetEquations();

                this.thirdInstability = ThirdSetEquations.thirdSetParameters(LithologyCombo.getSelectedItem().toString(),"Instability");
                this.thirdLossOfCirculation = ThirdSetEquations.thirdSetParameters(LithologyCombo.getSelectedItem().toString(),"LossOfCirculation");
                this.thirdWellControl = ThirdSetEquations.thirdSetParameters(LithologyCombo.getSelectedItem().toString(),"WellControl");
                this.thirdLongTermIntegrity = ThirdSetEquations.thirdSetParameters(LithologyCombo.getSelectedItem().toString(),"LongTermIntegrity");
                this.thirdROP = ThirdSetEquations.thirdSetParameters(LithologyCombo.getSelectedItem().toString(),"ROP");

                //Retrieve fourth set parameters

                FourthSetEquations fourthEquations = new FourthSetEquations();

                this.fourthInstability = FourthSetEquations.fourthSetParameters(GSICombo.getSelectedItem().toString(),"Instability");
                this.fourthLossOfCirculation = FourthSetEquations.fourthSetParameters(GSICombo.getSelectedItem().toString(),"LossOfCirculation");
                this.fourthWellControl = FourthSetEquations.fourthSetParameters(GSICombo.getSelectedItem().toString(),"WellControl");
                this.fourthLongTermIntegrity = FourthSetEquations.fourthSetParameters(GSICombo.getSelectedItem().toString(),"LongTermIntegrity");
                this.fourthROP = FourthSetEquations.fourthSetParameters(GSICombo.getSelectedItem().toString(),"ROP");

                //Retrieve fifth set parameters

                FifthSetEquations fifthEquations = new FifthSetEquations();

                this.fifthInstability = FifthSetEquations.fifthSetParameters(PermCombo.getSelectedItem().toString(),"Instability");
                this.fifthLossOfCirculation = FifthSetEquations.fifthSetParameters(PermCombo.getSelectedItem().toString(),"LossOfCirculation");
                this.fifthWellControl = FifthSetEquations.fifthSetParameters(PermCombo.getSelectedItem().toString(),"WellControl");
                this.fifthLongTermIntegrity = FifthSetEquations.fifthSetParameters(PermCombo.getSelectedItem().toString(),"LongTermIntegrity");
                this.fifthROP = FifthSetEquations.fifthSetParameters(PermCombo.getSelectedItem().toString(),"ROP");

                //Final parameter sums used in solution rubric
                sumInstability = this.firstInstability+this.secondInstability+this.thirdInstability+this.fourthInstability+this.fifthInstability;
                sumLossOfCirculation = this.firstLossOfCirculation+this.secondLossOfCirculation+this.thirdLossOfCirculation+this.fourthLossOfCirculation+this.fifthLossOfCirculation;
                sumWellControl = this.firstWellControl+this.secondWellControl+this.thirdWellControl+this.fourthWellControl+this.fifthWellControl;
                sumLongTermIntegrity = this.firstLongTermIntegrity+this.secondLongTermIntegrity+this.thirdLongTermIntegrity+this.fourthLongTermIntegrity+this.fifthLongTermIntegrity;
                sumROP = this.firstROP+this.secondROP+this.thirdROP+this.fourthROP+this.fifthROP;

                //Calculate and build stress polygon dataset and Mohr dataset
               StressPolygonDataset polyDataset = new StressPolygonDataset();
                XYSeriesCollection polygonCollection = polyDataset.stressPolygonDataset(this.SigmaV,this.PorePR,Double.parseDouble(DepthText.getText()));

                MohrDataset mohrDataset = new MohrDataset();
                XYSeriesCollection mohrCollection = mohrDataset.mohrDatasetBuild(this.Sigma3,this.Sigma2,this.Sigma1,cohesionInitial);

                if (buttonCount == 0) {
                    GraphOutputPanel polygonGraphOutput = new GraphOutputPanel(polygonCollection);
                    tabbedPane1.addTab("Stress Polygon", null, polygonGraphOutput, null);


                    MohrFailureGraph MohrGraphOutput = new MohrFailureGraph(mohrCollection);
                    tabbedPane1.addTab("Mohr-Coulomb Failure",null,MohrGraphOutput,null);
                    buttonCount = buttonCount +1;

                }
                else if (buttonCount == 1){

                    tabbedPane1.remove(3);
                    tabbedPane1.remove(2);

                    GraphOutputPanel graphOutput = new GraphOutputPanel(polygonCollection);
                    tabbedPane1.addTab("Stress Polygon", null, graphOutput, null);

                    MohrFailureGraph MohrGraphOutput = new MohrFailureGraph(mohrCollection);
                    tabbedPane1.addTab("Mohr-Coulomb Failure",null,MohrGraphOutput,null);

                }



                PorePressureResult.setText(Integer.toString((int) (PorePR*Integer.parseInt(DepthText.getText())*lengthUM*(1/pressureUM))));
                SigmaVResult.setText(Integer.toString((int) (SigmaV*(1/pressureUM))));
                SigmaHResult.setText(Integer.toString((int) (SigmaH*(1/pressureUM))));
                SigmahResult.setText(Integer.toString((int) (Sigmah*(1/pressureUM))));
                Principle1Result.setText(Integer.toString((int) (Sigma1*(1/pressureUM))));
                Principle2Result.setText(Integer.toString((int) (Sigma2*(1/pressureUM))));
                Principle3Result.setText(Integer.toString((int) (Sigma3*(1/pressureUM))));
                TensileFailResult.setText(failType);
                ShearFailResult.setText(shearType);
                InstabilityRating.setText(Integer.toString((int) sumInstability));
                LostCirculationRating.setText(Integer.toString((int) sumLossOfCirculation));
                WellControlRating.setText(Integer.toString((int) sumWellControl));
                LongTermIntegrityRating.setText(Integer.toString((int) sumLongTermIntegrity));
                ROPRating.setText(Integer.toString((int) sumROP));

               if(sumInstability >0 && sumInstability <20){

                   InstableConditionResult.setText("Stable");
               }
               else if(sumInstability >20 && sumInstability <40){

                   InstableConditionResult.setText("Semi-stable");
               }
               else if(sumInstability >40 && sumInstability <60){

                   InstableConditionResult.setText("Partially Unstable");
               }
               else if(sumInstability >60 && sumInstability <80){

                   InstableConditionResult.setText("Semi-Unstable");
               }
               else {

                   InstableConditionResult.setText("Unstable");
               }

                if(sumLossOfCirculation >0 && sumLossOfCirculation <20){

                    LostCirculationConditionResult.setText("No Loss");
                }
                else if(sumLossOfCirculation >20 && sumLossOfCirculation <40){

                    LostCirculationConditionResult.setText("2-4 bbl/hr");
                }
                else if(sumLossOfCirculation >40 && sumLossOfCirculation <60){

                    LostCirculationConditionResult.setText("4-10 bbl/hr");
                }
                else if(sumLossOfCirculation >60 && sumLossOfCirculation <80){

                    LostCirculationConditionResult.setText("10-20 bbl/hr");
                }
                else {

                    LostCirculationConditionResult.setText("Complete Loss");
                }


                if(sumWellControl >0 && sumWellControl <20){

                    WellControlConditionResult.setText("No Flow");
                }
                else if(sumWellControl >20 &&sumWellControl <40){

                    WellControlConditionResult.setText("Negligible Flow");
                }
                else if(sumWellControl >40 &&sumWellControl <60){

                    WellControlConditionResult.setText("4-10 bbl/hr");
                }
                else if(sumWellControl >60 &&sumWellControl <80){

                    WellControlConditionResult.setText("10-20 bbl/hr");
                }
                else {

                    WellControlConditionResult.setText("Kick/Blow Out");
                }

                if(sumLongTermIntegrity >0 && sumLongTermIntegrity <20){

                    LongTermIntegrityConditionResult.setText("Stable");
                }
                else if(sumLongTermIntegrity >20 && sumLongTermIntegrity <40){

                    LongTermIntegrityConditionResult.setText("Semi-Stable");
                }
                else if(sumLongTermIntegrity >40 && sumLongTermIntegrity <60){

                    LongTermIntegrityConditionResult.setText("Partially Unstable");
                }
                else if(sumLongTermIntegrity >60 && sumLongTermIntegrity <80){

                    LongTermIntegrityConditionResult.setText("Semi-Unstable");
                }
                else {

                    LongTermIntegrityConditionResult.setText("Unstable");
                }

                if(sumROP >0 && sumROP <20){

                    ROPConditionResult.setText("High");
                }
                else if(sumROP  >20 && sumROP  <40){

                    ROPConditionResult.setText("Medium-high");
                }
                else if(sumROP  >40 && sumROP  <60){

                    ROPConditionResult.setText("Medium");
                }
                else if(sumROP  >60 && sumROP  <80){

                    ROPConditionResult.setText("Medium-low");
                }
                else {

                    ROPConditionResult.setText("Low");
                }

                //generate rating textpane report
                ReportStrings reportList = new ReportStrings();
                String[] initSt = reportList.getInitString();
                SimpleAttributeSet sim = new SimpleAttributeSet();

                try {

                    ratingTextPane.getStyledDocument().insertString(ratingTextPane.getStyledDocument().getLength(),initSt[0],sim);

                } catch (BadLocationException ble) {
                    System.err.println("Couldn't insert initial text into text pane.");
                }



            }
        });


        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                SettingsFrame sf = new SettingsFrame(mainWindow.this);
                sf.setContentPane(sf.projectPanel);
                sf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                sf.pack();
                sf.setLocationRelativeTo(null);
                sf.setVisible(true);
                //get menu
                sf.setTitle("Project Settings");

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
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                new mainWindow().initialize();
            }
        });
    }

}