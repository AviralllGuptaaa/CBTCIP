import java.util.*;
public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int maxAttempts = 7;
        int attempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a random number between " + lowerBound + " and " + upperBound + ".");
        System.out.println("You have " + maxAttempts + " chances to guess it.");

        int playerGuess;

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            playerGuess = scanner.nextInt();
            attempts++;

            if (playerGuess < lowerBound || playerGuess > upperBound) {
                System.out.println("Please enter a valid number between " + lowerBound + " and " + upperBound + ".");
            } else if (playerGuess < secretNumber) {
                System.out.println("Too low! Try again.");
            } else if (playerGuess > secretNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number " + secretNumber + " in " + attempts + " attempts!");
                break;
            }

            int remainingAttempts = maxAttempts - attempts;
            if (remainingAttempts > 0) {
                System.out.println("You have " + remainingAttempts + " " + (remainingAttempts == 1 ? "chance" : "chances") + " left.");
            } else {
                System.out.println("Out of chances! The correct number was " + secretNumber + ". Better luck next time!");
            }
        }
    }
}
