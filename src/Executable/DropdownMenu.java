package Executable;

import com.sun.xml.internal.ws.api.config.management.policy.ManagementAssertion;
import oracle.jrockit.jfr.JFR;
import org.omg.SendingContext.RunTime;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.awt.SystemColor.desktop;
import static java.awt.SystemColor.menu;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 * Created by bryan on 10/11/2016.
 */
public class DropdownMenu  {


    public void buildMenuBar( SettingsFrame sf, mainWindow mw){

        //build file menu

        JMenuBar menubar = new JMenuBar();

        //build file JMenu and JMenuItems
        JMenu file = new JMenu("File");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem projectSettings = new JMenuItem("Project Settings");
        JMenuItem exit = new JMenuItem("Exit");
        file.add(open);
        file.add(save);
        file.add(projectSettings);
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
                String helpFilePath = helpTest.Execute("EGI User Manual.chm");
                //executes the .chm file
                try {
                    Runtime.getRuntime().exec("hh.exe "+helpFilePath);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }


        });

        //Work on this later. Use JFileChooser to open and import saved files(later implimentation too)
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser fc = new JFileChooser();
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
