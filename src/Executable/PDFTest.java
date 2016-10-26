package Executable;

import org.apache.pdfbox.cos.ICOSVisitor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1CFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.jfree.io.FileUtilities;

import javax.swing.*;
import java.io.File;
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

        PDDocument doc = new PDDocument();
        try {
            PDPage page = new PDPage();
            doc.addPage(page);

            // createFromFile is the easiest way with an image file
            // if you already have the image in a BufferedImage,
            // call LosslessFactory.createFromImage() instead
            PDImageXObject pdImage = PDImageXObject.createFromFile(imagePath, doc);

            PDPageContentStream contents = new PDPageContentStream(doc, page);

            // draw the image at full size at (x=20, y=20)
            contents.drawImage(pdImage, 20, 20);

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
            filename = filename.replaceAll(".pdf", "");
            filename = filename + ".pdf";
            String image = "D:\\EGI Drilling Advisor Tool\\src\\Executable\\EGI.png";


            try {
                imageCreator(image, filename);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        catch(Exception er){}

    }

}


