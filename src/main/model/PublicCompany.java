package model;

import java.util.Objects;

public class PublicCompany {

    String companyName;
    int sharePrice;
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
    public PublicCompany(String companyName, int sharePrice, int sharesLeft) {
        this.companyName = companyName;
        this.sharePrice = sharePrice;
        this.sharesLeft = sharesLeft;
    }

    public int getSharePrice() {
        return sharePrice;
    }

    public int getSharesLeft() {
        return sharesLeft;
    }

    public String getName() {
        return companyName;
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
        return 
        sharePrice == p.sharePrice &&
        sharesLeft == p.sharesLeft &&
        Objects.equals(companyName, p.companyName);
    }


    // prints out public company in text form
    @Override
    public String toString() {
        return "Public Company [" + companyName + "]";
    }

}
