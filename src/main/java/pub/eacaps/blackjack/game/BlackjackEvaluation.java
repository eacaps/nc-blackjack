package pub.eacaps.blackjack.game;

public class BlackjackEvaluation {
    private boolean over = false;
    private int value;
    private boolean blackjack = false;

    /**
     * Evaluation class for analyzing results
     *
     * @param value     - scored value of the hand
     * @param hand_size - how many cards were used to score
     */
    public BlackjackEvaluation(int value, int hand_size) {
        this.value = value;
        // blackjack is 21 with 2 cards
        if (value == 21) {
            if (hand_size == 2) {
                this.blackjack = true;
            }
        } else if (value > 21) {
            // over 21 is a bust
            this.over = true;
        }
    }

    /**
     * @return boolean for this hand is a blackjack
     */
    public boolean isBlackjack() {
        return this.blackjack;
    }

    /**
     * @return boolean for this hand has busted
     */
    public boolean isOver() {
        return this.over;
    }

    /**
     * @return raw value
     */
    public int getValue() {
        return this.value;
    }
}
