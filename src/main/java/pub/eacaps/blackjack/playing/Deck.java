package pub.eacaps.blackjack.playing;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A deck is a bunch of cards that can be shuffled and dealt
 */
abstract public class Deck {
    protected ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card dealCard() {
        if (cards.size() <= 0) {
            this.shuffle();
        }
        return cards.remove(0);
    }

    public int cardsRemaining() {
        return cards.size();
    }
}
