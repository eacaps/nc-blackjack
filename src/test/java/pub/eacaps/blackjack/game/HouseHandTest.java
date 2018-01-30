package pub.eacaps.blackjack.game;

import org.junit.Test;
import pub.eacaps.blackjack.playing.Card;
import pub.eacaps.blackjack.playing.Rank;
import pub.eacaps.blackjack.playing.Suit;

import static org.junit.Assert.*;

public class HouseHandTest {

    @Test
    public void testToString() {
        HouseHand hand = new HouseHand();
        Card ace_of_hearts = new Card(Suit.HEARTS, Rank.ACE);
        hand.addCard(ace_of_hearts);
        Card two_of_hearts = new Card(Suit.HEARTS, Rank.TWO);
        hand.addCard(two_of_hearts);
        Card three_of_hearts = new Card(Suit.HEARTS, Rank.THREE);
        hand.addCard(three_of_hearts);
        assertEquals("[" + ace_of_hearts + ", [??], [??]]", hand.toString());
    }

    @Test
    public void testToFullString() {
        HouseHand hand = new HouseHand();
        Card ace_of_hearts = new Card(Suit.HEARTS, Rank.ACE);
        hand.addCard(ace_of_hearts);
        Card two_of_hearts = new Card(Suit.HEARTS, Rank.TWO);
        hand.addCard(two_of_hearts);
        Card three_of_hearts = new Card(Suit.HEARTS, Rank.THREE);
        hand.addCard(three_of_hearts);
        assertEquals("[" + ace_of_hearts + ", " + two_of_hearts + ", " + three_of_hearts + "]", hand.toFullString());
    }
}