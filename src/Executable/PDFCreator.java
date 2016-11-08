package Executable;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.util.Matrix;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URISyntaxException;

/**
 * Created by bryan on 10/25/2016.
 */
public class PDFCreator {

    PDFCreator() {

    }

    //Used to create an image
    public void imageCreator(String pathImage, String savePDFPath,mainWindow mw) throws IOException, URISyntaxException {

        String imagePath = pathImage;
        String pdfPath = savePDFPath;
        File fileTest = new File(pdfPath);
        String fileTitle = fileTest.getName();

        //Removes the .pdf extension when placed in the PDF title
        if (fileTitle.endsWith(".pdf")){

            fileTitle = fileTitle.replace(".pdf"," ");
        }
        if (!pdfPath.endsWith(".pdf")) {
            System.err.println("Last argument must be the destination .pdf file");
            System.exit(1);
        }

        //gets the bite filepath of the pdf template
        InputStream inputStream = PDFCreator.class.getResourceAsStream("test2.pdf");
        PDDocument doc = PDDocument.load(inputStream);

        try {
            PDPage page = doc.getPage(0);
            PDPageContentStream contents = new PDPageContentStream(doc, page,true,true);


            contents.setNonStrokingColor(Color.BLACK);

            //Retrieve EGI imagepath and set in the file
            BufferedImage bimage = ImageIO.read(getClass().getResource("EGI.png"));
            PDImageXObject ximage = LosslessFactory.createFromImage(doc, bimage);
            contents.drawImage(ximage, 10, 701);

            //Adds the filepath Title in the PDF document first page
            contents.beginText();
            contents.newLineAtOffset(157,608);
            contents.setFont(PDType1Font.TIMES_ROMAN, 12);
            contents.showText(mw.getDepthText().getText());
            contents.endText();

           //Sets the title centered near the top of the document.
            String title = "File: " + fileTitle;
            int fontSize = 16;
            Point2D.Float center = new Point2D.Float(0, 370); //sets the title position offset
            addCenteredText(title,PDType1Font.TIMES_BOLD,fontSize,contents,page,center);

            contents.close();
            doc.save(pdfPath);
        } finally {
            doc.close();
        }

    }

    //Text center method
    void addCenteredText(String text, PDFont font, int fontSize, PDPageContentStream content, PDPage page, Point2D.Float offset) throws IOException {
        content.setFont(font, fontSize);
        content.beginText();


        Point2D.Float pageCenter = getCenter(page);

        // We use the text's width to place it at the center of the page
        float stringWidth = font.getStringWidth(text) * fontSize / 1000F;

            float textX = pageCenter.x - stringWidth / 2F + offset.x;
            float textY = pageCenter.y + offset.y;
            content.setTextMatrix(Matrix.getTranslateInstance(textX, textY));

        content.showText(text);
        content.endText();
    }

    //Finds the center of the PDF page in float type Point2D
    Point2D.Float getCenter(PDPage page) {
        PDRectangle pageSize = page.getMediaBox();

        float pageWidth = pageSize.getWidth();
        float pageHeight = pageSize.getHeight();

        return new Point2D.Float(pageWidth / 2F, pageHeight / 2F);
    }

    //Opens a save panel from filechoose and allows us to set the pdf save pathname
    public void getSaveLocation(mainWindow mw) {

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
                        imageCreator(image, filename, mw);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                else if (a == JOptionPane.NO_OPTION){

                    getSaveLocation(mw);
                }


            }
            else{

                try {
                    imageCreator(image, filename, mw);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }



        }
        catch(Exception er){}

    }

}


