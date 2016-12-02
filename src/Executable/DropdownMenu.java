package Executable;

import javax.swing.*;
import java.awt.*;
import java.io.Reader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by bryan on 10/11/2016.
 */
public class DropdownMenu  {

    JMenuItem exportPDF = new JMenuItem("Export Report");

    public JMenuItem getExportPDF() {
        return exportPDF;
    }

    public void buildMenuBar(mainWindow mw){

        //build file menu

        JMenuBar menubar = new JMenuBar();
        exportPDF = new JMenuItem("Export Report");
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
        URL url = mainWindow.class.getResource("/Images/DomAnal Image.png");
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

        about.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                AboutDialog ad = new AboutDialog(mw.getVersionNumber());
                ad.initialize();

            }
        });


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

                //gets the bite filepath of the .chm file
                InputStream inputStream = PDFCreator.class.getResourceAsStream("EGI User Manual.chm");

                //executes the .chm file
                try {
                    Runtime.getRuntime().exec("hh.exe "+inputStream);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }


        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    SaveLoadFileData sdSave = new SaveLoadFileData();
                    String filename = sdSave.getSaveLocation(mw);
                    sdSave.writeCSVFile(mw,filename);
                }
                catch (Exception ex2){

                }

            }
        });
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    SaveLoadFileData sdLoad = new SaveLoadFileData();
                    String filename = sdLoad.getLoadLocation(mw);
                    try {
                        Reader read = null;
                        read = sdLoad.readCSV(filename, mw);

                    } catch (Exception e1) {

                    }
                }
        });

        projectSettings.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                SettingDialog sf = new SettingDialog(mw,exportPDF );
                sf.initialize();

            }
        });
        mw.setJMenuBar(menubar);
    }
}
