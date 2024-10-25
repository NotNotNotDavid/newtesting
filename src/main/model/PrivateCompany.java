package model;

import java.util.Objects;

import org.json.JSONObject;

import persistence.Writable;

public class PrivateCompany implements Writable{

    String companyName;
    int price;
    boolean isBought;

    /*
     * REQUIRES:
     * conpanyName has a non-zero length;
     * 10 >= sharesLeft >= 0.
     *
     * EFFECTS:
     * name on public company is set to companyName;
     * price of the public company is set to price;
     * amount of shares bought is set to sharesBought;
     * amount of shares left is set to sharesLeft;
     */
    public PrivateCompany(String companyName, int price, boolean isBought) {
        this.companyName = companyName;
        this.price = price;
        this.isBought = isBought;
    }

    public String getName() {
        return companyName;
    }

    public int getPrice() {
        return price;
    }

    public boolean isBought() {
        return isBought;
    }

    public void setIsBought(boolean condition){
        isBought = condition;
    }

    // THIS PART IS LEARNED FROM OTHER SOURCES, SEE README FILE
    @Override
    public boolean equals(Object o) {
        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        // If the object is compared with null then return false
        if (o == null) {
            return false;
        }

        // Check if o is an instance of Transaction or not
        if (getClass() != o.getClass()) {
            return false;
        }

        // type casting o to private company to compare data members
        PrivateCompany p = (PrivateCompany) o;

        // this line is to comapre all the different instances of objects
        return price == p.price &&
                isBought == p.isBought &&
                Objects.equals(companyName, p.companyName);
    }

    // prints out private company in text form
    @Override
    public String toString() {
        return "Private Company [" + companyName + "]";
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("privateCompanyName", companyName);
        json.put("price", price);
        json.put("isBought", isBought);
        return json;
    }

}
