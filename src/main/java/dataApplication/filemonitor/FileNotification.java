package dataApplication.filemonitor;

public class FileNotification implements Runnable {

    FileMonitor monitor;

    public FileNotification(FileMonitor monitor) {
        this.monitor = monitor;
    }

    private boolean notificationDataInDirectory() {
        if (monitor.refreshInputFileList() == null) {
            System.out.println("Data/in not found");
            return false;
        }
        return true;
    }

    private boolean notificationDataOutDirectory() {
        if (monitor.refreshOutputFileList() == null) {
            System.out.println("Data/out not found");
            return false;
        }
        return true;
    }

    @Override
    public void run() {
        while (true) {
            notificationDataInDirectory();
            notificationDataOutDirectory();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
