package dataApplication.saleDataAnalysis;

import dataApplication.model.SaleData;
import dataApplication.model.Sales;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;

@Component
public class SaleDataAnalysis {

    public Sales saleDataAnalysis(String line, String spacer) {
        String[] array = line.split(spacer);
        if (array.length == 4) {
            String sale = array[2];
            return new Sales(Integer.parseInt(array[1]), generateSaleData(sale), array[3]);
        }
        String sale = array[2];
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i > 2) {
                name.append(array[i]);
            }
        }
        return new Sales(Integer.parseInt(array[1]), generateSaleData(sale), name.toString());
    }

    public ArrayList<SaleData> generateSaleData(String saleDataString) {
        ArrayList<SaleData> saleData = new ArrayList<>();
        saleDataString = saleDataString.substring(1, saleDataString.length() - 1);
        String[] sales = saleDataString.split(",");
        for (String s : sales) {
            String[] salesVar = s.split("-");
            SaleData saleObj = new SaleData(Integer.parseInt(salesVar[0]), Integer.parseInt(salesVar[1]), BigDecimal.valueOf(Double.parseDouble(salesVar[2])));
            saleData.add(saleObj);
        }
        return saleData;
    }

}
