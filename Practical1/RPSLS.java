
import java.util.Scanner;
import java.util.Random;

enum Move {
    ROCK, PAPER, SCISSORS, LIZARD, SPOCK
}

public class RPSLS {

    // Returns 1 if a wins, -1 if b wins, 0 for tie
    static int winner(Move a, Move b) {

        if (a == b) {
            return 0;
        }

        return switch (a) {

            case ROCK ->
                (b == Move.SCISSORS || b == Move.LIZARD) ? 1 : -1;

            case PAPER ->
                (b == Move.ROCK || b == Move.SPOCK) ? 1 : -1;

            case SCISSORS ->
                (b == Move.PAPER || b == Move.LIZARD) ? 1 : -1;

            case LIZARD ->
                (b == Move.PAPER || b == Move.SPOCK) ? 1 : -1;

            case SPOCK ->
                (b == Move.ROCK || b == Move.SCISSORS) ? 1 : -1;
        };
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        Move[] moves = Move.values();

        int playerScore = 0;
        int computerScore = 0;

        for (int round = 1; round <= 5; round++) {

            System.out.println("\nRound " + round);

            System.out.print("Enter move (ROCK, PAPER, SCISSORS, LIZARD, SPOCK): ");
            Move player = Move.valueOf(sc.nextLine().toUpperCase());

            Move computer = moves[random.nextInt(5)];

            System.out.println("Your move: " + player);
            System.out.println("Computer move: " + computer);

            int result = winner(player, computer);

            if (result == 1) {
                System.out.println("You win this round!");
                playerScore++;
            } else if (result == -1) {
                System.out.println("Computer wins this round!");
                computerScore++;
            } else {
                System.out.println("It's a tie!");
            }
        }

        System.out.println("\nFinal Score: You " + playerScore
                + " - " + computerScore + " Computer");

        if (playerScore > computerScore) {
            System.out.println("Overall Winner: You win!");
        } else if (computerScore > playerScore) {
            System.out.println("Overall Winner: Computer wins!");
        } else {
            System.out.println("Overall Winner: It's a tie!");
        }

        sc.close();
    }
}
