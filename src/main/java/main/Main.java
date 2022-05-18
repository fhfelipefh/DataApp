package main;

import dataApplication.AppConfig.AppConfig;
import dataApplication.dataservice.DataService;
import dataApplication.filemonitor.FileMonitor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        DataService dataService = (DataService) context.getBean("dataService");
        FileMonitor fileMonitor = (FileMonitor) context.getBean("fileMonitor");
        System.out.println("Data Analysis start");
        fileMonitor.notificationDataInDirectory();
        fileMonitor.notificationDataOutDirectory();
        while (true) {
            dataService.readRawFiles();
        }
    }
}