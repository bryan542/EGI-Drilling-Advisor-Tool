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
