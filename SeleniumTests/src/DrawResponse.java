import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DrawResponse {
    public String deck_id;

    public boolean success;

    public List<Card> cards;

}
