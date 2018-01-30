package pub.eacaps.blackjack.game;

import org.junit.Test;

import static org.junit.Assert.*;

public class BlackjackEvaluationTest {
    @Test
    public void testEvaluation() {
        BlackjackEvaluation eval = new BlackjackEvaluation(15, 4);
        assertEquals(eval.isBlackjack(), false);
        assertEquals(eval.isOver(), false);
        assertEquals(eval.getValue(), 15);
    }

    @Test
    public void testBlackjack() {
        BlackjackEvaluation eval = new BlackjackEvaluation(21, 2);
        assertEquals(eval.isBlackjack(), true);
        assertEquals(eval.isOver(), false);
        assertEquals(eval.getValue(), 21);
    }

    @Test
    public void testTwentyone() {
        BlackjackEvaluation eval = new BlackjackEvaluation(21, 3);
        assertEquals(eval.isBlackjack(), false);
        assertEquals(eval.isOver(), false);
        assertEquals(eval.getValue(), 21);
    }

    @Test
    public void testTwentytwo() {
        BlackjackEvaluation eval = new BlackjackEvaluation(22, 3);
        assertEquals(eval.isBlackjack(), false);
        assertEquals(eval.isOver(), true);
        assertEquals(eval.getValue(), 22);
    }
}