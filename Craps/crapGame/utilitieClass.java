package crapGame;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class utilitieClass {

//	utilitieClass(){dice1 = 1; dice2 = 2;};

	public int popDice(int diceValue) {
		
		int max = 7, min = 1;
		Random rand=new Random();
		diceValue = rand.nextInt(max - min) + 1;
		return diceValue;
	};
	
	
	public int add(int dice1, int dice2) {
		return dice1 + dice2;
	}

	public int keepItGoing(int total) {
		
		int dice1 = 0;
		int dice2 = 0;
		int ending = 0;
		int newTotal = 0;
		Scanner pressMe = new Scanner(System.in);
		
		
		ArrayList<Integer> tries = new ArrayList<Integer>();
		tries.add(total);
		
		do{
			
		System.out.println("Your number(s) to win: "); //cant use for each loop syntax on StringBuilders apparently 
		System.out.println(tries);
		
		System.out.println("Press Enter to re-roll!");
		pressMe.nextLine();
		dice1 = 0;
		dice2 = 0;
		dice1 = this.popDice(dice1);
		dice2 = this.popDice(dice2);
	
		newTotal = this.add(dice1, dice2);
		
		if(newTotal == 7) {
			System.out.println("Ouch! you rolled a 7");
			return 1;
		}
		
		for(int i = 0; i < tries.size(); i++) {
			
			if(tries.get(i) == newTotal) {
				System.out.println("Aha! you rolled a point number!");
				return 2;
			}
		}
		
		tries.add(newTotal);
		
		}while(ending != 1 || ending != 2);
		
		return ending;
		}
	}
