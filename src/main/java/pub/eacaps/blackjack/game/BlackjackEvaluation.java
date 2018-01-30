package pub.eacaps.blackjack.game;

public class BlackjackEvaluation {
    private boolean over = false;
    private int value;
    private boolean blackjack = false;

    public BlackjackEvaluation(int value, int hand_size) {
        this.value = value;
        if(value == 21) {
            if(hand_size == 2) {
                this.blackjack = true;
            }
        } else if(value > 21) {
            this.over = true;
        }
    }

    public boolean isBlackjack() {
        return this.blackjack;
    }

    public boolean isOver() {
        return this.over;
    }

    public int getValue() {
        return this.value;
    }
}
