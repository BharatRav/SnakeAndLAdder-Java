import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SnakeAndLadderExecution {
    List<Player> players;
    List<Snake> snakes;
    List<Ladder> ladders;

    int boardSize = 100; // if any player goes to 100 then game ends
    boolean stopGame = false;  // false, don't stop the game


    int rollDice() {
        return  new Random().nextInt(6) +1;

//        random object
        // 0 1 2 3 4 5
        // 1 2 3 4 5 6
    }

    public SnakeAndLadderExecution(List<Player> players, List<Snake> snakes, List<Ladder> ladders) {
        this.players = players;
        this.snakes = snakes;
        this.ladders = ladders;
    }

    int getNewPositionWithSnakeAndLadderMoves(Player player, int pos) {
        for (Snake s : snakes) {
            if (s.head == pos) { // come down
                System.out.println(player.name+" bitten by snake" + " at " + s.head + " and dropped at " + s.tail);
                return s.tail;
            }
        }

        for (Ladder l : ladders) {
            if (l.start == pos) {
                System.out.println(player.name+" got a ladder from " + l.start + " to " + l.end);
                return l.end;
            }
        }

        return pos;
    }


    void play() {
        int currentTurn = 0;
        //logic of game
        while (stopGame == false) {
            Player currentPlayer = players.get(currentTurn % players.size());
            int number = rollDice();
            int prevPosition = currentPlayer.position;

            if (currentPlayer.position==0 && number==6) {
                System.out.println(currentPlayer.name + " rolled dice and got " + number + ".\nNow he can move from position 1 ");
                System.out.println(currentPlayer.name+" got another chance");
                currentPlayer.position=1;
                continue;
            } else if (currentPlayer.position==0) {
                System.out.println(currentPlayer.name + " rolled dice and got " + number + ".\n"+currentPlayer.name +" can not start playing at position 0 without 6 \n");
                currentTurn++;
                continue;
            }

            int newPosition = currentPlayer.position + number;


            if (newPosition <= boardSize) {
                System.out.println("\n"+currentPlayer.name + " rolled dice and got " + number + ". He moved from " + prevPosition + " to " + newPosition);

                if (newPosition == boardSize) { // have you reached the end?
                    currentPlayer.position = newPosition;
                    System.out.println("Hurrey! "+currentPlayer.name + " won the game!");
                    stopGame = true;
                } else {
                    currentPlayer.position = getNewPositionWithSnakeAndLadderMoves(currentPlayer, currentPlayer.position + number);
                }
                if (number==6 && !stopGame) {
                    System.out.println(currentPlayer.name+" got another chance");
                    continue;
                }
            }

            currentTurn++;
        }

    }


}
