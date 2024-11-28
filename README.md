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

## Instructions for End User:

- You can add a new player into the game by pressing the "add new player" button and input their name and their starting balance
- You can then view the player, by clicking on their name in the combo box, and seeing if that is the correct player displayed on the text area
- You can then view their transactions, balances, ownership of both private and public companies, and buy and sell their private or public companies
- Buying or selling a company requires the name of the company to be inputted.
- You can locate the visual component by opening the application, where the splash screen will pop up.
- You can save the state of my application by pressing the save button
- You can reload the state of my application by pressing the load button.

## Phase 4: Task 2 (An example of what events that occur in the program)


    Wed Nov 27 21:59:10 PST 2024
    Added player: Linear A. Isassa with $2000


    Wed Nov 27 21:59:14 PST 2024
    Player: Linear A. Isassa accessed their transactions: []


    Wed Nov 27 21:59:19 PST 2024
    Player: Linear A. Isassa bought public company: Public Company [Tosa Rail]


    Wed Nov 27 21:59:27 PST 2024
    Player: Linear A. Isassa bought private company: Private Company [Dogo Rail]


    Wed Nov 27 21:59:33 PST 2024
    Player: Linear A. Isassa sold public company: Public Company [Tosa Rail]


    Wed Nov 27 21:59:35 PST 2024
    Player: Linear A. Isassa accessed their transactions: [Transaction[Player: Linear A. Isassa, Price: 100, Company: Tosa Rail, Action: buy], Transaction[Player: Linear A. Isassa, Price: 60, Company: Dogo Rail, Action: buy], Transaction[Player: Linear A. Isassa, Price: 100, Company: Tosa Rail, Action: sell]]


    Wed Nov 27 22:00:36 PST 2024
    Added player: Evan T. Rally with $8888


    Wed Nov 27 22:00:46 PST 2024
    Player: Evan T. Rally bought public company: Public Company [Tosa Rail]


    Wed Nov 27 22:00:52 PST 2024
    Player: Evan T. Rally accessed their transactions: [Transaction[Player: Evan T. Rally, Price: 100, Company: Tosa Rail, Action: buy]]

## Phase 4, Task 3 (Refactoring)

After drawing out the UML diagram for my project, I noticed that there was alot... of coupling. A way to reduce this is to first remove the arrow from LedgerAppGUI to player, since game already has player and does not need an arrow to it. In hindsight, I added it stright from my LedgerApp and did not think too much about the design. Another thing I would refactor is making PrivateCompany and PublicCompany into one abstract Company class. Since both of these classes have very similar methods and implementation. They can easily be refactored into one abstract class. These are the most obvious things I would refactor, and I do not see the potential in any design patterns yet. 

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

https://docs.oracle.com/javase/tutorial/uiswing/components/frame.html

for frames

https://docs.oracle.com/javase/tutorial/uiswing/components/combobox.html

for combo box

https://docs.oracle.com/javase/tutorial/uiswing/layout/grid.html

for gridlayouts

https://www.geeksforgeeks.org/java-swing-jwindow-examples/
https://stackoverflow.com/questions/16134549/how-to-make-a-splash-screen-for-gui
https://docs.oracle.com/javase/tutorial/uiswing/misc/timer.html

for JWindow and Splashscreen + timer for splash





