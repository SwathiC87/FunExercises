import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Card {
    public String code;

    public String value;

    public  String image;

    public String suit;


}
