package dataApplication.costumerDataAnalysis;

import dataApplication.AppConfig.AppConfig;
import dataApplication.model.Customer;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerDataAnalysisTest {

    @Mock
    private ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    @Mock
    private CustomerDataAnalysis customerDataAnalysis = (CustomerDataAnalysis) context.getBean("customerDataAnalysis");

    @Test
    public void shouldReturnAnObjectWithAllData() {
        String line = "002ç2345675433444345çEduardo PereiraçRural";
        Customer customerTest = new Customer("2345675433444345", "Eduardo Pereira", "Rural");
        Customer customerByDataAnalysis = customerDataAnalysis.costumerDataAnalysis(line, "ç");
        assertEquals(customerTest.getCnpj(), customerByDataAnalysis.getCnpj());
        assertEquals(customerTest.getBusinessArea(), customerByDataAnalysis.getBusinessArea());
        assertEquals(customerTest.getName(), customerByDataAnalysis.getName());
    }

    @Test
    public void shouldReturnAValidObjectInNameWithSpacer(){
        String line = "002ç2345675433444345çEduardo sçilva PereiraçRural";
        Customer customerTest = new Customer("2345675433444345", "Eduardo silva Pereira", "Rural");
        Customer customerByDataAnalysis = customerDataAnalysis.costumerDataAnalysis(line, "ç");
        assertEquals(customerTest.getCnpj(), customerByDataAnalysis.getCnpj());
        assertEquals(customerTest.getBusinessArea(), customerByDataAnalysis.getBusinessArea());
        assertEquals(customerTest.getName(), customerByDataAnalysis.getName());
    }

}