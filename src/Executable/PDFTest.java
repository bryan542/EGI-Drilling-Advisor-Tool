package Executable;

import org.apache.pdfbox.cos.ICOSVisitor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1CFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.jfree.io.FileUtilities;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by bryan on 10/25/2016.
 */
public class PDFTest {

    PDFTest() {

    }

    //Used to create an image
    public void imageCreator(String pathImage, String savePDFPath) throws IOException {

        String imagePath = pathImage;
        String pdfPath = savePDFPath;

        if (!pdfPath.endsWith(".pdf")) {
            System.err.println("Last argument must be the destination .pdf file");
            System.exit(1);
        }

        PDDocument doc = PDDocument.load(new File(".\\src\\Executable\\Drawing1 Layout1 test 2.pdf"));
        try {
            PDPage page = doc.getPage(0);
            PDPageContentStream contents = new PDPageContentStream(doc, page,true,true);


            //use for inserting images  // draw the image at full size at (x=20, y=20)
            
            //BufferedImage bimage = ImageIO.read(new File("src/Executable/EGITestTemplate.png"));
            //PDImageXObject ximage = LosslessFactory.createFromImage(doc, bimage);


            //contents.drawImage(ximage, 0, 0);

            contents.beginText();
            contents.newLineAtOffset(0,0);
            contents.setFont(PDType1Font.TIMES_ROMAN, 12);
            contents.showText("This is your test text that should work in PDFBox 2.0");
            contents.endText();

            // to draw the image at half size at (x=20, y=20) use
            // contents.drawImage(pdImage, 20, 20, pdImage.getWidth() / 2, pdImage.getHeight() / 2);




            contents.close();
            doc.save(pdfPath);
        } finally {
            doc.close();
        }

    }

    //Opens a save panel from filechoose and allows us to set the pdf save pathname
    public void getSaveLocation() {

        File file = null;
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

        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = chooser.showSaveDialog(null);

        try {
            if (result == chooser.APPROVE_OPTION) {
                file = chooser.getSelectedFile();

            } else {
                file = null;
            }

            String filename = file.toString();
            if (filename.endsWith(".pdf")) {

            }
            else{

                filename = filename + ".pdf";
            }


            String image = "EGI.png";


            //Checks to see if file pathname already exists and gives override option
            File fileOverwriteCondition = new File(filename);
            if(fileOverwriteCondition.exists()){

                int a = JOptionPane.showConfirmDialog(null,"Do you want to overwrite an existing file?",null,JOptionPane.YES_NO_OPTION);

                if(a == JOptionPane.YES_OPTION){

                    try {
                        imageCreator(image, filename);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                else if (a == JOptionPane.NO_OPTION){

                    getSaveLocation();
                }


            }
            else{

                try {
                    imageCreator(image, filename);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }



        }
        catch(Exception er){}

    }

}


