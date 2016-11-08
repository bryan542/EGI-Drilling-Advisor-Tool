package Executable;

import org.apache.pdfbox.pdmodel.PDDocument;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 * Created by bryan on 10/11/2016.
 */
public class DropdownMenu  {


    public void buildMenuBar(SettingDialog sf, mainWindow mw){

        //build file menu

        JMenuBar menubar = new JMenuBar();
        JMenuItem exportPDF = new JMenuItem("Export Report");
        //build file JMenu and JMenuItems
        JMenu file = new JMenu("File");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem projectSettings = new JMenuItem("Project Settings");
        JMenuItem exit = new JMenuItem("Exit");
        file.add(open);
        file.add(save);
        file.add(projectSettings);
        file.add(exportPDF);
        file.add(exit);
        open.setPreferredSize(new Dimension(100,20));

        //build DomAnal and DomAnal JMenuItems
        JMenu DomAnal = new JMenu("DomAnal");
        //set DomAnal Image icon
        URL url = mainWindow.class.getResource("DomAnal Image.png");
        ImageIcon bg = new ImageIcon(url);
        DomAnal.setIcon(bg);
        //DomAnal JMenuItems
        JMenuItem domAnalLaunch = new JMenuItem("Launch DomAnal Tool");
        DomAnal.add(domAnalLaunch);


        //disable export report initially until calculate button is ran
        exportPDF.setEnabled(false);
        //Execute exportPDF from PDFCreator class
        exportPDF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                PDFCreator pt = new PDFCreator();
                pt.getSaveLocation(mw);
            }
        });

        //build help menu
        JMenu help = new JMenu("Help");
        JMenuItem helpCenter = new JMenuItem("Help Center");
        JMenuItem about = new JMenuItem("About");
        help.add(about);
        help.add(helpCenter);
        about.setPreferredSize(new Dimension(100,20));
        //add menu's to menubar
        menubar.add(file);
        menubar.add(help);
        menubar.add(DomAnal);

        domAnalLaunch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //filepath finder class
                RootTest rt = new RootTest();
                //find file path for DomAnal executable
                String dominalFilePath = rt.Execute("DomAnal.exe");
                //executes the filepath
                rt.runFilePath(dominalFilePath);
            }
        });

        //file->exit action
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        //Help Center file
        helpCenter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //filepath finder class
                RootTest helpTest = new RootTest();
                //find filepath for the help library
                //gets the bite filepath of the pdf template
                InputStream inputStream = PDFCreator.class.getResourceAsStream("EGI User Manual.chm");

                //executes the .chm file
                try {
                    Runtime.getRuntime().exec("hh.exe "+inputStream);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }


        });

        //Work on this later. Use JFileChooser to open and import
        // saved files(later implimentation too). Will make the save document a
        //tab delimited file
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser fc = null;

                LookAndFeel previousLF = UIManager.getLookAndFeel();
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    fc = new JFileChooser();
                    UIManager.setLookAndFeel(previousLF);
                } catch (IllegalAccessException | UnsupportedLookAndFeelException | InstantiationException | ClassNotFoundException er) {}

                fc.setCurrentDirectory(new java.io.File("C:/"));
                fc.setDialogTitle("Choose Dataset to Open");
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                if (fc.showOpenDialog(open)==JFileChooser.APPROVE_OPTION){

                    System.out.println(fc.getSelectedFile().getAbsoluteFile());
                }
            }
        });

        projectSettings.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                sf.setContentPane(sf.projectPanel);
                sf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                sf.pack();
                sf.setLocationRelativeTo(null);
                sf.setVisible(true);

                sf.setTitle("Project Settings");
                //pack frame, set location on monitor, and set visible



/*SettingsDialog settings = new SettingsDialog(frame,true,frame.DepthLabel);

                settings.setLocationRelativeTo(null);
                settings.setVisible(true);
                frame.pack();
*/
            }
        });
        mw.setJMenuBar(menubar);
    }
}
