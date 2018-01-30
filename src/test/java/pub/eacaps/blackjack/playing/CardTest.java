package pub.eacaps.blackjack.playing;

import org.junit.*;

import static org.junit.Assert.*;

public class CardTest {
    @Test
    public void testToString() {
        Card card = new Card(Suit.CLUBS, Rank.TEN);
        assertEquals(card.toString(), "[TC]");
    }
}
