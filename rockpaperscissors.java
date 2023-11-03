import java.util.Scanner;
import java.util.Random;

public class rockpaperscissors {
    public static void main(String[] args) {
        // Declare variables of type integer
        int userChoice, computerChoice, rock, paper, scissors, userScore = 0, computerScore = 0,
                drawCount = 0, gameCount = 0;
        boolean playAgain = true;
        // Create input object to get user input
        Scanner input = new Scanner(System.in);
        // Create random input for the computer
        Random rnd = new Random();
        // Assign values to the following variables:
        rock = 0;
        paper = 1;
        scissors = 2;
        // Display the game name and rules
        System.out.println("Welcome to the ROCK - PAPER - SCISSORS GAME!");
        System.out.println("Enter your choice (0 = rock, 1 = paper, 2 = scissors).");
        // Loop for playing multiple games
        while (playAgain) {
            // Increase the game count for each game played
            gameCount++;
            // Get user input
            userChoice = input.nextInt();
            // If user inputs invalid choice, keep asking for valid input
            while (userChoice < 0 || userChoice > 2) {
                System.out.println("Invalid input! Please enter a number between 0 and 2.");
                userChoice = input.nextInt();
            }
            // Display user's choice
            if (userChoice == rock) {
                System.out.println("You chose ROCK.");
            } else if (userChoice == paper) {
                System.out.println("You chose PAPER.");
            } else {
                System.out.println("You chose SCISSORS.");
            }
            // Generate computer's choice
            computerChoice = rnd.nextInt(3);
            // Display computer's choice
            if (computerChoice == rock) {
                System.out.println("The computer chose ROCK.");
            } else if (computerChoice == paper) {
                System.out.println("The computer chose PAPER.");
            } else {
                System.out.println("The computer chose SCISSORS.");
            }
            // Determine winner of the game
            if (userChoice == computerChoice) {
                System.out.println("It's a draw!");
                drawCount++;
            } else if ((userChoice == rock && computerChoice == scissors) ||
                    (userChoice == paper && computerChoice == rock) ||
                    (userChoice == scissors && computerChoice == paper)) {
                System.out.println("You win!");
                userScore++;
            } else {
                System.out.println("The computer wins!");
                computerScore++;
            }
            // Display the scores
            System.out.println("Your score: " + userScore);
            System.out.println("Computer's score: " + computerScore);
            System.out.println("Number of draws: " + drawCount);
            // Ask if user wants to play again
            System.out.println("Do you want to play again? (y/n)");
            String playAgainChoice = input.next();
            // If user wants to play again, reset the scores and play again
            if (playAgainChoice.equalsIgnoreCase("y")) {
                userScore = 0;
                computerScore = 0;
                drawCount = 0;
            } else {
                playAgain = false;
            }
        }
        // Display final results
        System.out.println("Thank you for playing ROCK - PAPER - SCISSORS!");
        System.out.println("You played " + gameCount + " games.");
        System.out.println("Your score: " + userScore);
        System.out.println("Computer's final score: " + computerScore);
        System.out.println("Number of draws: " + drawCount);
        input.close();
    }
}