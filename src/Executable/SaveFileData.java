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


public class SaveFileData {

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
        saveListValues.add(mw.getAlpha1Text().getText());
        saveListValues.add(mw.getPoissonText().getText());

        saveListNames.add(mw.getDepthLabel().getText());
        saveListNames.add(mw.getMudWeightLabel().getText());
        saveListNames.add(mw.getGammaLabel().getText());
        saveListNames.add(mw.getAlpha1Label().getText());
        saveListNames.add(mw.getAlpha2Label().getText());
        saveListNames.add(mw.getPoissonLabel().getText());

        if (mw.getStressAutomaticRadioButton().isSelected()) {
            saveListValues.add(mw.getPoreCombo().getSelectedItem());
            saveListValues.add(mw.getFaultTypeCombo().getSelectedItem());

            saveListNames.add("Pore Pressure");
            saveListNames.add("Fault Type");
        } else {
            saveListValues.add(mw.getSigmaVTextField().getText());
            saveListValues.add(mw.getSigmaMaxTextField().getText());
            saveListValues.add(mw.getSigmaMinTextField().getText());
            saveListValues.add(mw.getPorePressureTextField().getText());

            saveListNames.add(mw.getInputSigmaVLabel().getText());
            saveListNames.add(mw.getInputSigmaMaxLabel().getText());
            saveListNames.add(mw.getInputSigmaMinLabel().getText());
            saveListNames.add(mw.getInputPorePressureLabel().getText());
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

        FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF & CSV Files", "pdf","csv");
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

    public static Reader readCSV(String csvFilePath) {

        Reader in = null;

        try {
            in = new FileReader(csvFilePath);
            Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader().parse(in);

            for (CSVRecord record : records) {
                String columnOne = record.get("Depth (ft)");
                String columnTwo = record.get("Mud Weight ECD (ppg)");
                String columnTwwo = record.get("Mud Weight ECD (ppg)");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

       return in;
    }
   
}
