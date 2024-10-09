package model;

public class PublicCompany {

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
    * the floatation of the company is set to isFloated;
    */


    public PublicCompany(String companyName, int price, int sharesLeft, boolean isFloated){
        //stub
    }
 
 
 
 
    //MODIFIES: this
    //EFFECTS: buys one share of the specified public company, company sharesBought++, company sharesLeft--
    public void buyPublicCompany(PublicCompany company){
        //stub
    }
 
 
    //MODIFIES: this
    //EFFECTS: sells one share of the specified public company, company sharesBought--, company sharesLeft++
    public void sellPublicCompany(PublicCompany company){
        //stub
    }
 
 
 
 
    //MODIFIES: this
    //EFFECTS: returns the share price of the given company
    public int getSharePrice(String companyName){
        return 0; //stub
    }
 
 
    //MODIFIES: this
    //EFFECTS: returns the number of remaining shares of the given company
    public int getSharesLeft(String companyName){
        return 0; //stub
    }
 
 
    //MODIFIES: this
    //EFFECTS: returns whether the company is floated or not
    public boolean getFloatStatus(String companyName){
        return false; //stub
    }
 
}
