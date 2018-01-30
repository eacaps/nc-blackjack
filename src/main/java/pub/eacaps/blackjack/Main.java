package pub.eacaps.blackjack;

import pub.eacaps.blackjack.game.*;
import pub.eacaps.blackjack.playing.Card;
import pub.eacaps.blackjack.playing.Rank;
import pub.eacaps.blackjack.playing.StandardDeck;
import pub.eacaps.blackjack.playing.Suit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("welcome to nc-blackjack");
        int score = 0;
        StandardDeck deck = new StandardDeck();
        Scanner scan = new Scanner(System.in);
        boolean play = true;
        do {
            deck.shuffle();
            Round round = new Round(deck);
            BlackjackHand my_hand = new BlackjackHand();
            HouseHand house_hand = new HouseHand();
            round.dealStartingHand(my_hand);
            round.dealStartingHand(house_hand);
            System.out.println("you  have: " + my_hand.toString());
            System.out.println("house has: " + house_hand.toString());
            boolean over = false;
            int blackjack_score = round.checkForBlackjacks(house_hand, my_hand);
            if (blackjack_score != 0) {
                over = true;
                score += blackjack_score;
            }
            while (!over) {
                System.out.println("what do you want to do: [h]it or [s]tand?");
                String line = scan.nextLine();
                if ("s".equals(line)) {
                    score += round.evaluateResults(house_hand, my_hand);
                    over = true;
                } else if ("h".equals(line)) {
                    round.hitHand(my_hand);
                    BlackjackEvaluation my_value = round.evaluateHand(my_hand);
                    System.out.println("you  have: " + my_hand.toString());
                    int hand_score = round.continueRoundCheck(my_value);
                    if (hand_score < 0) {
                        score += hand_score;
                        over = true;
                        System.out.println("you busted");
                    } else {
                        System.out.println("your  result: " + my_value.getValue());
                    }
                }
            }
            System.out.println("play again: [y]es or [n]o?");
            String line = scan.nextLine();
            if ("n".equals(line)) {
                play = false;
            }
        } while (play);
        System.out.println("your score was: " + score);
        System.out.println("good bye.");
    }
}
