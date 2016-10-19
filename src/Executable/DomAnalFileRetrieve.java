package Executable;

import java.io.IOException;

/**
 * Created by bryan on 10/18/2016.
 */
public class DomAnalFileRetrieve {

    static String WIN_PROGRAMFILES = System.getenv("programfiles");
    static String DEFAULT_COMPANY_NAME = "Default Company Name";
    static String DOMANALSETUP = "DomAnalSetup";
    static String FILE_SEPARATOR   = System.getProperty("file.separator");

    public static void retrieveDomAnal(){
        String[] commands =
                {"cmd.exe",
                        "/c",
                        WIN_PROGRAMFILES
                                + FILE_SEPARATOR
                                +DEFAULT_COMPANY_NAME
                                +FILE_SEPARATOR
                                +DOMANALSETUP
                                +FILE_SEPARATOR
                                + "DomAnal.exe"};
        try {
            Runtime.getRuntime().exec(commands);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
