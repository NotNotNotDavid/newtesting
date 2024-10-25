package persistence;

import model.Game;
import model.Player;
import model.PrivateCompany;
import model.PublicCompany;
import model.Transactions;
import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkGame(Game game) {

        ArrayList<Player> listOfPlayers = game.getListOfPlayers();
        ArrayList<PrivateCompany> listOfPrivateCompanies = game.getListofPrivateCompanies();
        ArrayList<PublicCompany> listOfPublicCompanies = game.getListofPublicCompanies();

    }

    protected void checkPrivateCompanyHoldings(Player player){

    }

    protected void checkPlayers(ArrayList<Player> listOfPlayers){
        for (Player p : listOfPlayers){
            assertEquals("", p.getName());
            assertEquals("", p.getBalance());
            assertEquals("", p.getPrivateCompanies());
        }
    }
}

// protected void checkGame(Game game, ArrayList<Player> listOfPlayer, ArrayList<PrivateCompany> listOfPrivateCompany,
// ArrayList<PublicCompany> listOfPublicCompany) {

//    assertEquals(listOfPlayer, game.getListOfPlayers());
//    assertEquals(listOfPrivateCompany, game.getListofPrivateCompanies());
//    assertEquals(listOfPublicCompany, game.getListofPublicCompanies());

/*
 *  Game {
 *          
 *          public compnay{
 *          
 *          }
 * 
 *          private compnay{
 *          
 *          }
 * 
 *        Player1 {
 *                  PublicCompanyOwnership{
                                    ... int sharePrice
                                        string Name
                                        int sharesLeft
 *                              }
 * 
 *                  PrivateCompanyOwnership{
 *                                  ... int price
 *                                      String Name
 *                                      boolean isBought
 *                              }
 * 
 *                  Transactions{
 *                                  ... toString
 *                              }
 *              }
 * 
 *        Player2 {
 * 
 *                  ...
 *              }
 * 
 *      }
 * 
 * 
 * 
 */