import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to SnakeAndLadder Game");
        System.out.println("-------------------------------------");

        //create Players
        List<Player> players = new ArrayList<>();
        System.out.println("How many Players want to Play?");

        int PlayersCount =sc.nextInt();
        System.out.println("Enter the name of players:");

        for (int i=1;i<=PlayersCount;i++) {
            String str =sc.next();
            Player p =new Player(String.valueOf(i),str);
            players.add(p);
        }
//        System.out.println(players.get(1).name);


        //create Snakes
        //total 8 snakes
        List<Snake> snakes = new ArrayList<>();
        snakes.add(new Snake(99, 12));
        snakes.add(new Snake(92,54));
        snakes.add(new Snake(79, 45));
        snakes.add(new Snake(72, 33));
        snakes.add(new Snake(59,19));
        snakes.add(new Snake(31,7));
        snakes.add(new Snake(36,2));
        snakes.add(new Snake(26,10));

        //create Ladders
        //total 5 ladders
        List<Ladder> ladders = new ArrayList<>();
        ladders.add(new Ladder(70,97));
        ladders.add(new Ladder(47,80));
        ladders.add(new Ladder(38,67));
        ladders.add(new Ladder(47,74));
        ladders.add(new Ladder(7,16));

        SnakeAndLadderExecution game = new SnakeAndLadderExecution(players,snakes,ladders);
        game.play();


    }
}
