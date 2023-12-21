import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CardTests {

    WebDriver webDriver;

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public CardTests(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    void runTest() throws IOException {
        DeckOfCards deckOfCards = new DeckOfCards(getWebDriver());
        deckOfCards.navigate();

        Deck shuffledDeck = Utils.shuffleDeck();

        DrawResponse drawResponse = Utils.drawCards(shuffledDeck.deck_id, 6);

        List<Integer> player1Cards = new ArrayList<>();
        List<Integer> player2Cards = new ArrayList<>();


        for (int i = 0; i < 6; i++) {
            int cardValue =  Utils.getCardValue(drawResponse.cards.get(i).value);

            if (i / 2 == 0) {
                player1Cards.add(cardValue);
            } else {
                player2Cards.add(cardValue);
            }
        }

        player1Cards.sort(Comparator.reverseOrder());
        player2Cards.sort(Comparator.reverseOrder());

        int p1Count = player1Cards.get(0) + player1Cards.get(1);
        int p2Count = player2Cards.get(0) + player2Cards.get(1);

        if(p1Count == 21){
            System.out.println("Player 1 has black jack");
        }

        if(p2Count == 21){
            System.out.println("Player 2 has black jack");
        }
    }
}
