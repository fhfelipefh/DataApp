package dataApplication.TestWithExamples;

import dataApplication.dataservice.DataService;
import dataApplication.filemonitor.FileMonitor;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestWithExamples {

    private static final String TEST_FILE_PATH = "src/test/resources/Data/out/testWithExamples.done.dat";

    /**
     * This class is used to test the data application with examples.
     *
     * @author fhfelipefh
     * <p>
     * examples:
     * 001ç1234567891234çPedroç50000
     * 001ç3245678865434çPauloç40000.99
     * 002ç2345675434544345çJose da SilvaçRural
     * 002ç2345675433444345çEduardo PereiraçRural
     * 003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro
     * 003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo
     */

    @Test
    public void testWithExamples() throws IOException {
        DataService dataService = new DataService();
        FileMonitor fileMonitor = new FileMonitor();
        String fileContent =
                        "001ç1234567891234çPedroç50000\n" +
                        "001ç3245678865434çPauloç40000.99\n" +
                        "002ç2345675434544345çJose da SilvaçRural\n" +
                        "002ç2345675433444345çEduardo PereiraçRural\n" +
                        "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro\n" +
                        "003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo";

        dataService.analyzeData("testWithExamples.dat", fileContent);
        assertTrue(fileMonitor.validateFile(TEST_FILE_PATH));
    }


}
