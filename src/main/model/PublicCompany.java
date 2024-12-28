package model;

import java.util.Objects;

import org.json.JSONObject;

import persistence.Writable;

public class PublicCompany extends Company implements Writable {

    int sharesLeft;

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
    public PublicCompany(String companyName, int price, int sharesLeft) {
        super(companyName, price);
        this.sharesLeft = sharesLeft;
    }

    public int getSharesLeft() {
        return sharesLeft;
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

        // Check if o is an instance of public company or not
        if (getClass() != o.getClass()) {
            return false;
        }

        // type casting o to public company to compare data members
        PublicCompany p = (PublicCompany) o;

        // this line is to comapre all the different instances of objects
        return price == p.price
                && sharesLeft == p.sharesLeft
                && Objects.equals(companyName, p.companyName);
    }

    // prints out public company in text form
    @Override
    public String toString() {
        return "Public Company [" + companyName + "]";
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("publicCompanyName", companyName);
        json.put("sharePrice", price);
        json.put("sharesLeft", sharesLeft);
        return json;
    }

}
