package dataApplication.SalesmanDataAnalysis;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import dataApplication.model.Salesman;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class SalesmanDataAnalysis {


    public Salesman salesmanDataAnalysis(String line, String spacer) {
        String[] array = line.split(spacer);
        if (array.length == 4) {
            return new Salesman(array[1], array[2], BigDecimal.valueOf(Double.parseDouble(array[3])));
        }
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i > 1 && i < array.length - 1) {
                name.append(array[i]);
            }
        }
        return new Salesman(array[1], name.toString(), BigDecimal.valueOf(Double.parseDouble(array[array.length - 1])));
    }


}
