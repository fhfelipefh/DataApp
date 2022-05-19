package dataApplication.AppConfig;

import dataApplication.SalesmanDataAnalysis.SalesmanDataAnalysis;
import dataApplication.costumerDataAnalysis.CustomerDataAnalysis;
import dataApplication.dataservice.DataService;
import dataApplication.filemonitor.FileCreator;
import dataApplication.filemonitor.FileMonitor;
import dataApplication.filemonitor.FileNotification;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import dataApplication.saleDataAnalysis.SaleDataAnalysis;

@Configuration
@ComponentScan("dataApplication")
public class AppConfig {

    @Bean
    public CustomerDataAnalysis customerDataAnalysis() {
        return new CustomerDataAnalysis();
    }

    @Bean
    public SaleDataAnalysis saleDataAnalysis() {
        return new SaleDataAnalysis();
    }

    @Bean
    public SalesmanDataAnalysis salesmanDataAnalysis() {
        return new SalesmanDataAnalysis();
    }

    @Bean
    public DataService dataService() {
        return new DataService();
    }

    @Bean
    public FileMonitor fileMonitor() {
        return new FileMonitor();
    }

    @Bean
    public FileCreator fileCreator() {
        return new FileCreator();
    }

    @Bean
    public FileNotification fileNotification(FileMonitor monitor) {
        return new FileNotification(monitor);
    }

}
