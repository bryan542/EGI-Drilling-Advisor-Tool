package Executable;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Bryan on 10/31/2016.
 */
public class TextFieldChecker {


    public TextFieldChecker() {

    }

    //method used to check if the input values are correct in the given textfieldsa
    public boolean runInputCheck(mainWindow mw) {


        ArrayList<JTextField> obj1 = new ArrayList<>();
        ArrayList<JLabel> obj11 = new ArrayList<>();
        ArrayList<JTextField> obj2 = new ArrayList<>();
        ArrayList<JLabel> obj22 = new ArrayList<>();
        ArrayList<JTextField> obj3 = new ArrayList<>();
        ArrayList<JLabel> obj33 = new ArrayList<>();

        // obj1 and obj11 are for condition value>0
        obj1.add(mw.getDepthText());
        obj1.add(mw.getMudWeightText());
        obj1.add(mw.getCohesionText());
        obj1.add(mw.getSigmaVTextField());
        obj1.add(mw.getSigmaMaxTextField());
        obj1.add(mw.getSigmaMinTextField());
        obj1.add(mw.getPorePressureTextField());
        obj1.add(mw.getTensileText());

        obj11.add(mw.getDepthLabel());
        obj11.add(mw.getMudWeightLabel());
        obj11.add(mw.getCohesionInputLabel());
        obj11.add(mw.getInputSigmaVLabel());
        obj11.add(mw.getInputSigmaMaxLabel());
        obj11.add(mw.getInputSigmaMinLabel());
        obj11.add(mw.getInputPorePressureLabel());
        obj11.add(mw.getTensileLabel());

        //obj2 and obj22 are for degree conditions 0<angle<360
        obj2.add(mw.getGammaText());
        obj2.add(mw.getAlpha1Text());
        obj2.add(mw.getAlpha2Text());
        obj2.add(mw.getBeddingPlaneStrikeTextField());
        obj2.add(mw.getFaultConductivityStrikeTextField());
        obj2.add(mw.getJointStrikeTextField());

        obj22.add(mw.getGammaLabel());
        obj22.add(mw.getAlpha1Label());
        obj22.add(mw.getAlpha2Label());
        obj22.add(mw.getBeddingPlaneConductivityLabel());
        obj22.add(mw.getFaultConductivityLabel());
        obj22.add(mw.getNaturalFractureFrequencyLabel());

        //obj3 and obj33 are dip conditions where 0<angle<90
        obj3.add(mw.getBeddingPlaneDipTextField());
        obj3.add(mw.getFaultConductivityDipTextField());
        obj3.add(mw.getJointDipTextField());

        obj33.add(mw.getBeddingPlaneConductivityLabel());
        obj33.add(mw.getFaultConductivityLabel());
        obj33.add(mw.getNaturalFractureFrequencyLabel());

        //return true of all conditions are satisfied in runInputChecker
        boolean checkResult = true;

        //obj1 checker
        for (int i = 0; i < obj1.size(); i++) {

            if (obj1.get(i).isEnabled()) {

                try {

                    if (Double.parseDouble(obj1.get(i).getText()) >= 0) {

                    } else {

                        JOptionPane.showMessageDialog(new JDialog(), obj11.get(i).getText() + ": Enter non-negative value.");
                        checkResult = false;
                        break;
                    }


                } catch (NumberFormatException e) {

                    JOptionPane.showMessageDialog(new JDialog(), obj11.get(i).getText() + ":Enter a valid value.");
                    checkResult = false;
                    break;
                }

            }
        }

        //breaks the method if the first condition isn't satisfied. If these aren't put in multiple JDialogs will popup
        if(checkResult == false){

            return checkResult;
        }

        //obj2 checker 0<angle<360
        for (int i = 0; i < obj2.size(); i++) {

            if (obj2.get(i).isEnabled()) {

                try {


                    if (0 <= Double.parseDouble(obj2.get(i).getText()) && Double.parseDouble(obj2.get(i).getText()) <= 360) {

                    } else {

                        JOptionPane.showMessageDialog(new JDialog(), obj22.get(i).getText() + ": Enter a value from 0-360 degrees.");
                        checkResult = false;
                        break;
                    }


                } catch (NumberFormatException e) {

                    JOptionPane.showMessageDialog(new JDialog(), obj22.get(i).getText() + ":Enter a valid value from 0-360 degrees.");
                    checkResult = false;
                    break;
                }

            }

        }

        if(checkResult == false){

            return checkResult;
        }

        //obj3 checker 0<angle<90
        for (int i = 0; i < obj3.size(); i++) {

            if (obj3.get(i).isEnabled()) {

                try {

                    if (0 <= Double.parseDouble(obj3.get(i).getText()) && Double.parseDouble(obj3.get(i).getText()) <= 90) {

                    } else {

                        JOptionPane.showMessageDialog(new JDialog(), obj33.get(i).getText() + ": Enter a dip value from 0-90 degrees.");
                        checkResult = false;
                        break;
                    }


                } catch (NumberFormatException e) {

                    JOptionPane.showMessageDialog(new JDialog(), obj33.get(i).getText() + ":Enter a dip value from 0-90 degrees.");
                    checkResult = false;
                    break;
                }
            }
        }

        if(checkResult == false){

            return checkResult;
        }

        //Poisson ratio textfield check. This text input has unique conditions and doesn't need to be in an ArrayList.
        try {

            if (0 <= Double.parseDouble(mw.getPoissonText().getText()) && Double.parseDouble(mw.getPoissonText().getText()) <= .5) {

            } else {

                JOptionPane.showMessageDialog(new JDialog(), mw.getPoissonLabel().getText() + ": Enter a value between 0-0.5.");
                checkResult = false;
            }


        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(new JDialog(), mw.getPoissonLabel().getText() + ":Enter a valid value between 0-0.5.");
            checkResult = false;
        }

        if(checkResult == false){

            return checkResult;
        }

        if(mw.getCoeffFrictionText().isEnabled()) {

            try {

                if (0 <= Double.parseDouble(mw.getCoeffFrictionText().getText()) && Double.parseDouble(mw.getCoeffFrictionText().getText()) <= 1) {

                } else {
                    JOptionPane.showMessageDialog(new JDialog(), mw.getCoeffFrictionLabel().getText() + ": Enter a value between 0-1.0.");
                    checkResult = false;

                }


            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(new JDialog(), mw.getCoeffFrictionLabel().getText() + ":Enter a valid value between 0-1.0.");
                checkResult = false;
            }
        }

        if(checkResult == false) {

            return checkResult;
        }

        //Rock Damage textfield check. This text input has unique conditions and doesn't need to be in an ArrayList.
        try {

            if (0 <= Double.parseDouble(mw.getRockDamageTextField().getText()) && Double.parseDouble(mw.getRockDamageTextField().getText()) <= 1.0) {

            } else {

                JOptionPane.showMessageDialog(new JDialog(), mw.getRockDamageLabel().getText() + ": Enter a value between 0-1.0.");
                checkResult = false;
            }


        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(new JDialog(), mw.getRockDamageLabel().getText() + ":Enter a valid value between 0-1.0.");
            checkResult = false;
        }

        if(checkResult == false) {

            return checkResult;
        }

        //GSI textfield check. This text input has unique conditions and doesn't need to be in an ArrayList.
        try {

            if (0 <= Double.parseDouble(mw.getGSITextField().getText()) && Double.parseDouble(mw.getGSITextField().getText()) <= 100) {

            } else {

                JOptionPane.showMessageDialog(new JDialog(), mw.getGSILabel().getText() + ": Enter a value between 0-100.");
                checkResult = false;
            }


        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(new JDialog(), mw.getGSILabel().getText() + ":Enter a valid value between 0-100.");
            checkResult = false;
        }


        return checkResult;
    }
}
