// package persistence;

// import model.Game;
// import model.Player;
// import model.PrivateCompany;
// import model.PublicCompany;
// import model.Transactions;
// import java.util.ArrayList;

// import static org.junit.Assert.assertThat;
// import static org.junit.jupiter.api.Assertions.assertEquals;

// public class JsonTest {
//     protected void checkGame(Game game) {

//         ArrayList<Player> listOfPlayers = game.getListOfPlayers();
//         ArrayList<PrivateCompany> listOfPrivateCompanies = game.getListofPrivateCompanies();
//         ArrayList<PublicCompany> listOfPublicCompanies = game.getListofPublicCompanies();

//         checkGamePrivateCompanies(listOfPrivateCompanies);
//         checkGamePublicCompanies(listOfPublicCompanies);
//         checkPlayers(listOfPlayers);

//     }

//     protected void checkGamePrivateCompanies(ArrayList <PrivateCompany> listOfPrivateCompanies){
//         for (PrivateCompany p : listOfPrivateCompanies){
//             checkPrivateCompany(p);
//         }
//     }

//     protected void checkPrivateCompany(PrivateCompany privateCompany){
//         assertEquals(???, privateCompany.getName());
//         assertEquals(???, privateCompany.getPrice());
//         assertEquals(???, privateCompany.isBought());
//     }

//     protected void checkGamePublicCompanies(ArrayList <PublicCompany> listOfPublicCompanies){
//         for (PublicCompany p : listOfPublicCompanies){
//             checkPublicCompany(p);
//         }
//     }

//     protected void checkPublicCompany(PublicCompany publicCompany){
//         assertEquals(???, publicCompany.getName());
//         assertEquals(???, publicCompany.getPrice());
//         assertEquals(???, publicCompany.sharesLeft);
//     }

//     protected void checkPlayers(ArrayList<Player> listOfPlayers){
//         for (Player p : listOfPlayers){
//             checkSinglePlayer(p);
//         }
//     }

//     protected void checkSinglePlayer(Player p){
//         assertEquals(???, p.getBalance());
//         assertEquals(???, p.getName());
//         checkTransactions(p.getTransactions());
//         checkPlayerPublicHolding(p.getPublicCompanies());
//         checkPlayerPrivateHolding(p.getPrivateCompanies());
//     }


//     protected void checkTransactions(ArrayList<Transactions> transactionsList){
//         for (Transactions t: transactionsList){
//             checkSingleTransaction(t);
//         }
//     }

//     protected void checkSingleTransaction(Transactions t){
//         assertEquals(???, t.getCompanyName());
//         assertEquals(???, t.getPlayerName());
//         assertEquals(???, t.getPrice());
//         assertEquals(???, t.getAction());
//     }

//     protected void checkPlayerPublicHolding(ArrayList<PublicCompany> publicCompaniesOwnership){
//         for (PublicCompany publicCompany : publicCompaniesOwnership){
//             checkPublicCompany(publicCompany);
//         }
//     }

//     protected void checkPlayerPrivateHolding(ArrayList<PrivateCompany> privateCompaniesOwnership){
//         for (PrivateCompany publicCompany : privateCompaniesOwnership){
//             checkPrivateCompany(publicCompany);
//         }
//     }

// }


// // ArrayList<PublicCompany> listOfPublicCompany) {

// //    assertEquals(listOfPlayer, game.getListOfPlayers());
// //    assertEquals(listOfPrivateCompany, game.getListofPrivateCompanies());
// //    assertEquals(listOfPublicCompany, game.getListofPublicCompanies());

// /*
//  *  Game {
//  *          
//  *          public compnay{
//  *          
//  *          }
//  * 
//  *          private compnay{
//  *          
//  *          }
//  * 
//  *        Player1 {
//  *                  PublicCompanyOwnership{
//                                     ... int sharePrice
//                                         string Name
//                                         int sharesLeft
//  *                              }
//  * 
//  *                  PrivateCompanyOwnership{
//  *                                  ... int price
//  *                                      String Name
//  *                                      boolean isBought
//  *                              }
//  * 
//  *                  Transactions{
//  *                                  ... toString
//  *                              }
//  *              }
//  * 
//  *        Player2 {
//  * 
//  *                  ...
//  *              }
//  * 
//  *      }
//  * 
//  * 
//  * 
//  */