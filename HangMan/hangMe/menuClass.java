package hangMe;

import java.util.Scanner;

public class menuClass {

	public static Boolean wishToPlay(Scanner input) {
		System.out.println("Welcome to Hangman!\nPlease type P to play or E to exit"); //Welcome Message
		
		char userInput = input.next().charAt(0); //This is how we get a char from user. 
		
		while(userInput != 'P' && userInput != 'p' && userInput != 'E' && userInput != 'e') {
			System.out.println("Sorry, that was the incorrect input");
			System.out.println("\nPlease press P to play or E to exit");
			userInput = input.next().charAt(0);
		}
		
		if(userInput == 'e' || userInput == 'E') {
			input.close();
			return false; // break out of function
		}		
		System.out.println("Alright, I am thinking of a word! Try to guess it");
		return true;
		
	}
	
	public int endGame(wordClass wordC, Scanner input) {
		System.out.println("\n\nCongratulations! You figured it out!\nYou had: " + wordC.wrongGuesses + " wrong guesses\n\n");
		System.out.println("Would you like to play again? Y/N");
		
		char wishContinue = input.next().charAt(0); //This is how we get a char from user. 
		
		while(wishContinue != 'Y' && wishContinue != 'y' && wishContinue != 'N' && wishContinue != 'n') {
			System.out.println("Sorry, that was the incorrect input");
			System.out.println("\nPlease press Y to play again or N to exit");
			wishContinue = input.next().charAt(0);
		}
		
		if(wishContinue == 'N' || wishContinue == 'n') {
			input.close();
			return 1; // break out of program
		}
		return 0;
	}
	

}
