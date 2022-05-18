package dataApplication.saleDataAnalysis;

import dataApplication.AppConfig.AppConfig;
import dataApplication.model.SaleData;
import dataApplication.model.Sales;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaleDataAnalysisTest {

    @Mock
    private ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    @Mock
    private SaleDataAnalysis saleDataAnalysis = (SaleDataAnalysis) context.getBean("saleDataAnalysis");

    @Test
    public void shouldReturnAnSaleWithAllData() {
        String line = "003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çRenato";
        ArrayList<SaleData> saleDataToTest = new ArrayList<>();
        SaleData sale1 = new SaleData(1, 34, BigDecimal.valueOf(10.0));
        SaleData sale2 = new SaleData(2, 33, BigDecimal.valueOf(1.50));
        SaleData sale3 = new SaleData(3, 40, BigDecimal.valueOf(0.10));
        saleDataToTest.add(sale1);
        saleDataToTest.add(sale2);
        saleDataToTest.add(sale3);
        ArrayList<SaleData> saleDataBySale = saleDataAnalysis.generateSaleData("[1-34-10,2-33-1.50,3-40-0.10]");
        assertEquals(saleDataToTest.toString(), saleDataBySale.toString());
    }

    @Test
    public void shouldReturnSalesDataWithAllData() {
        String line = "003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çRenato";
        Sales salesBySaleDataAnalysis = saleDataAnalysis.saleDataAnalysis(line, "ç");
        ArrayList<SaleData> saleDataToTest = new ArrayList<>();
        SaleData sale1 = new SaleData(1, 34, BigDecimal.valueOf(10.0));
        SaleData sale2 = new SaleData(2, 33, BigDecimal.valueOf(1.50));
        SaleData sale3 = new SaleData(3, 40, BigDecimal.valueOf(0.10));
        saleDataToTest.add(sale1);
        saleDataToTest.add(sale2);
        saleDataToTest.add(sale3);
        Sales saleToTest = new Sales(8, saleDataToTest, "Renato");
        assertEquals(saleToTest.toString(), salesBySaleDataAnalysis.toString());
    }

    @Test
    public void shouldReturnAValidObjectInNameWithSpacer() {
        String spacer = "ç";
        String line = "003ç08ç[1-34-10]çRe" + spacer + "nato";
        SaleData saleData = new SaleData(1, 34, BigDecimal.valueOf(10.0));
        ArrayList<SaleData> sales = new ArrayList<>();
        sales.add(saleData);
        Sales saleToTest = new Sales(8, sales, "Renato");
        Sales saleDataBySaleDataAnalysis = saleDataAnalysis.saleDataAnalysis(line, spacer);
        assertEquals(saleToTest.toString(), saleDataBySaleDataAnalysis.toString());
    }

}