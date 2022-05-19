package main;

import dataApplication.AppConfig.AppConfig;
import dataApplication.dataservice.DataService;
import dataApplication.filemonitor.FileMonitor;
import dataApplication.filemonitor.FileNotification;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        DataService dataService = (DataService) context.getBean("dataService");
        FileMonitor fileMonitor = (FileMonitor) context.getBean("fileMonitor");
        FileNotification fileNotification = (FileNotification) context.getBean("fileNotification");
        Thread fileNotificationThread = new Thread(fileNotification);
        fileNotificationThread.start();
        System.out.println("Data Analysis start");
        while (true) {
            dataService.readRawFiles();
        }
    }
}