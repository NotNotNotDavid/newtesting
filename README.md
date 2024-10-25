# David Huang's Personal Project

## General Overview:

This project will be planned around a board game, *Shikoku 1889*.

*Shikoku 1889* is a game comprised with heavy amounts of financial transactions, that is often annoying to handle physically.

The intended use of this application is to handle and record the cumbersome transactions that occur within the game. Players can view the history of all the transactions in the game at any time. 

It is inteded to be used on the side by people who are playing *Shikoku 1889*, making the application run simultaneously to what is occuring on the board.


## User Stories:

- As a user, I want to be able to add a player, who can buy and sell a public company at its stock price, or a private company.
- As a user, I want to view the total amount of money left in the game.
- As a user, I want to see how many shares of a public company has left (out of 10) and their stock price.
- As a user, I want to see which private company each player owns. 
- As a user, I want to see which public company each player owns. 
- As a user, I want to see the value of shares for each company.
- As a user, I want to be able to add each transaction (buying and selling shares and private companies) into a transaction log.
- As a user, I want to be able to view the transaction log for each player.
- As a user, I want to remove a certain tranaction from a transaction log.
- As a user, I want to see the statistics on how popularly traded a certain public company is.
- As a user, I want to be able to save some stuff in my ledger.
- As a user, I want to be able to load my saved ledgers from file.

## DISCLAMER AND SOURCES

For the persistence package, the implementation and structure is heavily inspired by the JsonSerializationDemo:
It is denoted with this note on the top of the classes:
// Referenced from the JsonSerialization Demo
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

In the Transaction class, equals() is Overrided. In order to achieve the desired outcome, some sources were used to help me implement this method.

Here are them below:

https://www.geeksforgeeks.org/overriding-equals-method-in-java/
https://stackoverflow.com/questions/8180430/how-to-override-equals-method-in-java

These two links helped me in trying to understand what Overriding is.

https://www.javatpoint.com/override-equals-method-in-java

This link helped me in figuring out what to return.








