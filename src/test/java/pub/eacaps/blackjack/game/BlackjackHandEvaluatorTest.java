package pub.eacaps.blackjack.game;

import org.junit.Test;
import pub.eacaps.blackjack.playing.Card;
import pub.eacaps.blackjack.playing.Hand;
import pub.eacaps.blackjack.playing.Rank;
import pub.eacaps.blackjack.playing.Suit;

import static org.junit.Assert.*;

public class BlackjackHandEvaluatorTest {

    @Test
    public void evaluateBlackJack() {
        Card jack_of_spades = new Card(Suit.SPADES, Rank.JACK);
        Card ace_of_hearts = new Card(Suit.HEARTS, Rank.ACE);
        BlackjackHand hand = new BlackjackHand();
        hand.addCard(jack_of_spades);
        hand.addCard(ace_of_hearts);
        BlackjackEvaluation eval = BlackjackHandEvaluator.evaluateHand(hand);
        assertEquals(eval.getValue(), 21);
        assertEquals(eval.isOver(), false);
        assertEquals(eval.isBlackjack(), true);
    }

    @Test
    public void evaluateTwentyOne() {
        Card jack_of_spades = new Card(Suit.SPADES, Rank.JACK);
        Card ace_of_hearts = new Card(Suit.HEARTS, Rank.ACE);
        BlackjackHand hand = new BlackjackHand();
        hand.addCard(jack_of_spades);
        hand.addCard(ace_of_hearts);
        BlackjackEvaluation eval = BlackjackHandEvaluator.evaluateHand(hand);
        assertEquals(eval.getValue(), 21);
        assertEquals(eval.isOver(), false);
        assertEquals(eval.isBlackjack(), true);
    }

    @Test
    public void evaluateSimpleBust() {
        Card jack_of_spades = new Card(Suit.SPADES, Rank.JACK);
        Card five_of_hearts = new Card(Suit.HEARTS, Rank.FIVE);
        Card six_of_hearts = new Card(Suit.HEARTS, Rank.SIX);
        BlackjackHand hand = new BlackjackHand();
        hand.addCard(jack_of_spades);
        hand.addCard(five_of_hearts);
        hand.addCard(six_of_hearts);
        BlackjackEvaluation eval = BlackjackHandEvaluator.evaluateHand(hand);
        assertEquals(eval.getValue(), 21);
        assertEquals(eval.isOver(), false);
        assertEquals(eval.isBlackjack(), false);
    }

    @Test
    public void evaluateAceLow() {
        Card jack_of_spades = new Card(Suit.SPADES, Rank.JACK);
        Card five_of_hearts = new Card(Suit.HEARTS, Rank.FIVE);
        Card ace_of_diamonds = new Card(Suit.DIAMONDS, Rank.ACE);
        BlackjackHand hand = new BlackjackHand();
        hand.addCard(jack_of_spades);
        hand.addCard(five_of_hearts);
        hand.addCard(ace_of_diamonds);
        BlackjackEvaluation eval = BlackjackHandEvaluator.evaluateHand(hand);
        assertEquals(eval.getValue(), 16);
        assertEquals(eval.isOver(), false);
        assertEquals(eval.isBlackjack(), false);
    }

    @Test
    public void evaluateAcesLow() {
        Card jack_of_spades = new Card(Suit.SPADES, Rank.JACK);
        Card five_of_hearts = new Card(Suit.HEARTS, Rank.FIVE);
        Card ace_of_hearts = new Card(Suit.HEARTS, Rank.ACE);
        Card ace_of_diamonds = new Card(Suit.DIAMONDS, Rank.ACE);
        BlackjackHand hand = new BlackjackHand();
        hand.addCard(jack_of_spades);
        hand.addCard(five_of_hearts);
        hand.addCard(ace_of_hearts);
        hand.addCard(ace_of_diamonds);
        BlackjackEvaluation eval = BlackjackHandEvaluator.evaluateHand(hand);
        assertEquals(eval.getValue(), 17);
        assertEquals(eval.isOver(), false);
        assertEquals(eval.isBlackjack(), false);
    }
}