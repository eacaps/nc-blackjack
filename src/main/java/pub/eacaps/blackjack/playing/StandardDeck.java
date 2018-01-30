package pub.eacaps.blackjack.playing;

/**
 * A standard deck is 52 cards, 1 of each rank of each suit
 */
public class StandardDeck extends Deck {
    public StandardDeck() {
        super();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                this.cards.add(new Card(suit, rank));
            }
        }
    }
}
