package dataApplication.model;

import java.util.ArrayList;

public class Sales {

    int saleID;
    ArrayList<SaleData> saleData = new ArrayList<>();
    String salesmanName;

    public Sales(int saleID, ArrayList<SaleData> saleData, String salesmanName) {
        this.saleID = saleID;
        this.saleData = saleData;
        this.salesmanName = salesmanName;
    }

    @Override
    public String toString() {
        return "Sales{" +
                " saleID = " + saleID +
                ", saleData = " + saleData +
                ", salesmanName = '" + salesmanName + '\'' +
                '}';
    }

    public ArrayList<SaleData> getSaleData() {
        return saleData;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public int getSaleID() {
        return saleID;
    }

    public void setSaleData(ArrayList<SaleData> saleData) {
        this.saleData = saleData;
    }
}
