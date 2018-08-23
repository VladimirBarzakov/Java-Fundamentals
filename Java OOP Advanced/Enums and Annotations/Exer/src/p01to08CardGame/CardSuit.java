package p01to08CardGame;

@CustomAnnotation(category = "Suit", description = "Provides suit constants for a Card class.")
public enum CardSuit {
    CLUBS(0), DIAMONDS(13), HEARTS(26), SPADES(39);

    int power;

    CardSuit(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return String.format("Ordinal value: %d; Name value: %s",this.ordinal(), this.name());
    }
}
