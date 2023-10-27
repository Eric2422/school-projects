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
        for (int rank=2; rank<=14; rank++) {
            for (int suit=0; suit<4; suit++) {
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
            // generate a random index in cards
            int random = randInt(0, cards.size() - 1);

            // swap the data contained within the nodes
            Card temp = cards.get(i);
            
            cards.set(i, cards.get(random));
            cards.set(random, temp);
        }
    }

    // returns whether the deck is empty(i.e. when cards.size() == 0)
    public boolean isEmpty() {
        return cards.size() == 0;
    }

    public static void main(String[] args) {
        Deck deck = new Deck();

        deck.fill();
        deck.add(new Card(Card.ACE, Card.SPADES)); // add a duplicate ace of spades as the last card

        for (int i=0; i<3; i++) {
            deck.shuffle();
        }

        while(!deck.isEmpty()) {            
            System.out.println(deck.draw());
        }
    }
}