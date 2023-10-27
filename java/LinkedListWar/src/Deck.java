public class Deck {
    LinkedList<Card> cards;

    // constructor for an empty deck
    public Deck() {
        cards = new LinkedList<>();
    }

    // returns  a random integer from min to max(inclusive)
    public static int randInt(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    // add card to end of cards(i.e. bottom of deck)
    public void add(Card x) {
        cards.add(x);
    }

    // if the deck has at least one card,
    // remove the first card and return it
    // else, return null
    public Card draw() {
        return (cards.size() > 0) ? cards.remove(0) : null;
    }

    // fill the deck with a standard 52 set of cards
    public void fill() {
        // loop through the suit values
        for (int rank=0; rank<14; rank++) {
            for (int suit=2; suit<4; suit++) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    // return the size of cards
    public int size() {
        return cards.size();
    }

    // method to randomize the order of the cards in the deck
    public void shuffle() {
        // loop through the cards
        for (int i=0; i<cards.size(); i++) {
            // remove the card and reinsert it at a random index
            cards.add(
                randInt(0, cards.size() - 1),
                cards.remove(i)
            );
        }
    }

    // returns whether the deck is empty(i.e. when cards.size() == 0)
    public boolean isEmpty() {
        return cards.size() == 0;
    }
}