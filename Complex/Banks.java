import java.util.Scanner;

public class Banks {
	Scanner input = new Scanner(System.in);
	private static double limit;
	private double loan;
	private double NumOfLoans;
	private double initBalance;
	private double balance;
	
	//Return initial balance of bank
	public double initBalance(double initBal) {
		this.initBalance = initBal;
		return initBalance;
	}
	
	//Adds loan to initial balance
	public double newBalance(double a) {
		return this.initBalance += a;
	}
	
	//Checks if bank object is under the limit
	public boolean unsafe() {
		if(balance < limit) {
			return true;
		} else {
			return false;
		}
	}
	
	//number of loans the bank has made
	public int numberOfLoans(int num) {
		return num;
	}
	
	//Returns the amount loaned from another bank object
	public double amountLoaned(double a) {
			System.out.print("Amount loaned: ");
			loan = input.nextDouble();
		return loan;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		//Takes user input and creates array of banks
		Scanner input = new Scanner(System.in);
		System.out.println("Number of Banks: ");
		int count = input.nextInt();
		Banks[] bankNum = new Banks[count];
		for(int i = 0; i < count; i++) {
			bankNum[i] = new Banks();
		
		}
		
		System.out.println("What is the minimum limit: ");
		limit = input.nextInt();
		
		for(int i = 0; i < count; i++) {
			System.out.print("Banks Initial Value: ");
			double initVal = input.nextDouble();
			bankNum[i].initBalance(initVal);
			System.out.println(bankNum[i].initBalance);
		}
		
		System.out.print("Number of loans: ");
		double loanNum = input.nextDouble();
		for(int i = 0; i < loanNum; i++) {
			
		}
				
		
	}//Main

}// Class Banks
