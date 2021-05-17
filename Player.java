import java.lang.Thread;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

public class Player {
    // name of the player
    private String name;

    // take input for name
    public Player(String name){
        this.name = name;
    }

    // turn over a card and display it. pop it from stack
    public String turnCard(Deck deck){
        float time = this.thinkTime();
        main.simulateThink(time);
        return deck.cardStack.pop();
    }

    // generates random thinking time
    public float thinkTime(){
        // generates a float between 0 and 1.5 seconds for think time
        float seconds = (float)(Math.random()*1.5);
        return seconds;
    }

    // return name of players
    public String getName(){
        return this.name;
    }
}
