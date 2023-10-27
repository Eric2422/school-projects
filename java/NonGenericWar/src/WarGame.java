import java.util.Scanner;

public class WarGame {
    // prints the deck sizes of the playe and computer
    public static void printDeckSizes(Deck player, Deck computer) {
        System.out.println("Deck Sizes");

        System.out.print("Player: " + player.size());
        System.out.println("      Comptuer: " + computer.size());
        System.out.println();
    }

    // plays one round of War
    public static void playRound() {
        Scanner input = new Scanner();

        printDeckSizes();
        
        // the user can press "Enter" to battle
        // or "s" (case-insensitive to shuffle their deck)
        String userAction = null;

        // while the player does not provide a valid option
        do {
            System.out.print("Press \"Enter\" to battle or \"S\" to shuffle: ");

            userAction = input.nextLine().strip().toLowerCase();

        } while (!userAction.equals("") || )
    }

    public static void main(String[] args) {
        // create a deck to split
        Deck computerDeck = new Deck();

        // fill the deck with the standard 52 cards
        deck.fill();

        // shuffle the deck the deck
        deck.shuffle();

        // create a player deck
        Deck playerDeck = new Deck();

        // give top half of computerDeck to player
        // computerDeck keeps the rest
        for (int i=0; i<mainDeck.size()/2; i++) {
            playerDeck.add(mainDeck.draw());
        }
        

    }
}