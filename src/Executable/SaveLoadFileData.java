package Executable;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.jfree.data.general.Series;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


public class SaveLoadFileData {

    //typs of separator used to separate values in the CSV file
    private static final String NEW_LINE_SEPARATOR = "\n";

    // saves the user input date to the filepath chosen from getSaveLocation()

    public static void writeCSVFile(mainWindow mw, String fileName) {


        List saveListValues = new ArrayList(); //saveListValue is the list of values that will be saved to the csv file
        List saveListNames = new ArrayList(); //saveListNames holds all of the names that will be used to construct the header in the CSV file

        //We will get different List sizes based on what the user had selected in the input panel
        saveListValues.add(mw.getDepthText().getText());
        saveListValues.add(mw.getMudWeightText().getText());
        saveListValues.add(mw.getGammaText().getText());
        saveListValues.add(mw.getAlpha1Text().getText());
        saveListValues.add(mw.getAlpha2Text().getText());
        saveListValues.add(mw.getPoissonText().getText());

        saveListNames.add(mw.getDepthLabel().getText());
        saveListNames.add(mw.getMudWeightLabel().getText());
        saveListNames.add("Deviation Angle Gamma");
        saveListNames.add("Alpha 1");
        saveListNames.add("Alpha 2");
        saveListNames.add(mw.getPoissonLabel().getText());

        if (mw.getStressAutomaticRadioButton().isSelected()) {
            saveListValues.add(mw.getPoreCombo().getSelectedItem());
            saveListValues.add(mw.getFaultTypeCombo().getSelectedItem());

            saveListNames.add("Pore Pressure Type");
            saveListNames.add("Fault Type");
        } else {
            saveListValues.add(mw.getSigmaVTextField().getText());
            saveListValues.add(mw.getSigmaMaxTextField().getText());
            saveListValues.add(mw.getSigmaMinTextField().getText());
            saveListValues.add(mw.getPorePressureTextField().getText());

            saveListNames.add("Sigma V");
            saveListNames.add("Sigma Max");
            saveListNames.add("Sigma Min");
            saveListNames.add("Pore Pressure");
        }
        if(mw.getCoefficientAutomaticRadioButton().isSelected()){

        }
        else{
            saveListValues.add(mw.getCoeffFrictionText().getText());

            saveListNames.add(mw.getCoeffFrictionLabel().getText());
        }
        if (mw.getTensileAutomaticRadioButton().isSelected()) {

        }
        else{

            saveListValues.add(mw.getTensileText().getText());

            saveListNames.add(mw.getTensileLabel().getText());
        }

        if (mw.getCohesionAutomaticButton().isSelected()) {

        }
        else{
            saveListValues.add(mw.getCohesionText().getText());

            saveListNames.add(mw.getCohesionInputLabel().getText());
        }

        saveListValues.add(mw.getPermCombo().getSelectedItem());
        saveListValues.add(mw.getLithologyCombo().getSelectedItem());
        saveListValues.add(mw.getGSICombo().getSelectedItem());

        saveListNames.add("Permeability");
        saveListNames.add("Lithology");
        saveListNames.add("GSI");

        saveListValues.add(mw.getBeddingCombo().getSelectedItem());
        saveListValues.add(mw.getBeddingPlaneStrikeTextField().getText());
        saveListValues.add(mw.getBeddingPlaneDipTextField().getText());

        saveListNames.add("Bedding Plane Conductivity");
        saveListNames.add("Bedding Strike");
        saveListNames.add("Bedding Dip");

        saveListValues.add(mw.getFaultConductCombo().getSelectedItem());
        saveListValues.add(mw.getFaultConductivityStrikeTextField().getText());
        saveListValues.add(mw.getFaultConductivityDipTextField().getText());

        saveListNames.add("Fault Conductivity");
        saveListNames.add("Fault Strike");
        saveListNames.add("Fault Dip");

        saveListValues.add(mw.getJointCombo().getSelectedItem());
        saveListValues.add(mw.getJointStrikeTextField().getText());
        saveListValues.add(mw.getJointDipTextField().getText());

        saveListNames.add("Natural Fractures");
        saveListNames.add("NF Strike");
        saveListNames.add("NF Dip");

        saveListValues.add(mw.getProjectSettingButton());
        saveListValues.add(mw.getProjectSettingType());
        saveListValues.add(mw.getProjectCustomDensityType());
        saveListValues.add(mw.getProjectCustomPressureType());
        saveListValues.add(mw.getProjectCustomLengthType());

        saveListNames.add("Project Button");
        saveListNames.add("Setting Type");
        saveListNames.add("Custom Density");
        saveListNames.add("Custom Pressure");
        saveListNames.add("Custom Length");


        //builds the file header for the csv file from the saveListNames arraylist
        Object[] FILE_HEADER = new Object[saveListNames.size()];

        for (int i = 0; i<saveListNames.size();i++){

            FILE_HEADER[i] = saveListNames.toArray()[i];
        }

        FileWriter fileWriter = null;

        CSVPrinter csvFilePrinter = null;

        //Create the CSVFormat object with "\n" as a record delimiter
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);

