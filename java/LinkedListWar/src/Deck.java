public class Deck {
    LinkedList<Card> cards;

    // constructor for an empty deck
    public Deck() {
        cards = new LinkedList<>();
    }

    // add card to end of cards(i.e. bottom of deck)
    public void add(Card x) {
        cards.add(x);
    }

    public Card draw() {
        return cards
    }
}