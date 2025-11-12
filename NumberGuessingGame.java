import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int generatedNumber = random.nextInt(100) + 1; // Random number between 1–100
        int userGuess = 0;
        int attempts = 0;
        int maxAttempts = 10; // optional limit

        System.out.println("🎮 Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100...");
        System.out.println("You have " + maxAttempts + " attempts. Good luck!");

        // Game loop
        while (userGuess != generatedNumber && attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();
            attempts++;

            if (userGuess < generatedNumber) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > generatedNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("🎉 Correct! You guessed the number in " + attempts + " attempts!");
                break;
            }
        }

        // If user didn't guess within max attempts
        if (userGuess != generatedNumber) {
            System.out.println("❌ You've used all your attempts!");
            System.out.println("The correct number was: " + generatedNumber);
        }

        // Calculate and display final score
        int score;
        if (userGuess == generatedNumber) {
            if (attempts <= 3) score = 100;
            else if (attempts <= 6) score = 75;
            else if (attempts <= 10) score = 50;
            else score = 25;
        } else {
            score = 0;
        }

        System.out.println("--------------------------------");
        System.out.println("🎯 Final Score: " + score);
        System.out.println("Total Attempts: " + attempts);
        System.out.println("Thanks for playing!");
        System.out.println("--------------------------------");

        scanner.close();
    }
}
