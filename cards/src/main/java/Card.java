/**
 * A simple POJO to define cards in deck
 */

public class Card {

    private String suit;
    private String value;

    public Card(String suit, String value){

        this.suit = suit;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
