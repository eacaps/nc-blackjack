package pub.eacaps.blackjack.game;

import org.junit.Test;
import pub.eacaps.blackjack.playing.Card;
import pub.eacaps.blackjack.playing.Rank;
import pub.eacaps.blackjack.playing.Suit;

import static org.junit.Assert.*;

public class BlackjackHandTest {
    @Test
    public void testAddAce() {
        BlackjackHand hand = new BlackjackHand();
        hand.addCard(new Card(Suit.HEARTS, Rank.ACE));
        hand.addCard(new Card(Suit.CLUBS, Rank.ACE));
        hand.addCard(new Card(Suit.HEARTS, Rank.TWO));
        assertEquals(hand.getAceCount(), 2);
        assertEquals(hand.handSize(), 3);
    }

    @Test
    public void testAddTen() {
        BlackjackHand hand = new BlackjackHand();
        hand.addCard(new Card(Suit.HEARTS, Rank.TEN));
        assertEquals(hand.getAceCount(), 0);
        assertEquals(hand.handSize(), 1);
    }
}