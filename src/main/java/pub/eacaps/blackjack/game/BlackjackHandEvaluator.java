package pub.eacaps.blackjack.game;

import pub.eacaps.blackjack.playing.Card;
import pub.eacaps.blackjack.playing.Hand;

import java.util.ArrayList;

public class BlackjackHandEvaluator {
    public static BlackjackEvaluation evaluateHand(BlackjackHand hand) {
        ArrayList<Card> cards = hand.getHand();
        int hand_value = 0;
        for(Card card:cards) {
            int value = card.getRank().getValue();
            hand_value = hand_value + value;
        }
        BlackjackEvaluation eval = new BlackjackEvaluation(hand_value, cards.size());
        int ace_count = hand.getAceCount();
        if(eval.isOver() && ace_count > 0) {
            int low_aces = 0;
            while(low_aces <= ace_count && eval.isOver()) {
                int higher_value = eval.getValue();
                int new_value = higher_value - 10;
                eval = new BlackjackEvaluation(new_value, cards.size());
                ace_count++;
            }
        }
        return eval;
    }
}
