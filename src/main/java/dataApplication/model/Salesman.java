package dataApplication.model;

import java.math.BigDecimal;

public class Salesman {

    String cpf;
    String name;
    BigDecimal salary;

    public Salesman(String cpf, String name, BigDecimal salary) {
        this.cpf = cpf;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Salesman{" +
                " cpf = '" + cpf + '\'' +
                ", name = '" + name + '\'' +
                ", salary = " + salary +
                '}';
    }

    public String getCpf() {
        return cpf;
    }
}