        try {
            if(fileName == null){
                return;
            }
            //initialize FileWriter object
            fileWriter = new FileWriter(fileName);

            //initialize CSVPrinter object
            csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);

            //Create CSV file header
            csvFilePrinter.printRecord(FILE_HEADER);

            //Write a new student object list to the CSV file

                csvFilePrinter.printRecord(saveListValues);


            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
                csvFilePrinter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter/csvPrinter !!!");
                e.printStackTrace();
            }
        }

    }

    //Opens a save panel from filechoose and allows us to set the pdf save pathname
    public String getSaveLocation(mainWindow mw) {

        File file = null;
        String filename = null;
        JFileChooser chooser =null;

        //this portion is for setting the windows look and feel for the save pane and preventing
        //the other panels' look and feel from changing
        LookAndFeel previousLF = UIManager.getLookAndFeel();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            chooser = new JFileChooser();
            UIManager.setLookAndFeel(previousLF);
        } catch (IllegalAccessException | UnsupportedLookAndFeelException | InstantiationException | ClassNotFoundException e) {}


        //choose the start user path
        chooser.setCurrentDirectory(new java.io.File("C:/"));
        chooser.setDialogTitle("Choose Save Location");

        //sets the file extensions that you can see
        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV File Save Path", "csv");
        chooser.setFileFilter(filter);

        int result = chooser.showSaveDialog(null);

        try {
            if (result == chooser.APPROVE_OPTION) {
                file = chooser.getSelectedFile();

            } else {
                file = null;
            }

            filename = file.toString();
            if (filename.endsWith(".csv")) {

            }
            else{

                filename = filename + ".csv";
            }


            //Checks to see if file pathname already exists and gives override option
            File fileOverwriteCondition = new File(filename);
            if(fileOverwriteCondition.exists()){

                int a = JOptionPane.showConfirmDialog(null,"Do you want to overwrite an existing file?",null,JOptionPane.YES_NO_OPTION);

                if(a == JOptionPane.YES_OPTION){

                    return filename;

                }
                else if (a == JOptionPane.NO_OPTION){

                    getSaveLocation(mw);
                }


            }
            else{
            }



        }
        catch(Exception er){}

        return filename;
    }


    public String getLoadLocation(mainWindow mw) {

        File file = null;
        String filename = null;
        JFileChooser chooser =null;

        //this portion is for setting the windows look and feel for the save pane and preventing
        //the other panels' look and feel from changing
        LookAndFeel previousLF = UIManager.getLookAndFeel();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            chooser = new JFileChooser();
            UIManager.setLookAndFeel(previousLF);
        } catch (IllegalAccessException | UnsupportedLookAndFeelException | InstantiationException | ClassNotFoundException e) {}


        //choose the start user path
        chooser.setCurrentDirectory(new java.io.File("C:/"));
        chooser.setDialogTitle("Choose File to Load");

        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Files", "csv");
        chooser.setFileFilter(filter);

        int result = chooser.showOpenDialog(null);

        try {
            if (result == chooser.APPROVE_OPTION) {
                file = chooser.getSelectedFile();

            } else {
                file = null;
            }

            filename = file.toString();

        }
        catch(Exception er){}

        return filename;
    }

    public static Reader readCSV(String csvFilePath, mainWindow mw) {


        // clears the panels if a proper path is selected. if there is no path an dthe jdialog is exited, nothing gets cleared out
        if (csvFilePath != null || !csvFilePath.isEmpty()){

            ClearResetValues cv = new ClearResetValues();
            cv.resetTool(mw);
        }



        Reader in = null;

        try {
            in = new FileReader(csvFilePath);
            Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader().parse(in);

            for (CSVRecord record : records) {

                // Anything to do with project setting paramaters is used to determine the units of measurement used (aka standard or SI units)
                String projectButton = record.get("Project Button");
                String projectType = record.get("Setting Type");
                String projectCustomDensity = record.get("Custom Density");
                String projectCustomPressure = record.get("Custom Pressure");
                String projectCustomLength = record.get("Custom Length");

                String densityUnit = "";
                String pressureUnit = "";
                String lengthUnit = "";
                String readerPressureUnits = "";

                if (projectButton.equals("General")){

                    mw.setProjectSettingButton("General");
                    if(projectType.equals("Oil Field Units")){

                        mw.setProjectSettingType("Oil Field Units");
                        mw.setDensityUM(1); //sets the project setting unit conversions properly when the user invokes the calculate button in the mainWindow panel
                        mw.setPressureUM(1);
                        mw.setLengthUM(1);
                        densityUnit = "ppg";
                        pressureUnit = "psi";
                        lengthUnit = "ft";
                        mw.setDepthLabel("Depth ("+lengthUnit+")");
                        mw.setInputStressGradientLabel("Stress Gradients ("+pressureUnit+"/"+lengthUnit+")");

                    }
                    else if (projectType.equals("SI Units")){

                        mw.setProjectSettingType("SI Units");
                        mw.setDensityUM(8.3454);
                        mw.setPressureUM(0.145038);
                        mw.setLengthUM(3.28084);
                        densityUnit = "g/cc";
                        pressureUnit = "Pa";
                        readerPressureUnits = "kPa";
                        lengthUnit = "m";
                        mw.setDepthLabel("Depth ("+lengthUnit+")");
                        mw.setInputStressGradientLabel("Stress Gradients ("+pressureUnit+"/"+lengthUnit+")");
                    }
                }
                else if (projectButton.equals("Custom")){

                    mw.setProjectSettingButton("Custom");

                    if (projectCustomDensity.equals("ppg")){

                        mw.setProjectCustomDensityType("ppg");
                        mw.setDensityUM(1);
                        densityUnit = "ppg";
                    }
                    else{

                        mw.setProjectCustomDensityType("g/cc");
                        mw.setDensityUM(8.3454);
                        densityUnit = "g/cc";
                    }

                    if(projectCustomPressure.equals("psi")){

                        mw.setProjectCustomPressureType("psi");
                        mw.setPressureUM(1);
                        pressureUnit = "psi";
                    }
                    else{

                        mw.setProjectCustomPressureType("Pa");
                        mw.setPressureUM(0.145038);
                        pressureUnit = "Pa";
                        readerPressureUnits = "kPa";

                    }

                    if(projectCustomLength.equals("ft")){

                        mw.setProjectCustomLengthType("ft");
                        mw.setLengthUM(1);
                        lengthUnit = "ft";

                    }
                    else{

                        mw.setProjectCustomLengthType("m");
                        mw.setLengthUM(3.28084);
                        lengthUnit = "m";

                    }
                }
                //change the labels with the proper unit extensions (ft or m, kPa or psi, ppg or g/cc)
                mw.setDepthLabel("Depth ("+lengthUnit+")");
                mw.setMudWeightLabel("Mud Weight ECD ("+densityUnit+")");

                mw.setTensileLabel("Tensile Strength ("+pressureUnit+")");
                mw.setCohesionInputLabel("Cohesion ("+pressureUnit+")");

                //Guaranteed data are values that will always be saved to the .CSV file
                //guaranteed data. I know I could delete these paramaters. However, listing them here is nice for reference
                /*
                String depth = "";
                String density = "";
                String deviationAngle = "";
                String alpha1 = "";
                String alpha2 = "";
                String poissonRatio = "";
                String permeability = "";
                String lithology = "";
                String GSI = "";
                String beddingPlaneConductivity = "";
                String beddingPlaneConductivityStrike = "";
                String beddingPlaneConductivityDip = "";
                String faultConductivity = "";
                String faultConductivityStrike = "";
                String faultConductivityDip = "";
                String naturalFractures = "";
                String naturalFracturesStrike = "";
                String naturalFracturesDip = "";
                */


                //Non-guaranteed saved data may not exist in the .CSV file depending on the user chosen inputs on the mainWindow JPanel
                //non-guaranteed saved data
                /*
                String porePressure = "";
                String porePressureType = "";
                String faultType = "";

                */

                //these non-guaranteed paramaters are used for checking if certain buttongroups are selected
                String sigmaV = "";
                String sigmaMax = "";
                String sigmaMin = "";
                String tensileStrength= "";
                String coeffFriction = "";
                String cohesion = "";

                mw.setDepthText(record.get("Depth ("+lengthUnit+")"));
                mw.setMudWeightText(record.get("Mud Weight ECD ("+densityUnit+")"));
                mw.setGammaText(record.get("Deviation Angle Gamma"));
                mw.setAlpha1Text(record.get("Alpha 1"));
                mw.setAlpha2Text(record.get("Alpha 2"));
                mw.setPoissonText(record.get("Poisson's Ratio"));
                mw.setPermCombo(record.get("Permeability"));
                mw.setLithologyCombo(record.get("Lithology"));
                mw.setGSICombo(record.get("GSI"));

                mw.setBeddingCombo(record.get("Bedding Plane Conductivity"));
                mw.setBeddingPlaneStrikeTextField(record.get("Bedding Strike"));
                mw.setBeddingPlaneDipTextField(record.get("Bedding Dip"));

                mw.setFaultConductCombo(record.get("Fault Conductivity"));
                mw.setFaultConductivityStrikeTextField(record.get("Fault Strike"));
                mw.setFaultConductivityDipTextField(record.get("Fault Dip"));

                mw.setJointCombo(record.get("Natural Fractures"));
                mw.setJointStrikeTextField(record.get("NF Strike"));
                mw.setJointDipTextField(record.get("NF Dip"));


                //Anything with try/catch blocks are fields not guaranteed to be in the .CSV file. This allows the mainWindow JPanel texfields to be set if a value does exist
                try{

                    mw.setFaultTypeCombo(record.get("Fault Type"));

                }
                catch(Exception e){};

                try{
                    coeffFriction = record.get("Coefficient of Friction");
                    mw.setCoeffFrictionText(record.get("Coefficient of Friction"));
                }
                catch(Exception e){};
                try{
                    tensileStrength = record.get("Tensile Strength ("+readerPressureUnits+")");
                    mw.setTensileText(record.get("Tensile Strength ("+readerPressureUnits+")"));

                }
                catch(Exception e){};

                try{
                    cohesion = record.get("Cohesion ("+readerPressureUnits+")");
                    mw.setCohesionText(record.get("Cohesion ("+readerPressureUnits+")"));

                }
                catch(Exception e){};

                try{
                    sigmaV = record.get("Sigma V");
                    mw.setSigmaVTextField(record.get("Sigma V"));

                }
                catch(Exception e){};

                try{
                    sigmaMax = record.get("Sigma Max");
                    mw.setSigmaMaxTextField(record.get("Sigma Max"));

                }
                catch(Exception e){};

                try{
                    sigmaMin = record.get("Sigma Min");
                    mw.setSigmaMinTextField(record.get("Sigma Min"));

                }
                catch(Exception e){};

                try{
                    mw.setPorePressureTextField(record.get("Pore Pressure"));

                }
                catch(Exception e){};

                try{
                    mw.setPoreCombo(record.get("Pore Pressure Type"));

                }
                catch(Exception e){};

                //enables or disables the stress gradient portion and fault type/pore combo portion
                if(sigmaV.isEmpty() && sigmaMax.isEmpty() && sigmaMin.isEmpty()){
                    mw.getStressAutomaticRadioButton().setSelected(true);
                    mw.getSigmaVTextField().setEnabled(false);
                    mw.getSigmaMaxTextField().setEnabled(false);
                    mw.getSigmaMinTextField().setEnabled(false);
                    mw.getPorePressureTextField().setEnabled(false);
                    mw.getPoreCombo().setEnabled(true);
                    mw.getFaultTypeCombo().setEnabled(true);
                }
                else {
                    mw.getStressManualInputRadioButton().setSelected(true);
                    mw.getSigmaVTextField().setEnabled(true);
                    mw.getSigmaMaxTextField().setEnabled(true);
                    mw.getSigmaMinTextField().setEnabled(true);
                    mw.getPorePressureTextField().setEnabled(true);
                    mw.getPoreCombo().setEnabled(false);
                    mw.getFaultTypeCombo().setEnabled(false);
                }

                //enables/disables objects if a tensile strength value exists
                if(tensileStrength.isEmpty()){
                    mw.getTensileAutomaticRadioButton().setSelected(true);
                    mw.getTensileText().setEnabled(false);
                }
                else{
                    mw.getTensileManualRadioButton().setSelected(true);
                    mw.getTensileText().setEnabled(true);
                }

                //enables/disables objects if a cohesion value exists
                if(cohesion.isEmpty()){
                    mw.getCohesionAutomaticButton().setSelected(true);
                    mw.getCohesionText().setEnabled(false);
                }
                else{
                    mw.getCohesionManualButton().setSelected(true);
                    mw.getCohesionText().setEnabled(true);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

       return in;
    }

}
