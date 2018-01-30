package pub.eacaps.blackjack.playing;

import org.junit.Test;

import static org.junit.Assert.*;

public class StandardDeckTest {
    @Test
    public void testDeckGeneration() {
        Deck deck = new StandardDeck();
        assertEquals(deck.cardsRemaining(), 52);
    }
}