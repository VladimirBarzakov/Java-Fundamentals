package p01to08CardGame;

import java.util.ArrayList;
import java.util.List;

public class CardDeck{
    private List<Card> cards;

    public CardDeck() {
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card){
        this.cards.add(card);
    }

    public boolean removeCard(Card card){
        for (int i = this.cards.size()-1; i >=0 ; i--) {
            if (this.cards.get(i).equals(card)){
                this.cards.remove(i);
                return true;
            }
        }
        return false;
    }

    public Iterable<Card> iterable(){
        return this.cards;
    }
}
