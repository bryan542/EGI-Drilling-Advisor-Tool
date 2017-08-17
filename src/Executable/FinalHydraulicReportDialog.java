package Executable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.ArrayList;

public class FinalHydraulicReportDialog extends JDialog {
    private JPanel contentPane;

    private JButton exportReportButton;

    private JTextField fluidSystemReportJTextField;
    private JTextField fluidVolumeReportJTextField;
    private JTextField fluidLossReportJTextField;
    private JTextField treatmentRateReportJTextFIeld;
    private JTextField rampUpReportJTextField;
    private JTextField fracturePressureReportJTextFIeld;
    private JTextField proppantConcentrationReportJTextField;
    private JTextField proppantSizeReportJTextField;
    private JTextField proppantDensityReportJTextField;
    private JTextField proppantVolumeReportJTextField;
    private JTextField proppedSurfaceAreReportJTextField;
    private JTextField perforationClustersReportJTextField;
    private JTextField fractureGeometryReportJTextField;
    private JTextField propagationResistanceReportJTextField;
    private JTextField fractureHeightReportJTextField;
    private JTextField fractureLengthReportJTextField;
    private JTextField EURReportJTextField;

    private JLabel fluidSystemReportJLabel;
    private JLabel fluidVolumeReportJLabel;
    private JLabel fluidLossReportJLabel;
    private JLabel treatmentRateReportJLabel;
    private JLabel rampUpStrategyReportJLabel;
    private JLabel fracturePressureReportJLabel;
    private JLabel proppantConcentrationReportJLabel;
    private JLabel proppantSizeReportJLabel;
    private JLabel proppantDensityReportJLabel;
    private JLabel proppantVolumeReportJLabel;
    private JLabel proppedSurfaceAreaReportJLabel;
    private JLabel perfClusterReportJLabel;
    private JLabel fractureGeometryReportJLabel;
    private JLabel propagationResistanceReportJLabel;
    private JLabel fractureHeightReportJLabel;
    private JLabel fractureLengthReportJLabel;
    private JLabel EURReportJLabel;


    public JLabel getFluidSystemJLabal() {
        return fluidSystemReportJLabel;
    }
    public JLabel getFluidVolumeJLabel() {
        return fluidVolumeReportJLabel;
    }
    public JLabel getFluidLossJLabel() {
        return fluidLossReportJLabel;
    }
    public JLabel getTreatmentRateJLabel() {
        return treatmentRateReportJLabel;
    }
    public JLabel getRampUpStrategyJLabel() {
        return rampUpStrategyReportJLabel;
    }
    public JLabel getFracturePressureJLabel() {
        return fracturePressureReportJLabel;
    }
    public JLabel getProppantConcentrationJLabel() {
        return proppantConcentrationReportJLabel;
    }
    public JLabel getProppantSizeJLabel() {
        return proppantSizeReportJLabel;
    }
    public JLabel getProppantDensityJLabel() {
        return proppantDensityReportJLabel;
    }
    public JLabel getProppantVolumeJLabel() {
        return proppantVolumeReportJLabel;
    }
    public JLabel getProppedSurfaceAreaJLabel() {
        return proppedSurfaceAreaReportJLabel;
    }
    public JLabel getPerfClusterJLabel() {
        return perfClusterReportJLabel;
    }
    public JLabel getFractureGeometryJLabel() {
        return fractureGeometryReportJLabel;
    }
    public JLabel getPropagationResistanceJLabel() {
        return propagationResistanceReportJLabel;
    }
    public JLabel getFractureHeightJLabel() {
        return fractureHeightReportJLabel;
    }
    public JLabel getFractureLengthJLabel() {
        return fractureLengthReportJLabel;
    }
    public JLabel getEURJLabel() {
        return EURReportJLabel;
    }

    public JTextField getFluidSystemReportJTextField() {
        return fluidSystemReportJTextField;
    }
    public JTextField getFluidVolumeReportJTextField() {
        return fluidVolumeReportJTextField;
    }
    public JTextField getFluidLossReportJTextField() {
        return fluidLossReportJTextField;
    }
    public JTextField getTreatmentRateReportJTextFIeld() {
        return treatmentRateReportJTextFIeld;
    }
    public JTextField getRampUpReportJTextField() {
        return rampUpReportJTextField;
    }
    public JTextField getFracturePressureReportJTextFIeld() {
        return fracturePressureReportJTextFIeld;
    }
    public JTextField getProppantConcentrationReportJTextField() {
        return proppantConcentrationReportJTextField;
    }
    public JTextField getProppantSizeReportJTextField() {
        return proppantSizeReportJTextField;
    }
    public JTextField getProppantDensityReportJTextField() {
        return proppantDensityReportJTextField;
    }
    public JTextField getProppantVolumeReportJTextField() {
        return proppantVolumeReportJTextField;
    }
    public JTextField getProppedSurfaceAreReportJTextField() {
        return proppedSurfaceAreReportJTextField;
    }
    public JTextField getPerforationClustersReportJTextField() {
        return perforationClustersReportJTextField;
    }
    public JTextField getFractureGeometryReportJTextField() {
        return fractureGeometryReportJTextField;
    }
    public JTextField getPropagationResistanceReportJTextField() {
        return propagationResistanceReportJTextField;
    }
    public JTextField getFractureHeightReportJTextField() {
        return fractureHeightReportJTextField;
    }
    public JTextField getFractureLengthReportJTextField() {
        return fractureLengthReportJTextField;
    }
    public JTextField getEURReportJTextField() {
        return EURReportJTextField;
    }



