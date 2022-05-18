package dataApplication.filemonitor;

import org.springframework.stereotype.Component;

import java.io.*;
import java.lang.System;

@Component
public class FileCreator {

    private static String OUTPUT_DIRECTORY = "./Data/out/";
    private static String TEST_DIRECTORY = "src/test/resources/Data/out/";

    public boolean createFile(String flatFileName, String infoText) throws IOException {
        try {
            if(flatFileName.contains(".dat")){
                flatFileName = flatFileName.replace(".dat","");
            }
            FileWriter fileWriter = null;
            if(!flatFileName.equals("testWithExamples")) {
                File output = new File(OUTPUT_DIRECTORY + flatFileName + ".done" + ".dat");
                output.createNewFile();
                fileWriter = new FileWriter(OUTPUT_DIRECTORY + flatFileName + ".done" + ".dat");
            } else {
                File output = new File(TEST_DIRECTORY + flatFileName + ".done" + ".dat");
                output.createNewFile();
                fileWriter = new FileWriter(TEST_DIRECTORY + flatFileName  + ".done" + ".dat");
            }
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.printf(infoText);
            printWriter.close();
            return true;
        } catch (IOException e) {
            System.out.println("Cannot write files: " + e);
            return false;
        }
    }

}
