package pub.eacaps;

import pub.eacaps.blackjack.game.BlackjackEvaluation;
import pub.eacaps.blackjack.game.BlackjackHand;
import pub.eacaps.blackjack.game.BlackjackHandEvaluator;
import pub.eacaps.blackjack.game.HouseHand;
import pub.eacaps.blackjack.playing.StandardDeck;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        StandardDeck deck = new StandardDeck();
        deck.shuffle();
        BlackjackHand my_hand = new BlackjackHand();
        HouseHand house_hand = new HouseHand();
        my_hand.addCard(deck.dealCard());
        house_hand.addCard(deck.dealCard());
        my_hand.addCard(deck.dealCard());
        house_hand.addCard(deck.dealCard());
        System.out.println("you  have: " + my_hand.toString());
        System.out.println("house has: " + house_hand.toString());
        System.out.println("what do you want to do: [h]it or [s]tand?");
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        if ("s".equals(line)) {
            BlackjackEvaluation my_value = BlackjackHandEvaluator.evaluateHand(my_hand);
            BlackjackEvaluation house_value = BlackjackHandEvaluator.evaluateHand(house_hand);
            System.out.println("you  have: " + my_hand.toString());
            System.out.println("house has: " + house_hand.toFullString());
            System.out.println("your  result: " + my_value.getValue());
            System.out.println("house result: " + house_value.getValue());
            if (my_value.getValue() > house_value.getValue()) {
                System.out.println("you win!");
            } else if (my_value.getValue() < house_value.getValue()) {
                System.out.println("the house wins.");
            } else {
                System.out.println("its a tie");
            }
        }
    }


}
