package dataApplication.costumerDataAnalysis;

import dataApplication.model.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CustomerDataAnalysis {

    private String spacerS;

    public Customer costumerDataAnalysis(String line, String spacer) {
        spacerS = spacer;
        String[] array = line.split(spacer);
        if (array.length == 4) {
            return new Customer(array[1], array[2], array[3]);
        } else {
            String[] newArray = getNameAndBusinessAreaWithSpacer(array).toArray(new String[0]);
            return new Customer(newArray[1], newArray[2], newArray[3]);
        }
    }

    private ArrayList<String> getNameAndBusinessAreaWithSpacer(String[] array) {
        StringBuilder name = new StringBuilder();
        ArrayList<String> newArray = new ArrayList<String>();
        newArray.add(array[0]);
        newArray.add(array[1]);
        for (int i = 0; i < array.length; i++) {
            if (i > 1 && i < array.length - 1) {
                name.append(array[i]);
            }
        }
        newArray.add(name.toString());
        newArray.add(array[array.length-1]);
        return newArray;
    }

}
