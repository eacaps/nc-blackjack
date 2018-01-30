package pub.eacaps.blackjack.game;

import pub.eacaps.blackjack.playing.Deck;
import pub.eacaps.blackjack.playing.Hand;

public class Round {
    private Deck deck;

    public Round(Deck deck) {
        this.deck = deck;
    }

    public void dealStartingHand(Hand hand) {
        hand.addCard(this.deck.dealCard());
        hand.addCard(this.deck.dealCard());
    }

    public void hitHand(Hand hand) {
        hand.addCard(deck.dealCard());
    }

    public BlackjackEvaluation evaluateHand(BlackjackHand hand) {
        BlackjackEvaluation value = BlackjackHandEvaluator.evaluateHand(hand);
        return value;
    }

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
    }
}
