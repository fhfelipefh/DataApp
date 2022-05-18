package dataApplication.model;

public class Customer {

    String cnpj;
    String name;
    String businessArea;

    public Customer(String cnpj, String name, String businessArea) {
        this.cnpj = cnpj;
        this.name = name;
        this.businessArea = businessArea;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "  cnpj = '" + cnpj + '\'' +
                ", name = '" + name + '\'' +
                ", businessArea = '" + businessArea + '\'' +
                '}';
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getName() {
        return name;
    }

    public String getBusinessArea() {
        return businessArea;
    }
}
