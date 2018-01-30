package pub.eacaps.blackjack.game;

import pub.eacaps.blackjack.playing.Card;
import pub.eacaps.blackjack.playing.Hand;

import java.util.ArrayList;

/**
 * Simple static class for evaluating a single hand
 */
public class BlackjackHandEvaluator {
    public static BlackjackEvaluation evaluateHand(BlackjackHand hand) {
        ArrayList<Card> cards = hand.getHand();
        int hand_value = 0;
        // for each card, get the rank value
        for (Card card : cards) {
            int value = card.getRank().getValue();
            hand_value = hand_value + value;
        }
        // create evaluation object
        BlackjackEvaluation eval = new BlackjackEvaluation(hand_value, cards.size());
        int ace_count = hand.getAceCount();
        // handle cases where multiple aces may be low values
        if (eval.isOver() && ace_count > 0) {
            int low_aces = 0;
            // as long as we haven't gone over the ace count we can take away 10 if we are over
            while (low_aces <= ace_count && eval.isOver()) {
                int higher_value = eval.getValue();
                int new_value = higher_value - 10;
                eval = new BlackjackEvaluation(new_value, cards.size());
                low_aces++;
            }
        }
        return eval;
    }
}
