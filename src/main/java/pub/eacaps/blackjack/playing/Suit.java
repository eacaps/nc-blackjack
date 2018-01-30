package pub.eacaps.blackjack.playing;

public enum Suit {
    CLUBS("C"),
    SPADES("S"),
    DIAMONDS("D"),
    HEARTS("H");

    private String representation;

    private Suit(String representation) {
        this.representation = representation;
    }

    @Override
    public String toString() {
        return this.representation;
    }
}
