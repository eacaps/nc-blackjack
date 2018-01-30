package pub.eacaps.blackjack.game;

import org.junit.Before;
import org.junit.Test;
import pub.eacaps.blackjack.playing.*;

import static org.junit.Assert.*;

public class RoundTest {
    private Round round;
    private Deck deck = new StandardDeck();

    @Before
    public void setUp() throws Exception {
        deck.shuffle();
        round = new Round(deck);
    }

    @Test
    public void testStart() {
        BlackjackHand hand = new BlackjackHand();
        round.dealStartingHand(hand);
        assertEquals(hand.handSize(), 2);
    }

    @Test
    public void testHit() {
        BlackjackHand hand = new BlackjackHand();
        round.dealStartingHand(hand);
        assertEquals(hand.handSize(), 2);
        round.hitHand(hand);
        assertEquals(hand.handSize(), 3);
    }

    @Test
    public void testContinue() {
        BlackjackHand hand = new BlackjackHand();
        hand.addCard(new Card(Suit.SPADES, Rank.FIVE));
        hand.addCard(new Card(Suit.SPADES, Rank.TEN));
        assertEquals(round.continueRoundCheck(round.evaluateHand(hand)), 0);
        hand.addCard(new Card(Suit.SPADES, Rank.JACK));
        assertEquals(round.continueRoundCheck(round.evaluateHand(hand)), -1);
    }

    @Test
    public void testBoringHouseHand() {
        HouseHand house_hand = new HouseHand();
        house_hand.addCard(new Card(Suit.SPADES, Rank.QUEEN));
        house_hand.addCard(new Card(Suit.CLUBS, Rank.QUEEN));
        BlackjackEvaluation eval = round.processHouseHand(house_hand);
        assertTrue(eval.getValue() > 17);
    }

    @Test
    public void testLowHouseHand() {
        HouseHand house_hand = new HouseHand();
        house_hand.addCard(new Card(Suit.SPADES, Rank.TWO));
        house_hand.addCard(new Card(Suit.CLUBS, Rank.TWO));
        BlackjackEvaluation eval = round.processHouseHand(house_hand);
        assertTrue(eval.getValue() > 17);
    }

    @Test
    public void testNoBlackjacks() {
        HouseHand house_hand = new HouseHand();
        house_hand.addCard(new Card(Suit.SPADES, Rank.TWO));
        house_hand.addCard(new Card(Suit.CLUBS, Rank.TWO));
        BlackjackHand hand = new BlackjackHand();
        hand.addCard(new Card(Suit.SPADES, Rank.THREE));
        hand.addCard(new Card(Suit.CLUBS, Rank.THREE));
        assertEquals(round.checkForBlackjacks(house_hand, hand), 0);
    }

    @Test
    public void testHouseBlackjack() {
        HouseHand house_hand = new HouseHand();
        house_hand.addCard(new Card(Suit.SPADES, Rank.ACE));
        house_hand.addCard(new Card(Suit.CLUBS, Rank.JACK));
        BlackjackHand hand = new BlackjackHand();
        hand.addCard(new Card(Suit.SPADES, Rank.THREE));
        hand.addCard(new Card(Suit.CLUBS, Rank.THREE));
        assertEquals(round.checkForBlackjacks(house_hand, hand), -1);
    }

    @Test
    public void testBlackjack() {
        HouseHand house_hand = new HouseHand();
        house_hand.addCard(new Card(Suit.SPADES, Rank.TWO));
        house_hand.addCard(new Card(Suit.CLUBS, Rank.TWO));
        BlackjackHand hand = new BlackjackHand();
        hand.addCard(new Card(Suit.SPADES, Rank.ACE));
        hand.addCard(new Card(Suit.CLUBS, Rank.JACK));
        assertEquals(round.checkForBlackjacks(house_hand, hand), 1);
    }

    @Test
    public void testDoubleBlackjack() {
        HouseHand house_hand = new HouseHand();
        house_hand.addCard(new Card(Suit.SPADES, Rank.ACE));
        house_hand.addCard(new Card(Suit.CLUBS, Rank.JACK));
        BlackjackHand hand = new BlackjackHand();
        hand.addCard(new Card(Suit.DIAMONDS, Rank.ACE));
        hand.addCard(new Card(Suit.HEARTS, Rank.JACK));
        assertEquals(round.checkForBlackjacks(house_hand, hand), 0);
    }

    @Test
    public void testBust() {
        HouseHand house_hand = new HouseHand();
        house_hand.addCard(new Card(Suit.SPADES, Rank.KING));
        house_hand.addCard(new Card(Suit.CLUBS, Rank.JACK));
        BlackjackHand hand = new BlackjackHand();
        hand.addCard(new Card(Suit.DIAMONDS, Rank.JACK));
        hand.addCard(new Card(Suit.HEARTS, Rank.JACK));
        hand.addCard(new Card(Suit.HEARTS, Rank.FIVE));
        assertEquals(round.evaluateResults(house_hand, hand), -1);
    }

    @Test
    public void testHouseBust() {
        HouseHand house_hand = new HouseHand();
        house_hand.addCard(new Card(Suit.SPADES, Rank.KING));
        house_hand.addCard(new Card(Suit.CLUBS, Rank.JACK));
        house_hand.addCard(new Card(Suit.HEARTS, Rank.FIVE));
        BlackjackHand hand = new BlackjackHand();
        hand.addCard(new Card(Suit.DIAMONDS, Rank.JACK));
        hand.addCard(new Card(Suit.HEARTS, Rank.JACK));
        assertEquals(round.evaluateResults(house_hand, hand), 1);
    }

    @Test
    public void testWin() {
        HouseHand house_hand = new HouseHand();
        house_hand.addCard(new Card(Suit.SPADES, Rank.KING));
        house_hand.addCard(new Card(Suit.HEARTS, Rank.FIVE));
        BlackjackHand hand = new BlackjackHand();
        hand.addCard(new Card(Suit.DIAMONDS, Rank.JACK));
        hand.addCard(new Card(Suit.HEARTS, Rank.JACK));
        assertEquals(round.evaluateResults(house_hand, hand), 1);
    }

    @Test
    public void testHouseWins() {
        HouseHand house_hand = new HouseHand();
        house_hand.addCard(new Card(Suit.SPADES, Rank.KING));
        house_hand.addCard(new Card(Suit.CLUBS, Rank.JACK));
        BlackjackHand hand = new BlackjackHand();
        hand.addCard(new Card(Suit.DIAMONDS, Rank.JACK));
        hand.addCard(new Card(Suit.HEARTS, Rank.FIVE));
        assertEquals(round.evaluateResults(house_hand, hand), -1);
    }

    @Test
    public void testTie() {
        HouseHand house_hand = new HouseHand();
        house_hand.addCard(new Card(Suit.SPADES, Rank.KING));
        house_hand.addCard(new Card(Suit.CLUBS, Rank.JACK));
        BlackjackHand hand = new BlackjackHand();
        hand.addCard(new Card(Suit.DIAMONDS, Rank.JACK));
        hand.addCard(new Card(Suit.HEARTS, Rank.JACK));
        assertEquals(round.evaluateResults(house_hand, hand), 0);
    }
}