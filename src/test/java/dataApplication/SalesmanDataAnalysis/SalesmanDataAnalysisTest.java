package dataApplication.SalesmanDataAnalysis;

import dataApplication.AppConfig.AppConfig;
import dataApplication.model.Salesman;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalesmanDataAnalysisTest {

    @Mock
    private ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    @Mock
    private SalesmanDataAnalysis salesmanDataAnalysis = (SalesmanDataAnalysis) context.getBean("salesmanDataAnalysis");

    @Test
    public void shouldReturnSalesmanWithAllData() {
        String line = "001ç1234567891234çDiegoç50000";
        Salesman salesmanToTest = new Salesman("1234567891234", "Diego", BigDecimal.valueOf(50000.0));
        Salesman salesmanBySalesmanDataAnalysis = salesmanDataAnalysis.salesmanDataAnalysis(line,"ç");
        assertEquals(salesmanToTest.toString(), salesmanBySalesmanDataAnalysis.toString());
    }

    @Test
    public void shouldReturnAValidObjectInNameWithSpacer() {
        String spacer = "ç";
        String line = "001"+spacer+"1234567891234"+spacer+"Di"+spacer+"e"+spacer+"go"+spacer+"50000";
        Salesman salesmanToTest = new Salesman("1234567891234", "Diego", BigDecimal.valueOf(50000.0));
        Salesman salesmanBySalesmanDataAnalysis = salesmanDataAnalysis.salesmanDataAnalysis(line,"ç");
        assertEquals(salesmanToTest.toString(), salesmanBySalesmanDataAnalysis.toString());
    }


}