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
    */
    public PublicCompany(String companyName, int price, int sharesLeft){
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

    //EFFECTS: returns the company name
    public String getName(){
        return "";
    }


 
}
