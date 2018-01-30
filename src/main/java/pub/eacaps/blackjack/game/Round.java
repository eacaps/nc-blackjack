package pub.eacaps.blackjack.game;

import pub.eacaps.blackjack.playing.Deck;
import pub.eacaps.blackjack.playing.Hand;

/**
 * This class is used to process a whole round of blackjack, handling blackjack checking as well as house rules.
 */
public class Round {
    private Deck deck;

    public Round(Deck deck) {
        this.deck = deck;
    }

    /**
     * Add two starting cards to a hand
     *
     * @param hand
     */
    public void dealStartingHand(Hand hand) {
        hand.addCard(this.deck.dealCard());
        hand.addCard(this.deck.dealCard());
    }

    /**
     * Add another card to a hand
     *
     * @param hand
     */
    public void hitHand(Hand hand) {
        hand.addCard(deck.dealCard());
    }

    /**
     * Check this hand for valuation
     *
     * @param hand
     * @return evaluated hand state
     */
    public BlackjackEvaluation evaluateHand(BlackjackHand hand) {
        BlackjackEvaluation value = BlackjackHandEvaluator.evaluateHand(hand);
        return value;
    }

    /**
     * Check to see if this value means the hand is done
     *
     * @param value
     * @return 0 if we can continue, -1 if busted
     */
    public int continueRoundCheck(BlackjackEvaluation value) {
        int score = 0;
        if (value.isOver()) {
            score = -1;
        }
        return score;
    }

    /**
     * Handle house logic of hitting on anything lower than 17
     *
     * @param house_hand
     * @return evaluation of house_hand
     */
    public BlackjackEvaluation processHouseHand(HouseHand house_hand) {
        System.out.println("house has: " + house_hand.toFullString());
        BlackjackEvaluation house_value = BlackjackHandEvaluator.evaluateHand(house_hand);
        while (house_value.getValue() < 17) {
            this.hitHand(house_hand);
            house_value = this.evaluateHand(house_hand);
            System.out.println("house has: " + house_hand.toFullString());
        }
        return house_value;
    }

    /**
     * Initial check to handle blackjacks for both hands
     *
     * @param house_hand
     * @param my_hand
     * @return 1 for user win, 0 for tie, -1 for loss
     */
    public int checkForBlackjacks(BlackjackHand house_hand, BlackjackHand my_hand) {
        int score = 0;
        BlackjackEvaluation house_value = BlackjackHandEvaluator.evaluateHand(house_hand);
        BlackjackEvaluation my_value = BlackjackHandEvaluator.evaluateHand(my_hand);
        if (house_value.isBlackjack() && my_value.isBlackjack()) {
            System.out.println("blackjack tie!");
        } else if (house_value.isBlackjack()) {
            System.out.println("house has blackjack");
            score = -1;
        } else if (my_value.isBlackjack()) {
            System.out.println("you have blackjack");
            score = 1;
        }
        return score;
    }

    /**
     * Evaluates the hands and determines win state
     *
     * @param house_hand
     * @param my_hand
     * @return 1 for user win, 0 for tie, -1 for loss
     */
    public int evaluateResults(HouseHand house_hand, BlackjackHand my_hand) {
        int score = 0;
        BlackjackEvaluation house_value = this.processHouseHand(house_hand);
        BlackjackEvaluation my_value = BlackjackHandEvaluator.evaluateHand(my_hand);
        if (my_value.isOver()) {
            System.out.println("you busted.");
            score = -1;
        } else if (house_value.isOver()) {
            System.out.println("house busted!");
            score = 1;
        } else {
            System.out.println("house result: " + house_value.getValue());
            System.out.println("you  have: " + my_hand.toString());
            System.out.println("your  result: " + my_value.getValue());
            if (my_value.getValue() > house_value.getValue()) {
                System.out.println("you win!");
                score = 1;
            } else if (my_value.getValue() < house_value.getValue()) {
                System.out.println("the house wins.");
                score = -1;
            } else {
                System.out.println("its a tie");
                score = 0;
            }
        }
        return score;
    }
}
