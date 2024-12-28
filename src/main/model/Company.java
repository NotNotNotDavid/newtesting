package model;

public abstract class Company {

    String companyName;
    int price;

    public Company(String companyName, int price) {
        this.companyName = companyName;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return companyName;
    }


}
