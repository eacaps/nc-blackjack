package pub.eacaps.blackjack.game;

import pub.eacaps.blackjack.playing.Card;
import pub.eacaps.blackjack.playing.Hand;
import pub.eacaps.blackjack.playing.Rank;

public class BlackjackHand extends Hand {
    private int ace_count = 0;

    public BlackjackHand() {
        super();
    }

    @Override
    public void addCard(Card card) {
        Rank card_rank = card.getRank();
        if (Rank.ACE.equals(card_rank)) {
            ace_count++;
        }
        super.addCard(card);
    }

    public int getAceCount() {
        return ace_count;
    }
}
