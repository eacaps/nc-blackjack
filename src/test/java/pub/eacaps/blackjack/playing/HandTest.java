package pub.eacaps.blackjack.playing;

import org.junit.Test;

import static org.junit.Assert.*;

public class HandTest {

    @Test
    public void testHand() {
        Hand hand = new Hand();
        assertEquals(hand.handSize(), 0);
        Card ace_of_diamonds = new Card(Suit.DIAMONDS, Rank.ACE);
        hand.addCard(ace_of_diamonds);
        assertEquals(hand.handSize(), 1);
        Card five_of_diamonds = new Card(Suit.DIAMONDS, Rank.FIVE);
        hand.addCard(five_of_diamonds);
        assertEquals(hand.handSize(), 2);
        assertEquals("[" + ace_of_diamonds.toString() + ", " + five_of_diamonds.toString() + "]", hand.toString());
    }
}