package Executable;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bryan on 10/18/2016.
 */
public class RootTest {




        private String outputFilePath;
        private String fileNameToSearch;
        private List<String> result = new ArrayList<String>();

        public String getFileNameToSearch() {
            return fileNameToSearch;
        }

        public void setFileNameToSearch(String fileNameToSearch) {
            this.fileNameToSearch = fileNameToSearch;
        }

        public List<String> getResult() {
            return result;
        }

        public  String Execute(String fileToSearch){

            RootTest fileSearch = new RootTest();

            //try different directory and filename :)
            fileSearch.searchDirectory(new File("C:\\Program FIles"), fileToSearch);
            fileSearch.searchDirectory(new File("C:\\Program FIles (x86)"), fileToSearch);
            fileSearch.searchDirectory(new File("C:\\Users"), fileToSearch);


            int count = fileSearch.getResult().size();
            if(count ==0){
                System.out.println("\nNo result found!");

            }else{
                System.out.println("\nFound " + count + " result!\n");
                for (String matched : fileSearch.getResult()){
                    System.out.println("Found : " + matched);
                    outputFilePath = fileSearch.getResult().get(0).toString().replace("[","").replace("]","");
                    System.out.println(outputFilePath);

                    System.out.println("hello bryan");
                }
            }
            return outputFilePath;
        }

        public void searchDirectory(File directory, String fileNameToSearch) {

            setFileNameToSearch(fileNameToSearch);

            if (directory.isDirectory()) {
                search(directory);
            } else {
                System.out.println(directory.getAbsoluteFile() + " is not a directory!");
            }

        }

        private void search(File file) {

            if (file.isDirectory()) {

                //System.out.println("Searching directory ... " + file.getAbsoluteFile());

                //do you have permission to read this directory?
                if (file.canRead()) {
                    try {
                        for (File temp : file.listFiles()) {
                            if (temp.isDirectory()) {
                                search(temp);
                            } else {
                                if (getFileNameToSearch().equals(temp.getName())) {
                                    result.add(temp.getAbsoluteFile().toString());
                                }

                            }
                        }
                    }
                    catch(Exception e){

                    }
                } else {
                    System.out.println(file.getAbsoluteFile() + "Permission Denied");
                }
            }

        }

    public static void runFilePath(String filePath){
        String commands = filePath;

        try {
            Runtime.getRuntime().exec(commands);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    }

