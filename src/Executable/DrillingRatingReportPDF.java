package Executable;

import com.qoppa.pdfWriter.DocumentInfo;
import com.qoppa.pdfWriter.PDFDocument;
import com.qoppa.pdfWriter.PDFPage;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorConvertOp;
import java.awt.print.PageFormat;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

public class DrillingRatingReportPDF {

    public int getLastPageNumber() {
        return lastPageNumber;
    }

    int lastPageNumber;
    public void setLastPageNumber(int lastPageNumber) {
        this.lastPageNumber = lastPageNumber;
    }

public DrillingRatingReportPDF(ArrayList<ArrayList> arrayLabelHolder, ArrayList<ArrayList> arrayValueHolder, ArrayList<BufferedImage> chartBufferedImageArray ) {




    String[] arrayTitles = {"drilling Stability Inputs","Rock Property Inputs","Discontinuity Inputs","Geomechanical Outputs"};

    PDFDocument pdfDoc = new PDFDocument();
    PDFPage page = pdfDoc.createPage(null);
    PageFormat pf = new PageFormat();
    double pageWidth = pf.getWidth();
    double pageHeight = pf.getHeight();


    URL url = mainWindow.class.getResource("/Images/Nexen Logo.png");

    //page margins 1 inch
    int marginTop = 36;
    int marginBot = 36;
    int marginLeft = 36;
    int marginRight = 36;

    //highest page top height and low height
    int minComponentHeight = 115;
    int maxComponentHeight = 700;

    //When I build a page and add on to it I need a value to track the current page hate before building a new one
    int currentPageHeight = 85;

    //Current page number used to append items down the list
    lastPageNumber = 0;

    double resizeWidthRatio = .3;
    double resizeHeightRatio = .3;
    BufferedImage bufferedLogo = resizedBufferedImage(url,resizeWidthRatio,resizeHeightRatio);


    //First page added is outside the loop
    pdfDoc.addPage(page);

    //Loops and adds the drilling components and values
    for(int i = 0;i<arrayLabelHolder.size();i++){

        currentPageHeight = reportStringBuilder(pdfDoc,lastPageNumber,currentPageHeight,((ArrayList) arrayLabelHolder.get(i)),((ArrayList) arrayValueHolder.get(i)), arrayTitles[i]);

        //Page cutoff value. This makes sure a new page is generated if we start appending near the end
        currentPageHeight = pageLengthChecker(currentPageHeight,pdfDoc);
    }

    reportStringBuilder(pdfDoc,lastPageNumber,currentPageHeight,chartBufferedImageArray);
    //add the reocurring elements that you want on every page
    reocurringPageItemsSetter(pdfDoc,bufferedLogo,resizeWidthRatio,resizeHeightRatio,pageWidth,pageHeight,marginBot,marginTop,marginLeft,marginRight);


    String filename = getSaveLocation();

    //adds the filename title to the first page
    fileNamePosition(pdfDoc,filename);

    File outFile = new File(filename);
        if (outFile != null)
    {
        // save the document
        try {
            pdfDoc.saveDocument (outFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

    public void fileNamePosition(PDFDocument pdfDoc, String fileName){

        File f = new File(fileName);
        //gets the name of the filepath and also removed the extension
        String name = f.getAbsolutePath().substring(f.getAbsolutePath().lastIndexOf("\\")+1);
        name = name.replace(".pdf","");

        //makes sure the title does not extend into the logo. If it is greater than 64, we wont
        //report the titlea
        if(name.length() < 64){

            //draws the filename string
            int height = 45;
            int length = 45;
            Graphics2D g2dlabelTitle = pdfDoc.getPage(0).createGraphics();
            g2dlabelTitle.setFont(new Font("Times New Roman",Font.PLAIN,15));
            g2dlabelTitle.setColor(Color.black);
            g2dlabelTitle.drawString(name,length,height);

        }


    }

    //builds the page and also returns the current page height for checking how much page length is left
    public int reportStringBuilder(PDFDocument pdfDoc,int latestPageNumber,int currentPageHeight, ArrayList<String> reportTitles,
                                   ArrayList<String> reportValues, String stringTitle){

        //Title heights
        int heightMainTitle = currentPageHeight;
        int x1MainTitle = 45;

        //Text heights below the title
        int heightinitial = currentPageHeight+30;
        int lengthLabel = 72;
        int lengthValue = 400;

        //builds the basic title
        String firstGlanceTitle = stringTitle;
        Graphics2D  g2dFirstGlanceTitle = pdfDoc.getPage(latestPageNumber).createGraphics();
        Font titleFont = new Font("Times New Roman",Font.BOLD,16);
        g2dFirstGlanceTitle.setFont(titleFont);
        g2dFirstGlanceTitle.setColor(Color.black);
        g2dFirstGlanceTitle.drawString(firstGlanceTitle,x1MainTitle, heightMainTitle);

        //underlines the title
        int lineLength = g2dFirstGlanceTitle.getFontMetrics(titleFont).stringWidth(firstGlanceTitle);
        Graphics2D  g2dTitleUnderline = pdfDoc.getPage(latestPageNumber).createGraphics();
        g2dTitleUnderline.drawLine(x1MainTitle,heightMainTitle+3,x1MainTitle+lineLength,heightMainTitle+3);


        for (int i = 0;i<reportTitles.size();i++){

            //Page cutoff value while looping. This makes sure a new page is
            // generated if we start appending near the end
            if(heightinitial > 600){

                PDFPage page2 = pdfDoc.createPage(null);
                pdfDoc.addPage(page2);
                setLastPageNumber(pdfDoc.getPageCount()-1);
                latestPageNumber = getLastPageNumber();
                currentPageHeight = 85;
                heightinitial = currentPageHeight+30;
            }

            //draws the label string
            String labelTitle = reportTitles.get(i);
            Graphics2D  g2dlabelTitle = pdfDoc.getPage(latestPageNumber).createGraphics();
            g2dlabelTitle.setFont(new Font("Times New Roman",Font.BOLD,12));
            g2dlabelTitle.setColor(Color.black);
            g2dlabelTitle.drawString(labelTitle,lengthLabel, heightinitial);

            //draws the value string
            String valueTitle = reportValues.get(i);
            Graphics2D  g2dvalueTitle = pdfDoc.getPage(latestPageNumber).createGraphics();
            g2dvalueTitle.setFont(new Font("Times New Roman",Font.PLAIN,12));
            g2dvalueTitle.setColor(Color.black);
            g2dvalueTitle.drawString(valueTitle,lengthValue, heightinitial);

            heightinitial = heightinitial+30;

        }

        return  heightinitial;

    }
    public int reportStringBuilder(PDFDocument pdfDoc,int latestPageNumber,int currentPageHeight, ArrayList<BufferedImage> bufferedChartArrayList){

        //Text heights below the title
        int heightinitial = currentPageHeight+30;
        PageFormat pf = new PageFormat();
        double pageWidth = pf.getWidth()/2;


        for (int i = 0;i<bufferedChartArrayList.size();i++){

            //Page cutoff value while looping. This makes sure a new page is
            // generated if we start appending near the end
            if(heightinitial > 600){

                PDFPage page2 = pdfDoc.createPage(null);
                pdfDoc.addPage(page2);
                setLastPageNumber(pdfDoc.getPageCount()-1);
                latestPageNumber = getLastPageNumber();
                currentPageHeight = 85;
                heightinitial = currentPageHeight+30;
            }

            Graphics2D chartGraphics = pdfDoc.getPage(latestPageNumber).createGraphics();
            BufferedImageOp op = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_sRGB), null);

            chartGraphics.drawImage(bufferedChartArrayList.get(i), op,20,heightinitial);


            heightinitial = heightinitial+575;




        }

        return  heightinitial;

    }
    public int pageLengthChecker(int pageHeightChecked, PDFDocument pdfDoc ){

        if(pageHeightChecked > 600){

            PDFPage page2 = pdfDoc.createPage(null);
            pdfDoc.addPage(page2);
            lastPageNumber = pdfDoc.getPageCount()-1;
            pageHeightChecked = 85;
        }

        return pageHeightChecked;
    }
    //Has the user choose the file save location of the pdf
    public String getSaveLocation() {

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
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF", "pdf");
        chooser.setFileFilter(filter);

        int result = chooser.showSaveDialog(null);

        try {
            if (result == chooser.APPROVE_OPTION) {
                file = chooser.getSelectedFile();

            } else {
                file = null;
            }

            filename = file.toString();
            if (filename.endsWith(".pdf")) {

            }
            else{

                filename = filename + ".pdf";
            }


            //Checks to see if file pathname already exists and gives override option
            File fileOverwriteCondition = new File(filename);
            if(fileOverwriteCondition.exists()){

                int a = JOptionPane.showConfirmDialog(null,"Do you want to overwrite an existing file?",null,JOptionPane.YES_NO_OPTION);

                if(a == JOptionPane.YES_OPTION){

                    return filename;

                }
                else if (a == JOptionPane.NO_OPTION){

                    getSaveLocation();
                }


            }
            else{
            }

        }
        catch(Exception er){}

        return filename;
    }

    //resizes the logo image
    public BufferedImage resizedBufferedImage(URL url, double resizeWidthRatio, double resizeHeightRatio){


        BufferedImage bufferedImage = null;
        BufferedImage bufferedResized = null;
        try {
            bufferedImage = ImageIO.read(url);
            bufferedResized = scale(bufferedImage,BufferedImage.TYPE_INT_ARGB,bufferedImage.getWidth(),bufferedImage.getHeight(),resizeWidthRatio,resizeHeightRatio);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bufferedResized;

    }

    //scaling tool
    public static BufferedImage scale(BufferedImage sbi, int imageType, int dWidth, int dHeight, double fWidth, double fHeight) {
        BufferedImage dbi = null;
        if(sbi != null) {
            dbi = new BufferedImage(dWidth, dHeight, imageType);
            Graphics2D g = dbi.createGraphics();
            AffineTransform at = AffineTransform.getScaleInstance(fWidth, fHeight);
            g.drawRenderedImage(sbi, at);
        }
        return dbi;
    }


    //The items here are to be displayed on every page generated
    public void reocurringPageItemsSetter(PDFDocument pdfDoc, BufferedImage bufferedLogo, double resizeWidthRatio, double resizeHeightRatio, double pageWidth, double pageHeight, int marginBottom, int marginTop, int marginLeft, int marginRight){

        int pageCount = pdfDoc.getPageCount();
        Graphics2D g2dLogo = null;
        Graphics2D g2dLine = null;
        Graphics2D g2dPage = null;
        String pageNumber = null;
        BufferedImageOp op = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_sRGB), null);

        for(int i = 0;i<pageCount;i++){

            //adds the company logo near the top right of the page
            g2dLogo = pdfDoc.getPage(i).createGraphics();
            g2dLogo.drawImage(bufferedLogo, op,(int) (Math.round(pageWidth)-marginRight-Math.round(bufferedLogo.getWidth()*resizeWidthRatio)),(int) Math.round(marginTop-bufferedLogo.getHeight()*resizeHeightRatio/2-8) );
            // g2dLogo.setStroke(new BasicStroke(1));
            //g2dLogo.setColor(Color.black);
            //g2dLogo.drawRect((int) (Math.round(pageWidth)-marginRight-Math.round(bufferedLogo.getWidth()*resizeWidthRatio))-1,(int) Math.round(marginTop-bufferedLogo.getHeight()*resizeHeightRatio/2-8),(int) Math.round(bufferedLogo.getWidth()*resizeWidthRatio)+2,(int) Math.round(bufferedLogo.getHeight()*resizeHeightRatio)+2);


            //draws the page number of each page in the document
            pageNumber = "Page "+Integer.toString(i+1);
            g2dLine = pdfDoc.getPage(i).createGraphics();
            g2dPage = pdfDoc.getPage(i).createGraphics();
            g2dPage.setFont(new Font("Times New Roman",Font.PLAIN,12));
            g2dPage.setColor(Color.blue);
            g2dPage.drawString(pageNumber,(int) Math.round(pageWidth/2),(int) Math.round(pageHeight-marginBottom+5));

            //draws the default lines near the bottom and top margins
            g2dLine.drawLine(marginLeft,51,(int) Math.round(pageWidth)-marginRight,51);
            g2dLine.drawLine(marginLeft,741,(int) Math.round(pageWidth)-marginRight,741);

        }

    }


}

