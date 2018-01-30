package pub.eacaps.blackjack.playing;

import java.util.ArrayList;

public class Hand {
    protected ArrayList<Card> cards;

    public Hand() {
        this.cards = new ArrayList<Card>();
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public int handSize() {
        return cards.size();
    }

    public ArrayList<Card> getHand() {
        return cards;
    }

    @Override
    public String toString() {
        return "{ " + cards + " }";
    }
}
