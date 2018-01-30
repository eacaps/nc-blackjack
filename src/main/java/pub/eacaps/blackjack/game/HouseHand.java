package pub.eacaps.blackjack.game;

import pub.eacaps.blackjack.playing.Card;

/**
 * HouseHand hides what the house has for display
 */
public class HouseHand extends BlackjackHand {
    public HouseHand() {
        super();
    }

    /**
     * @return String that only shows the first card for a househand
     */
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

    /**
     * @return String of the full revealed hand
     */
    public String toFullString() {
        return super.toString();
    }
}
