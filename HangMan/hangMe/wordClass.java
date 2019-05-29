package hangMe;

import java.util.Random;
import java.util.Scanner;

public class wordClass {

	String words[] = {"apple", "dinosaur", "zebra", "camera", "chair", "banana", "shirt", "guitar", "weather", "purpose", "creator", "rhythm"};
	String hiddenWord;
	char[] hideWord;
	int wrongGuesses; 
    int numberOfLetters;
    StringBuilder sb;
	
	wordClass(){
		Random rand = new Random();
		int randomNumber = rand.nextInt(words.length); // Generates random number that we can use in array
		hiddenWord = new String(words[randomNumber]); // our new string containing random word from our list of words
		hideWord = new char[hiddenWord.length()];    
		wrongGuesses = 0; 
	    numberOfLetters = 0;
	    sb = new StringBuilder();
	}
	
	
	public void hideWord() {
		
		for(int i = 0; i < hiddenWord.length(); i++) { //now we have a hidden word
        	hideWord[i] = '*';
        	System.out.print(hideWord[i]);
        }  
	}
	
	public void guessLetter(Scanner reader) {
	            
				char guess = ' ';
				
				
				System.out.println("   Guess\n" );
	            guess = reader.next().charAt(0);
	        	guess = Character.toLowerCase(guess); // convert uppercase letters to lowercase
	            while(sb.toString().indexOf(guess) != -1) {
	        		System.out.println("You have already guessed that letter! guess again");
	        		guess = reader.next().charAt(0);
	        		guess = Character.toLowerCase(guess);
	        	}
	           	sb.append(Character.toString(guess)); //char to string to be able to be appended to StringBuilder. chars can't be added to SB's so need to cast char to string     
	            
	           int index = hiddenWord.indexOf(guess);
	           if(index == -1) wrongGuesses++;
	           
	           while(index >= 0 ) { //basically if index will represent an index of the array... if indexOf() returns with -1 then it means that char isn't found in the string
	        	   index = hiddenWord.indexOf(guess, index); //gives the position of the char(guess) after the position of index
	        	   		if(index == -1) break;
	        	   hideWord[index] = guess;
	        	   numberOfLetters++;
	        	   index++;
	           } 
	        
	        for(int i = 0; i < hiddenWord.length(); i++) { //now we have a hidden word
	           	System.out.print(hideWord[i]);
	           }
	        
	        }
		
	
	
}
