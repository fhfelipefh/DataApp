package dataApplication.dataservice;

import dataApplication.SalesmanDataAnalysis.SalesmanDataAnalysis;
import dataApplication.costumerDataAnalysis.CustomerDataAnalysis;
import dataApplication.filemonitor.FileCreator;
import dataApplication.filemonitor.FileMonitor;
import dataApplication.model.Customer;
import dataApplication.model.SaleData;
import dataApplication.model.Sales;
import dataApplication.model.Salesman;
import dataApplication.saleDataAnalysis.SaleDataAnalysis;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

@Service
public class DataService {

    FileCreator fileCreator = new FileCreator();
    FileMonitor fileMonitor = new FileMonitor();

    private final String inputDirectory = "./Data/in/";
    private final String spacer = "ç";
    ArrayList<String> inputList;
    ArrayList<String> outputList;
    ArrayList<String> unprocessedFileNames;
    SalesmanDataAnalysis salesmanDataAnalysis = new SalesmanDataAnalysis();
    CustomerDataAnalysis customerDataAnalysis = new CustomerDataAnalysis();
    SaleDataAnalysis saleDataAnalysis = new SaleDataAnalysis();

    private ArrayList<String> returnUnprocessedFileNames() {
        inputList = fileMonitor.convertInputListToArrayListOfNames();
        outputList = fileMonitor.convertOutputListToArrayListOfNames();
        ArrayList<String> outputVar = new ArrayList();
        ArrayList<String> inputVar = new ArrayList();

        for (String o : outputList) {
            o = o.replace(".done.dat", "");
            outputVar.add(o);
        }
        for (String i : inputList) {
            i = i.replace(".dat", "");
            inputVar.add(i);
        }

        for (int i = 0; i < outputVar.size(); i++) {
            for (int s = 0; s < inputVar.size(); s++) {
                if (inputVar.get(s).equals(outputVar.get(i))) {
                    inputVar.remove(s);
                    i = 0;
                }
            }
        }
        return inputVar;
    }

    public boolean readRawFiles() {
        unprocessedFileNames = returnUnprocessedFileNames();
        if (inputList.size() > 0 && unprocessedFileNames.size() > 0) {
            int percentage = (unprocessedFileNames.size() * 100);
            System.out.println("percentage of unprocessed files: " + percentage / inputList.size() + "%");
        }
        if (unprocessedFileNames.size() > 0) {
            StringBuilder fileContents = new StringBuilder();
            try (Scanner sc = new Scanner(new File(inputDirectory + unprocessedFileNames.get(0) + ".dat"), "UTF-8")) {
                while (sc.hasNextLine()) {
                    fileContents.append(sc.nextLine() + "\n");
                }
                analyzeData(unprocessedFileNames.get(0), fileContents.toString());
                return true;
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return false;
    }

    public boolean analyzeData(String fileName, String fileContents) throws IOException {
        ArrayList<Salesman> salesman = new ArrayList<>();
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Sales> sales = new ArrayList<>();

        if (!fileContents.contains(spacer)) {
            System.out.println("The file " + fileName + " It is invalid!");
            return false;
        } else {
            Scanner scan = new Scanner(fileContents);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                if (line.startsWith("001")) {
                    salesman.add(salesmanDataAnalysis.salesmanDataAnalysis(line,spacer));
                } else if (line.startsWith("002")) {
                    customers.add(customerDataAnalysis.costumerDataAnalysis(line,spacer));
                } else if (line.startsWith("003")) {
                    sales.add(saleDataAnalysis.saleDataAnalysis(line,spacer));
                } else {
                    System.out.println("line in invalid format.");
                    break;
                }
            }
            String infoText = "- Amount of clients in the input file: " + getAmountOfClients(customers) + "\n" +
                    "- Amount of salesman in the input file: " + getAmountOfSalesman(salesman) + "\n" +
                    "- ID of the most expensive sale: " + getMostExpensiveSaleID(sales) + "\n" +
                    "- Worst salesman ever: " + getWorstSalesmanEver(sales) + "\n";
            System.out.println("Processed file: " + fileName);
            return fileCreator.createFile(fileName, infoText);
        }
    }

    private String getWorstSalesmanEver(ArrayList<Sales> sales) {
        String worstSalesman = "";
        Double worstSale = 0D;
        Double aux = 0D;
        Integer worstSaleID = 0;
        for (int o = 0; o < sales.size(); o++) {
            for (SaleData sd : sales.get(o).getSaleData()) {
                aux += sd.getQuantity() * sd.getItemPrice().doubleValue();
            }
            if (o == 0 || aux < worstSale) {
                worstSaleID = sales.get(o).getSaleID();
                worstSale = aux;
            }
            aux = 0D;
        }
        for (Sales s : sales) {
            if (s.getSaleID() == worstSaleID) {
                worstSalesman = s.getSalesmanName();
            }
        }
        return worstSalesman;
    }


    private int getMostExpensiveSaleID(ArrayList<Sales> sales) {
        int mostExpensiveID = 0;
        Double mostExpensiveSale = 0D;
        Double aux = 0D;
        for (int i = 0; i < sales.size(); i++) {
            for (SaleData sd : sales.get(i).getSaleData()) {
                aux += sd.getQuantity() * sd.getItemPrice().doubleValue();
            }
            if (i == 0 || aux > mostExpensiveSale) {
                mostExpensiveID = sales.get(i).getSaleID();
                mostExpensiveSale = aux;
            }
            aux = 0D;
        }
        return mostExpensiveID;
    }

    private int getAmountOfClients(ArrayList<Customer> customers) {
        HashSet<String> hashSet = new HashSet<String>();
        for (Customer c : customers) {
            hashSet.add(c.getCnpj());
        }
        return hashSet.size();
    }

    private int getAmountOfSalesman(ArrayList<Salesman> salesman) {
        HashSet<String> hashSet = new HashSet<String>();
        for (Salesman s : salesman) {
            hashSet.add(s.getCpf());
        }
        return hashSet.size();
    }


}
