package pub.eacaps.blackjack.game;

public class HandEvaluation {
    private boolean over = false;
    private int value;

    public HandEvaluation(int value) {
        this.value = value;
        if(value > 21) {
            this.over = true;
        }
    }

    public boolean isOver() {
        return over;
    }

    public int getValue() {
        return value;
    }
}
