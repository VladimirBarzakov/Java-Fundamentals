package p01to08CardGame;

public class Card implements Comparable<Card>{
    private CardSuit cardSuit;
    private CardRank cardRank;

    public Card(String cardSuit, String cardRank) {
        this.cardSuit = CardSuit.valueOf(CardSuit.class, cardSuit);
        this.cardRank = CardRank.valueOf(CardRank.class, cardRank);
    }

    public CardSuit getCardSuit() {
        return this.cardSuit;
    }

    public CardRank getCardRank() {
        return this.cardRank;
    }

    public int getCardPower(){
        return this.cardSuit.power+this.cardRank.power;
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",
                this.cardRank.name(), this.cardSuit.name(), this.getCardPower());
    }

    @Override
    public int compareTo(Card other) {
        return Integer.compare(this.getCardPower(), other.getCardPower());
    }

    @Override
    public boolean equals(Object card) {
        if (!card.getClass().getSimpleName().equals("Card")){
            return false;
        }
        return this.cardRank==((Card)card).cardRank && this.cardSuit==((Card)card).cardSuit;
    }
}