    public FinalHydraulicReportDialog(String[] reportnames) {

    //sets EGI image icon
    URL EGIURL = mainWindow.class.getResource("/Images/EGI.png");
    ImageIcon EGIImageIcon = new ImageIcon(EGIURL);
    Image EGIImage = EGIImageIcon.getImage();
    this.setIconImage(EGIImage);

        //wont allow the use to edit the jtextfield outputs
        fluidSystemReportJTextField.setEditable(false);;
        fluidVolumeReportJTextField.setEditable(false);;
        fluidLossReportJTextField.setEditable(false);;
        treatmentRateReportJTextFIeld.setEditable(false);;
        rampUpReportJTextField.setEditable(false);;
        fracturePressureReportJTextFIeld.setEditable(false);;
        proppantConcentrationReportJTextField.setEditable(false);;
        proppantSizeReportJTextField.setEditable(false);;
        proppantDensityReportJTextField.setEditable(false);;
        proppantVolumeReportJTextField.setEditable(false);;
        proppedSurfaceAreReportJTextField.setEditable(false);;
        perforationClustersReportJTextField.setEditable(false);;
        fractureGeometryReportJTextField.setEditable(false);;
        propagationResistanceReportJTextField.setEditable(false);;
        fractureHeightReportJTextField.setEditable(false);;
        fractureLengthReportJTextField.setEditable(false);;
        EURReportJTextField.setEditable(false);

        //add all the textfields to a list to cycle through
        ArrayList<JLabel> reportJLabelList = new ArrayList<>();
        reportJLabelList.add(fluidSystemReportJLabel);
        reportJLabelList.add(fluidVolumeReportJLabel);
        reportJLabelList.add(fluidLossReportJLabel);
        reportJLabelList.add(treatmentRateReportJLabel);
        reportJLabelList.add(getRampUpStrategyJLabel());
        reportJLabelList.add(fracturePressureReportJLabel);
        reportJLabelList.add(proppantConcentrationReportJLabel);
        reportJLabelList.add(proppantSizeReportJLabel);
        reportJLabelList.add(proppantDensityReportJLabel);
        reportJLabelList.add(proppantVolumeReportJLabel);
        reportJLabelList.add(proppedSurfaceAreaReportJLabel);
        reportJLabelList.add(perfClusterReportJLabel);
        reportJLabelList.add(fractureGeometryReportJLabel);
        reportJLabelList.add(propagationResistanceReportJLabel);
        reportJLabelList.add(fractureHeightReportJLabel);
        reportJLabelList.add(fractureLengthReportJLabel);
        reportJLabelList.add(EURReportJLabel);

        //add all the textfields to a list to cycle through
        ArrayList<JTextField> reportJTextFieldList = new ArrayList<>();
        reportJTextFieldList.add(fluidSystemReportJTextField);
        reportJTextFieldList.add(fluidVolumeReportJTextField);
        reportJTextFieldList.add(fluidLossReportJTextField);
        reportJTextFieldList.add(treatmentRateReportJTextFIeld);
        reportJTextFieldList.add(rampUpReportJTextField);
        reportJTextFieldList.add(fracturePressureReportJTextFIeld);
        reportJTextFieldList.add(proppantConcentrationReportJTextField);
        reportJTextFieldList.add(proppantSizeReportJTextField);
        reportJTextFieldList.add(proppantDensityReportJTextField);
        reportJTextFieldList.add(proppantVolumeReportJTextField);
        reportJTextFieldList.add(proppedSurfaceAreReportJTextField);
        reportJTextFieldList.add(perforationClustersReportJTextField);
        reportJTextFieldList.add(fractureGeometryReportJTextField);
        reportJTextFieldList.add(propagationResistanceReportJTextField);
        reportJTextFieldList.add(fractureHeightReportJTextField);
        reportJTextFieldList.add(fractureLengthReportJTextField);
        reportJTextFieldList.add(EURReportJTextField);


        exportReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                HydraulicFracturePDFReportGenerator hfrg = new HydraulicFracturePDFReportGenerator(reportJLabelList,reportJTextFieldList);
            }
        });
        // call onCancel() on ESCAPE
    contentPane.registerKeyboardAction(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            onCancel();
        }
    }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);


    //sets the jtextfield outputs with the selected final values
    setTextField(reportnames,reportJTextFieldList);
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }


    //loops through the jtextfield list and the final selected names generated from
    //HydraulicFractureAnalysisDialog Class // method populateReportTextField
    public void setTextField(String[] stringNames, ArrayList<JTextField> textFieldList){

        int length = stringNames.length;

        for(int i = 0;i<length;i++){

         textFieldList.get(i).setText(stringNames[i]);

        }

    }
    public void initialize() {

        setContentPane(contentPane);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Hydraulic Fracture Report");
    }
}
