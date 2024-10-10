package model;

public class PrivateCompany {

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

}
