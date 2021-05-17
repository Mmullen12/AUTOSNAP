import java.util.ArrayDeque;
import java.util.Deque;

public class main {
    public static void main(String[] args) {

        // Create the players
        Player player1 = new Player("George");
        Player player2 = new Player("Desmond");

        // Create the deck of cards
        Deck deck = new Deck();

        // set the control variable to true
        boolean playing = true;
        // loop until game ends

        // stack to store the played cards
        Deque<String> playedStack = new ArrayDeque<String>(deck.deckSize);

        // player 1 goes first and adds a card to the stack
        // turn card over
        String player1Card = player1.turnCard(deck);
        // push it to top of played stack
        playedStack.push(player1Card);
        // think
        simulateThink(player1.thinkTime());
        // display drawn output
        System.out.println(player1.getName()+" has drawn: "+player1Card);

        // start turn loop with player 2 going next
        String player2Card;
        while (playing) {
            // turn over a card
            player2Card = player2.turnCard(deck);
            // think
            simulateThink(player2.thinkTime());
            // display results
            System.out.println(player2.getName()+" has drawn: "+player2Card);

            // check if it snaps with top of playedStack
            if(checkSnap(player2Card,playedStack.peek())){
                // snap if it returns true
                Snap(player1,player2);
                // set playing to false
                playing = false;
                // break loop to stop player 1 taking a turn after game ends
                break;
            }
            // if no snap, put card on top of stack
            else{
                playedStack.push(player2Card);
            }

            // if deck has been fully drawn
            if(deck.cardStack.isEmpty()){
                // end loop condition
                playing = false;
                // display end message
                System.out.println("DRAW, deck is empty.");
                // break while to stop player1 taking their turn
                break;
            }

            // turn over card
            player1Card = player1.turnCard(deck);
            // think
            simulateThink(player1.thinkTime());
            // display results
            System.out.println(player1.getName()+" has drawn: "+player1Card);

            // check if snap
            if (checkSnap(player1Card, playedStack.peek())) {
                // snap if true
                Snap(player1, player2);
                // close loop clause. No break needed as loop ends here
                playing = false;
            }
            // otherwise push card to top of played stack
            else{
                playedStack.push(player1Card);
            }

            // check if deck is empty
            if(deck.cardStack.isEmpty()){
                // end loop condition
                playing = false;
                // display end message
                System.out.println("DRAW, deck is empty.");
                // no break as it is end of loop
            }
        }
    }

    // Checks if two cards snap
    public static boolean checkSnap(String card,String played){
        // if characters at position 0 are equal
        if(card.charAt(0) == played.charAt(0)){
            // SNAP
            return true;
        }
        // no snap
        return false;
    }

    // calculates who is fastest to SNAP
    public static void Snap(Player player1,Player player2){
        // generate speeds for saying snap
        float p1Speed = player1.thinkTime();
        float p2Speed = player2.thinkTime();
        // stores output for winner
        String winner = "";
        // if player 1 is faster
        if(p1Speed < p2Speed){
            // add their name to winner
            winner += player1.getName();
            // think
            simulateThink(p1Speed);
        }
        // otherwise player 2 wins
        else{
            // add their name to winne
            winner += player2.getName();
            // think
            simulateThink(p2Speed);
        }
        // display winner SNAP
        System.out.println("SNAP! "+winner+" is the winner!");
    }

    // Halts program for thinking time
    public static void simulateThink(float seconds){
        // convert random float think time to integer in milliseconds
        int millisSec = (int)(seconds*1000);
        try {
            // sleep program
            Thread.sleep(millisSec);
        }
        // catch error and interrupt the sleep
        catch(Exception e){
            Thread.currentThread().interrupt();
        }
    }

}
