package pub.eacaps.blackjack.game;

import pub.eacaps.blackjack.playing.Card;
import pub.eacaps.blackjack.playing.Hand;
import pub.eacaps.blackjack.playing.Rank;

/**
 * BlackjackHand needs to keep track of ace count to simplify scoring
 */
public class BlackjackHand extends Hand {
    private int ace_count = 0;

    public BlackjackHand() {
        super();
    }

    /**
     * Override to keep track of aces for handling low ace scoring
     *
     * @param card - card to add
     */
    @Override
    public void addCard(Card card) {
        Rank card_rank = card.getRank();
        if (Rank.ACE.equals(card_rank)) {
            ace_count++;
        }
        super.addCard(card);
    }

    /**
     * @return number of aces in this hand
     */
    public int getAceCount() {
        return ace_count;
    }
}
