import java.util.ArrayList;
import java.util.Collections;

public class Play {

    private static final int CARDNUMERICSTARTVALUE = 2;
    private static final int CARDNUMERICENDVALUE = 10;
    private static final int DECKSTARTINDEX = 0;
    private static final int DECKENDINDEX = 51;
    private static final int RANDOMMIN = 0;
    private static int randomMax = 51;

    ArrayList<Card> deck = new ArrayList<>(52);

private void initialiseCards(){

    ArrayList<Card> heartCards = new ArrayList<Card>(13);
    ArrayList<Card> spadeCards = new ArrayList<Card>(13);
    ArrayList<Card> diamondCards = new ArrayList<Card>(13);
    ArrayList<Card> clubCards = new ArrayList<Card>(13);

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

    for(int i = CARDNUMERICSTARTVALUE; i <= CARDNUMERICENDVALUE; i++){

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

        int random = (int)(Math.random() * ((randomMax - RANDOMMIN) + 1)) + RANDOMMIN;

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

    for (int i = DECKSTARTINDEX; i <= DECKENDINDEX; i++){

        Card dealt = play.dealOneCard();

        if(null != dealt){
            System.out.println("Card removed : "+ dealt.getValue()+ " of "+ dealt.getSuit());
        }
    }

    play.dealOneCard(); //Check for the 53rd call

}

}
