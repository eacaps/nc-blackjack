package pub.eacaps.blackjack.playing;

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
