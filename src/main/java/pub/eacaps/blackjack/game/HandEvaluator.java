package pub.eacaps.blackjack.game;

import pub.eacaps.blackjack.playing.Card;
import pub.eacaps.blackjack.playing.Hand;

import java.util.ArrayList;

public class HandEvaluator {
    public static HandEvaluation evaluateHand(Hand hand) {
        ArrayList<Card> cards = hand.getHand();
        int hand_value = 0;
        for(Card card:cards) {
            int value = card.getRank().getValue();
            hand_value = hand_value + value;
        }
        HandEvaluation eval = new HandEvaluation(hand_value);
        return eval;
    }
}
