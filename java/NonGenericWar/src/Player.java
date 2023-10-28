public class Player {
    // the name of the player
    private String name;

    // the cards in the players hand. Represented by a deck
    private Deck hand;

    public Player(String name, Deck hand) {
        this.name = name;
        this.hand = hand;
    }

    // get the name of the player
    public String getName() {
        return name;
    }

    // set the player's name
    public void setName(String name) {
        this.name = name;
    }

    // get the player's hand
    public Deck getHand() {
        return hand;
    }

    // assign the player to a new hand
    public void setHand(Deck hand) {
        this.hand = hand;
    }
}