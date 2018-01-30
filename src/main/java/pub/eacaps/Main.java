package pub.eacaps;

import pub.eacaps.blackjack.game.*;
import pub.eacaps.blackjack.playing.StandardDeck;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
            if(round.checkForBlackjacks(house_hand, my_hand) != 0) {
                over = true;
            }
            while (!over) {
                System.out.println("what do you want to do: [h]it or [s]tand?");
                String line = scan.nextLine();
                if ("s".equals(line)) {
                    round.evaluateResults(house_hand, my_hand);
                    over = true;
                } else if ("h".equals(line)) {
                    round.hitHand(my_hand);
                    BlackjackEvaluation my_value = round.evaluateHand(my_hand);
                    System.out.println("you  have: " + my_hand.toString());
                    if (round.evaluateHand(my_hand).isOver()) {
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
    }
}
