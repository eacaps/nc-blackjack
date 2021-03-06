package pub.eacaps.blackjack.playing;

/**
 * ENUM for card Rank, with a value for scoring and a String for display
 */
public enum Rank {
    TWO(2, "2"),
    THREE(3, "3"),
    FOUR(4, "4"),
    FIVE(5, "5"),
    SIX(6, "6"),
    SEVEN(7, "7"),
    EIGHT(8, "8"),
    NINE(9, "9"),
    TEN(10, "T"),
    JACK(10, "J"),
    QUEEN(10, "Q"),
    KING(10, "K"),
    ACE(11, "A");

    private int value;
    private String representation;

    Rank(int value, String representation) {
        this.value = value;
        this.representation = representation;
    }

    public String getRepresentation() {
        return this.representation;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.representation;
    }
}
