import java.util.ArrayList;
import java.util.Collections;

public class Play {

    private static final int cardNumericStartValue = 2;
    private static final int cardNumericEndValue = 10;
    private static final int deckStartIndex = 0;
    private static final int deckEndIndex = 51;
    private static final int randomMin = 0;
    private static int randomMax = 51;

    ArrayList<Card> deck = new ArrayList<>(51);

private void initialiseCards(){

    ArrayList<Card> heartCards = new ArrayList<Card>(12);
    ArrayList<Card> spadeCards = new ArrayList<Card>(12);
    ArrayList<Card> diamondCards = new ArrayList<Card>(12);
    ArrayList<Card> clubCards = new ArrayList<Card>(12);

    populateCards("Heart",heartCards);
    deck.addAll(heartCards);

    populateCards("Spade",spadeCards);
    deck.addAll(spadeCards);

    populateCards("Diamond",diamondCards);
    deck.addAll(diamondCards);

    populateCards("Club",clubCards);
    deck.addAll(clubCards);

}

private void populateCards(String suit, ArrayList<Card> cardsList){

    for(int i = cardNumericStartValue; i <= cardNumericEndValue; i++){

        Card c = new Card( suit, Integer.toString(i));
        cardsList.add(c);
    }

    Card king = new Card(suit, "King");
    Card queen = new Card(suit, "Queen");
    Card jack = new Card(suit, "Jack");
    Card ace = new Card(suit, "Ace");

    cardsList.add(king);
    cardsList.add(queen);
    cardsList.add(jack);
    cardsList.add(ace);

}

private void shuffle(){

    Collections.shuffle(deck);

    deck.forEach((card -> System.out.println("Card: "+card.getValue() + " of "+ card.getSuit())));
}

private Card dealOneCard(){

    if(!deck.isEmpty()){

        int random = (int)(Math.random() * ((randomMax - randomMin) + 1)) + randomMin;

        Card removedCard = deck.get(random);

        deck.remove(random);

        randomMax--;

        return removedCard;
    }

    else {
        System.out.println("Deck is empty.. No card to be removed..!!");

        return null;
    }
}

public static void main(String args[]){

    Play play = new Play();

    play.initialiseCards();

    play.shuffle();

    for (int i = deckStartIndex; i <= deckEndIndex; i++){

        Card dealt = play.dealOneCard();

        if(null != dealt){
            System.out.println("Card removed : "+ dealt.getValue()+ " of "+ dealt.getSuit());
        }
    }

    play.dealOneCard(); //Check for the 53rd call

}

}

