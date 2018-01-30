package pub.eacaps.blackjack.game;

import org.junit.Test;
import pub.eacaps.blackjack.playing.Card;
import pub.eacaps.blackjack.playing.Hand;
import pub.eacaps.blackjack.playing.Rank;
import pub.eacaps.blackjack.playing.Suit;

import static org.junit.Assert.*;

public class HandEvaluatorTest {

    @Test
    public void evaluateBlackJack() {
        Card jack_of_spades = new Card(Suit.SPADES, Rank.JACK);
        Card ace_of_hearts = new Card(Suit.HEARTS, Rank.ACE);
        Hand hand = new Hand();
        hand.addCard(jack_of_spades);
        hand.addCard(ace_of_hearts);
        HandEvaluation eval = HandEvaluator.evaluateHand(hand);
        assertEquals(eval.getValue(), 21);
        assertEquals(eval.isOver(), false);
    }

    @Test
    public void evaluateSimpleBust() {
        Card jack_of_spades = new Card(Suit.SPADES, Rank.JACK);
        Card jack_of_hearts = new Card(Suit.HEARTS, Rank.JACK);
        Card jack_of_diamonds = new Card(Suit.DIAMONDS, Rank.JACK);
        Hand hand = new Hand();
        hand.addCard(jack_of_spades);
        hand.addCard(jack_of_hearts);
        hand.addCard(jack_of_diamonds);
        HandEvaluation eval = HandEvaluator.evaluateHand(hand);
        assertEquals(eval.getValue(), 30);
        assertEquals(eval.isOver(), true);
    }
}