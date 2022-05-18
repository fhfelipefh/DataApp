package dataApplication.model;

import java.math.BigDecimal;

public class SaleData {

    int itemID;
    int quantity;
    BigDecimal itemPrice;

    public SaleData(int itemID, int quantity, BigDecimal itemPrice) {
        this.itemID = itemID;
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString() {
        return "SaleData{" +
                "itemID = " + itemID +
                ", quantity = " + quantity +
                ", itemPrice = " + itemPrice +
                '}';
    }

    public int getItemID() {
        return itemID;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }



}
