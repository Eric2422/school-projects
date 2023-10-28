import java.util.Scanner;

public class WarGame {
    // prints the deck sizes of the player and computer
    public static void printDeckSizes(Deck playerDeck, Deck computerDeck) {
        System.out.println("Deck Sizes");

        System.out.print("Player: " + playerDeck.size());
        System.out.println("      Computer: " + computerDeck.size());
        System.out.println();
    }
    
    // print the card drawn
    public static void printDrawnCard(String player, Card card) {
        // print out the card
        System.out.print(player + " drew ");
        // account for vowels
        System.out.print(
                (card.toString().substring(0, 1).equals("8")
                        || card.toString().substring(0, 1).equals("a"))
                                ? "an "
                                : "a ");

        System.out.println(card);
    }

    /*
     * takes player's card and computer's card 
     * as well as a deck of cards being contested
     * compare player and computer decks
     * Give the cards to the winner
     */
    public static void compareCards(Deck playerDeck, Deck computerDeck, Card playerCard, Card computerCard, Deck playedCards) {
        // compare the cards
        // if player wins
        // the player takes the cards
        if (playerCard.compareRank(computerCard) > 0) {
            System.out.println("Player won " + playedCards.size()/2 + " cards!");

            while (!playedCards.isEmpty()) {
                playerDeck.add(playedCards.draw());
            }

        } else if (playerCard.compareRank(computerCard) == 0) { // if the cards are equal
            // declare war
            System.out.println("\nI declare War!");
            battle(playedCards, playerDeck, computerDeck);

        } else { // if computer wins
            // the computer takes the cards
            System.out.println("Computer won " + playedCards.size()/2 + " cards!");

            while (!playedCards.isEmpty()) {
                computerDeck.add(playedCards.draw());
            }
        }
        
        System.out.println();
    }

    /* player and computer compare cards and go to war if equal
     * take three decks:
     * one to represent played cards
     * one to represent player,
     * one to represent computer
     */
    public static void battle(Deck playedCards, Deck playerDeck, Deck computerDeck) {
         // if it is not empty
        // it's a war
        boolean isWar = !playedCards.isEmpty();

        
        if (isWar) {
            // if playerDeck has less than three cards
            // computer wins
            if (playerDeck.size() < 3) {
                System.out.println("\nPlayer had insufficient cards for war.");
                return;
            } 

            // if computer has less than three cards
            // player wins
            if (computerDeck.size() < 3) { 
                System.out.println("\nComputer had insufficient cards for war.");
                return;
            }
        }   

        // draw a card from playerDeck
        Card playerCard = playerDeck.draw();
        playedCards.add(playerCard);

        // draw another two if it's war 
        if (isWar) {
            System.out.println("\nPlayer lays down three cards.");

            for (int i=0; i<2; i++) {
                playerCard = playerDeck.draw();
                playedCards.add(playerCard);
            }
        }

        printDrawnCard("Player", playerCard);

        // draw a card from computerDeck
        Card computerCard = computerDeck.draw();
        playedCards.add(computerCard);

        // draw another two if it's war 
        if (isWar) {
            System.out.println("\nComputer lays down three cards.");

            for (int i=0; i<2; i++) {
                computerCard = computerDeck.draw();
                playedCards.add(computerCard);
            }
        }

        printDrawnCard("Computer", computerCard);

        compareCards(playerDeck, computerDeck, playerCard, computerCard, playedCards);
    }

    // plays one round of War
    public static void playRound(Deck playerDeck, Deck computerDeck) {
        Scanner input = new Scanner(System.in);

        printDeckSizes(playerDeck, computerDeck);
        
        // the user can press "Enter" to battle
        // or "s" (case-insensitive to shuffle their deck)
        String userAction = null;

        // until the player provides a valid option("" or "s")
        do {
            // prompt the user for an action
            System.out.print("Press \"Enter\" to battle or \"S\" to shuffle: ");

            userAction = input.nextLine().strip().toLowerCase();

        } while (!(userAction.equals("") || userAction.equals("s")));

        System.out.println();

        // fight a battle or shuffle based on user's input
        switch (userAction) {
            case "":
                // cards being played and contested
                Deck playedCards = new Deck();

                battle(playedCards, playerDeck, computerDeck);
                break;

            case "s":
                System.out.println("You shuffle your deck.");
                playerDeck.shuffle();
        }

        // if player runs out of cards
        // computer wins
        if (playerDeck.isEmpty()) { 
            System.out.println("Computer wins the war!");
            return;
        } 
        
        // if computer runs out of cards
        // player wins
        if (computerDeck.isEmpty()) { 
            System.out.println("Player wins the war!");
            return;
        }

        // if neither player is out of cards
        // play another round
        playRound(playerDeck, computerDeck);
    }

    public static void main(String[] args) {
        // create a deck to split
        Deck computerDeck = new Deck();

        // fill the deck with the standard 52 cards
        computerDeck.fill();

        // shuffle the deck the deck
        computerDeck.shuffle();

        // create a player deck
        Deck playerDeck = new Deck();

        for (int i = 0; i < computerDeck.size(); i++) {
            computerDeck.draw();
        }

        for (int i = 0; i < computerDeck.size(); i++) {
            computerDeck.draw();
        }

        // give top half of computerDeck to player
        // computerDeck keeps the rest
        for (int i = 0; i < computerDeck.size(); i++) {
            playerDeck.add(computerDeck.draw());
        }

        playRound(playerDeck, computerDeck);
    }
}