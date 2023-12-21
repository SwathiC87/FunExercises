import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Utils {
    public static final String BRAND_NEW_DECK_API = "https://www.deckofcardsapi.com/api/deck/new/";

    public static final String SHUFFLE_NEW_DECK_API = "https://www.deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1";

    public static final String DRAW_CARDS_API = "https://www.deckofcardsapi.com/api/deck/%1$s/draw/?count=%2$s";
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static Deck shuffleDeck() throws IOException {
        URL url = new URL(SHUFFLE_NEW_DECK_API);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        int responseCode = httpURLConnection.getResponseCode();

        System.out.println("HTTP status: " + responseCode);

     return OBJECT_MAPPER.readValue(httpURLConnection.getInputStream(), Deck.class);

    }

    public static DrawResponse drawCards(String decId, int count) throws IOException{
        URL url = new URL(String.format(DRAW_CARDS_API, decId, count));
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        int responseCode = httpURLConnection.getResponseCode();

        System.out.println("HTTP status: " + responseCode);


       return OBJECT_MAPPER.readValue(httpURLConnection.getInputStream(), DrawResponse.class);


    }

    public static int getCardValue(String card) {
        if(card.equals( "JACK") || card.equals("KING") ||
                card.equals( "QUEEN")){
            return 10;
        }
        else if(card.equals( "ACE")) {
            return 11;
        }
        else {
            return Integer.parseInt(card);
        }
    }
}
