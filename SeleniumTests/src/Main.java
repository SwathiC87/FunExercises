import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    WebDriver webDriver;

    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/Shared/Swathi/chromedriver-mac-arm64/chromedriver");

        webDriver = new ChromeDriver();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        Main mObj = new Main();
        mObj.setUp();

        //Exercise1
        CheckersPage checkersPage = new CheckersPage(mObj.webDriver);
        checkersPage.navigate();
        checkersPage.makeMoves(5);
        System.out.println("End of exercise1");
        Thread.sleep(5000);

        //Exercise 2
        DeckOfCards deckOfCards = new DeckOfCards(mObj.webDriver);
        deckOfCards.navigate();

        Deck shuffledDeck = Utils.shuffleDeck();

        System.out.println("Shuffled Deck id: " + shuffledDeck.deck_id);

        DrawResponse drawResponse = Utils.drawCards(shuffledDeck.deck_id, 6);

        System.out.println("Draw Response size: " + drawResponse.cards.size());

        List<Integer> player1Cards = new ArrayList<>();
        List<Integer> player2Cards = new ArrayList<>();


        for (int i = 0; i < 6; i++) {
            int cardValue;
            if(drawResponse.cards.get(i).value.equals( "JACK") || drawResponse.cards.get(i).value.equals("KING") ||
                    drawResponse.cards.get(i).value.equals( "QUEEN")){
                cardValue = 10;
            }
            else if(drawResponse.cards.get(i).value.equals( "ACE")) {
                cardValue =11;
            }
            else {
                cardValue = Integer.parseInt(drawResponse.cards.get(i).value);
            }

            if (i / 2 == 0) {
                player1Cards.add(cardValue);
            } else {
                player2Cards.add(cardValue);
            }
        }

        for(int i: player1Cards){
            System.out.println("Player1 card:" + i);
        }

        for(int i: player2Cards){
            System.out.println("Player2 card:" + i);
        }

        player1Cards.sort(Comparator.reverseOrder());
        player2Cards.sort(Comparator.reverseOrder());

        int p1Count = player1Cards.get(0) + player1Cards.get(1);
        int p2Count = player2Cards.get(0) + player2Cards.get(1);

        System.out.println("Player 1 total:" + p1Count);

        System.out.println("Player 2 total:" + p2Count);

        if(p1Count == 21){
            System.out.println("Player 1 has black jack");
        }

        if(p2Count == 21){
            System.out.println("Player 2 has black jack");
        }



    }
}