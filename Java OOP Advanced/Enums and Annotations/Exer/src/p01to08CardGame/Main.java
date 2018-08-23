package p01to08CardGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CardDeck cardDeck = generateCardDeck();
        String playerOne = reader.readLine();
        String playerTwo = reader.readLine();
        Set<Card> playerOneSet = new HashSet<>();
        Set<Card> playerTwoSet = new HashSet<>();

        String line;
        populatePlayerDeck(reader, cardDeck, playerOneSet);
        populatePlayerDeck(reader, cardDeck, playerTwoSet);
        String winner = getWinnerWithCardMessage(playerOne, playerOneSet, playerTwo, playerTwoSet);
        System.out.println(winner);
    }

    private static String getWinnerWithCardMessage(String playerOne, Set<Card> playerOneSet,
                                                   String playerTwo, Set<Card> playerTwoSet) {
        Card strongestPlayerOneCard = playerOneSet.stream().min(Comparator.reverseOrder()).get();
        Card strongestPlayerTwoCard = playerTwoSet.stream().min(Comparator.reverseOrder()).get();
        if (strongestPlayerOneCard.compareTo(strongestPlayerTwoCard)>=0){
            return String.format("%s wins with %s of %s.",
                    playerOne,
                    strongestPlayerOneCard.getCardRank().name(),
                    strongestPlayerOneCard.getCardSuit().name());
        } else{
            return String.format("%s wins with %s of %s.",
                    playerTwo,
                    strongestPlayerTwoCard.getCardRank().name(),
                    strongestPlayerTwoCard.getCardSuit().name());
        }
    }

    private static void populatePlayerDeck(BufferedReader reader, CardDeck cardDeck, Set<Card> playerTwoSet) throws IOException {
        String line;
        while (playerTwoSet.size()<5){
            line=reader.readLine();
            String[] tokens = line.split(" of ");
            Card card = null;
            try {
                card = new Card(tokens[1], tokens[0]);
            } catch (IllegalArgumentException e){
                System.out.println("No such card exists.");
                continue;
            }
            if (cardDeck.removeCard(card)){
                playerTwoSet.add(card);
            } else{
                System.out.println("Card is not in the deck.");
            }
        }
    }

    private static void printCardDeck(CardDeck cardDeck) {
        for (Card card:cardDeck.iterable()) {
            System.out.println(String.format("%s of %s", card.getCardRank().name(), card.getCardSuit().name()));
        }
    }

    private static CardDeck generateCardDeck() {
        CardDeck cardDeck = new CardDeck();
        for (CardSuit suit:CardSuit.values()) {
            for (CardRank rank:CardRank.values()) {
                Card card = new Card(suit.name(), rank.name());
                cardDeck.addCard(card);
            }
        }
        return cardDeck;
    }
}
