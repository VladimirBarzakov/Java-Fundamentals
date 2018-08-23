import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

public class HandsOfCards {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, HashSet<String>> playerDecks = new LinkedHashMap<>();
        List<String> cardPower = Arrays.asList("2", "3", "4", "5", "6", "7", "8",
                "9", "10", "J", "Q", "K", "A");
        List<String> cardType = Arrays.asList("C", "D", "H","S");

        String line;
        while (!"JOKER".equals(line=reader.readLine())){
            String[] tokens = line.split(": ");
            String player = tokens[0];
            String[] playerCards = tokens[1].split(", ");
            if (!playerDecks.containsKey(player)){
                playerDecks.put(player, new HashSet<>());
            }
            playerDecks.get(player).addAll(Arrays.asList(playerCards));
        }
        for (String player: playerDecks.keySet()) {
            Long playerScore = getPlayerScore(playerDecks.get(player),cardPower, cardType);
            System.out.printf("%s: %s%n",player,playerScore);
        }
    }

    private static Long getPlayerScore(HashSet<String> cards,
                                       List<String> cardPower,
                                       List<String> cardType) {
        Long score =0L;
        for (String card: cards) {
            String playerCardType = card.substring(card.length()-1);
            String playerCardPower = card.substring(0,card.length()-1);
            if (!cardPower.contains(playerCardPower) || !cardType.contains(playerCardType)){
                continue;
            }
            int calculatedPower = (cardPower.indexOf(playerCardPower)+2)
                    * (cardType.indexOf(playerCardType)+1);
            score+=calculatedPower;
        }

        return score;
    }
}
