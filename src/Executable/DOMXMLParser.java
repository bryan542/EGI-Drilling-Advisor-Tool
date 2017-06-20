package Executable;

import com.sun.org.apache.xml.internal.resolver.helpers.FileURL;
import org.jfree.io.FileUtilities;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by bryan on 6/19/2017.
 */
public class DOMXMLParser {

    //depending on the modulus value chosen, the parser will populate the fracture analysis tables with the xml data values
    public void populateValuesParser(String attributeValueUserInput, JTextField[] tabTextFields, String identity){

        String pathname = null;
        String elementTagName = null;
        String elementAttribute = null;

        if(identity == "Young's Modulus"){

            pathname = "XMLFiles/young modulus tables.xml";
            URL url = getClass().getResource(pathname);
            elementTagName = "modulus";
            elementAttribute = "modulusvalue";
        }
        else if(identity == "Natural Fracture Density"){

            pathname = "XMLFiles/Natural Fracture Tables.xml";
            URL url = getClass().getResource(pathname);
            elementTagName = "naturalfracturedensity";
            elementAttribute = "densityvalue";
        }
        else if(identity =="Formation Pressure"){

            pathname = "XMLFiles/Formation Pressure Table.xml";
            URL url = getClass().getResource(pathname);
            elementTagName = "formationpressure";
            elementAttribute = "formationpressurevalue";
        }

        String modulusvalue= null;
        try {
            File inputFile = new File(String.valueOf(getResourceAsFile(pathname)));
            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName(elementTagName); //finds all elements in the file names modulus

            for (int temp = 0; temp < nList.getLength(); temp++) { //goes through the data of everyone one of the nodes
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    modulusvalue = eElement.getAttribute(elementAttribute); //finds the node with the right attribute value
                    if(modulusvalue.equalsIgnoreCase(attributeValueUserInput)){ //user selects attribute they want in the combobox and the parser references it to this

                        Element eFluidSystem = (Element) doc.getElementsByTagName("fluidsystem").item(temp); //grabs the specific fluid element
                        tabTextFields[0].setText( eFluidSystem.getElementsByTagName("slickwaterfluid").item(0).getTextContent());
                        tabTextFields[1].setText( eFluidSystem.getElementsByTagName("hybridfluid").item(0).getTextContent());
                        tabTextFields[2].setText( eFluidSystem.getElementsByTagName("crosslinkedfluid").item(0).getTextContent());
                        tabTextFields[3].setText( eFluidSystem.getElementsByTagName("foamfluid").item(0).getTextContent());


                        Element eFluidVolume = (Element) doc.getElementsByTagName("fluidvolume").item(temp);
                        tabTextFields[4].setText(eFluidVolume.getElementsByTagName("high").item(0).getTextContent());
                        tabTextFields[5].setText(eFluidVolume.getElementsByTagName("moderate").item(0).getTextContent());
                        tabTextFields[6].setText(eFluidVolume.getElementsByTagName("low").item(0).getTextContent());

                        Element eFluidLoss = (Element) doc.getElementsByTagName("fluidloss").item(temp);
                        tabTextFields[7].setText(eFluidLoss.getElementsByTagName("high").item(0).getTextContent());
                        tabTextFields[8].setText(eFluidLoss.getElementsByTagName("moderate").item(0).getTextContent());
                        tabTextFields[9].setText(eFluidLoss.getElementsByTagName("low").item(0).getTextContent());

                        Element eTreatmentRate = (Element) doc.getElementsByTagName("treatmentrate").item(temp);
                        tabTextFields[10].setText(eTreatmentRate.getElementsByTagName("low").item(0).getTextContent());
                        tabTextFields[11].setText(eTreatmentRate.getElementsByTagName("moderate").item(0).getTextContent());
                        tabTextFields[12].setText(eTreatmentRate.getElementsByTagName("high").item(0).getTextContent());

                        Element eRampUp = (Element) doc.getElementsByTagName("rampupstrategy").item(temp);
                        tabTextFields[13].setText(eRampUp.getElementsByTagName("slow").item(0).getTextContent());
                        tabTextFields[14].setText(eRampUp.getElementsByTagName("moderate").item(0).getTextContent());
                        tabTextFields[15].setText(eRampUp.getElementsByTagName("fast").item(0).getTextContent());

                        Element eFracturePressure = (Element) doc.getElementsByTagName("fracturepressure").item(temp);
                        tabTextFields[16].setText(eFracturePressure.getElementsByTagName("high").item(0).getTextContent());
                        tabTextFields[17].setText(eFracturePressure.getElementsByTagName("moderate").item(0).getTextContent());
                        tabTextFields[18].setText(eFracturePressure.getElementsByTagName("low").item(0).getTextContent());

                        Element eProppantConcentration = (Element) doc.getElementsByTagName("proppantconcentration").item(temp);
                        tabTextFields[19].setText(eProppantConcentration.getElementsByTagName("high").item(0).getTextContent());
                        tabTextFields[20].setText(eProppantConcentration.getElementsByTagName("moderate").item(0).getTextContent());
                        tabTextFields[21].setText(eProppantConcentration.getElementsByTagName("low").item(0).getTextContent());

                        Element eProppantSize = (Element) doc.getElementsByTagName("proppantsize").item(temp);
                        tabTextFields[22].setText(eProppantSize.getElementsByTagName("hundredfollowed2040").item(0).getTextContent());
                        tabTextFields[23].setText(eProppantSize.getElementsByTagName("hybrid").item(0).getTextContent());
                        tabTextFields[24].setText(eProppantSize.getElementsByTagName("twenty40").item(0).getTextContent());

                        Element eProppantDensity = (Element) doc.getElementsByTagName("proppantdensity").item(temp);
                        tabTextFields[25].setText(eProppantDensity.getElementsByTagName("low").item(0).getTextContent());
                        tabTextFields[26].setText(eProppantDensity.getElementsByTagName("moderate").item(0).getTextContent());
                        tabTextFields[27].setText(eProppantDensity.getElementsByTagName("normal").item(0).getTextContent());

                        Element eProppantVolume = (Element) doc.getElementsByTagName("proppantvolume").item(temp);
                        tabTextFields[28].setText(eProppantVolume.getElementsByTagName("high").item(0).getTextContent());
                        tabTextFields[29].setText(eProppantVolume.getElementsByTagName("moderate").item(0).getTextContent());
                        tabTextFields[30].setText(eProppantVolume.getElementsByTagName("low").item(0).getTextContent());

                        Element eProppedSurfaceArea = (Element) doc.getElementsByTagName("proppedsurfacearea").item(temp);
                        tabTextFields[31].setText(eProppedSurfaceArea.getElementsByTagName("high").item(0).getTextContent());
                        tabTextFields[32].setText(eProppedSurfaceArea.getElementsByTagName("moderate").item(0).getTextContent());
                        tabTextFields[33].setText(eProppedSurfaceArea.getElementsByTagName("low").item(0).getTextContent());

                        Element ePerforationClustersPerStage = (Element) doc.getElementsByTagName("perforationclustersperstage").item(temp);
                        tabTextFields[34].setText(ePerforationClustersPerStage.getElementsByTagName("fourormore").item(0).getTextContent());
                        tabTextFields[35].setText(ePerforationClustersPerStage.getElementsByTagName("three").item(0).getTextContent());
                        tabTextFields[36].setText(ePerforationClustersPerStage.getElementsByTagName("two").item(0).getTextContent());

                        Element eFractureGeometry = (Element) doc.getElementsByTagName("fracturegeometry").item(temp);
                        tabTextFields[37].setText(eFractureGeometry.getElementsByTagName("complex").item(0).getTextContent());
                        tabTextFields[38].setText(eFractureGeometry.getElementsByTagName("moderatetocomplex").item(0).getTextContent());
                        tabTextFields[39].setText(eFractureGeometry.getElementsByTagName("planar").item(0).getTextContent());
                        tabTextFields[40].setText(eFractureGeometry.getElementsByTagName("planarorshearing").item(0).getTextContent());

                        Element epropagationresistance = (Element) doc.getElementsByTagName("propagationresistance").item(temp);
                        tabTextFields[41].setText(epropagationresistance.getElementsByTagName("bigger").item(0).getTextContent());
                        tabTextFields[42].setText(epropagationresistance.getElementsByTagName("big").item(0).getTextContent());
                        tabTextFields[43].setText(epropagationresistance.getElementsByTagName("moderate").item(0).getTextContent());
                        tabTextFields[44].setText(epropagationresistance.getElementsByTagName("small").item(0).getTextContent());

                        Element eFractureHeight = (Element) doc.getElementsByTagName("fractureheight").item(temp);
                        tabTextFields[45].setText(eFractureHeight.getElementsByTagName("high").item(0).getTextContent());
                        tabTextFields[46].setText(eFractureHeight.getElementsByTagName("moderate").item(0).getTextContent());
                        tabTextFields[47].setText(eFractureHeight.getElementsByTagName("implied").item(0).getTextContent());

                        Element eFractureLength = (Element) doc.getElementsByTagName("fracturelength").item(temp);
                        tabTextFields[48].setText(eFractureLength.getElementsByTagName("short").item(0).getTextContent());
                        tabTextFields[49].setText(eFractureLength.getElementsByTagName("moderate").item(0).getTextContent());
                        tabTextFields[50].setText(eFractureLength.getElementsByTagName("long").item(0).getTextContent());

                        Element eEUR = (Element) doc.getElementsByTagName("eur").item(temp);
                        tabTextFields[51].setText(eEUR.getElementsByTagName("high").item(0).getTextContent());
                        tabTextFields[52].setText(eEUR.getElementsByTagName("moderate").item(0).getTextContent());
                        tabTextFields[53].setText(eEUR.getElementsByTagName("low").item(0).getTextContent());
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Accesses the .xml files from the resource folder in the built .jar file and establish a temporary File object
    //to reference the pathnames.
    public static File getResourceAsFile(String resourcePath) {
        try {
            InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream(resourcePath);
            if (in == null) {
                return null;
            }

            File tempFile = File.createTempFile(String.valueOf(in.hashCode()), ".tmp");
            tempFile.deleteOnExit();

            try (FileOutputStream out = new FileOutputStream(tempFile)) {
                //copy stream
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            }
            return tempFile;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    //This method retrieves the dropdown list of xml child values from the root. When the user selects a different value in the combobox
    //it will queue the parser to update the value readouts.

    public ArrayList<String> getComboItems(String userInputElement, String userInputValue, String userInputFilepath){

        ArrayList<String> comboList = new ArrayList<String>();
        try {
            File inputFile = new File(String.valueOf(getResourceAsFile(userInputFilepath)));
            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName(userInputElement);


            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    comboList.add( eElement.getAttribute(userInputValue));
                }
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return comboList;
    }

}
