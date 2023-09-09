import java.util.Random;
import java.util.Scanner;

public class task1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		int lowRange = 1;
		int highRange = 100;
		int totalAttempts = 5;

		boolean playAgain = true;
		int totalRounds = 0;
		int totalScore = 0;

		while (playAgain) {
			int targetNumber = random.nextInt(highRange - lowRange + 1) + lowRange;
			int attempts = 0;

			System.out.println("Welcome to the Number Guessing Game!");
			System.out.println("I'm thinking of a number between " + lowRange + " and " + highRange);

			while (attempts < totalAttempts) {
				System.out.print("Enter your guess: ");
				int userGuess = scanner.nextInt();
				attempts++;
                if(userGuess > 0 && userGuess <= 100) {
					if (userGuess == targetNumber) {
						System.out.println("Congratulations! You guessed the correct number " + userGuess + " in "
								+ attempts + " attempts.");
						totalScore += totalAttempts - attempts + 1;
						break;
					} else if (userGuess < targetNumber) {
						System.out.println("your guess number is Too low. Try again.");
					} else {
						System.out.println("your guess number is  Too high. Try again.");
					}
					if (attempts == totalAttempts) {
						System.out.println("Sorry! you've reached the maximun number of attempts....");
						System.out.println("The correct number is =  " + targetNumber);
					}
                }else {
                	System.out.println("your guess number are not lie between range. Try again.");
                }
			}

			totalRounds++;

			
			System.out.print("Do you want to play again? (yes/no): ");
			String playAgainInput = scanner.next();
			playAgain = playAgainInput.equalsIgnoreCase("yes");
		}

		System.out.println("Thanks for playing!");
		System.out.println("Total rounds played: " + totalRounds);
		System.out.println("Total score: " + totalScore);

		scanner.close();
	}

}
