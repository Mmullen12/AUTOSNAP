import java.util.*;

public class Deck {
    // Array of every card
    private String[] cards = {"AC", "AD", "AH", "AS", "2C", "2D", "2H", "2S", "3C", "3D", "3H", "3S",
                    "4C","4D","4H","4S","5C","5D","5H","5S","6C","6D","6H","6S","7C","7D","7H","7S",
                    "8C","8D","8H","8H","8S","9C","9D","9H","9S","10C","10D","10H","10S",
                    "JC","JD","JH","JS","QC","QD","QH","QS","KC","KD","KS"};
    // size of deck
    public int deckSize = cards.length;

    // Create empty stack to store the playing deck
    public Deque<String> cardStack = new ArrayDeque<String>(this.deckSize);

    public Deck(){
        // Shuffle deck
        shuffle();
        // push each of the cards onto the stack
        for(String card: cards){
            this.cardStack.push(card);
        }
    }

    public void shuffle(){
        // turn array into a list
        List<String> cardList = Arrays.asList(this.cards);
        // shuffle it using Collections library
        Collections.shuffle(cardList);
        // convert back to array
        this.cards = cardList.toArray(this.cards);
    }
}
