import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class SkockoGame {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random randomNumber = new Random();

		int gamesPlayed = 0;
		int totalPoints = 0;

		// Game loop
		while (true) {
			// Generate a random combination of four characters
			int[] rundomCombination = new int[4];
			for (int i = 0; i < 4; i++) {
				rundomCombination[i] = randomNumber.nextInt(6) + 1;
			}

			// Game attempts loop
			int attempts = 0;
			while (attempts < 7) {
				// Get the user's guess
				System.out.print("Enter your guess (four numbers separated by spaces): ");
				int[] guess = new int[4];
				for (int i = 0; i < 4; i++) {
					guess[i] = input.nextInt();
				}

				// Check the guess
				int numCorrect = 0;
				int numInPosition = 0;
				for (int i = 0; i < 4; i++) {
					if (guess[i] == rundomCombination[i]) {
						numInPosition++;
					}
				}
				ArrayList<Integer> checkedArr = new ArrayList<Integer>();
				for (int i = 0; i < 4; i++) {
					if (!checkedArr.contains(guess[i])) {
						for (int j = 0; j < 4; j++) {
							if (guess[i] == rundomCombination[j]) {
								numCorrect++;
								checkedArr.add(guess[i]);
							}
						}
					}
				}

				// Print the results
				System.out.println("The total number of correctly guessed characters is: " + numCorrect
						+ "\n and of those correctly guessed, the total in the correct place is: " + numInPosition
						+ "\n");

				// Check if the game is won
				if (numInPosition == 4) {
					break;
				}

				attempts++;
			}

			// Print the final result of the game
			System.out.println("The correct combination was: " + rundomCombination[0] + " " + rundomCombination[1] + " "
					+ rundomCombination[2] + " " + rundomCombination[3]);
			int points = 0;
			if (attempts < 6) {
				points = 30;
				System.out.println("You won the game with less then 6 attempts and scored 30 points.");
			}
			if (attempts == 6) {
				points = 20;
				System.out.println("You won the game with 7 attempts and scored 20 points.");
			}
			totalPoints += points;
			gamesPlayed++;

			// Ask the user if they want to play again
			System.out.print("Do you want to play again? (Y/N) ");
			String playAgain = input.next();
			if (playAgain.equalsIgnoreCase("N")) {
				break;
			}
		}

		// Print the total number of games played and points scored
		System.out.println(
				"Thanks for playing! You played " + gamesPlayed + " games and scored " + totalPoints + " points.");
		input.close();
	}
}
