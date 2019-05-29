package crapGame;

import java.util.Scanner;

public class crapGame {

	public static void main(String[] args) {
		
		int keepGoing = 0;
		menuClass menu = new menuClass();
		utilitieClass crapUtil = new utilitieClass();
		Scanner read1 = new Scanner(System.in);
		
		if(!menuClass.wishToPlay(read1)) {return;}; //break out of program if false
			
		while(keepGoing != 1) {
			int dice1=0;
			int dice2=0;
			int total = 0;
			int ending = 0;
			
			Scanner read2 = new Scanner(System.in);
			System.out.println("Press any key to roll the dice");
			read2.nextLine();
			
			dice1 = crapUtil.popDice(dice1);
			dice2 = crapUtil.popDice(dice2);
			total = crapUtil.add(dice1, dice2);
			
			System.out.println("Die one: " + dice1 + "      Die two: " + dice2 + "          Your total roll is: " + total);
			
			if(total == 2 || total == 3 || total == 12) {
				System.out.println("Craps! sorry, you lose!");
				ending = 1;
			}
			else if(total == 7 || total == 11) {
				System.out.println("Natural! you win!");
				ending = 2;
			}
			else {
				ending = crapUtil.keepItGoing(total);
			}
			
			keepGoing = menu.endGame(read1, ending); 
			
	
		}
	}
}
