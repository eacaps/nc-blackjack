package pub.eacaps.blackjack.game;

import pub.eacaps.blackjack.playing.Card;

public class HouseHand extends BlackjackHand {
    public HouseHand() {
        super();
    }

    @Override
    public String toString() {
        String value = "{ }";
        if (this.cards.size() > 0) {
            value = "[" + this.cards.get(0);
            for (int x = 1; x < this.cards.size(); x++) {
                Card card = this.cards.get(x);
                value += ", [??]";
            }
            value += "]";
        }
        return value;
    }

    public String toFullString() {
        return super.toString();
    }
}
