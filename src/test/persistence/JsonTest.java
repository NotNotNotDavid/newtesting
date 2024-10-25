package persistence;

import model.Game;
import model.Player;
import model.PrivateCompany;
import model.PublicCompany;
import model.Transactions;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkGame(Game game, Player player, PrivateCompany privateCompany, PublicCompany
    publicCompany, Transactions transactions) {

        assertEquals(player, game.getListOfPlayers());
        assertEquals(privateCompany, game.getListofPrivateCompanies());
        assertEquals(player, game.getListofPublicCompanies());
        assertEquals(transactions, player.getTransactions());

    }
}


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