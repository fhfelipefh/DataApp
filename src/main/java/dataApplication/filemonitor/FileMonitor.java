package dataApplication.filemonitor;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;

@Component
public class FileMonitor {

    private final String inputDirectory = "./Data/in";
    private final String outputDirectory = "./Data/out";

    File input = new File(inputDirectory);
    File output = new File(outputDirectory);

    File[] afilein = input.listFiles();
    File[] afileout = output.listFiles();

    public File[] refreshInputFileList() {
        return input.listFiles();
    }

    public File[] refreshOutputFileList() {
        return output.listFiles();
    }

    public ArrayList convertInputListToArrayListOfNames() {
        afilein = refreshInputFileList();
        ArrayList<String> arrayListInputFiles = new ArrayList();
        if (afilein == null) {
            return arrayListInputFiles;
        }
        int s = 0;
        for (int j = afilein.length; s < j; s++) {
            if (afilein[s].getName().endsWith(".dat") && afilein[s].isFile())
                arrayListInputFiles.add(afilein[s].getName());
        }
        return arrayListInputFiles;
    }

    public ArrayList convertOutputListToArrayListOfNames() {
        afileout = refreshOutputFileList();
        ArrayList<String> arrayListOutputFiles = new ArrayList();
        if (afileout == null) {
            return arrayListOutputFiles;
        }
        int s = 0;
        for (int j = afileout.length; s < j; s++) {
            if (afileout[s].getName().endsWith("done.dat") && afileout[s].isFile())
                arrayListOutputFiles.add(afileout[s].getName());
        }
        return arrayListOutputFiles;
    }

    public boolean validateFile(String fileDirectory) {
        File file = new File(fileDirectory);
        if (!file.exists()) {
            System.out.println("File not found");
            return false;
        }
        if (!file.getName().endsWith("dat")) {
            System.out.println("File is not a .dat file");
            return false;
        }
        if (file.length() == 0) {
            System.out.println("File is empty");
        }
        String fileContent = "";
        try {
            fileContent = new String(java.nio.file.Files.readAllBytes(file.toPath()));
            System.out.println(fileContent);
        } catch (Exception e) {
            System.out.println("File is empty");
        }
        if (!fileContent.contains("- Amount of clients in the input file:")) {
            System.out.println("File does not contain the text: Amount of clients in the input file:");
            return false;
        } else if (!fileContent.contains("Amount of salesman in the input file:")) {
            System.out.println("File does not contain the text: Amount of salesman in the input file:");
            return false;
        } else if (!fileContent.contains("ID of the most expensive sale:")) {
            System.out.println("File does not contain the text: ID of the most expensive sale:");
            return false;
        } else if (!fileContent.contains("Worst salesman ever:")) {
            System.out.println("File does not contain the text: Worst salesman ever:");
            return false;
        }
        return true;
    }


}
